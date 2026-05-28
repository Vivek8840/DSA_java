import java.util.*;
/*
Problem Statement:
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

approach :
we can apply a simple formula for each element 
gain=prices[i]-minimumprice(before i)
maxprofit=max(gain,maxprofit)
that is minimum price will store the value of lowest cost before or at the same day 

Coplexity:
Time Complexity:O(n);
Space Coplexity: O(1)


*/
class Solve{
public int maxProfit(int [] prices){
    int maxprofit=0;
    int minimumPrice=Integer.MAX_VALUE;
    for(int i:prices){
        minimumPrice=Math.min(minimumPrice,i);
        int profit=i=minimumPrice
        maxprofit=Math.max(maxprofit,profit);

    }
    return maxprofit;
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