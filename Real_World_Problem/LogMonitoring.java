import java.util.*;

/*
Problem:
You are building a mini log monitoring system used in large-scale
applications like Google, Amazon, or Netflix servers.

Given an array of log types:

["ERROR", "INFO", "ERROR", "WARNING", "INFO", "ERROR"]

Perform the following operations:

1. Find the most frequent log type.
2. Count total number of ERROR logs.
3. Calculate percentage of ERROR logs.
4. Bonus:
   Sort log types based on frequency in descending order.

--------------------------------------------------

Example:

Input:
["ERROR", "INFO", "ERROR", "WARNING", "INFO", "ERROR"]

Output:
Most Frequent Log Type : ERROR
ERROR Count            : 3
ERROR Percentage       : 50.0%

Sorted Frequency:
ERROR   -> 3
INFO    -> 2
WARNING -> 1

--------------------------------------------------

Brute Force Approach:
For every log entry:
- traverse entire array again
- count frequency manually

Time Complexity: O(n^2)
Space Complexity: O(1)

--------------------------------------------------

Optimal Approach:
Use HashMap for frequency counting.

Steps:
1. Traverse logs array.
2. Store frequency of each log type in HashMap.
3. Track most frequent log.
4. Count ERROR logs separately.
5. Calculate percentage.
6. Sort frequency map entries using custom comparator.

--------------------------------------------------

Complexities:
Time Complexity: O(n log n)
Space Complexity: O(n)

Explanation:
- Frequency counting -> O(n)
- Sorting map entries -> O(n log n)

--------------------------------------------------
*/
class LogMonitoring{
    public static void analyseLog(String []s){
       if(s.length ==0){
        System.out.println("No logs");
       }

        Map<String,Integer> mp=new HashMap<>();
        int errorcount=0;
        for(String str:s){
            mp.put(str,mp.getOrDefault(str,0)+1);
            if(str.isEqulas('ERROR'))
            errorcount++;
        }
        int maxfrq=0;
        String frqlog="";
        for(var k:mp.keySet()){
            if(mp.get(k)>maxfrq){
                maxfrq=mp.get(k);
                frqlog=k;

            }
        }
        double errorpercetage=(double) (errorcount/s.length)*100;
        // sorting the log by frequency
        List<Map.Entry<String,Integer>> li=new ArrayList<>(mp.entrySet());
        Collections.sort(li,(a,b)-> b.getValues()-a.getValues());
         System.out.println("Most Frequent Log Type : "
                + mostFrequentLog);

        System.out.println("ERROR Count            : "
                + errorCount);

        System.out.println("ERROR Percentage       : "
                + errorPercentage + "%");

        System.out.println("\nSorted Frequency:");

        for (Map.Entry<String, Integer> entry : sortedLogs) {

            System.out.println(entry.getKey()
                    + " -> " + entry.getValue());
        }
    

    }
}