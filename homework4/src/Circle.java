/**
 * Класс, описывающих Круг
 * Свойство - радиус
 */

public class Circle extends Shape{
    private double radius;

    /**
     * Конструктор для создания нового объекта с заданным параметром
     * @param radius радиус круга
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Метод для вычисления площади круга
     * @return площадь круга
     */
    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Метод для вычисления периметра круга
     * @return периметр круга
     */
    @Override
    double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
