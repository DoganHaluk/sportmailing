package be.vdab.sportmailing.domain;

import javax.persistence.*;

@Entity
@Table(name = "sporters")
public class Sporter {
    @Id
    private long id;
    private String emailAdres;

    public long getId() {
        return id;
    }

    public String getEmailAdres() {
        return emailAdres;
    }
}
