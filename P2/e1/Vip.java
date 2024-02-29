package e1;

public class Vip extends Clientes {
    public Vip(String DNI) {
        super(DNI);
    }

    @Override
    public String tipoCliente() {
        return "VIP";
    }

    @Override
    public boolean retirarEnNegativo() {
        return true;
    }

    @Override
    public long limiteMinimoIngreso() {
        return 0;
    }

    @Override
    public long limiteNegativo() {
        return 1;
    }

    @Override
    public long limiteRetirada() {return 0;}  //ULTIMO CAMBIO

    @Override
    public long comisionRetirada() {
        return 0;
    }
}
