package clientes;
import java.time.LocalDate;

import animais.Animal;
public class ClienteAnimal {
	private Animal animal;
	private Cliente cliente;
	private LocalDate dataCompra;
	private LocalDate dataVenda;
	public ClienteAnimal(Animal animal, Cliente cliente, LocalDate dataCompra) {
		this.animal = animal;
		this.cliente = cliente;
		this.dataCompra=dataCompra;
		this.dataVenda = null;
	}
	public Animal getAnimal() {
		return animal;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public LocalDate getDataCompra() {
		return dataCompra;
	}
	public LocalDate getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}
	@Override
	public String toString() {
		String codAnimal, codCliente = null;
		if(animal==null) {
			codAnimal = "Não Discriminado";
		}
		else codAnimal = String.valueOf(animal.getCodAnimal());
		if(cliente==null) {
			codCliente = "Não Discriminado";
		}
		else codCliente = String.valueOf(cliente.getCodCliente());
		return "ClienteAnimal [CodAnimal = " + codAnimal + ", CodCliente = " + codCliente + ", Data de Compra = " + dataCompra + ", Data de Venda = " + dataVenda + "]";
	}
	
}