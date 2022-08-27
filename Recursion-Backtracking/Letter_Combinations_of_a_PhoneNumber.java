import java.io.*;
import java.util.*;
 class Letter_Combinations_of_a_PhoneNumber
{
   public static void main(String args[]){
       String digits="23";
       System.out.println(letterCombinations(digits));
   }
   static List<String> letterCombinations(String digits) {
        
       if(digits=="" || digits.length()==0) 
        return new ArrayList<String>();
        
       //             0  1    2     3     4    5      6     7      8     9            
       String[] keys={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"}; // similar to mobile keypad
       List<String> ans= new ArrayList<>();
       String res="";
       combinations(0,digits,keys,ans,res);
       return ans; 
    }
    
   static void combinations (int index, String digits, String[]keys,List<String> ans,String res){
        
        if(index==digits.length())// if we have reached the end of digits then we have a possible ans
        {
            ans.add(new String(res));
            return;
        }
        
        int currDigit=digits.charAt(index)-'0'; // find the digit in int
        // iterate over the chars mapped to this digit in the keypad i.e the keys string array
        for(int i=0;i<keys[currDigit].length();i++){
            char ch=keys[currDigit].charAt(i);
            res+=ch;// add these letters to the res one at a time
            combinations(index+1,digits,keys,ans,res);// call the recursive function for the next digit
            res=res.substring(0,res.length()-1);// remove the last character while backtracking
        }
    }
}
