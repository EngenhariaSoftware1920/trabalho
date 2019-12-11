package clientesTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import clientes.GestaoCliente;
class ClienteTest {
	private GestaoCliente manager;
	@BeforeEach
	void setup() {
		manager = new GestaoCliente();
	}
	@Test
	void insertSearchClienteTest() {
		for(int i = 1; i <= 5; i++) {
			manager.insertCliente(nomeRandom(), "Morada", "911947379");
			assertNotNull(manager.searchClienteByCod(i));
		}
	}
	private String nomeRandom() {
		return "Nome" +ThreadLocalRandom.current().nextInt(0,1000);
	}
}
