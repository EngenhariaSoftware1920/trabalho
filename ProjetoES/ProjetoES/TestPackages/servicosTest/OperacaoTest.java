package servicosTest;
import static org.junit.Assert.*;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import servicos.GestaoServico;
class OperacaoTest {
	private GestaoServico manager;
	@BeforeEach
	void setup() {
		manager = new GestaoServico();
	}
	@Test
	void valuesTest() {
		String aux = randomNome();
		assertTrue(manager.insertOperacao(aux));
		assertFalse(manager.insertOperacao(aux));
	}
	@Test
	void insertSearchTest() {
		for(int i = 0; i < 5; i++) {
			String nome = randomNome();
			assertTrue(manager.insertOperacao(nome));
			assertNotNull(manager.searchOperacaoByNome(nome));
		}
	}
	private String randomNome() {
		return "Nome" + ThreadLocalRandom.current().nextInt(0,1000);
	}
}
