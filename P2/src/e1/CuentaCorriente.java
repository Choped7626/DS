package e1;

public class CuentaCorriente extends CuentasBancarias {
    public CuentaCorriente(String IBAN) {
        super(IBAN);
    }  //cambiado

    @Override
    public void deleteMoney(long cash) {  //ULTIMO CAMBIO
        if(verTitular().retirarEnNegativo()){
            if(verTitular().limiteNegativo() < 0){      //Preferente
                if(viewMoney()-cash >= -100000){
                    super.deleteMoney(cash);
                }else
                    throw new IllegalArgumentException("Tras la retirada, la cantidad máxima permitida de cuenta en negativo es " + verTitular().limiteNegativo() + " y en este caso se supera");
            }else       //VIP
                super.deleteMoney(cash);
        }else{                      //cliente standard
            if(cash>viewMoney()){
                throw new IllegalArgumentException("Tras la retirada, la cuenta no puede quedar en negativo");
            }else
                super.deleteMoney(cash);
        }
    }
}
