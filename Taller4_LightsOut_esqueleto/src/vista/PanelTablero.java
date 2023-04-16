package vista;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class PanelTablero extends JPanel implements MouseListener {
	private VentanaJuego ventana;
	private int[][] cantidades;
	private boolean[][] tablero;
	private int tamaño;
	private int altoPanel;
	private int anchoPanel;
	private int gap =10;
	private int altoCasilla;
	private int anchoCasilla;

	
	public PanelTablero(VentanaJuego ventana, int tamaño, boolean[][] tablero) {
		this.ventana = ventana;
		this.tamaño = tamaño;
		this.tablero = tablero;
		this.cantidades = new int[tamaño][tamaño];
		addMouseListener(this);
	}
	
	@Override
	public void mousePressed(MouseEvent e){
		int click_x = e.getX();
		int click_y = e.getY();
		int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
		cantidades[casilla[0]][casilla[1]]++;
		ventana.jugar(casilla[0], casilla[1]);
		repaint();
	}
	
	private int[] convertirCoordenadasACasilla(int x, int y){
		int fila = (int) (y / (altoCasilla + gap));
		int columna = (int) (x / (anchoCasilla + gap));
		if (fila >=  tamaño) {
			fila = tamaño - 1;
		}
		if (columna >=  tamaño) {
			columna = tamaño - 1;
		}
		return new int[] { fila, columna };
	}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        anchoPanel = getWidth() - (gap * (tamaño + 1));
        altoPanel = getHeight() - (gap * (tamaño + 1));
        anchoCasilla = anchoPanel / tamaño;
        altoCasilla = altoPanel / tamaño;
        int x = gap;
        int y = gap;
        g2.setFont(new Font("Arial", Font.PLAIN, 14));
        Image image;
		try {
			image = ImageIO.read(new File("data/luz.png"));
	        for (int row = 0; row < tamaño; row++) {
	            for (int col = 0; col < tamaño; col++) {
	            	if(tablero[row][col]) {
	            		g2.setColor(new Color(101, 100, 91));
	            	} else {
	            		g2.setColor(new Color(255, 215, 3));
	            	}
	                g2.fillRoundRect(x, y, anchoCasilla, altoCasilla, 20, 20);
	                g2.drawImage(image, x, y, (int) (anchoCasilla*0.8), (int) (altoCasilla*0.8), null);
            		g2.setColor(Color.BLACK);
	                g2.drawString(String.valueOf(cantidades[row][col]), x+anchoCasilla-2*gap, y+altoCasilla-2*gap);
	                x += anchoCasilla + gap;
	            }
	            y += altoCasilla + gap;
	            x = gap;
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	public void actualizar(boolean[][] tablero) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	
}
