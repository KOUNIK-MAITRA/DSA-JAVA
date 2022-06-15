import java.io.*;
import java.util.*;
 class LongestCommonSubsequence_SpaceOptimized
{
  public static void main(String args[])
  {  String a="ABCABEFTR";
      String b="AECBE";
      int m=a.length();
      int n=b.length();
      
      System.out.println("Length of Longest Common Subsequence is "+ LCS(m,n,a,b));
    }
  public static void ArrayCopy(int[]a,int[]b)
   { for(int i=0;i<a.length;i++)
       { a[i]=b[i];
        }
    }
  public static int LCS(int m, int n,String a, String b)
  {
      int []row1=new int[m+1];
      int []row2=new int[m+1];
      
      Arrays.fill(row1,0);
   
      
      for(int i=0;i<n;i++)
      { int x=1;
        row2[0]=0;  
          for (int j=0;j<m;j++)
          { if(b.charAt(i)==a.charAt(j))
              { row2[x]=1+row1[x-1];
                  x++;
                }
                else
             { row2[x]=Math.max(row2[x-1],row1[x]);
                 x++;
            }
            }
            ArrayCopy(row1,row2);
          
        }
              return row2[row2.length-1];
       }
}
