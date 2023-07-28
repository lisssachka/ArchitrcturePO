package task5;

public class Printer {
    private PrintText printText;

    public Printer(PrintText printText) {
        this.printText = printText;
    }

    public void print(Text text) {
        printText.print(text.getText());
    }
}
