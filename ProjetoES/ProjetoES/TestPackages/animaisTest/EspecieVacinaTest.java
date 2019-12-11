package animaisTest;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestInstance;
import animais.Especie;
import animais.Genero;
import vacinas.Vacina;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EspecieVacinaTest {
	private Vacina auxV;
	private Genero auxG;
	private Especie auxE;
	@BeforeAll
	void globalSetup() {
		auxG = new Genero(randomNome());
	}
	@BeforeEach
	void setup() {
		auxE = new Especie(randomNome(), auxG);	
		auxV = new Vacina(randomNome(), 1);
	}
	@Test
	void valuesTest() {
		assertTrue(auxE.insertVacina(auxV));
		assertFalse(auxE.insertVacina(auxV));
	}
	@RepeatedTest(5)
	void insertSearchTest() {
		String nome = randomNome();
		assertTrue(auxE.insertVacina(new Vacina(nome, 1)));
		assertNotNull(auxE.searchVacinaByNome(nome));
	}
	private String randomNome() {
		return "Nome" + ThreadLocalRandom.current().nextInt(0, 1000);
	}
}
