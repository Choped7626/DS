package e1;

public class Preferente extends Clientes {
    public Preferente(String DNI) {
        super(DNI);
    }

    @Override
    public String tipoCliente() {
        return "Preferente";
    }

    @Override
    public boolean retirarEnNegativo() {
        return true;
    }

    @Override
    public long limiteMinimoIngreso() {
        return 50000;
    }

    @Override
    public long limiteRetirada() {return 100;}  //ULTIMO CAMBIO
    @Override
    public long limiteNegativo() {
        return -100000;
    }

    @Override
    public long comisionRetirada() {
        return 2;
    }
}
