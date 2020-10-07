package main.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "post_votes")
public class PostVote
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User userId;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @NotNull
    private Post postId;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date time;

    @NotNull
    private byte value;

    public PostVote(@NotNull long id, @NotNull User userId, @NotNull Post postId, @NotNull Date time, @NotNull byte value)
    {
        this.id = id;
        this.userId = userId;
        this.postId = postId;
        this.time = time;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotNull User getUserId() {
        return userId;
    }

    public void setUserId(@NotNull User userId) {
        this.userId = userId;
    }

    public @NotNull Post getPostId() {
        return postId;
    }

    public void setPostId(@NotNull Post postId) {
        this.postId = postId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }
}
