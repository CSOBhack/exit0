package cz.csob.rest.apimodel.actions;

public class _embedded
{
    private Actions[] actions;

    public Actions[] getActions ()
    {
        return actions;
    }

    public void setActions (Actions[] actions)
    {
        this.actions = actions;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [actions = "+actions+"]";
    }
}