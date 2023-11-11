package services;

public final class ValidUtilService {

    private ValidUtilService() {
    }

    public static boolean validChoice(int choiceAux, int total) {
        return choiceAux > 0 && choiceAux <= total;
    }

}
