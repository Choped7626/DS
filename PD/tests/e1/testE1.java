package e1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testE1 {
    @Test
    void Hotel() {
        //CREAMOS UN HOTEL CON TRES HABITACIONES
        Hotel hotel = new Hotel("UDC-HILLS");
        hotel.addHab("Juan");
        hotel.addHab("Luis");
        hotel.addHab("Juan");

        assertNotNull(hotel.getHabitacion(1));
        assertNotNull(hotel.getHabitacion(2));
        assertNotNull(hotel.getHabitacion(3));
        assertNull(hotel.getHabitacion(5));

        //COMPROBAMOS CUALES DEBERIAN ESTAR DISPONIBLES
        String habitaciones = "\nHabitaciones Disponibles:\n" +
                "Habitación número 1: Libre. Aprobada por Juan.\n" +
                "Habitación número 2: Libre. Aprobada por Luis.\n" +
                "Habitación número 3: Libre. Aprobada por Juan.\n";
        assertEquals(habitaciones, hotel.getHabitacionesDisponibles());


        //MOSTRAMOS LA INFORMACIÓN SOBRE EL ESTADO DE LAS HABITACIONES DEL HOTEL, QUE TIENE QUE COINCIDIR EN CIERTA MEDIDA CON HABITACIONES DISPONIBLES
        habitaciones = "***********************\n" +
                "Hotel UDC-HILLS\n" +
                "***********************\n" +
                "Habitación número 1: Libre. Aprobada por Juan.\n" +
                "Habitación número 2: Libre. Aprobada por Luis.\n" +
                "Habitación número 3: Libre. Aprobada por Juan.\n" +
                "***********************\n";
        assertEquals(habitaciones, hotel.mostrarEstadoHabitaciones());


        //MIRAMOS QUE EL RESTO DE ESTADOS NO SE TIENEN EN CUENTA DE MOMENTO POR LAS HABITACIONES
        habitaciones="\nHabitaciones Pendientes de Aprobación de limpieza:\n";
        assertEquals(habitaciones, hotel.getHabitacionesPendientesAprobacion());


        habitaciones="\nHabitacines Pendientes de Limpieza:\n";
        assertEquals(habitaciones, hotel.getHabitacionesPendientesLimpieza());

        //RESERVAMOS LA HABITACION 1 QUE PASA ESTAR OCUPADA
        hotel.reservarHabitacion(1, "Juan");
        habitaciones = "\nHabitaciones Disponibles:\n" +
                "Habitación número 2: Libre. Aprobada por Luis.\n" +
                "Habitación número 3: Libre. Aprobada por Juan.\n";

        assertEquals(habitaciones, hotel.getHabitacionesDisponibles());
        assertTrue(hotel.getHabitacion(1).getEstadoActual() instanceof EstadoOcupada);
        assertEquals("Juan", hotel.getHabitacion(1).getHuespedActual());

        hotel.cancelarReservaHabitacion(1);
        assertTrue(hotel.getHabitacion(1).getEstadoActual() instanceof EstadoPendienteDeLimpieza);

        //AHORA TENDRÍA QUE APARECER LA HABITACION 1
        habitaciones = "\nHabitacines Pendientes de Limpieza:\n" +
                "Habitación número 1: Pendiente de Limpieza\n";
        assertEquals(habitaciones, hotel.getHabitacionesPendientesLimpieza());

        hotel.limpiarHabitacion(2, "personalLimpieza");
        assertTrue(hotel.getHabitacion(2).getEstadoActual() instanceof EstadoLimpiezaPendienteDeAprobacion);

        hotel.aprobarLimpiezaHabitacion(2, "Luis");
        assertTrue(hotel.getHabitacion(2).getEstadoActual() instanceof EstadoLibre);

        hotel.cancelarReservaHabitacion(2);
        hotel.aprobarLimpiezaHabitacion(2, "Juan");
        assertTrue(hotel.getHabitacion(2).getEstadoActual() instanceof EstadoLibre);
        assertEquals("Juan", hotel.getHabitacion(2).getSupervisor());

        hotel.reservarHabitacion(1, "Juan");
        hotel.cancelarReservaHabitacion(1);
        hotel.limpiarHabitacion(1, "personalLimpieza");

        hotel.reservarHabitacion(2,"Luis");
        hotel.reservarHabitacion(2, "Saul");
        hotel.limpiarHabitacion(2, "personalLimpieza");
        hotel.aprobarLimpiezaHabitacion(2, "Supervisor");
        assertTrue(hotel.getHabitacion(2).getEstadoActual() instanceof EstadoOcupada);

        hotel.cancelarReservaHabitacion(2);
        hotel.aprobarLimpiezaHabitacion(2, "Miguel");
        assertTrue(hotel.getHabitacion(2).getEstadoActual() instanceof EstadoPendienteDeLimpieza);


        hotel.reservarHabitacion(1, "Pablo");
        hotel.cancelarReservaHabitacion(1);
        hotel.limpiarHabitacion(1,"personalLimpieza");
        System.out.println(hotel.mostrarEstadoHabitaciones());

    }
}
