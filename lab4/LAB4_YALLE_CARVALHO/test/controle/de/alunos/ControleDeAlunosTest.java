package controle.de.alunos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControleDeAlunosTest {

	private ControleDeAlunos controleDeAlunos;
	
	@BeforeEach
	void criaControleDeAlunos() {
		this.controleDeAlunos = new ControleDeAlunos();
		this.controleDeAlunos.cadastraAluno("250", "Gabriel Reyes", "Computação");
		this.controleDeAlunos.cadastraAluno("200", "Lili Camposh", "Computação");
		this.controleDeAlunos.cadastraAluno("500", "Leo Martinez", "Economia");
		this.controleDeAlunos.cadastraGrupo("Listas", "Literatura");
		this.controleDeAlunos.cadastraGrupo("LEDA", "computação");
	}
	
	@Test
	void testaCadastrarAlunosBemSucedido() {
		assertTrue(controleDeAlunos.cadastraAluno("202" , "Angela Ziegler", "Medicina"));
		assertTrue(controleDeAlunos.cadastraAluno("201" , "Torbjorn Lindholm", "Engenharia Mecânica"));
	}
	
	void testaCadastrarAlunosComErro() {
		try {
			controleDeAlunos.cadastraAluno("", "Yalle Carvalho", "Relações Internacionais");
			fail("Espera-se uma exceção");
		} catch (IllegalArgumentException iae) {
			
		}
		
	}
	@Test
	void testaMatriculaJaCadastrada() {
			assertFalse(controleDeAlunos.cadastraAluno("200" , "Angela Ziegler", "Medicina"));
			
	}
	@Test
	void testarCadastraGrupoSemRestricao() {
		assertTrue(controleDeAlunos.cadastraGrupo("Programação OO", ""));
		
	}
	@Test
	void testarCadastraGrupoComRestricao() {
		assertTrue(controleDeAlunos.cadastraGrupo("Atividades", "Computação"));
	}
	
	@Test
	void testarCadastraGrupoJaCadastrado() {
		assertFalse(controleDeAlunos.cadastraGrupo("Listas", ""));
	}
	@Test
	void testarCadastraGrupoComNomeIvalido() {
		try {
			this.controleDeAlunos.cadastraGrupo("", "");
			fail("Espera-se uma exceção");
		} catch (IllegalArgumentException iae) {
		
		} 
	}
	@Test
	void testaExibiçãoDeAluno() {
		assertEquals("Aluno: 250 - Gabriel Reyes - Computação", controleDeAlunos.exibeAluno("250"));
		assertEquals("Aluno: 200 - Lili Camposh - Computação", controleDeAlunos.exibeAluno("200"));
	}
	@Test
	void testaExibiçãoDeAlunoNaoCadastrado() {
		assertEquals("ALUNO NÃO CADASTRADO.", controleDeAlunos.exibeAluno("150"));
	}
	@Test
	void testaExibiçãoDeAlunoComParametroInvalido() {
		try {
			this.controleDeAlunos.exibeAluno("");
			fail("Espera-se uma exceção");
		} catch (IllegalArgumentException iae) {
		}
	}

	@Test
	void testaAlocaAlunoAUmGrupo() {
		assertEquals("ALUNO ALOCADO!", controleDeAlunos.alocaAluno("200", "Listas"));
		assertEquals("ALUNO ALOCADO!", controleDeAlunos.alocaAluno("250", "Listas"));
		assertEquals("ALUNO ALOCADO!", controleDeAlunos.alocaAluno("200", "Listas"));
		
	}
	
	@Test
	void testaAlocarAlunoInexistenteAGrupoInexistente() {
		assertEquals("GRUPO E ALUNOS NÃO CADASTRADOS", controleDeAlunos.alocaAluno("100", "Tarefas"));
	}
	@Test
	void testaAlocarAlunoInexistente() {
		assertEquals("ALUNO NÃO CADASTRADO.", controleDeAlunos.alocaAluno("100", "Listas"));
	}
	@Test
	void testaAlocarAlunoAGrupoInexistente() {
		assertEquals("GRUPO NÃO CADASTRADO", controleDeAlunos.alocaAluno("500", "Tarefas"));
	}
	@Test
	void testaAlocarAlunoAGrupoComRestricao() {
		assertEquals("GRUPO COM RESTRIÇÃO DE CURSO", controleDeAlunos.alocaAluno("200", "LEDA"));
		assertEquals("ALUNO ALOCADO!", controleDeAlunos.alocaAluno("500", "LEDA"));
		
	}
	@Test
	void testaAlocarAlunoComParametrosInvalidos() {
		try {
			this.controleDeAlunos.alocaAluno("", "");
			fail("Espera-se uma exceção");
		} catch (IllegalArgumentException iae) {
		}
		try {
			this.controleDeAlunos.alocaAluno("200", "");
			fail("Espera-se uma exceção");
		} catch (IllegalArgumentException iae) {
		}
		try {
			this.controleDeAlunos.alocaAluno("", "LEDA");
			fail("Espera-se uma exceção");
		} catch (IllegalArgumentException iae) {
		}
	}

	@Test
	void testaPertinenciaAoGrupo() {
		this.controleDeAlunos.alocaAluno("500", "LEDA");
		this.controleDeAlunos.alocaAluno("500", "LEDA");
		assertEquals("ALUNO PERTENCE AO GRUPO", controleDeAlunos.pertenceAoGrupo("LEDA", "500"));
		assertEquals("ALUNO NÃO PERTENCE AO GRUPO", controleDeAlunos.pertenceAoGrupo("LEDA", "200"));
	}
	@Test
	void testaPertinenciaAoGrupoAlunoEGrupoInexistentes() {
		assertEquals("ALUNO NÃO CADASTRADO", controleDeAlunos.pertenceAoGrupo("LEDA", "175"));
		assertEquals("GRUPO NÃO CADASTRADO", controleDeAlunos.pertenceAoGrupo("INFOSOC", "200"));
	}
	@Test
	void testaPertinenciaComParametrosInvalidos() {
		try {
			this.controleDeAlunos.pertenceAoGrupo("", "");
			fail("Espera-se uma exceção");
		} catch (IllegalArgumentException iae) {
		}
		try {
			this.controleDeAlunos.pertenceAoGrupo("LEDA", "");
			fail("Espera-se uma exceção");
		} catch (IllegalArgumentException iae) {
		}
		try {
			this.controleDeAlunos.pertenceAoGrupo("", "500");
			fail("Espera-se uma exceção");
		} catch (IllegalArgumentException iae) {
		}
	}

	@Test
	void testaCadastrarRespostaNoQuadro() {
		assertEquals("ALUNO REGISTRADO!", controleDeAlunos.cadastraRespostaNoQuadro("250"));
		assertEquals("ALUNO REGISTRADO!", controleDeAlunos.cadastraRespostaNoQuadro("500"));
		assertEquals("ALUNO NÃO CADASTRADO!", controleDeAlunos.cadastraRespostaNoQuadro("127"));
	}
	@Test
	void testaCadastrarRespostaComParametroInvalido() {
		try {
			this.controleDeAlunos.cadastraRespostaNoQuadro(" ");
			fail("Espera-se uma exceção");
		} catch (IllegalArgumentException iae) {
		}
	}
	@Test
	void testaImprimirAlunosParticipativos() {
		this.controleDeAlunos.cadastraRespostaNoQuadro("250");
		this.controleDeAlunos.cadastraRespostaNoQuadro("500");
		String lista = "Alunos: \n" +
						"1. 250 - Gabriel Reyes - Computação" + "\n"
						+ "2. 500 - Leo Martinez - Economia" + "\n";
		assertEquals(lista, controleDeAlunos.imprimeAlunosParticipativos());
	}
	@Test
	void testaImprimirListaVaziaDeAlunosParticipativos() {
		try {
			this.controleDeAlunos.imprimeAlunosParticipativos();
			fail("Espera-se uma exceção");
		} catch (NullPointerException npe) {	
		}
		
	}
	@Test
	void testaContarRestricao() {
		this.controleDeAlunos.cadastraGrupo("Atividades", "Computação");
		assertEquals("Computação 2" + "\n",controleDeAlunos.contaRestricao("Computação"));
	}
	@Test
	void testaContarRestricaoComParametroInvalido() {
		try{
			this.controleDeAlunos.contaRestricao(" ");
			fail("Espera-se uma exceção");
		} catch (IllegalArgumentException iae) {	
		}
	}

}
