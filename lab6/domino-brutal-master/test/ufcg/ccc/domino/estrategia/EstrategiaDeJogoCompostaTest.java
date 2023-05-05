package ufcg.ccc.domino.estrategia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.JogadaInvalidaException;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.Jogada.TipoJogada;

/*
 * Classe pra testar a implementação da estratégia de jogo composta, a qual recebe um array de estratégias e alterna entre elas.
 */

class EstrategiaDeJogoCompostaTest {
	
	private Mesa mesa;
	private List<EstrategiaDeJogo> estrategias;
	
	@BeforeEach
	void setUp() throws Exception {
		mesa = new Mesa();
		estrategias = new ArrayList<>();
	
	}
	
	@Test
	void testaJogaPrimeiraEstrategiaDaListaComoPrimeiraPossivel() {

		estrategias.add(new JogaPrimeiraPossivel());

		estrategias.add(new JogaTrancando());

		EstrategiaDeJogo estrategiaComposta = new EstrategiaDeJogoComposta(estrategias);
		
		
		Jogada j1 = estrategiaComposta.decideJogada(List.of(new Peca(3, 3), new Peca(0, 3)), mesa);
		assertEquals(3, j1.getPeca().getNumEsquerdo());
		assertEquals(3, j1.getPeca().getNumDireito());
		
	}
	
	@Test
	void testaJogaPrimeiraEstrategiaDaListaComoJogaTrancando() {

		estrategias.add(new JogaTrancando());

		estrategias.add(new JogaPrimeiraPossivel());

		EstrategiaDeJogo estrategiaComposta = new EstrategiaDeJogoComposta(estrategias);
		
		
		Jogada j1 = estrategiaComposta.decideJogada(List.of(new Peca(1, 3), new Peca(6, 6), new Peca(1, 2)), mesa);
		assertEquals(6, j1.getPeca().getNumEsquerdo());
		assertEquals(6, j1.getPeca().getNumDireito());
		
	}
	
	@Test
	void testaJogaPrimeiraEstrategiaCarrocao() {

		estrategias.add(new JogaCarrocas());

		estrategias.add(new JogaPrimeiraPossivel());

		EstrategiaDeJogo estrategiaComposta = new EstrategiaDeJogoComposta(estrategias);
		
		
		Jogada j1 = estrategiaComposta.decideJogada(List.of(new Peca(0, 1), new Peca(4, 6), new Peca(0, 0)), mesa);
		assertEquals(0, j1.getPeca().getNumEsquerdo());
		assertEquals(0, j1.getPeca().getNumDireito());
		
	}
	
	@Test
	void testJogaDireita() throws JogadaInvalidaException {
		
		estrategias.add(new JogaCarrocas());

		estrategias.add(new JogaPrimeiraPossivel());

		EstrategiaDeJogo estrategiaComposta = new EstrategiaDeJogoComposta(estrategias);
		
		Jogada j1 = estrategiaComposta.decideJogada(List.of(new Peca(0,3), new Peca(3, 3), new Peca(5, 3)), mesa);
		
		assertEquals(3, j1.getPeca().getNumEsquerdo());
		assertEquals(3, j1.getPeca().getNumDireito());
		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		
		Jogada j2 = estrategiaComposta.decideJogada(List.of(new Peca(0,3), new Peca(5, 3)), mesa);
		
		assertEquals(0, j2.getPeca().getNumEsquerdo());
		assertEquals(3, j2.getPeca().getNumDireito());
		assertEquals(TipoJogada.NA_DIREITA, j2.getTipo());
		
	}


}
