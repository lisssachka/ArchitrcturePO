package template_method;
//Абстрактный класс с шаблонным методом

abstract class AbstractClass {
// Шаблонный метод
    public final void templateMethod() {
        doBefore();
        doSomething();
        doAfter();
    }

// Метод до
// Может быть реализован в абстрактном классе или иметь пустую реализацию

    protected void doBefore() {}

// Абстрактный метод
// Должен быть реализован в каждом наследнике
    protected abstract void doSomething();
// Метод после
//Может быть реализован в абстрактном классе или иметь пустую реализацию
    protected void doAfter() {}
}

//Пример наследника абстрактного класса с переопределением методов

class ConcreteClass extends AbstractClass {
    @Override
    protected void doBefore() {
        // Действия, выполняемые перед выполнением абстрактного метода
    }

    @Override
    protected void doSomething() {
        // Реализация абстрактного метода
    }

    @Override
    protected void doAfter() {
        // Действия, выполняемые после выполнения абстрактного метода
    }
}

public class Main {
    public static void main(String[] args) {
        AbstractClass object = new ConcreteClass();
        object.templateMethod();
    }
}
