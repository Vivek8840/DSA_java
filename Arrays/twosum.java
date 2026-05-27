/*
Problem : Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Brute Force: Using nested loop , for every pair -> calculate their sum , if the sum is equal to target then return the index;
Complexity : Time Complexity O(n^2)
            Space complexity O(1)

Optimal Approach : using hashMap -> Store val and idx in map , for every new element check the (target-nums[i]) already present in map or not
if present then return the index of both element;      
Complexity : Time Complexity O(n)
            Space complexity O(n)      
 */
import java.util.*;
class TwoSum{
public int[] twoSum(int[] nums, int target) {
    Map<Integer,Integer> mp=new HashMap<>();
    int ans[]=new int[2];
    for(int i=0;i<nums.length;i++){
        int val=target-nums[i];
        if(mp.containsKey(val)){
                ans[0]=mp.get(val);
                ans[1]=i;
                return ans;

        }
        else{
            mp.put(nums[i],i);
        }

    }
    return ans;
    }
}
