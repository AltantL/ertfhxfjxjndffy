package vue;

import constantes.ConstantesCalendrier;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modele.*;




public class VBoxAffichagePlanning extends VBox implements ConstantesCalendrier {
    Label numSemaineActuel;
    Label numSemaineSelectionnee;
    Date dateA;

    public VBoxAffichagePlanning() {
        dateA = new Date();
        numSemaineSelectionnee = new Label("Semaine : " + dateA.getNumSemaine());

        this.getChildren().add(numSemaineSelectionnee);
    }

    public void setNumSemaineSelectionnee(Date date){
        dateA = date;
        numSemaineSelectionnee.setText("Semaine : " + date.getNumSemaine());
        System.out.println(numSemaineSelectionnee.getText());
    }
}
