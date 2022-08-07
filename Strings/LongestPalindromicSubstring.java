 class LongestPalindromicSubstring
{
   public static void main(String args[]){
       String s="babad";
       System.out.println(longestPalindrome(s));
    }
   static String longestPalindrome(String s) {
        int maxLength=0;
        String palindrome="";
        
        for(int i=0;i<s.length();i++){
            //odd length
            int left=i;
            int right=i;
            
            while(left>=0 && right<=s.length()-1 && s.charAt(left)==s.charAt(right))
            {
                int lengthOfCurrPalindrome=right-left+1;
                if(lengthOfCurrPalindrome>maxLength){
                    maxLength=lengthOfCurrPalindrome;
                    palindrome=s.substring(left,right+1);
                }
                left--;
                right++;
            }
            
            //even length
            left=i;
            right=i+1;
            while(left>=0 && right<=s.length()-1 && s.charAt(left)==s.charAt(right))
            {
                int lengthOfCurrPalindrome=right-left+1;
                if(lengthOfCurrPalindrome>maxLength){
                    maxLength=lengthOfCurrPalindrome;
                    palindrome=s.substring(left,right+1);
                }
                left--;
                right++;
            }
        }
        
        return palindrome;
    } 
}
