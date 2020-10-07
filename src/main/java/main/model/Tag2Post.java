package main.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Tag2Post
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @NotNull
    private Post postId;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    @NotNull
    private Tag tagId;

    public Tag2Post(@NotNull long id, @NotNull Post postId, @NotNull Tag tagId)
    {
        this.id = id;
        this.postId = postId;
        this.tagId = tagId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotNull Post getPostId() {
        return postId;
    }

    public void setPostId(@NotNull Post postId) {
        this.postId = postId;
    }

    public @NotNull Tag getTagId() {
        return tagId;
    }

    public void setTagId(@NotNull Tag tagId) {
        this.tagId = tagId;
    }
}
