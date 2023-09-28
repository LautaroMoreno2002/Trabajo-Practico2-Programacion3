package gui;

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

public class PantallaIngresarPersonas {

	private JFrame frmIngresarPersonasY;
	private JTextField contPersonasRegistradas;
	private int personasRegistradas;
	private Presenter presenter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaIngresarPersonas window = new PantallaIngresarPersonas();
					window.frmIngresarPersonasY.setVisible(true);
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
		presenter = new Presenter();
		personasRegistradas = 0;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIngresarPersonasY = new JFrame();
//		frmIngresarPersonasY.setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaIngresarPersonas.class.getResource("/org/eclipse/jface/fieldassist/images/contassist_ovr.png")));
		frmIngresarPersonasY.setTitle("Ingresar personas y sus interes");
		frmIngresarPersonasY.setBounds(100, 100, 600, 400);
		frmIngresarPersonasY.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIngresarPersonasY.getContentPane().setLayout(null);
		
		JTextPane txtBienvenidoEnEste = new JTextPane();
		txtBienvenidoEnEste.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		txtBienvenidoEnEste.setEditable(false);
		txtBienvenidoEnEste.setText("Bienvenido, en este programa se pedirá que ingrese una persona con su nombre y sus respectivos valores de interés sobre deportes, la música, noticias de espectáculo y la ciencia. Considerando un rango que va del 1 al 5, siendo 1 el interés más bajo y 5 el interés máximo posible.\r\n\r\n");
		txtBienvenidoEnEste.setBounds(10, 11, 564, 73);
		frmIngresarPersonasY.getContentPane().add(txtBienvenidoEnEste);
		
		JLabel etIngresarNombre = new JLabel("Ingrese el nombre de la persona: \r\n");
		etIngresarNombre.setBounds(57, 116, 162, 22);
		frmIngresarPersonasY.getContentPane().add(etIngresarNombre);
		
		JTextField inputNombre = new JTextField();
		inputNombre.setBounds(337, 116, 189, 22);
		frmIngresarPersonasY.getContentPane().add(inputNombre);
		inputNombre.setColumns(10);
		
		JLabel etIngresarValores = new JLabel("Ingrese los valores de interés que tiene la persona:");
		etIngresarValores.setBounds(57, 149, 259, 22);
		frmIngresarPersonasY.getContentPane().add(etIngresarValores);
		
		JLabel etIMusica = new JLabel("Música:");
		etIMusica.setBounds(82, 232, 78, 14);
		frmIngresarPersonasY.getContentPane().add(etIMusica);
		
		JLabel etINoticiasEspectaculo = new JLabel("Noticias de espectáculo: ");
		etINoticiasEspectaculo.setBounds(82, 207, 119, 14);
		frmIngresarPersonasY.getContentPane().add(etINoticiasEspectaculo);
		
		JLabel etIDeportes = new JLabel("Deportes:");
		etIDeportes.setBounds(82, 182, 78, 14);
		frmIngresarPersonasY.getContentPane().add(etIDeportes);
		
		JLabel etICiencia = new JLabel("Ciencia:");
		etICiencia.setBounds(82, 257, 78, 14);
		frmIngresarPersonasY.getContentPane().add(etICiencia);
		
		JSpinner iDeportes = new JSpinner();
		iDeportes.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		iDeportes.setBounds(288, 179, 41, 20);
		frmIngresarPersonasY.getContentPane().add(iDeportes);
		
		JSpinner iEspectaculo = new JSpinner();
		iEspectaculo.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		iEspectaculo.setBounds(288, 204, 41, 20);
		frmIngresarPersonasY.getContentPane().add(iEspectaculo);
		
		JSpinner iMusica = new JSpinner();
		iMusica.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		iMusica.setBounds(288, 229, 41, 20);
		frmIngresarPersonasY.getContentPane().add(iMusica);
		
		JSpinner iCiencia = new JSpinner();
		iCiencia.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		iCiencia.setBounds(288, 254, 41, 20);
		frmIngresarPersonasY.getContentPane().add(iCiencia);
		
		JButton btnAgrupamiento = new JButton("Iniciar agrupamiento");
		
		btnAgrupamiento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Test
				presenter.grafoCompleto();
			}
		});
		
		btnAgrupamiento.setBounds(403, 302, 143, 39);
		frmIngresarPersonasY.getContentPane().add(btnAgrupamiento);
		
		JButton btnRegistrarPersona = new JButton("Registrar persona");
		
		btnRegistrarPersona.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				presenter.registrarPersona(inputNombre.getText(), (int) iDeportes.getValue(), (int) iMusica.getValue(), (int) iEspectaculo.getValue(), (int) iCiencia.getValue());
				personasRegistradas++;
				contPersonasRegistradas.setText(""+personasRegistradas);
			}
		});
		
		btnRegistrarPersona.setBounds(403, 195, 143, 39);
		frmIngresarPersonasY.getContentPane().add(btnRegistrarPersona);
		
		JLabel etCantPersonasR = new JLabel("Cantidad de personas registradas:");
		etCantPersonasR.setBounds(57, 302, 173, 14);
		frmIngresarPersonasY.getContentPane().add(etCantPersonasR);
		
		contPersonasRegistradas = new JTextField();
		contPersonasRegistradas.setHorizontalAlignment(SwingConstants.CENTER);
		contPersonasRegistradas.setEditable(false);
		contPersonasRegistradas.setBounds(250, 299, 51, 20);
		frmIngresarPersonasY.getContentPane().add(contPersonasRegistradas);
		contPersonasRegistradas.setColumns(10);
	}
}
