public class Factors
{
  public static void main(String args[])
  {
      int n=20;
      factors(n);
  }
  static void factors(int n)
  {
      for(int i=1;i*i<=n;i++)
      {
          if(n%i==0){
           if(n/i==i) 
           System.out.println(i);
          else
          {
              System.out.println(i);
              System.out.println(n/i);
          }
          }
      }
  }
}
