// only one object can be created for a singleton class
class Singleton
{
  private Singleton()
  {
      
  }
  // create the object/instance 
  // this is the only object/instance that can be created for the Singleton class
  // static is used so everytime an object is created it will get the same object
  // no new object will be created in the memory
  
  private static Singleton obj;
  
  public static  Singleton getObject(){
      // if object is not created the create one and return 
      if(obj==null){
          obj=new Singleton();
      }
      return obj; // if object is alreay created return the object
  }
}
