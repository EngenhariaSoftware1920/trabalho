package animais;
// Informa��o relativa aos G�nero relevantes
public class Genero {
	private String designacao;
	// Construtor
	public Genero(String designacao) {
		this.designacao = designacao;
	}
	// Gets e Sets
	public String getDesignacao() {
		return designacao;
	}
	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}
	// ToString
	@Override
	public String toString() {
		return "Genero [Designa��o = " + designacao + "]";
	}
}