package colaboradores;
import java.util.*;
//Informa��o relativa aos Assistentes empregues pela Cl�nica 
public class Veterinario extends ElementoEquipa {
	private ArrayList<EspecieVeterinario> especies;
	// Construtor
	public Veterinario(String nome, String morada, String telefone, String diaFolga, String urgencias) {
		super(nome, morada, telefone, diaFolga, urgencias);
		this.especies = new ArrayList<EspecieVeterinario>();
	}
	// Especies associadas ao Veterin�rio
	public boolean insertEspecie(EspecieVeterinario newEV) {
		if(this.searchByEspecie(newEV.getEspecie().getNome()) != null || newEV.getVeterinario() != this) {
			return false;
		}
		else {
			especies.add(newEV);
			return true;
		}
	}
	public EspecieVeterinario searchByEspecie(String nome) {
		int i = 0;
		while(i!=especies.size() && !especies.get(i).getEspecie().getNome().equalsIgnoreCase(nome)) {
			i++;
		}
		if(i == especies.size()) {
			return null;
		}
		else return especies.get(i);
	}
	public void printPrefer�ncias() {
		if(especies.isEmpty()) {
			System.out.println("N�o existem Esp�cies associadas a este Veterin�rio");
		}
		else {
			for (EspecieVeterinario ev : especies) {
				if(ev.getPreferencia() == true) {
					System.out.println(ev.toString());
				}
			}
		}
	}
	public void printAll() {
		if(especies.isEmpty()) {
			System.out.println("N�o existem Esp�cies associadas a este Veterin�rio");
		}
		else {
			for (EspecieVeterinario ev : especies) {
				System.out.println(ev.toString());
			}
		}
	}
	@Override
	public String toString() {
		return "Veterinario [CodColaborador = " + codColaborador + ", Nome = " + nome + ", Morada = " + morada + ", Telefone = " + telefone + ", Dia de Folga = " + diaFolga + "Urg�ncias = " + urgencias + "]";
	}
	
}