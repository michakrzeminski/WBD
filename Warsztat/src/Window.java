import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Window {

	private JFrame frame;
	private JTextField field_imie;
	private JTextField field_nazwisko;
	private JTextField field_miejsc;
	private JTextField field_ulica;
	private JTextField field_nr_m;
	private JTextField field_nr_l;
	private JTextField field_tel;
	private JTextField field_email;
	private JTextField field_model;
	private JTextField field_marka;
	private JTextField field_rejestr;
	private JTextField field_rok;
	private JTextField field_przebieg;
	private JTable table_1;
	private JTable table;
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_1;
	private JLabel error;
	private int zmienna=0;
	
	private int id=0;
	
	private static JDBCConnection database;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					database = new JDBCConnection();
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
		
		field_imie = new JTextField();
		field_imie.setBounds(128, 36, 140, 20);
		frame.getContentPane().add(field_imie);
		field_imie.setColumns(10);
		
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
		
		field_nazwisko = new JTextField();
		field_nazwisko.setBounds(128, 59, 140, 20);
		frame.getContentPane().add(field_nazwisko);
		field_nazwisko.setColumns(10);
		
		field_miejsc = new JTextField();
		field_miejsc.setBounds(128, 81, 140, 20);
		frame.getContentPane().add(field_miejsc);
		field_miejsc.setColumns(10);
		
		field_ulica = new JTextField();
		field_ulica.setBounds(128, 103, 140, 20);
		frame.getContentPane().add(field_ulica);
		field_ulica.setColumns(10);
		
		JLabel lblNrKontaktowy = new JLabel("Nr kontaktowy:");
		lblNrKontaktowy.setBounds(10, 172, 108, 14);
		frame.getContentPane().add(lblNrKontaktowy);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 194, 108, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblNewLabel = new JLabel("Sta\u0142y klient:");
		lblNewLabel.setBounds(10, 216, 108, 14);
		frame.getContentPane().add(lblNewLabel);
		
		field_nr_m = new JTextField();
		field_nr_m.setBounds(128, 125, 140, 20);
		frame.getContentPane().add(field_nr_m);
		field_nr_m.setColumns(10);
		
		field_nr_l = new JTextField();
		field_nr_l.setBounds(128, 147, 140, 20);
		frame.getContentPane().add(field_nr_l);
		field_nr_l.setColumns(10);
		
		field_tel = new JTextField();
		field_tel.setBounds(128, 169, 140, 20);
		frame.getContentPane().add(field_tel);
		field_tel.setColumns(10);
		
		field_email = new JTextField();
		field_email.setBounds(128, 191, 140, 20);
		frame.getContentPane().add(field_email);
		field_email.setColumns(10);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(128, 213, 140, 20);
		comboBox.addItem("Tak");
		comboBox.addItem("Nie");
		frame.getContentPane().add(comboBox);
		
		JButton btnZatwierdz = new JButton("Zatwierd\u017A");
		btnZatwierdz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id++;
				clientData();
			}
		});
		btnZatwierdz.setBounds(10, 450, 108, 23);
		frame.getContentPane().add(btnZatwierdz);
		
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
		
		field_model = new JTextField();
		field_model.setBounds(128, 262, 140, 20);
		frame.getContentPane().add(field_model);
		field_model.setColumns(10);
		
		field_marka = new JTextField();
		field_marka.setBounds(128, 284, 140, 20);
		frame.getContentPane().add(field_marka);
		field_marka.setColumns(10);
		
		field_rejestr = new JTextField();
		field_rejestr.setBounds(128, 306, 140, 20);
		frame.getContentPane().add(field_rejestr);
		field_rejestr.setColumns(10);
		
		field_rok = new JTextField();
		field_rok.setBounds(128, 328, 140, 20);
		frame.getContentPane().add(field_rok);
		field_rok.setColumns(10);
		
		field_przebieg = new JTextField();
		field_przebieg.setBounds(128, 350, 140, 20);
		frame.getContentPane().add(field_przebieg);
		field_przebieg.setColumns(10);
		
		JLabel lblPoleNieobowizkowe = new JLabel("* pole nieobowiazkowe");
		lblPoleNieobowizkowe.setBounds(10, 382, 159, 14);
		frame.getContentPane().add(lblPoleNieobowizkowe);
		
		JLabel lblRodzajNaprawy = new JLabel("Powod:");
		lblRodzajNaprawy.setBounds(10, 410, 108, 14);
		frame.getContentPane().add(lblRodzajNaprawy);
		
		comboBox_1 = new<String> JComboBox();
		comboBox_1.setBounds(129, 407, 139, 20);
		comboBox_1.addItem("Naprawa");
		comboBox_1.addItem("Przeglad");
		frame.getContentPane().add(comboBox_1);
		
		JButton btnRealizuj = new JButton("Realizuj");
		btnRealizuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				realization();
			}
		});
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
		
		JButton btnZrobione = new JButton("Zrobione");
		btnZrobione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resourceAllocation();
			}
		});
		btnZrobione.setBounds(468, 212, 89, 23);
		frame.getContentPane().add(btnZrobione);
		
		error = new JLabel("");
		error.setBounds(10, 435, 258, 14);
		frame.getContentPane().add(error);
	}
	
	private void clientData() {
		int counter = 0;
		int counter2 = 0;
		boolean flag = false;
		
		String[] clientData = new String[9];
		String[] carData = new String[5];
		clientData[0] = this.field_imie.getText();
		clientData[1] = this.field_nazwisko.getText();
		clientData[2] = this.field_miejsc.getText();
		clientData[3] = this.field_ulica.getText();
		clientData[4] = this.field_nr_m.getText();
		clientData[5] = this.field_nr_l.getText();
		clientData[6] = this.field_tel.getText();
		clientData[7] = this.field_email.getText();
		clientData[8] = (String) this.comboBox.getSelectedItem();
		
		carData[0] = this.field_model.getText();
		carData[1] = this.field_marka.getText();
		carData[2] = this.field_rejestr.getText();
		carData[3] = this.field_rok.getText();
		carData[4] = this.field_przebieg.getText();
		
		for(int i =0;i<clientData.length;i++) {
			if(!clientData[i].isEmpty())
				counter++;
		}
		for(int j =0;j<carData.length;j++) {
			if(!carData[j].isEmpty())
				counter2++;
		}
		if(counter >= clientData.length -1 && counter2 == carData.length) {
			flag = true;
			counter = 0;
			counter2 = 0;
		} else {
			this.error.setText("Nie wszystkie wymagane pola zostaly wybrane");
			flag = false;
		}
		
		if(flag) {
			try{
				//insert to wlasciciel_pojazdu
				int idwlasc = getId("WLASCICIEL_POJAZDU");
				zmienna = idwlasc;
				String query = "INSERT INTO WLASCICIEL_POJAZDU VALUES("+idwlasc+", ";
				for(int i=0;i<clientData.length;i++)
				{
					query+="'"+clientData[i]+"', ";
				}
				query = query.substring(0, query.length()-2);
				query += ")";
				database.executeQuery(query);
				
				//insert to model
				int idmodelu = getId("MODEL");
				query = "INSERT INTO MODEL VALUES("+idmodelu+", ";
				query +="'"+carData[0]+"', ";
				query +="'"+carData[1]+"'";
				query += ")";
				database.executeQuery(query);
				
				//insert to pojazd
				int id_pojazdu = getId("POJAZD");
				query = "INSERT INTO POJAZD VALUES("+id_pojazdu+", "+idwlasc+", "+idmodelu+", ";
				query = "INSERT INTO POJAZD VALUES("+getId("POJAZD")+", "+idwlasc+", "+idmodelu+", ";
				query +="'"+carData[2]+"', ";
				query +="'"+Integer.parseInt(carData[3])+"', ";
				query +="'"+Integer.parseInt(carData[4])+"'";
				query += ")";
				database.executeQuery(query);
				
				//insert to naprawa
				query = "INSERT INTO NAPRAWA (ID_NAPRAWY, ID_POJAZDU) VALUES("+getId("NAPRAWA")+", "+id_pojazdu+")";
				//System.out.println("INSERT INTO NAPRAWA (ID_NAPRAWY, ID_POJAZDU) VALUES("+id_naprawy+", "+id_pojazdu+")");
				database.executeQuery(query);

			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void realization() {
		//scenariusz 1
		try{
		switch(this.comboBox_1.getSelectedIndex()) {
			case 0:
			{
				//Naprawa
				String query = "SELECT ID_OPERACJI, NAZWA FROM OPERACJA";
				ResultSet rs = database.executeQuery(query);
				List<String> id = new ArrayList<String>();
				List<String> name = new ArrayList<String>();
				int i=0;
				while(rs.next()) {
					id.add(rs.getString("ID_OPERACJI"));
					name.add(rs.getString("NAZWA"));
					i++;
				}
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				model.setColumnCount(0);
				model.addColumn("ID_OPERACJI");
		        model.addColumn("NAZWA");
		        model.addRow(new Object[]{"ID_OPERACJI","NAZWA"});	
				for(int j=0;j<id.size();j++) {
					model.addRow(new Object[]{id.get(j),name.get(j)});	
				}
				if(this.table.getSelectedRow() != -1)	
				{
					query = "SELECT ID_STANOWISKA FROM STANOWISKO WHERE NAZWA_STANOWISKA = "+ table.getValueAt(this.table.getSelectedRow(), 1);
					ResultSet rsc = database.executeQuery(query);
					rsc.first();
					int id_stanowiska = rsc.getInt(1);
					query = "SELECT ID_NAPRAWY FROM NAPRAWA WHERE ID_POJAZDU = (SELECT ID_POJAZDU FROM POJAZD WHERE ID_WLASCICIELA = "+ zmienna;
					ResultSet rsd = database.executeQuery(query);
					rsd.first();
					int id_naprawy = rsd.getInt(1);
					
					query = "INSERT INTO WYKONANIE_OPERACJI (ID_WYKONANIA_OPERACJI, ID_PRZEGLADU, ID_NAPRAWY, ID_OPERACJI, ID_STANOWISKA, RODZAJ_OPERACJI) "
							+ "VALUES ("
							+getId("WYKONANIE_OPERACJI")
							+","+id
							+","+id_naprawy
							+","+model.getValueAt(this.table.getSelectedRow(), 0)
							+","+id_stanowiska
							+"Naprawa"
							+")";
					System.out.println(query);
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				for(int j=0;j<id.size();j++) {
					model.addRow(new Object[]{id.get(j),name.get(j)});	
				}
				
				if(this.table.getSelectedRow() != -1)
				{					
					query = "INSERT INTO WYKONANIE_OPERACJI (ID_WYKONANIA_OPERACJI, ID_PRZEGLADU, ID_OPERACJI) "
							+ "VALUES ("
							+getId("WYKONANIE_OPERACJI")
							+id
							+model.getValueAt(this.table.getSelectedRow(), 0)
							+")";
					database.executeQuery(query);
				}
				break;
			}
			case 1:
			{
				//Przeglad
				String query = "SELECT ID_OPERACJI, NAZWA FROM OPERACJA "
						+ "WHERE ID_OPERACJI IN(SELECT ID_OPERACJI FROM OPERACJA_SERWISOWA "
						+ "WHERE ID_POZYCJI_PLANU_SERWISOWEGO IN "
						+ "(SELECT ID_POZYCJI_PLANU_SERWISOWEGO FROM POZYCJA_PLANU_SERWISOWEGO "
						+ "WHERE ID_MODELU IN (SELECT ID_MODELU FROM POJAZD WHERE NR_REJESTRACYJNY = '"+this.field_rejestr.getText()+"')))";
				ResultSet rs = database.executeQuery(query);
				List<String> id = new ArrayList<String>();
				List<String> name = new ArrayList<String>();
				while(rs.next()) {
					id.add(rs.getString("ID_OPERACJI"));
					name.add(rs.getString("NAZWA"));
				}
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				model.setColumnCount(0);
				model.addColumn("ID_OPERACJI");
		        model.addColumn("NAZWA");
		        model.addRow(new Object[]{"ID_OPERACJI","NAZWA"});	
				for(int i=0;i<id.size();i++) {
					model.addRow(new Object[]{id.get(i),name.get(i)});	
				}
				
					query = "SELECT ID_STANOWISKA FROM STANOWISKO WHERE NAZWA_STANOWISKA = "+ table.getValueAt(this.table.getSelectedRow(), 1);
					ResultSet rsc = database.executeQuery(query);
					rsc.first();
					int id_stanowiska = rsc.getInt(1);
					query = "SELECT ID_NAPRAWY FROM NAPRAWA WHERE ID_POJAZDU = (SELECT ID_POJAZDU FROM POJAZD WHERE ID_WLASCICIELA = "+ zmienna;
					ResultSet rsd = database.executeQuery(query);
					rsd.first();
					int id_naprawy = rsd.getInt(1);
					
					query = "INSERT INTO WYKONANIE_OPERACJI (ID_WYKONANIA_OPERACJI, ID_PRZEGLADU, ID_NAPRAWY, ID_OPERACJI, ID_STANOWISKA, RODZAJ_OPERACJI) "
							+ "VALUES ("
							+getId("WYKONANIE_OPERACJI")
							+","+id
							+","+id_naprawy
							+","+model.getValueAt(this.table.getSelectedRow(), 0)
							+","+id_stanowiska
							+"Naprawa"
							+")";
					database.executeQuery(query);
				
				
				for(int i=0;i<id.size();i++) {
					model.addRow(new Object[]{id.get(i),name.get(i)});	
				
					query = "INSERT INTO WYKONANIE_OPERACJI (ID_WYKONANIA_OPERACJI, ID_PRZEGLADU, ID_OPERACJI) "
							+ "VALUES ("
							+getId("WYKONANIE_OPERACJI")
							+getId("ID_PRZEGLADU")
							+id.get(i)
							+")";
					database.executeQuery(query);
				}
				break;
			}
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void resourceAllocation() {
		//scenariusz 2
		try{		
			String query = "SELECT ID_WYKONANIA_OPERACJI FROM WYKONANIE_OPERACJI";
			ResultSet rs = database.executeQuery(query);
			List<String> idwykon = new ArrayList<String>();
			while(rs.next()) {
				idwykon.add(rs.getString("ID_WYKONANIA_OPERACJI"));
			}
			if(idwykon.size() !=0) {
				for(int k=0;k<idwykon.size();k++) {
					//TODO przydzial pracownika
					query = "INSERT INTO Przydzial_Pracownika VALUES (1, "
							+ idwykon.get(k)
							+ ")";
					database.executeQuery(query);
					
					//przydzial stanowiska
					query = "UPDATE WYKONANIE_OPERACJI SET ID_STANOWISKA = "
							+ "(SELECT ID_STANOWISKA FROM STANOWISKO WHERE ID_TYPU_STANOWISKA = "
							+ "(SELECT ID_TYPU_STANOWISKA FROM OPERACJA WHERE ID_TYPU_STANOWISKA = "
							+ "WYKONANIE_OPERACJI.ID_OPERACJI)) WHERE ID_WYKONANIA_OPERACJI = "
							+ idwykon.get(k);
					database.executeQuery(query);
					
					//przydzial czesci
					query = "INSERT INTO PRZYDZIAL_CZESCI VALUES "
							+ "("
							+ idwykon.get(k)
							+ ",(SELECT ID_CZESCI FROM Czesc WHERE ID_OPERACJI = "
							+ "(SELECT ID_OPERACJI FROM WYKONANIE_OPERACJI WHERE ID_WYKONANIA_OPERACJI = "
							+ idwykon.get(k)
							+ ")))";
					database.executeQuery(query);
				}
				
				//wyswietlenie wszytkiego 
				query = "SELECT CZESC.NAZWA, STANOWISKO.NAZWA_STANOWISKA, STANOWISKO.NR_STANOWISKA, PRACOWNIK.NAZWISKO "
							+ "FROM CZESC JOIN PRACOWNIK ON ID_PRACOWNIKA = "
							+ "(SELECT ID_PRACOWNIKA FROM PRZYDZIAL_PRACOWNIKA WHERE WYKONANIE_OPERACJI = "
							+ "(SELECT ID_WYKONANIA_OPERACJI FROM PRZYDZIAL_CZESCI WHERE ID_CZESCI = CZESC.ID_CZESCI)) "
							+ "JOIN STANOWISKO ON ID_STANOWISKA = "
							+ "(SELECT ID_STANOWISKA FROM WYKONANIE_OPERACJI WHERE ID_WYKONANIA_OPERACJI = "
							+ "(SELECT ID_WYKONANIA_OPERACJI FROM PRZYDZIAL_CZESCI WHERE ID_CZESCI = CZESC.ID_CZESCI))";
				rs  = database.executeQuery(query);
				List<String> nazwaczesci = new ArrayList<String>();
				List<String> nazwastanowiska = new ArrayList<String>();
				List<String> nrstanowiska = new ArrayList<String>();
				List<String> nazwpracownika = new ArrayList<String>();
				while(rs.next()) {
					nazwaczesci.add(rs.getString("NAZWA"));
					nazwastanowiska.add(rs.getString("NAZWA_STANOWISKA"));
					nrstanowiska.add(rs.getString("NR_STANOWISKA"));
					nazwpracownika.add(rs.getString("NAZWISKO"));
				}
					
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				
				for(int i=0;i<nazwaczesci.size();i++) {
					model.addRow(new Object[]{nazwaczesci.get(i),nazwastanowiska.get(i),nrstanowiska.get(i),nazwpracownika.get(i)});	
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private int getId(String table) throws SQLException {
		String query = "SELECT COUNT(*) FROM "+table;
		ResultSet rs = database.executeQuery(query);
		int i=0;
		while(rs.next())
			i = rs.getInt(1);
		return i+1;
	}
}
