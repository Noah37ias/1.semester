package test;

import Model.MultipleChoiceTest;
import Model.Student;
import Model.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    private final ArrayList<Team> allTeams = new ArrayList<>();

    void main() {
        boolean washedUp = false;

        while (!washedUp) {
            printMenu();

            int userInput = Integer.parseInt(IO.readln());
            switch (userInput) {
                case 1 -> {

                    Scanner sc = new Scanner(IO.readln("Team name and room:"));
                    String teamName;
                    String roomName;
                    String myStr = sc.nextLine();
                    String regex = "[\\s]";
                    String[] myArray = myStr.split(regex);
                    if (myArray.length == 2) {
                        teamName = myArray[0];
                        roomName = myArray[1];
                        Team team = new Team(teamName, roomName);
                        allTeams.add(team);
                        IO.println("--> Team created with name and room set to " + teamName + " and " + roomName);
                        sc.close();
                    } else {
                        IO.println("Error: Team name and/or room names are incorrect.");
                    }
                }
                case 2 -> {
                    boolean found = false;
                    while (!found) {
                        String teamName = IO.readln("Name of team (or type 'back' to cancel): ");
                        if (teamName.equalsIgnoreCase("back")) {
                            IO.println("Returning to main menu...");
                            IO.println();
                            break;
                        } else {

                            for (Team team : allTeams) {
                                if (teamName.equals(team.getName())) {
                                    found = true;
                                    Scanner scanner = new Scanner(IO.readln("Student's name and activity status (true/false): "));

                                    String str = scanner.nextLine();
                                    String[] strArray = str.split(" ");
                                    if (strArray.length == 2 && (strArray[1].equalsIgnoreCase("true") || strArray[1].equalsIgnoreCase("false"))) {
                                        String studentName = strArray[0];
                                        boolean isActive = Boolean.parseBoolean(strArray[1]);

                                        scanner = new Scanner(IO.readln("Student's number of grades: "));
                                        int gradeCount = scanner.nextInt();
                                        scanner = new Scanner(IO.readln(("Student's " + gradeCount + " grades: ")));
                                        int[] studentGrades = new int[gradeCount];
                                        for (int i = 0; i < gradeCount; i++) {
                                            studentGrades[i] = scanner.nextInt();
                                        }

                                        Student student = new Student(studentName, isActive, studentGrades);
                                        student.setAnswers((MultipleChoiceTest.generateAnswers()));
                                        team.addStudent(student);

                                        String active;
                                        if (isActive) {
                                            active = "(active)";
                                        } else active = "(inactive)";
                                        IO.println("--> Student " + studentName + active + " with grades " + Arrays.toString(studentGrades) + " created in team " + teamName);
                                        IO.println();
                                    } else {
                                        IO.println("ERROR: INVALID INPUT");
                                        IO.println();
                                    }
                                }
                            }
                        }
                    }
                }
                case 3 -> {
                    boolean found = false;

                    while (!found) {
                        Scanner sc = new Scanner(IO.readln("Insert student name: "));
                        String name = sc.next();
                        if (name.equalsIgnoreCase("back")) {
                            IO.println("Returning to main menu...");
                            found = true;
                        } else {
                            for (Team team : allTeams) {
                                for (Student students : team.getStudents()) {
                                    if (name.equalsIgnoreCase(students.getName())) {
                                        String[] info = team.studentInfos(students);
                                        IO.println(String.format("%-5s | Avg. grade: %5.2f  | Correct: %s", info[0], Double.parseDouble(info[1]), info[2]));
                                        found = true;
                                    }
                                    if (!found) {
                                        IO.println("Try again noob!");
                                        IO.println("No student found with name " + name);
                                    }
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
                        if (teamName.equalsIgnoreCase("back")) {
                            IO.println("Returning to main menu...");
                            found = true;
                        } else {
                            for (Team team : allTeams) {
                                if (teamName.equalsIgnoreCase(team.getName())) {
                                    for (Student student : team.getStudents()) {
                                        String[] info = team.studentInfos(student);
                                        IO.println(String.format("%-5s | Avg. grade: %5.2f  | Correct: %s", info[0], Double.parseDouble(info[1]), info[2]));
                                        found = true;

                                    }


                                }
                            }
                        }
                        if (!found) {
                            IO.println("Try again noob");
                            IO.println("No team name found with name " + teamName);
                        }
                    }
                }
                case 5 -> {
                    for (Team team : allTeams) {
                        for (Student student : team.getStudents()) {
                            if (team.getStudents().isEmpty()) {
                                IO.println("No student in team, team is empty");
                            }
                            String[] info = team.studentInfos(student);
                            IO.println(String.format("%-5s | Avg. grade: %5.2f  | Correct: %s", info[0], Double.parseDouble(info[1]), info[2]));
                        }
                    }
                }
                case 6 -> {
                    boolean found = false;

                    while (!found) {
                        Scanner sc = new Scanner(IO.readln("Insert the student name you want to remove: "));
                        String name = sc.next();
                        Student studentRemove = null;
                        if (name.equalsIgnoreCase("back")) {
                            IO.println("Returning to main menu...");
                            found = true;
                        } else {
                            for (Team team : allTeams) {
                                ArrayList<Student> students = team.getStudents();
                                for (Student student : team.getStudents()) {
                                    if (name.equalsIgnoreCase(student.getName())) {
                                        IO.println("Student " + student.getName() + " has been removed");
                                        studentRemove = student;
                                        found = true;
                                    }
                                }
                                if (found) {
                                    team.removeStudent(studentRemove.getName());
                                } else {
                                    IO.println("Try again noob!");
                                    IO.println("No student found with name " + name);
                                }
                            }
                        }
                    }
                }
                case 7 -> {
                    boolean found = false;
                    while (!found) {
                        Scanner sc = new Scanner(IO.readln("Insert the team name you want to remove: "));
                        String teamName = sc.next();
                        if (teamName.equalsIgnoreCase("back")) {
                            IO.println("Returning to main menu...");
                            found = true;
                        } else {
                            for (Team team : allTeams) {
                                if (teamName.equalsIgnoreCase(team.getName())) {
                                    IO.println("Team " + teamName + " has been removed");
                                    team.getStudents().removeAll(team.getStudents());
                                    //allTeams.remove(team);
                                    found = true;
                                }
                            }
                            if (!found) {
                                IO.println("Try again noob!");
                                IO.println("No team found with name " + teamName);
                            }
                        }
                    }
                }
                case 8 -> {
                    washedUp = true;
                    IO.println("  ======================================================");
                    IO.println("  ||  🚨 SYSTEM SHUTDOWN. YOU ARE DONE MY FRIEND. 🚨 ||");
                    IO.println("  ||                  S A L U T E !                  ||");
                    IO.println("  ||     ( •_•)>⌐■-■                 (⌐■_■)          ||");
                    IO.println("  ||     (╯°□°)╯︵ ┻━┻             ¯\\_(ツ)_/¯         ||");
                    IO.println("  ||     \\( ﾟヮﾟ)/                   (✌ﾟ∀ﾟ)☞          ||");
                    IO.println("  ||             🚀 💥 👾 ✌️ 😎 🏁                  ||");
                    IO.println("  ======================================================");
                }
                default -> {
                    System.err.println("=========================");
                    System.err.println("Invalid input, try again!");//printer error i rød
                    System.err.println("=========================");
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
        IO.println("6: Remove a student");
        IO.println("7: Remove a team");
        IO.println("8: Exit program");
    }
}
