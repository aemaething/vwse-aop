package com.aemaething.vwse.aop.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {

    @ManyToOne()
    @JoinColumn(name = "post_id")
    @NotNull
    protected Post post;

    @Column(name = "is_public")
    protected boolean isPublic;

    @Lob
    @Column(name = "content", nullable = false, length = 4096)
    @NotNull
    @Length(max = 4096)
    private String content;

    @Column(name = "cnt", nullable = false)
    private int cnt;


    public Comment() {
        super();
        isPublic = false;
        cnt = 0;
    }

    public Comment(@NotNull Post post) {
        this();
        this.post = post;
        post.getComments().add(this);
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
