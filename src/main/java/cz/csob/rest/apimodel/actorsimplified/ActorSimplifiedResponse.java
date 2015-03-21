package cz.csob.rest.apimodel.actorsimplified;
                 
public class ActorSimplifiedResponse
{
    private String id;

    private String current_action_points;

    private String name;

    private String doing;

    private _links _links;

    private String type;

    private String goal;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getCurrent_action_points ()
    {
        return current_action_points;
    }

    public void setCurrent_action_points (String current_action_points)
    {
        this.current_action_points = current_action_points;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getDoing ()
    {
        return doing;
    }

    public void setDoing (String doing)
    {
        this.doing = doing;
    }

    public _links get_links ()
    {
        return _links;
    }

    public void set_links (_links _links)
    {
        this._links = _links;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getGoal ()
    {
        return goal;
    }

    public void setGoal (String goal)
    {
        this.goal = goal;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", current_action_points = "+current_action_points+", name = "+name+", doing = "+doing+", _links = "+_links+", type = "+type+", goal = "+goal+"]";
    }
}
		