package pl.javastart.task;

import java.util.ArrayList;
import java.util.List;

public class UniversityApp {
    List<Lecturer> tabLecturer = new ArrayList<>();
    private List<Group> tabGroup = new ArrayList<>();
    private List<Students> tabStudents = new ArrayList<>();
    private List<Grade> tabGrade = new ArrayList<>();

    public void createLecturer(int id, String degree, String firstName, String lastName) {
        for (Lecturer lecturer : tabLecturer) {
            if (lecturer.getId() == id) {
                System.out.println("Prowadzący z id " + id + " już istnieje");
                return;
            }
        }
        Lecturer lecturerNext = new Lecturer(id, degree, firstName, lastName);
        tabLecturer.add(lecturerNext);

    }

    public void createGroup(String code, String name, int lecturerId) {
        for (Group group : tabGroup) {
            if (group.getGroupCode().equals(code)) {
                System.out.println("Grupa " + code + " już istnieje");
                return;

            }
        }
        Lecturer lecturer = null;
        for (Lecturer lecturer1 : tabLecturer) {
            if ((lecturer1.getId() == lecturerId)) {
                lecturer = lecturer1;
                break;
            }
            if (lecturer == null) {
                System.out.println("Prowadzący o id " + lecturerId + " nie istnieje");
            }
        }
        Group groupNext = new Group(code, name, lecturerId);
        tabGroup.add(groupNext);
    }


    /**
     * Dodaje studenta do grupy zajęciowej.
     * W przypadku gdy grupa zajęciowa nie istnieje wyświetlany jest komunikat:
     * "Grupa [kod grupy] nie istnieje
     *
     * @param index     - unikalny numer indeksu studenta
     * @param groupCode - kod grupy utworzonej wcześniej za pomocą {@link #createGroup(String, String, int)}
     * @param firstName - imię studenta
     * @param lastName  - nazwisko studenta
     */
    public void addStudentToGroup(int index, String groupCode, String firstName, String lastName) {
        Group group = null;
        for (Students tabStudent : tabStudents) {
            if (tabStudent.getIndex() == index) {
                System.out.println("Student o indeksie " + index + " jest już w grupie " + groupCode);
                return;
            }
        }
        for (Group group1 : tabGroup) {
            if (group1.getGroupCode().equals(groupCode)) {
                group = group1;
                break;
            }
        }
        if (group == null) {
            System.out.println("Grupa " + groupCode + " nie istnieje");
            return;
        }
        Students students = new Students(index, groupCode, firstName, lastName);
        tabStudents.add(students);
    }


    /**
     * Wyświetla informacje o grupie w zadanym formacie.
     * Oczekiwany format:
     * Kod: [kod_grupy]
     * Nazwa: [nazwa przedmiotu]
     * Prowadzący: [stopień naukowy] [imię] [nazwisko]
     * Uczestnicy:
     * [nr indeksu] [imie] [nazwisko]
     * [nr indeksu] [imie] [nazwisko]
     * [nr indeksu] [imie] [nazwisko]
     * W przypadku gdy grupa nie istnieje, wyświetlany jest komunikat w postaci: "Grupa [kod] nie znaleziona"
     *
     * @param groupCode - kod grupy, dla której wyświetlić informacje
     */
    public void printGroupInfo(String groupCode) {
        Group group1 = null;
        for (Group group : tabGroup) {
            if (group.getGroupCode().equals(groupCode)) {
                group1 = group;
                break;
            }
        }
        if (group1 == null) {
            System.out.println("Grupa " + groupCode + " nie znaleziona");
            return;
        }

        System.out.println("Kod: " + groupCode);
        System.out.println("Nazwa: " + group1.getName());
        for (Lecturer lecturer : tabLecturer) {
            if (group1.getLecturerId() == lecturer.getId()) {
                System.out.println("Prowadzący: " + lecturer.getDegree() + " " + lecturer.getFistName() + " " + lecturer.getLastName());
            }
        }
        System.out.println("Uczestnicy");
        for (Students tabStudent : tabStudents) {
            if (tabStudent.getGroupCode().equals(groupCode)) {
                System.out.println(tabStudent.getIndex() + " " + tabStudent.getFirstName() + " " + tabStudent.getLastName());
            }
        }
    }


    /**
     * Dodaje ocenę końcową dla wskazanego studenta i grupy.
     * Student musi być wcześniej zapisany do grupy za pomocą {@link #addStudentToGroup(int, String, String, String)}
     * W przypadku, gdy grupa o wskazanym kodzie nie istnieje, wyświetlany jest komunikat postaci:
     * "Grupa pp-2022 nie istnieje"
     * W przypadku gdy student nie jest zapisany do grupy, wyświetlany jest komunikat w
     * postaci: "Student o indeksie 179128 nie jest zapisany do grupy pp-2022"
     * W przypadku gdy ocena końcowa już istnieje, wyświetlany jest komunikat w postaci:
     * "Student o indeksie 179128 ma już wystawioną ocenę dla grupy pp-2022"
     */
    public void addGrade(int studentIndex, String groupCode, double grade) {
        Group group1 = null;
        for (Group group : tabGroup) {
            if (group.getGroupCode().equals(groupCode)) {
                group1 = group;
                break;
            }
        }
        if (group1 == null) {
            System.out.println("Grupa " + groupCode + " nie istnieje");
            return;
        }
        Students students = null;
        for (Students tabStudent : tabStudents) {
            if (tabStudent.getIndex() == studentIndex) {
                students = tabStudent;
                break;
            }
        }
        if (students == null) {
            System.out.println("Student o indeksie " + studentIndex + " nie jest zapisany do grupy " + groupCode);
            return;
        }
        for (Grade grade1 : tabGrade) {
            if (grade1.getStudentIndex() == studentIndex && grade1.getGroupCode().equals(groupCode)) {
                System.out.println("Student o indeksie " + studentIndex + " ma już wystawioną ocenę dla grupy " + groupCode);
            }
        }
        Grade grade2 = new Grade(studentIndex, groupCode, grade);
        tabGrade.add(grade2);
    }

    /**
     * Wyświetla wszystkie oceny studenta.
     * Przykładowy wydruk:
     * Podstawy programowania: 5.0
     * Programowanie obiektowe: 5.5
     *
     * @param index - numer indesku studenta dla którego wyświetlić oceny
     */
    public void printGradesForStudent(int index) {
        for (Grade grade : tabGrade) {
            if (grade.getStudentIndex() == index) {
                for (Group group : tabGroup) {
                    if (group.getGroupCode().equals(grade.getGroupCode())){
                        System.out.println(group.getName() + ":" + " " + grade.getGrade());
                }
            }
        }
        }
    }


    /**
     * Wyświetla oceny studentów dla wskazanej grupy.
     * Przykładowy wydruk:
     * 179128 Marcin Abacki: 5.0
     * 179234 Dawid Donald: 4.5
     * 189521 Anna Kowalska: 5.5
     *
     * @param groupCode - kod grupy, dla której wyświetlić oceny
     */
    public void printGradesForGroup(String groupCode) {
        Group group1 = null;
        for (Group group : tabGroup) {
            if (group.getGroupCode().equals(groupCode)) {
                group1 = group;
                break;
            }
        }
        if (group1 == null) {
            System.out.println("Grupa " + groupCode + " nie istnieje");
            return;
        }
        for (Students tabStudent : tabStudents) {
            for (Grade grade : tabGrade) {
                if (grade.getStudentIndex() == tabStudent.getIndex()) {
                    System.out.println(tabStudent.getIndex() + " " + tabStudent.getFirstName() + " " + tabStudent.getLastName() + ":" + " " + grade.getGrade());
                }
            }
        }
    }


    /**
     * Wyświetla wszystkich studentów. Każdy student powinien zostać wyświetlony tylko raz.
     * Każdy student drukowany jest w nowej linii w formacie [nr_indesku] [imie] [nazwisko]
     * Przykładowy wydruk:
     * 179128 Marcin Abacki
     * 179234 Dawid Donald
     * 189521 Anna Kowalska
     */
    public void printAllStudents() {
        System.out.println("Wszyscy studenci:");

        for (Students tabStudent : tabStudents) {
            System.out.println(tabStudent.getIndex() + " " + tabStudent.getFirstName() + " " + tabStudent.getLastName());
        }
    }
}

