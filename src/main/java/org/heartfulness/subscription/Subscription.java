package org.heartfulness.subscription;

import org.heartfulness.model.BaseEntity;
import org.heartfulness.model.NamedEntity;
import org.heartfulness.user.User;

import javax.persistence.*;

@Entity
public class Subscription extends BaseEntity {

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "whatsapp")
    private boolean whatsapp;

    @Column(name = "sms")
    private boolean sms;

    @Column(name = "email")
    private boolean email;


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    public Subscription(String name) {
        this.setName(name);
    }

    public Subscription() {

    }

    public boolean isWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(boolean whatsapp) {
        this.whatsapp = whatsapp;
    }

    public boolean isSms() {
        return sms;
    }

    public void setSms(boolean sms) {
        this.sms = sms;
    }

    public boolean isEmail() {
        return email;
    }

    public void setEmail(boolean email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
