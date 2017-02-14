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
    /**
     * Password
     */
    private String password;
    /**
     * Salt
     */
    private String salt;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}