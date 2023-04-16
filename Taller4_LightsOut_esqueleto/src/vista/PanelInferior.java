package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelInferior extends JPanel {
	private JLabel jugadas;
	private JLabel jugador;
	
	public PanelInferior(int numJugadas) {
		this.jugadas = crearLabel(String.valueOf(numJugadas));
		this.jugador = crearLabel("");
		
		setLayout(new GridLayout(1,4));
		setBackground(Color.LIGHT_GRAY);
		
		add(crearLabel("Jugadas:"));
		add(jugadas);
		add(crearLabel("Jugador:"));
		add(jugador);
	}
	
	public void setJugadas(int cantidad) {
		jugadas.setText(String.valueOf(cantidad));
	}
	
	public void setJugador(String nombre) {
		jugador.setText(nombre);
	}
	
	public JLabel crearLabel(String nombre) {
		JLabel label = new JLabel(nombre);
		label.setFont(new Font("Arial", Font.PLAIN, 16));
		return label;
	}
}