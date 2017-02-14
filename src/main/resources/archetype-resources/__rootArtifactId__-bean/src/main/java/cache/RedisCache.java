package ${package}.cache;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

public abstract class RedisCache {

    private JedisPool jedisPool;

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public Jedis open() {
        return jedisPool.getResource();
    }

    public void close(Jedis resource) {
        if (jedisPool != null) {
            try {
                if (resource != null) {
                    jedisPool.returnResource(resource);
                    resource = null;
                }
            } catch (JedisConnectionException e) {
                jedisPool.returnBrokenResource(resource);
                resource = null;
            } finally {
                if (resource != null) {
                    jedisPool.returnResource(resource);
                }
                resource = null;
            }
        }
    }
}
