package mementor;
// Originator хранит внутреннее состояние и создаёт снимок
class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento save() {
        return new Memento(state);
    }

    public void restore(Memento memento) {
        state = memento.getState();
    }
}

// Memento представляет снимок внутреннего состояния
class Memento {
    private final String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// Caretaker хранит снимок состояния и предоставляет его по запросу
class Caretaker {
    private Memento memento;

    public void saveMemento(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }
}

// Пример использования паттерна Памятка
public class Main {
    public static void main(String[] args) {
        // Создаем объект Originator
        Originator originator = new Originator();
        originator.setState("State1");

        // Создаем объект Caretaker
        Caretaker caretaker = new Caretaker();

        // Сохраняем состояние в Originator и получаем снимок
        caretaker.saveMemento(originator.save());

        // Меняем состояние объекта Originator
        originator.setState("State2");

        // Восстанавливаем сохраненное состояние с использованием снимка из Caretaker
        originator.restore(caretaker.getMemento());
    }
}
