package ufcg.ccc.domino;

import java.util.Comparator;

/**
 * Classe para comparar peças e ordenar pela esquerda e depois pela direita. 
 * @author yalle carvalho
 */

public class PecaPadraoComparator implements Comparator<Peca> {

	@Override
	public int compare(Peca peca, Peca outraPeca) {
		
		 if(peca.getNumEsquerdo() > outraPeca.getNumEsquerdo()) {
				return 1;
		 }
		 if(peca.getNumEsquerdo() == outraPeca.getNumEsquerdo()) {
			 if(peca.getNumDireito() > outraPeca.getNumDireito()) {
				 return 1;
			 }
			 if(peca.getNumDireito() < outraPeca.getNumDireito()) {
				 return -1;
			 }
			 if(peca.getNumDireito() == peca.getNumDireito()) {
				 return 0;
			 } 
			 
			 return 0;
			 
		 } else {
		 
			 return -1;
		 }
	}

}
