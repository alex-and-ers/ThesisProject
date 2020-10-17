package main.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "captcha_codes")
public class GlobalSettings
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "MULTIUSER_MODE")
    @NotNull
    private YesNoEnum multiuserMode;

    @Enumerated(EnumType.STRING)
    @Column(name = "POST_PREMODERATION")
    @NotNull
    private YesNoEnum postPremoderation;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATISTICS_IS_PUBLIC")
    @NotNull
    private YesNoEnum statisticsIsPublic;

    public GlobalSettings(@NotNull int id, @NotNull YesNoEnum multiuserMode,
                          @NotNull YesNoEnum postPremoderation, @NotNull YesNoEnum statisticsIsPublic)
    {
        this.id = id;
        this.multiuserMode = multiuserMode;
        this.postPremoderation = postPremoderation;
        this.statisticsIsPublic = statisticsIsPublic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public YesNoEnum getMultiuserMode() {
        return multiuserMode;
    }

    public void setMultiuserMode(YesNoEnum multiuserMode) {
        this.multiuserMode = multiuserMode;
    }

    public YesNoEnum getPostPremoderation() {
        return postPremoderation;
    }

    public void setPostPremoderation(YesNoEnum postPremoderation) {
        this.postPremoderation = postPremoderation;
    }

    public YesNoEnum getStatisticsIsPublic() {
        return statisticsIsPublic;
    }

    public void setStatisticsIsPublic(YesNoEnum statisticsIsPublic) {
        this.statisticsIsPublic = statisticsIsPublic;
    }
}
