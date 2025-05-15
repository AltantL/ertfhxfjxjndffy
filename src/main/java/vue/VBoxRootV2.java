package vue;

import constantes.ConstantesCalendrier;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import modele.Date;
import modele.*;

import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.List;


public class VBoxRootV2 extends VBox implements ConstantesCalendrier {
    public VBoxRootV2() {

        Date today = new Date();

        CalendrierDuMois moisActuel = new CalendrierDuMois(today.getMois(), today.getAnnee());
        //System.out.println (moisActuel);
        Label labelTitle = new Label(MOIS[moisActuel.getMois()-1] + " " +
                moisActuel.getAnnee());



        StackPane stackePaneMois = new StackPane();
        ToggleGroup buttonGroup = new ToggleGroup();

        for (int numMois=1; numMois<=12; numMois++){

            CalendrierDuMois monthCalendar = new CalendrierDuMois(numMois, today.getAnnee());

            TilePane tilePane = new TilePane();
            tilePane.setPrefColumns(7);

            tilePane.setPrefRows(monthCalendar.getDates().size()%7 + 1);
            tilePane.setId("opaque");

            for (String jourAb : JOURS_SEMAINE_ABR){
                Label labelJour = new Label(jourAb);
                tilePane.getChildren().add(labelJour);
            }

            for (DateCalendrier date : monthCalendar.getDates()) {

                ToggleButton boutonDate = new ToggleButton(Integer.toString(date.getJour()));

                boutonDate.setToggleGroup(buttonGroup);
                tilePane.getChildren().add(boutonDate);

                boutonDate.setUserData(date);
                boutonDate.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println(date);
                    }
                });

                if (date.getMois()!= monthCalendar.getMois()) {
                    boutonDate.setId("dateHorsMois");
                }
                if (date.isToday()) {
                    boutonDate.setId("today");
                }

            }
            tilePane.setAccessibleText(MOIS[numMois-1]);
            stackePaneMois.getChildren().add(tilePane);
        }



        List<Node> listNode = stackePaneMois.getChildren();
        String moisCourant = MOIS[today.getMois()-1];
        String dernierMois = MOIS[11];
        String premierMois = MOIS[0];

        while(!moisCourant.equals(listNode.get(11).getAccessibleText())){
            listNode.get(0).toFront();
        }

        HBox boiteBoutons = new HBox();

        Button boutonSuperPrecedent = new Button("<<");
        Button boutonPrecedent = new Button("<");
        Button boutonSuivant = new Button(">");
        Button boutonSuperSuivant = new Button(">>");

        boiteBoutons.getChildren().addAll(boutonSuperPrecedent, boutonPrecedent, boutonSuivant, boutonSuperSuivant);

//        HBox.setHgrow(boiteBoutons, Priority.ALWAYS);

        this.getChildren().addAll(labelTitle, stackePaneMois, boiteBoutons);

        boutonPrecedent.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton Precedent");
                listNode.get(listNode.size()-1).toBack();
                labelTitle.setText(listNode.get(listNode.size()-1).getAccessibleText() + " " + today.getAnnee());
            }
        });
        boutonSuivant.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton Suivant");
                listNode.get(0).toFront();
                labelTitle.setText(listNode.get(0).getAccessibleText() + " " + today.getAnnee());
            }
        });
        boutonSuperPrecedent.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton Super Precedent");
                while(!premierMois.equals(listNode.get(listNode.size()-1).getAccessibleText())) {
                    listNode.get(listNode.size() - 1).toBack();
                    labelTitle.setText(listNode.get(listNode.size()-1).getAccessibleText() + " " + today.getAnnee());
                }
            }
        });
        boutonSuperSuivant.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton Super Suivant");
                while(!dernierMois.equals(listNode.get(0).getAccessibleText())){
                    listNode.get(0).toFront();
                    labelTitle.setText(listNode.get(0).getAccessibleText() + " " + today.getAnnee());
                }
            }
        });



    }
}

