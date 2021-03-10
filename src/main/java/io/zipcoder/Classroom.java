package io.zipcoder;

import java.util.*;

public class Classroom {
    public Student[] students;
    public HashMap<Character, ArrayList<Student>> gradedStudents = new HashMap<Character, ArrayList<Student>>();

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
        Arrays.sort(students);
        return students;
    }

    public void setGradeBook() {
        Student[] sortedStudentsByGrade = getStudentsByScore();
        double count;
        double percentage;
        ArrayList<Student> aStudents = new ArrayList<>();
        ArrayList<Student> bStudents = new ArrayList<>();
        ArrayList<Student> cStudents = new ArrayList<>();
        ArrayList<Student> dStudents = new ArrayList<>();
        ArrayList<Student> fStudents = new ArrayList<>();

        for(int i = 0; i < sortedStudentsByGrade.length; i++) {
            count = 0;
            for(int j = 0; j < sortedStudentsByGrade.length; j++) {
                if (sortedStudentsByGrade[i].getAverageExamScore() >= sortedStudentsByGrade[j].getAverageExamScore() && i != j) {
                    count++;
                }
            }
            percentage = (count * 100) / (sortedStudentsByGrade.length - 1);

            if (percentage >= 90) {
                aStudents.add(sortedStudentsByGrade[i]);
            } else if (percentage <= 89 && percentage >= 71) {
                bStudents.add(sortedStudentsByGrade[i]);
            } else if (percentage <= 70 && percentage >= 51) {
                cStudents.add(sortedStudentsByGrade[i]);
            } else if (percentage >= 50 && percentage <= 11) {
                dStudents.add(sortedStudentsByGrade[i]);
            } else fStudents.add(sortedStudentsByGrade[i]);
        }

        gradedStudents.put('A', aStudents);
        gradedStudents.put('B', bStudents);
        gradedStudents.put('C', cStudents);
        gradedStudents.put('D', dStudents);
        gradedStudents.put('F', fStudents);
    }

    public ArrayList<Student> getGradeBook(Character grade) {
        return gradedStudents.get(grade);
    }

}
