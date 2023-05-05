package controle.de.alunos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe para realizar testes da Classe Aluno.
 * @author Yalle Carvalho - 119210523
 */



class AlunoTest {
	
	private Aluno aluno1;
	private Aluno aluno2;
	
	
	@Test
	void testaAlunoCompleto() {
		new Aluno("250", "Gabriel Reyes", "Computação");
	}
	@Test
	void testaAlunoComArgumentosNaoValidos() {
		try {
			new Aluno("105", "", "Medicina");
			fail("Espera-se uma exceção");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	@BeforeEach
	void preparaAluno() {
		this.aluno1 = new Aluno("250", "Gabriel Reyes", "Computação");
		this.aluno2 = new Aluno("200", "Lili Camposh", "Engenharia");
	}
	
	@Test
	void exibirMatricula() {
		assertEquals("250", aluno1.getMatricula());
		assertEquals("200", aluno2.getMatricula());
	}
	@Test
	void exibirNome() {
		assertEquals("Gabriel Reyes", aluno1.getNome());
		assertEquals("Lili Camposh", aluno2.getNome());
	}
	@Test
	void exibirCurso() {
		assertEquals("Computação", aluno1.getCurso());
		assertEquals("Engenharia", aluno2.getCurso());
	}
	@Test
	void exibirAlunos() {
		assertEquals("250 - Gabriel Reyes - Computação", aluno1.toString());
		assertEquals("200 - Lili Camposh - Engenharia", aluno2.toString());
	}
	@Test
	void testaHashCodeAlunosDiferentes() {
		assertNotEquals(this.aluno1.hashCode(), this.aluno2.hashCode());
	}
	@Test
	void testaHashCodeAlunosIguais() {
		assertEquals(this.aluno1.hashCode(), new Aluno("250", "Júlia Rodrigues", "Medicina").hashCode());
	}
	@Test
	void testaEqualsObjects() {
		assertFalse(this.aluno1.equals(aluno2));
		assertTrue(this.aluno2.equals(new Aluno("200", "Mario Quintana", "Literatura")));
	}
	//falta os testes pra equals e hashcode
}
