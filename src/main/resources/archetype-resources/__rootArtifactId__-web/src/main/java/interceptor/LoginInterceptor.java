package ${package}.interceptor;

import javax.annotation.Resource;

import ${package}.home.UserDO;
import ${package}.manager.UserManager;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.DigestUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by copywrite on 17/2/13.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{

    private Logger logger = LoggerFactory.getLogger("rootLog");

    @Resource
    private UserManager userManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {

            logger.error("LoginInterceptor preHandle.");

            String name = request.getParameter("user");
            String password = request.getParameter("password");

            if (StringUtils.isBlank(name) || StringUtils.isBlank(password)) {
                returnNeedLoginError(response);
                return false;
            }

            UserDO user = userManager.getByName(name);
            if (user == null) {
                returnNeedLoginError(response);
                return false;
            }

            String userPassword = user.getPassword();
            String salt = user.getSalt();
            String salted = DigestUtils.md5DigestAsHex((password + salt).getBytes());
            if (!userPassword.equals(salted)) {
                returnNeedLoginError(response);
                return false;
            }

        } catch (Exception e) {
            returnNeedLoginError(response);
            return false;
        }

        return true;
    }

    private void returnNeedLoginError(HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter out = response.getWriter();
            out.write("Authentication required or login failed.");
            out.flush();
            out.close();
        } catch (IOException e) {
        }
    }
}
