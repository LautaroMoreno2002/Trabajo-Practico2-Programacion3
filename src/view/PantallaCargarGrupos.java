package view;

import java.awt.Color;
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
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaCargarGrupos {

	private JFrame frmGruposDePersonas;
	private JMapViewer plano;
	private List<String> _usuarios = new ArrayList<String>();
	private HashMap<Coordinate, Integer> coordenadasConIndice = new HashMap<>();
	private ArrayList<HashSet<Integer>> _vecinos;
	private ArrayList<Coordinate> coordinadas = new ArrayList<Coordinate>();
	private PantallaIngresarPersonas _pantallaPersonas;
	private Double promedioDeporte;
	private Double promedioMusica;
	private Double promedioEspectaculo;
	private Double promedioCiencia;
	private final Font tipografiaBoton = new Font("Segoe UI Historic", Font.PLAIN, 12);
	private final Font tipografiaEtiqueta = new Font("Segoe UI Historic", Font.PLAIN, 11);

	public PantallaCargarGrupos(List<String> _usuarios, ArrayList<HashSet<Integer>> _vecinos, Double promedioDeporte,
			Double promedioMusica, Double promedioEspectaculo, Double promedioCiencia, PantallaIngresarPersonas pantallaPersonas) {
		this._usuarios = _usuarios;
		this._vecinos = _vecinos;
		this._pantallaPersonas = pantallaPersonas;
		this.promedioDeporte = promedioDeporte;
		this.promedioMusica = promedioMusica;
		this.promedioEspectaculo = promedioEspectaculo;
		this.promedioCiencia = promedioCiencia;
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
		
		JPanel panelMapa = new JPanel();
		panelMapa.setBounds(0, 0, 398, 363);
		
		
		frmGruposDePersonas.getContentPane().add(panelMapa);
		frmGruposDePersonas.getContentPane().setLayout(null);
		
		//Nos posicionamos en el atlantico
		panelMapa.add(plano); //
		plano.setZoomControlsVisible(false);
		
		JLabel lblNewLabel = new JLabel("Promedios de interés de cada tema:");
		lblNewLabel.setFont(tipografiaEtiqueta);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(396, 10, 190, 44);
		frmGruposDePersonas.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("- Deporte:");
		lblNewLabel_1.setFont(tipografiaEtiqueta);
		lblNewLabel_1.setBounds(408, 53, 64, 29);
		frmGruposDePersonas.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("- Espectáculo:");
		lblNewLabel_1_1.setFont(tipografiaEtiqueta);
		lblNewLabel_1_1.setBounds(408, 131, 87, 29);
		frmGruposDePersonas.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("- Música:");
		lblNewLabel_1_1_1.setFont(tipografiaEtiqueta);
		lblNewLabel_1_1_1.setBounds(408, 92, 64, 29);
		frmGruposDePersonas.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("- Ciencia:");
		lblNewLabel_1_1_2.setFont(tipografiaEtiqueta);
		lblNewLabel_1_1_2.setBounds(408, 172, 87, 29);
		frmGruposDePersonas.getContentPane().add(lblNewLabel_1_1_2);
		
		JButton btnNuevoAgrupamiento = new JButton("Nuevo agrupamiento");
		btnNuevoAgrupamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGruposDePersonas.setVisible(false);
				PantallaIngresarPersonas pantallaIngresarPersonas = new PantallaIngresarPersonas();
				pantallaIngresarPersonas.get_frmIngresarPersonas().setVisible(true);
			}
		});
		btnNuevoAgrupamiento.setFont(tipografiaBoton);
		btnNuevoAgrupamiento.setBounds(424, 280, 150, 30);
		frmGruposDePersonas.getContentPane().add(btnNuevoAgrupamiento);
		
		JButton btnAgregarPersona = new JButton("Agregar persona");
        btnAgregarPersona.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                abrirPantallaPersonas();
            }

            private void abrirPantallaPersonas() {
                frmGruposDePersonas.setVisible(false);
                _pantallaPersonas.get_frmIngresarPersonas().setVisible(true);

            }
        });
		btnAgregarPersona.setFont(tipografiaBoton);
		btnAgregarPersona.setBounds(424, 319, 150, 30);
		frmGruposDePersonas.getContentPane().add(btnAgregarPersona);
		
		JLabel deporteGrupo2 = new JLabel(promedioDeporte.toString());
		deporteGrupo2.setFont(new Font("Arial", Font.BOLD, 12));
		deporteGrupo2.setBounds(531, 54, 41, 29);
		frmGruposDePersonas.getContentPane().add(deporteGrupo2);
		
		JLabel MusicaGrupo2 = new JLabel(promedioMusica.toString());
		MusicaGrupo2.setFont(new Font("Arial", Font.BOLD, 12));
		MusicaGrupo2.setBounds(531, 93, 41, 29);
		frmGruposDePersonas.getContentPane().add(MusicaGrupo2);
		
		JLabel espectaculoGrupo2 = new JLabel(promedioEspectaculo.toString());
		espectaculoGrupo2.setFont(new Font("Arial", Font.BOLD, 12));
		espectaculoGrupo2.setBounds(531, 132, 41, 29);
		frmGruposDePersonas.getContentPane().add(espectaculoGrupo2);
		
		JLabel cienciaGrupo2 = new JLabel(promedioCiencia.toString());
		cienciaGrupo2.setFont(new Font("Arial", Font.BOLD, 12));
		cienciaGrupo2.setBounds(533, 173, 41, 29);
		frmGruposDePersonas.getContentPane().add(cienciaGrupo2);
		

		Coordinate coordinada = new Coordinate(-39.4, -30.19);
		plano.setDisplayPosition(coordinada, 8); //PARA CAMBIAR EL ZOOM
		
		//Poligono
		
		double latitud = -38.990380;
		double longitud = -30.197439;
		double cont= 0.0;
		
		
		for (int i = 0; i < _usuarios.size(); i++) {
			
			crearNuevoPuntoEnElPlano(latitud,longitud,i);

		    double deltaLat = -0.1;
		    double deltaLon = -0.2;
		    
		    if(i%2==0||i==1) {
			    latitud += deltaLat;
			    longitud += deltaLon+cont;
		    } else if(i%2!=0) {
			    latitud += deltaLat;
			    longitud -= deltaLon+cont;
		    }
		    
		    cont+=0.2;
		}
		

		for (int vertice = 0; vertice < _vecinos.size(); vertice++) {
			ArrayList<Coordinate> coordinates = armarArregloConVecinosDelVertice(vertice);
			crearArista(coordinates, vertice);
		}
	}

	public JFrame getFrmGruposDePersonas() {
		return frmGruposDePersonas;
	}
	
	//FUNCIONES AUXILIARES!!!!!!!!!!!
	
	private void crearNuevoPuntoEnElPlano(double latitud, double longitud, int i) {
	    Coordinate coordinadasPunto = new Coordinate(latitud, longitud); // Crea una nueva instancia en cada iteración
	    
	    MapMarker marker = new MapMarkerDot(_usuarios.get(i),coordinadasPunto);
	    
	    
	    //Agregamos las coordenadasConIndice al poligono
	    coordenadasConIndice.put(coordinadasPunto,i);
	    coordinadas.add(coordinadasPunto);
	    
	    marker.getStyle().setBackColor(Color.PINK);
	    marker.getStyle().setColor(Color.WHITE);
	    plano.addMapMarker(marker);
	}
	
	
	private void crearArista(ArrayList<Coordinate> coordinates, int vertice) {
		for (int i = 0; i < coordinates.size(); i += 2) {
			if (i + 1 < coordinates.size()) {
				List<Coordinate> route2 = new ArrayList<Coordinate>(Arrays.asList(coordinadas.get(vertice), coordinates.get(i), coordinates.get(i)));
				plano.addMapPolygon(new MapPolygonImpl(route2));
			}
		}
	}
	
	private ArrayList<Coordinate> armarArregloConVecinosDelVertice(int vertice) {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>(); //Para guardar las coordenadasConIndice de cada vecino
		
		HashSet<Integer> vecinosDeI = _vecinos.get(vertice);
		
		for (int vecino : vecinosDeI) {
			// Para cada vecino en vecinosDeI, intenta encontrar la coordenada correspondiente en el HashMap coordenadasConIndice
		    for (Map.Entry<Coordinate, Integer> entry : coordenadasConIndice.entrySet()) {
		        if (entry.getValue().equals(vecino)) {
		        	Coordinate coordenada = entry.getKey();
		        	coordinates.add(coordenada);
		        }
		    }
		}
		
		coordinates.add(coordinadas.get(vertice)); //agregamos la coordenada del vertice en el que nos paramos al array de las coordenadasConIndice de los vecinos
		
		return coordinates;
	}
	
}

