package clientes;
import main.ReadOperation;
public class ControllerCliente {
	private GestaoCliente manager;
	private ReadOperation rO;
	public ControllerCliente(ReadOperation rO) {
		this.manager = new GestaoCliente();
		this.rO = rO;
	}
	public void insertCliente() {
		String nome = rO.readString("Introduza o nome do cliente:");
		String morada = rO.readString("Introduza a morada do cliente:");
		String telefone = null;
		do {
			telefone = rO.readString("Introduza o telefone do cliente:");
		}
		while(!telefone.matches("^[0-9]*$"));
		manager.insertCliente(nome, morada, telefone);
		System.out.println("Registo completado com sucesso");
	}
	public Cliente searchClienteByCod() {
		int codColaborador = rO.readInt("Introduza código do cliente:");
		return manager.searchClienteByCod(codColaborador);
	}
	public void printAllCliente() {
		manager.printAll();
	}
}
