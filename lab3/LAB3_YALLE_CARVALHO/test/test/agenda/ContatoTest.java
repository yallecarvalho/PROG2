package agenda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Classe para realizar testes da Classe Contato.
 * @author Yalle Carvalho - 119210523
 */

class ContatoTest {

    private Contato contato1;
    private Contato contato2;
    private Contato contato3;

    @Test
    void testContatoCompleto(){
        new Contato("Yalle", "Carvalho", "83 99561024", "83 99870065", "83 99088313");
    }
    @Test
    void testContatoSemTelAdicional(){
        new Contato("Yalle", "Carvalho", "83 99561024", "83 99870065", null);
    }

    @BeforeEach
    void preparaContato(){
        this.contato1 = new Contato("Monica", "Geller","87 99006677","83 99004564",null);
        this.contato2 = new Contato("Phoebe","Buffay", "83 99006561", "83 99006789", "87 99768900");
        this.contato3 = new Contato("Rose", "Tyler", "83 95068900", "83 99003134", " ");
    }

    @Test
    void ExibirNome() {
        assertEquals("Monica", contato1.getNome());
        assertEquals("Phoebe", contato2.getNome());
        assertEquals("Rose", contato3.getNome());
    }

    @Test
    void ExibirSobrenome() {
        assertEquals("Geller", contato1.getSobrenome());
        assertEquals("Buffay", contato2.getSobrenome());
        assertEquals("Tyler", contato3.getSobrenome());
    }

    @Test
    void ExibirNomeCompleto() {
        assertEquals("Monica Geller", contato1.getNomeSobrenome());
        assertEquals("Phoebe Buffay", contato2.getNomeSobrenome());
        assertEquals("Rose Tyler", contato3.getNomeSobrenome());
    }

    @Test
    void ExibirContatoComTelefoneNulo() {
        assertEquals("""
                Monica Geller
                87 99006677 (Prioritário)
                83 99004564 (Whatsapp)""", contato1.toString());
    }
    @Test
    void ExibirContatoCompleto() {
        assertEquals("""
                Phoebe Buffay
                83 99006561 (Prioritário)
                83 99006789 (Whatsapp)
                87 99768900 (Adicional)""", contato2.toString());

    }
    @Test
    void ExibirContatoComTelefoneVazio() {
        assertEquals("""
                Rose Tyler
                83 95068900 (Prioritário)
                83 99003134 (Whatsapp)""", contato3.toString());

    }
}