import java.util.*;
/*
Product of Array Except Self
Problem Statement

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Input:

nums = [1,2,3,4]

Output:
[24,12,8,6]

Approach:
as mention we can use prefix and suffix product array 
then the sum at any index i
product[i]=prefix[i-1]*suffix[i+1];
Complexity:
TimeComplexity:O(n);
SpaceComplexity :O(n);
*/
public class productArray{
    public static int[] findproduct(int nums[]){
        int n=nums.length;
        int res[]=new int[n];
        // res[i]=prefix[i-1]*suffix[i+1];
        int prefix[]=new int[n];
        int suffix[]=new int[n];

        prefix[0]=nums[0];

        for(int i=1;i<n;i++)
        prefix[i]=nums[i]*prefix[i-1];

        suffix[n-1]=nums[n-1];

        for(int i=n-2;i>=0;i--){
            suffix[i]=nums[i]*suffix[i+1];
        }
        nums[0]=suffix[1];
        nums[n-1]=prefix[n-1];
        for(int i=1;i<n-1;i++){
            nums[i]=prefix[i-1]*suffix[i+1];
        }
        return nums;
    }
    /*
Approach 2:
Instead of creating prefix and suffix array we can use single which represent prefix and suffix
Complexity:
TimeComplexity:O(n);
SpaceComplexity :O(1);
    */
 public static int[] findproduct2(int nums[]){
    int n=nums.length;
    int res[]=new int[n];
    res[0]=1;

 for(int i=1;i<n;i++){
    res[i]=res[i-1]*nums[i-1];
   
 }
int suffix=1;
for(int i=n-1;i>0;i--){
    res[i]*=suffix;
    suffix*=nums[i];
}

return res;
 }
 // OR
  public static int[] findproduct3(int nums[]){
    int n=nums.length;
    int res[]=new int[n];
 int prefix=1;
 for(int i=0;i<n;i++){
    res[i]=prefix*nums[i];
    prefix*=nums[i];
 }
int suffix=1;
for(int i=n-1;i>0;i--){
    res[i]=res[i-1]*suffix;
    suffix*=nums[i];
}
res[0]=suffix;
return res;
 }
 public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int nums[]={1,2,3,4};
    int res[]=findproduct2(nums);
    for(int i:res){
        System.out.print(i+" ");
    }
 }

}