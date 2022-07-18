import java.io.*;
import java.util.*;
 class FloodFill
{
   public static void main (String args[])
   { 
       int image[][]={{1,1,1},{1,1,0},{1,0,1}};
       int sr=1,sc=1,color=2; ;
       
       image =floodFill(image,sr,sc,color);
       
       for(int i=0;i<image.length;i++)
       { for(int j=0;j<image[0].length;j++)
           { System.out.print(image[i][j]);
            }
            System.out.println();
        }
    }
    static int[][] floodFill(int[][] image, int sr, int sc, int color) {
       
        if(image[sr][sc]==color) return image;
      
        int rows=image.length;
        int cols=image[0].length;
                
        int value =image[sr][sc];
                
        fillMatrix(image,sr,sc,value,color);
        
        
        return image;
        
    }
    
    static void fillMatrix(int[][] image, int sr, int sc,int value, int color)
    {   
        int rows=image.length;
        int cols=image[0].length;
        
        if(sr<0||sc<0||sr==rows||sc==cols)
            return;
        
        if(image[sr][sc]!=value)
            return;
        
        image[sr][sc]=color;
        
        fillMatrix(image,sr-1,sc,value,color);
        fillMatrix(image,sr+1,sc,value,color);
        fillMatrix(image,sr,sc-1,value,color);
        fillMatrix(image,sr,sc+1,value,color);
        
    } 
}
