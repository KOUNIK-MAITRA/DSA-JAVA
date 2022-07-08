
// row wise sorted col wise sorted//
// GFG prblm//

 class Search_2D_Matrix_II
{
    
  static boolean searchElement(int [][]matrix, int target )
    { // start from the last element of the first row
      // all elements to the left of the element are less than the curr element
      // all elements below the current element are greater then the curr element 
      // move accordingly 
      int rows =matrix.length;
      int cols=matrix[0].length;
      int i=0;
      int j=cols-1;
      
      while (i<rows && j>=0)
      { if(matrix[i][j]==target)
          return true;
          
         if(matrix[i][j]<target)
          i++;
          else 
          j--;
        }
        return false;
    }
    
  public static void main(String args[])
  { int matrix[][] ={
                     {10,20,30,40},
                     {15,25,35,45},
                     {27,29,37,48},
                     {32,33,39,50}
                    };
                    
      System.out.println(searchElement(matrix,48));
    }
}
