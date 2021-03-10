package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void testGetFirstName() {
        // : Given
        String firstName = "Xiong";
        String lastName = "Yuan";
        Double[] examScores = {100.0, 100.0, 90.0, 100.0, 93.0};
        Student xiong = new Student(firstName, lastName, examScores);

        // : When
        String expected = "Xiong";
        String actual = xiong.getFirstName();

        // : Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetLastName() {
        // : Given
        String firstName = "Xiong";
        String lastName = "Yuan";
        Double[] examScores = {100.0, 100.0, 90.0, 100.0, 93.0};
        Student xiong = new Student(firstName, lastName, examScores);

        // : When
        String expected = "Yuan";
        String actual = xiong.getLastName();

        // : Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetFirstName() {
        // : Given
        String firstName = "Xiong";
        String lastName = "Yuan";
        Double[] examScores = {100.0, 100.0, 90.0, 100.0, 93.0};
        Student xiong = new Student(firstName, lastName, examScores);

        // : When
        xiong.setFirstName("Git-Yee");
        String expected = "Git-Yee";
        String actual = xiong.getFirstName();


        // : Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetLastName() {
        // : Given
        String firstName = "Xiong";
        String lastName = "Yuan";
        Double[] examScores = {100.0, 100.0, 90.0, 100.0, 93.0};
        Student xiong = new Student(firstName, lastName, examScores);

        // : When
        xiong.setLastName("Chu");
        String expected = "Chu";
        String actual = xiong.getLastName();

        // : Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNumberOfExamsTaken() {
        // : Given
        String firstName = "Xiong";
        String lastName = "Yuan";
        Double[] examScores = {100.0, 100.0, 90.0, 100.0, 93.0};
        Student xiong = new Student(firstName, lastName, examScores);

        // : When
        int expected = 5;
        int actual = xiong.getNumberOfExamsTaken();

        // : Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetExamsScores() {
        // : Given
        String firstName = "Xiong";
        String lastName = "Yuan";
        Double[] examScores = {100.0, 100.0, 90.0, 100.0, 93.0};
        Student xiong = new Student(firstName, lastName, examScores);

        // : When
        String expected = "Exam Scores:\n" +
                "\tExam 1 -> 100.0\n" +
                "\tExam 2 -> 100.0\n" +
                "\tExam 3 -> 90.0\n" +
                "\tExam 4 -> 100.0\n" +
                "\tExam 5 -> 93.0\n";
        String actual = xiong.getExamScores();

        // : Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddExamScores() {
        // : Given
        String firstName = "Xiong";
        String lastName = "Yuan";
        Double[] examScores = {100.0, 100.0, 90.0, 100.0, 93.0};
        Student xiong = new Student(firstName, lastName, examScores);

        // : When
        xiong.addExamScores(100.0);
        xiong.addExamScores(98.0);
        xiong.addExamScores(100.0);
        int expected = 8;
        int actual = xiong.getNumberOfExamsTaken();

        // : Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetExamScore() {
        // : Given
        String firstName = "Xiong";
        String lastName = "Yuan";
        Double[] examScores = {100.0, 100.0, 90.0, 100.0, 93.0};
        Student xiong = new Student(firstName, lastName, examScores);

        // : When
        xiong.setExamScores(1, 90.0);
        double expected = 90;
        double actual = xiong.getExamScore(1);

        // : Then
        Assert.assertEquals(expected, actual, 1e-16);
    }

    @Test
    public void testGetAverageExamScore() {
        // : Given
        String firstName = "Xiong";
        String lastName = "Yuan";
        Double[] examScores = {100.0, 100.0, 90.0, 100.0, 93.0};
        Student xiong = new Student(firstName, lastName, examScores);

        // : When
        double expected = 96.6;
        double actual = xiong.getAverageExamScore();

        // : Then
        Assert.assertEquals(expected, actual, 1e-16);
    }

    @Test
    public void testToString() {
        // : Given
        String firstName = "Xiong";
        String lastName = "Yuan";
        Double[] examScores = {100.0, 100.0, 90.0, 100.0, 93.0};
        Student xiong = new Student(firstName, lastName, examScores);

        // : When
        String expected = "Student Name: Xiong Yuan\n" +
                "> Average Score: 96.6\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 100.0\n" +
                "\tExam 2 -> 100.0\n" +
                "\tExam 3 -> 90.0\n" +
                "\tExam 4 -> 100.0\n" +
                "\tExam 5 -> 93.0\n";
        String actual = xiong.toString();
        System.out.println(expected);
        System.out.println(actual);

        // : Then
        Assert.assertEquals(expected, actual);
    }

}