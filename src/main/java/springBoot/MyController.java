package springBoot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author brobinson
 */
@Controller
public class MyController {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        String myTextVariable = "Thymeleaf made me appear!";
        return myTextVariable;
    }

}
