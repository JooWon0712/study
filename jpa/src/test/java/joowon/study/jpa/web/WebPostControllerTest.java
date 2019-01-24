package joowon.study.jpa.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class WebPostControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    WebPostRepository webPostRepository;

    @Test
    public void getWebPost() throws Exception {
        createWebPost();

        mockMvc.perform(get("/post/10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("jpa"));
    }

    @Test
    public void getWebPosts() throws Exception {
        createWebPost();

        mockMvc.perform(get("/posts")
                    .param("page", "0")
                    .param("size", "10")
                    .param("sort", "created,desc")
                    .param("sort", "title"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    private void createWebPost() {
        int postsCount = 100;
        while (postsCount > 0){
            WebPost webPost = new WebPost();
            webPost.setTitle("jpa");
            webPostRepository.save(webPost);
            postsCount--;
        }

    }

}