package colaboradoresTest;
import static org.junit.Assert.assertNotNull;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import colaboradores.ControllerColaborador;
import main.ReadOperation;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ControllerColaboradorTest {
	private ControllerColaborador controller;
	private ReadOperation rO;
	@BeforeAll
	void globalSetup() {
		Scanner sc = new Scanner(System.in);
		rO = new ReadOperation(sc);
	}
	@BeforeEach
	void setup() {
		controller = new ControllerColaborador(rO);
	}
	@Test
	void insertSearchColaborador() {
		for(int i = 0; i < 5; i++) {
			System.out.println("// Colaborador Test //");
			controller.insertColaborador();
		}
		controller.printColaboradorByNome();
		controller.printAllColaborador();
		assertNotNull(controller.searchColaboradorByCod());
	}
}
