import java.util.*;
class Test
{
    static int totalWays(int n, String str)
    {   ArrayList<Integer> IdxOf1s = new ArrayList<Integer>();
        int cntWays = 1;
        for (int i = 0; i < n; i++)
        {
            if (str.charAt(i) == '1')
            {
                IdxOf1s.add(i);
            }
        }
        int M = IdxOf1s.size();
        if ((M == 1) || ((M % 2) != 0))   
         return 0;
        
        for (int i = 2; i < M; i += 2)
            cntWays = cntWays * (IdxOf1s.get(i) - IdxOf1s.get(i - 1));     
        return cntWays;
    }
    public static void main(String[] args)
    {
        String str = "110011";
        int n = str.length();
        System.out.print(totalWays(n, str));
    }
}

