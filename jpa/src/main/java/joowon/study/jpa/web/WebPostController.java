package joowon.study.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
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
    public PagedResources<Resource<WebPost>> getWebPosts(Pageable pageable, PagedResourcesAssembler<WebPost> assembler) {
        return assembler.toResource(posts.findAll(pageable));
    }
}