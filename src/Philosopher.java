

/**
 * Interface of a philosopher. They think and eat in a loop.
 * 
 * @author Fabian Foerg
 * 
 */
public interface Philosopher extends Runnable {
	/**
	 * Think and eat in a loop.
	 */
	public void run();

	/**
	 * Think.
	 */
	public void think();

	/**
	 * Grab forks and eat. Put down forks afterwards.
	 */
	public void eat();
}
