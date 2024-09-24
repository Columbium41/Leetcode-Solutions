package medium;

import java.util.*;

// time: O(n^2)
// space: O(n)

public class q443 {
    public int minMutation(String startGene, String endGene, String[] bank) {
        int numMutations = 0;

        LinkedList<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.addLast(startGene);
        visited.add(startGene);

        while (!queue.isEmpty()) {
            int currentSize = queue.size();

            for (int i = 0; i < currentSize; i++) {
                String currentGene = queue.removeFirst();

                if (currentGene.equals(endGene)) {
                    return numMutations;
                }

                for (String gene : bank) {
                    if (visited.contains(gene))
                        continue;

                    int diffCount = 0;

                    for (int j = 0; j < 8; j++) {
                        if (gene.charAt(j) != currentGene.charAt(j))
                            diffCount++;
                    }

                    if (diffCount == 1) {
                        queue.addLast(gene);
                        visited.add(gene);
                    }
                }
            }

            numMutations++;
        }

        return -1;
    }
}
