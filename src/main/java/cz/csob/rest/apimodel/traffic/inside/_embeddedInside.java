package cz.csob.rest.apimodel.traffic.inside;

import cz.csob.rest.apimodel.traffic.Action;
import cz.csob.rest.apimodel.traffic.Actor;

public class _embeddedInside
{
    private String system;

    private String node;

    private String layer;

    private Action action;

    private Actor actor;

    public String getSystem ()
    {
        return system;
    }

    public void setSystem (String system)
    {
        this.system = system;
    }

    public String getNode ()
    {
        return node;
    }

    public void setNode (String node)
    {
        this.node = node;
    }

    public String getLayer ()
    {
        return layer;
    }

    public void setLayer (String layer)
    {
        this.layer = layer;
    }

    public Action getAction ()
    {
        return action;
    }

    public void setAction (Action action)
    {
        this.action = action;
    }

    public Actor getActor ()
    {
        return actor;
    }

    public void setActor (Actor actor)
    {
        this.actor = actor;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [system = "+system+", node = "+node+", layer = "+layer+", action = "+action+", actor = "+actor+"]";
    }
}