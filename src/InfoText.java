import java.util.Scanner;

class InfoText {

    private String text;
    public String getText() {
        return text;
    }

    private String setText() {
        System.out.println("enter your text");
        Scanner scanner = new Scanner(System.in);
        return this.text = scanner.nextLine();

    }

    public InfoText() {
        this.text = setText();
    }
}