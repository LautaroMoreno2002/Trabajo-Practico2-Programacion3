package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import presenter.Presenter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Panel;
import java.awt.Window.Type;
import javax.swing.DropMode;

public class PantallaIngresarPersonas {

	private JFrame _frmIngresarPersonasY;
	private JTextField _contPersonasRegistradas;
	private int _personasRegistradas;
	private Presenter _presenter;
	private final Font _tipografia = new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12); 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaIngresarPersonas window = new PantallaIngresarPersonas();
					window._frmIngresarPersonasY.setVisible(true);
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
		initialize();
		_presenter = new Presenter();
		_personasRegistradas = 0;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		_frmIngresarPersonasY = new JFrame();
		_frmIngresarPersonasY.getContentPane().setBackground(new Color(192, 192, 192));
//		frmIngresarPersonasY.setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaIngresarPersonas.class.getResource("/org/eclipse/jface/fieldassist/images/contassist_ovr.png")));
		_frmIngresarPersonasY.setTitle("Clustering humano");
		_frmIngresarPersonasY.setBounds(100, 100, 600, 400);
		_frmIngresarPersonasY.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frmIngresarPersonasY.getContentPane().setLayout(null);
		_frmIngresarPersonasY.getContentPane().setForeground(null);
		
		JTextPane txtBienvenidoEnEste = new JTextPane();
		txtBienvenidoEnEste.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		txtBienvenidoEnEste.setEditable(false);
		txtBienvenidoEnEste.setText("Bienvenido, en este programa se pedirá que ingrese una persona con su nombre y sus respectivos valores de interés sobre deportes, la música, noticias de espectáculo y la ciencia. Considerando un rango que va del 1 al 5, siendo 1 el interés más bajo y 5 el interés máximo posible.\r\n\r\n");
		txtBienvenidoEnEste.setBounds(10, 47, 564, 73);
		_frmIngresarPersonasY.getContentPane().add(txtBienvenidoEnEste);
		
		JLabel etIngresarNombre = new JLabel("Ingrese el nombre de la persona: \r\n");
		etIngresarNombre.setFont(_tipografia);
		etIngresarNombre.setBounds(24, 147, 244, 22);
		_frmIngresarPersonasY.getContentPane().add(etIngresarNombre);
		
		JTextField inputNombre = new JTextField();
		inputNombre.setHorizontalAlignment(SwingConstants.CENTER);
		inputNombre.setBounds(346, 147, 189, 22);
		inputNombre.setFont(_tipografia);
		_frmIngresarPersonasY.getContentPane().add(inputNombre);
		inputNombre.setColumns(10);
		
		JLabel etIngresarValores = new JLabel("Ingrese los valores de interés que tiene la persona:");
		etIngresarValores.setFont(_tipografia);
		etIngresarValores.setBounds(24, 180, 270, 22);
		_frmIngresarPersonasY.getContentPane().add(etIngresarValores);
		
		JLabel etIMusica = new JLabel("Música:");
		etIMusica.setBounds(44, 263, 78, 14);
		etIMusica.setFont(_tipografia);
		_frmIngresarPersonasY.getContentPane().add(etIMusica);
		
		JLabel etINoticiasEspectaculo = new JLabel("Noticias de espectáculo: ");
		etINoticiasEspectaculo.setFont(_tipografia);
		etINoticiasEspectaculo.setBounds(44, 238, 148, 14);
		_frmIngresarPersonasY.getContentPane().add(etINoticiasEspectaculo);
		
		JLabel etIDeportes = new JLabel("Deportes:");
		etIDeportes.setFont(_tipografia);
		etIDeportes.setBounds(44, 213, 78, 14);
		_frmIngresarPersonasY.getContentPane().add(etIDeportes);
		
		JLabel etICiencia = new JLabel("Ciencia:");
		etICiencia.setBounds(44, 288, 78, 14);
		etICiencia.setFont(_tipografia);
		_frmIngresarPersonasY.getContentPane().add(etICiencia);
		
		JSpinner iDeportes = new JSpinner();
		iDeportes.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		iDeportes.setBounds(202, 211, 40, 20);
		_frmIngresarPersonasY.getContentPane().add(iDeportes);
		
		JSpinner iEspectaculo = new JSpinner();
		iEspectaculo.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		iEspectaculo.setBounds(202, 236, 40, 20);
		_frmIngresarPersonasY.getContentPane().add(iEspectaculo);
		
		JSpinner iMusica = new JSpinner();
		iMusica.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		iMusica.setBounds(202, 261, 40, 20);
		_frmIngresarPersonasY.getContentPane().add(iMusica);
		
		JSpinner iCiencia = new JSpinner();
		iCiencia.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		iCiencia.setBounds(202, 282, 40, 20);
		_frmIngresarPersonasY.getContentPane().add(iCiencia);
		
		JLabel condicionAgrupamiento = new JLabel("");
		condicionAgrupamiento.setForeground(Color.RED);
		condicionAgrupamiento.setBounds(278, 321, 296, 22);
		_frmIngresarPersonasY.getContentPane().add(condicionAgrupamiento);

		
		JLabel condicionNombre = new JLabel("");
		condicionNombre.setForeground(Color.RED);
		condicionNombre.setBounds(331, 170, 212, 14);
		_frmIngresarPersonasY.getContentPane().add(condicionNombre);

		JLabel etCantPersonasR = new JLabel("Cantidad de personas registradas:");
		etCantPersonasR.setFont(_tipografia);
		etCantPersonasR.setBounds(18, 313, 189, 30);
		_frmIngresarPersonasY.getContentPane().add(etCantPersonasR);
		
		_contPersonasRegistradas = new JTextField();
		_contPersonasRegistradas.setColumns(10);
		_contPersonasRegistradas.setBackground(Color.WHITE);
		_contPersonasRegistradas.setHorizontalAlignment(SwingConstants.CENTER);
		_contPersonasRegistradas.setEditable(false);
		_contPersonasRegistradas.setBounds(217, 321, 51, 20);
		_frmIngresarPersonasY.getContentPane().add(_contPersonasRegistradas);
		
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
				}
				else {
					condicionNombre.setText("El campo \"nombre\" debe estar lleno.");
				}
			}
		});
		_frmIngresarPersonasY.getContentPane().add(btnRegistrarPersona);
		
		JButton btnAgrupamiento = new JButton("Iniciar agrupamiento");
		btnAgrupamiento.setBackground(Color.BLACK);
		btnAgrupamiento.setForeground(Color.WHITE);
		btnAgrupamiento.setBounds(384, 277, 162, 39);
		btnAgrupamiento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Test
				if (_personasRegistradas >= 2)
					_presenter.grafoCompleto();
				else
					condicionAgrupamiento.setText("Deben haber un mínimo de 2 personas registradas.");
			}
		});		
		_frmIngresarPersonasY.getContentPane().add(btnAgrupamiento);
		
		JLabel lblNewLabel = new JLabel("Clustering Humano");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("JetBrains Mono", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(180, 11, 230, 25);
		_frmIngresarPersonasY.getContentPane().add(lblNewLabel);

		
		
	}
	
	
	private boolean validarNombre(JTextField input){
		return input.getText().length() >= 3;
	}
}
