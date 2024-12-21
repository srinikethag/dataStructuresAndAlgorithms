package Arrays;

/*
 **** LEETCODE - 303 *****

 Given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

rangeSumQuery(int[] nums) Initializes the object with the integer array nums.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).


Example 1:

Input
["rangeSumQuery", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Explanation
rangeSumQuery rangeSumQuery = new rangeSumQuery([-2, 0, 3, -5, 2, -1]);
rangeSumQuery.sumRange(0, 2); // return (-2) + 0 + 3 = 1
rangeSumQuery.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
rangeSumQuery.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3


Constraints:

1 <= nums.length <= 104
-105 <= nums[i] <= 105
0 <= left <= right < nums.length
At most 104 calls will be made to sumRange.
*/

public class rangeSumQuery {
    public int[] pf;

    // create prefix sum in constructor
    public rangeSumQuery(int[] nums) {
        pf = new int[nums.length];
        pf[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            pf[i] = pf[i-1] + nums[i];
        }
    }

    // use prefix sum to provide the range sum
    public int sumRange(int left, int right) {
        if(left==0) return pf[right];
        return pf[right] - pf[left-1];
    }
}
