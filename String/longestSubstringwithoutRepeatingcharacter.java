import java.util.*;
/*
Problem Statement :Given String s , find the length of the longesst substring without repeating character.
Input :
s="abcabcbb"
Output
3
Approach :
We can use sliding window with a map storing freq of element in window 

Complexity:
Time Complexity:O(n)
Space Complexity : O(n)

*/
class Solve{
    public int count(String s){
        int n=s.length();
        if(n<=1)
        return n;
        Map<Characters,Integer> mp=new HashMap<>();
        int l=0;
        int maxlen=0;
        for(int r=0;r<n;r++){
            char c=s.charAt(r);
           
           while(mp.containsKey(c)){
            char d=s.charAt(l);
            int freq=mp.get(d)-1;
            if(freq==0)
            mp.remove(d);
            else
            mp.put(d,freq);
            l++;
           }
           mp.put(c,mp.getOrDefault(c,0)+1);
           int len=r-l+1;
           maxlen=Math.max(maxlen,len);
        }
        return maxlen;
    }
    /*
    Approach2: Instead of mainting window of unique elemnt and count freq of element we can explore last index approach.
    so for character cin string s , we get the last occuring index of c from map and 
    then move l to that index +1 and update our maxlenth
    */
   public int count2(String s){
    Map<Characters,Integer> mp=new HashMap<>();
    int maxlen=0;
    int l=0;
    for(int r=0;r<s.length();r++){
        char c=s.charAt(r);

        if(mp.containsKey(c)){
            l=Math.max(mp.get(c)+1,l)
        }
        mp.put(c,r);
        len=r-l+1;
        maxlen=Math.max(maxlen,len);
        
            }
            return maxlen;
   }
   public static void main(String args[]){
    Scanner sc=new ScanneR(System.in);
    String s=sc.nextLine();
    System.out.println("Length of longest Substring without any repating character is :",count2(s));
   }
}