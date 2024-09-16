package medium;

// accepted: 100% time and 33.03% memory

public class q1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int m = queries.length;
        int[] results = new int[m];
        int[] prefix = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            prefix[i] = prefix[i - 1] ^ arr[i - 1];
        }

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];

            results[i] = prefix[query[1] + 1] ^ prefix[query[0]];
        }

        return results;
    }
}
