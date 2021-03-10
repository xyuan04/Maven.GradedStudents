package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student implements Comparable<Student>{
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores = new ArrayList<>();
    private double avgExamScore;

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        examScores.addAll(Arrays.asList(testScores));
        setAvgExamScore();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumberOfExamsTaken() {
        return examScores.size();
    }

    public String getExamScores() {
        String studentExamScores = "Exam Scores:\n";
        for(int i = 0; i < examScores.size(); i++) {
            studentExamScores += String.format("\tExam %d -> %s\n", i+1, examScores.get(i));
        }
        return studentExamScores;
    }

    public void addExamScores(double examScore) {
        examScores.add(examScore);
    }

    public void setExamScores(int examNumber, double newScore) {
        examScores.set(examNumber, newScore);
    }

    public double getExamScore(int examNumber) {
        return examScores.get(examNumber);
    }

    public double getAverageExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore() {
        double totalScore = 0;
        for (int i = 0; i < examScores.size(); i++) { totalScore += examScores.get(i);
        }
        avgExamScore = totalScore/examScores.size();
    }

    @Override
    public String toString() {
        String namePart = String.format("Student Name: %s %s\n", this.firstName, this.lastName);
        String avgScore = String.format("> Average Score: %s\n", getAverageExamScore());
        String examScores = String.format("> %s", getExamScores());

        return namePart + avgScore + examScores;
    }

    @Override
    public int compareTo(Student o) {
        return (int)(o.getAverageExamScore() - this.avgExamScore);
    }
}
