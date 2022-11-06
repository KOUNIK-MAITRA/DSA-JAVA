 class Car extends Vehicle
{
   String company;
   int maxSpeed;
   Car(String type,int wheels,String medium,String company, int maxSpeed)
   {
       super(type,wheels,medium);
       this.company=company;
       this.maxSpeed=maxSpeed;
   }
   public static void main(String args[])
   {
       Car car1=new Car("car",4,"land","Mahindra",200);
   }
}
