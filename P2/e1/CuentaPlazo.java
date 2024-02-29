package e1;

public class CuentaPlazo extends CuentasBancarias {
    public CuentaPlazo(String IBAN) {  //cambiado
        super(IBAN);
    }

    @Override
    public long putmoney(long cash) {  //ULTIMO CAMBIO
        if (cash < verTitular().limiteMinimoIngreso()) {
            throw new IllegalArgumentException("La cantidad mínima para poder ingresar dinero siendo cliente " + verTitular().tipoCliente() + " es : " + verTitular().limiteMinimoIngreso());
        }
        return super.putmoney(cash);
    }

    @Override
    public void deleteMoney(long cash) {  //ULTIMO CAMBIO
        if (cash < verTitular().limiteRetirada()) {
            throw new IllegalArgumentException("La cantidad mínima para poder retirar dinero siendo cliente " +verTitular().tipoCliente() + " es : " + verTitular().limiteRetirada());
        }
        else {
            long retirar = (cash + verTitular().comisionRetirada() * (cash / 100));
            if(verTitular().retirarEnNegativo()){
                if(verTitular().limiteNegativo() < 0){//Preferente
                    if((viewMoney() - retirar) < verTitular().limiteNegativo()){
                        throw new IllegalArgumentException("Tras la retirada, la cantidad máxima permitida de cuenta en negativo es " + verTitular().limiteNegativo() + " y en este caso se supera");
                    }else {
                        super.deleteMoney(retirar);
                    }
                }else {//VIP
                    super.deleteMoney(retirar);
                }
            }else{                      //cliente standard
                if(retirar > viewMoney()){
                    throw new IllegalArgumentException("Tras la retirada, la cuenta no puede quedar en negativo");
                }else
                    super.deleteMoney(retirar);
            }
        }
    }
}
