package animaisTest;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import animais.GestaoAnimal; 
class GeneroTest {
	private GestaoAnimal manager;
	@BeforeEach
	void setup() {
		manager = new GestaoAnimal();
	}
	@Test
	void valuesTest() {	
		String aux = designacaoRandom();
		assertTrue(manager.insertGenero(aux));
		assertFalse(manager.insertGenero(aux));
	}
	@Test
	void insertSearchGeneroTest() {	
		String[] designacoes = new String[5];
		for(int i = 0; i < 5; i++) {
			designacoes[i] = designacaoRandom();
			assertTrue(manager.insertGenero(designacoes[i]));
		}
		for(int i = 0; i< 5; i++) {
			assertNotNull(manager.searchGeneroByDesignacao(designacoes[i]));
		}
	}
	private String designacaoRandom() {
		return "Designacao" + ThreadLocalRandom.current().nextInt(0,1000);
	}
}
