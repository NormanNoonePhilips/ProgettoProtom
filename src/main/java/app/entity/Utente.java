package app.entity;

	import java.io.Serializable;
	import java.time.LocalDate;
	import java.time.Period;

	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;

	@Entity
	@Table(name = "utente")
	public class Utente implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "user_id", nullable = false, unique = true)
		private int id;
		@Column(length = 45)
		private String nome;
		@Column(length = 45)
		private String cognome;
		@Column(length = 45)
		private String email;
		@Column(length = 45)
		private LocalDate datanasc;

		public Utente(String nome, String cognome, String email) {
			super();
			this.nome = nome;
			this.cognome = cognome;
			this.email = email;
		}

		public Utente() {
			super();
		}

		public Utente(String nome, String cognome) {
			super();
			this.nome = nome;
			this.cognome = cognome;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCognome() {
			return cognome;
		}

		public void setCognome(String cognome) {
			this.cognome = cognome;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public LocalDate getDatanasc() {
			return datanasc;
		}

		public void setDatanasc(LocalDate datanasc) {
			this.datanasc = datanasc;
		}
		public int getEta() {
			Period p = Period.between(datanasc, LocalDate.now());
			int et = p.getYears();
			return et;
		}
		public String getData() {
			LocalDate l = getDatanasc();
			String data = l.toString();
			return data;
	}
	}

