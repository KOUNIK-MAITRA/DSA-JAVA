// inheritance
import java.io.*;
import java.util.*;
public class BoxWeight extends Box 
{
  int weight;
  private final int DEFAULT_WEIGHT=5;
  public BoxWeight()
  {
      super();
      this.weight=DEFAULT_WEIGHT;
  }
  public BoxWeight(int size, int weight)
  {
      super(size);
      this.weight=weight;
  }
  public BoxWeight(int length, int width, int height, int weight)
  {
      super(length, weight,height);
      this.weight=weight;
  }
  public BoxWeight(BoxWeight box)
  {
      super(box.length,box.width,box.height);
      this.weight=weight;
  }
  public double density()
  {
      return (weight/super.volume());
  }
}
