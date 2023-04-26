package proxy;

import java.util.List;

public interface ICliente {
    List<String> obterDadosPessoais();
    List<String> obterContaBancaria(Bancario bancario);
}
