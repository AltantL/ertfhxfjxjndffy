package vue;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import constantes.ConstantesCalendrier;
import modele.Date;
import modele.PlanningCollection;

public class GridPaneFormulaireReservation extends GridPane implements ConstantesCalendrier {

    public Date dateReserve = new Date();
    public Label labelDate;
    public TextField textField;
    public ComboBox heureDepart;
    public ComboBox heureFin;
    public ComboBox minuteDepart;
    public ComboBox minuteFin;
    public ToggleGroup radioGroup;
    public PlanningCollection chPlanning;

    public GridPaneFormulaireReservation() {

        //Date du jour

        labelDate = new Label(dateReserve.getJour() + " " + MOIS[dateReserve.getMois()-1] + " " +
                dateReserve.getAnnee());
//        Label labelDate;




        Label labelCours = new Label("Cours");
        Label labelNiveau = new Label("Niveau");
        Label labelHoraire = new Label("Horaire");

        textField = new TextField();

        radioGroup = new ToggleGroup();

        RadioButton radioButtonDebutant = new RadioButton("_"+"Debutant");
        radioButtonDebutant.setSelected(true);
        RadioButton radioButtonMoyen = new RadioButton("_"+"Moyen");
        RadioButton radioButtonAvance = new RadioButton("_"+"Avancé");
        RadioButton radioButtonExpert = new RadioButton("_"+"Expert");

        radioGroup.getToggles().addAll(radioButtonDebutant, radioButtonMoyen, radioButtonAvance, radioButtonExpert);

        heureDepart = peupleComboBox(HEURES);
        minuteDepart = peupleComboBox(MINUTES);
        heureFin = peupleComboBox(HEURES);
        heureFin.setValue("8");
        minuteFin = peupleComboBox(MINUTES);
        
        Label lableDe = new Label("de");
        Label labelH1 = new Label("h");
        Label labelMn1 = new Label("mn");
        Label labelH2 = new Label("h");
        Label labelMn2 = new Label("mn");
        Label labelA = new Label("à");

        Button buttonAnnuler = new Button("Annuler");
        buttonAnnuler.setOnAction(HBoxRoot.getControleur());
        Button buttonEnregistrer = new Button("Enregistrer");
        buttonEnregistrer.setOnAction(HBoxRoot.getControleur());



        //espace pour H et V
        this.setHgap(10);
        this.setVgap(10);

        this.add(labelDate, 2, 0,2,1);
        //                     x,   y, largeur,hauteur

        this.add(labelCours, 0, 1,1,1);
        this.add(textField, 1, 1,5,1);
        this.add(labelNiveau, 0, 2,1,1);
        this.add(labelHoraire, 0, 4,1,1);

        //Radio Button
        this.add(radioButtonDebutant, 1, 2,1,1);
        this.add(radioButtonMoyen, 3, 2,1,1);
        this.add(radioButtonAvance, 1, 3,1,1);
        this.add(radioButtonExpert, 3, 3,1,1);

        //horaire
        this.add(heureDepart, 2, 4,1,1);
        this.add(heureFin, 2, 5,1,1);
        this.add(minuteDepart, 4, 4,1,1);
        this.add(minuteFin, 4, 5,1,1);

        //mot dans horaire
        this.add(lableDe, 1, 4,1,1);
        this.add(labelA, 1, 5,1,1);
        this.add(labelH1, 3, 4,1,1);
        this.add(labelMn1, 5, 4,1,1);
        this.add(labelH2, 3, 5,1,1);
        this.add(labelMn2, 5, 5,1,1);

        //bouton
        this.add(buttonAnnuler, 2, 6,1,1);
        this.add(buttonEnregistrer, 4, 6,1,1);


    }

    private ComboBox<String> peupleComboBox(String[] strings) {
        ComboBox<String> comboBox = new ComboBox<>();
        for(String string : strings) {
            comboBox.getItems().add(string);
        }
        comboBox.setValue(strings[0]);
        return comboBox;
    }


    public void setDate(Date date){
        dateReserve = date;
        labelDate.setText(date.getJour() + " " + MOIS[date.getMois()-1] + " " +
                date.getAnnee());
    }
}
