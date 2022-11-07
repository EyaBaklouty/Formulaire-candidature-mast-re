package master;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;

import javax.swing.JFormattedTextField.AbstractFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.event.DocumentListener;

public class ZDialog extends JDialog {
  private ZDialogInfo zInfo = new ZDialogInfo();
  private boolean sendData;
  private JLabel nomLabel,cinLabel, sexeLabel, cheveuxLabel, ageLabel, tailleLabel,taille2Label, icon;
  private JRadioButton tranche1, tranche2, tranche3, tranche4;
  private JComboBox sexe, cheveux;
  private JTextField nom, taille, cin;
  int tailleCin =1;


  public ZDialog(JFrame parent, String title, boolean modal){
	  
	  
    super(parent, title, modal);
    this.setSize(720, 420);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    this.initComponent();
  }

  public ZDialogInfo showZDialog(){
    this.sendData = false;
    this.setVisible(true);      
    return this.zInfo;      
  }

  private void initComponent(){
    //Icône
    icon = new JLabel(new ImageIcon("images/isitcom.png"));
    JPanel panIcon = new JPanel();
    //panIcon.setPreferredSize(new Dimension(100, 60));
    panIcon.setBackground(Color.white);
    panIcon.setLayout(new BorderLayout());
    panIcon.add(icon);

    //CIN
    JPanel panCin = new JPanel();
    panCin.setBackground(Color.white);
    panCin.setPreferredSize(new Dimension(445, 60));
    cin = new JTextField();
    cin.setPreferredSize(new Dimension(150, 25));
    panCin.setBorder(BorderFactory.createTitledBorder("Identification"));
    cinLabel = new JLabel("CIN :");
    panCin.add(cinLabel);
    panCin.add(cin);
    
    cin.addKeyListener(new KeyAdapter(){
    	public void keyTyped(KeyEvent e ) {

    	char input = e.getKeyChar(); //saved here when type something
    	tailleCin = cin.getText().length();//Length CiN
    	//System.out.println("taille" + tailleCin);
    	if(Character.isDigit(input) == false || tailleCin > 7) {
    	e.consume();
    	}
    	}
    	});

    
    
    //Le nom
    JPanel panNom = new JPanel();
    panNom.setBackground(Color.white);
    panNom.setPreferredSize(new Dimension(220, 60));
    nom = new JTextField();
    nom.setPreferredSize(new Dimension(100, 25));
    panNom.setBorder(BorderFactory.createTitledBorder("Identification"));
    nomLabel = new JLabel("Nom et Prrénom :");
    panNom.add(nomLabel);
    panNom.add(nom);

    //Le sexe
    JPanel panSexe = new JPanel();
    panSexe.setBackground(Color.white);
    panSexe.setPreferredSize(new Dimension(220, 60));
    panSexe.setBorder(BorderFactory.createTitledBorder("Civilité :"));
    sexe = new JComboBox();
    sexe.addItem("Masculin");
    sexe.addItem("Féminin");
    sexe.addItem("Indéterminé");
    sexeLabel = new JLabel("Civilité :");
    panSexe.add(sexeLabel);
    panSexe.add(sexe);

    //L'âge 
    JPanel panAge = new JPanel();
    panAge.setBackground(Color.white);
    panAge.setBorder(BorderFactory.createTitledBorder("Etudiant"));
    panAge.setPreferredSize(new Dimension(220, 60));
    tranche1 = new JRadioButton("Interne");
    tranche1.setSelected(true);
    tranche2 = new JRadioButton("Externe");
  
    ButtonGroup bg = new ButtonGroup();
    bg.add(tranche1);
    bg.add(tranche2);

    panAge.add(tranche1);
    panAge.add(tranche2);

    
  //La date de naissance
    JPanel pandate = new JPanel();
    pandate.setBackground(Color.white);
    pandate.setPreferredSize(new Dimension(220, 60));
    pandate.setBorder(BorderFactory.createTitledBorder("Date de naissance"));

    JDateChooser date = new JDateChooser();
    date.setPreferredSize(new Dimension(100, 25));
    date.setEnabled(true);
    pandate.add(date);

    //La taille
    JPanel panTaille = new JPanel();
    panTaille.setBackground(Color.white);
    panTaille.setPreferredSize(new Dimension(220, 60));
    panTaille.setBorder(BorderFactory.createTitledBorder("Moyenne PFE"));
    tailleLabel = new JLabel("Moyenne : ");
    taille = new JTextField("10");
    taille.setPreferredSize(new Dimension(90, 25));
    panTaille.add(tailleLabel);
    panTaille.add(taille);

    //La couleur des cheveux
    JPanel panCheveux = new JPanel();
    panCheveux.setBackground(Color.white);
    panCheveux.setPreferredSize(new Dimension(220, 60));
    panCheveux.setBorder(BorderFactory.createTitledBorder("Mastere"));
    cheveux = new JComboBox();
    cheveux.addItem("Mastère de recherche");
    cheveux.addItem("Mastère professionnel");
    cheveuxLabel = new JLabel("Choix");
    panCheveux.add(cheveuxLabel);
    panCheveux.add(cheveux);
    
    
  //L'adresse 
    JPanel panAdr = new JPanel();
    panAdr.setBackground(Color.white);
    panAdr.setBorder(BorderFactory.createTitledBorder("Adresse"));
    panAdr.setPreferredSize(new Dimension(445, 60));
    JSlider slider = new JSlider(15,50) ;
    Hashtable position = new Hashtable();
    position.put(15, new JLabel("15"));
    position.put(25, new JLabel("25"));
    position.put(35, new JLabel("35"));
    position.put(45, new JLabel("45"));
    position.put(50, new JLabel("50"));
    slider.setLabelTable(position); 
    slider.setPaintLabels(true);
    panAdr.add(slider);


    JPanel content = new JPanel();
    content.setBackground(Color.LIGHT_GRAY);
    content.add(panCin);
    content.add(panNom);
    content.add(panSexe);
    content.add(panAge);
    content.add(pandate);
    content.add(panTaille);
    content.add(panCheveux);
    content.add(panAdr);
    

    JPanel control = new JPanel();
    JButton okBouton = new JButton("Ok",new ImageIcon(new ImageIcon("images/ok.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));

    

    okBouton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {        
        zInfo = new ZDialogInfo(nom.getText(), (String)sexe.getSelectedItem(), getAge(), (String)cheveux.getSelectedItem() ,getTaille());
        setVisible(false);
      }

      
      public String getAge(){
        return (tranche1.isSelected()) ? tranche1.getText() : 
               (tranche2.isSelected()) ? tranche2.getText() : 
               
                tranche1.getText();  
      }

      public String getTaille(){
        return (taille.getText().equals("")) ? "10" : taille.getText();
      }      
    });

   
    
    JButton cancelBouton = new JButton("Annuler",new ImageIcon(new ImageIcon("images/non.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
    cancelBouton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
        setVisible(false);
      }      
    });

    control.add(okBouton);
    control.add(cancelBouton);

    this.getContentPane().add(panIcon, BorderLayout.WEST);
    this.getContentPane().add(content, BorderLayout.CENTER);
    this.getContentPane().add(control, BorderLayout.SOUTH);
  }  
}