import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class Window {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTable table_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JDBCConnection n = new JDBCConnection();
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 583, 536);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(128, 36, 140, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDaneNowegoKlienta = new JLabel("Dane nowego klienta");
		lblDaneNowegoKlienta.setHorizontalAlignment(SwingConstants.CENTER);
		lblDaneNowegoKlienta.setBounds(77, 11, 120, 14);
		frame.getContentPane().add(lblDaneNowegoKlienta);
		
		JLabel lblImi = new JLabel("Imi\u0119:");
		lblImi.setBounds(10, 39, 108, 14);
		frame.getContentPane().add(lblImi);
		
		JLabel lblNazwisko = new JLabel("Nazwisko:");
		lblNazwisko.setBounds(10, 62, 108, 14);
		frame.getContentPane().add(lblNazwisko);
		
		JLabel lblUlica = new JLabel("Ulica:");
		lblUlica.setBounds(10, 106, 108, 14);
		frame.getContentPane().add(lblUlica);
		
		JLabel lblNrMieszkania = new JLabel("Nr mieszkania:");
		lblNrMieszkania.setBounds(10, 128, 108, 14);
		frame.getContentPane().add(lblNrMieszkania);
		
		JLabel lblNrLokaluopcjonalnie = new JLabel("Nr lokalu:*");
		lblNrLokaluopcjonalnie.setBounds(10, 150, 108, 14);
		frame.getContentPane().add(lblNrLokaluopcjonalnie);
		
		JLabel lblMiescowosc = new JLabel("Miejscowo\u015B\u0107:");
		lblMiescowosc.setBounds(10, 84, 108, 14);
		frame.getContentPane().add(lblMiescowosc);
		
		textField_1 = new JTextField();
		textField_1.setBounds(128, 59, 140, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(128, 81, 140, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(128, 103, 140, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNrKontaktowy = new JLabel("Nr kontaktowy:");
		lblNrKontaktowy.setBounds(10, 172, 108, 14);
		frame.getContentPane().add(lblNrKontaktowy);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 194, 108, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblNewLabel = new JLabel("Sta\u0142y klient:");
		lblNewLabel.setBounds(10, 216, 108, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField_4 = new JTextField();
		textField_4.setBounds(128, 125, 140, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(128, 147, 140, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(128, 169, 140, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(128, 191, 140, 20);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(128, 213, 140, 20);
		comboBox.addItem("Tak");
		comboBox.addItem("Nie");
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Zatwierd\u017A");
		btnNewButton.setBounds(10, 450, 108, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblDanePojazdu = new JLabel("Dane pojazdu");
		lblDanePojazdu.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanePojazdu.setBounds(77, 240, 120, 14);
		frame.getContentPane().add(lblDanePojazdu);
		
		JLabel lblNazwaModelu = new JLabel("Nazwa modelu:");
		lblNazwaModelu.setBounds(10, 265, 108, 14);
		frame.getContentPane().add(lblNazwaModelu);
		
		JLabel lblMarkaPojazdu = new JLabel("Marka pojazdu:");
		lblMarkaPojazdu.setBounds(10, 287, 108, 14);
		frame.getContentPane().add(lblMarkaPojazdu);
		
		JLabel lblNrRejestracyjny = new JLabel("Nr rejestracyjny:");
		lblNrRejestracyjny.setBounds(10, 309, 108, 14);
		frame.getContentPane().add(lblNrRejestracyjny);
		
		JLabel lblNewLabel_1 = new JLabel("Rok produkcji:");
		lblNewLabel_1.setBounds(10, 331, 108, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Przebieg: (w km)");
		lblNewLabel_2.setBounds(10, 353, 108, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_8 = new JTextField();
		textField_8.setBounds(128, 262, 140, 20);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(128, 284, 140, 20);
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(128, 306, 140, 20);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(128, 328, 140, 20);
		frame.getContentPane().add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(128, 350, 140, 20);
		frame.getContentPane().add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblPoleNieobowizkowe = new JLabel("* pole nieobowiazkowe");
		lblPoleNieobowizkowe.setBounds(10, 382, 159, 14);
		frame.getContentPane().add(lblPoleNieobowizkowe);
		
		JLabel lblRodzajNaprawy = new JLabel("Powod:");
		lblRodzajNaprawy.setBounds(10, 410, 108, 14);
		frame.getContentPane().add(lblRodzajNaprawy);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(129, 407, 139, 20);
		comboBox_1.addItem("Naprawa");
		comboBox_1.addItem("Przeglad");
		frame.getContentPane().add(comboBox_1);
		
		JButton btnRealizuj = new JButton("Realizuj");
		btnRealizuj.setBounds(128, 450, 108, 23);
		frame.getContentPane().add(btnRealizuj);
		
		JLabel lblRealizacjaUsugi = new JLabel("Operacje");
		lblRealizacjaUsugi.setHorizontalAlignment(SwingConstants.CENTER);
		lblRealizacjaUsugi.setBounds(353, 11, 120, 14);
		frame.getContentPane().add(lblRealizacjaUsugi);
		
		JLabel lblNewLabel_3 = new JLabel("Realizacja operacji");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(353, 240, 120, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		table_1 = new JTable();
		table_1.setBounds(278, 265, 279, 208);
		frame.getContentPane().add(table_1);
		
		table = new JTable();
		table.setBounds(278, 36, 279, 172);
		frame.getContentPane().add(table);
		
		JButton btnNewButton_1 = new JButton("Zrobione");
		btnNewButton_1.setBounds(468, 212, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
