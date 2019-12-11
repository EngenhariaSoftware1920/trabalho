package colaboradores;
import java.util.HashMap;
import main.ReadOperation;
public class ControllerColaborador {
	private GestaoColaborador manager;
	private ReadOperation rO;
	private HashMap <Integer, String> diasSemana;
	public ControllerColaborador(ReadOperation rO) {
		this.manager = new GestaoColaborador();
		this.rO = rO;
		this.diasSemana = new HashMap<>();
		this.setDiasSemana();
	}
	public void insertColaborador() {
		String subclass = rO.readString("Introduza função do colaborador (V)eterinario // (A)ssistente // (L)impeza // (S)ecretario:");
		String nome = rO.readString("Introduza o nome do colaborador:");
		String morada = rO.readString("Introduza a morada do colaborador:");
		String telefone = null;
		do {
			telefone = rO.readString("Introduza o telefone do cliente:");
		}
		while(!telefone.matches("^[0-9]*$"));
		int diaFolga = -1;
		do {
			diaFolga = rO.readInt("Introduza o dia de folga do colaborador 1 - Domingo // 2 - Segunda // 3 - Terça // 4 - Quarta // 5 - Quinta // 6 - Sexta // 7 - Sábado:");
		}
		while(!diasSemana.keySet().contains(diaFolga));
		String att = rO.readString("Introduza informação do horario/urgência do colaborador:");
		manager.insertColaborador(subclass, nome, morada, telefone, diasSemana.get(diaFolga) ,att);
		System.out.println("Registo completado com sucesso");
	}
	public Colaborador searchColaboradorByCod() {
		int codColaborador = rO.readInt("Introduza código de colaborador a pesquisar:");
		return manager.searchColaboradorByCod(codColaborador);
	}
	public void printColaboradorByNome() {
		String nome = rO.readString("Introduza o nome do colaborador a pesquisar:");
		manager.printByNome(nome);
	}
	public void printAllColaborador() {
		manager.printAll();
	}
	private void setDiasSemana() {
		diasSemana.put(1, "Domingo");
		diasSemana.put(2, "Segunda");
		diasSemana.put(3, "Terça");
		diasSemana.put(4, "Quarta");
		diasSemana.put(5, "Quinta");
		diasSemana.put(6, "Sexta");
		diasSemana.put(7, "Sabádo");
	}
}
