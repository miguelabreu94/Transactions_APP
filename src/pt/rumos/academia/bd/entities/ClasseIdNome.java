package pt.rumos.academia.bd.entities;

public class ClasseIdNome {

	protected int id;
	
	protected String nome;

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
	
	
	@Override
	public String toString() {
		return String.format("%d,%s", id, nome);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(this == obj) return false;
		if(obj instanceof ClasseIdNome cin) {
			return cin.id == this.id && cin.nome.equals(this.nome); 
		}
		
		return false;
	}
	
	
}
