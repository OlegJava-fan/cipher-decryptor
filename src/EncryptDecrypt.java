public class EncryptDecrypt {
    private final String phrase;
    private final int iteration;

    public String getPhrase() {
        return phrase;
    }

    public EncryptDecrypt(String phrase, int iteration) {
        this.phrase = phrase;
        this.iteration = iteration;
    }

    public String encrypt(String phrase, int iteration) {

        if (phrase.isBlank()||iteration<1){
            return getPhrase();
        }

        StringBuilder charBox = new StringBuilder();

        oddChar(phrase, charBox);

        evenChar(phrase, charBox);

        if (iteration == 1) {
            return charBox.toString();
        }

        return encrypt(charBox.toString(), iteration - 1);


    }

    public String decrypt(String phrase, int iteration) {
        if (phrase.isBlank()||iteration<1){
            return phrase;

        }
        StringBuilder charBox = new StringBuilder();


        int centerPhrase = phrase.length() / 2;

        searchForEvenCharLeft(phrase, charBox, centerPhrase);
        searchForOddCharRight(phrase, charBox, centerPhrase);
        searchForOddCharLeft(phrase, charBox, centerPhrase);
        searchForEvenCharRight(phrase, charBox, centerPhrase);


        if (iteration == 1) {
            return charBox.toString();
        }

        return decrypt(charBox.toString(), iteration - 1);

    }

    private void evenChar(String phrase, StringBuilder charBox) {
        for (int i = 0; i <= phrase.length() - 1; i++) {
            if (i % 2 == 0) {
                charBox.append(phrase.charAt(i));
            }
        }
    }

    private void oddChar(String phrase, StringBuilder charBox) {
        for (int i = 0; i <= phrase.length() - 1; i++) {
            if (i % 2 == 1) {
                charBox.append(phrase.charAt(i));
            }
        }
    }

    private static void searchForEvenCharRight(String phrase, StringBuilder charBox, int centerPhrase) {
        for (int i = centerPhrase; i <= phrase.length() - 1; i++) {
            if (i % 2 == 0 && i != phrase.length() / 2) {
                charBox.append(phrase.charAt(i));
            }
        }
    }

    private static void searchForOddCharLeft(String phrase, StringBuilder charBox, int centerPhrase) {
        for (int i = centerPhrase; i >= 0; i--) {
            if (i % 2 == 1) {
                charBox.append(phrase.charAt(i));
            }
        }
    }

    private static void searchForOddCharRight(String phrase, StringBuilder charBox, int centerPhrase) {
        for (int i = centerPhrase; i <= phrase.length() - 1; i++) {
            if (i % 2 == 1) {
                charBox.append(phrase.charAt(i));
            }
        }
    }

    private static void searchForEvenCharLeft(String phrase, StringBuilder charBox, int centerPhrase) {
        for (int i = centerPhrase; i >= 0; i--) {
            if (i % 2 == 0) {
                charBox.append(phrase.charAt(i));
            }
        }
    }

}