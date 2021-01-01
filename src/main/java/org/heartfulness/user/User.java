package org.heartfulness.user;

import org.heartfulness.model.NamedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class User extends NamedEntity {

    @Column(name = "email")
    private String email;

    @Column(name = "sms_number")
    private String smsNumber;

    @Column(name = "whatsapp_number")
    private String whatsappNumber;

    @Column(name = "whispers")
    private boolean whispers;

    @Column(name = "OBT")
    private boolean OBT;

    @Column(name = "weekly")
    private boolean weekly;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSmsNumber() {
        return smsNumber;
    }

    public void setSmsNumber(String smsNumber) {
        this.smsNumber = smsNumber;
    }

    public String getWhatsappNumber() {
        return whatsappNumber;
    }

    public void setWhatsappNumber(String whatsappNumber) {
        this.whatsappNumber = whatsappNumber;
    }

    public boolean isWhispers() {
        return whispers;
    }

    public void setWhispers(boolean whispers) {
        this.whispers = whispers;
    }

    public boolean isOBT() {
        return OBT;
    }

    public void setOBT(boolean OBT) {
        this.OBT = OBT;
    }

    public boolean isWeekly() {
        return weekly;
    }

    public void setWeekly(boolean weekly) {
        this.weekly = weekly;
    }
}
