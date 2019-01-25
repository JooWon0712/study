package joowon.study.jpa.newcomment;

import org.springframework.data.jpa.domain.Specification;

public class NewCommentSpecs {

    public static Specification<NewComment> isBest() {
        return (Specification<NewComment>) (root, query, builder) -> builder.isTrue(root.get(NewComment_.best));
    }

    public static Specification<NewComment> isGood() {
        return (Specification<NewComment>) (root, query, builder) -> builder.greaterThan(root.get(NewComment_.up), 10);
    }
}
