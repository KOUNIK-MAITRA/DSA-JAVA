import java.io.*;
import java.util.*;
class Search_in_a_2D_Matrix
{
   public static void main (String args[]){
    int [][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}}; 
    int target = 3;
    System.out.println(searchMatrix(matrix,target));
    }
     static boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix.length==0||matrix==null)
            return false;
        
        int n=matrix.length;
        int m=matrix[0].length;
        
        int low=0;
        int high=(n*m)-1;
        
        while (low<=high)
        {
            int mid=(low+high)/2;
            
            if(matrix[mid/m][mid%m]==target)
                return true;
            
            if(matrix[mid/m][mid%m]<target)
                low=mid+1;
            else 
                high=mid-1;
        }
        return false;
        
    }
}
