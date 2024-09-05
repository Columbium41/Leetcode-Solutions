package medium;

import java.util.*;
import utils.Edge;

// accepted: 79.11% time and 75.44% memory

public class q1514 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<Edge<Integer, Double>>[] adjList = (ArrayList<Edge<Integer, Double>>[]) new ArrayList[n];

        for (int i = 0; i < n; i++)
            adjList[i] = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            double succ = succProb[i];
            adjList[edge[0]].add(new Edge<Integer, Double>(edge[1], succ));
            adjList[edge[1]].add(new Edge<Integer, Double>(edge[0], succ));
        }

//        for (ArrayList<Edge<Integer, Double>> a : adjList)
//            System.out.println(a);

        PriorityQueue<Edge<Integer, Double>> pq = new PriorityQueue<>((a, b) -> Double.compare(b.w, a.w));
        double[] d = new double[n];
        d[start_node] = 1.0;
        pq.add(new Edge<Integer, Double>(start_node, 1.0));

        while (!pq.isEmpty()) {
            Edge<Integer, Double> curr = pq.poll();

            if (curr.d == end_node)
                return curr.w;

            for (Edge<Integer, Double> neighbor : adjList[curr.d]) {
                double newWeight = curr.w * neighbor.w;
                if (newWeight > d[neighbor.d]) {
                    d[neighbor.d] = newWeight;
                    pq.add(new Edge<Integer, Double>(neighbor.d, curr.w * neighbor.w));
                }
            }
        }

        return 0d;
    }

    public static void main(String[] args) {
        q1514 instance = new q1514();
        System.out.println(instance.maxProbability(
                3,
                new int[][]{new int[] {0, 1}, new int[] {1, 2}, new int[] {0, 2}},
                new double[]{0.5, 0.5, 0.2},
                0,
                2
        ));
    }
}
