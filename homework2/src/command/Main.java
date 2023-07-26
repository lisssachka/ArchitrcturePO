package command;
// Интерфейс команды
interface Command {
    void execute();
}

// ConcreteCommand класс, представляющий конкретную команду
class ConcreteCommand implements Command {
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        receiver.action();
    }
}

// Receiver класс-получатель, выполняющий действие
class Receiver {
    public void action() {
        System.out.println("Выполняется команда");
    }
}

// Invoker вызывает команду
class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}

// Пример использования
public class Main {
    public static void main(String[] args) {
        // Создаем получателя команды
        Receiver receiver = new Receiver();

        // Создаем команду с определенным получателем
        Command command = new ConcreteCommand(receiver);

        // Создаем вызывающего команду
        Invoker invoker = new Invoker();

        // Устанавливаем команду в вызывающего объекта
        invoker.setCommand(command);

        // Выполняем команду
        invoker.executeCommand();
    }
}