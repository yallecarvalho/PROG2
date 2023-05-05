package ufcg.ccc.domino;

import java.util.LinkedList;
import java.util.List;

import ufcg.ccc.domino.Jogo.TipoDeVitoria;

/**
 * Guarda o histórico de um jogo, com as posições da mesa jogada a jogada e o
 * resultado, para usarmos em interfaces.
 *
 */
public class HistoricoDeJogo {

	private List<SituacaoNoJogo> rodadas;
	private Jogador jogador1;
	private Jogador jogador2;
	private boolean empate;
	private String vencedor;
	private int numeroDeVitoriasNormal;
	private int numeroDeVitoriasLaELo;
	private int numeroDeVitoriasCarroca;
	private int numeroDeVitoriasCruzada;
	
	
	/**
	 * Cria um novo histórico.
	 * 
	 * @param jogador1 Um jogador.
	 * @param jogador2 O outro.
	 */
	public HistoricoDeJogo(Jogador jogador1, Jogador jogador2) {
		this.rodadas = new LinkedList<SituacaoNoJogo>();
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
		this.empate = false;
		this.vencedor = null;
		this.numeroDeVitoriasNormal = 0;
		this.numeroDeVitoriasLaELo = 0;
		this.numeroDeVitoriasCarroca = 0;
		this.numeroDeVitoriasCruzada = 0;
	}

	public void addRodada(Jogada ultimaJogadaJ1, Jogada ultimaJogadaJ2, Mesa mesa) {
		SituacaoNoJogo novaSituacao = new SituacaoNoJogo(jogador1, ultimaJogadaJ1, jogador2, ultimaJogadaJ2,
				jogador1.getMao(), jogador2.getMao(), mesa.getPecasNaMesa());
		this.rodadas.add(novaSituacao);
	}

	/**
	 * Informa que o resultado da partida nesse histórico foi empate.
	 */
	public void setResultadoEmpate() {
		this.empate = true;
		this.vencedor = null;
	}

	/**
	 * Informa o vencedor.
	 * 
	 * @param vencedor o nome do vencedor.
	 */
	public void setVencedor(String vencedor) {
		this.vencedor = vencedor;
		this.empate = false;
	}
	

	public boolean isEmpate() {
		return empate;
	}

	public String getVencedor() {
		return vencedor;
	}
	/**
	 * @return número de vitórias normais
	 */
	public int getVitoriasNormais() {
		return numeroDeVitoriasNormal;
	}
	/**
	 * @return número de vitórias por la e lo
	 */
	public int getVitoriasLaELo() {
		return numeroDeVitoriasLaELo;
	}
	/**
	 * @return número de vitórias por carroça
	 */
	public int getVitoriasCarroca() {
		return numeroDeVitoriasCarroca;
	}

	/**
	 * @return número de vitórias por cruzada
	 */
	public int getVitoriasCruzada() {
		return numeroDeVitoriasCruzada;
	}
	/**
	 * Informa o tipo de vitória e o número. Aqui somamos as vitórias de cada tipo.
	 * @param vitoria tipo de vitória
	 * @param numeroDeVitorias número de vitória
	 */
	public void setVitoria(Jogo.TipoDeVitoria vitoria, int numeroDeVitorias) {
		if(vitoria.equals(TipoDeVitoria.NORMAL)) {
			numeroDeVitoriasNormal += numeroDeVitorias;
		} else if(vitoria.equals(TipoDeVitoria.LA_E_LO)) {
			numeroDeVitoriasLaELo += numeroDeVitorias;
		} else if(vitoria.equals(TipoDeVitoria.CARROCA)) {
			numeroDeVitoriasCarroca += numeroDeVitorias;
		} else {
			numeroDeVitoriasCruzada += numeroDeVitorias;
		}
	
	}
	
	@Override
	public String toString() {
		String o = "==\n== Novo Jogo \n==";
		for (int i = 0; i < rodadas.size(); i++) {
			o += "\nRodada " + i + "\n" + rodadas.get(i).toString();
		}

		o += "\n--RESULTADO: " + (this.isEmpate() ? "EMPATE\n" : ("VIT�RIA DE " + getVencedor()) + "\n");
		return o;
	}

	/**
	 * Classe privada para encapsular o estado da partida depois de uma rodada.
	 *
	 */
	private class SituacaoNoJogo {
		private Jogada jogadaJ1;
		private Jogada jogadaJ2;
		private List<Peca> maoJ1;
		private List<Peca> maoJ2;
		private List<Peca> mesa;
		private Jogador jogador1;
		private Jogador jogador2;

		public SituacaoNoJogo(Jogador j1, Jogada jogadaJ1, Jogador j2, Jogada jogadaJ2, List<Peca> maoJ1,
				List<Peca> maoJ2, List<Peca> naMesa) {
			this.jogador1 = j1;
			this.jogadaJ1 = jogadaJ1;
			this.jogador2 = j2;
			this.jogadaJ2 = jogadaJ2;
			this.maoJ1 = maoJ1;
			this.maoJ2 = maoJ2;
			this.mesa = naMesa;
		}

		@Override
		public String toString() {
			return "  " + this.jogador1.getNome() + " : " + jogadaJ1.toString() + ", mão: " + maoJ1.toString() + "\n  "
					+ this.jogador2.getNome() + " : " + jogadaJ2.toString() + ", mão: " + maoJ2.toString() + "\n  "
					+ "MESA: " + mesa.toString();
		}
	}

	
}
