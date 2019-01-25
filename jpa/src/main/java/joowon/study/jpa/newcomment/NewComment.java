package joowon.study.jpa.newcomment;

import joowon.study.jpa.newpost.NewPost;

import javax.persistence.*;

@Entity
public class NewComment {

    @Id @GeneratedValue
    private Long id;

    private String Comment;

    @ManyToOne(fetch = FetchType.LAZY)
    private NewPost newPost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public NewPost getNewPost() {
        return newPost;
    }

    public void setNewPost(NewPost newPost) {
        this.newPost = newPost;
    }
}
