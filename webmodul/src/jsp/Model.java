package jsp;

public class Model {
    public Student getStudent(){
        Student student = new Student();
        student.setName("Michael");
        student.setAge(21);
        return student;
    }
}
