package fr.diginamic;

import javax.persistence.*;

@Entity
public class Region {
	@Id
	private int id;
	@Column (name="Nom", length=50, nullable=false)
	private String nom;
	
	public Region(int idRegion, String nom) {
		super();
		this.id = idRegion;
		this.nom = nom;
	}
	public Region() {
	}
	@Override
	public String toString() {
		return "Region " + id + "\nnom=" + nom + "\n";
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
