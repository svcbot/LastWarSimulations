# Golden zombies 

This package contains simulation related to the `golden zombies` event.

In order to simulate golden zombies following facts are needed:

* Killing a golden zombie costs `10 energy`. The reward is always `10 medals` and `268k gold`
* After killing a golden zombie there is a `10 % chance to spawn a boss` zombie. Boss level is random, but seems to depend on HQ and combat power.
* If your boss is killed, there is a guarantied intel reward of `190 + boss level * 2 medals` and `0.5M + boss level / 100 M gold`. E.g. lvl 100 boss will produce 390 medals and 1.5 M gold.
* Killing a boss as a rally initiator always gives `80 medals` and `0.5M + boss level / 100 M gold`.
* Boss kill assist always gives `40 medals` and `0.332 M + boss level / 5 * 0.03 gold`.

# Simulation results

```log
Task :dev.svcbot.Main.main()
Starting energy of each simulation: 1000
Starting 1000 simulations of AttackOwnBossesStrategy
Strategy description: Always kill your own boss after it is spawned.
Average medals: 5471,88
Average gold 54,44 M 
Average bosses summoned: 10,05 
Average bosses slayed: 10,05
Simulation of AttackOwnBossesStrategy is complete

Starting 1000 simulations of AssistOwnBossStrategy
Strategy description: Always assist to kill your own boss.
Average medals: 6312,59
Average gold 61,40 M 
Average bosses summoned: 12,51 
Average bosses slayed: 0,00
Simulation of AssistOwnBossStrategy is complete

Starting 1000 simulations of IgnoreOwnBossStrategy
Strategy description: Kill golden zombies, but ignore all spawned bosses. Goal is to spawn as may as possible. 
0 assists. Not a viable strategy, since you want to assist as much as possible, but it represents a good baseline to compare to.
Average medals: 5828,95
Average gold 50,77 M 
Average bosses summoned: 12,55 
Average bosses slayed: 0,00
Simulation of IgnoreOwnBossStrategy is complete

Starting 1000 simulations of AttackBossesExclusivelyStrategy
Strategy description: Spend all the energy to attack golden bosses exclusively
Average medals: 4000,00
Average gold 68,76 M 
Average bosses summoned: 0,00 
Average bosses slayed: 50,00
Simulation of AttackBossesExclusivelyStrategy is complete

Starting 1000 simulations of Perform20RandomAssistsStrategy
Strategy description: Assist 20 random bosses. No golden zombies kills, no own boss kills.
Average medals: 800,00
Average gold 17,14 M 
Average bosses summoned: 0,00 
Average bosses slayed: 0,00
Simulation of Perform20RandomAssistsStrategy is complete
```
