package ContainsDuplicate2;

import java.util.HashSet;

public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hi = new HashSet<>();
        for(int i =0; i<nums.length; i++){
            if(hi.contains(nums[i])){
                return true;
            }

            hi.add(nums[i]);

            if(hi.size()>k){
                hi.remove(nums[i-k]);
            }}
        return false;
    }
    public static void main(String[] args) {
        ContainsDuplicate2 c = new ContainsDuplicate2();
        System.out.println(c.containsNearbyDuplicate(new int[]{1,2,3,1}, 2));
    }
}
