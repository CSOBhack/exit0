package cz.csob.rest.apimodel.actors;

public class _embedded
{
    private Actors[] actors;

    public Actors[] getActors ()
    {
        return actors;
    }

    public void setActors (Actors[] actors)
    {
        this.actors = actors;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [actors = "+actors+"]";
    }
}
