package e1;

import java.util.HashSet;
import java.util.Set;

public abstract class Clientes {
    private final String DNI;
    private Set<CuentasBancarias> cuentas;  //CAMBIADO
    public Clientes(String DNI) {  //CAMBIADO
        this.DNI = DNI;
        this.cuentas = new HashSet<>();
    }

    public CuentasBancarias addCuenta(CuentasBancarias cuenta) { //CAMBIADO
        if (!cuentas.contains(cuenta)) {
            cuentas.add(cuenta);
            cuenta.asociarTitular(this);
            return cuenta;//AÑADIDO
        }
        else
            throw new IllegalArgumentException("Error. Una cuenta solo puede tener asociado un cliente");
    }
    public Set<CuentasBancarias> obtenerCuentas(){
        return cuentas;
    }
    public abstract String tipoCliente();
    public abstract boolean retirarEnNegativo();
    public abstract long limiteMinimoIngreso();
    public abstract long limiteNegativo();
    public abstract long limiteRetirada();
    public abstract long comisionRetirada();

    @Override
    public String toString() {
        return "DNI titular cuenta: " +DNI;
    }
}

