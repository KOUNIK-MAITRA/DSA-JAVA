// POLYMORPHISM
class ShapeMain
{
    public static void main(String args[])
    {
        Shape shape=new Shape();
        Square square=new Square();
        Circle circle=new Circle();
        Triangle triangle=new Triangle();
        
        shape.scope();
        square.scope();
        circle.scope();
        triangle.scope();
        
      
        square.area(5);
        circle.area(5);
        triangle.area(5,10);
    }
}
