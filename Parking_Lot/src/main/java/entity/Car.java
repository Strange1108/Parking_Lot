package entity;

public class Car 
{
    private String regNo;
    private String color;
    private int slot;

    public Car(String regNo, String color) 
    {
        this.regNo = regNo;
        this.color = color;
    }

    public String getRegNo() 
    {
        return regNo;
    }

    public String getColor() 
    {
        return color;
    }

    public int getSlot() 
    {
        return slot;
    }

    public void setSlot(int slot) 
    {
        this.slot = slot;
    }
}
