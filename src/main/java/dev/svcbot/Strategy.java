package dev.svcbot;

import java.security.SecureRandom;
import java.util.concurrent.Callable;

abstract public class Strategy<T extends StrategyResult> implements Callable<T> {

    public SecureRandom random = new SecureRandom();
    public String description;
    public T result;

    abstract public T call();
}
