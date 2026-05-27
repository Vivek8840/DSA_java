import java.util.*;

/*
Problem:
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
...

Brute Force:
...

Optimal Approach:
Use a Stack to store opening brackets.

For every closing bracket:
- check whether stack is empty
- verify top element matches corresponding opening bracket

If mismatch occurs:
return false

At the end:
if stack becomes empty -> valid
otherwise invalid.
...

Complexities:
Time complexity : O(n)
Space Complexity :O(n)
...
*/

class ValidParenthesis{
 public boolean isValid(String sr) {
        
        if(sr.length()==1)
        return false;

        Stack<Character> s=new Stack<>();
        for(int i=0; i<sr.length();i++){
            char c=sr.charAt(i);
            if(c=='{'||c=='['||c=='('){
                s.push(c);
            }
            else{
                if(s.isEmpty())
                return false;
                if(c=='}' && s.peek()=='{')
                s.pop();
                else if(c==']' && s.peek()=='[')
                s.pop();
                else if(c==')' && s.peek()=='(')
                s.pop();
                else
                return false;
            }
        }
      return s.isEmpty();
    }
}
