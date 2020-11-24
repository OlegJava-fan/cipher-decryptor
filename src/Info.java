import java.util.Scanner;

class Info {
    private String phrase;
    private int iteration;


    public String getPhrase() {
        return phrase;
    }

    private String setPhrase() {
        System.out.println("Enter a phrase for encryption");
        Scanner scan = new Scanner(System.in);
        return this.phrase = scan.nextLine();
    }

    public int getIteration() {
        return iteration;
    }

    private int setIteration() {

        System.out.println("Enter the number of encryption");
        Scanner scan = new Scanner(System.in);
        if (!scan.hasNextInt()) {
            System.out.println("Wrong number of encryption");
            return setIteration();
        }
        return this.iteration = scan.nextInt();
    }

    public Info() {
        this.phrase = setPhrase();
        this.iteration = setIteration();
    }
}

