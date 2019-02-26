package joowon.study.oauth.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by JooWon0712.
 * User: joowon
 * Date: 2019-02-26
 * Time: 12:17
 */
@Controller
public class WebController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
