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

import org.eclipse.swt.internal.win32.INPUT;

import presenter.Presenter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Panel;

public class PantallaIngresarPersonas {

	private JFrame frmIngresarPersonasY;
	private JTextField contPersonasRegistradas;
	private int personasRegistradas;
	private Presenter presenter;
	private final Font tipografia = new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12); 
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
		frmIngresarPersonasY.getContentPane().setBackground(new Color(192, 192, 192));
//		frmIngresarPersonasY.setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaIngresarPersonas.class.getResource("/org/eclipse/jface/fieldassist/images/contassist_ovr.png")));
		frmIngresarPersonasY.setTitle("Ingresar personas y sus interes");
		frmIngresarPersonasY.setBounds(100, 100, 600, 400);
		frmIngresarPersonasY.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIngresarPersonasY.getContentPane().setLayout(null);
		frmIngresarPersonasY.getContentPane().setForeground(null);
		
		JTextPane txtBienvenidoEnEste = new JTextPane();
		txtBienvenidoEnEste.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		txtBienvenidoEnEste.setEditable(false);
		txtBienvenidoEnEste.setText("Bienvenido, en este programa se pedirá que ingrese una persona con su nombre y sus respectivos valores de interés sobre deportes, la música, noticias de espectáculo y la ciencia. Considerando un rango que va del 1 al 5, siendo 1 el interés más bajo y 5 el interés máximo posible.\r\n\r\n");
		txtBienvenidoEnEste.setBounds(10, 11, 564, 73);
		frmIngresarPersonasY.getContentPane().add(txtBienvenidoEnEste);
		
		JLabel etIngresarNombre = new JLabel("Ingrese el nombre de la persona: \r\n");
		etIngresarNombre.setFont(tipografia);
		etIngresarNombre.setBounds(24, 116, 244, 22);
		frmIngresarPersonasY.getContentPane().add(etIngresarNombre);
		
		JTextField inputNombre = new JTextField();
		inputNombre.setHorizontalAlignment(SwingConstants.CENTER);
		inputNombre.setBounds(337, 116, 189, 22);
		inputNombre.setFont(tipografia);
		frmIngresarPersonasY.getContentPane().add(inputNombre);
		inputNombre.setColumns(10);
		
		JLabel etIngresarValores = new JLabel("Ingrese los valores de interés que tiene la persona:");
		etIngresarValores.setFont(tipografia);
		etIngresarValores.setBounds(24, 149, 270, 22);
		frmIngresarPersonasY.getContentPane().add(etIngresarValores);
		
		JLabel etIMusica = new JLabel("Música:");
		etIMusica.setBounds(44, 232, 78, 14);
		etIMusica.setFont(tipografia);
		frmIngresarPersonasY.getContentPane().add(etIMusica);
		
		JLabel etINoticiasEspectaculo = new JLabel("Noticias de espectáculo: ");
		etINoticiasEspectaculo.setFont(tipografia);
		etINoticiasEspectaculo.setBounds(44, 207, 148, 14);
		frmIngresarPersonasY.getContentPane().add(etINoticiasEspectaculo);
		
		JLabel etIDeportes = new JLabel("Deportes:");
		etIDeportes.setFont(tipografia);
		etIDeportes.setBounds(44, 182, 78, 14);
		frmIngresarPersonasY.getContentPane().add(etIDeportes);
		
		JLabel etICiencia = new JLabel("Ciencia:");
		etICiencia.setBounds(44, 257, 78, 14);
		etICiencia.setFont(tipografia);
		frmIngresarPersonasY.getContentPane().add(etICiencia);
		
		JSpinner iDeportes = new JSpinner();
		iDeportes.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		iDeportes.setBounds(202, 182, 40, 20);
		frmIngresarPersonasY.getContentPane().add(iDeportes);
		
		JSpinner iEspectaculo = new JSpinner();
		iEspectaculo.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		iEspectaculo.setBounds(202, 205, 40, 20);
		frmIngresarPersonasY.getContentPane().add(iEspectaculo);
		
		JSpinner iMusica = new JSpinner();
		iMusica.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		iMusica.setBounds(202, 230, 40, 20);
		frmIngresarPersonasY.getContentPane().add(iMusica);
		
		JSpinner iCiencia = new JSpinner();
		iCiencia.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		iCiencia.setBounds(202, 255, 40, 20);
		frmIngresarPersonasY.getContentPane().add(iCiencia);
		
		JLabel condicionAgrupamiento = new JLabel("");
		condicionAgrupamiento.setForeground(Color.RED);
		condicionAgrupamiento.setBounds(257, 321, 296, 22);
		frmIngresarPersonasY.getContentPane().add(condicionAgrupamiento);

		
		JLabel condicionNombre = new JLabel("");
		condicionNombre.setForeground(Color.RED);
		condicionNombre.setBounds(325, 138, 212, 14);
		frmIngresarPersonasY.getContentPane().add(condicionNombre);

		JLabel etCantPersonasR = new JLabel("Cantidad de personas registradas:");
		etCantPersonasR.setFont(tipografia);
		etCantPersonasR.setBounds(24, 290, 189, 30);
		frmIngresarPersonasY.getContentPane().add(etCantPersonasR);
		
		contPersonasRegistradas = new JTextField();
		contPersonasRegistradas.setColumns(10);
		contPersonasRegistradas.setBackground(Color.WHITE);
		contPersonasRegistradas.setHorizontalAlignment(SwingConstants.CENTER);
		contPersonasRegistradas.setEditable(false);
		contPersonasRegistradas.setBounds(217, 296, 51, 20);
		frmIngresarPersonasY.getContentPane().add(contPersonasRegistradas);
		
		JButton btnRegistrarPersona = new JButton("Registrar persona");
		btnRegistrarPersona.setForeground(Color.WHITE);
		btnRegistrarPersona.setBackground(Color.BLACK);		
		btnRegistrarPersona.setBounds(404, 196, 143, 39);
		btnRegistrarPersona.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (validarNombre(inputNombre)) {
					presenter.registrarPersona(inputNombre.getText(), (int) iDeportes.getValue(), (int) iMusica.getValue(), (int) iEspectaculo.getValue(), (int) iCiencia.getValue());
					personasRegistradas++;
					contPersonasRegistradas.setText(""+personasRegistradas);

				}
				else {
					condicionNombre.setText("El campo \"nombre\" debe estar lleno.");
				}
			}
		});
		frmIngresarPersonasY.getContentPane().add(btnRegistrarPersona);
		
		JButton btnAgrupamiento = new JButton("Iniciar agrupamiento");
		btnAgrupamiento.setBackground(Color.BLACK);
		btnAgrupamiento.setForeground(Color.WHITE);
		btnAgrupamiento.setBounds(391, 281, 162, 39);
		btnAgrupamiento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Test
				if (personasRegistradas >= 2)
					presenter.grafoCompleto();
				else
					condicionAgrupamiento.setText("Deben haber un mínimo de 2 personas registradas.");
			}
		});		
		frmIngresarPersonasY.getContentPane().add(btnAgrupamiento);

		
		
	}
	
	
	private boolean validarNombre(JTextField input){
		return input.getText().length() >= 3;
	}
}
