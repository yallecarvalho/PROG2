package ufcg.ccc.domino.estrategia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.JogadaInvalidaException;
/*
 * Classe pra testar a implementação da estratégia de jogar primeiro as carroças durante o jogo de dominó.
 */
class JogaCarrocaTest {
	
	private Mesa mesa;

	@BeforeEach
	void setUp() throws Exception {
		mesa = new Mesa();
	}

	@Test
	void testJogaPassa() throws JogadaInvalidaException {
		mesa.jogaNaDireita(new Peca(1, 2));
		mesa.jogaNaEsquerda(new Peca(1, 4));
		
		JogaCarrocas estrategia = new JogaCarrocas();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(5, 0), new Peca(5, 6), new Peca(0, 3)), mesa);
		
		assertEquals(TipoJogada.PASSA, j1.getTipo());
	}
	
	@Test
	void testJogaPrimeiraPecaCarroca() {
		JogaCarrocas estrategia = new JogaCarrocas();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(2, 2), new Peca(0, 2), new Peca(1, 3)), mesa);
		
		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(2, j1.getPeca().getNumDireito());
		

	}
	@Test
	void testJogaPrimeiraCarroca() {
		JogaCarrocas estrategia = new JogaCarrocas();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(1, 2), new Peca(4, 4), new Peca(2, 3)), mesa);
		
		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(4, j1.getPeca().getNumEsquerdo());
		assertEquals(4, j1.getPeca().getNumDireito());
	
	}
	@Test
	void testJogaCarrocasNaEsquerda() throws JogadaInvalidaException {
		mesa.jogaNaDireita(new Peca(1, 2));
		mesa.jogaNaEsquerda(new Peca(1, 4));
		
		JogaCarrocas estrategia = new JogaCarrocas();
		

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(1, 5), new Peca(4, 4), new Peca(2, 3)), mesa);
		
		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
		assertEquals(4, j1.getPeca().getNumEsquerdo());
		assertEquals(4, j1.getPeca().getNumDireito());
	
	}
	
	@Test
	void testJogaCarrocasNaDireita() throws JogadaInvalidaException {
		mesa.jogaNaDireita(new Peca(1, 2));
		mesa.jogaNaEsquerda(new Peca(1, 4));
		
		JogaCarrocas estrategia = new JogaCarrocas();
		

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(1, 5), new Peca(2, 2), new Peca(2, 3)), mesa);
		
		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(2, j1.getPeca().getNumDireito());
	
	}
	
	@Test
	void testNaoTemCarrocaPrimeiraJogada() throws JogadaInvalidaException {
		JogaCarrocas estrategia = new JogaCarrocas();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(1, 5), new Peca(0, 4), new Peca(2, 3)), mesa);
		
		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(1, j1.getPeca().getNumEsquerdo());
		assertEquals(5, j1.getPeca().getNumDireito());
	
	}
	
	@Test
	void testNaoTemCarrocaQueEncaixaEJogaNaDireita() throws JogadaInvalidaException {
		mesa.jogaNaDireita(new Peca(1, 2));
		mesa.jogaNaEsquerda(new Peca(1, 4));
		JogaCarrocas estrategia = new JogaCarrocas();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(1, 5), new Peca(3, 3), new Peca(2, 3)), mesa);
		
		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(3, j1.getPeca().getNumDireito());
	
	}
	@Test
	void testNaoTemCarrocaQueEncaixaEJogaNaEsquerda() throws JogadaInvalidaException {
		mesa.jogaNaDireita(new Peca(1, 2));
		mesa.jogaNaEsquerda(new Peca(1, 4));
		JogaCarrocas estrategia = new JogaCarrocas();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(4, 5), new Peca(3, 3), new Peca(0, 3)), mesa);
		
		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
		assertEquals(4, j1.getPeca().getNumEsquerdo());
		assertEquals(5, j1.getPeca().getNumDireito());
	
	}

}
