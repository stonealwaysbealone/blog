package com.stone.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_commnet")
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private String emai;
    private String conment;
    private String avatar;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createtime;
    @ManyToOne
    private Blog blog;
    @OneToMany(mappedBy = "parentcomment")
    private List<Comment> comments = new ArrayList<>();
    @ManyToOne
    private Comment parentcomment;


    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmai() {
        return emai;
    }

    public void setEmai(String emai) {
        this.emai = emai;
    }

    public String getConment() {
        return conment;
    }

    public void setConment(String conment) {
        this.conment = conment;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Comment getParentcomment() {
        return parentcomment;
    }

    public void setParentcomment(Comment parentcomment) {
        this.parentcomment = parentcomment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", emai='" + emai + '\'' +
                ", conment='" + conment + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createtime=" + createtime +
                ", blog=" + blog +
                '}';
    }
}
