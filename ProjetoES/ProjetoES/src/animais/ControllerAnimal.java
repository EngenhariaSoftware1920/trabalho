package animais;
import java.time.LocalDate;
import main.ReadOperation;
public class ControllerAnimal {
	private GestaoAnimal manager;
	private ReadOperation rO;
	public ControllerAnimal(ReadOperation rO) {
		this.manager = new GestaoAnimal();
		this.rO = rO;
	}
	// Animal
	public void insertAnimal() {
		String nome = rO.readString("Introduza o nome do Animal:");
		Especie especie = null;
		while(especie == null) {
			String nomeE = rO.readString("Introduza o nome da Especie:");
			especie = manager.searchEspecieByNome(nomeE);
			if(especie == null) {
				System.out.println("Espécie não encontrada!");
			}
		}
		String sexo = "";
		do {
			sexo = rO.readString("Introduza o sexo (M)acho // (F)emea // (O)utro: ");
		}
		while(!sexo.equals("M") && !sexo.equals("F") && !sexo.equals("O"));
		LocalDate dataNascimento = null;
		do {
			dataNascimento = rO.readDate("Introduza Data de Nascimento YYYY-MM-DD:");
		}
		while(dataNascimento.isAfter(LocalDate.now()));
		manager.insertAnimal(nome, especie, sexo, dataNascimento);
		System.out.println("Registo completado com sucesso!");
	}
	public Animal searchAnimalByCod() {
		int codAnimal = rO.readInt("Introduza código do Animal a pesquisar:");
		Animal aux = manager.searchAnimalByCod(codAnimal);
		return aux;
	}
	public void printAllAnimal() {
		manager.printAllAnimal();
	}
	public void insertAntecClínicos(Animal a) {
		boolean flag = true;
		do {
			String antecClinico = rO.readString("Introduza novo antecedente clínico:");
			if(!a.insertAntecClinicos(antecClinico)) {
				System.out.println("Não foi possível completar o registo do antecedente clínico");
				flag = false;
			}
			else {
				System.out.println("Registo introduzido com sucesso");
			}
		}
		while(rO.readInt("Deseja continuar? (1-Continuar // 0-Sair)") != 0  && flag);
	}
	public void printAllAntecClinicos(Animal a) {
		a.printAntecClinicos();
	}
	// Espécie
	public void insertEspecie() {
		String nome = rO.readString("Introduza o nome do Espécie:");
		Genero genero = null;
		while(genero == null) {
			String nomeG = rO.readString("Introduza o nome do Género:");
			genero = manager.searchGeneroByDesignacao(nomeG);
			if(genero == null) {
				System.out.println("Espécie não encontrada!");
			}
		}
		if(!manager.insertEspecie(nome, genero)) {
			System.out.println("Não foi possível completar o registo da Especie!");
		}
		else {
			System.out.println("Registo completado com sucesso!");
		}
	}
	public Especie searchEspecieByNome() {
		String nome = rO.readString("Introduza nome da espécie a pesquisar:");
		return manager.searchEspecieByNome(nome);
	}
	public void printAllEspecie() {
		manager.printAllEspecie();
	}
	// Género
	public void insertGenero() {
		String designacao = rO.readString("Introduza designação:");
		if(!manager.insertGenero(designacao)) {
			System.out.println("Não foi possível completar o registo do Género!");
		}
		else {
			System.out.println("Registo completado com sucesso!");
		}
	}
	public Genero searchGeneroByDesignacao() {
		String designacao = rO.readString("Introduza designação a pesquisar:");
		return manager.searchGeneroByDesignacao(designacao);
	}
	public void printAllGenero() {
		manager.printAllGenero();
	}
}
