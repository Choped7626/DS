package e1;

import java.util.ArrayList;
import java.util.List;


public class Hotel {
    private final String nombre;
    private final List<Habitacion> habitaciones;

    public Hotel(String nombre) {
        this.nombre = nombre;
        this.habitaciones = new ArrayList<>();
    }

    public void addHab (String supervisor){
        Habitacion h1 = new Habitacion(habitaciones.size() + 1 , supervisor);
        habitaciones.add(h1);
    }

    protected Habitacion getHabitacion(int numero) {
        if (numero > 0 && numero <= habitaciones.size()) {
            return habitaciones.get(numero - 1);
        }
        else {
            System.out.println("Número de habitación inválido: "+ numero);
            return null;
        }
    }
    //Mostrar habitaciones disponibles, pendientes de limpieza y pendientes de aprobacion
    public String getHabitacionesDisponibles() {
        StringBuilder disponibles = new StringBuilder();
        disponibles.append("\nHabitaciones Disponibles:\n");
        for (Habitacion h : habitaciones) {
            if (h.getEstadoActual() instanceof EstadoLibre)
                disponibles.append(h.obtenerInformacion()).append("\n");
        }
        return disponibles.toString();
    }

    public String getHabitacionesPendientesLimpieza() {
        StringBuilder limpieza = new StringBuilder();
        limpieza.append("\nHabitacines Pendientes de Limpieza:\n");
        for (Habitacion h: habitaciones) {
            if (h.getEstadoActual() instanceof EstadoPendienteDeLimpieza)
                limpieza.append(h.obtenerInformacion()).append("\n");
        }
        return limpieza.toString();
    }

    public String getHabitacionesPendientesAprobacion() {
        StringBuilder aprobar = new StringBuilder();
        aprobar.append("\nHabitaciones Pendientes de Aprobación de limpieza:\n");
        for (Habitacion h : habitaciones) {
            if (h.getEstadoActual() instanceof EstadoLimpiezaPendienteDeAprobacion)
                aprobar.append(h.obtenerInformacion()).append("\n");
        }
        return aprobar.toString();
    }
    public String mostrarEstadoHabitaciones() {
        StringBuilder info = new StringBuilder();
        info.append("***********************\nHotel ");
        info.append(nombre);
        info.append("\n***********************\n");
        for (Habitacion habitacion : habitaciones)
            info.append(habitacion.obtenerInformacion()).append("\n");
        info.append("***********************").append("\n");
        return info.toString();
    }

    public void reservarHabitacion(int numero, String huesped) {
        Habitacion habitacion = getHabitacion(numero);
        if (habitacion != null) {
            habitacion.reservar(huesped);
        }
    }

    public void cancelarReservaHabitacion(int numero) {
        Habitacion habitacion = getHabitacion(numero);
        if (habitacion != null) {
            habitacion.cancelarReserva();
        }
    }

    public void limpiarHabitacion(int numero, String personalDeLimpieza) {
        Habitacion habitacion = getHabitacion(numero);
        if (habitacion != null) {
            habitacion.limpiar(personalDeLimpieza);
        }
    }

    public void aprobarLimpiezaHabitacion(int numero, String supervisor) {
        Habitacion habitacion = getHabitacion(numero);
        if (habitacion != null) {
            habitacion.aprobarLimpieza(supervisor);
        }
    }

}
