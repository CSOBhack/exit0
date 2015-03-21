package cz.csob.rest.apimodel.actorsimplified;

public class Self
{
    private String templated;

    private String method;

    private String href;

    public String getTemplated ()
    {
        return templated;
    }

    public void setTemplated (String templated)
    {
        this.templated = templated;
    }

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
        return "ClassPojo [templated = "+templated+", method = "+method+", href = "+href+"]";
    }
}