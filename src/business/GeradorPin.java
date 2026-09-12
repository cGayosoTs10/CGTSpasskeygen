package business;

public class GeradorPin extends GeradorSenha {

    private static final int pinsize = 6;

    @Override
    public String gerarSenha() {
        String pin;

        do {
            StringBuilder produto = new StringBuilder(pinsize);

            while (produto.length() < pinsize) {
                produto.append(sortearCaractere(NUMEROS));
            }

            pin = produto.toString();

        } while (!validPin(pin));

        return pin;
    }

    private boolean validPin(String pin) {
        if (digitIsEqual(pin)) {
            return false;
        }

        if (isCrescentSeq(pin)) {
            return false;
        }

        if (isDecrescentSeq(pin)) {
            return false;
        }

        return true;
    }

    private boolean digitIsEqual(String pin) {
        for (int i = 1; i < pin.length(); i++) {
            if (pin.charAt(i) != pin.charAt(0)) {
                return false;
            }
        }

        return true;
    }

    private boolean isCrescentSeq(String pin) {
        for (int i = 1; i < pin.length(); i++) {
            int anterior = Character.getNumericValue(pin.charAt(i - 1));
            int atual = Character.getNumericValue(pin.charAt(i));

            if (atual != anterior + 1) {
                return false;
            }
        }

        return true;
    }

    private boolean isDecrescentSeq(String pin) {
        for (int i = 1; i < pin.length(); i++) {
            int anterior = Character.getNumericValue(pin.charAt(i - 1));
            int atual = Character.getNumericValue(pin.charAt(i));

            if (atual != anterior - 1) {
                return false;
            }
        }

        return true;
    }
}

