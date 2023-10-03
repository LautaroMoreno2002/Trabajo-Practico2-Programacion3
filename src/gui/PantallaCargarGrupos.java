package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class PantallaCargarGrupos {

	private JFrame frmGruposDePersonas;

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGruposDePersonas = new JFrame();
		frmGruposDePersonas.setTitle("Grupos de personas similares");
		frmGruposDePersonas.setBounds(100, 100, 600, 400);
		frmGruposDePersonas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
