package joowon.study.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebPostController {

    @Autowired
    WebPostRepository webPostRepository;

    @GetMapping("/post/{id}")
    public String getWebPost(@PathVariable("id") WebPost webPost) {
        return webPost.getTitle();
    }
}