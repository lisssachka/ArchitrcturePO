/**
 * Класс, описывающий Прямоугольник
 * Свойства - длина и ширина
 */
public class Rectangle extends Shape{
    private double length;
    private double width;

    /**
     * Конструктор для создания нового объекта с заданными параметрами
     * @param length длина прямоугольника
     * @param width ширина прямоугольника
     */
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    /**
     * Метод для вычисления площади прямоугольника
     * @return площадь прямоугольника
     */
    @Override
    double getArea() {
        return length * width;
    }

    /**
     * Метод для вычисления периметра прямоугольника
     * @return периметр прямоугольника
     */
    @Override
    double getPerimeter() {
        return 2 * (length + width);
    }
}
