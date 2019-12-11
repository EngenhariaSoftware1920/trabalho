package colaboradores;
// Classe dedicada para a criação de novos Colaborares
public class ColaboradorFactory{
	private static ColaboradorFactory single_instance;
	// Private Construtor - Singleton Pattern
	private ColaboradorFactory() {}
	public static ColaboradorFactory getInstance() {
		if(single_instance==null) {
			return new ColaboradorFactory();
		}
		else return single_instance;
	}
	// Novos de Colaboradores
	public Colaborador buildColaborador(String subclass, String nome, String morada, String telefone, String diaFolga, String att) {
		if(subclass.equalsIgnoreCase("V")) {
			return this.buildVeterinario(nome, morada, telefone, diaFolga, att);
		}
		else if(subclass.equalsIgnoreCase("A")){
			return this.buildAssistente(nome, morada, telefone, diaFolga, att);
		}
		else if(subclass.equalsIgnoreCase("S")) {
			return this.buildSecretariado(nome, morada, telefone, diaFolga, att);
		}
		else if(subclass.equalsIgnoreCase("L")) {
			return this.buildLimpeza(nome, morada, telefone, diaFolga, att);
		}
		else return null;
	}
	public Colaborador buildVeterinario(String nome, String morada, String telefone, String diaFolga, String att) {
		return new Veterinario(nome, morada, telefone, diaFolga, att);
	}
	public Colaborador buildAssistente(String nome, String morada, String telefone, String diaFolga, String att) {
		return new Assistente(nome, morada, telefone, diaFolga, att);
	}
	public Colaborador buildSecretariado(String nome, String morada, String telefone, String diaFolga, String att) {
		return new Secretariado(nome, morada, telefone, diaFolga, att);
	}
	public Colaborador buildLimpeza(String nome, String morada, String telefone, String diaFolga, String att) {
		return new Limpeza(nome, morada, telefone, diaFolga, att);
	}
}