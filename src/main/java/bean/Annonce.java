package bean;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "annonce")
public class Annonce {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "adress")
    private String adresse;

    @Column(name = "mail")
    private String email;

    @Column(name = "date")
    private Timestamp date;

    public Annonce() {

    }

    public Annonce(int id, String title, String description, String adresse, String email, Timestamp date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.adresse = adresse;
        this.email = email;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
