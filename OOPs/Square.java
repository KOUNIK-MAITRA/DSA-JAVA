class Square extends Shape
{
    @Override
    void scope()
    {
        System.out.println("I am in class Square");
    }
    void area(int side)
    {
        System.out.println("Area of Square "+(side*side));
    }
}
