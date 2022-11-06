class Circle extends Shape
{
    @Override
    void scope()
    {
        System.out.println("I am in class Circle");
    }
    void area(int radius)
    {
        System.out.println("Area of Circle "+(Math.PI*radius*radius));
    }
}
