package test;

import Model.MultipleChoiceTest;
import Model.Student;
import Model.Team;

import java.util.Arrays;

public class Main {
    void main() {
        IO.println("Teams: ");
        Team team1 = new Team("25V", "A1.32");
        IO.println(team1.toString());
        Team team2 = new Team("25Y", "A1.28");
        IO.println(team2.toString());

        int[] gradesStudent1 = {7, 4, 7, 10};
        int[] gradesStudent2 = {12, 12, 10, 12};
        int[] gradesStudent3 = {1, 2, 3, 4};
        int[] gradesStudent4 = {1};


        Student student1 = new Student("Ib", true, gradesStudent1);
        Student student2 = new Student("Ulla", true, gradesStudent2);
        Student student3 = new Student("Per", false, gradesStudent2);
        Student student4 = new Student("Hans", true, gradesStudent2);
        Student student5 = new Student("Anna", true, gradesStudent3);
        Student student6 = new Student("Leo", false, gradesStudent4);
        team1.addStudent(student1);
        team1.addStudent(student2);
        team1.addStudent(student3);
        team2.addStudent(student4);
        team2.addStudent(student5);
        team2.addStudent(student6);

        Student[] allStudents = {student1, student2, student3, student4, student5, student6};

        IO.println("Students in team 25V:");
        IO.println(team1.getStudents().toString());
        IO.println("Students in team 25Y:");
        IO.println(team2.getStudents().toString());

        IO.println();
        IO.println("Active students in 25V:");
        IO.println(Arrays.toString(team1.activeStudents()));
        IO.println("Active students in 25y:");
        IO.println(Arrays.toString(team2.activeStudents()));

        IO.println("TEST");
        IO.println(student1.bestGrade());
        IO.println(student1.averageGrade());
        IO.println(team1.averageGradeTeam());
        IO.println(Arrays.toString(team1.highScoreStudents(8)));

        for (Student student : allStudents) {
            student.setAnswers(MultipleChoiceTest.generateAnswers(10));
            IO.println(Arrays.toString(student.getAnswers()));

        }
        IO.println(student1.correctAnswerCount());
    }
}
