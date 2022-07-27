/**
 * QuickFindUF class
 *
 * @apiNote This is a class to illustrate QuickFind in Unionfind
 * @implNote This uses the lazy approach
 * @author David Kariuki
 *
 * <p>
 * @note Data Structure
 * Integer array id[] of length N
 * Interpretation: id[i] is parent of i.
 * Root of i is id[id[id[...id[i]...]]]. - keep going until it does not change (algorithm ensures no cycles)
 * <p>
 * @note Process.
 * Find. Check if p and q have the same root.
 * Union. To merge components containing p and q, set the id of p's root to the id of q's root.
 * <p>
 * @note
 * <p>
 * @note
 * <p>
 * @note
 * @since 27/7/2022
 */

package dk.AlgorithmsPart1.union_find;

public class QuickUnionUF {

	private final int[] id; // Id array

	/**
	 * Default constructor
	 */
	public QuickUnionUF() {
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
	public QuickUnionUF(int N) {

		id = new int[N]; // Initialize id with N

		// Loop to initialize array
		for (int i = 0; i < N; i++) {
			id[i] = i; // Set the id of each object to itself
		}
	}

	/**
	 * Method to get the root
	 * @param i - I
	 * @return int
	 */
	private int root(int i) {

		while (i != id[i]) {
			i = id[i];
		}
		return i;
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
		int pId = id[p]; // Get id at index P
		int qId = id[q]; // Get id at index Q

		// Loop through creating union
		for (int i = 0; i < id.length; i++) {

			// Change all entries with id[p] to id[q]. At most 2N + 2 array accesses
			if (id[i] == pId) {
				id[i] = qId;
			}
		}
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
