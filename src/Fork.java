

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Represents a fork in the dining philosophers scenario.
 * 
 * @author Fabian Foerg
 * 
 */
public final class Fork {
	private final BlockingQueue<Integer> fork;

	/**
	 * Creates a new fork.
	 */
	public Fork() {
		fork = new LinkedBlockingQueue<Integer>();
		putDown();
	}

	/**
	 * Take the fork.
	 * 
	 * @throws InterruptedException
	 *             when a philosopher who is waiting for a fork is interrupted.
	 */
	public void take() throws InterruptedException {
		fork.take();
	}

	/**
	 * Put down the fork, i.e. make it available to other philosophers.
	 */
	public void putDown() {
		fork.add(0);
	}
}
