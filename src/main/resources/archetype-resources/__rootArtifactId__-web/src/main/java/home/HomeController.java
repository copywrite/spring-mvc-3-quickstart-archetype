package ${package}.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class HomeController {

    /**
     * Hello World
     * @return "hello"
     */
    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        return "hello";
    }
}
