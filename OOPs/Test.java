public class Test //outside class cannot be static
{   
    // inner classes may or maynot be static
    class TestA
    {
        String name;
        TestA(String name)
        {
            this.name=name;
        }
    }

    static class TestB
    {
        String name;
        TestB(String name)
        {
            this.name=name;
        }
    }
    public static void main(String args[])
    {
        // TestA is non-static i.e it is dependant on class Test 
        // TestA a=new TestA("Kounik"); 
        TestB b= new TestB("Rahul");
    }
}
