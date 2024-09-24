package medium;

import java.util.*;

public class q241 {
    // brackets go around an operator and the left and right numbers
    //

    public List<Integer> diffWaysToCompute(String expression) {
        String[] split = expression.split("(?=[+\\-*])|(?<=[+\\-*])");
        LinkedList<Integer>[][] memo = new LinkedList[split.length][split.length];
        return recurse(split, 0, split.length - 1, memo);
    }

    public LinkedList<Integer> recurse(String[] expressions, int l, int r, LinkedList<Integer>[][] memo) {
        if (l == r && !expressions[l].equals("+") && !expressions[l].equals("-") && !expressions[l].equals("*")) {
            LinkedList<Integer> li = new LinkedList<>();
            li.add(Integer.parseInt(expressions[l]));
            return li;
        }

        if (memo[l][r] != null) {
            System.out.println("memoized");
            return memo[l][r];
        }

        LinkedList<Integer> ans = new LinkedList<>();

        for (int i = l; i <= r; i++) {
            String exp = expressions[i];
            if (exp.equals("+") || exp.equals("-") || exp.equals("*")) {
                LinkedList<Integer> left = recurse(expressions, l, i - 1, memo);
                LinkedList<Integer> right = recurse(expressions, i + 1, r, memo);
                for (int n1 : left)
                    for (int n2 : right) {
                        if (exp.equals("+"))
                            ans.addLast(n1 + n2);
                        else if (exp.equals("-"))
                            ans.addLast(n1 - n2);
                        else
                            ans.addLast(n1 * n2);
                    }
            }
        }

        memo[l][r] = ans;
        return ans;
    }

    public static void main(String[] args) {
        q241 instance = new q241();
        //System.out.println(instance.diffWaysToCompute("2*3-4*5-5*12+46-17"));
    }
}
