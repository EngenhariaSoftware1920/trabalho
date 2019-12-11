package servicos;
import java.util.*;
public class Operacao {
	private String nome;
	private ArrayList<Servico> servicos;
	public Operacao(String nome) {
		this.nome = nome;
		this.servicos = new ArrayList<>(); 
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	// Servi�os associados ao tipo de Opera��o
	public boolean insertServico(Servico newS) {
		if(newS == null) {
			return false;
		}
		if(newS.getOperacao() != this) {
			return false;
		}
		else {
			servicos.add(newS);
			return true;
		}
	}
	public void printByConsulta(int codConsulta) {
		if(servicos.isEmpty()) {
			System.out.println("Esta Consulta n�o se encontra associado a esta Opera��o");
		}
		else {
			for(Servico s : servicos) {
				if(s.getConsulta().getCodConsulta() == codConsulta) {
					System.out.println(s.toString());
				}
			}
		}
	}
	public void printByElementoEquipa(int codColaborador) {
		if(servicos.isEmpty()) {
			System.out.println("Este Colaborador n�o se encontra associado a esta Opera��o");
		}
		else {
			for(Servico s : servicos) {
				if(s.getEquipa().getCodColaborador() == codColaborador) {
					System.out.println(s.toString());
				}
			}
		}
	}
	public void printAll() {
		if(servicos.isEmpty()) {
			System.out.println("N�o existem Servi�os associados a esta Opera��o");
		}
		else {
			for(Servico s : servicos) {
				System.out.println(s.toString());
			}
		}
	}
	// ToString
	@Override
	public String toString() {
		return "Operacao [Nome = " + nome + "]";
	}
}