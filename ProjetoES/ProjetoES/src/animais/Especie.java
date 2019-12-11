package animais;
import java.util.*;
import colaboradores.EspecieVeterinario;
import vacinas.Vacina;
// Informa��o relativa �s Especies relevantes
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
	// Veterin�rios da Esp�cie
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
			System.out.println("N�o existem Veterin�rios associados a esta Esp�cie");
		}
		else {
			for (EspecieVeterinario ev : veterinarios) {
				System.out.println(ev.toString());
			}
		}
	}
	// Vacinas da Esp�cie
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
			System.out.println("N�o existem Vacinas asssociadas a esta Esp�cie");
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
			desGenero = "N�o Discriminado";
		}
		else desGenero = genero.getDesignacao();
		return "Especie [Nome = " + nome + ", G�nero = " + desGenero + "]";
	}
}