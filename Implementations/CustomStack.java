import java.io.*;
import java.util.*;
public class CustomStack
{
  protected int[]data;
  private static final int DEFAULT_SIZE=10;
  int ptr=-1;
  
  public CustomStack()//when size is not provided
  {
      this(DEFAULT_SIZE);
  }
  public CustomStack(int size)//when size is provided
  {
    this.data=new int[size];  
  }
  public boolean isFull()
  {
      return ptr==data.length-1;
  }
  public boolean isEmpty()
  {
      return ptr==-1;
  }
  public boolean push(int item) throws StackException
  {
      if(isFull())
      {
          throw new StackException("Stack is full");
      }
      ptr++;
      data[ptr]=item;
      return true;
  }
  public int pop() throws StackException
  {
      if(isEmpty())
      {
          throw new StackException("Cannot pop from an empty stack");
      }
      return data[ptr--];
  }
  public int peek()throws StackException
  {
      if(isEmpty())
      {
          throw new StackException("Stack is currently empty");
      }
      return data[ptr];
  }
}