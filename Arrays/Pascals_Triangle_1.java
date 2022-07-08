// return pascals triangle till N rows as an array lists //

import java.io.*;
import java.util.*;
class Pascals_Triangle_1
{  static List<List<Integer>> pascal(int numRows)
    { List<List<Integer>> res=new ArrayList<List<Integer>>(); // create a list of list of integers
        List<Integer> row,pre=null; // initialize an empty list of rows and the previous row//
        for(int i=0;i<numRows;i++) // loop for n rows
        { row=new ArrayList<Integer>();// make row an empty array list
          for(int j=0;j<=i;j++)// because we know nth rows have nth coloumns
          {if(j==0 ||j==i)
            { row.add(1);
            }
            else 
            { row.add(pre.get(j-1)+pre.get(j));
            }
          }
          pre=row; // make the current row the previous row
          res.add(row); // add the current row to the result
        }
        return res;
        
    }
   static void display(List<Integer> a )
   { for (int i=0;i<a.size();i++)
       { System.out.print(a.get(i)+" ");
        }
    }
    public static void main(String args[])
    { 
        int numRows=5;
        List<List<Integer>> result=pascal(numRows);
        for(int i=0;i<result.size();i++)
        { display(result.get(i));
            System.out.println();
        }
    }
}