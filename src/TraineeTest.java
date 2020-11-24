import java.util.Scanner;

public class TraineeTest {
    public static void main(String[] args) {

        switch (setOperation()) {

            case 1:
                Info info = new Info();
                String temp = info.getPhrase().toLowerCase().trim();
                EncryptDecrypt encryptDecrypt = new EncryptDecrypt(temp, info.getIteration());
                String encrypt = encryptDecrypt.encrypt(temp, info.getIteration());
                String decrypt = encryptDecrypt.decrypt(encrypt, info.getIteration());

                if (temp.isBlank() || info.getIteration() < 1) {
                    System.out.println("Your phrase is empty or wrong iteration");

                } else {
                    System.out.println("Your encrypt phrase:" + encrypt + " in the " + info.getIteration() + "iteration");
                    System.out.println("Your phrase after decrypt: " + decrypt);
                }
                break;

            case 2:
                InfoText infoText = new InfoText();
                String text = infoText.getText();

                SearchMostFrequentWords words = new SearchMostFrequentWords(text);
                System.out.println(words.wordsMass(text));
                break;
        }
    }
        static int setOperation () {
            System.out.println("Chose operation:\n" + "1)Encrypt/decrypt phrase\n" + "2)Most frequent words in your text\n");
            Scanner scanner = new Scanner(System.in);
            if (!scanner.hasNextInt()) {
                System.out.println("Wrong operation");
                return setOperation();
            } else {
                return scanner.nextInt();
            }
        }
    }
