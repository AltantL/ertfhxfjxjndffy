package vue;

import constantes.ConstantesCalendrier;
import javafx.scene.layout.HBox;
import modele.Date;
import modele.DateCalendrier;
import modele.CalendrierDuMois;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.List;


public class VBoxRootV1 extends VBox implements ConstantesCalendrier {
    public VBoxRootV1() {

        Date today = new Date();
        CalendrierDuMois moisActuel = new CalendrierDuMois(today.getMois(), 2025);
        //System.out.println (moisActuel);
        Label labelTitle = new Label(MOIS[moisActuel.getMois()-1] + " " +
                moisActuel.getAnnee());
        VBox.setMargin( labelTitle, new Insets(14) );



        StackPane stackPaneMois = new StackPane();




//        boutonDroite.setOnAction(actionEvent -> System.out.println(">") );
//        boutonGauche.setOnAction(actionEvent -> System.out.println("<") );

        for (int i=1; i<=12; i++){

            VBox boiteDates = new VBox ();

            ScrollPane scrollPaneDates = new ScrollPane();
            scrollPaneDates.setContent(boiteDates);

            scrollPaneDates.setAccessibleText(MOIS[i-1]);

            moisActuel = new CalendrierDuMois(i, 2025);

            for (DateCalendrier date : moisActuel.getDates()) {

                Label labelDate = new Label(date.toString());
// les attributs id sont utilisés dans la feuille de style
                if (date.getMois()!= moisActuel.getMois()) {
                    labelDate.setId("dateHorsMois");
                }
                if (date.isToday()) {
                    labelDate.setId("today");
                }
                VBox.setMargin( labelDate, new Insets(8));
                boiteDates.getChildren().add(labelDate);
            }
           stackPaneMois.getChildren().add(scrollPaneDates);
        }



        List<Node> listNode = stackPaneMois.getChildren();
        String moisCourant = MOIS[today.getMois()-1];

        while(!moisCourant.equals(listNode.get(11).getAccessibleText())){
            listNode.get(0).toFront();
        }

        HBox boiteBoutons = new HBox();

        Button boutonSuivant = new Button(">");
        Button boutonPrecedent = new Button("<");

        boiteBoutons.getChildren().addAll(labelTitle,boutonPrecedent, boutonSuivant);

//        HBox.setHgrow(boiteBoutons, Priority.ALWAYS);

        this.getChildren().addAll(boiteBoutons, stackPaneMois);

        boutonPrecedent.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton Precedent");
                listNode.get(listNode.size()-1).toBack();
            }
        });
        boutonSuivant.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton Suivant");
                listNode.get(0).toFront();
            }
        });



    }
}









//public class VBoxRoot extends VBox {
//
//    public VBoxRoot() {
////        DateCalendrier aujourd = new DateCalendrier();
////        Label labelAujourdHui = new Label(aujourd.toString());
////        this.getChildren().add(labelAujourdHui);
////
////        Label labelLendemain = new Label(aujourd.dateDuLendemain().toString());
////        this.getChildren().add(labelLendemain);
//
//        VBox boiteVBox = new VBox();
//        CalendrierDuMois date = new CalendrierDuMois(04, 2025);
//        Label dateLabel = new Label("Mois: " + date.getMois() + " Annee: " + date.getAnnee());
//
//        ScrollPane scrollPlaneDates = new ScrollPane();
//        scrollPlaneDates.setContent(boiteVBox);
//
//        for (DateCalendrier dateCalendrier: date.getDates()){
//            Label dateLabel2 = new Label(date.toString());
//            boiteVBox.getChildren().add(dateLabel2);
//        }
//
//        this.getChildren().addAll(dateLabel, boiteVBox);
//
//    }
//
//
//}
