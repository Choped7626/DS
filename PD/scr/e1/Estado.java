package e1;

public interface Estado {
    void reservar(Habitacion habitacion, String huesped);
    void cancelarReserva(Habitacion habitacion);
    void limpiar(Habitacion habitacion, String personalDeLimpieza);
    void aprobarLimpieza(Habitacion habitacion, String supervisor);
    String obtenerEstado();
}
