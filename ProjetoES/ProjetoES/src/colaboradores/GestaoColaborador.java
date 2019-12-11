package colaboradores;
import java.util.*;
public class GestaoColaborador {
	private ColaboradorFactory factory;
	private ArrayList<Colaborador> colaboradores;
	public GestaoColaborador() {
		this.factory = ColaboradorFactory.getInstance();
		colaboradores = new ArrayList<>();
	}
	public boolean insertColaborador(String subclass, String nome, String morada, String telefone, String diaFolga, String att) {
		Colaborador newC = factory.buildColaborador(subclass, nome, morada, telefone, diaFolga, att);
		if(newC == null) {
			return false;
		}
		else {
			colaboradores.add(newC);
			return true;
		}
	}
	public Colaborador searchColaboradorByCod(int codColaborador) {
		int i = 0;
		while(i!=colaboradores.size() && colaboradores.get(i).getCodColaborador() != codColaborador) {
			i++;
		}
		if(i == colaboradores.size()) {
			return null;
		}
		else return colaboradores.get(i);
	}
	public void printByNome(String nome) {
		if(colaboradores.isEmpty()) {
			System.out.println("Não existem colaboradores registados");
		}
		else {
			for(Colaborador c : colaboradores) {
				if(c.getNome().equalsIgnoreCase(nome)) {
					System.out.println(c.toString());
				}
			}
		}
	}
	public void printAll() {
		if(colaboradores.isEmpty()) {
			System.out.println("Não existem colaboradores registados");
		}
		else {
			for(Colaborador c : colaboradores) {
				System.out.println(c.toString());
			}
		}
	}
	public ArrayList<Veterinario> getVeterinarios(){
		ArrayList<Veterinario> aux = new ArrayList<>();
		for(Colaborador c : colaboradores) {
			if(c instanceof Veterinario) {
				aux.add((Veterinario)c);
			}
		}
		return aux;
	}
	public ArrayList<Assistente> getAssistentes(){
		ArrayList<Assistente> aux = new ArrayList<>();
		for(Colaborador c : colaboradores) {
			if(c instanceof Assistente) {
				aux.add((Assistente)c);
			}
		}
		return aux;
	}
	public ArrayList<Limpeza> getLimpeza(){
		ArrayList<Limpeza> aux = new ArrayList<>();
		for(Colaborador c : colaboradores) {
			if(c instanceof Limpeza) {
				aux.add((Limpeza)c);
			}
		}
		return aux;
	}
	public ArrayList<Secretariado> getSecretariado(){
		ArrayList<Secretariado> aux = new ArrayList<>();
		for(Colaborador c : colaboradores) {
			if(c instanceof Secretariado) {
				aux.add((Secretariado)c);
			}
		}
		return aux;
	}
}