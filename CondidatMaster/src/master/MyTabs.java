package master;

import javax.swing.*;

public class MyTabs 
{
  MyTabs()
  {
    //Cr�er le frame
    JFrame frame = new JFrame();
    //Cr�er une zone de texte
    JTextField text = new JTextField(10);
    //Cr�er le panneau 1
    JPanel p1 = new JPanel();
    //Ajouter la zone de texte dans le panneau 1
    
    p1.add(text);
    //Cr�er le panneau 2
    JPanel p2 = new JPanel();
    //Cr�er le panneau 3
    JPanel p3 = new JPanel();
    
    //Cr�er le conteneur des onglets
    JTabbedPane onglets = new JTabbedPane();
    //D�finir la position de conteneur d'onglets
    onglets.setBounds(40,20,300,300);
    //Associer chaque panneau � l'onglet correspondant
    onglets.add("Generale", p1);
    onglets.add("Affichage", p2);
    onglets.add("A propos", p3);
    
    //Ajouter les onglets au frame
    frame.add(onglets);
    
    frame.setSize(400,400);
    frame.setLayout(null);
    frame.setVisible(true);
  }
  public static void main(String[] args) 
  {
    new MyTabs();
  }
}