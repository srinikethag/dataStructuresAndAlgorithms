package Arrays;

/*
 **** LEETCODE - 1664 *****

You are given an integer array nums. You can choose exactly one index (0-indexed) and remove the element. Notice that the index of the elements may change after the removal.

For example, if nums = [6,1,7,4,1]:

Choosing to remove index 1 results in nums = [6,7,4,1].
Choosing to remove index 2 results in nums = [6,1,4,1].
Choosing to remove index 4 results in nums = [6,1,7,4].
An array is fair if the sum of the odd-indexed values equals the sum of the even-indexed values.

Return the number of indices that you could choose such that after the removal, nums is fair.



Example 1:

Input: nums = [2,1,6,4]
Output: 1
Explanation:
Remove index 0: [1,6,4] -> Even sum: 1 + 4 = 5. Odd sum: 6. Not fair.
Remove index 1: [2,6,4] -> Even sum: 2 + 4 = 6. Odd sum: 6. Fair.
Remove index 2: [2,1,4] -> Even sum: 2 + 4 = 6. Odd sum: 1. Not fair.
Remove index 3: [2,1,6] -> Even sum: 2 + 6 = 8. Odd sum: 1. Not fair.
There is 1 index that you can remove to make nums fair.
Example 2:

Input: nums = [1,1,1]
Output: 3
Explanation: You can remove any index and the remaining array is fair.
Example 3:

Input: nums = [1,2,3]
Output: 0
Explanation: You cannot make a fair array after removing any index.
 */


public class waysToMakeFairArray {
    public int waysToMakeFair(int[] nums) {
        int count = 0;

        int[] cumArrEven = new int[nums.length];
        cumArrEven[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(i%2==0) cumArrEven[i] =cumArrEven[i-1]+nums[i];
            else cumArrEven[i]=cumArrEven[i-1];

        }

        int[] cumArrOdd = new int[nums.length];
        cumArrOdd[0] = 0;
        for(int i=1; i<nums.length; i++) {
            if(i%2==1) cumArrOdd[i] =cumArrOdd[i-1]+nums[i];
            else cumArrOdd[i]=cumArrOdd[i-1];

        }
        for (int i=0; i<nums.length; i++) {
            // check if ith element is special or not
            int index1 = 0;
            int index2 = i-1;
            int index3 = i+1;
            int index4 = nums.length-1;
            int sumOdd = sumOfElementsReturn(cumArrOdd, index1,index2) +  sumOfElementsReturn(cumArrEven, index3,index4);
            int sumEven = sumOfElementsReturn(cumArrEven, index1,index2) +  sumOfElementsReturn(cumArrOdd, index3,index4);

            if (sumOdd == sumEven) count++;
        }
        return count;
    }

    public static int sumOfElementsReturn(int[] cumArr, int L, int R) {


        if (R < L) return 0;
        else if (L==0) return cumArr[R];
        else return (cumArr[R]-cumArr[L-1]);

    }

}
