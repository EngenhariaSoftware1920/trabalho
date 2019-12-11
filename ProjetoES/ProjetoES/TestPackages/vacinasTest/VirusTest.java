package vacinasTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import vacinas.GestaoVacina;
import vacinas.Vacina;
import vacinas.Virus;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class VirusTest {
	private GestaoVacina gv;
	
	@BeforeEach
	void setup() {
		gv = new GestaoVacina();
	}
	
	@Test
	@DisplayName("Inserir virus")
	void inserirVirus() {
		Virus vi1=new Virus("Vi1");
		Virus vi2=new Virus("Vi2");
		assertTrue(gv.getVirus().size()==0);
		gv.adicionarVirus(vi1);
		gv.adicionarVirus(vi2);
		assertEquals(gv.getVirus().size(),2);
	}
	
	@Test
	@DisplayName("Inserir vacina no virus")
	void inserirVacinaVirus() {
		Vacina v1=new Vacina("Va1",10);
		Vacina v2=new Vacina("Va2",50);
		Vacina v3=new Vacina("Va3",30);
		assertTrue(gv.getVacinas().size()==0);
		gv.adicionarVacina(v1);
		gv.adicionarVacina(v2);
		gv.adicionarVacina(v3);
		assertEquals(gv.getVacinas().size(),3);
		
		Virus vi1=new Virus("Vi1");
		Virus vi2=new Virus("Vi2");
		assertTrue(gv.getVirus().size()==0);
		gv.adicionarVirus(vi1);
		gv.adicionarVirus(vi2);
		assertEquals(gv.getVirus().size(),2);
		
		gv.adicionarVacinaVirus("vi1", v1);
		gv.adicionarVacinaVirus("vi1", v2);
		gv.adicionarVacinaVirus("vi2", v2);
		assertTrue(vi1.getVacinas().get(0).getNome().equalsIgnoreCase("va1"));
		assertTrue(vi2.getVacinas().get(0).getNome().equalsIgnoreCase("va2"));
	}
}
