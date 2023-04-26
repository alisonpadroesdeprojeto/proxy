package proxy;

import java.util.Arrays;
import java.util.List;

public class Cliente implements ICliente {

    private Integer id;
    private String nome;
    private String cidade;
    private String numeroConta;
    private String numeroAgencia;

    public Cliente(int id) {
        this.id = id;
        Cliente objeto = BD.getCliente(id);
        this.nome = objeto.nome;
        this.cidade = objeto.cidade;
        this.numeroConta = objeto.numeroConta;
        this.numeroAgencia = objeto.numeroAgencia;
    }

    public Cliente(Integer id, String nome, String cidade, String numeroConta, String numeroAgencia) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public List<String> obterDadosPessoais() {
        return Arrays.asList(this.nome, this.cidade);
    }

    @Override
    public List<String> obterContaBancaria(Bancario bancario) {
        return Arrays.asList(this.numeroConta, this.numeroAgencia);
    }
}
