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
				System.out.println("Esp�cie n�o encontrada!");
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
		int codAnimal = rO.readInt("Introduza c�digo do Animal a pesquisar:");
		Animal aux = manager.searchAnimalByCod(codAnimal);
		return aux;
	}
	public void printAllAnimal() {
		manager.printAllAnimal();
	}
	public void insertAntecCl�nicos(Animal a) {
		boolean flag = true;
		do {
			String antecClinico = rO.readString("Introduza novo antecedente cl�nico:");
			if(!a.insertAntecClinicos(antecClinico)) {
				System.out.println("N�o foi poss�vel completar o registo do antecedente cl�nico");
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
	// Esp�cie
	public void insertEspecie() {
		String nome = rO.readString("Introduza o nome do Esp�cie:");
		Genero genero = null;
		while(genero == null) {
			String nomeG = rO.readString("Introduza o nome do G�nero:");
			genero = manager.searchGeneroByDesignacao(nomeG);
			if(genero == null) {
				System.out.println("Esp�cie n�o encontrada!");
			}
		}
		if(!manager.insertEspecie(nome, genero)) {
			System.out.println("N�o foi poss�vel completar o registo da Especie!");
		}
		else {
			System.out.println("Registo completado com sucesso!");
		}
	}
	public Especie searchEspecieByNome() {
		String nome = rO.readString("Introduza nome da esp�cie a pesquisar:");
		return manager.searchEspecieByNome(nome);
	}
	public void printAllEspecie() {
		manager.printAllEspecie();
	}
	// G�nero
	public void insertGenero() {
		String designacao = rO.readString("Introduza designa��o:");
		if(!manager.insertGenero(designacao)) {
			System.out.println("N�o foi poss�vel completar o registo do G�nero!");
		}
		else {
			System.out.println("Registo completado com sucesso!");
		}
	}
	public Genero searchGeneroByDesignacao() {
		String designacao = rO.readString("Introduza designa��o a pesquisar:");
		return manager.searchGeneroByDesignacao(designacao);
	}
	public void printAllGenero() {
		manager.printAllGenero();
	}
}
