package cz.csob.rest.model.node;

public class Self
{
    private String method;

    private String href;

    public String getMethod ()
    {
        return method;
    }

    public void setMethod (String method)
    {
        this.method = method;
    }

    public String getHref ()
    {
        return href;
    }

    public void setHref (String href)
    {
        this.href = href;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [method = "+method+", href = "+href+"]";
    }
}