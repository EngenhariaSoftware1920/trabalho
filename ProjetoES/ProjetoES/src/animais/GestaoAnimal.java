package animais;
import java.time.LocalDate;
import java.util.*;
// Manutenção dos registos das classes associadas com a informação dos Animais
public class GestaoAnimal {
	private ArrayList<Animal> animal;
	private ArrayList<Especie> especie;
	private ArrayList<Genero> genero;
	public GestaoAnimal() {
		animal = new ArrayList<>();
		especie = new ArrayList<>();
		genero = new ArrayList<>();
	}
	// Animais
	public void insertAnimal(String nome, Especie e, String sexo, LocalDate dataNascimento) {
		animal.add(new Animal(nome, e, sexo, dataNascimento));
	}
	public Animal searchAnimalByCod(int codAnimal) {
		int i = 0;
		while(i!=animal.size() && animal.get(i).getCodAnimal() != codAnimal) {
			i++;
		}
		if(i == animal.size()) {
			return null;
		}
		else return animal.get(i);
	}
	public void printAllAnimal() {
		if(animal.isEmpty()) {
			System.out.println("Não existem Animais registados");
		}
		else {
			for(Animal a : animal) {
				System.out.println(a.toString());
			}
		}
	}
	// Especies
	public boolean insertEspecie(String nome, Genero g) {
		if(this.searchEspecieByNome(nome)!=null) {
			return false;
		}
		else {
			especie.add(new Especie(nome, g));
			return true;
		}
	}
	public Especie searchEspecieByNome(String nome) {
		int i = 0;
		while(i!=especie.size() && !especie.get(i).getNome().equals(nome)) {
			i++;
		}
		if(i == especie.size()) {
			return null;
		}
		else return especie.get(i);
	}
	public void printAllEspecie() {
		if(especie.isEmpty()) {
			System.out.println("Não existem colaboradores registados");
		}
		else {
			for(Especie e : especie) {
				System.out.println(e.toString());
			}
		}
	}
	// Generos
	public boolean insertGenero(String designacao) {
		if(this.searchGeneroByDesignacao(designacao)!=null) {
			return false;
		}
		else {
			genero.add(new Genero(designacao));
			return true;
		}
	}
	public Genero searchGeneroByDesignacao(String designacao) {
		int i = 0;
		while(i!=genero.size() && !genero.get(i).getDesignacao().equals(designacao)) {
			i++;
		}
		if(i == genero.size()) {
			return null;
		}
		else return genero.get(i);
	}
	public void printAllGenero() {
		if(genero.isEmpty()) {
			System.out.println("Não existem colaboradores registados");
		}
		else {
			for(Genero g: genero) {
				System.out.println(g.toString());
			}
		}
	}
}