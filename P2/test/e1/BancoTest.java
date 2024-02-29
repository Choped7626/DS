package e1;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions  .*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BancoTest {
    @Test
    void testClientes(){

        Preferente cliente1 = new Preferente("clientePreferente");
        Standard cliente2 = new Standard("clienteEstandar");
        Vip cliente3 = new Vip("clienteVip");

        assertEquals("Preferente" , cliente1.tipoCliente());
        assertEquals("Standard" , cliente2.tipoCliente());
        assertEquals("VIP" , cliente3.tipoCliente());

        assertEquals("DNI titular cuenta: clientePreferente" , cliente1.toString());
        assertEquals("DNI titular cuenta: clienteEstandar" , cliente2.toString());
        assertEquals("DNI titular cuenta: clienteVip" , cliente3.toString());

        assertTrue(cliente1.retirarEnNegativo());
        assertFalse(cliente2.retirarEnNegativo());
        assertTrue(cliente3.retirarEnNegativo());

        assertEquals(50000 , cliente1.limiteMinimoIngreso());
        assertEquals(100000 , cliente2.limiteMinimoIngreso());
        assertEquals(0 , cliente3.limiteMinimoIngreso());

        assertEquals(0 , cliente3.comisionRetirada());
        assertEquals(2 , cliente1.comisionRetirada());
        assertEquals(4 , cliente2.comisionRetirada());

        assertEquals(new HashSet<>(), cliente1.obtenerCuentas());
        assertEquals(new HashSet<>(), cliente2.obtenerCuentas());
        assertEquals(new HashSet<>(), cliente3.obtenerCuentas());


        CuentaCorriente c1 = new CuentaCorriente( "Corriente");
        CuentaPlazo c2 = new CuentaPlazo( "Plazo");

        assertEquals(c1 , cliente1.addCuenta(c1));
        assertEquals(c2 , cliente2.addCuenta(c2));
        assertThrows(IllegalArgumentException.class ,() -> c1.asociarTitular(cliente1));
        assertThrows(IllegalArgumentException.class ,() -> c1.asociarTitular(cliente2));
        assertThrows(IllegalArgumentException.class ,() -> cliente2.addCuenta(c1));
        assertThrows(IllegalArgumentException.class ,() -> cliente2.addCuenta(c2));
        assertThrows(IllegalArgumentException.class ,() -> cliente1.addCuenta(c2));
        assertThrows(IllegalArgumentException.class ,() -> cliente1.addCuenta(c1));
    }

    @Test
    void testCuentas(){

        Standard cliente3 = new Standard("clienteEstandar");
        CuentaCorriente c3 = new CuentaCorriente("CorrienteStandard");
        assertEquals(c3 , cliente3.addCuenta(c3));

        Standard cliente4 = new Standard("clienteEstandar");
        CuentaPlazo c4 = new CuentaPlazo("PlazoStandard");
        assertEquals(c4 , cliente4.addCuenta(c4));

        Preferente cliente1 = new Preferente("clientePreferente");
        CuentaCorriente c1 = new CuentaCorriente( "CorrientePreferente");
        assertEquals(c1 , cliente1.addCuenta(c1));

        Preferente cliente2 = new Preferente("clientePreferente");
        CuentaPlazo c2 = new CuentaPlazo("PlazoPreferente");
        assertEquals(c2 , cliente2.addCuenta(c2));

        Vip cliente5 = new Vip("clienteVip");
        CuentaCorriente c5 = new CuentaCorriente("CorrienteVip");
        assertEquals(c5 , cliente5.addCuenta(c5));

        Vip cliente6 = new Vip("clienteVip");
        CuentaPlazo c6 = new CuentaPlazo("PlazoVip");
        assertEquals(c6 , cliente6.addCuenta(c6));

        assertEquals(0 , c1.viewMoney());
        assertEquals(0 , c2.viewMoney());
        assertEquals(0 , c3.viewMoney());
        assertEquals(0 , c4.viewMoney());
        assertEquals(0 , c5.viewMoney());
        assertEquals(0 , c6.viewMoney());

        //1Preferente 3Standard 5Vip; //Cuentas corrientes
        c5.deleteMoney(1000000);
        assertEquals(-1000000 , c5.viewMoney());
        assertThrows(IllegalArgumentException.class ,() -> c3.deleteMoney(1000000));
        c1.deleteMoney(100000);
        assertEquals(-100000 , c1.viewMoney());
        assertThrows(IllegalArgumentException.class , () -> c1.deleteMoney(1));

        //2preferente 4standard 6vip //Cuentas A Plazo
        c6.deleteMoney(1000000);
        assertEquals(-1000000 , c6.viewMoney());
        c6.deleteMoney(1);
        assertEquals(-1000001 , c6.viewMoney());
        assertThrows(IllegalArgumentException.class ,() -> c4.deleteMoney(1000000));
        c2.deleteMoney(5000);
        assertEquals(-5100 , c2.viewMoney());
        assertThrows(IllegalArgumentException.class ,() -> c2.deleteMoney(1));
        assertThrows(IllegalArgumentException.class , () -> c2.deleteMoney(100000));

        assertEquals(1000 , c3.putmoney(1000));
        assertEquals(100000 , c4.putmoney(100000));
        c3.deleteMoney(1);
        assertEquals( 999 , c3.viewMoney());
        assertThrows(IllegalArgumentException.class , () -> c4.deleteMoney(1));
        assertEquals(100000 , c4.viewMoney());
        assertEquals(-99000 , c1.putmoney(1000));
        assertEquals(94900 , c2.putmoney(100000));
        assertEquals(-999000 , c5.putmoney(1000));
        assertEquals(-999001 , c6.putmoney(1000));

        assertEquals(-98999 , c1.putmoney(1));
        assertThrows(IllegalArgumentException.class , () -> c2.putmoney(1));
        assertEquals(1000 , c3.putmoney(1));
        assertThrows(IllegalArgumentException.class , () -> c4.putmoney(1));
        assertEquals(-998999 , c5.putmoney(1));
        assertEquals(-999000 , c6.putmoney(1));

        assertEquals(-98999 , c1.viewMoney());
        assertEquals(94900 , c2.viewMoney());
        assertEquals(1000 , c3.viewMoney());
        assertEquals(100000 , c4.viewMoney());
        assertEquals(-998999 , c5.viewMoney());
        assertEquals(-999000 , c6.viewMoney());

        c1.deleteMoney(1);
        assertEquals(-99000 ,c1.viewMoney());
        assertThrows(IllegalArgumentException.class , () -> c2.deleteMoney(1));
        c3.deleteMoney(1);
        assertEquals(999 ,c3.viewMoney());
        assertThrows(IllegalArgumentException.class , () -> c4.deleteMoney(1));
        c5.deleteMoney(1);
        assertEquals(-999000 ,c5.viewMoney());
        c6.deleteMoney(1);
        assertEquals(-999001 ,c6.viewMoney());
        c4.deleteMoney(10000);

        assertEquals(89600 , c4.viewMoney());
        assertEquals(cliente1 , c1.verTitular());
        assertEquals(cliente2 , c2.verTitular());
        assertEquals(cliente3 , c3.verTitular());
        assertEquals(cliente4 , c4.verTitular());
        assertEquals(cliente5 , c5.verTitular());
        assertEquals(cliente6 , c6.verTitular());

        assertEquals("CorrientePreferente" , c1.viewIBAN());
        assertEquals("PlazoPreferente" , c2.viewIBAN());
        assertEquals("CorrienteStandard" , c3.viewIBAN());
        assertEquals("PlazoStandard" , c4.viewIBAN());
        assertEquals("CorrienteVip" , c5.viewIBAN());
        assertEquals("PlazoVip" , c6.viewIBAN());

        assertEquals("DNI titular cuenta: clientePreferente, con IBAN: CorrientePreferente" , c1.toString());
        assertEquals("DNI titular cuenta: clientePreferente, con IBAN: PlazoPreferente" , c2.toString());
        assertEquals("DNI titular cuenta: clienteEstandar, con IBAN: CorrienteStandard" , c3.toString());
        assertEquals("DNI titular cuenta: clienteEstandar, con IBAN: PlazoStandard" , c4.toString());
        assertEquals("DNI titular cuenta: clienteVip, con IBAN: CorrienteVip" , c5.toString());
        assertEquals("DNI titular cuenta: clienteVip, con IBAN: PlazoVip" , c6.toString());

    }
}
