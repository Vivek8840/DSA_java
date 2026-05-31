import java.util.*;
/*
Problem:
Design a mini URL Shortener Service similar to
Bitly or TinyURL.

Features:
1. Convert long URL -> short URL
2. Retrieve original URL
3. Track visit counts

--------------------------------------------------
Functional Requirements:
- shortenURL(String longURL)
- getOriginalURL(String shortURL)
- getVisitCount(String shortURL)

--------------------------------------------------
Data Structures Used:
1. HashMap
   shortURL -> originalURL

2. HashMap
   shortURL -> visitCount

--------------------------------------------------
Complexities:
shortenURL()      -> O(1)
getOriginalURL()  -> O(1)
getVisitCount()   -> O(1)
*/
public class URLShortener{
   private Map<String,String> urlmap;
   private Map<String,Integer> visited;
   private static final String VALUES=
   "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
   private Random random;

   
   public  URLShortener(){
      urlmap=new HashMap<>();
      visited=new HashMap<>();
      random = new Random();

   }


   private String generateShortCode(){
      StringBuilder sb=new StringBuilder();
      for(int i=0;i<6;i++){
         int idx=random.nextInt(VALUES.length());
         sb.append(VALUES.charAt(idx));
      }
      return sb.toString();
   }
  public String shortenURL(String longurl){
      String shortcode=generateShortCode();
      while(urlmap.containsKey(shortcode)){
         shortcode=generateShortCode();

      }
      urlmap.put(shortcode,longurl);
      visited.put(shortcode,0);
      return "short.ly/" + shortcode;
   }
public String getOriginalURL(String shortURL) {

      String shortcode=shortURL.substring(shortURL.lastIndexOf('/') +1);
      if(!urlmap.containsKey(shortcode))
      return "URL not found";

      visited.put(shortcode,visited.get(shortcode)+1);
      return urlmap.get(shortcode);

}
public int getVisitedCount(String shorturl){
   String shortcode=shorturl.substring(shorturl.lastIndexOf('/') + 1);
   return visited.getOrDefault(shortcode,0);
}
 public static void main(String[] args) {

        URLShortner service =new URLShortner();
                

        // Shorten URL
        String shortURL =
                service.shortenURL(
                        "https://www.google.com"
                );

        System.out.println("Short URL: " + shortURL);

        // Retrieve original URL
        String original =
                service.getOriginalURL(shortURL);

        System.out.println("Original URL: " + original);

        // Visit count
        int visits =
                service.getVisitedCount(shortURL);

        System.out.println("Visit Count: " + visits);
    }
 }