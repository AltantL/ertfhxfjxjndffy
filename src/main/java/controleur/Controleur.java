package controleur;

import exception.ExceptionPlanning;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import modele.*;
import vue.GridPaneFormulaireReservation;
import vue.HBoxRoot;


public class Controleur implements EventHandler{

    @Override
    public void handle(Event event) {
        PlanningCollection planning = HBoxRoot.getPlanning();
        GridPaneFormulaireReservation reservationPane = HBoxRoot.getReservationPane();

        //la source de event est un ToggleButton du calendrier
        if (event.getSource() instanceof ToggleButton) {


            ToggleButton boutonDate = (ToggleButton) event.getSource();

            DateCalendrier date = (DateCalendrier) boutonDate.getUserData();

            reservationPane.setDate(date);

        }

        //la source de event est le bouton "Enregistrer" du formulaire de réservatuion

        if (event.getSource() instanceof Button){

            Date date = reservationPane.dateReserve;

            TextField textField = reservationPane.textField;


            ComboBox heureDepart = reservationPane.heureDepart;
            ComboBox minuteDepart = reservationPane.minuteDepart;
            ComboBox heureFin = reservationPane.heureFin;
            ComboBox minuteFin = reservationPane.minuteFin;

            Button boutonEnregistrer = (Button) event.getSource();

            int heureD = heureDepart.getSelectionModel().getSelectedIndex();
            int minuteD = minuteDepart.getSelectionModel().getSelectedIndex();
            int heureF = heureFin.getSelectionModel().getSelectedIndex();
            int minuteF = minuteFin.getSelectionModel().getSelectedIndex();

            Horaire horaire1 = new Horaire(heureD,minuteD);
            Horaire horaire2 = new Horaire(heureF,minuteF);



            PlageHoraire plageHoraire = null;
            try {
                plageHoraire = new PlageHoraire(horaire1,horaire2);
                Reservation reservation = new Reservation(textField.getAccessibleText(), date, plageHoraire);
            } catch (ExceptionPlanning e) {
                throw new RuntimeException(e);
            }

        }
    }
}
