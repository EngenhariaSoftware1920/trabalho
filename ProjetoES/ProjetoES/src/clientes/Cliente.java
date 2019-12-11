package clientes;
import java.util.*;
public class Cliente {
	private static int sequence = 0;
	private int codCliente;
	private String nome;
	private String morada;
	private String telefone;
	private boolean proprietario;
	private ArrayList<ClienteAnimal> animais;
	// Construtor
	public Cliente(String nome, String morada, String telefone) {
		this.codCliente = ++sequence;
		this.nome = nome;
		this.morada = morada;
		this.telefone = telefone;
		this.proprietario = false;
		this.animais = new ArrayList<>();
	}
	// Gets e Sets
	public int getCodCliente() {
		return codCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMorada() {
		return morada;
	}
	public void setMorada(String morada) {
		this.morada = morada;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public boolean isProprietario() {
		return proprietario;
	}
	// Animais - Cliente pode ter vários Animais e pode ter o mesmo Animal mais do que uma vez
	public boolean insertClienteAnimal(ClienteAnimal newCA) {
		if(newCA.getCliente() != this) {
			return false;
		}
		else {
			animais.add(newCA);
			return true;
		}
	}
	public void printByAnimal(int codAnimal) {
		if(animais.isEmpty()) {
			System.out.println("Não existem Animais associados a este Cliente com este código");
		}
		else {
			for(ClienteAnimal ca : animais) {
				if(ca.getAnimal().getCodAnimal() == codAnimal) {
					System.out.println(ca.toString());
				}
			}
		}	
	}
	public void printAll() {
		if(animais.isEmpty()) {
			System.out.println("Não existem Animais associados a este Cliente");
		}
		else {
			for(ClienteAnimal ca : animais) {
				System.out.println(ca.toString());
			}
		}	
	}
	// ToString
	@Override
	public String toString() {
		return "Cliente [CodCliente = " + codCliente + ", Nome = " + nome + ", Morada = " + morada + ", Telefone = " + telefone + ", Proprietário = " + proprietario + "]";
	}
}