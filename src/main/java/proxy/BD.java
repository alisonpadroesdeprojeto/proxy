package proxy;

import java.util.HashMap;
import java.util.Map;

public class BD {
    private static Map<Integer, Cliente> clientes = new HashMap<>();

    public static Cliente getCliente(Integer matricula) {
        return clientes.get(matricula);
    }

    public static void addCliente(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }
}
