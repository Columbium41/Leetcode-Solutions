package easy;
import java.util.*;
public class q217 {
        public boolean containsDuplicate(int[] nums) {
            HashSet<Integer> set = new HashSet<>();

            for (int num : nums) {
                if (set.contains(num)) {
                    return true;
                }
                set.add(num);
            }

            return false;
        }
}
