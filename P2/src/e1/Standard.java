package e1;

public class Standard extends Clientes {
    public Standard(String DNI) {
        super(DNI);
    }

    @Override
    public String tipoCliente() {
        return "Standard";
    }

    @Override
    public boolean retirarEnNegativo() {
        return false;
    }

    @Override
    public long limiteMinimoIngreso() {
        return 100000;
    }

    @Override
    public long limiteRetirada(){return 300;}  //ULTIMO CAMBIO
    public long limiteNegativo(){
        return 0;
    }

    @Override
    public long comisionRetirada() {
        return 4;
    }
}
