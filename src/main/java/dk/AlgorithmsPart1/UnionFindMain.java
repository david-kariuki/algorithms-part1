/**
 * UnionFindMain class
 *
 * @apiNote This is a class to test and illustrate QuickFind in UnionFind
 * @author David Kariuki
 * @see dk.AlgorithmsPart1.union_find.QuickFindUF#QuickFindUF(int)
 * @see dk.AlgorithmsPart1.union_find.QuickFindUF#connected(int, int)
 * @see dk.AlgorithmsPart1.union_find.QuickFindUF#union(int, int)
 * @since 25/7/2022
 */

package dk.AlgorithmsPart1;

import dk.AlgorithmsPart1.union_find.QuickFindUF;
import dk.AlgorithmsPart1.utilities.algs4.StdIn;
import dk.AlgorithmsPart1.utilities.algs4.StdOut;

public class UnionFindMain {
	public static void main(String[] args) {

		int N = StdIn.readInt();

		QuickFindUF quickFindUF = new QuickFindUF(N); // Initialize N

		// Loop
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();

			// Check if connected
			if (!quickFindUF.connected(p, q)) {
				quickFindUF.union(p, q);
				StdOut.println(p + " " + q);
			}
		}
	}
}