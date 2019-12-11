package servicos;
import colaboradores.ElementoEquipa;
public class Servico {
	private Consulta consulta;
	private Operacao operacao;
	private ElementoEquipa equipa;
	private int numHoras;
	public Servico(Consulta consulta, Operacao operacao, ElementoEquipa equipa, int numHoras) {
		this.consulta = consulta;
		this.operacao = operacao;
		this.equipa = equipa;
		this.numHoras = numHoras;
	}
	public Consulta getConsulta() {
		return consulta;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	public Operacao getOperacao() {
		return operacao;
	}
	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}
	public ElementoEquipa getEquipa() {
		return equipa;
	}
	public void setEquipa(ElementoEquipa equipa) {
		this.equipa = equipa;
	}
	public int getNumHoras() {
		return numHoras;
	}
	public void setNumHoras(int numHoras) {
		this.numHoras = numHoras;
	}
	@Override
	public String toString() {
		String codConsulta, nOperacao, codElementoEquipa = null;
		if(consulta==null) {
			codConsulta = "Não Discriminado";
		}
		else codConsulta = String.valueOf(consulta.getCodConsulta());
		if(operacao==null) {
			nOperacao = "Não Discriminado";
		}
		else nOperacao = operacao.getNome();
		if(equipa==null) {
			codElementoEquipa = "Não Discriminado";
		}
		else codElementoEquipa = String.valueOf(equipa.getCodColaborador());
		return "Servico [CodConsulta = " + codConsulta + ", Operação = " + nOperacao + ", CodElementoEquipa = " + codElementoEquipa + ", Número de Horas = " + numHoras + "]";
	}
}