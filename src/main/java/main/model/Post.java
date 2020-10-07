package main.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "posts")
public class Post
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private long id;

    @Column(name = "is_active")
    @NotNull
    private byte isActive;


    @Enumerated(EnumType.STRING)
    @Column(name = "moderation_status")
    @NotNull
    private ModStatusEnum moderationStatus;

    @ManyToOne
    @JoinColumn(name = "moderator_users_id")
    private User moderatorId;

    @ManyToOne
    @JoinColumn(name = "users_id")
    @NotNull
    private User userId;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date time;

    @NotNull
    private String title;

    @Type(type = "text")
    @NotNull
    private String text;

    @Column(name = "view_count")
    @NotNull
    private int viewCount;

    @OneToMany(mappedBy = "postId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PostVote> postVotes = new HashSet<>();

    @OneToMany(mappedBy = "postId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Tag2Post> tag2PostConnections = new HashSet<>();

    @OneToMany(mappedBy = "postId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PostComment> postComments = new HashSet<>();

    public Post(@NotNull long id, @NotNull byte isActive, @NotNull ModStatusEnum moderationStatus,
                User moderatorId, @NotNull User userId, @NotNull Date time, @NotNull String title,
                @NotNull String text, @NotNull int viewCount)
    {
        this.id = id;
        this.isActive = isActive;
        this.moderationStatus = moderationStatus;
        this.moderatorId = moderatorId;
        this.userId = userId;
        this.time = time;
        this.title = title;
        this.text = text;
        this.viewCount = viewCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte getIsActive() {
        return isActive;
    }

    public void setIsActive(byte isActive) {
        this.isActive = isActive;
    }

    public ModStatusEnum getModerationStatus() {
        return moderationStatus;
    }

    public void setModerationStatus(ModStatusEnum moderationStatus) {
        this.moderationStatus = moderationStatus;
    }

    public User getModeratorId() {
        return moderatorId;
    }

    public void setModeratorId(User moderatorId) {
        this.moderatorId = moderatorId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public Set<PostVote> getPostVotes() {
        return postVotes;
    }

    public void setPostVotes(Set<PostVote> postVotes) {
        this.postVotes = postVotes;
    }

    public Set<Tag2Post> getTag2PostConnections() {
        return tag2PostConnections;
    }

    public void setTag2PostConnections(Set<Tag2Post> tag2PostConnections) {
        this.tag2PostConnections = tag2PostConnections;
    }

    public Set<PostComment> getPostComments() {
        return postComments;
    }

    public void setPostComments(Set<PostComment> postComments) {
        this.postComments = postComments;
    }
}
