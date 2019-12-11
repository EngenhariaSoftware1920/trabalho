package main;
import colaboradores.GestaoColaborador;
public class Main {
	public static void main(String[] args) {
		GestaoColaborador manager = new GestaoColaborador();
		manager.insertColaborador("Veterinario", "Nome", "Rua", "Telefone", "Sabado", "Qualquer");
	}

}
