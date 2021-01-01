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

    @Column(name = "whispers_email")
    private boolean whispersEmail;

    @Column(name = "whispers_whatsapp")
    private boolean whispersWhatsapp;

    @Column(name = "whispers_sms")
    private boolean whispersSMS;


    @Column(name = "obt_email")
    private boolean OBTEmail;

    @Column(name = "obt_whatsapp")
    private boolean OBTWhatsapp;

    public boolean isWhispersEmail() {
        return whispersEmail;
    }

    public void setWhispersEmail(boolean whispersEmail) {
        this.whispersEmail = whispersEmail;
    }

    public boolean isWhispersWhatsapp() {
        return whispersWhatsapp;
    }

    public void setWhispersWhatsapp(boolean whispersWhatsapp) {
        this.whispersWhatsapp = whispersWhatsapp;
    }

    public boolean isWhispersSMS() {
        return whispersSMS;
    }

    public void setWhispersSMS(boolean whispersSMS) {
        this.whispersSMS = whispersSMS;
    }

    public boolean isOBTEmail() {
        return OBTEmail;
    }

    public void setOBTEmail(boolean OBTEmail) {
        this.OBTEmail = OBTEmail;
    }

    public boolean isOBTWhatsapp() {
        return OBTWhatsapp;
    }

    public void setOBTWhatsapp(boolean OBTWhatsapp) {
        this.OBTWhatsapp = OBTWhatsapp;
    }

    public boolean isOBTSMS() {
        return OBTSMS;
    }

    public void setOBTSMS(boolean OBTSMS) {
        this.OBTSMS = OBTSMS;
    }

    public boolean isWeeklyEmail() {
        return weeklyEmail;
    }

    public void setWeeklyEmail(boolean weeklyEmail) {
        this.weeklyEmail = weeklyEmail;
    }

    public boolean isWeeklyWhatsapp() {
        return weeklyWhatsapp;
    }

    public void setWeeklyWhatsapp(boolean weeklyWhatsapp) {
        this.weeklyWhatsapp = weeklyWhatsapp;
    }

    public boolean isWeeklySMS() {
        return weeklySMS;
    }

    public void setWeeklySMS(boolean weeklySMS) {
        this.weeklySMS = weeklySMS;
    }

    @Column(name = "obt_sms")
    private boolean OBTSMS;


    @Column(name = "weekly_email")
    private boolean weeklyEmail;

    @Column(name = "weekly_whatsapp")
    private boolean weeklyWhatsapp;

    @Column(name = "weekly_sms")
    private boolean weeklySMS;


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

}
