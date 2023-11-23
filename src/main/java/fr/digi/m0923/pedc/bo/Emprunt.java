package fr.digi.m0923.pedc.bo;

import jakarta.persistence.*;

import java.time.DateTimeException;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID")
    private Integer id;
    @Column(name= "DATE_DEBUT")
    private Date dateDebut;
    @Column(name= "DATE_FIN")
    private Date dateFin;
    @Column(name= "DELAI")
    private int delai;

    @ManyToOne
    @JoinColumn(name="ID_CLIENT")
    private Client client;

    public Emprunt() {
    }

    public Emprunt(Date dateDebut, Date dateFin, int delai, Client client) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.delai = delai;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getDelai() {
        return delai;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", delai=" + delai +
                ", client=" + client +
                '}';
    }

    public List<Livre> getLivres() {
        return null;
    }
}
