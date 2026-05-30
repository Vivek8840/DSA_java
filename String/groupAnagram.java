import java.util.*;
/*
Problem Statement

Given an array of strings strs, group the anagrams together.

You can return the answer in any order.4
Input:
["eat","tea","tan","ate","nat","bat"]

Output:
[
 ["eat","tea","ate"],
 ["tan","nat"],
 ["bat"]
]
Approach 1:
just like anagram here we consider each string by sorting them so that 
we can get equlas string and then group them
Time Coplexity:O(n*klogk)
SPace Complexity:O(n);

*/
 public class groupAnagram{
    public static List<List<String>> groupAna(String [] strs){

        List<List<String>> ans=new ArrayList<>();

        Map<String,List<String>> mp=new HashMap<>();


        for(String s:strs){

            char[] arr=s.toCharArray();

            Arrays.sort(arr);

            String temp=String.valueOf(arr);

            if(!mp.containsKey(temp))
            mp.put(temp,new ArrayList<>());


            mp.get(temp).add(s);

        }


        for(var k:mp.keySet()){
            ans.add(mp.get(k));

        }

        
        return ans;
    }
    /*
    Approach 2: we can create a hashvalue for every string in given array by counting their frequecy 
    so for everystring s in array , we count their frequency out of 26 letter and then
    generate a hashvalue for string .
    Anagram string have same hashvalue so they can grouped together directly without sorting.
    Complexity:
    Timecoplexiy: O(n*k)
    Sapce Complexity :O(n+26)=O(n)
    */
   static List<List<String>>groupAna2(String[] strs){
    List<List<String>> ans=new ArrayList<>();
    Map<String,List<String>>mp=new HashMap<>();
    for(String s:strs){
        int frq[]=new int[26];

        for(char c:s.toCharArray()){
            frq[c-'a']++;
        }

        StringBuilder sb=new StringBuilder();

        for(int i:frq){
            sb.append(i).append("*");
        }

        String ky=sb.toString();

        if(!mp.containsKey(ky)){
            mp.put(ky,new ArrayList<>());
        }

        mp.get(ky).add(s);
    }


       for(var k:mp.keySet()){
            ans.add(mp.get(k));

        }


        return ans;

   }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String strs[]=new String[n];
        for(int i=0;i<n;i++){
            strs[i]=sc.nextLine();
        }
        System.out.println("GroupedAnagram :");
        System.out.println(groupAna(strs));
    }
}
