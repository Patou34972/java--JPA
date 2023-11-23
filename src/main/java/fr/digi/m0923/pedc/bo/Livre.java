package fr.digi.m0923.pedc.bo;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "LIVRE")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID")
    private Integer id;
    @Column(name= "TITRE")
    private String titre;
    @Column(name= "AUTEUR")
    private String auteur;

    @ManyToMany
    @JoinTable(name="COMPO",
        joinColumns = @JoinColumn(name= "ID_LIV",referencedColumnName = "ID"),
        inverseJoinColumns = @JoinColumn(name= "ID_EMP", referencedColumnName = "ID")

    )
    private Set<Emprunt> emprunts;

    public Livre() {
    }

    public Livre(Integer id, String titre, String auteur) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
    }

    public Livre(String titre, String auteur) {
        this.titre = titre;
        this.auteur = auteur;
    }

    public Livre(Set<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    public Set<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(Set<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", emprunts=" + emprunts +
                '}';
    }
}
