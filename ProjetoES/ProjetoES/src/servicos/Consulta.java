package servicos;
import java.time.*;
import java.util.*;
import animais.Animal;
public class Consulta {
	private static int sequence = 0;
	private int codConsulta;
	private TipoConsulta tipo;
	private Animal animal;
	private LocalDate data;
	private LocalTime hora;
	private ArrayList<Servico> servicos;
	public Consulta(TipoConsulta tipo, Animal animal, LocalDate data, LocalTime hora) {
		this.codConsulta = ++sequence;
		this.tipo = tipo;
		this.animal = animal;
		this.data = data;
		this.hora = hora;
		servicos = new ArrayList<>();
	}
	public int getCodConsulta() {
		return codConsulta;
	}
	public TipoConsulta getTipo() {
		return tipo;
	}
	public void setTipo(TipoConsulta tipo) {
		this.tipo = tipo;
	}
	public Animal getAnimal() {
		return animal;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	// Servicos
	public boolean insertServico(Servico newS) {
		if(newS.getConsulta() != this) {
			return false;
		}
		else {
			servicos.add(newS);
			return true;
		}
	}
	public void printByOperacao(String nome) {
		if(servicos.isEmpty()) {
			System.out.println("Esta Consulta n�o se encontra associado a esta Opera��o");
		}
		else {
			for(Servico s : servicos) {
				if(s.getOperacao().getNome().equalsIgnoreCase(nome)) {
					System.out.println(s.toString());
				}
			}
		}
	}
	public void printByElementoEquipa(int codColaborador) {
		if(servicos.isEmpty()) {
			System.out.println("Este Colaborador n�o se encontra associado a esta Opera��o");
		}
		else {
			for(Servico s : servicos) {
				if(s.getEquipa().getCodColaborador() == codColaborador) {
					System.out.println(s.toString());
				}
			}
		}
	}
	public void printAll() {
		if(servicos.isEmpty()) {
			System.out.println("N�o existem Servi�os associados a esta Opera��o");
		}
		else {
			for(Servico s : servicos) {
				System.out.println(s.toString());
			}
		}
	}
	@Override
	public String toString() {
		String desTipo, codAnimal = null;
		if(tipo==null) {
			desTipo = "N�o Discriminado";
		}
		else desTipo = tipo.getDesignacao();
		if(animal==null) {
			codAnimal = "N�o Discriminado";
		}
		else codAnimal = String.valueOf(animal.getCodAnimal());
		return "Consulta [CodConsulta = " + codConsulta + ", Tipo de Consulta = " + desTipo + ", CodAnimal = " + codAnimal + ", Data = " + data + ", Hora = " + hora + "]";
	}
}