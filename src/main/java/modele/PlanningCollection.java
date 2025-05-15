package modele;

import exception.ExceptionPlanning;

import java.util.*;

public class PlanningCollection {
    private ArrayList<Reservation> reservationArrayList;
    private TreeSet<Reservation> reservationTreeSet;
    private TreeMap<Integer, TreeSet<Reservation>> reservationTreeMap;

    public PlanningCollection() {
        reservationArrayList = new ArrayList<>();
        reservationTreeSet = new TreeSet<>();
        reservationTreeMap = new TreeMap<>();
    }



    /**
     * La méthode ajout() ajout dans le champ de type ArrayList, TreeSet et TreeMap de this la reservation reçue en parametre si elle est possible, si il n'y a pas de confile
     * @param reservation
     * @throws ExceptionPlanning
     */
    public void ajout(Reservation reservation) throws ExceptionPlanning {

//        for (int i = 0; i < reservationArray.size(); i++){
//            if (reservationArray.get(i).compareTo(reservation) == 0)
//                throw new ExceptionPlanning(0);
//        }
//
//        reservationArray.add(reservation);

//------------------------------------------------------------------------------

//        Iterator<Reservation> iterator = reservationArray.iterator();
//        while (iterator.hasNext()){
//            Reservation res = iterator.next();
//
//            if (res.compareTo(reservation) == 0){
//                throw new ExceptionPlanning(0);
//            }
//        }
//        reservationArray.add(reservation);

//-------------------------------------------------------------------------------

        if (reservationArrayList.size() == 0){
            reservationArrayList.add(reservation);
        }
        else {
            for (int i = 0; i < reservationArrayList.size(); i++){
                if (reservationArrayList.get(i).compareTo(reservation) == 0){
                    throw new ExceptionPlanning(0);
                }
            }
            reservationArrayList.add(reservation);
        }

//---------------------------------------------------------------------------------

        int tailleTreeSet = reservationTreeSet.size();

        reservationTreeSet.add(reservation);

        if (tailleTreeSet == reservationTreeSet.size()){
            throw new ExceptionPlanning(0);
        }

//-------------------------------------------------------------------------------

        int numSemaine = reservation.getDate().getNumSemaine();
        TreeSet<Reservation> reservationSet = reservationTreeMap.get(numSemaine);
        if (reservationSet == null){
            reservationSet = new TreeSet<>();
            reservationTreeMap.put(numSemaine, reservationSet);
        }
        reservationSet.add(reservation);



    }

    /**
     * retourn l'ensempble des reservation du planning ayant pour date parDate ou null si aucune reservation n'a lieu à cette date.
     * @param dateCalendrier
     * @return treeSet
     */
    public TreeSet<Reservation> getReservationTree(DateCalendrier dateCalendrier) {
        TreeSet<Reservation> treeSet = new TreeSet<>();
        Iterator<Reservation> iterator = reservationTreeSet.iterator();

        while (iterator.hasNext()){
            Reservation reservation = iterator.next();
            if (reservation.getDate().compareTo(dateCalendrier) == 0){
                treeSet.add(reservation);
            }
        }
        if (treeSet.isEmpty())
            return null;
        return treeSet;
    }

    /**
     * return l'ensemble des reservations du planning contenant la chaîne parString dans leur intituler
     * @param intitule
     * @return treeSet
     */
    public TreeSet<Reservation> getReservation (String intitule){
        TreeSet<Reservation> treeSet = new TreeSet<>();
        Iterator<Reservation> iterator = reservationTreeSet.iterator();

        while (iterator.hasNext()){
            Reservation reservation = iterator.next();
            if (reservation.getChintitule().equals(intitule)){
                treeSet.add(reservation);
            }
        }
        if (treeSet.isEmpty())
            return null;
        return treeSet;
    }



    public String toString(){
        return reservationArrayList.size() + " " + reservationArrayList.toString() + "\n" +
                reservationTreeSet.size() + " " + reservationTreeSet.toString()
                + "\n" + reservationTreeMap.size() + " " + reservationTreeMap.toString();
    }

}
