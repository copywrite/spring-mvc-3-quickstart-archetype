package ${package}.home;

import java.io.Serializable;

public class UserDO implements Serializable {
    private static final long serialVersionUID = -1L;

    /**
     * ID
     */
    private Long id;
    /**
     * Name
     */
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}