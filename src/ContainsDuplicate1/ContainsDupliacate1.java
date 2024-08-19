package ContainsDuplicate1;

import java.util.HashSet;

public class ContainsDupliacate1 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
    public static void main(String[] args) {
        ContainsDupliacate1 c = new ContainsDupliacate1();
        int[] nums = {1,2,3,4,5,6,7,8,9};
        System.out.println(c.containsDuplicate(nums));

    }
}
