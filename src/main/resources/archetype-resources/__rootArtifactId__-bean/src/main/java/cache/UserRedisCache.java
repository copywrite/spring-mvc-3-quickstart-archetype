package ${package}.cache;

import ${package}.home.UserDO;
import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import static ${package}.common.constants.RedisNamespaces.USER_PREFIX;

@Service
public class UserRedisCache extends RedisCache {
    private Gson gson = new Gson();

    public boolean setUserDO(Long userId, UserDO userDO) {
        Jedis jedis = null;
        try {
            jedis = open();
            String key = USER_PREFIX + String.valueOf(userId);
            jedis.set(key, gson.toJson(userDO));
            jedis.expire(key, 60 * 60 * 24);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            close(jedis);
        }
    }

    public UserDO getUserDO(Long userId) {
        Jedis jedis = null;
        try {
            jedis = open();
            String key = USER_PREFIX + String.valueOf(userId);
            String obj = jedis.get(key);
            if (StringUtils.isNotBlank(obj)) {
                return gson.fromJson(obj, UserDO.class);
            }
        } catch (Exception e) {
            return null;
        } finally {
            close(jedis);
        }
        return null;
    }
}