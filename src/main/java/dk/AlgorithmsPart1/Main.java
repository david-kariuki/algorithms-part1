package dk.AlgorithmsPart1;


import dk.AlgorithmsPart1.utilities.algs4.StdIn;
import dk.AlgorithmsPart1.utilities.algs4.StdOut;

public class Main {
	public static void main(String[] args) {

		int N = StdIn.readInt();

		UnionFind unionFind = new UnionFind(N);

		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();

			if (!unionFind.connected(p, q)) {
				unionFind.union(p, q);
				StdOut.println(p + " " + q);
			}
		}


	}
}