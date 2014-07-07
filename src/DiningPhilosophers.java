

/**
 * Implementation of the dining philosopher scenario. There are two kinds of
 * philosophers: the standard and the wise philosophers. A standard philosopher
 * picks up the left fork before he picks up the right fork. A wise philosopher
 * picks up the left fork first, if his right neighbor picks up the right fork
 * first. If his right neighbor picks up the left fork first, the wise
 * philosopher will pick up the right fork first.
 * 
 * @author Fabian Foerg
 * 
 */
public final class DiningPhilosophers {
	private static final boolean WISE_PHILOSOPHER = false;

	/**
	 * Commence dinner.
	 * 
	 * @param args
	 *            ignored.
	 */
	public static void main(String[] args) {
		if (args.length != 4) {
			usage();
			return;
		}

		// parse command-line arguments
		int k;
		long l, h, e;

		try {
			k = Integer.parseInt(args[0]);
			l = Long.parseLong(args[1]);
			h = Long.parseLong(args[2]);
			e = Long.parseLong(args[3]);
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
			usage();
			return;
		}

		// create philosophers and forks
		Philosopher[] philosophers = new StandardPhilosopher[k];
		Thread[] philosopherThreads = new Thread[k];
		Fork[] forks = new Fork[k];

		for (int i = 0; i < k; i++) {
			forks[i] = new Fork();
		}

		for (int i = 0; i < k; i++) {
			if (WISE_PHILOSOPHER) {
				philosophers[i] = new WisePhilosopher(forks[i], forks[(i + 1)
						% k], l, h, e, i);
			} else {
				philosophers[i] = new StandardPhilosopher(forks[i],
						forks[(i + 1) % k], l, h, e, i);
			}
			philosopherThreads[i] = new Thread(philosophers[i]);
			philosopherThreads[i].start();
		}

		for (Thread philosopher : philosopherThreads) {
			try {
				philosopher.join();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * Print usage message.
	 */
	private static void usage() {
		System.out.println("Usage: DiningPhilosophers <k> <l> <h> <e>");
	}
}
