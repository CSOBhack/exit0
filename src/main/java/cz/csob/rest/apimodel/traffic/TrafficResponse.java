package cz.csob.rest.apimodel.traffic;

public class TrafficResponse
{
    private _links _links;

    private _embedded _embedded;

    public _links get_links ()
    {
        return _links;
    }

    public void set_links (_links _links)
    {
        this._links = _links;
    }

    public _embedded get_embedded ()
    {
        return _embedded;
    }

    public void set_embedded (_embedded _embedded)
    {
        this._embedded = _embedded;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [_links = "+_links+", _embedded = "+_embedded+"]";
    }
}