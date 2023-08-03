/**
 * Класс, описывающий треугольник
 * Свойства - значения сторон треугольника
 */

public class Triangle extends Shape{
    private double side1;
    private double side2;
    private double side3;

    /**
     * Конструктор для создания объекта класса с входными параметрами
     * @param side1 первая сторона треугольника
     * @param side2 вторая сторона треугольника
     * @param side3 третья сторона треугольника
     */

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    /**
     * Метод для вычисления площади треугольника
     * @return площадь треугольника
     */
    @Override
    double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    /**
     * Метод для вычисления периметра треугольника
     * @return перимерт треугольника
     */
    @Override
    double getPerimeter() {
        return side1 + side2 + side3;
    }
}