package colaboradores;
//Informa��o relativa aos funcion�rios da Secretaria empregues pela Cl�nica 
public class Secretariado extends Colaborador {
	private String horario;
	// Construtor
	public Secretariado(String nome, String morada, String telefone, String diaFolga, String horario) {
		super(nome, morada, telefone, diaFolga);
		this.horario=horario;
	}
	// ToString
	@Override
	public String toString() {
		return "Limpeza [CodColaborador = " + codColaborador + ", Nome = " + nome + ", Morada = " + morada + ", Telefone = " + telefone + ", Dia de Folga = " + diaFolga + ", Hor�rio = " + horario + "]";
	}
}