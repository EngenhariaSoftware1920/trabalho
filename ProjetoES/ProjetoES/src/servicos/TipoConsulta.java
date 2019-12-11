package servicos;
public class TipoConsulta {
	private String designacao;
	public TipoConsulta(String designacao) {
		this.designacao = designacao;
	}
	public String getDesignacao() {
		return designacao;
	}
	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}
	@Override
	public String toString() {
		return "TipoConsulta [Designação = " + designacao + "]";
	}
}