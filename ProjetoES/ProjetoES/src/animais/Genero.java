package animais;
// Informação relativa aos Género relevantes
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
		return "Genero [Designação = " + designacao + "]";
	}
}