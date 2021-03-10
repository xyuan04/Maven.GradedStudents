package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Classroom {
    public Student[] students;

    public Classroom(int maxNumberOfStudents) {
        students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom() {
        students = new Student[30];
    }


    public String getStudents() {
        String studentList = "Students: \n";
        for(int i  = 0; i < students.length; i++) {
            if(students[i] != null) {
                studentList += String.format("\t%s %s\n", students[i].getFirstName(), students[i].getLastName());
            }
        }
        return studentList;
    }

    public int numberOfStudents() {
        return students.length;
    }

    public double getAverageExamScore() {
        double totalAvgScore = 0;
        double avgAvgScore = 0;

        for(int i = 0; i < students.length; i++) {
            totalAvgScore += students[i].getAverageExamScore();
        }

        avgAvgScore = totalAvgScore/students.length;

        return  avgAvgScore;
    }

    public void addStudent(Student student) {
        ArrayList<Student> temp = new ArrayList<>();
        temp.add(student);

        for(int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = temp.get(0);
                break;
            }
        }
    }

    public void removeStudent(String firstName, String lastName) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getFirstName().equals(firstName) && students[i].getLastName().equals(lastName)) {
                students[i] = null;
            }
        }

        for (int i = 0; i < students.length - 1; i++) {
            if (students[i] == null) {
                students[i] = students[i + 1];
                students[i+1] = null;
            }
        }
    }

    public Student[] getStudentsByScore() {
        double[] highestScoreToLowest = new double[students.length];
        Student[] smartestToJavaleMagee = new Student[students.length];

        for (int i = 0; i < students.length; i++) {
            highestScoreToLowest[i] = students[i].getAverageExamScore();
        }

        Arrays.sort(highestScoreToLowest);
        double start = 0;
        double end = highestScoreToLowest.length - 1;
        double temp;
        while (end > start) {
            temp = highestScoreToLowest[(int)end];
            highestScoreToLowest[(int)end] = highestScoreToLowest[(int)start];
            highestScoreToLowest[(int)start] = temp;
            end--;
            start++;
        }

        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < students.length; j++) {
                if (students[j].getAverageExamScore() == highestScoreToLowest[i]) {
                    smartestToJavaleMagee[i] = students[j];
                }
            }
        }

        return smartestToJavaleMagee;
    }


}
