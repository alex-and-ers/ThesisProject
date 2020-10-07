package main.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "post_comments")
public class PostComment
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private long id;

    @ManyToOne (cascade=CascadeType.ALL)
    @JoinColumn (name="post_comments_id")
    private PostComment parentId;

    @ManyToOne
    @JoinColumn(name = "posts_id")
    @NotNull
    private Post postId;

    @ManyToOne
    @JoinColumn(name = "users_id")
    @NotNull
    private User userId;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date time;

    @Type(type = "text")
    @NotNull
    private String text;

    public PostComment(@NotNull long id, PostComment parentId, @NotNull Post postId,
                       @NotNull User userId, @NotNull Date time, @NotNull String text)
    {
        this.id = id;
        this.parentId = parentId;
        this.postId = postId;
        this.userId = userId;
        this.time = time;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PostComment getParentId() {
        return parentId;
    }

    public void setParentId(PostComment parentId) {
        this.parentId = parentId;
    }

    public @NotNull Post getPostId() {
        return postId;
    }

    public void setPostId(@NotNull Post postId) {
        this.postId = postId;
    }

    public @NotNull User getUserId() {
        return userId;
    }

    public void setUserId(@NotNull User userId) {
        this.userId = userId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
