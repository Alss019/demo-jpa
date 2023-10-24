package fr.diginamic.entites;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPRUNT")
public class Emprunt {

	@Id
	@Column(name="ID")
	private int id;
	@Column(name="date_debut")
	private LocalDate dateDebut;
	@Column(name="DATE_FIN")
	private LocalDate dateFin;
	@Column(name="DELAI")
	int delais;
	
	@ManyToMany(mappedBy="emprunt")
	private List<Livre>livres;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;
	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", delais=" + delais
				+ ", livres=" + livres + ", client=" + client + "]";
	}
	public Emprunt() {
		
	}
	/** Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/** Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/** Getter
	 * @return the dateDebut
	 */
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	/** Setter
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	/** Getter
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}
	/** Setter
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	/** Getter
	 * @return the delais
	 */
	public int getDelais() {
		return delais;
	}
	/** Setter
	 * @param delais the delais to set
	 */
	public void setDelais(int delais) {
		this.delais = delais;
	}
	/** Getter
	 * @return the livres
	 */
	public List<Livre> getLivres() {
		return livres;
	}
	/** Setter
	 * @param livres the livres to set
	 */
	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}
	/** Getter
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}
	/** Setter
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

}
