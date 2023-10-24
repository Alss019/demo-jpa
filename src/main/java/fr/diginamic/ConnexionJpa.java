package fr.diginamic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ConnexionJpa {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory ("recensement");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction= em.getTransaction();
		transaction.begin();
			
			
			Region r  = em.find(Region.class, 1);
			if(r!=null) {
				System.out.println("Region trouvée : " + r.getNom());
			}else {
				System.out.println("Region non trouvée" );
			}
			Region region = new Region();
			region.setId(50);
			region.setNom("Midi-Pyrenee");
			em.persist(region);
			
			TypedQuery<Region> query = em.createQuery("select region from Region region where region.nom='Midi-Pyrenee'",Region.class);
			List<Region> regions = query.getResultList();
			System.out.println(regions);
		
		transaction.commit();
	}

}
