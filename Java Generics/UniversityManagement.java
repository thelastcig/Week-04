import java.util.*;

abstract class CourseType {
    String name;
    CourseType(String name) { this.name = name; }
    abstract void evaluate(); // Each course type has a different evaluation method
}

class ExamCourse extends CourseType {
    ExamCourse(String name) { super(name); }
    void evaluate() { System.out.println(name + " - Evaluation: Written Exam"); }
}

class AssignmentCourse extends CourseType {
    AssignmentCourse(String name) { super(name); }
    void evaluate() { System.out.println(name + " - Evaluation: Assignments"); }
}

class ResearchCourse extends CourseType {
    ResearchCourse(String name) { super(name); }
    void evaluate() { System.out.println(name + " - Evaluation: Research Paper"); }
}

class Course<T extends CourseType> {
    T courseType;
    
    Course(T courseType) { this.courseType = courseType; }

    void displayCourse() { courseType.evaluate(); }
}

class UniversityUtils {
    static void displayAllCourses(List<? extends CourseType> courses) {
        courses.forEach(CourseType::evaluate);
    }
}

public class UniversityManagement {
    public static void main(String[] args) {
        Course<ExamCourse> math = new Course<>(new ExamCourse("Mathematics"));
        Course<AssignmentCourse> history = new Course<>(new AssignmentCourse("History"));
        Course<ResearchCourse> physics = new Course<>(new ResearchCourse("Quantum Physics"));

        List<CourseType> courseList = Arrays.asList(math.courseType, history.courseType, physics.courseType);

       
        UniversityUtils.displayAllCourses(courseList);
    }
}
