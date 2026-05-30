import java.util.*;
/*
Given an integer array nums, find the subarray with the largest sum, and return its sum.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Approach :
Brute force: we can consider all possible subarray and find their sum and find max sum out of that;
Complexity:
Time complexity:O(n^2)
Space complexity: O(1);
*/


public class maximumsumSubarray{
public static int findmaxsum(int[] nums){
    int n=nums.length;
    int ans=nums[0];
    for(int i=0;i<n-1;i++){
    int sum=nums[i];
    for(int j=i+1;j<n;j++){
        sum+=nums[j];
        ans=Math.max(ans,sum);
    }

    }
    return ans;
}
/*
Approach 2: Kadane Algorithm 
at every step we choose wheter to consider previous sum or start new
Coplexity:
Time Complexity: O(n)
Space Complexity:O(1);

*/
publci static int findmaxsum2(int[] nums){
    int ans=nums[0];
    int sum=0;
    for(int i=0;i<n;i++){
        sum+i;
        ans=Math.max(sum,ans);
        sum=Math.max(sum,0);

    }
    return ans;
}

}