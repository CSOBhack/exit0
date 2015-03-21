package cz.csob.rest.apimodel.traffic;

import cz.csob.rest.apimodel.traffic.inside._embeddedInside;

public class Events
{
    private String happened_at;

    private String event_id;

    private _embeddedInside _embeddedInside;

    public String getHappened_at ()
    {
        return happened_at;
    }

    public void setHappened_at (String happened_at)
    {
        this.happened_at = happened_at;
    }

    public String getEvent_id ()
    {
        return event_id;
    }

    public void setEvent_id (String event_id)
    {
        this.event_id = event_id;
    }

    public _embeddedInside get_embeddedInside()
    {
        return _embeddedInside;
    }

    public void set_embeddedInside(_embeddedInside _embeddedInside)
    {
        this._embeddedInside = _embeddedInside;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [happened_at = "+happened_at+", event_id = "+event_id+", _embedded = "+ _embeddedInside +"]";
    }
}