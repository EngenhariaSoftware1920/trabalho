package servicosTest;
import static org.junit.Assert.*;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import servicos.GestaoServico;
class TipoConsultaTest {
	private GestaoServico manager;
	@BeforeEach
	void setup() {
		manager = new GestaoServico();
	}
	@Test
	void valuesTest() {
		String aux = randomDesignacao();
		assertTrue(manager.insertTipoConsulta(aux));
		assertFalse(manager.insertTipoConsulta(aux));
	}
	@Test
	void insertSearchTipoConsultaTest() {
		for(int i = 0; i < 5; i++) {
			String designacao = randomDesignacao();
			assertTrue(manager.insertTipoConsulta(designacao));
			assertNotNull(manager.searchTipoByDesignacao(designacao));
		}
	}
	private String randomDesignacao() {
		return "Des" + ThreadLocalRandom.current().nextInt(0,1000);
	}
}
