package ${package}.dao;

import ${package}.common.exception.DaoException;
import ${package}.home.UserDO;
import ${package}.query.UserQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserDAO
 *
 * User: copywrite
 * Date: 2017-02-09 11:15:00
 */

@Service
public class UserDAO extends BaseDAO{

    private static final String NAMESPACE = "UserDAO.";

    /**
     * insert one data
     *
     * @param userDO object
     * @return primaryKey Long
     * @throws Exception exception
     */
     public Long insert(UserDO userDO) throws DaoException {
        try{
            return (Long) sqlMapClientTemplate.insert(NAMESPACE + "insert", userDO);
        } catch (Exception e) {
            throw new DaoException(e);
        }
     }

    /**
     * update data
     *
     * @param userDO object
     * @return update num
     * @throws Exception exception
     */
    public int update(UserDO userDO) throws DaoException{
        try{
            return sqlMapClientTemplate.update(NAMESPACE + "update", userDO);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
    /**
     * get an obj
     *
     * @param id key
     * @return do obj
     * @throws Exception exception
     */
    public UserDO get(Long id) throws DaoException{
        try{
            return (UserDO) sqlMapClientTemplate.queryForObject(NAMESPACE + "select", id);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    /**
     * query a list
     *
     * @param userQuery query
     * @return List
     * @throws Exception exception
     */
    @SuppressWarnings("unchecked")
    public List<UserDO> getList(UserQuery userQuery) throws DaoException{
        try{
            return (List<UserDO>) sqlMapClientTemplate.queryForList(NAMESPACE + "queryList", userQuery);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    /**
     * query count
     *
     * @param userQuery query
     * @return Integer
     * @throws Exception exception
     */
    public Integer getCount(UserQuery userQuery) throws DaoException{
        try{
            return (Integer) sqlMapClientTemplate.queryForObject(NAMESPACE + "queryCount", userQuery);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    /**
     * logically delete one line
     *
     * @param id key
     * @return delete num
     * @throws Exception exception
     */
    public int delete(Long id) throws Exception{
        try{
            return sqlMapClientTemplate.update(NAMESPACE + "delete", id);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}