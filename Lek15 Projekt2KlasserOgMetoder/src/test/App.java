package test;

import Model.MultipleChoiceTest;
import Model.Student;
import Model.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    private ArrayList<Team> allTeams = new ArrayList<>();
    private ArrayList<Student> allStudents = new ArrayList<>();

    void main() {
        boolean washedUp = false;

        while (!washedUp) {
            printMenu();

            int userInput = Integer.parseInt(IO.readln());
            switch (userInput) {
                case 1 -> {

                    Scanner sc = new Scanner(IO.readln("Team name and room:"));
                    String teamName = sc.next();
                    String roomName = sc.next();

                    Team team = new Team(teamName, roomName);
                    allTeams.add(team);
                    IO.println("--> Team created with name and room set to " + teamName + " and " + roomName);
                    sc.close();
                }
                case 2 -> {
                    boolean found = false;

                    while (!found) {
                        Scanner sc = new Scanner(IO.readln("Name of student's team: "));
                        String teamName = sc.next();
                        for (Team t : allTeams) {
                            if (teamName.equalsIgnoreCase(t.getName())) {
                                sc = new Scanner(IO.readln("Student's name and activity status (true/false): "));
                                String studentName = sc.next();
                                boolean activity = sc.nextBoolean();
                                sc = new Scanner(IO.readln("Student's number of grades:"));
                                int grades = sc.nextInt();
                                sc = new Scanner(IO.readln("Student's " + grades + " grades:"));
                                int[] gradesArr = new int[grades];
                                for (int i = 0; i < grades; i++) {
                                    gradesArr[i] = sc.nextInt();
                                }
                                Student student = new Student(studentName, activity, gradesArr);
                                student.setAnswers(MultipleChoiceTest.generateAnswers(10));
                                allStudents.add(student);

                                IO.println("--> Student " + studentName + " " + activity + " with grades " + Arrays.toString(gradesArr) + " Created in team " + teamName);
                                found = true;
                            }
                            if (!found) {
                                IO.println("Try again noob");
                            }

                        }
                    }

                }
                case 3 -> {
                    boolean found = false;

                    while (!found) {
                        Scanner sc = new Scanner(IO.readln("Insert student name: "));
                        String name = sc.next();
                        for (Team team : allTeams) {
                            for (Student students : allStudents) {
                                if (name.equalsIgnoreCase(students.getName())) {
                                    String[] info = team.studentInfos(students);
                                    IO.println(String.format("%-5s | Avg. grade: %5.2f  | Correct: %s", info[0], Double.parseDouble(info[1]), info[2]));
                                    found = true;
                                }
                                if (!found) {
                                    IO.println("Try again noob");
                                }
                            }
                        }
                    }


                }
                case 4 -> {
                    boolean found = false;

                    while (!found) {
                        Scanner sc = new Scanner(IO.readln("Insert team name: "));
                        String teamName = sc.next();
                        for (Team team : allTeams) {
                            if (teamName.equalsIgnoreCase(team.getName())) {
                                for (Student student : allStudents) {
                                    String[] info = team.studentInfos(student);
                                    IO.println(String.format("%-5s | Avg. grade: %5.2f  | Correct: %s", info[0], Double.parseDouble(info[1]), info[2]));
                                }
                                found = true;
                            }
                            if(!found) {
                                IO.println("Try again noob");
                            }
                        }
                    }
                }
                case 5 ->  {
                    for (Team team : allTeams) {
                            for (Student student : team.getStudents()) {
                                String[] info = team.studentInfos(student);
                                IO.println(String.format("%-5s | Avg. grade: %5.2f  | Correct: %s", info[0], Double.parseDouble(info[1]), info[2]));
                            }

                }
                    }
                case 6 -> {
                    washedUp = true;
                    IO.println("You are done my friend salute");
                }
                default -> {
                    IO.println("Invalid input");
                }
            }
        }

    }

    public void printMenu() {
        IO.println("MENU");
        IO.println("1: Create a team");
        IO.println("2: Create a student");
        IO.println("3: Show one student's info and results");
        IO.println("4: Show one team's info and result");
        IO.println("5: Show info and results for all teams");
        IO.println("6: Exit program");

    }
}
