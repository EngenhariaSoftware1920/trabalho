package servicos;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import animais.Animal;
public class GestaoServico {
	private ArrayList<TipoConsulta> tiposConsulta;
	private ArrayList<Operacao> operacoes;
	private ArrayList<Consulta> consultas;
	public GestaoServico() {
		this.tiposConsulta = new ArrayList<>();
		this.operacoes = new ArrayList<>();
		this.consultas = new ArrayList<>();
	}
	// Tipos de Consulta
	public boolean insertTipoConsulta(String designacao) {
		if(this.searchTipoByDesignacao(designacao) != null) {
			return false;
		}
		else {
			tiposConsulta.add(new TipoConsulta(designacao));
			return true;
		}
	}
	public TipoConsulta searchTipoByDesignacao(String designacao) {
		int i = 0;
		while(i!=tiposConsulta.size() && !tiposConsulta.get(i).getDesignacao().equalsIgnoreCase(designacao)) {
			i++;
		}
		if(i == tiposConsulta.size()) {
			return null;
		}
		else return tiposConsulta.get(i);
	}
	public void printAllTipoConsulta() {
		if(tiposConsulta.isEmpty()) {
			System.out.println("Não existem Tipos de Consulta registados");
		}
		else {
			for(TipoConsulta tc : tiposConsulta) {
				System.out.println(tc.toString());
			}
		}
		
	}
	// Operacoes
	public boolean insertOperacao(String nome) {
		if(this.searchOperacaoByNome(nome) != null) {
			return false;
		}
		else {
			operacoes.add(new Operacao(nome));
			return true;
		}
	}
	public Operacao searchOperacaoByNome(String nome) {
		int i = 0;
		while(i!=operacoes.size() && !operacoes.get(i).getNome().equalsIgnoreCase(nome)) {
			i++;
		}
		if(i == operacoes.size()) {
			return null;
		}
		else return operacoes.get(i);
	}
	public void printAllOperacao() {
		if(operacoes.isEmpty()) {
			System.out.println("Não existem Tipos de Consulta registados");
		}
		else {
			for(Operacao o : operacoes) {
				System.out.println(o.toString());
			}
		}
	}
	// Consultas
	public void insertConsulta(TipoConsulta tipo, Animal animal, LocalDate data, LocalTime hora) {
		consultas.add(new Consulta(tipo, animal, data, hora));
	}
	public Consulta searchConsultaByCod(int codConsulta) {
		int i = 0;
		while(i!=consultas.size() && consultas.get(i).getCodConsulta() != codConsulta) {
			i++;
		}
		if(i == consultas.size()) {
			return null;
		}
		else return consultas.get(i);
	}
	public void printAllConsulta() {
		if(consultas.isEmpty()) {
			System.out.println("Não existem Tipos de Consulta registados");
		}
		else {
			for(Consulta c : consultas) {
				System.out.println(c.toString());		
			}
		}
	}
}