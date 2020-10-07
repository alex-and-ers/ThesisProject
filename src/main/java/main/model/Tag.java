package main.model;

import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tags")
public class Tag
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private long id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "tagId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Tag2Post> tag2PostConnections = new HashSet<>();

    public Tag(@NotNull long id, @NotNull String name)
    {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
