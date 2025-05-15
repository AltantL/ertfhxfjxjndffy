package modele;

import exception.ExceptionPlanning;

public class Reservation implements Comparable<Reservation> {

    private String chintitule;
    private Date chDate;
    private PlageHoraire chPlageHoraire;


    public Reservation(String parintitule, Date pardate, PlageHoraire parplageHoraire) throws ExceptionPlanning{
        chintitule = parintitule;
        chDate = pardate;
        chPlageHoraire = parplageHoraire;
        if (!this.chPlageHoraire.estValide() || !this.chDate.estValide())
            throw new ExceptionPlanning(0);
    }

    public int compareTo(Reservation reservation) {
        if (chDate.compareTo(reservation.chDate) == 1) {
            return 1;
        }
        if (chDate.compareTo(reservation.chDate) == -1) {
            return -1;
        }

        if (chPlageHoraire.compareTo(reservation.chPlageHoraire) == 1) {
                return 1;
        }
        if (chPlageHoraire.compareTo(reservation.chPlageHoraire) == -1) {
                return -1;
        }

        return 0;
    }

    public boolean estValide() {
        if (!this.chPlageHoraire.estValide())
            return false;
        if(!this.chDate.estValide())
            return false;
        return true;
    }

    public String getChintitule() {
        return chintitule;
    }

    public Date getDate() {
        return chDate;
    }

    public String toString() {
        return "Reservation de : " + chintitule + " le " + chDate + " à " + chPlageHoraire;
    }
}
