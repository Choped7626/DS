package e1;

public class EstadoOcupada implements Estado{
    @Override
    public void reservar(Habitacion habitacion, String huesped) {
        System.out.println("La habitacion " + habitacion.getNumero() + " ya está ocupada.");
    }

    @Override
    public void cancelarReserva(Habitacion habitacion) {
        habitacion.setHuespedActual(null);
        habitacion.setEstadoActual(new EstadoPendienteDeLimpieza());
    }

    @Override
    public void limpiar(Habitacion habitacion, String personalDeLimpieza) {
        System.out.println("La habitación " + habitacion.getNumero() + " está ocupada por " + habitacion.getHuespedActual() + " y, por lo tanto, no se puede limpiar.");
    }

    @Override
    public void aprobarLimpieza(Habitacion habitacion, String supervisor) {
        System.out.println("La habitación" + habitacion.getNumero() + " está ocupada y por tanto no se puede limpiar");
    }

    @Override
    public String obtenerEstado() {
        return "Ocupada";
    }
}
