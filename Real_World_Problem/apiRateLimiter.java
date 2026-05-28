import java.util.*;
/*
Problem:You are building a backend service like:

Google API
Stripe
Twitter/X
Swiggy
Zomato

To prevent server overload, users can only make limited requests.
Problem

Given an array representing user API requests:

["user1", "user2", "user1", "user3", "user1", "user2"]

And a request limit:

limit = 2

Return users who exceeded the request limit.

Expected Output
[user1]
Approach: we make a hashmap which store frequency of each user request and then return a list 
of user who exceed the limit
Complexity:
Time Coplexity:O(n)
Space Coplexity:O(n)
*/
class Solve{
    public List<String> findUser(String[] request, int limit){
        Map<String,Integer> mp=new HashSet<>();
        List<String> ans=new ArrayList<>();

        for(String s:request){
            mp.put(s,mp.getOrDefault(s,0)+1);
           

        }
        for(var s:mp.keySet()){
            if(mp.get(s)>limit)
            ans.add(s);
        }
        return ans;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int limit=sc.nextInt()
        sc.nextLine();
        String[] request=new String[n];
        for(int i=0;i<n;i++){
            request[i]=sc.nextLine();
        }
        System.out.println("User Exceeding request Limit: ",findUser(request,limit));
    }
}