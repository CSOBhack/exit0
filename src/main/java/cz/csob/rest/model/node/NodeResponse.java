package cz.csob.rest.model.node;

/**
 * Created by roman.zakutny on 21.3.2015.
 */
public class NodeResponse {
    private Links _links;

    private EmbeddedNodes _embedded;

    public Links get_links ()
    {
        return _links;
    }

    public void set_links (Links _links)
    {
        this._links = _links;
    }

    public EmbeddedNodes get_embedded ()
    {
        return _embedded;
    }

    public void set_embedded (EmbeddedNodes _embedded)
    {
        this._embedded = _embedded;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [_links = "+_links+", _embedded = "+_embedded+"]";
    }
}
