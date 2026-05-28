import java.util.*;
/*
Problem : Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:

Input: nums = [1,2,3,1]

Output: true

Explanation:

The element 1 occurs at the indices 0 and 3.
Brute Force: using Nested loops , consider one elemnt at a time and searching where its duplicate present in remaining or not
Optimal Approach :
Using HashSet , adding element to hashset by checking whether its priviously present or not , if present then return false, at last return true.
Complexity:
Time Complexity:O(n)
Space Complexity:O(n)
*/
class solve{
    public boolean check(int nums[]){
        int n=nums.length;
        if(n==1)
        return true;
        Set<Integer> st=new HashSet<>();
        st.add(nums[0]);
        for(int i=1;i<n;i++){
            if(st.contains(nums[i]))
            return false;
            st.add(nums[i]);

        }
        return true;
    }
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println("Contains Dulicate :",check(nums));
    }
}
