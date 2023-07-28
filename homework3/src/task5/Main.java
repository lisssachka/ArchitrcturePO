package task5;

public class Main {
    public static void main(String[] args) {
        Text myText = new Text("Hello, world!");
        PrintText textPrint = new ConsolePrint();
        Printer myPrinter = new Printer(textPrint);
        myPrinter.print(myText);
    }
}
