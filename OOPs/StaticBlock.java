public class StaticBlock
{
    static int a=5;
    static int b;

    //static block : used to initialize static variables
    // runs only once when the first object is created
    //i.e when the class is loaded for the first time
    static{
        System.out.println("I am in static block");
        b=4*a;
    }
    public static void main(String args[])
    {
        StaticBlock obj1=new StaticBlock();
        System.out.println(obj1.b);
        b+=3;
        StaticBlock obj2=new StaticBlock();
        System.out.println(obj2.b);
    }
}
