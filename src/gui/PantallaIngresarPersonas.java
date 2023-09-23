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
import java.awt.Toolkit;

public class PantallaIngresarPersonas {

	private JFrame frmIngresarPersonasY;
	private JTextField textField_1;
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIngresarPersonasY = new JFrame();
		frmIngresarPersonasY.setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaIngresarPersonas.class.getResource("/org/eclipse/jface/fieldassist/images/contassist_ovr.png")));
		frmIngresarPersonasY.setTitle("Ingresar personas y sus interes");
		frmIngresarPersonasY.setBounds(100, 100, 600, 400);
		frmIngresarPersonasY.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIngresarPersonasY.getContentPane().setLayout(null);
		
		JTextPane txtpnBienvenidoEnEste = new JTextPane();
		txtpnBienvenidoEnEste.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		txtpnBienvenidoEnEste.setEditable(false);
		txtpnBienvenidoEnEste.setText("Bienvenido, en este programa se pedirá que ingrese una persona con su nombre y sus respectivos valores de interés sobre deportes, la música, noticias de espectáculo y la ciencia. Considerando un rango que va del 1 al 5, siendo 1 el interés más bajo y 5 el interés máximo posible.\r\n\r\n");
		txtpnBienvenidoEnEste.setBounds(10, 11, 564, 73);
		frmIngresarPersonasY.getContentPane().add(txtpnBienvenidoEnEste);
		
		JLabel lblNewLabel = new JLabel("Ingrese el nombre de la persona: \r\n");
		lblNewLabel.setBounds(57, 116, 162, 22);
		frmIngresarPersonasY.getContentPane().add(lblNewLabel);
		
		JTextField txtNombre = new JTextField();
		txtNombre.setBounds(337, 116, 189, 22);
		frmIngresarPersonasY.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese los valores de interés que tiene la persona:");
		lblNewLabel_1.setBounds(57, 149, 259, 22);
		frmIngresarPersonasY.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Música:");
		lblNewLabel_2.setBounds(82, 232, 78, 14);
		frmIngresarPersonasY.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Noticias de espectáculo: ");
		lblNewLabel_2_1.setBounds(82, 207, 119, 14);
		frmIngresarPersonasY.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Deportes:");
		lblNewLabel_2_1_1.setBounds(82, 182, 78, 14);
		frmIngresarPersonasY.getContentPane().add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Ciencia:");
		lblNewLabel_2_1_2.setBounds(82, 257, 78, 14);
		frmIngresarPersonasY.getContentPane().add(lblNewLabel_2_1_2);
		
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
		
		JButton btnNewButton = new JButton("Iniciar agrupamiento");
		btnNewButton.setBounds(403, 302, 143, 39);
		frmIngresarPersonasY.getContentPane().add(btnNewButton);
		
		JButton btnRegistrarPersona = new JButton("Registrar persona");
		btnRegistrarPersona.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				presenter.registrarPersona(txtNombre.getText(), (int) iDeportes.getValue(), (int) iMusica.getValue(), (int) iEspectaculo.getValue(), (int) iCiencia.getValue());
			}
		});
		btnRegistrarPersona.setBounds(403, 195, 143, 39);
		frmIngresarPersonasY.getContentPane().add(btnRegistrarPersona);
		
		JLabel lblNewLabel_3 = new JLabel("Cantidad de personas registradas:");
		lblNewLabel_3.setBounds(57, 302, 173, 14);
		frmIngresarPersonasY.getContentPane().add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setEditable(false);
		textField_1.setBounds(250, 299, 51, 20);
		frmIngresarPersonasY.getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
}
