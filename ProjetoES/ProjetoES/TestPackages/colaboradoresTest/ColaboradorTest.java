package colaboradoresTest;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import colaboradores.*;
import org.junit.jupiter.api.Test;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ColaboradorTest {
	private GestaoColaborador manager;
	private HashMap<Integer, String> options;
	@BeforeAll
	void globalSetup() {
		options = new HashMap<>();
		options.put(0, "V");
		options.put(1, "A");
		options.put(2, "L");
		options.put(3, "S");
	}
	@BeforeEach
	void setup() {
		manager = new GestaoColaborador();
	}
	@Test
	void factoryTest() {
		ColaboradorFactory factory = ColaboradorFactory.getInstance();
		assertTrue(factory.buildColaborador("V", "Nome", "Rua", "Telefone", "Sabado", "Qualquer") instanceof Veterinario);
		assertTrue(factory.buildColaborador("A", "Nome", "Rua", "Telefone", "Sabado", "Qualquer") instanceof Assistente);
		assertTrue(factory.buildColaborador("S", "Nome", "Rua", "Telefone", "Sabado", "Qualquer") instanceof Secretariado);
		assertTrue(factory.buildColaborador("L", "Nome", "Rua", "Telefone", "Sabado", "Qualquer") instanceof Limpeza);
	}
	@Test
	void insertSearchColaboradorTest() {
		for(int i = 1; i <= 5; i++) {
			assertTrue(manager.insertColaborador(randomSubclass(), "Nome", "Rua", "911947379", "Sabado", "Qualquer"));
			assertNotNull(manager.searchColaboradorByCod(i));
		}
	}
	private String randomSubclass() {
		return options.get(ThreadLocalRandom.current().nextInt(0,4));
	}
}
