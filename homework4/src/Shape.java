/**
 * Класс-абстракция основа для создания классов конкретных фигур
 */

public abstract class Shape {
    /**
     * Метод вычисления площади фигуры
     * @return площадь фигуры
     */
    abstract double getArea();

    /**
     * Метод вычисления периметра фигуры
     * @return периметр фигуры
     */
    abstract double getPerimeter();
}