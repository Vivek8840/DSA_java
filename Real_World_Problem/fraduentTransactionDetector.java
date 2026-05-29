import java.util.*;
/*
Problem Statement :
You are building a fraud monitoring system for an a=online payment company
given list of transaction records
and a fraud threshold 
return 
user whose trasaction count exceeds threshold
most actice user
total suspicious transaction

Containts
1<=transactions.length<=10^5
Approach:
Maintaining a map of user and their frequency 
*/
public class solve {
    public void  frauddetection(String []transactions,int threshold){
        int n=transactions.length;
        Map<String,Integer> mp=new HashMap<>();
        for(String s:transactions){
            mp.put(s,mp.getOrDefault(s,0)+1);
        }
        List<String> userexceedinglimit=new ArrayList<>();
        String mostactiveuser="";
        int freq=0;
        for(var e:mp.keySet()){
            if(mp.get(e)>threshold)
            userexceedinglimit.add(e);
            if(mp.get(e)>freq){
                freq=mp.get(e);
                mostactiveuser=e;
            }
        }
        System.out.println("User whose transaction count exceeds threshold: ");
        System.out.prinltn(userexceedinglimit);
        System.out.println("\n Most Active User:",mostactiveuser);
        System.out.println("\nToatl suspicious transaction :",userexceedinglimit.size());

    }
}