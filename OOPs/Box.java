import java.io.*;
import java.util.*;
public class Box
{
  private final int DEFAULT_SIZE=10;  
  public int length;
  public int width;
  public int height;
  
  // CONSTRUCTOR OVERLOADING
  public Box()
  {
     this.length=this.width=this.height=DEFAULT_SIZE;
  }
  public Box(int size)
  {
      this.length=size;
      this.width=size;
      this.height=size;
  }
  public Box(int length, int width, int height)
  {
      this.length=length;
      this.width=width;
      this.height=height;
  }
  public Box(Box box) //COPY CONSTRUCTOR
  {
      this.length=box.length;
      this.width=box.width;
      this.height=box.height;
  }
  public int area()
  {
      return (length*width);
  }
  public int volume()
  {
      return length*width*height;
  }
}
