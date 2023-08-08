import java.util.*;

public class StudentsTableGateway {
    private List<Student> students;
    public StudentsTableGateway(){
        students = new ArrayList<>();
    }

    /**
     * Поиск студента в базе данных по id
     * @param studentId id студента
     * @return информация о студенте
     */
    public Student find (int studentId){
        for (Student student: students){
            if (student.getStudentId() == studentId){
                return student;
            }
        }
        return null;
    }

    /**
     * Добавление данных о новом студенте
     * @param student объект класса Student
     */

    public void insert(Student student){
        students.add(student);
    }

    /**
     * Изменение данных о студенте, который уже существует в БД
     * @param student объект класса Student
     */
    public void update(Student student){
        int indexInList = students.indexOf(find(student.getStudentId()));
        if (indexInList != -1){
            students.set(indexInList, student);
        }
    }

    /**
     * Удаление информации о студенте из БД по ID студента
     * @param studentID ID студента
     */

    public void delete(int studentID){
        students.remove(find(studentID));
    }

    /**
     * Вывод таблицы Студенты
     */

    public void showStudentsTable(){
        for (Student student: students) {
            System.out.println(student);

        }
    }

}
