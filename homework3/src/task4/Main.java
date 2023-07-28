package task4;

public class Main {
    public static void main(String[] args) {
        Working robot = new RobotWorker();
        Working human = new HumanWorker();
        Eating humanEat = new HumanWorker();
        robot.work();
        human.work();
        humanEat.eat();
    }
}
