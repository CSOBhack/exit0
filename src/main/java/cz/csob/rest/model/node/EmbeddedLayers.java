package cz.csob.rest.model.node;

public class EmbeddedLayers {
    private Layer[] layers;

    public Layer[] getLayers() {
        return layers;
    }

    public void setLayers(Layer[] layers) {
        this.layers = layers;
    }

    @Override
    public String toString() {
        return "ClassPojo [layers = " + layers + "]";
    }
}