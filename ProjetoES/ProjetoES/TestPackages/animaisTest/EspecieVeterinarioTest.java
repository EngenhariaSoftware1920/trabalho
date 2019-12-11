package animaisTest;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import animais.Especie;
import animais.Genero;
import colaboradores.EspecieVeterinario;
import colaboradores.Veterinario;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EspecieVeterinarioTest {
	private Genero g;
	private Especie e;
	private Veterinario v;
	@BeforeAll
	void globalSetup() {
		g = new Genero(randomNome());	
	}
	@BeforeEach
	void setup() {
		e = new Especie(randomNome(), g);
		v = new Veterinario(randomNome(), "Morada", "911111111", "Sabado", "True");
	}
	@Test
	void valuesTest() {
		Especie newE = new Especie(randomNome(), g);
		EspecieVeterinario aux = new EspecieVeterinario(newE, v, true);
		assertFalse(e.insertEspecieVeterinario(aux));
		aux = new EspecieVeterinario(e, v, true);
		assertTrue(e.insertEspecieVeterinario(aux));
	}
	@RepeatedTest(5)
	void insertTest() {
		EspecieVeterinario aux = new EspecieVeterinario(e, v, true);
		assertTrue(e.insertEspecieVeterinario(aux));
	}
	private String randomNome() {
		return "Nome" + ThreadLocalRandom.current().nextInt(0,1000);
	}
}
