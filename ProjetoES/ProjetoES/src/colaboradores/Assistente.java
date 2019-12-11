package colaboradores;
// Informação relativa aos Assistentes empregues pela Clínica 
public class Assistente extends ElementoEquipa {
	public Assistente(String nome, String morada, String telefone, String diaFolga, String urgencias) {
		super(nome, morada, telefone, diaFolga, urgencias);
	}
	@Override
	public String toString() {
		return "Assistente [CodColaborador = " + codColaborador + ", Nome = " + nome + ", Morada = " + morada + ", Telefone = " + telefone + ", Dia de Folga = " + diaFolga + ", Urgências = " + urgencias + "]";
	}
}