package modele;

import exception.ExceptionPlanning;

public class PlageHoraire {
    private Horaire chDebutHoraire;
    private Horaire chFinHoraire;
    private final static int chDuree_Minimum = 30;

    public PlageHoraire(Horaire pardebutHoraire, Horaire parfinHoraire) throws ExceptionPlanning{
        chDebutHoraire = pardebutHoraire;
        chFinHoraire = parfinHoraire;
        if (chFinHoraire.toMinutes() - chDebutHoraire.toMinutes() < chDuree_Minimum) {
            throw new ExceptionPlanning(2);
        }

    }

    public int duree() {
        return (chFinHoraire.toMinutes() - chDebutHoraire.toMinutes()) / 60;
    }

    public int dureem() {
        return (chFinHoraire.toMinutes() - chDebutHoraire.toMinutes()) % 60;
    }


    public boolean estValide() {
        if (chFinHoraire.toMinutes() - chDebutHoraire.toMinutes() > chDuree_Minimum) {
            return true;
        }
        else {
            return false;
        }
    }

    public int compareTo(PlageHoraire plageHoraire) {
        if (this.chFinHoraire.toMinutes() <= plageHoraire.chDebutHoraire.toMinutes()) {
            return -1;
        }
        else if (plageHoraire.chFinHoraire.toMinutes() <= this.chDebutHoraire.toMinutes()) {
            return 1;
        }
        return 0;
    }

    public String toString() {
        return chDebutHoraire + " - " + chFinHoraire + ", durée : " + duree() + "h" + dureem() + "mn";
    }
}
