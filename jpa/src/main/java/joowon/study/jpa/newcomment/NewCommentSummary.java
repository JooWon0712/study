package joowon.study.jpa.newcomment;

public class NewCommentSummary {

    private String newComment;

    private int up;

    private int down;

    public NewCommentSummary(String newComment, int up, int down) {
        this.newComment = newComment;
        this.up = up;
        this.down = down;
    }

    public String getNewComment() {
        return newComment;
    }

    public int getUp() {
        return up;
    }

    public int getDown() {
        return down;
    }

    public String getVotes() {
        return this.up + " " + this.down;
    }
}

