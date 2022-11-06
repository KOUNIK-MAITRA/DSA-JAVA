class Triangle extends Shape
{
    @Override
    void scope()
    {
        System.out.println("I am in class Triangle");
    }

    void area(int height,int base)
    {
        System.out.println("Area of Triangle "+(0.5*base*height));
    }
}
