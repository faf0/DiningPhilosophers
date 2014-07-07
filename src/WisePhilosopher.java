

/**
 * The wise philosopher picks up the left fork first, if his right neighbor
 * picks up the right fork first.
 * 
 * @author Fabian Foerg
 * 
 */
public final class WisePhilosopher extends StandardPhilosopher {
	/**
	 * Creates a new wise philosopher.
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
	public WisePhilosopher(Fork leftFork, Fork rightFork, long lowThinkTime,
			long highThinkTime, long eatTime, int seat) {
		super(leftFork, rightFork, lowThinkTime, highThinkTime, eatTime, seat);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void eat() {
		try {
			// get forks
			if ((getSeat() % 2) == 0) {
				getLeftFork().take();
				getRightFork().take();
			} else {
				getRightFork().take();
				getLeftFork().take();
			}
			System.out.format("Philosopher %d is eating.\n", getSeat());
			// eat
			Thread.sleep(getEatTime());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// put down forks
		getLeftFork().putDown();
		getRightFork().putDown();
	}
}
