package vacinas;

import java.util.*;

public class Virus {

	private String nome;
	private ArrayList<Vacina> vacinas;
	
	public Virus(String nome) {
		this.nome=nome;
		vacinas=new ArrayList<Vacina>();
	}
	
	public String getNome() {
		return nome;
	}

	public ArrayList<Vacina> getVacinas() {
		return vacinas;
	}

	@Override
	public String toString() {
		return "Virus-> Nome = " + nome;
	}

	public void adicionarVacina(Vacina v) {
		if(searchVacina(v.getNome())==null) {
			vacinas.add(v);
		}
		else {
			System.out.println("Vacina "+v.getNome()+" ja existe!");
		}
	}
	
	public void printAllVacinas() {
		if(vacinas.size()==0) {
			System.out.println("Nao existem vacinas!");
		}
		else {
			for(int i=0;i<vacinas.size();i++) {
				System.out.println(vacinas.get(i));
			}
		}
	}
	
	public void procuraVacina(String nome) {
		if(vacinas.size()==0) {
			System.out.println("Nao existem vacinas!");
		}
		else if(searchVacina(nome)==null) {
			System.out.println("Vacina "+nome+" nao existe!");
		}
		else {
			Vacina v=searchVacina(nome);
			System.out.println("Detalhes da vacina:");
			System.out.println(v);
		}
	}
	
	public void printAlfabeticamente() {
		if(vacinas.size()==0) {
			System.out.println("Nao existem vacinas!");
		}	
		else {
			ArrayList<Vacina>vacinasClone=(ArrayList<Vacina>) vacinas.clone();
			Collections.sort(vacinasClone, new Comparator<Vacina>() {
				public int compare(Vacina v1, Vacina v2) {
					return String.valueOf(v1.getNome()).compareTo(v2.getNome());
				}	
			});
			for(int i=0;i<vacinasClone.size();i++) {
				System.out.println(vacinasClone.get(i));
			}
		}
	}
	
	public void printPeriocidadeCrescente() {
		if(vacinas.size()==0) {
			System.out.println("Nao existem vacinas!");
		}	
		else {
			ArrayList<Vacina>vacinasClone=(ArrayList<Vacina>) vacinas.clone();
			Collections.sort(vacinasClone, new Comparator<Vacina>() {
				public int compare(Vacina v1, Vacina v2) {
					return Integer.valueOf(v1.getPeriodicidade()).compareTo(v2.getPeriodicidade());
				}	
			});
			for(int i=0;i<vacinasClone.size();i++) {
				System.out.println(vacinasClone.get(i));
			}
		}
	}
	
	private Vacina searchVacina(String nome) {
		for(int i=0;i<vacinas.size();i++) {
			if(vacinas.get(i).getNome().equalsIgnoreCase(nome)) {
				return vacinas.get(i);
			}
		}
		return null;
	}
}