package cz.csob.rest.model.node;

public class EmbeddedNodes {
    private Node[] nodes;

    public Node[] getNodes() {
        return nodes;
    }

    public void setNodes(Node[] nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        return "ClassPojo [nodes = " + nodes + "]";
    }
}