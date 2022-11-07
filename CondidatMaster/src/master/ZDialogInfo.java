package master;

public class ZDialogInfo {
	  private String nom, sexe, age, cheveux, taille;

	  public ZDialogInfo(){}
	  public ZDialogInfo(String nom, String sexe, String age, String cheveux, String taille){
	    this.nom = nom;
	    this.sexe = sexe;
	    this.age = age;
	    this.cheveux = cheveux;
	    this.taille = taille;
	  }

	  public String toString(){
	    String str;
	    if(this.nom != null && this.sexe != null && this.taille != null && this.age != null && this.cheveux != null){
	      str = "Etudiant"  + "\n";
	      str += "Nom : " + this.nom + "\n";
	      str += "Civilit� : " + this.sexe + "\n";
	      str += "Age : " + this.age + "\n";
	      str += "Mast�re : " + this.cheveux + "\n";
	      str += "Moyenne : " + this.taille + "\n";
	    }
	    else{
	      str = "Aucune information !";
	    }
	    return str;
	  }
	}
