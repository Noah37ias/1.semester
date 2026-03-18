package Model;

import java.util.ArrayList;

public class Team {
    private String name;
    private String room;
    private ArrayList<Student> students;

    public Team(String name, String room) {
        this.name = name;
        this.room = room;
        this.students = new ArrayList<>();
    }
    public Team(){
        this.name = "";
        this.room = "";
        this.students = new ArrayList<>();
    }
    public void addStudent(Student student) {
        students.add(student);
    }


    public void removeStudent(String name) {
        boolean found = false;
        int i = 0;
        while (!found && i < students.size()) {
            if (students.get(i).getName().equals(name)) {
                students.remove(i);
                found = true;
            }
            i++;
        }
    }


    @Override
    public String toString() {
        if (students.isEmpty()) {
            return "Team(" + name + ", " + room + ")";
        }
        return "";
    }

    public String[] activeStudents() {
        int count = 0;
        for (Student student : students) {
            if (student.isActive()) {
                count++;
            }
        }
        String[] activeStudents = new String[count];
        int i = 0;
        for (Student student : students) {
            if (student.isActive()) {
                activeStudents[i] = student.getName();
                i++;
            }
        }
        return activeStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public double averageGradeTeam() {
            double totalSum = 0;
            double totalGradeCount = 0;

            for(Student student : students){
                int[] grades = student.getGrades();
                for(int grade : grades) {
                    totalSum += grade;
                }
                totalGradeCount += grades.length;
            }
            return totalSum / totalGradeCount;
        }

    public Student[] highScoreStudents(double minAverage) {
        int count = 0;
        for (Student student : students) {
            if (minAverage < student.averageGrade() && student.isActive()) {
                count++;
            }
        }
        Student[] goodGuy = new Student[count];
        int index = 0;
        for (Student student : students) {
            if (minAverage < student.averageGrade() && student.isActive()) {
                goodGuy[index] = student;
                index++;
            }
        }
        return goodGuy;
    }
    public int[] correctAnswerCounts(){
        int[] list = new int[students.size()];
        int index = 0;
        for (Student student : students) {
            list[index] = student.correctAnswerCount();
            index++;
        }
        return list;
    }
    public int[] correctQuestionAnswerCounts() {
        int[] correctAnswerList = new int[10];

        for (int i = 0; i < 10; i++) {
            int count = 0;
            for (Student student : students) {
                if (student.getAnswers()[i] == MultipleChoiceTest.getCorrectAnswer()[i]) {
                    count++;
                }

            }
            correctAnswerList[i] = count;

        }
        return correctAnswerList;
    }
    public String[] studentInfos(Student student) {
        String[] info = new String[3];

        info[0] = student.getName();
        info[1] = String.valueOf(student.averageGrade());
        info[2] = String.valueOf(student.correctAnswerCount());

        return info;
    }
}
