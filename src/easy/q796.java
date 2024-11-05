package easy;

public class q796 {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length())
            return false;

        StringBuilder str = new StringBuilder();
        str.append(s).append(s);

        return str.toString().contains(goal);
    }
}
