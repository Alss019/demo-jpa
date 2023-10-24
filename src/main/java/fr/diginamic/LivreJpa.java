package fr.diginamic;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Emprunt;
import fr.diginamic.entites.Livre;

public class LivreJpa {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("livreJpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		//Requete qui extrait un livre en fonction de son id
		Livre l = new Livre();
		TypedQuery<Livre> query = em.createQuery("select l from Livre l where l.id='2'", Livre.class);
		List<Livre> livre = query.getResultList();
		System.out.println(livre);

		System.out.println("\n ------------------------------------ \n");

		// Requête qui extrait un emprunt en fonction de son ID
		Emprunt e = new Emprunt();
		TypedQuery<Emprunt> query2 = em.createQuery("SELECT e FROM Emprunt e WHERE e.id = '1'", Emprunt.class);
		List<Emprunt> emprunts = query2.getResultList();
		for (Emprunt emp : emprunts) {
			System.out.println("Id Emprunt :" + emp.getId());
			System.out.println("Livres associés à l'emprunt :");
			// On recupere la liste de livres associer a l'ID emprunt et on affiche le titre
			// du livre associer
			List<Livre> livres = emp.getLivres();
			for (Livre liv : livres) {
				System.out.println(" - Titre du livre : " + liv.getTitre());
			}
		}
		System.out.println("\n ------------------------------------ \n");
		// Requête qui extrait tous les emprunts d'un client donné
		TypedQuery<Emprunt> query3 = em.createQuery("SELECT e FROM Emprunt e WHERE e.client.id = '1'", Emprunt.class);
		emprunts = query3.getResultList();
		for (Emprunt emp : emprunts) {
			System.out.println("ID CLient:" + emp.getClient() + "\nNom: " + emp.getClient().getNom() + "\nPrenom: "
					+ emp.getClient().getPrenom() + "\nID emprunt:" + emp.getId());
			if (emp.getDateFin() == null) {
				LocalDate nouvelleDate = emp.getDateDebut().plusDays(emp.getDelais());
				System.out.println("Date retour maximum: " +nouvelleDate);
			}else {
				System.out.println("Date retour: " +emp.getDateFin());
			}
			System.out.println("ID emprunt:" + emp.getId() + "\n - Date emprunt: " + emp.getDateDebut());
			List<Livre> livres = emp.getLivres();
			for (Livre liv : livres) {
				System.out.println(" - Titre du livre: " + liv.getTitre());
			}
			System.out.println("\n ------------------------------------ \n");
		}
	}

}
