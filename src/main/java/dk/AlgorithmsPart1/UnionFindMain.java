/**
 * UnionFindMain class
 *
 * @apiNote This is a class to test and illustrate QuickFind, QuickUnion in UnionFind
 * @author David Kariuki
 *
 * @note QuickFindUF
 * @see dk.AlgorithmsPart1.union_find.QuickFindUF#QuickFindUF() - Default constructor
 * @see dk.AlgorithmsPart1.union_find.QuickFindUF#QuickFindUF(int) - Parameterized constructor for init
 * @see dk.AlgorithmsPart1.union_find.QuickFindUF#connected(int, int) - Connected
 * @see dk.AlgorithmsPart1.union_find.QuickFindUF#union(int, int) - Union
 * @see dk.AlgorithmsPart1.union_find.QuickFindUF#find(int) - Find
 * @see dk.AlgorithmsPart1.union_find.QuickFindUF#count() - Count
 *
 * @note QuickUnionUF
 * @see dk.AlgorithmsPart1.union_find.QuickUnionUF#QuickUnionUF() - Default constructor
 * @see dk.AlgorithmsPart1.union_find.QuickUnionUF#QuickUnionUF(int) - Parameterized constructor for init
 * @see dk.AlgorithmsPart1.union_find.QuickUnionUF#root - Root
 * @see dk.AlgorithmsPart1.union_find.QuickUnionUF#connected(int, int) - Connected
 * @see dk.AlgorithmsPart1.union_find.QuickUnionUF#union(int, int) - Union
 * @since 25/7/2022
 */

package dk.AlgorithmsPart1;

import dk.AlgorithmsPart1.union_find.QuickFindUF;
import dk.AlgorithmsPart1.union_find.QuickUnionUF;
import dk.AlgorithmsPart1.utilities.algs4.StdIn;

public class UnionFindMain {

	/**
	 * Main method to illustrate UnionFind
	 * @param args - Arguments
	 * @implNote - Call from static reference
	 */
	public static void main(String[] args) {

		System.out.println("Input value N");
		int N = StdIn.readInt();

		QuickFindUF quickFindUF = new QuickFindUF(N); // Initialize QuickFindUf with N
		QuickUnionUF quickUnionUF = new QuickUnionUF(N); // Initialize QuickUnionUf with N

		// Loop
		while (!StdIn.isEmpty()) {

			System.out.println("Input value P");
			int p = StdIn.readInt();
			System.out.println("Input value Q");
			int q = StdIn.readInt();


			/*
			 * This section demonstrates QuickUnionUF
			 */
			// Check if P and Q connected
			if (!quickFindUF.connected(p, q)) {
				quickFindUF.union(p, q); // Connect P and Q
			}


			/*
			 * This section demonstrates QuickUnionUF
			 */
			// Check if the root of P and Q are connected
			if (!quickUnionUF.connected(p, q)) {
				quickUnionUF.union(p, q); // Connect P and Q
			}
		}
	}
}