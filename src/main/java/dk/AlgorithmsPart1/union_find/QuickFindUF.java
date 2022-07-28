/**
 * QuickFindUF class
 *
 * @apiNote This is a class to illustrate Unionfind
 * @implNote This uses the eager approach
 * @author David Kariuki
 *
 * <p>
 * @note Data structure.
 * Integer array id[] of length N.
 * Interpretation: p and q are connected iff they have the same id.
 * <p>
 * @note Process.
 * Find - Check if p and q have the same id.
 * Union. To merge components containing p and q, change all entries whose id equals id[p] to id[q].
 * <p>
 * @note Speed.
 * Union find is too slow and too expensive
 * It takes N Squared array accesses to process a sequence of N union commands on N objects
 * Quadratic algorithms do not scale. They also don't scale with technology
 * <p>
 * @note Rough standard (for now).
 * 10^9 operations per second, 10^9 words of main memory.
 * Touch all words in approximately 1 second.
 * <p>
 * @note Huge problem for quick-find.
 * 109 union commands on 109 objects.
 * Quick-find takes more than 1018 operations.
 * 30+ years of computer time!
 * <p>
 * @note Quadratic algorithms don't scale with technology.
 * New computer may be 10x as fast, But, has 10x as much memory ⇒
 * Case: You want to solve a problem that is 10x as big. With quadratic algorithm, this takes 10x as long!
 * @see dk.AlgorithmsPart1.UnionFindMain#main(java.lang.String[])
 * @since 25/7/2022
 */

package dk.AlgorithmsPart1.union_find;

public class QuickFindUF {

	private final int[] id; // Id array

	/**
	 * Default constructor
	 */
	public QuickFindUF() {
		id = new int[0]; // Initialize id with 0
	}

	/**
	 * Class constructor
	 *
	 * <p>
	 *
	 * @apiNote Initialize union-find data structure with n objects (0 to N - 1)
	 * @apiNote (N array accesses)
	 */
	public QuickFindUF(int n) {

		id = new int[n]; // Initialize id with N

		// Loop to initialize array
		for (int i = 0; i < n; i++) {
			id[i] = i; // Set the id of each object to itself
		}
	}

	/**
	 * Method to check whether P and Q are in the same component
	 *
	 * @param p - P
	 * @param q - Q
	 * @return boolean
	 *
	 * <p>
	 * @apiNote - Are P and Q in the same component (2 array accesses)
	 */
	public boolean connected(final int p, final int q) {
		return (id[p] == id[q]); // Compare for connection
	}

	/**
	 * Method to find union find
	 *
	 * @param p - P
	 * @param q - Q
	 * @apiNote add connection between P and Q
	 * @apiNote At most 2N + 2 array accesses
	 */
	public void union(final int p, final int q) {

		System.out.println("Connecting P and Q" + p + " " + q);

		int pId = id[p]; // Get id at index P
		int qId = id[q]; // Get id at index Q

		// Loop through creating union
		for (int i = 0; i < id.length; i++) {

			// Change all entries with id[p] to id[q]. At most 2N + 2 array accesses
			if (id[i] == pId) {
				id[i] = qId;
			}
		}

		System.out.println("P Q " + p + " " + q);
	}

	/**
	 * Method to check if connected
	 *
	 * @param p - P
	 * @return int
	 * @apiNote Component identifier for P (o to N - 1)
	 */
	int find(int p) {
		return 0;
	}

	/**
	 * Method to count number of components
	 *
	 * @return int
	 * @apiNote - Number of components
	 */
	public int count() {
		return id.length; // Return length
	}
}
