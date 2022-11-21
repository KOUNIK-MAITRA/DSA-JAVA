import java.io.*;
import java.util.*; 
class BitwiseOperators
{
    //check if a number is odd or even using & operator
    static void checkEvenOrOdd(int n){
        // if n&1=1 n is odd
        // if n&1=0 n is even
        if((n&1)==1)
            System.out.println(n+" is Odd");
        else if((n&1)==0)
        System.out.println(n+" is Even");
    }
    public static void main(String args[]){
       checkEvenOrOdd(67);
    }
}
