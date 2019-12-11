package clientesTest;
import static org.junit.Assert.assertNotNull;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import clientes.ControllerCliente;
import main.ReadOperation;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ControllerClienteTest {
	private ControllerCliente controller;
	private ReadOperation rO;
	@BeforeAll
	void globalSetup() {
		Scanner sc = new Scanner(System.in);
		rO = new ReadOperation(sc);
	}
	@BeforeEach
	void setup() {
		controller = new ControllerCliente(rO);
	}
	@Test
	void insertSearchClientTest() {
		for(int i = 0; i < 5; i++) {
			System.out.println("// Cliente Test //");
			controller.insertCliente();
		}
		controller.printAllCliente();
		assertNotNull(controller.searchClienteByCod());
	}
}
