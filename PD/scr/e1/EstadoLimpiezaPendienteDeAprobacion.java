package e1;

public class EstadoLimpiezaPendienteDeAprobacion implements Estado{
    @Override
    public void reservar(Habitacion habitacion, String huesped) {
        System.out.println("La habitacion " + habitacion.getNumero() + " está pendiente de aprobación de limpieza y no se puede reservar.");
    }

    @Override
    public void cancelarReserva(Habitacion habitacion) {
        System.out.println("La habitación " + habitacion.getNumero() + " no tiene una reserva activa para cancelar.");
    }

    @Override
    public void limpiar(Habitacion habitacion, String personalDeLimpieza) {
        System.out.println("La habitación " + habitacion.getNumero() + " ha sido limpiada por " + personalDeLimpieza + " y esta pendiente de aprobación.");
    }

    @Override
    public void aprobarLimpieza(Habitacion habitacion, String supervisor) {
        System.out.println("La limpieza de la habitación " + habitacion.getNumero()+ " ha sido limpiada y está pendiente de aprobación.");
        habitacion.setEstadoActual(new EstadoLibre());
        habitacion.setSupervisor(supervisor);
    }

    @Override
    public String obtenerEstado() {
        return "Limpia y Pendiente de Aprobación";
    }
}
