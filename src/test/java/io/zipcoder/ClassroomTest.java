package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ClassroomTest {

    @Test
    public void testClassroomConstructor() {
        // : Given
        Classroom nullClass = new Classroom();

        // : When
        int expected = 30;
        int actual = nullClass.numberOfStudents();

        // : Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testClassroomConstructorWithMaxStudents() {
        // : Given
        Classroom maxClass = new Classroom(69);

        // : When
        int expected = 69;
        int actual = maxClass.numberOfStudents();

        // : Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testClassroomConstructorWithStudentsArray() {
        // : Given
        Double[] examScores = {100.0, 100.0, 90.0, 100.0, 93.0};
        Double[] examScores2 = {75.0, 58.0, 84.0, 96.0, 98.0};
        Double[] examScores3 = {55.0, 65.0, 75.0, 85.0, 95.0};
        Student student1 = new Student("student","one", examScores);
        Student student2 = new Student("student","two", examScores2);
        Student student3 = new Student("student","three", examScores3);
        Student[] zipCode = {student1, student2, student3};

        Classroom codeClass = new Classroom(zipCode);

        // : When
        int expected = 3;
        int actual = codeClass.numberOfStudents();

        // : Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetStudents() {
        // : Given
        Double[] examScores = {100.0, 100.0, 90.0, 100.0, 93.0};
        Double[] examScores2 = {75.0, 58.0, 84.0, 96.0, 98.0};
        Double[] examScores3 = {55.0, 65.0, 75.0, 85.0, 95.0};
        Student student1 = new Student("student","one", examScores);
        Student student2 = new Student("student","two", examScores2);
        Student student3 = new Student("student","three", examScores3);
        Student[] zipCode = {student1, student2, student3};

        Classroom codeClass = new Classroom(zipCode);

        // : When
        String expected = String.format("Students: \n" +
                "\tstudent one\n" +
                "\tstudent two\n" +
                "\tstudent three\n");
        String actual = codeClass.getStudents();
        System.out.println(expected);
        System.out.println(actual);

        // : Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAverageExamScore() {
        // : Given
        Double[] examScores = {100.0, 100.0, 90.0, 100.0, 93.0};
        Double[] examScores2 = {75.0, 58.0, 84.0, 96.0, 98.0};
        Double[] examScores3 = {55.0, 65.0, 75.0, 85.0, 95.0};
        Student student1 = new Student("student","one", examScores);
        Student student2 = new Student("student","two", examScores2);
        Student student3 = new Student("student","three", examScores3);
        Student[] zipCode = {student1, student2, student3};

        Classroom codeClass = new Classroom(zipCode);

        // : When
        double expected = 84.6;
        double actual = codeClass.getAverageExamScore();
        System.out.println(expected);
        System.out.println(actual);

        // : Then
        Assert.assertEquals(expected, actual, 0.00000001);
    }

    @Test
    public void testAddStudent() {
        // : Given
        Double[] examScores = {100.0, 100.0, 90.0, 100.0, 93.0};
        Double[] examScores2 = {75.0, 58.0, 84.0, 96.0, 98.0};
        Double[] examScores3 = {55.0, 65.0, 75.0, 85.0, 95.0};
        Student student1 = new Student("student","one", examScores);
        Student student2 = new Student("student","two", examScores2);
        Student student3 = new Student("student","three", examScores3);

        Classroom codeClass = new Classroom(3);

        // : When
        codeClass.addStudent(student1);
        codeClass.addStudent(student2);
        String expected = String.format("Students: \n" +
                "\tstudent one\n" +
                "\tstudent two\n");
        String actual = codeClass.getStudents();
        System.out.println(expected);
        System.out.println(actual);

        // : Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveStudent() {
        // : Given
        Double[] examScores = {100.0, 100.0, 90.0, 100.0, 93.0};
        Double[] examScores2 = {75.0, 58.0, 84.0, 96.0, 98.0};
        Double[] examScores3 = {55.0, 65.0, 75.0, 85.0, 95.0};
        Student student1 = new Student("student","one", examScores);
        Student student2 = new Student("student","two", examScores2);
        Student student3 = new Student("student","three", examScores3);

        Classroom codeClass = new Classroom(3);

        // : When
        codeClass.addStudent(student1);
        codeClass.addStudent(student2);
        codeClass.addStudent(student3);
        codeClass.removeStudent("student", "two");
        String expected = String.format("Students: \n" +
                "\tstudent one\n" +
                "\tstudent three\n");
        String actual = codeClass.getStudents();
        System.out.println(expected);
        System.out.println(actual);
        for(int i = 0; i < codeClass.students.length; i++) {
            System.out.println(codeClass.students[i]);
        }

        // : Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetStudentsByScore() {
        // : Given
        Double[] examScores = {100.0, 100.0, 90.0, 100.0, 93.0};
        Double[] examScores2 = {75.0, 58.0, 84.0, 96.0, 98.0};
        Double[] examScores3 = {100.0, 100.0, 100.0, 100.0, 100.0};
        Student student1 = new Student("student","one", examScores);
        Student student2 = new Student("student","two", examScores2);
        Student student3 = new Student("student","three", examScores3);

        Classroom codeClass = new Classroom(3);

        // : When
        codeClass.addStudent(student1);
        codeClass.addStudent(student2);
        codeClass.addStudent(student3);

        String expected = "three one two ";
        String actual = "";

        for(int i = 0; i < codeClass.students.length; i++) {
            actual += codeClass.getStudentsByScore()[i].getLastName() + " ";
        }

        // : Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetGradeBook() {
        // : Given
        Double[] examScores = {100.0, 100.0, 90.0, 100.0, 93.0};
        Double[] examScores2 = {75.0, 58.0, 84.0, 96.0, 98.0};
        Double[] examScores3 = {100.0, 100.0, 100.0, 100.0, 100.0};
        Student student1 = new Student("student","one", examScores);
        Student student2 = new Student("student","two", examScores2);
        Student student3 = new Student("student","three", examScores3);

        Classroom codeClass = new Classroom(3);

        // : When
        codeClass.addStudent(student1);
        codeClass.addStudent(student2);
        codeClass.addStudent(student3);
        codeClass.setGradeBook();


        ArrayList<Student> expected = new ArrayList<>(Arrays.asList(student3));
        ArrayList<Student> actual = codeClass.getGradeBook('A');
        System.out.println(codeClass.getGradeBook('A'));
        System.out.println(codeClass.getGradeBook('B'));
        System.out.println(codeClass.getGradeBook('C'));
        System.out.println(codeClass.getGradeBook('D'));
        System.out.println(codeClass.getGradeBook('F'));

        // : Then
        Assert.assertEquals(expected, actual);
    }


}
