package mainTest;
import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestInstance;
import main.ReadOperation;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ReadOperationTest {
	private ReadOperation rO;
	@BeforeAll
	void globalSetup() {
		Scanner sc = new Scanner(System.in);
		rO = new ReadOperation(sc);
	}
	@RepeatedTest(5)
	void stringTest() {
		assertEquals(rO.readString("Introduza string de teste:"), "teste");
	}
	@RepeatedTest(5)
	void intTest() {
		assertEquals(rO.readInt("Introduza número de teste:"), 1);
	}
	@RepeatedTest(5)
	void dateTest() {
		assertEquals(rO.readDate("Introduza data de teste:"), LocalDate.of(2020, 04, 01));
	}
	@RepeatedTest(5)
	void timeTest() {
		assertEquals(rO.readTime("Introduza hora de teste:"), LocalTime.of(18,00));
	}
}
