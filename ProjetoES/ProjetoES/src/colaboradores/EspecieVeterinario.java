package colaboradores;
import animais.Especie;
public class EspecieVeterinario {
	private Especie especie;
	private Veterinario veterinario;
	private boolean preferencia;
	public EspecieVeterinario(Especie especie, Veterinario veterinario, boolean preferencia) {
		this.especie = especie;
		this.veterinario = veterinario;
		this.preferencia = preferencia;
	}
	public Especie getEspecie() {
		return especie;
	}
	public Veterinario getVeterinario() {
		return veterinario;
	}
	public boolean getPreferencia() {
		return preferencia;
	}
	public void setPreferencia(boolean preferencia) {
		this.preferencia = preferencia;
	}
	@Override
	public String toString() {
		String nEspecie, codVeterinario = null;
		if(especie==null) {
			nEspecie = "N�o Discriminado";
		}
		else nEspecie = especie.getNome();
		if(veterinario==null) {
			codVeterinario = "N�o Discriminado";
		}
		else codVeterinario = String.valueOf(veterinario.getCodColaborador());
		return "EspecieVeterinario [Esp�cie = " + nEspecie + ", CodVeterinario = " + codVeterinario + ", Prefer�ncia = " + preferencia + "]";
	}
	
}