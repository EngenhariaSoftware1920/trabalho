package clientes;
import java.util.*;
public class GestaoCliente {
	private ArrayList<Cliente> clientes;
	public GestaoCliente() {
		clientes = new ArrayList<>();
	}
	public void insertCliente(String nome, String morada, String telefone) {
		clientes.add(new Cliente(nome, morada, telefone));
	}
	public Cliente searchClienteByCod(int codCliente) {
		int i = 0;
		while(i!=clientes.size() && clientes.get(i).getCodCliente() != codCliente) {
			i++;
		}
		if(i == clientes.size()) {
			return null;
		}
		else return clientes.get(i);
	}
	public void printByNome(String nome) {
		if(clientes.isEmpty()) {
			System.out.println("Não existem Clientes registados com o nome fornecido");
		}
		else {
			for(Cliente c: clientes) {
				if(c.getNome().equalsIgnoreCase(nome)) {
					System.out.println(c.toString());
				}
			}
		}	
	}
	public void printAll() {
		if(clientes.isEmpty()) {
			System.out.println("Não existem Clientes registados");
		}
		else {
			for(Cliente c: clientes) {
				System.out.println(c.toString());
			}
		}	
	}
	// Outros
	public boolean isEmptyString(String text) {
		return text.length()<=0;
	}
}