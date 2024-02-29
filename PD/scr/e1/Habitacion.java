package e1;

public class Habitacion {
    private final int numero;
    private Estado estadoActual;
    private String supervisor;
    private String huespedActual;

    protected Habitacion(int numero, String supervisor) {
        this.numero = numero;
        this.supervisor = supervisor;
        this.estadoActual = new EstadoLibre();
    }

    public void reservar(String huesped) {
        this.huespedActual = huesped;
        estadoActual.reservar(this,huesped);
    }

    public void cancelarReserva() {
        this.huespedActual = null;
        estadoActual.cancelarReserva(this);
    }

    public void limpiar(String personalDeLimpieza) {
        estadoActual.limpiar(this, personalDeLimpieza);
    }

    public void aprobarLimpieza(String supervisor) {
        this.supervisor = supervisor;
        estadoActual.aprobarLimpieza(this, supervisor);
    }

    public void setEstadoActual(Estado nuevoEstado) {
        this.estadoActual = nuevoEstado;
    }

    public Estado getEstadoActual() {
        return estadoActual;
    }
    public String obtenerInformacion() {
        String info = "Habitación número " + numero + ": ";

        if (estadoActual instanceof EstadoOcupada)
            info += "Reservada por "+ huespedActual + ". Ocupada.";
        else {
            info += estadoActual.obtenerEstado();
            if (estadoActual instanceof EstadoLibre)
                info += ". Aprobada por " + supervisor + ".";
        }

        return info;
    }

    public int getNumero() {
        return numero;
    }

    public String getHuespedActual() {
        return huespedActual;
    }

    public void setHuespedActual(String huespedActual) {
        this.huespedActual = huespedActual;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

}
