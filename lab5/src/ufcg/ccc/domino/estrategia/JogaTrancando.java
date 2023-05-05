package ufcg.ccc.domino.estrategia;

import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.Jogada.TipoJogada;

/**
 * Inicia o jogo com a peça mais alta e tenta manter trancando o jogo quando possível.
 * @author yalle carvalho
 */
public class JogaTrancando  implements EstrategiaDeJogo {
	
	@Override
	public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
		if (mesa.getNumPecas() == 0) {
			for (int i = 0; i < mao.size(); i++) {
				if (mao.get(i).getPontosPeca() > mao.get(i+1).getPontosPeca()) {
					return new Jogada(mao.get(i), TipoJogada.NA_DIREITA);
				}
			}
		}
		// Tenta jogar trancando com uma peça normal ou com carroça
		for (Peca peca : mao) {
				if(peca.encaixa(mesa.getNumNaDireita())) {
					if (peca.getNumDireito() == mesa.getNumNaEsquerda()) {
						return new Jogada(peca, TipoJogada.NA_DIREITA); }    
					if(peca.pecaCarroca()) {
						return new Jogada(peca, TipoJogada.NA_DIREITA); 
				}
				} else if (peca.encaixa(mesa.getNumNaEsquerda())) {
					if(peca.getNumEsquerdo() == mesa.getNumNaDireita()) {
						return new Jogada(peca, TipoJogada.NA_ESQUERDA); 
					} if(peca.pecaCarroca()) {
						return new Jogada(peca, TipoJogada.NA_ESQUERDA);
					}
				}
		}
		// Joga normal se nao houver possibilidade de trancar.
		for (Peca peca : mao) {
			if(peca.encaixa(mesa.getNumNaDireita())) {
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
		return "Joga tentando trancar o jogo.";
	}
}
