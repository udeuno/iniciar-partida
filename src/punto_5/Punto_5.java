package punto_5;

import javax.swing.*;
import punto_5.Modelo.*;
import punto_5.Vista.*;
import punto_5.Controlador.*;

public class Punto_5 {

    
    public static void main(String[] args) {
       SwingUtilities.invokeLater(() -> {
            ModeloChat modeloChat = new ModeloChat();
            VistaChat vistaChat = new VistaChat();
            ControladorChat controladorChat =
                    new ControladorChat(modeloChat, vistaChat);

            ModeloLobby modeloLobby = new ModeloLobby();
            VistaLobby vistaLobby = new VistaLobby(vistaChat);

            ControladorLobby controladorLobby =
                    new ControladorLobby(
                            modeloLobby,
                            vistaLobby,
                            controladorChat
                    );

            JFrame ventana = new JFrame("Lobby de juego");
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setSize(700, 450);
            ventana.setLocationRelativeTo(null);
            ventana.setContentPane(vistaLobby);

            controladorLobby.unirJugador(
                    new ModeloJugador("marcelo", 0)
            );

            controladorLobby.unirJugador(
                    new ModeloJugador("Jugador 2", 1)
            );

            ventana.setVisible(true);
        });
    }
    
}
