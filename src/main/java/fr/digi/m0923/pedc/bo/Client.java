package fr.digi.m0923.pedc.bo;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "CLIENT")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID")
    private Integer id;
    @Column(name= "NOM")
    private String nom;
    @Column(name= "PRENOM")
    private String prenom;

    @OneToMany(mappedBy = "client")
    private Set<Emprunt>emprunts;

    public Client() {
    }
    public Client(String nom, String prenom, Set<Emprunt> emprunts) {
        this.nom = nom;
        this.prenom = prenom;
        this.emprunts = emprunts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Set<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(Set<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", emprunts=" + emprunts +
                '}';
    }
}
