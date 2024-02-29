package e1;

public class EstadoLibre implements Estado{
    @Override
    public void reservar(Habitacion habitacion, String huesped) {
        habitacion.setHuespedActual(huesped);
        habitacion.setEstadoActual(new EstadoOcupada());
    }

    @Override
    public void cancelarReserva(Habitacion habitacion) {
        System.out.println("La habitación " + habitacion.getNumero() + " está libre. Por lo tanto, no está reservada");
    }

    @Override
    public void limpiar(Habitacion habitacion, String personalDeLimpieza) {
        System.out.println("La habitación " + habitacion.getNumero() + " está libre y su limpieza fue realizada por " + personalDeLimpieza);
        habitacion.setEstadoActual(new EstadoLimpiezaPendienteDeAprobacion());
    }

    @Override
    public void aprobarLimpieza(Habitacion habitacion, String supervisor) {
        System.out.println("La habitación " + habitacion.getNumero() + " está libre y su limpieza fue aprobada por " + supervisor);

    }

    @Override
    public String obtenerEstado() {
        return "Libre";
    }
}
