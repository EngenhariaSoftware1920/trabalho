package animaisTest;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.time.LocalDate;
import java.time.Month;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import animais.Especie;
import animais.Genero;
import animais.GestaoAnimal;
import org.junit.jupiter.api.TestInstance;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AntecClinicosTest {
	private GestaoAnimal manager;
	@BeforeAll
	void setup() {
		manager = new GestaoAnimal();
		Genero auxG = new Genero(designacaoRandom());
		Especie auxE = new Especie(nomeRandom("E"), auxG);
		manager.insertAnimal(nomeRandom("A"), auxE, "Macho", LocalDate.of(2016, Month.APRIL, 4));
	}
	@Test
	void valuesTest() {
		String aux = antecRandom();
		assertTrue(manager.searchAnimalByCod(1).insertAntecClinicos(aux));
 		assertFalse(manager.searchAnimalByCod(1).insertAntecClinicos(aux));
	}
	@Test
	void insertAntecClinicosTest() {
		for(int i=0; i<5;i ++) {
	 		assertTrue(manager.searchAnimalByCod(1).insertAntecClinicos(antecRandom()));
		}
	}
	// Nomes Random
	private String designacaoRandom() {
		return "Designacao" + ThreadLocalRandom.current().nextInt(0,1000);
	}
	private String nomeRandom(String subject) {
		return "Nome" + subject +ThreadLocalRandom.current().nextInt(0,1000);
	}
	private String antecRandom() {
		return "Antec" + ThreadLocalRandom.current().nextInt(0,1000);
	}
}
