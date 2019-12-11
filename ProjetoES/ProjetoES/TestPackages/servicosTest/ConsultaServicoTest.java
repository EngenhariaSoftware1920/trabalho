package servicosTest;
import static org.junit.Assert.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import animais.*;
import colaboradores.Assistente;
import colaboradores.ElementoEquipa;
import colaboradores.Veterinario;
import servicos.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ConsultaServicoTest {
	private Veterinario v;
	private Assistente as;
	private Consulta c;
	private TipoConsulta tp;
	private Operacao op;
	private Animal a;
	@BeforeAll
	void globalSetup() {
		tp = new TipoConsulta(randomNome());
		Genero g = new Genero(randomNome());
		Especie e = new Especie(randomNome(), g);
		a = new Animal(randomNome(), e, "Macho", LocalDate.of(2016, Month.APRIL, 4));
	}
	@BeforeEach
	void setup() {
		v = new Veterinario(randomNome(), "Morada", "911111111", "Sabado", "true");
		as = new Assistente(randomNome(), "Morada", "911111111", "Sabado", "true");
		c = new Consulta(tp, a, LocalDate.of(2020, Month.APRIL, 4), LocalTime.of(16,00));
		op = new Operacao(randomNome());
	}
	@Test
	void valuesTest() {
		Consulta newC = new Consulta(tp, a, LocalDate.of(2020, Month.NOVEMBER, 4), LocalTime.of(16,00));
		Servico aux = new Servico(newC, op, v, 2);
		assertFalse(c.insertServico(aux));
		aux = new Servico(c, op, v, 2);
		assertTrue(c.insertServico(aux));		
	}
	@RepeatedTest(5)
	void insertTest() {
		Servico aux = new Servico(c, op, randomC(), 2);
		assertTrue(c.insertServico(aux));
	}
	private String randomNome() {
		return "Nome" + ThreadLocalRandom.current().nextInt(0, 1000);
	}
	private ElementoEquipa randomC() {
		if(ThreadLocalRandom.current().nextInt(0,1) == 0) {
			return v;
		}
		else return as;
	}
}
