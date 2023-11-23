package fr.digi.m0923.pedc;

import fr.digi.m0923.pedc.bo.Emprunt;
import fr.digi.m0923.pedc.bo.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TestBibliotheque {
    public static void main(String[] args) {

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
             EntityManager em = emf.createEntityManager()) {

            em.getTransaction().begin();

            // Réalisez une requête qui permet d’extraire un emprunt et tous ses livres associés.
            int idEmprunt = 1; // Remplacez par l'ID réel de l'emprunt que vous souhaitez extraire

            TypedQuery<Emprunt> queryEmprunt = em.createQuery(
                    "SELECT e FROM Emprunt e JOIN FETCH e.livre WHERE e.id = :idEmprunt",
                    Emprunt.class
            );
            queryEmprunt.setParameter("idEmprunt", idEmprunt);

            Emprunt emprunt = queryEmprunt.getSingleResult();

            // Affichage des informations sur l'emprunt et les livres associés
            System.out.println("Emprunt trouvé : " + emprunt);
            List<Livre> livres = emprunt.getLivres();
            if (livres != null && !livres.isEmpty()) {
                System.out.println("Livres associés :");
                for (Livre livre : livres) {
                    System.out.println("- " + livre);
                }
            } else {
                System.out.println("Aucun livre associé à cet emprunt.");
            }

            em.getTransaction().commit();
        }
    }
}
