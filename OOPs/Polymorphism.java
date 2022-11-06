class Polymorphism
{
    // THERE ARE TWO TYPES OF POLYMORPHISM : 
    // 1. COMPILE TIME / STATIC POLYMORPHISM - e.g METHOD OVERLOADING
    // 2. RUN TIME / DYNAMIC POLYMORPHISM -e.g METHOD OVERRIDING

    int sum (int a, int b)
    {
        return a+b;
    }

    int sum(int a , int b, int c)
    {
        return a+b+c;
    }

    public static void main(String args[])
    {
        Polymorphism obj=new Polymorphism();
        // compile time polymorphism
        System.out.println(obj.sum(5,4));
        System.out.println(obj.sum(5,4,5));
    }
}
