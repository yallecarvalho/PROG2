package ufcg.ccc.domino.estrategia;

import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.Jogada.TipoJogada;

/**
 * Joga sempre primeiro as carroças (remetendo ao jogo do dominó normal) 
 * e tenta se livrar sempre das maiores carroças primeiro. 
 * @author yalle carvalho
 *
 */
public class JogaCarrocas implements EstrategiaDeJogo {
	
	@Override
	public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
		if (mesa.getNumPecas() == 0) {
			for (Peca peca : mao) {
				if (peca.pecaCarroca()) {
					return new Jogada(peca, TipoJogada.NA_DIREITA);
				}
			} return new Jogada(mao.get(0), TipoJogada.NA_DIREITA);
		}
			
		
		// Primeiro tenta as carroças e depois as peças normais. 
		for (Peca peca : mao) {
			if (peca.pecaCarroca() && peca.encaixa(mesa.getNumNaDireita())) {
				return new Jogada(peca, TipoJogada.NA_DIREITA);
			}
			if (peca.pecaCarroca() && peca.encaixa(mesa.getNumNaEsquerda())) {
				return new Jogada(peca, TipoJogada.NA_ESQUERDA);
			}
			if (peca.encaixa(mesa.getNumNaDireita())) {
				return new Jogada(peca, TipoJogada.NA_DIREITA);
			}
			if (peca.encaixa(mesa.getNumNaEsquerda())) {
				return new Jogada(peca, TipoJogada.NA_ESQUERDA);
			}
		}
		
		return new Jogada();
		
	}
	
	@Override
	public String toString() {
		return "Joga primeiro as carro�as";
	}
}
