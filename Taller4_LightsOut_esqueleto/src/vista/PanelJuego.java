package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelJuego extends JPanel {
	private VentanaJuego ventana;
	private JButton nuevo;
	private JButton reiniciar;
	private JButton top;
	private JButton cambiar;
	
	public PanelJuego(VentanaJuego ventana) {
		this.ventana = ventana;
		this.nuevo = crearBoton("NUEVO");
		this.reiniciar = crearBoton("REINICIAR");
		this.top = crearBoton("TOP 10");
		this.cambiar = crearBoton("CAMBIAR JUGADOR");
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setAlignmentX(Component.CENTER_ALIGNMENT);
		setAlignmentY(Component.CENTER_ALIGNMENT);
		
		add(this.nuevo);
		add(this.reiniciar);
		add(this.top);
		add(this.cambiar);
		
	    nuevo.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {

	        }
	    });
	    
	    reiniciar.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {

	        }
	    });
	    
	    top.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {

	        }
	    });
	    
	    cambiar.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {

	        }
	    });
	}
	
	public JButton crearBoton(String nombre) {
		JButton boton = new JButton(nombre);
		boton.setForeground(Color.WHITE);
		boton.setBackground(new Color (3,135,255));
		boton.setFont(new Font("Arial", Font.BOLD, 16));
		return boton;
	}
}