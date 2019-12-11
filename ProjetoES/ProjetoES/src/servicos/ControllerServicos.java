package servicos;
import java.time.LocalDate;
import java.time.LocalTime;
import animais.Animal;
import main.ReadOperation;
public class ControllerServicos {
	private GestaoServico manager;
	private ReadOperation rO;
	public ControllerServicos(ReadOperation rO) {
		manager = new GestaoServico();
		this.rO = rO;
	}
	// Tipo Consulta
	public void insertTipoConsulta() {
		String designacao = rO.readString("Introduza a designação:");
		if(manager.insertTipoConsulta(designacao)) {
			System.out.println("Registo completado com sucesso");
		}
		else System.out.println("Não foi possível inserir o registo");	
	}
	public TipoConsulta searchTipoByDesignacao() {
		String designacao = rO.readString("Introduza a designação:");
		return manager.searchTipoByDesignacao(designacao);
	}
	public void printAllTipo() {
		manager.printAllTipoConsulta();
	}
	// Operação
	public void insertOperacao() {
		String nome = rO.readString("Introduza o nome:");
		if(manager.insertOperacao(nome)) {
			System.out.println("Registo completado com sucesso");
		}
		else System.out.println("Não foi possível inserir o registo");
	}
	public Operacao searchOperacaoByDesignacao() {
		String nome = rO.readString("Introduza o nome:");
		return manager.searchOperacaoByNome(nome);
	}
	public void printAllOperacao() {
		manager.printAllOperacao();
	}
	// Consulta
	public void insertConsulta(Animal a) {
		TipoConsulta tp = null;
		while(tp == null) {
			String designacao = rO.readString("Introduza a designacao do tipo de consulta:");
			tp = manager.searchTipoByDesignacao(designacao);
			if(tp == null) {
				System.out.println("Espécie não encontrada!");
			}
		}
		LocalDate data = null;
		do {
			data = rO.readDate("Introduza Data YYYY-MM-DD:");
		}
		while(data.isBefore(LocalDate.now()));
		LocalTime time = null;
		do {
			time = rO.readTime("Introduza Hora HH-MM:");
		}
		while(data.isBefore(LocalDate.now()));
		while(!timeInRange(time));
		manager.insertConsulta(tp, a, data, time);
		System.out.println("Registo completado com sucesso");
	}
	public Consulta searchConsultaByCod() {
		int codConsulta = rO.readInt("Introduza código da consulta:");
		return manager.searchConsultaByCod(codConsulta);
	}
	public void printAllConsulta() {
		manager.printAllConsulta();
	}
	private boolean timeInRange(LocalTime hora) {
		// Abertura da Clínica
		LocalTime opening = LocalTime.of(8,0);
		// Fecho da Clínica
		LocalTime closing = LocalTime.of(19,0);
		return hora.isAfter(opening) && hora.isBefore(closing) ;
	}
}
