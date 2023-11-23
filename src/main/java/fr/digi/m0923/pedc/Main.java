package fr.digi.m0923.pedc;

import fr.digi.m0923.pedc.bo.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
            EntityManager em = emf.createEntityManager()) {

            em.getTransaction().begin();

            //AFFICHER UN LIVRE
            Livre livreAfficher = em.find(Livre.class, 3);

            //AFFICHER TOUS LES LIVRES PAR LE TITRE ET L'AUTEUR
            TypedQuery<Livre> queryTousLivres = em.createQuery("SELECT l FROM Livre l", Livre.class);
            List<Livre> listeLivres = queryTousLivres.getResultList();

            for (Livre livre : listeLivres) {
                System.out.println("Titre: " + livre.getTitre() + ", Auteur: " + livre.getAuteur());
            }

            // AFFICHER UN LIVRE PAR AUTEUR
            TypedQuery<Livre> queryParAuteur = em.createQuery("SELECT l FROM Livre l WHERE l.auteur = 'Jean-Pierre Coffe'", Livre.class);
            Livre livreParAuteur = queryParAuteur.getResultList().get(0);
            System.out.println(livreParAuteur);

            // AFFICHER UN LIVRE PAR TITRE
            TypedQuery<Livre> queryParTitre = em.createQuery("SELECT l FROM Livre l WHERE l.titre = 'Apprendre à parler aux animaux'", Livre.class);
            Livre livreParTitre = queryParTitre.getResultList().get(0);
            System.out.println(livreParTitre);


            // CREATION D'UN NOUVEAU LIVRE
            Livre livreACreer = new Livre( "one piece", "oda");
            em.persist(livreACreer);

            // MODIFICATION  LE NOM D'UN LIVRE
            Livre livreModif = em.find(Livre.class, 5);
            if (null != livreModif) {
                livreModif.setTitre("Du plaisir dans la cuisine");
            }

            // SUPPRESSION D'UN LIVRE
            Livre livreASupprimer = em.find(Livre.class, 6);
            if (null != livreASupprimer) {
                em.remove(livreASupprimer);
            }

            em.getTransaction().commit();
            }

    }
}
