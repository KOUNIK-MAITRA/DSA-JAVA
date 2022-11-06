import java.io.*;
import java.util.*;
public class BoxPrice extends BoxWeight
{
    private final int DEFAULT_PRICE=500;
    int price;
    public BoxPrice()
    {
        super();
        this.price=DEFAULT_PRICE;
    }
    public BoxPrice(int size,int weight, int price)
    {
        super(size,weight);
        this.price=price;
    }
    public BoxPrice(int length, int width, int height, int weight, int price)
    {
        super(length,width,height,weight);
        this.price=price;
    }
    public BoxPrice(BoxPrice box)
    {
        super(box.length,box.width,box.height,box.weight);
        this.price=box.price;
    }
    public void BoxDeatils()
    {
        System.out.println("length : "+this.length);
        System.out.println("width : "+this.width);
        System.out.println("height : "+this.height);
        System.out.println("weight : "+this.weight);
        System.out.println("price : "+this.price);
    }
}
