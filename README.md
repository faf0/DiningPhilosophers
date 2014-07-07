# About

Simulation of the dining philosophers problem.

In the problem, `k` philosophers sit around a round table with `k` forks.
The philosophers either think or eat.
When a philosopher thinks, he leaves the forks located to the left and right to
him on the table.
Whenever a philosopher wants to eat, he picks up the left and the right
fork from the table, provided that no other philosopher is using them.
This situation can lead to a deadlock when all philosophers hold one fork from
the same direction (left or right) at the same time using naive synchronization.
As a result, all philosophers starve, since they need both forks to eat.

This program implements the situation described above.
In addition to these `standard philosophers`, it implements `wise philosophers`
whose behavior cannot lead to a deadlock.
A wise philosopher picks up the forks in a different order than his neighbors.
If the neighbors of a philosopher pick up the left fork first, the wise philosopher
will pick up the right fork first and vice versa.

This is my solution of an assignment in the course
[CS511](https://web.stevens.edu/compsci/graduate/masters/courses/viewer.php?course=CS511&type=syl) (Concurrent Programming) at Stevens Institute of
Technology in the Fall of 2012.

# Usage

The constant `WISE PHILOSOPHER` in `DiningPhilosophers.java` allows to switch
between wise and standard philosophers.

Create a JAR archive and start the simulation with the command

    java -jar WiseDiningPhilosophers.jar k l h e

where
* `k` denotes the number of philosophers
* `l` is the minimum thinking time of a philosopher in milliseconds.
* `h` is the maximum thinking time of a philosopher in milliseconds.
  The thinking time is chosen uniformly at random out of the
  interval [`l`, `h`].
* `e` is the eating time in milliseconds.

# Copyright

(Copyright) 2012 Fabian Foerg

