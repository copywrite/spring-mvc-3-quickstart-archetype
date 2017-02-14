package ${package}.home;

import javax.annotation.Resource;

import ${package}.manager.UserManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
class HomeController {

    private Logger logger = LoggerFactory.getLogger("rootLog");

    @Resource
    private UserManager userManager;

    /**
     * Hello World
     * @return "hello"
     */
    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        try {
            logger.info("HomeController hello.");

            UserDO user = userManager.get(0L);
            if (user != null) {
                return "hello " + user.getName();
            }
        } catch (Exception e) {
            return "bye";
        }

        return "hello";
    }
}
