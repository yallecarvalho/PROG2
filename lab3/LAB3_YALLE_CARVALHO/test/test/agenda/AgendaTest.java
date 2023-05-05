package agenda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Classe para realizar testes da Classe Agenda.
 * @author Yalle Carvalho - 119210523
 */

class AgendaTest {

    private Agenda agenda;

    @BeforeEach
    void preparaAgenda() {
        this.agenda = new Agenda();
    }

    @Test
    void testAgenda(){
        new Agenda();
    }

    @Test
    void testListarContatos() {
        this.agenda.cadastraContato(1, "Kurt", "Cobain", "8399403140", "8399805640", null);
        this.agenda.cadastraContato(4, "Rachel", "Green", "8399453647", "8399815642", "8399887766");
        this.agenda.cadastraContato(3, "Chandler", "Bing", "8399443340", "8399855741", "");
        assertEquals("""
                1: Kurt Cobain
                3: Chandler Bing
                4: Rachel Green
                """, agenda.listaContatos());
}

   @Test
   void testListarFavoritos() {
       this.agenda.cadastraContato(1, "Kurt", "Cobain", "8399403140", "8399805640", null);
       this.agenda.cadastraContato(4, "Rachel", "Green", "8399453647", "8399815642", "8399887766");
       this.agenda.cadastraContato(3, "Chandler", "Bing", "8399443340", "8399855741", "");
       this.agenda.cadastraFavorito(1,1);
       this.agenda.cadastraFavorito(3, 4);
       assertEquals("""
               1 - Kurt Cobain
               4 - Chandler Bing
               """, agenda.listaFavoritos());

    }

    @Test
    void testExibirContatoComTodosOsDados() {
        this.agenda.cadastraContato(1, "Rachel", "Green", "83 99453647", "83 99815642", "83 99887766");
        assertEquals("""
                Rachel Green
                83 99453647 (Prioritário)
                83 99815642 (Whatsapp)
                83 99887766 (Adicional)""", this.agenda.exibeContato(1));
    }
    @Test
    void testExibirContatosSemUmDosTelefones() {
        this.agenda.cadastraContato(1, "Kurt", "Cobain", "83 99403140", "83 99805640", null);
        assertEquals("""
                Kurt Cobain
                83 99403140 (Prioritário)
                83 99805640 (Whatsapp)""", this.agenda.exibeContato(1));
    }
    @Test
    void testExibirContatoInexistente() {
        this.agenda.cadastraContato(2, "Kurt", "Cobain", "83 99403140", "83 99805640", null);
        try {
            this.agenda.exibeContato(1); }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
    @Test
    void testExibirContatoEmLimiteSuperior() {
        this.agenda.cadastraContato(2, "Kurt", "Cobain", "83 99403140", "83 99805640", null);
        try {
            this.agenda.exibeContato(101); }
        catch (RuntimeException re) {
            re.printStackTrace();
        }
    }
    @Test
    void testExibirContatoEmLimiteInferior() {
        this.agenda.cadastraContato(2, "Kurt", "Cobain", "83 99403140", "83 99805640", null);
        try {
            this.agenda.exibeContato(0); }
        catch (RuntimeException re) {
            re.printStackTrace();
        }
    }
    @Test
    void testExibirContatoFavoritado() {
        this.agenda.cadastraContato(1, "Kurt", "Cobain", "83 99403140", "83 99805640", null);
        this.agenda.cadastraContato(4, "Rachel", "Green", "83 99453647", "83 99815642", "83 99887766");
        this.agenda.cadastraContato(25, "Chanandler", "Bong", "83 99907865", "83 99234567", " ");
        this.agenda.cadastraFavorito(1, 1);
        assertEquals("""
                <3 Kurt Cobain
                83 99403140 (Prioritário)
                83 99805640 (Whatsapp)""", this.agenda.exibeContato(1));

    }
    @Test
    void testExibirExFavoritado() {
        this.agenda.cadastraContato(1, "Kurt", "Cobain", "83 99403140", "83 99805640", null);
        this.agenda.cadastraContato(4, "Rachel", "Green", "83 99453647", "83 99815642", "83 99887766");
        this.agenda.cadastraContato(25, "Chanandler", "Bong", "83 99907865", "83 99234567", " ");
        this.agenda.cadastraFavorito(1, 1);
        this.agenda.cadastraFavorito(4,1);
        assertEquals("""
                Kurt Cobain
                83 99403140 (Prioritário)
                83 99805640 (Whatsapp)""", this.agenda.exibeContato(1));
        assertEquals("""
                <3 Rachel Green
                83 99453647 (Prioritário)
                83 99815642 (Whatsapp)
                83 99887766 (Adicional)""", this.agenda.exibeContato(4));


    }

    @Test
    void testaContatosIguais() {
        this.agenda.cadastraContato(1, "Fa", "Mulan", "8399240242", "8399203012", "8399219901");
        assertTrue(agenda.testaContatosIguais("Fa Mulan"));
    }
    @Test
    void testaContatosDiferentes(){
        this.agenda.cadastraContato(1, "Fa", "Mulan", "8399240242", "8399203012", "8399219901");
        assertFalse(agenda.testaContatosIguais("Kevin Pearson"));
    }

    @Test
    void testCadastraContatoPosicaoVazia() {
        this.agenda.cadastraContato(1, "Fa", "Mulan", "8399240242", "8399203012", "8399219901");
    }
    @Test
    void testCadastraContatoPosicaoExistente() {
        this.agenda.cadastraContato(1, "Mushu", "Dragaozinho", "8399303123", "8399393112", "8399349671");
    }
    @Test
    void testCadastraContatoLimite(){
        this.agenda.cadastraContato(100, "Kevin", "Pearson", "8399623032", "8399213111", "8399345670");
    }
    @Test
    void testCadastraContatoAcimaDoLimite() {
        try {
            this.agenda.cadastraContato(101, "Randall", "Pearson", "8399120342", "8230102130", "8399405150");
        } catch (ArrayIndexOutOfBoundsException a) {
        }
    }
    @Test
    void testCadastraContatoAbaixoLimite(){
        try { this.agenda.cadastraContato(0, "Kate", "Pearson", "8399128292", "8399665511", "8399102304");
        } catch (ArrayIndexOutOfBoundsException a) {
        }
    }

    @Test
    void testCadastraContatoTelefoneVazio(){
        this.agenda.cadastraContato(20, "Timao", "Suricato", "8399303145", "8399505134", "");
    }
    @Test
    void testCadastraContatoInvalido() throws IllegalArgumentException {
        this.agenda.cadastraContato(25, null, "Suricato", "8399303145", "8399505134", "");
    }
   @Test
   void cadastraFavorito() {
       this.agenda.cadastraContato(1, "Mushu", "Dragaozinho", "8399303123", "8399393112", "8399349671");
       this.agenda.cadastraFavorito(1, 1);
    }
    @Test
    void cadastraFavoritoAcimaDoLimite() {
        try {
            this.agenda.cadastraContato(20, "Mushu", "Dragaozinho", "8399303123", "8399393112", "8399349671");
            this.agenda.cadastraFavorito(20, 11);
        } catch (ArrayIndexOutOfBoundsException a) {
        }
    }

    @Test
    void testaFavoritosComNomesIguais() {
        this.agenda.cadastraContato(1, "Ross", "Geller", "83 99403140", "83 99805640", null);
        this.agenda.cadastraContato(4, "Rachel", "Green", "83 99453647", "83 99815642", "83 99887766");
        this.agenda.cadastraContato(25, "Ross", "Geller", "83 99907865", "83 99234567", " ");
        this.agenda.cadastraFavorito(1, 1);
        this.agenda.cadastraFavorito(25, 2);
        assertTrue(agenda.testaFavoritos(25));
    }
    @Test
    void testaFavoritosComNomesDiferentes() {
        this.agenda.cadastraContato(1, "Ross", "Geller", "83 99403140", "83 99805640", null);
        this.agenda.cadastraContato(4, "Rachel", "Green", "83 99453647", "83 99815642", "83 99887766");
        this.agenda.cadastraContato(25, "Chanandler", "Bong", "83 99907865", "83 99234567", " ");
        this.agenda.cadastraFavorito(1, 1);
        assertFalse(agenda.testaFavoritos(25));
    }
}