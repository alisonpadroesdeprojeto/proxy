package proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ClienteProxyTest {

    @BeforeEach
    void setUp() {
        BD.addCliente(new Cliente(1, "Carlos", "São Paulo", "12345-6", "000-1"));
        BD.addCliente(new Cliente(2, "José", "Rio de Janeiro", "98765-4", "000-2"));
    }

    @Test
    void deveRetornarDadosPessoaisCliente() {
        ClienteProxy cliente = new ClienteProxy(1);
        assertEquals(Arrays.asList("Carlos", "São Paulo"), cliente.obterDadosPessoais());
    }

    @Test
    void deveRetonarContaCliente() {
        Bancario bancario = new Bancario("Beatriz", true);
        ClienteProxy cliente = new ClienteProxy(2);

        assertEquals(Arrays.asList("98765-4", "000-2"), cliente.obterContaBancaria(bancario));
    }

    @Test
    void deveRetonarExcecaoUsuarioNaoAutorizadoConsultarNotasCliente() {
        try {
            Bancario bancario = new Bancario("Lucas", false);
            ClienteProxy cliente = new ClienteProxy(2);

            cliente.obterContaBancaria(bancario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Bancário não autorizado", e.getMessage());
        }
    }
}