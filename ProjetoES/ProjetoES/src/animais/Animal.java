package animais;
import java.time.LocalDate;
import java.util.*;

import clientes.ClienteAnimal;
import colaboradores.Veterinario;
// Informação dos Animais com histórico na Clínica
public class Animal {
	private static int sequence=0;
	private int codAnimal;
	private String nome;
	private Veterinario veterinario;
	private Especie especie;
	private String sexo;
	private LocalDate dataNascimento;
	private ArrayList<String> antecClinicos;
	private ArrayList<ClienteAnimal> proprietarios;
	public Animal (String nome, Especie especie, String sexo, LocalDate dataNascimento) {
		this.nome=nome;
		this.codAnimal = ++sequence;
		this.veterinario = null;
		this.especie = especie;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		antecClinicos = new ArrayList<>();
		proprietarios = new ArrayList<>();
	}
	// Gets e Sets
	public int getCodAnimal() {
		return codAnimal;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Veterinario getVeterinario() {
		return veterinario;
	}
	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}
	public Especie getEspecie() {
		return especie;
	}
	public String getSexo() {
		return sexo;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	// Antecedentes Clínicos - Vários antecedentes clínicos
	public boolean insertAntecClinicos(String newAntec) {
		if(antecClinicos.contains(newAntec)) {
			return false;
		}
		else {
			antecClinicos.add(newAntec);
			return true;
		}
	}
	public void printAntecClinicos() {
		if(antecClinicos.isEmpty()) {
			System.out.println("Não existem Antecedentes Clínicos registados");
		}
		else {
			for(String s : antecClinicos) {
				System.out.println(s);
			}
		}
	}
	// Proprietários - Cada Animal tem muito donos e pode ter o mesmo dono mais do que uma vez
	public boolean insertClienteAnimal(ClienteAnimal newCA) {
		if(newCA.getAnimal() != this) {
			return false;
		}
		else {
			proprietarios.add(newCA);
			return true;
		}
	}
	public void printByCliente(int codCliente) {
		for(ClienteAnimal ca : proprietarios) {
			if(ca.getCliente().getCodCliente() == codCliente) {
				System.out.println(ca.toString());
			}
		}
	}
	public void printAll() {
		if(proprietarios.isEmpty()) {
			System.out.println("Não existem Proprietários associados a este Animal");
		}
		else {
			for(ClienteAnimal ca : proprietarios) {
				System.out.println(ca.toString());
			}
		}	
	}
	// ToString
	@Override
	public String toString() {
		String codVeterinario, nEspecie = null;
		if(veterinario==null) {
			codVeterinario = "Não Discriminado";
		}
		else codVeterinario = String.valueOf(veterinario.getCodColaborador());
		if(especie==null) {
			nEspecie = "Não Discriminado";
		}
		else nEspecie = especie.getNome();
		return "Animal [CodAnimal = " + codAnimal + ", Nome = " + nome + ", CodVeterinário = " + codVeterinario + ", Espécie = " + nEspecie + ", Sexo = " + sexo + ", Data de Nascimento = " + dataNascimento + "]";
	}
}