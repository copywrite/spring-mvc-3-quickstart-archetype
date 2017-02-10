package ${package}.dao;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * BaseDAO
 *
 * User: copywrite
 * Date: 2017-02-09 11:15:00
 */

public class BaseDAO {

    @Resource
    protected SqlMapClientTemplate sqlMapClientTemplate;

    public Long executeInsertBatch(final String sqlID, final List stList) {
        Long result = -1L;

        if ((sqlID != null) && (stList != null) && !stList.isEmpty()) {
            result = (Long) sqlMapClientTemplate.execute(new SqlMapClientCallback() {

                @Override
                public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
                    Long result;
                    executor.startBatch();

                    for (int i = 0; i < stList.size(); i++) {
                        executor.insert(sqlID, stList.get(i));
                    }
                    result = new Long(executor.executeBatch());
                    return result;
                }
            });
        }
        return result;
    }

}
