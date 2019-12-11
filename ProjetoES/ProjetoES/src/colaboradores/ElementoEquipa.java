package colaboradores;
import java.util.*;

import servicos.Servico;
// Classe abstrata que representa os Colaboradores que efetuam Serviços
public abstract class ElementoEquipa extends Colaborador {
	protected String urgencias;
	protected ArrayList<Servico> servicos;
	// Construtor
	public ElementoEquipa(String nome, String morada, String telefone, String diaFolga, String urgencias) {
		super(nome, morada, telefone, diaFolga);
		this.servicos = new ArrayList<>();
		this.urgencias = urgencias;
	}
	public String getUrgencias() {
		return urgencias;
	}
	public void setUrgencias(String urgencias) {
		this.urgencias = urgencias;
	}
	// Serviços
	public boolean insertServico(Servico newS) {
		if(newS.getEquipa() != this) {
			return false;
		}
		else {
			servicos.add(newS);
			return true;
		}
	}
	public void printByOperacao(String nome) {
		if(servicos.isEmpty()) {
			System.out.println("Esta Consulta não se encontra associado a esta Operação");
		}
		else {
			for(Servico s : servicos) {
				if(s.getOperacao().getNome().equalsIgnoreCase(nome)) {
					System.out.println(s.toString());
				}
			}
		}
	}
	public void printByConsulta(int codConsulta) {
		if(servicos.isEmpty()) {
			System.out.println("Esta Consulta não se encontra associado a esta Operação");
		}
		else {
			for(Servico s : servicos) {
				if(s.getConsulta().getCodConsulta() == codConsulta) {
					System.out.println(s.toString());
				}
			}
		}
	}
	public void printAll() {
		if(servicos.isEmpty()) {
			System.out.println("Não existem Serviços associados a esta Operação");
		}
		else {
			for(Servico s : servicos) {
				System.out.println(s.toString());
			}
		}
	}
	@Override
	public String toString() {
		return "ElementoEquipa [CodColaborador = " + codColaborador + ", Nome = " + nome + ", Morada = " + morada + ", Telefone = " + telefone + ", Dia de Folga = " + diaFolga + ", Urgências = " + urgencias + "]";
	}	
}