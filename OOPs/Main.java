 class Main
{
   public static void main(String args[])
   {
       // Singleton obj= new Singleton(); --> this is not possible since the constructor 
       //                                     is declared private in Singleton class
                                          
       //to create an object we need to do it through the getObject() method
       // and every time the same object will be returned as it i declared static
       Singleton obj1=Singleton.getObject();
       Singleton obj2=Singleton.getObject();
       Singleton obj3=Singleton.getObject();
   }
}
