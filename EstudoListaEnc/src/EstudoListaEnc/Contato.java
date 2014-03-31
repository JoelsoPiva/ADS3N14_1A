package EstudoListaEnc;

public class Contato {
	private String nome;
	private Contato prox;
	
	/**
	 * @return the prox
	 */
	public Contato getProx() {
		return prox;
	}
	/**
	 * @param prox the prox to set
	 */
	public void setProx(Contato prox) {
		this.prox = prox;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	String telefone;
	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}
	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
