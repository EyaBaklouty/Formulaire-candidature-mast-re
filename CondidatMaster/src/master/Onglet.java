package master;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import java.awt.*;

public class Onglet extends JFrame{

	public static final String[] columns = {"Nom", "Prenom", "Adresse", "sexe","Email","Age","NumTel","Salaire","TypeEmp","DateNaiss"};
	public DefaultTableModel model = new DefaultTableModel(columns,0);
	public JTable table = new JTable(model);
	JScrollPane j = new JScrollPane(table);
	public Onglet() {
		JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);
		 JPanel onglet1 = new JPanel();
		 onglet1.setLayout(new BorderLayout());

		 //Login mdp (label and fields)
		 JPanel content1 = new JPanel();
		 content1.setLayout(null);
		 onglet1.add(content1, BorderLayout.CENTER);	
		 
		 JPanel panel = new JPanel();
		 panel.setBounds(0, 0, 369, 253);
		 content1.add(panel);
		 panel.setLayout(null);
		 
		 JLabel loginLabel = new JLabel("Login:");
		 loginLabel.setBounds(31, 72, 72, 28);
		 panel.add(loginLabel);
		 
		 JTextField textField_1 = new JTextField();
		 textField_1.setBounds(113, 76, 105, 20);
		 panel.add(textField_1);
		 
		 JLabel passwordLabel = new JLabel("Password:");
		 passwordLabel.setBounds(31, 125, 72, 20);
		 panel.add(passwordLabel);
		 
		 JPasswordField passwordField = new JPasswordField();
		 passwordField.setBounds(113, 125, 105, 20);
		 panel.add(passwordField);
		 
		 JButton btn1 = new JButton("Connexion");
		 btn1.setBounds(207, 178, 105, 23);
		 panel.add(btn1);
		 JLabel image = new JLabel("");
		 image.setIcon(new ImageIcon("C:\\Users\\Abir\\Documents\\image.png"));
		 image.setBounds(230, 0, 150, 150);
		    panel.add(image);
		   
		    btn1.addActionListener(new ActionListener(){
		    	   public void actionPerformed(ActionEvent arg0) {
		    	    String loginValue = textField_1.getText();
		    	    char[] pf = passwordField.getPassword();
		    	    String passwordValue = new String(pf);
		    	   
		    	    //String passwordValue = password.getText();
		    	   
		    	    if((loginValue.equals("eya")) && (passwordValue.equals("eya123"))) {
		    	    onglets.setEnabledAt(1, true);
		    	    onglets.setSelectedIndex(1);
		    	    onglets.setEnabledAt(0, false);
		    	    }
		    	    else {
		    	    JOptionPane.showMessageDialog(null,"Saisie Erronée","Alert",JOptionPane.ERROR_MESSAGE);}      

		    	    }
		    	 });

		 onglet1.setPreferredSize(new Dimension(300, 100));
		 

		 JPanel onglet2 = new JPanel();
		 onglet2.setLayout(new BorderLayout());
		 
		 //prenom nom (label and fields)
		 JPanel content2 = new JPanel();

		 content2.setLayout(new BorderLayout());
		 
		 JLabel nomLabel = new JLabel("Nom:");
		 nomLabel.setBounds(31, 11, 119, 20);
		 JTextField nom = new JTextField();
		 nom.setBounds(184, 11, 109, 20);
		 JLabel prenomLabel = new JLabel("Prénom:");
		 prenomLabel.setBounds(31, 32, 119, 20);
		 JTextField prenom = new JTextField();
		 prenom.setBounds(184, 32, 109, 20);
		 
		 JComboBox sexe = new JComboBox();
		 sexe.setBounds(184, 53, 109, 20);
		    sexe.addItem("Masculin");
		    sexe.addItem("Féminin");
		    sexe.addItem("Indéterminé");
		 JLabel sexeLabel = new JLabel("Sexe : ");
		 sexeLabel.setBounds(31, 53, 119, 20);
		 JLabel ageLabel = new JLabel("Age:");
		 ageLabel.setBounds(31, 74, 119, 20);
		 JTextField age = new JTextField();
		 age.setBounds(184, 74, 109, 20);
		 JLabel emailLabel = new JLabel("Email:");
		 emailLabel.setBounds(31, 137, 119, 20);
		 JTextField email = new JTextField();
		 email.setBounds(184, 137, 109, 20);
		 JLabel adresseLabel = new JLabel("Adresse:");
		 adresseLabel.setBounds(31, 116, 119, 20);
		 JTextField adresse = new JTextField();
		 adresse.setBounds(184, 116, 109, 20);
		 JLabel numLabel = new JLabel("Numéro de téléphone:");
		 numLabel.setBounds(31, 95, 119, 20);
		 JTextField num = new JTextField();
		 num.setBounds(184, 95, 109, 20);
		 JLabel salaireLabel = new JLabel("Salaire:");
		 salaireLabel.setBounds(31, 158, 119, 20);
		 
		 
		 
		 JSpinner salaire = new JSpinner();
		 salaire.setBounds(184, 158, 109, 20);
		 JLabel typeLabel = new JLabel("Type d'employé:");
		 typeLabel.setBounds(31, 179, 119, 20);
		 JComboBox type = new JComboBox();
		 type.setBounds(184, 179, 109, 20);
		    type.addItem("Type1");
		    type.addItem("Type2");
		    type.addItem("Type3");
		
		    
		   
		   
		
		 
		 JPanel inside2 = new JPanel();
		 inside2.setLayout(null);
		 
		 JButton btnAjouter = new JButton("ajouter");
		 btnAjouter.setBounds(102, 236, 67, 23);
		 inside2.add(btnAjouter);
		 JDateChooser chooser = new JDateChooser();
		 chooser.setBounds(185, 205, 108, 20);
		 inside2.add(chooser);
		
		 chooser.getJCalendar().setPreferredSize(new Dimension(300, 200));
		 chooser.setDateFormatString("yyyy-MM-dd");
		 JLabel dateLabel =new JLabel("Date de naissance :*");
		 dateLabel.setBounds(31, 205, 119, 20);
		 
		 JButton clean_1 = new JButton("Clean");
		 clean_1.setBounds(185, 236, 59, 23);
		 inside2.add(clean_1);
		 inside2.add(nomLabel);
		 inside2.add(nom);
		 inside2.add(prenomLabel);
		 inside2.add(prenom);
		 inside2.add(sexeLabel);
		 inside2.add(sexe);
		 inside2.add(ageLabel);
		 inside2.add(age);
		 inside2.add(numLabel);
		 inside2.add(num);
		 inside2.add(adresseLabel);
		 inside2.add(adresse);
		 inside2.add(emailLabel);
		 inside2.add(email);
		 
		 inside2.add(salaireLabel);
		 inside2.add(salaire);
		 inside2.add(typeLabel);
		 inside2.add(type);
		 
		 inside2.add(dateLabel);
		 inside2.add(chooser);
		 
		 content2.add(inside2,BorderLayout.CENTER);
		 
		
		 

		 onglet2.add(content2, BorderLayout.CENTER);	
		// onglet2.add(btn2, BorderLayout.SOUTH);
		 
			 
		 onglet2.setPreferredSize(new Dimension(300, 100));
		 
		 
		 
		 onglets.addTab("Login", onglet1);
		 onglets.addTab("Inscription", onglet2);
		 onglets.setEnabledAt(1, false);

		 this.getContentPane().add(onglets);

		
		
		
		 this.setTitle("Test de onglet");
		    this.setSize(390, 337);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);

		    this.setVisible(true);
		    
	}
	
	
public static void main(String[] args) {
	Onglet o = new Onglet();
	}
}
