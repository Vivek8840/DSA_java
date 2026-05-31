import java.util.*;
/*
Top K Frequent Elements
Problem Statement

Given an integer array nums and an integer k,
return the k most frequent elements.


Approach: Using map we count the frequency of each element and
 return top k elements having most frequency
 Complexity
 Time Complexity:O(nlogn)
 Space Complexity:O(n);

*/
public class TopKFrequency{
    public static int[] topKFrequent(int nums[],int k){
        int n=nums.length;
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i:nums){
            mp.put(i,mp.getOrDefault(mp,0 )+1);

        }
        List<Map.Entry<Integer,Integer>> li=new ArrayList<>(mp.entrySet());
        Collections.sort(li,(a,b)-> b.getValue()-a.getValue());
        int res[]=new int[k];
        int i=0;
       for(var e:li){
        res[i++]=e.getKey();
        if(i==k)
        break;
       }
       return res;
    }
/*
    Approach2:
    Using priorityqueue , we don't have to sort the map explicitly , 
    priorityqueue itself contains the element in sorted order
*/
public class pair implements Comparable<pair>{
    int val;
    int freq;
   public  pair(int val,int freq){
    this.val=val;
    this.freq=freq;
   }
   public  int compareTo(pair p){
    if(p.freq!=this.freq)
    return this.freq-p.freq;
    else
    return p.val-this.val;

   }
}
public static int[]  topKFrequent2(int nums[],int k){
    Map<Integer,Integer> mp=new HashMap<>();
    for(int i:nums){
        mp.put(i,mp.getOrDefault(i,0)+1);
    }
    PriorityQueue<pair> pq=new PriorityQueue<>();

    for(var e:mp.keySet()){
    pq.add(new pair(e,mp.get(e)));
    if(pq.size()>k){
        pq.remove();
    }
    }
     int res[]=new int[k];
        for(int i=0;i<k;i++){
            pair p=pq.remove();
            res[i]=p.val;
        }
      
       return res;
}
    public static void main(String[] args){
        int nums[]={1,2,1,2,1,2,3,1,3,2};
        int k=2;
        int res[]=topKFrequent2(nums, k);
        for(int i:res){
            System.out.print(i+" ");
        }
    }
}
