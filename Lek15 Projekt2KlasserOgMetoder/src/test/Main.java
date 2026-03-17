package test;

import Model.MultipleChoiceTest;
import Model.Student;
import Model.Team;

import java.util.Arrays;

public class Main {
    void main() {
        //Opretter og printer vores teams
        IO.println("Teams: ");
        Team team1 = new Team("25V", "A1.32");
        IO.println(team1.toString());
        Team team2 = new Team("25Y", "A1.28");
        IO.println(team2.toString());
        Team[] teams = {team1, team2};//Laver array Team med vores teams

        //Oprettelse af grades til vores students
        int[] gradesStudent1 = {7};
        int[] gradesStudent2 = {12, 12, 10, 12,12,12};
        int[] gradesStudent3 = {1, 2, 3, 4};
        int[] gradesStudent4 = {1};

        //Opretter alle vores students
        Student student1 = new Student("Ib", true, gradesStudent1);
        Student student2 = new Student("Ulla", true, gradesStudent2);
        Student student3 = new Student("Per", false, gradesStudent2);
        Student student4 = new Student("Hans", true, gradesStudent2);
        Student student5 = new Student("Anna", true, gradesStudent3);
        Student student6 = new Student("Leo", false, gradesStudent4);
        //Tilføjer vores 6 forskellige students til de 2 forskellige teams
        team1.addStudent(student1);
        team1.addStudent(student2);
        team1.addStudent(student3);
        team2.addStudent(student4);
        team2.addStudent(student5);
        team2.addStudent(student6);

        //Printer alle students i hvert team opdelt, bruger getStudents metoden fra Team
        IO.println("Students in team 25V:");
        IO.println(team1.getStudents().toString());
        IO.println("Students in team 25Y:");
        IO.println(team2.getStudents().toString());

        //Printer alle students i hvert team, som er aktive
        IO.println();
        IO.println("Active students in 25V:");
        IO.println(Arrays.toString(team1.activeStudents()));
        IO.println("Active students in 25y:");
        IO.println(Arrays.toString(team2.activeStudents()));

        IO.println();
        IO.println("Best grade student 1: " + student1.bestGrade());//Printer bestGrade for en student
        IO.println("Average grade student 1: " + student1.averageGrade()); //Printer gennemsnitlig grade fra en student
        IO.println("Average grade team 1: " + team1.averageGradeTeam()); //Printer gennemsnitlig grade fra alle studerende på et hold
        IO.println("Student in team 1 with average grade over 8 "+ Arrays.toString(team1.highScoreStudents(8)));
        for (Team t : teams) {
            for (Student student : t.getStudents()) {
                student.setAnswers(MultipleChoiceTest.generateAnswers(10));
                IO.print(student.getName() + " ");
                IO.println(Arrays.toString(student.getAnswers()));
            }
        }
        IO.println("Correct answer count for student 1: "+student1.correctAnswerCount());
        IO.println(Arrays.toString(team1.correctAnswerCounts()));
        IO.println(Arrays.toString(team2.correctAnswerCounts()));

        for (Team t : teams) {
            for (Student student : t.getStudents()) {
                student.setAnswers(MultipleChoiceTest.generateAnswers(10));
                IO.println(Arrays.toString(student.getAnswers()));
            }
            }
        for (Team t : teams) { // får hvert studerenes info
            for (Student student : t.getStudents()) {
                String[] info = t.studentInfos(student);
                IO.println(String.format("%-5s | Avg. grade: %5.2f  | Correct: %s", info[0], Double.parseDouble(info[1]), info[2]));
            }
        }
        for (Team t : teams) { // får hvert hold's samlet korrekt pr spørgsmål
            IO.println("Times that questions where correct of team " + t.getName());
            IO.println(Arrays.toString(t.correctQuestionAnswerCounts()));
        }
        IO.println(team1.averageGradeTeam());
    }
    }


