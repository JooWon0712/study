package joowon.study.jpa.newpost;

import org.springframework.context.ApplicationEvent;

public class NewPostPublishedEvent extends ApplicationEvent {

    private final NewPost newPost;

    public NewPostPublishedEvent(Object source) {
        super(source);
        this.newPost = (NewPost) source;
    }

    public NewPost getNewPost() {
        return newPost;
    }
}
