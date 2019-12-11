package animaisTest;
import static org.junit.Assert.assertNotNull;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import animais.Especie;
import animais.Genero;
import animais.GestaoAnimal;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AnimalTest {
	private GestaoAnimal manager;
	private Genero auxG;
	private Especie auxE;
	@BeforeAll
	void globalSetup() {
		auxG = new Genero(designacaoRandom());
		auxE = new Especie(nomeRandom("E"), auxG);
	}
	@BeforeEach
	void setup() {
		manager = new GestaoAnimal();
	}
	@Test
	void insertSearchClienteTest() {
		for(int i = 1; i <= 5; i++) {
	 		manager.insertAnimal(nomeRandom("A"), auxE, "Fêmea", LocalDate.of(2016, 04, 4));
	 		assertNotNull(manager.searchAnimalByCod(i));
		}
	}
	// Nomes Random
	private String designacaoRandom() {
		return "Designacao" + ThreadLocalRandom.current().nextInt(0,1000);
	}
	private String nomeRandom(String subject) {
		return "Nome" + subject +ThreadLocalRandom.current().nextInt(0,1000);
	}
}
