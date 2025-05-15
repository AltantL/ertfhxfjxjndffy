package clients;

import modele.CalendrierDuMois;

public class ClientsCalendirer {
    public static void main(String[] args) {

        CalendrierDuMois test1 = new CalendrierDuMois(5,2020);
        CalendrierDuMois test2 = new CalendrierDuMois(9,2019);

        System.out.println(test1);
        System.out.println(test2);

    }
}
