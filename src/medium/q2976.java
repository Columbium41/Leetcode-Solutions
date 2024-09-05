package medium;

import utils.Edge;

import java.util.*;

// accepted: 5.95% time and 5.51% memory

public class q2976 {
    // idea: find and memoize the cost of converting each individual character to the target character
    // and sum up the costs

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long totalCost = 0;
        int n = source.length();
        HashMap<String, Integer> memo = new HashMap<>();

        // construct graph from arrays
        HashMap<Character, ArrayList<Edge<Character, Integer>>> graph = new HashMap<>();
        for (int i = 0; i < cost.length; i++) {
            char s = original[i];
            char d = changed[i];
            int w = cost[i];

            if (!graph.containsKey(s)) {
                graph.put(s, new ArrayList<Edge<Character, Integer>>());
            }

            graph.get(s).add(new Edge(d, w));
        }

//        for (Map.Entry<Character, ArrayList<Edge>> entry : graph.entrySet()) {
//            System.out.println(entry.getKey() + " - " + entry.getValue());
//        }

        // calculate costs for converting each character
        for (int i = 0; i < n; i++) {
            char originalChar = source.charAt(i);
            char targetChar = target.charAt(i);

            if (originalChar == targetChar)
                continue;

            String memoKey = originalChar + "," + targetChar;
            if (memo.containsKey(memoKey)) {
                totalCost += memo.get(memoKey);
                continue;
            }

            // run dijkstra's with memoization
            int distance = dijkstra(graph, originalChar, targetChar, memo);
            if (distance == -1)
                return -1;

            //System.out.println(distance);
            totalCost += distance;
        }

        return totalCost;
    }

    public int dijkstra(HashMap<Character, ArrayList<Edge<Character, Integer>>> graph, char s, char d, HashMap<String, Integer> memo) {
        PriorityQueue<Edge<Character, Integer>> pq = new PriorityQueue<>();
        HashMap<Character, Integer> distances = new HashMap<>();

        pq.add(new Edge<Character, Integer>(s, 0));
        distances.put(s, 0);

        while (!pq.isEmpty()) {
            Edge<Character, Integer> curr = pq.poll();
            int currDistance = distances.get(curr.d);

            if (!graph.containsKey(curr.d)) {
                continue;
            }

            for (Edge<Character, Integer> e : graph.get(curr.d)) {
                char node = e.d;
                int w = e.w;

                if (!distances.containsKey(node) || currDistance + w < distances.get(node)) {
                    distances.put(node, currDistance + w);
                    pq.add(new Edge(node, currDistance + w));
                }
            }
        }

        for (Map.Entry<Character, Integer> entry : distances.entrySet()) {
            memo.put(s + "," + entry.getKey(), entry.getValue());
        }

        if (distances.containsKey(d)) {
            return distances.get(d);
        }
        return -1;
    }
}