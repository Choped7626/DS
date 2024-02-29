package e1;

public class EstadoPendienteDeLimpieza implements Estado{
    @Override
    public void reservar(Habitacion habitacion, String huesped) {
        System.out.println("La habitacion " + habitacion.getNumero() + " está pendiente de limpieza. No se puede reservar.");
    }

    @Override
    public void cancelarReserva(Habitacion habitacion) {
        System.out.println("La habitacion " + habitacion.getNumero() + " está en proceso de limpieza y no está disponible.");
    }

    @Override
    public void limpiar(Habitacion habitacion, String personalDeLimpieza) {
        System.out.println("La habitación " + habitacion.getNumero() + " esta pendiente de limpieza.");
        habitacion.setEstadoActual(new EstadoLimpiezaPendienteDeAprobacion());
    }

    @Override
    public void aprobarLimpieza(Habitacion habitacion, String supervisor) {
        System.out.println("La habitación " + habitacion.getNumero() + " está sucia. Pendiente de limpieza.");
    }

    @Override
    public String obtenerEstado() {
        return "Pendiente de Limpieza";
    }
}
