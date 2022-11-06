class Boat extends Vehicle
{
    String company;
    int maxSpeed;
    Boat(String type,int wheels,String medium,String company, int maxSpeed)
    {
        super(type,wheels,medium);
        this.company=company;
        this.maxSpeed=maxSpeed;
    }

    public static void main(String args[])
    {
        Boat boat=new Boat("boat",0,"water","Kingfisher",100);
    }
}
