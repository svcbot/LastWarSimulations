package dev.svcbot;

import lombok.extern.java.Log;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log
abstract public class Simulation<T extends StrategyResult> {
    protected final int repeats;
    protected final Supplier<? extends Strategy<T>> strategySupplier;
    protected final List<T> results = new ArrayList<>();
    protected final ExecutorService executorService = Executors.newFixedThreadPool(6);

    public Simulation(int repeats, Supplier<? extends Strategy<T>> supplier) {
        this.repeats = repeats;
        this.strategySupplier = supplier;
    }

    public void simulate() {

        sampleStrategyResults();

        evaluateStrategyResults();

    }

    public void sampleStrategyResults() {
        System.out.printf("Starting %d simulations of %s%n", repeats, strategySupplier.get().getClass().getSimpleName());
        System.out.printf("Strategy description: %s%n", strategySupplier.get().description);

        executorService.submit(strategySupplier.get());
        List<? extends Strategy<T>> todo = IntStream.range(0, repeats).boxed().map(i -> strategySupplier.get()).toList();

        try {
            List<Future<T>> futures = executorService.invokeAll(todo);

            executorService.shutdown();
            executorService.awaitTermination(10, TimeUnit.SECONDS);

            futures.forEach(integerFuture -> {
                try {
                    results.add(integerFuture.get());
                } catch (InterruptedException | ExecutionException e) {
                    log.warning("Future was incomplete: " + e.getLocalizedMessage());
                }
            });
        } catch (InterruptedException e) {
            log.warning("Executor service interrupted");
        }
    }

    abstract void evaluateStrategyResults();

}
