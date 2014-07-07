

import java.util.Random;

/**
 * The standard philosopher picks up the left fork before it picks up the right
 * fork.
 * 
 * @author Fabian Foerg
 * 
 */
public class StandardPhilosopher implements Philosopher {
	private final Random generator;
	private final Fork leftFork;
	private final Fork rightFork;
	private final long lowThinkTime;
	private final long highThinkTime;
	private final long eatTime;
	private final int seat;

	/**
	 * Creates a new standard philosopher.
	 * 
	 * @param leftFork
	 *            the philosopher's left fork.
	 * @param rightFork
	 *            the philosopher's right fork.
	 * @param lowThinkTime
	 *            the minimum thinking time in milliseconds.
	 * @param highThinkTime
	 *            the maximum thinking time in milliseconds.
	 * @param eatTime
	 *            the eating time in milliseconds.
	 * @param seat
	 *            the seat ID.
	 */
	public StandardPhilosopher(Fork leftFork, Fork rightFork,
			long lowThinkTime, long highThinkTime, long eatTime, int seat) {
		generator = new Random();
		this.leftFork = leftFork;
		this.rightFork = rightFork;
		this.lowThinkTime = lowThinkTime;
		this.highThinkTime = highThinkTime;
		this.eatTime = eatTime;
		this.seat = seat;
	}

	/**
	 * {@inheritDoc}
	 */
	public void run() {
		while (true) {
			think();
			eat();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void eat() {
		try {
			// get forks
			leftFork.take();
			rightFork.take();
			System.out.format("Philosopher %d is eating.\n", seat);
			// eat
			Thread.sleep(eatTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// put down forks
		leftFork.putDown();
		rightFork.putDown();
	}

	/**
	 * {@inheritDoc}
	 */
	public void think() {
		long thinkTime = (long) (generator.nextDouble()
				* (highThinkTime - lowThinkTime) + lowThinkTime);
		System.out.format("Philosopher %d is thinking.\n", seat);
		try {
			Thread.sleep(thinkTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the left fork, but does not put it down.
	 * 
	 * @return the left fork.
	 */
	public Fork getLeftFork() {
		return leftFork;
	}

	/**
	 * Returns the right fork, but does not put it down.
	 * 
	 * @return the right fork.
	 */
	public Fork getRightFork() {
		return rightFork;
	}

	/**
	 * Returns the seat ID.
	 * 
	 * @return the seat ID.
	 */
	public int getSeat() {
		return seat;
	}

	/**
	 * Returns the eating time in milliseconds.
	 * 
	 * @return the eating time in milliseconds.
	 */
	public long getEatTime() {
		return eatTime;
	}
}
