package cz.csob.rest.model.node;

public class Layer {
    private String id;

    private String level;

    private String user_capacity;

    private String max_robustness;

    private String name;

    private String current_robustness;

    private String system_id;

    private String created_at;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getUser_capacity() {
        return user_capacity;
    }

    public void setUser_capacity(String user_capacity) {
        this.user_capacity = user_capacity;
    }

    public String getMax_robustness() {
        return max_robustness;
    }

    public void setMax_robustness(String max_robustness) {
        this.max_robustness = max_robustness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrent_robustness() {
        return current_robustness;
    }

    public void setCurrent_robustness(String current_robustness) {
        this.current_robustness = current_robustness;
    }

    public String getSystem_id() {
        return system_id;
    }

    public void setSystem_id(String system_id) {
        this.system_id = system_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", level = " + level + ", user_capacity = " + user_capacity + ", max_robustness = " + max_robustness + ", name = " + name + ", current_robustness = " + current_robustness + ", system_id = " + system_id + ", created_at = " + created_at + "]";
    }
}