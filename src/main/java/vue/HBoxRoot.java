package vue;

import controleur.Controleur;
import javafx.scene.control.Control;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import modele.PlanningCollection;

public class HBoxRoot extends HBox {

    private static PlanningCollection planning;
    private static Controleur controleur;
    private static GridPane calendrierPane;
    private static GridPaneFormulaireReservation reservationPane;
    private static VBoxAffichagePlanning affichagePlanning;

    public HBoxRoot() {

        super(30);

        planning = new PlanningCollection();
        controleur = new Controleur();
        calendrierPane = new GridPane();
        reservationPane = new GridPaneFormulaireReservation();
        affichagePlanning = new VBoxAffichagePlanning();


        VBoxCalendrier vBoxCalendrier = new VBoxCalendrier();
        this.getChildren().addAll(vBoxCalendrier, reservationPane, calendrierPane, affichagePlanning);
    }

    public static PlanningCollection getPlanning(){
        return planning;
    }

    public static Controleur getControleur(){
        return controleur;
    }

    public static GridPane getCalendrierPane(){
        return calendrierPane;
    }

    public static GridPaneFormulaireReservation getReservationPane(){
        return reservationPane;
    }

    public static VBoxAffichagePlanning getAffichagePlanning(){return affichagePlanning;}

}
