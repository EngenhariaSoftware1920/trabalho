package vacinas;

import java.util.*;

public class GestaoVacina {
	
	private ArrayList<Virus> virus;

	private ArrayList<Vacina> vacinas;

	public GestaoVacina() {
		vacinas=new ArrayList<Vacina>();
		virus=new ArrayList<Virus>();
	}

	public ArrayList<Virus> getVirus() {
		return virus;
	}

	public ArrayList<Vacina> getVacinas() {
		return vacinas;
	}

	public void adicionarVirus(Virus v) {
		if(searchVirus(v.getNome())==null) {
			virus.add(v);
		}
		else {
			System.out.println("Virus "+v.getNome()+" ja foi catalogado!");
		}		
	}
	
	public void adicionarVacina(Vacina v) {
		if(searchVacina(v.getNome())==null) {
			vacinas.add(v);
		}
		else {
			System.out.println("Vacina "+v.getNome()+" ja existe!");
		}
	}
	
	public void adicionarVirusVacina(String nomeVa,Virus v) {
		if(vacinas.size()==0) {
			System.out.println("Nao existem vacinas!");
		}
		else if(searchVacina(nomeVa)==null) {
			System.out.println("Vacina "+nomeVa+" nao existe!");
		}
		else if(virus.size()==0) {
			System.out.println("Nao existem virus!");			
		}
		else if(searchVirus(v.getNome())==null) {
			System.out.println("Virus "+v.getNome()+" nao existe!");
		}
		else {
			Vacina va=searchVacina(nomeVa);
			va.adicionarVirus(v);
		}
	}
	
	public void adicionarVacinaVirus(String nomeVi,Vacina v) {
		if(virus.size()==0) {
			System.out.println("Nao existem virus!");
		}
		else if(searchVirus(nomeVi)==null) {
			System.out.println("Virus "+nomeVi+" nao existe!");
		}
		else if(vacinas.size()==0) {
			System.out.println("Nao existem vacinas!");			
		}
		else if(searchVacina(v.getNome())==null) {
			System.out.println("Vacina "+v.getNome()+" nao existe!");
		}
		else {
			Virus vi=searchVirus(nomeVi);
			vi.adicionarVacina(v);
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
	
	public void printAllVirus() {
		if(virus.size()==0) {
			System.out.println("Nao existem virus!");
		}
		else {
			for(int i=0;i<virus.size();i++) {
				System.out.println(virus.get(i));
			}
		}
	}
	
	public void printAllVirusVacina(String nomeVa) {
		if(vacinas.size()==0) {
			System.out.println("Nao existem vacinas!");
		}
		else if(searchVacina(nomeVa)==null) {
			System.out.println("Vacina "+nomeVa+" nao existe!");
		}
		else {
			Vacina va=searchVacina(nomeVa);
			va.printAllVirus();
		}		
	}
	
	public void printAllVacinasVirus(String nomeVi) {
		if(virus.size()==0) {
			System.out.println("Nao existem virus!");
		}
		else if(searchVirus(nomeVi)==null) {
			System.out.println("Virus "+nomeVi+" nao existe!");
		}
		else {
			Virus vi=searchVirus(nomeVi);
			vi.printAllVacinas();
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
	
	public void procuraVirus(String nome) {
		if(virus.size()==0) {
			System.out.println("Nao existem virus!");
		}
		else if(searchVirus(nome)==null) {
			System.out.println("Virus "+nome+" nao existe!");
		}
		else {
			Virus v=searchVirus(nome);
			System.out.println("Detalhes do virus:");
			System.out.println(v);
		}
	}
	
	public void procuraVirusVacina(String nomeVa,String nomeVi) {
		if(vacinas.size()==0) {
			System.out.println("Nao existem vacinas!");
		}
		else if(searchVacina(nomeVa)==null) {
			System.out.println("Vacina "+nomeVa+" nao existe!");
		}
		else {
			Vacina va=searchVacina(nomeVa);
			va.procuraVirus(nomeVi);
		}		
	}
	
	public void procuraVacinasVirus(String nomeVi,String nomeVa) {
		if(virus.size()==0) {
			System.out.println("Nao existem virus!");
		}
		else if(searchVirus(nomeVi)==null) {
			System.out.println("Virus "+nomeVi+" nao existe!");
		}
		else {
			Virus vi=searchVirus(nomeVi);
			vi.procuraVacina(nomeVa);
		}			
	}
	
	public void printVirusAlfabeticamente() {
		if(virus.size()==0) {
			System.out.println("Nao existem virus!");
		}	
		else {
			ArrayList<Virus>virusClone=(ArrayList<Virus>) virus.clone();
			Collections.sort(virusClone, new Comparator<Virus>() {
				public int compare(Virus v1, Virus v2) {
					return String.valueOf(v1.getNome()).compareTo(v2.getNome());
				}
			});
			for(int i=0;i<virusClone.size();i++) {
				System.out.println(virusClone.get(i));
			}
		}
	}
	
	public void printVacinasAlfabeticamente() {
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
	
	public void printVirusVacinasAlfabeticamente(String nomeVa) {
		if(vacinas.size()==0) {
			System.out.println("Nao existem vacinas!");
		}
		else if(searchVacina(nomeVa)==null) {
			System.out.println("Vacina "+nomeVa+" nao existe!");
		}
		else {
			Vacina va=searchVacina(nomeVa);
			va.printAlfabeticamente();
		}			
	}
	
	public void printVacinasVirusAlfabeticamente(String nomeVi) {
		if(virus.size()==0) {
			System.out.println("Nao existem virus!");
		}
		else if(searchVirus(nomeVi)==null) {
			System.out.println("Virus "+nomeVi+" nao existe!");
		}
		else {
			Virus vi=searchVirus(nomeVi);
			vi.printAlfabeticamente();
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
	
	public void printPeriocidadeCrescenteVacinasVirus(String nomeVi) {
		if(virus.size()==0) {
			System.out.println("Nao existem virus!");
		}
		else if(searchVirus(nomeVi)==null) {
			System.out.println("Virus "+nomeVi+" nao existe!");
		}
		else {
			Virus vi=searchVirus(nomeVi);
			vi.printPeriocidadeCrescente();
		}			
	}
	
	private Virus searchVirus(String nome) {
		for(int i=0;i<virus.size();i++) {
			if(virus.get(i).getNome().equalsIgnoreCase(nome)) {
				return virus.get(i);
			}
		}
		return null;
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