package joowon.study.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebPostController {

    @Autowired
    WebPostRepository posts;

    @GetMapping("/post/{id}")
    public String getWebPost(@PathVariable("id") WebPost webPost) {
        return webPost.getTitle();
    }

    @GetMapping("/posts")
    public Page<WebPost> getWebPosts(Pageable pageable) {
        return posts.findAll(pageable);
    }
}