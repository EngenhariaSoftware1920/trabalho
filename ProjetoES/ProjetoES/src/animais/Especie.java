package animais;
import java.util.*;
import colaboradores.EspecieVeterinario;
import vacinas.Vacina;
// Informação relativa às Especies relevantes
public class Especie {
	private String nome;
	private Genero genero;
	private ArrayList<EspecieVeterinario> veterinarios;
	private ArrayList<Vacina> vacinas;
	public Especie(String nome, Genero genero) {
		this.nome = nome;
		this.genero = genero;
		this.veterinarios = new ArrayList<>();
		this.vacinas = new ArrayList<>();
	}
	// Gets e Sets
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Genero getGenero() {
		return genero;
	}
	// Veterinários da Espécie
	public boolean insertEspecieVeterinario(EspecieVeterinario newEV) {
		if(this.searchByVeterinario(newEV.getVeterinario().getCodColaborador()) != null || newEV.getEspecie() != this) {
			return false;
		}
		else {
			veterinarios.add(newEV);
			return true;
		}
	}
	public EspecieVeterinario searchByVeterinario(int codColaborador) {
		int i = 0;
		while(i!=veterinarios.size() && veterinarios.get(i).getVeterinario().getCodColaborador() != codColaborador) {
			i++;
		}
		if(i == veterinarios.size()) {
			return null;
		}
		else return veterinarios.get(i);
	}
	public void printAll() {
		if(veterinarios.isEmpty()) {
			System.out.println("Não existem Veterinários associados a esta Espécie");
		}
		else {
			for (EspecieVeterinario ev : veterinarios) {
				System.out.println(ev.toString());
			}
		}
	}
	// Vacinas da Espécie
	public boolean insertVacina(Vacina newV) {
		if(searchVacinaByNome(newV.getNome()) != null) {
			return false;
		}
		else {
			vacinas.add(newV);
			return true;
		}
	}
	public Vacina searchVacinaByNome(String nome) {
		int i = 0;
		while(i!=vacinas.size() && !vacinas.get(i).getNome().equalsIgnoreCase(nome)) {
			i++;
		}
		if(i == vacinas.size()) {
			return null;
		}
		else return vacinas.get(i);
	}
	public void printAllVacina() {
		if(veterinarios.isEmpty()) {
			System.out.println("Não existem Vacinas asssociadas a esta Espécie");
		}
		else {
			for(Vacina v : vacinas) {
				System.out.println(v.toString());
			}
		}
	}
	// ToString
	@Override
	public String toString() {
		String desGenero = null;
		if(genero==null) {
			desGenero = "Não Discriminado";
		}
		else desGenero = genero.getDesignacao();
		return "Especie [Nome = " + nome + ", Género = " + desGenero + "]";
	}
}