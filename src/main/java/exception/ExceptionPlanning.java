package exception;

import constantes.ConstantesErreur;

public class ExceptionPlanning extends Exception implements ConstantesErreur {
    private int codeErreur;

    public ExceptionPlanning(int parcodeErreur) {
        codeErreur = parcodeErreur;
    }

    public String getcodeErreur(){
        return ERREUR_PLANNING[codeErreur];
    }
}
