/**
 * QuickFindUF class
 *
 * @apiNote This is a class to demonstrate how the UnionFind can be improved using weighting, path compression
 * @implNote This uses the lazy approach
 * @author David Kariuki
 * @note Data structure. Same as quick-union, but maintain extra array sz[i] (size)
 * to count number of objects in the tree rooted at i
 *
 * <p>
 * @implNote Improvement 1: Weighting (Weighted quick-union analysis)
 * <p>
 * @note Process
 * Find - Identical to quick-union
 * Union - Modify quick-union to link root of smaller tree to root of larger tree and update the sz[] array
 * <p>
 * @note Running time.
 * Find - takes time proportional to depth of p and q.
 * Union - takes constant time, given roots.
 * Proposition. Depth of any node x is at most lg N. (lg = base-2 logarithm)
 * Pf - When does depth of x increase?
 * Increases by 1 when tree T1 containing x is merged into another tree T2. The size of the tree containing x at
 * least doubles since | T 2 | ≥ | T 1 |. Size of tree containing x can double at most lg N times. The union includes
 * cost of finding roots
 *
 * <p>
 * @implNote Improvement 2: Path Compression
 * Quick union with path compression. Just after computing the root of p, set the id of each examined node to point
 * to that root.
 *
 * <p>
 * @implNote Weighted quick-union with path compression: amortized analysis
 * Proposition. [Hopcroft-Ulman, Tarjan] Starting from an empty data structure, any sequence of M union-find ops
 * on N objects makes ≤ c ( N + M lg* N ) array accesses. Analysis can be improved to N + M α(M, N).
 * <p>
 * Linear-time algorithm for M union-find ops on N objects?
 * Cost within constant factor of reading in the data. In theory, WQUPC is not quite linear
 * In practice, WQUPC is linear.
 * <p>
 * @note
 * @see dk.AlgorithmsPart1.UnionFindMain#main(java.lang.String[])
 * @since 28/7/2022
 */
package dk.AlgorithmsPart1.union_find;

public class WeightedQuickUnion {


	private final int[] id; // Id array

	/**
	 * Default constructor
	 */
	public WeightedQuickUnion() {
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
	public WeightedQuickUnion(int n) {

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
		while (i != id[i]) {
			id[i] = id[id[i]]; // Only one extra line of code !
			i = id[i];
		}
		return i;
	}
}
