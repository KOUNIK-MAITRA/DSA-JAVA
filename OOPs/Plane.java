class Plane extends Vehicle
{
    String company;
    int maxSpeed;
    Plane(String type,int wheels,String medium,String company, int maxSpeed)
    {
        super(type,wheels,medium);
        this.company=company;
        this.maxSpeed=maxSpeed;
    }

    public static void main(String args[])
    {
        Plane plane=new Plane("plane",0,"air","Indigo",800);
    }
}
