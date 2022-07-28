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
 * @note Speed
 * Quick-union is also too slow
 * Cost model - Number of array accesses (for read or write).
 * @note Quick-find defect
 * Union is too expensive (N array accesses), Trees are flat, but too expensive to keep them flat.
 * <p>
 * @note Quick-union defect.
 * Trees can get tall.
 * Find too expensive (could be N array accesses).
 * <p>
 * @see dk.AlgorithmsPart1.UnionFindMain#main(java.lang.String[])
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
	 * @note Initialize union-find data structure with n objects (0 to N - 1)
	 * (N array accesses)
	 */
	public QuickUnionUF(int n) {

		id = new int[n]; // Initialize id with N

		// Loop to initialize array
		for (int i = 0; i < n; i++) {
			id[i] = i; // Set the id of each object to itself
		}
	}

	/**
	 * Method to get the root
	 *
	 * @param i - I
	 * @return int
	 *
	 * <p>
	 * @note Chase parent pointers until it reaches the root (depth of i array accesses)
	 */
	private int root(int i) {

		// Chase parent pointers until it reaches the root (depth of i array accesses)
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
	 * @note - Check if p and q have same root (depth of p and q array accesses)
	 */
	public boolean connected(final int p, final int q) {
		return (root(p) == root(q)); // Check if p and q have same root (depth of p and q array accesses)

	}

	/**
	 * Method to find union find
	 *
	 * @param p - P
	 * @param q - Q
	 *
	 * <p>
	 * @note add connection between P and Q
	 * @note At most 2N + 2 array accesses
	 */
	public void union(final int p, final int q) {

		System.out.println("Connecting P and Q" + p + " " + q);

		// Change root of p to point to root of q (depth of p and q array accesses)
		int i = root(p); // Get root of p
		int j = root(q); // Get root of q
		id[i] = j; // Set id to root of q

		System.out.println("P Q " + p + " " + q);
	}
}
