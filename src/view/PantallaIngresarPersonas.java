package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import presenter.Presenter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.awt.Color;

public class PantallaIngresarPersonas {

	private JFrame _frmIngresarPersonas;
	private JTextField _contPersonasRegistradas;
	private int _personasRegistradas;
	private Presenter _presenter;
	private PantallaCargarGrupos pantallaGrupos;
	private final Font _tipografia = new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12); 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaIngresarPersonas window = new PantallaIngresarPersonas();
					window.get_frmIngresarPersonas().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public PantallaIngresarPersonas() {
		_presenter = new Presenter();
		_personasRegistradas = 0;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		_frmIngresarPersonas = new JFrame();
		_frmIngresarPersonas.getContentPane().setBackground(new Color(192, 192, 192));
		_frmIngresarPersonas.setTitle("Clustering humano");
		_frmIngresarPersonas.setBounds(100, 100, 600, 400);
		_frmIngresarPersonas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frmIngresarPersonas.getContentPane().setLayout(null);
		_frmIngresarPersonas.getContentPane().setForeground(null);
		
		JTextPane txtBienvenidoEnEste = new JTextPane();
		txtBienvenidoEnEste.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		txtBienvenidoEnEste.setEditable(false);
		txtBienvenidoEnEste.setText("Bienvenido, en este programa se pedirá que ingrese una persona con su nombre y sus respectivos valores de interés sobre deportes, la música, noticias de espectáculo y la ciencia. Considerando un rango que va del 1 al 5, siendo 1 el interés más bajo y 5 el interés máximo posible.\r\n\r\n");
		txtBienvenidoEnEste.setBounds(10, 47, 564, 73);
		_frmIngresarPersonas.getContentPane().add(txtBienvenidoEnEste);
		
		JLabel etIngresarNombre = new JLabel("Ingrese el nombre de la persona: \r\n");
		etIngresarNombre.setFont(_tipografia);
		etIngresarNombre.setBounds(24, 147, 244, 22);
		_frmIngresarPersonas.getContentPane().add(etIngresarNombre);
		
		JTextField inputNombre = new JTextField();
		inputNombre.setHorizontalAlignment(SwingConstants.CENTER);
		inputNombre.setBounds(346, 147, 189, 22);
		inputNombre.setFont(_tipografia);
		_frmIngresarPersonas.getContentPane().add(inputNombre);
		inputNombre.setColumns(10);
		
		JLabel etIngresarValores = new JLabel("Ingrese los valores de interés que tiene la persona:");
		etIngresarValores.setFont(_tipografia);
		etIngresarValores.setBounds(24, 180, 270, 22);
		_frmIngresarPersonas.getContentPane().add(etIngresarValores);
		
		JLabel etIMusica = new JLabel("Música:");
		etIMusica.setBounds(44, 263, 78, 14);
		etIMusica.setFont(_tipografia);
		_frmIngresarPersonas.getContentPane().add(etIMusica);
		
		JLabel etINoticiasEspectaculo = new JLabel("Noticias de espectáculo: ");
		etINoticiasEspectaculo.setFont(_tipografia);
		etINoticiasEspectaculo.setBounds(44, 238, 148, 14);
		_frmIngresarPersonas.getContentPane().add(etINoticiasEspectaculo);
		
		JLabel etIDeportes = new JLabel("Deportes:");
		etIDeportes.setFont(_tipografia);
		etIDeportes.setBounds(44, 213, 78, 14);
		_frmIngresarPersonas.getContentPane().add(etIDeportes);
		
		JLabel etICiencia = new JLabel("Ciencia:");
		etICiencia.setBounds(44, 288, 78, 14);
		etICiencia.setFont(_tipografia);
		_frmIngresarPersonas.getContentPane().add(etICiencia);
		
		JSpinner iDeportes = new JSpinner();
		iDeportes.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		iDeportes.setBounds(202, 211, 40, 20);
		_frmIngresarPersonas.getContentPane().add(iDeportes);
		
		JSpinner iEspectaculo = new JSpinner();
		iEspectaculo.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		iEspectaculo.setBounds(202, 236, 40, 20);
		_frmIngresarPersonas.getContentPane().add(iEspectaculo);
		
		JSpinner iMusica = new JSpinner();
		iMusica.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		iMusica.setBounds(202, 261, 40, 20);
		_frmIngresarPersonas.getContentPane().add(iMusica);
		
		JSpinner iCiencia = new JSpinner();
		iCiencia.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		iCiencia.setBounds(202, 282, 40, 20);
		_frmIngresarPersonas.getContentPane().add(iCiencia);
		
		JLabel condicionAgrupamiento = new JLabel("");
		condicionAgrupamiento.setForeground(Color.RED);
		condicionAgrupamiento.setBounds(278, 321, 296, 22);
		_frmIngresarPersonas.getContentPane().add(condicionAgrupamiento);

		JLabel condicionNombre = new JLabel("");
		condicionNombre.setForeground(Color.RED);
		condicionNombre.setBounds(331, 170, 212, 14);
		_frmIngresarPersonas.getContentPane().add(condicionNombre);

		JLabel etCantPersonasR = new JLabel("Cantidad de personas registradas:");
		etCantPersonasR.setFont(_tipografia);
		etCantPersonasR.setBounds(18, 313, 189, 30);
		_frmIngresarPersonas.getContentPane().add(etCantPersonasR);
		
		_contPersonasRegistradas = new JTextField();
		_contPersonasRegistradas.setColumns(10);
		_contPersonasRegistradas.setBackground(Color.WHITE);
		_contPersonasRegistradas.setHorizontalAlignment(SwingConstants.CENTER);
		_contPersonasRegistradas.setEditable(false);
		_contPersonasRegistradas.setBounds(217, 321, 51, 20);
		_frmIngresarPersonas.getContentPane().add(_contPersonasRegistradas);
		
		JButton btnRegistrarPersona = new JButton("Registrar persona");
		btnRegistrarPersona.setForeground(Color.WHITE);
		btnRegistrarPersona.setBackground(Color.BLACK);		
		btnRegistrarPersona.setBounds(384, 213, 159, 39);
		btnRegistrarPersona.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (validarNombre(inputNombre)) {
					_presenter.registrarPersona(inputNombre.getText(), (int) iDeportes.getValue(), (int) iMusica.getValue(), (int) iEspectaculo.getValue(), (int) iCiencia.getValue());
					_personasRegistradas++;
					_contPersonasRegistradas.setText(""+_personasRegistradas);
					inputNombre.setText("");
					condicionNombre.setText("");
					condicionAgrupamiento.setText("");
				}
				else {
					condicionNombre.setText("El campo \"nombre\" debe estar lleno.");
				}
			}
		});
		_frmIngresarPersonas.getContentPane().add(btnRegistrarPersona);
		
		JButton btnAgrupamiento = new JButton("Iniciar agrupamiento");
		btnAgrupamiento.setBackground(Color.BLACK);
		btnAgrupamiento.setForeground(Color.WHITE);
		btnAgrupamiento.setBounds(384, 277, 162, 39);
		btnAgrupamiento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Test
                if (_personasRegistradas > 2) {
                    _frmIngresarPersonas.setVisible(false);
                    _presenter.iniciarAgrupamiento();
                    abrirPantallaGrupo(_presenter.getNombresPersonas(),_presenter.getArrayVecinos(),_presenter.getPromedioDeporte(), _presenter.getPromedioMusica(),_presenter.getPromedioEspectaculo(),_presenter.getPromedioMusica(), getPantalla());
                }
                else
                    condicionAgrupamiento.setText("Deben haber un mínimo de 3 personas registradas.");
            }
			private void abrirPantallaGrupo(List<String> nombresPersonas, ArrayList<HashSet<Integer>> arrayVecinos,
                    Double promedioDeporte, Double promedioMusica, Double promedioEspectaculo, Double promedioCiencia, PantallaIngresarPersonas pantallaPersonas) {
                pantallaGrupos = new PantallaCargarGrupos(nombresPersonas, arrayVecinos, promedioDeporte, promedioMusica, promedioEspectaculo, promedioCiencia, getPantalla());
                pantallaGrupos.getFrmGruposDePersonas().setVisible(true);
            }
		});
		_frmIngresarPersonas.getContentPane().add(btnAgrupamiento);
		
		JLabel etTitulo = new JLabel("Clustering Humano");
		etTitulo.setBackground(Color.WHITE);
		etTitulo.setFont(new Font("JetBrains Mono", Font.BOLD, 18));
		etTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		etTitulo.setBounds(180, 11, 230, 25);
		_frmIngresarPersonas.getContentPane().add(etTitulo);
		_frmIngresarPersonas.setVisible(true);
	}
	
	public JFrame get_frmIngresarPersonas() {
		return _frmIngresarPersonas;
	}
	public void set_frmIngresarPersonas(JFrame _frmIngresarPersonas) {
		this._frmIngresarPersonas = _frmIngresarPersonas;
	}
	private PantallaIngresarPersonas getPantalla() {
        return this;
    }
	private boolean validarNombre(JTextField input){
		return input.getText().length() >= 3;
	}
}