// row wise sorted col wise sorted and first element of every row is greater than the last element in the prev row//
// leetcode prblm//

 class Search_2D_Matrix_I
{ 
   static boolean searchElement(int [][]matrix, int target)
   { if(matrix.length==0||matrix==null)
       return false;
      // we will consider the matrix as an single sorted array and apply binary search // 
      
       int n=matrix.length; // no.of rows
       int m=matrix[0].length; // no.of cols
       
       int low =0; // low index for binary search 
       int high= (n*m)-1; // high index for binary search 
       
       while (low<=high)
       { int mid=(low+high)/2; //  in case of overflow use mid=(low+(high-low))/2
           int curr_ele=matrix[mid/m][mid%m]; // gives the curr element from the matirx corresponding to the mid index of the imaginary single sorted array
          if(target==curr_ele)
          return true;
          
          if(target>curr_ele)
          low=mid+1;
          else 
          high=mid-1;
        }
        return false ; 
    }
   
   public static void main(String args[])
   { int matrix[][]={ {1, 3,  5, 7},
                      {10,11,16,20},
                      {23,30,34,50}
                       };
     System.out.println(searchElement(matrix,70));
     }   
}
