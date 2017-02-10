package ${package}.manager;

import java.util.List;
import ${package}.dao.UserDAO;
import ${package}.query.UserQuery;
import ${package}.home.UserDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * UserManager
 *
 * User: copywrite
 * Date: 2017-02-09 11:15:00
 */

@Service
public class UserManager {

    @Resource
    private UserDAO userDAO;

    /**
     * insert one data
     *
     * @param userDO object
     * @return primaryKey Long
     * @throws Exception exception
     */
    public Long insert(UserDO userDO) throws Exception{
        return userDAO.insert(userDO);
    }

    /**
     * update data
     *
     * @param userDO object
     * @return update num
     * @throws Exception exception
     */
    public int update(UserDO userDO) throws Exception{
        return userDAO.update(userDO);
    }

    /**
     * get an obj
     *
     * @param id key
     * @return do obj
     * @throws Exception exception
     */
    public UserDO get(Long id) throws Exception{
        return userDAO.get(id);
    }

    /**
     * query a list
     *
     * @param userQuery query
     * @return List
     * @throws Exception exception
     */
    public List<UserDO> getList(UserQuery userQuery) throws Exception{
        return userDAO.getList(userQuery);
    }

    /**
     * query count
     *
     * @param userQuery query
     * @return Integer
     * @throws Exception exception
     */
    public Integer getCount(UserQuery userQuery) throws Exception{
        return userDAO.getCount(userQuery);
    }

    /**
     * logic delete one line
     *
     * @param id key
     * @return delete num
     * @throws Exception exception
     */
    public int delete(Long id) throws Exception{
        return userDAO.delete(id);
    }

}