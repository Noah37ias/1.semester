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

    public Object getStudents() {
        return students;
    }

    public double averageGradeTeam() {
            int average = 0;
            for(Student student : students){
                average += student.averageGrade();
            }
            return (double) average / students.size();
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

}
