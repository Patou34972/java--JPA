package fr.digi.m0923.pedc;

import fr.digi.m0923.pedc.bo.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
            EntityManager em = emf.createEntityManager()) {

            em.getTransaction().begin();

            //AFFICHE UN LIVRE
          /*  Livre livreAfficher = em.find(Livre.class, 3);*/

            // CREATION D'UN NOUVEAU LIVRE
            /*Livre livreACreer = new Livre( "one piece", "oda");
            em.persist(livreACreer);*/

            // MODIFICATION D'UN LIVRE
         /*   Livre livreModif = em.find(Livre.class, 3);
            if (null != livreModif) {
                livreModif.setTitre("diginamic domaine");
            }*/

            // SUPPRESSION D'UN LIVRE
            Livre livreASupprimer = em.find(Livre.class, 6);
            if (null != livreASupprimer) {
                em.remove(livreASupprimer);
            }

            em.getTransaction().commit();
            }

    }
}
