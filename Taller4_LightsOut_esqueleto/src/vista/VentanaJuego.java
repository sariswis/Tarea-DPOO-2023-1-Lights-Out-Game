package vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Component;

import com.formdev.flatlaf.FlatLightLaf;

import uniandes.dpoo.taller4.modelo.Top10;
import uniandes.dpoo.taller4.modelo.Tablero;

@SuppressWarnings("serial")
public class VentanaJuego extends JFrame {
	private Tablero tablero;
	private Top10 top10;
	private int tam = 5;
	private int dificultad = 5;
	private PanelSuperior pSuperior;
	private PanelTablero pTablero;
	private PanelJuego pJuego;
	private PanelInferior pInferior;
	
	public VentanaJuego() {
		this.tablero = new Tablero(tam);
		this.tablero.desordenar(dificultad);
		this.top10 = new Top10();
		this.pSuperior= new PanelSuperior(this);
		this.pTablero = new PanelTablero(this, tam, tablero.darTablero());
		this.pJuego = new PanelJuego(this);
		this.pInferior = new PanelInferior(tablero.darJugadas());
		
		setLayout(new BorderLayout());
		add(this.pSuperior, BorderLayout.NORTH);
		add(this.pTablero, BorderLayout.CENTER);
		add(this.pJuego, BorderLayout.EAST);
		add(this.pInferior, BorderLayout.SOUTH);
		
		setTitle("Lights Out");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setSize(800, 600);
		
		// Esto se usa para que al cerrar la ventana se salven los resultados
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				salvarTop10();
			}
		});
		
	}
	
	public static void main(String[] args) {
		FlatLightLaf.install();
		new VentanaJuego();
	}
	
	public void salvarTop10() {
		
	}

	public void jugar(int i, int j) {
		tablero.jugar(i,  j);
		pTablero.actualizar(tablero.darTablero());
		pInferior.setJugadas(tablero.darJugadas());
		if(tablero.tableroIluminado()) {
			
		}
	}
	
	public void setTamaño(int tamaño) {
		this.tam = tamaño;
		this.tablero = new Tablero(tam);
		this.tablero.desordenar(dificultad);
		pInferior.setJugadas(tablero.darJugadas());
		remove(this.pTablero);
		this.pTablero = new PanelTablero(this, tam, tablero.darTablero());
		add(this.pTablero, BorderLayout.CENTER);
		revalidate();
		repaint();
	}
	
	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
		this.tablero.reiniciar();
		this.tablero.desordenar(dificultad);
		pInferior.setJugadas(tablero.darJugadas());
		remove(this.pTablero);
		this.pTablero = new PanelTablero(this, tam, tablero.darTablero());
		add(this.pTablero, BorderLayout.CENTER);
		revalidate();
		repaint();
	}

}
