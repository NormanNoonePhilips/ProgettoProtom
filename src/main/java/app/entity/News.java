package app.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "news")
public class News implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "news_id", nullable = false, unique = true)
	private int id;
	@Column(length = 45)
	private String autore;
	@Column(length = 45)
	private String titolo;
	@Column(length = 45)
	private String genere;
	@Column
	private LocalDate dataPublicazione;
	@Lob
	private String testo;

	public News(String autore, String genere, LocalDate dataPublicazione, String testo) {
		super();
		this.autore = autore;
		this.genere = genere;
		this.dataPublicazione = dataPublicazione;
		this.testo = testo;
	}

	public News(String autore, String genere, String titolo, LocalDate dataPublicazione) {
		super();
		this.autore = autore;
		this.titolo = titolo;
		this.genere = genere;
		this.dataPublicazione = dataPublicazione;
	}

	public News(String autore, String titolo, String genere) {
		super();
		this.autore = autore;
		this.titolo = titolo;
		this.genere = genere;
	}

	public News(String autore, String titolo, String genere, LocalDate dataPublicazione, String testo) {
		super();
		this.autore = autore;
		this.titolo = titolo;
		this.genere = genere;
		this.dataPublicazione = dataPublicazione;
		this.testo = testo;
	}

	public News() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public LocalDate getDataPublicazione() {
		return dataPublicazione;
	}

	public void setDataPublicazione(LocalDate dataPublicazione) {
		this.dataPublicazione = dataPublicazione;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getData() {
		LocalDate l = getDataPublicazione();
		String data = l.toString();
		return data;
	}

}
