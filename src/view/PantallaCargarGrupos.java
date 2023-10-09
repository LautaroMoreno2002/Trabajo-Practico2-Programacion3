package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

public class PantallaCargarGrupos {

	private JFrame frmGruposDePersonas;
	private JMapViewer plano;
	private List<String> usuarios = new ArrayList<String>();
	private HashMap<Coordinate, Integer> coordenadas = new HashMap<>();
	private ArrayList<HashSet<Integer>> _vecinos;
	
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
	public PantallaCargarGrupos(List<String> usersArray, ArrayList<HashSet<Integer>> _vecinos) {
		this.usuarios = usersArray;
		this._vecinos = _vecinos;
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
		double cont= 0.0;
		
		ArrayList<Coordinate> coordinadas = new ArrayList<Coordinate>();
		for (int i = 0; i < usuarios.size(); i++) {
		    Coordinate coordinadasPunto = new Coordinate(latitud, longitud); // Crea una nueva instancia en cada iteración
		    
		    MapMarker marker = new MapMarkerDot(usuarios.get(i),coordinadasPunto);
		    
		    
		    //Agregamos las coordenadas al poligono
		    coordenadas.put(coordinadasPunto,i);
		    coordinadas.add(coordinadasPunto);
		    
		    marker.getStyle().setBackColor(Color.PINK);
		    marker.getStyle().setColor(Color.WHITE);
		    plano.addMapMarker(marker);

		    double deltaLat = -0.1; // Cambia las coordenadas por una cantidad diferente
		    double deltaLon = -0.2;
		    
		    
		    if(i%2==0||i==1) {
			    latitud += deltaLat; // Actualiza las coordenadas para la próxima iteración
			    longitud += deltaLon+cont;
		    } else if(i%2!=0) {
			    latitud += deltaLat; // Actualiza las coordenadas para la próxima iteración
			    longitud -= deltaLon+cont;
		    }
		    
		    cont+=0.2;
		}
		
//		Coordinate newCoordinate = new Coordinate(coordinadas.get(2).getLat(), coordinadas.get(2).getLon()+0.2);
//		coordinadas.set(2, newCoordinate);
		
//		Coordinate one = coordinadas.get(0);
//		Coordinate two = coordinadas.get(1);
//		
//		List<Coordinate> route = new ArrayList<Coordinate>(Arrays.asList(coordinadas.get(0), coordinadas.get(1), coordinadas.get(1)));
//		MapPolygon poligono = new MapPolygonImpl(coordinadas);
//		plano.addMapPolygon(new MapPolygonImpl(route));
		
		
		
		for (int vertice = 0; vertice < _vecinos.size(); vertice++) {
			ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>(); //Para guardar las coordenadas de cada vecino
			
			HashSet<Integer> vecinosDeI = _vecinos.get(vertice);

			for (int vecino : vecinosDeI) {
				// Para cada vecino en vecinosDeI, intenta encontrar la coordenada correspondiente en el HashMap coordenadas
			    for (Map.Entry<Coordinate, Integer> entry : coordenadas.entrySet()) {
			        if (entry.getValue().equals(vecino)) {
			        	Coordinate coordenada = entry.getKey();
			        	coordinates.add(coordenada);
			        }
			    }
			}
			
			coordinates.add(coordinadas.get(vertice)); //agregamos la coordenada del vertice en el que nos paramos al array de las coordenadas de los vecinos
			
			for (int i = 0; i < coordinates.size(); i += 2) {
				if (i + 1 < coordinates.size()) {
					List<Coordinate> route2 = new ArrayList<Coordinate>(Arrays.asList(coordinadas.get(vertice), coordinates.get(i), coordinates.get(i)));
					plano.addMapPolygon(new MapPolygonImpl(route2));
				}
			}
	}
	}


	public JFrame getFrmGruposDePersonas() {
		return frmGruposDePersonas;
	}
}
