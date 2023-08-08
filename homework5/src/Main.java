public class Main {
    public static void main(String[] args) {
        StudentsTableGateway gateway = new StudentsTableGateway();

        Student student1 = new Student(1, "Petrova", "Irina", "Russian");
        Student student2 = new Student(2, "Ivanov", "Ivan", "Math");

        gateway.insert(student1);
        gateway.insert(student2);
        System.out.println("Таблица после внесения данных");
        gateway.showStudentsTable();

        Student student2Update  = new Student(2, "Ivanov", "Ivan", "English");
        gateway.update(student2Update);
        System.out.println("Студент с ID 2 после изменения данных о нем");
        System.out.println(gateway.find(2));

        gateway.delete(1);
        System.out.println("Таблица после удаления данных о студенте с ID 1");
        gateway.showStudentsTable();
    }

}