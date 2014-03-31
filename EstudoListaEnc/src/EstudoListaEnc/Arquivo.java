package EstudoListaEnc;
import java.io.*;


public class Arquivo {

	private String nomeArquivo;
	/**
	 * @return the nomeArquivo
	 */
	public String getNomeArquivo() {
		return nomeArquivo;
	}
	/**
	 * @param nomeArquivo the nomeArquivo to set
	 */
	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	private String caminhoArquivo;
	/**
	 * @return the caminhoArquivo
	 */
	public String getCaminhoArquivo() {
		return caminhoArquivo;
	}
	/**
	 * @param caminhoArquivo the caminhoArquivo to set
	 */
	public void setCaminhoArquivo(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	}	
	
	public void Criar(String nome) throws IOException{
		File aux = new File("d:\\" + nome + ".txt");
		aux.createNewFile();
	}
}
