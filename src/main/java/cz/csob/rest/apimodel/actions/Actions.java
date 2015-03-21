package cz.csob.rest.apimodel.actions;

public class Actions
{
    private String id;

    private String price;

    private String name;

    private String power;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getPrice ()
    {
        return price;
    }

    public void setPrice (String price)
    {
        this.price = price;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getPower ()
    {
        return power;
    }

    public void setPower (String power)
    {
        this.power = power;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", price = "+price+", name = "+name+", power = "+power+"]";
    }
}