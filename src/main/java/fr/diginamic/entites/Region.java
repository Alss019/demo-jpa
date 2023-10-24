package fr.diginamic.entites;

import javax.persistence.*;

@Entity
public class Region {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	@Column (name="Nom", length=50, nullable=false)
	private String nom;
	
	public Region() {
	}
	@Override
	public String toString() {
		return "ID de la region =" + id + "\nNom= " + nom + "\n";
	}

	/** Getter
	 * @return the idRegion
	 */
	public int getId() {
		return id;
	}

	/** Setter
	 * @param idRegion the idRegion to set
	 */
	public void setId(int idRegion) {
		this.id = idRegion;
	}

	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
