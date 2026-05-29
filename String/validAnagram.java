import java.util.*;
/*
Problem StateMent: given Two String s and t,return true if t is an anagram of s,otherwise return false.
An anagram is formed by rearranging the letters of another word using exactly all original characters.
Input :
s="listen"
t="silent"
output :
true

Approach :
create two maps to store each string frequecy , if both maps are equal then it is valid anagram else not valid anagram
Complexity:
Time Complexity: O(n)
Space Complexity: O(n)
*/
class Solve{
    public boolean CheckAnagram(String s,String t){
        int n=s.length();
        int m=t.length();
        if(n!=m)
        return false;
        Map<Charcaters,Integer> mp=new HashMap<>();
        Map<Charcaters,Integer> mn=new HashMap<>();
        for(char c:s.toCharArray()){
            mp.put(c,mp.getOrDefault(c,0)+1);
        }
         for(char c:t.toCharArray()){
            mn.put(c,mn.getOrDefault(c,0)+1);
        }
        if(mp.isEquals(mn))
        return true;
        return false;

    }
    public static void main(String args[]){
        Scanneer sc=new Scanner(System.in);
        String s=sc.nextLine();
        String t=sc.nextLine();
        System.out.println("Both Strings are valid Anagram :",CheckAnagram(s,t));
    }
}