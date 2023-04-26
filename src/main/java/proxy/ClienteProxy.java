package proxy;

import java.util.List;

public class ClienteProxy implements ICliente {

    private Cliente Cliente;

    private final Integer id;

    public ClienteProxy(Integer matricula) {
        this.id = matricula;
    }

    @Override
    public List<String> obterDadosPessoais() {
        if (this.Cliente == null) {
            this.Cliente = new Cliente(this.id);
        }
        return this.Cliente.obterDadosPessoais();
    }

    @Override
    public List<String> obterContaBancaria(Bancario Bancario) {
        if (!Bancario.isGerente()) {
            throw new IllegalArgumentException("Bancário não autorizado");
        }
        if (this.Cliente == null) {
            this.Cliente = new Cliente(this.id);
        }
        return this.Cliente.obterContaBancaria(Bancario);
    }
}
