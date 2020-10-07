package main.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "captcha_codes")
public class CaptchaCode
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date time;

    @Type(type = "text")
    @NotNull
    private String code;

    @Type(type = "text")
    @Column(name = "secret_code")
    @NotNull
    private String secretCode;

    public CaptchaCode(@NotNull long id, @NotNull Date time, @NotNull String code, @NotNull String secretCode)
    {
        this.id = id;
        this.time = time;
        this.code = code;
        this.secretCode = secretCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }
}
