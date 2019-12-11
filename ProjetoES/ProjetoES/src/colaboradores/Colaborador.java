package colaboradores;
// Classe abstrata que contém os elementos comuns a todos os Colaborarores da Clínica
public abstract class Colaborador {
	private static int sequence=0;
	protected int codColaborador;
	protected String nome;
	protected String morada;
	protected String telefone;
	protected String diaFolga;
	// Construtor
	public Colaborador(String nome, String morada, String telefone, String diaFolga) {
		this.codColaborador=++sequence;
		this.nome = nome;
		this.morada = morada;
		this.telefone = telefone;
		this.diaFolga = diaFolga;
	}
	// Gets e Sets
	public int getCodColaborador() {
		return codColaborador;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMorada() {
		return morada;
	}
	public void setMorada(String morada) {
		this.morada = morada;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getDiaFolga() {
		return diaFolga;
	}
	public void setDiaFolga(String diaFolga) {
		this.diaFolga = diaFolga;
	}
	// ToString
	@Override
	public String toString() {
		return "Colaborador [CodColaborador = " + codColaborador + ", Nome = " + nome + ", Morada = " + morada + ", Telefone = " + telefone + ", Dia de Folga = " + diaFolga + "]";
	}
}