package punto_5.Controlador;

import punto_5.Modelo.*;
import punto_5.Vista.*;


public class ControladorChat {
    private ModeloChat modelo;
    private VistaChat vista;
    private ModeloJugador jugadorActual;

    public ControladorChat(ModeloChat modelo, VistaChat vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setControlador(this);
    }

    public void setJugadorActual(ModeloJugador jugador) {
        jugadorActual = jugador;
    }

    public void enviarMensaje() {
        String texto = vista.obtenerTexto().trim();

        if (texto.isEmpty() || jugadorActual == null) {
            return;
        }

        ModeloMensaje mensaje = new ModeloMensaje(texto, jugadorActual);
        mensaje.enviar(modelo);

        vista.limpiarMensaje();
        actualizarChat();
    }

    public void actualizarChat() {
        vista.limpiarConversacion();

        for (ModeloMensaje mensaje : modelo.obtenerMensajes()) {
            String texto = mensaje.getEmisor().getNombre()
                    + ": " + mensaje.getMensaje();

            vista.mostrarMensaje(texto);
        }
    }
}