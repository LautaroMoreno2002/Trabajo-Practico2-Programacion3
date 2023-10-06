package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;
import org.openstreetmap.gui.jmapviewer.interfaces.MapPolygon;

public class PantallaCargarGrupos {

	private JFrame frmGruposDePersonas;
	private JMapViewer plano;
	private List<String> usuarios = new ArrayList<String>();
	private ArrayList<Coordinate> coordinadas = new ArrayList<Coordinate>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaCargarGrupos window = new PantallaCargarGrupos();
					window.frmGruposDePersonas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaCargarGrupos() {
		initialize();
	}
	
	

	public PantallaCargarGrupos(List<String> usersArray) {
		super();
		this.usuarios = usersArray;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGruposDePersonas = new JFrame();
		frmGruposDePersonas.setTitle("Grupos de personas similares");
		frmGruposDePersonas.setBounds(100, 100, 600, 400);
		frmGruposDePersonas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		plano = new JMapViewer();
		
		//Nos posicionamos en el atlantico
		frmGruposDePersonas.getContentPane().add(plano);
		plano.setZoomControlsVisible(false);
		Coordinate coordinada = new Coordinate(-38.990380, -30.197439);
		plano.setDisplayPosition(coordinada, 8); //PARA CAMBIAR EL ZOOM
		
		//Agregamos un marcador
//		MapMarker marker1 = new MapMarkerDot("Acá iría el nombre", coordinate);
//		marker1.getStyle().setBackColor(Color.PINK);
//		marker1.getStyle().setColor(Color.WHITE);
//		plano.addMapMarker(marker1);
//		
//		Coordinate coordinate2 = new Coordinate(-38.990400, -30.300);
//		MapMarker marker2 = new MapMarkerDot("aaaa", coordinate2);
//		marker1.getStyle().setBackColor(Color.PINK);
//		marker1.getStyle().setColor(Color.WHITE);
//		plano.addMapMarker(marker2);
		
		//Poligono
		double latitud = -38.990380;
		double longitud = -30.197439;
		
		for (int i = 0; i < usuarios.size(); i++) {
		    Coordinate coordinadasPunto = new Coordinate(latitud, longitud); // Crea una nueva instancia en cada iteración
		    MapMarker marker = new MapMarkerDot(usuarios.get(i),coordinadasPunto);
		    
		    //Agregamos las coordenadas al poligono
		    coordinadas.add(coordinadasPunto);
		    
		    marker.getStyle().setBackColor(Color.PINK);
		    marker.getStyle().setColor(Color.WHITE);
		    plano.addMapMarker(marker);

		    double deltaLat = -0.1; // Cambia las coordenadas por una cantidad diferente
		    double deltaLon = -0.1;
		    latitud += deltaLat; // Actualiza las coordenadas para la próxima iteración
		    longitud += deltaLon;
		    
		    
		}
		MapPolygon poligono = new MapPolygonImpl(coordinadas);
		plano.addMapPolygon(poligono);
	}


	public JFrame getFrmGruposDePersonas() {
		return frmGruposDePersonas;
	}

	
	

}
