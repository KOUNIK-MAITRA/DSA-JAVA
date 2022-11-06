import java.io.*;
import java.util.*;
class GenerateParentheses
{
    static List<String> generateParentheses(int n)
    {
        List<String> ans=new ArrayList<>();
        int open=n;
        int close=n;
        generate(open,close,"",ans);
        return ans;
    }

    static void generate(int open, int close,String output,List<String> ans)
    {
        if(close<open)
        {   return;
        }

        if(open==0 && close==0)
        {
            ans.add(new String(output));
            return;
        }

        if(open>0){
            output+="(";
            generate(open-1,close,output,ans);
            output=output.substring(0,output.length()-1);
        }

        if(close>0){
            output+=")";
            generate(open,close-1,output,ans);
            output=output.substring(0,output.length()-1);
        }
    }

    public static void main(String args[])
    {
        int n=3;
        System.out.println(generateParentheses(n));
    }
}
