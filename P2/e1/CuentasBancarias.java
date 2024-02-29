package e1;

public abstract class CuentasBancarias {
    private final String IBAN;
    private long saldo;
    private Clientes titular;  //cambiado

    public CuentasBancarias(String IBAN) {  //cambiado
        this.IBAN = IBAN;
        this.saldo = 0;
    }

    //MÉTODOS
    public void asociarTitular(Clientes cliente) { //cambiado
        if (titular == null) {
            titular = cliente;
        }
        else
            throw new IllegalArgumentException("Error.La cuenta ya tiene un titular");
    }
    public long viewMoney(){
        return saldo;
    }
    public String viewIBAN(){return IBAN;}
    public Clientes verTitular() {
        return titular;
    }
    public long putmoney(long cash) {  //ULTIMO CAMBIO
        return saldo += cash;
    }
    public void deleteMoney(long cash){  //ULTIMO CAMBIO
        saldo -= cash;
    }

    @Override
    public String toString() {
        return   titular + ", con IBAN: " + IBAN;
    }
}