package ${package}.query;

import java.io.Serializable;

/**
 * UserQuery
 *
 * User: copywrite
 * Date: 2017-02-09 11:15:00
 */

public class UserQuery implements Serializable{
    private static final long serialVersionUID = -1L;

    /**
     * id
     */
    private Long id;
    /**
     * name
     */
    private String name;

    /**
     * id getter & setter
     */
    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    /**
     * name getter & setter
     */
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

}