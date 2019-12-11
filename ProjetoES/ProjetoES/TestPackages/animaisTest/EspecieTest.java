package animaisTest;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import animais.Genero;
import animais.GestaoAnimal;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EspecieTest {
	private GestaoAnimal manager;
	private Genero auxG;
	@BeforeAll
	void gloabalSetup() {
		auxG = new Genero(designacaoRandom());
	}
	@BeforeEach
	void setup() {
		manager = new GestaoAnimal();
	}
	@Test
	void valuesTest() {
		String aux = nomeRandom();
		assertTrue(manager.insertEspecie(aux, auxG));
		assertFalse(manager.insertEspecie(aux, auxG));	
	}
	@Test
	void insertSearchEspecieTest() {
		String[] nomes = new String[5];
		for(int i = 0; i < 5; i++) {
			nomes[i] = nomeRandom();
			assertTrue(manager.insertEspecie(nomes[i], auxG));
		}
		for(int i = 0; i < 5; i++) {
			assertNotNull(manager.searchEspecieByNome(nomes[i]));
		}
	}
	private String designacaoRandom() {
		return "Designacao" + ThreadLocalRandom.current().nextInt(0,1000);
	}
	private String nomeRandom() {
		return "Nome" + ThreadLocalRandom.current().nextInt(0,1000);
	}
}
