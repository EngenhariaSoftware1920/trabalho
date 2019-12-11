package vacinas;
import java.util.*;
public class Vacina {
	
	private String nome;
	private int periodicidade;
	private ArrayList<Virus>virus;
	
	public Vacina(String nome,int periocidade) {
		this.nome=nome;
		this.periodicidade=periocidade;
		virus=new ArrayList<Virus>();
	}

	public String getNome() {
		return nome;
	}
	
	public int getPeriodicidade() {
		return periodicidade;
	}

	public ArrayList<Virus> getVirus() {
		return virus;
	}

	@Override
	public String toString() {
		return "Vacina-> Nome = " + nome + "||Periodicidade = " + periodicidade;
	}
	
	public void adicionarVirus(Virus v) {
		if(searchVirus(v.getNome())==null) {
			virus.add(v);
		}
		else {
			System.out.println("Virus "+v.getNome()+" ja foi catalogado!");
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
	
	public void printAlfabeticamente() {
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
	
	private Virus searchVirus(String nome) {
		for(int i=0;i<virus.size();i++) {
			if(virus.get(i).getNome().equalsIgnoreCase(nome)) {
				return virus.get(i);
			}
		}
		return null;
	}
}