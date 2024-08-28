package productOfArrayExpectItsSelf;

import java.util.Arrays;

public class product {
    public int[] productExceptSelf(int[] nums) {
        // n is for calculating the length of the array
        int n = nums.length;
        // then they declare an array ans to store the ans
        int ans[] = new int[n];
        // ans[0] = 1
        ans[0] = 1;
        for (int i =1; i<n; i++){
            // In the first loop they store the ans of the prefix
            //ans[1] = ans[0] * nums[0]
            // its mean that they store the ans of only nums[0]
            // then ans[2] = ans[1] * nums[1] that means they store the ans of nums[0] *
            // nums[1]
            // then ans[3] = ans[2] * nums[2]
            // so its mean that they store the ans of nums[0]*nums[1]*nums[2]
            ans[i] = ans[i-1] * nums[i-1];
        }
        // initialize the suffix equal to 1
        int suffixProduct =1 ;
        for(int i = n-1; i>=0; i-- ){
            // first they multifly  suffix = 1 with the ans[3]
            // which store the ans of nums[0]*nums[1]*nums[3]
            // Then it is the ans of multify everything together except nums[3]
            // then they multifly the suffix with with nums[3]
            // Next they multify ans[2] which store the ans of nums[1] and nums[0]
            // then they multify it which the suffixproduct nums[3] so it is the ans of
            // nums[1]* nums[0] * nums[3] except nums[2]
            // then suffix multify with nums[2] so now suffix is the multify with nums[2]
            // and nums[3]
            // next ans[1] is multifly which the suffix with will be the multifly of nums[0]
            // nums[3]*nums[2]
            // next suffix multifly with nums[3] x nums[2] x nums [1]
            // ans[0] multifly with suffix then it return  nums[3] x nums[2] x nums [1]
            ans[i]*=suffixProduct;
            suffixProduct *= nums[i];
        }
        return ans;

    }
    public static void main(String[] args) {
        product p = new product();
        int[] result = p.productExceptSelf(new int[]{1, 2, 3, 4});
        // Print the array contents
        System.out.println(Arrays.toString(result));
    }
}
