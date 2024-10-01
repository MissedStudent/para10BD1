import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static String url = "jdbc:mysql://localhost/College";
    public static String user = "root";
    public static String password = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Выберите один из вариантов:
                1. запрос по фамилии студента, какие у него оценки
                2. вывести зачетку полностью и БЕЗ ID
                3. запрос по фамилии преподавателя, какие предметы у него
                4. запрос по фамилии преподавателя, каким выставил оценки и по каким предметам
                """);
        int swtch = scanner.nextInt();
        switch (swtch) {
            case 1: {//1. запрос по фамилии студента, какие у него оценки
                System.out.println("Введите фамилию студента:");
                String fam = scanner.next();
                switch (fam) {
                    case "Кузовлев": {
                        StudentsGradeKuz();
                    }
                    break;
                    case "Иванов":{
                        StudentsGradeIvan();
                    }break;
                    case "Александров":{
                        StudentsGradeAleks();
                    }break;
                    default:{System.out.println("Студента с такой фамилией нет в базе данных");}break;
                }
            }
            break;
            case 2: {//2. вывести зачетку полностью и БЕЗ ID
                System.out.println("Введите фамилию студента:");
                String fam=scanner.next();
                switch (fam){
                    case "Кузовлев":{
                        ZachetKuz();
                    }break;
                    case "Иванов":{
                        ZachetIvan();
                    }break;
                    case "Александров":{
                        ZachetAleks();
                    }break;
                    default:{System.out.println("Студента с такой фамилией нет в базе данных");}break;
                }
            }
            break;
            case 3: {//3. запрос по фамилии преподавателя, какие предметы у него
                System.out.println("Введите фамилию преподавателя:");
                String fam=scanner.next();
                switch (fam){
                    case "Иванова":{
                        predmetPrepod();
                    }break;
                    default:{System.out.println("Преподавателя с такой фамилией нет в базе данных");}break;
                }
            }
            break;
            case 4: {//4. запрос по фамилии преподавателя, каким выставил оценки и по каким предметам
                System.out.println("Введите фамилию преподавателя:");
                String fam=scanner.next();
                switch (fam) {
                    case "Иванова": {
                        ocenkiPrepod();
                    }
                    break;
                    default: {
                        System.out.println("Преподавателя с такой фамилией нет в базе данных");
                    }
                    break;
                }
            }
            break;
            default: {
                System.out.println("Значение выходит за предусмотренные рамки");
            }
            break;
        }
    }

    public static void StudentsGradeKuz() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();//SELECT students.student_surname, students.student_name, students.student_lastname, groups.group_name FROM `students`, `groups` WHERE students.student_group_id=groups.id_group;
             ResultSet resultSet = statement.executeQuery("SELECT students.student_surname, grades.grades FROM students, grades WHERE students.student_surname='Кузовлев' AND students.id_student=grades.id_grades")) {
            int columCount = resultSet.getMetaData().getColumnCount();
            for (int i = 1; i <= columCount; i++) {
                System.out.print(resultSet.getMetaData().getColumnName(i) + "\t");
            }
            System.out.println();

            while (resultSet.next()) {
                for (int i = 1; i <= columCount; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void StudentsGradeIvan() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();//SELECT students.student_surname, students.student_name, students.student_lastname, groups.group_name FROM `students`, `groups` WHERE students.student_group_id=groups.id_group;
             ResultSet resultSet = statement.executeQuery("SELECT students.student_surname, grades.grades FROM students, grades WHERE students.student_surname='Иванов' AND students.id_student=grades.id_grades")) {
            int columCount = resultSet.getMetaData().getColumnCount();
            for (int i = 1; i <= columCount; i++) {
                System.out.print(resultSet.getMetaData().getColumnName(i) + "\t");
            }
            System.out.println();

            while (resultSet.next()) {
                for (int i = 1; i <= columCount; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void StudentsGradeAleks() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();//SELECT students.student_surname, students.student_name, students.student_lastname, groups.group_name FROM `students`, `groups` WHERE students.student_group_id=groups.id_group;
             ResultSet resultSet = statement.executeQuery("SELECT students.student_surname, grades.grades FROM students, grades WHERE students.student_surname='Александров' AND students.id_student=grades.id_grades")) {
            int columCount = resultSet.getMetaData().getColumnCount();
            for (int i = 1; i <= columCount; i++) {
                System.out.print(resultSet.getMetaData().getColumnName(i) + "\t");
            }
            System.out.println();

            while (resultSet.next()) {
                for (int i = 1; i <= columCount; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void ZachetKuz() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();//SELECT students.student_surname, students.student_name, students.student_lastname, groups.group_name FROM `students`, `groups` WHERE students.student_group_id=groups.id_group;
             ResultSet resultSet = statement.executeQuery("SELECT groups.group_name, students.student_surname, students.student_name, students.student_lastname, discipline.discipline_name, grades.grades FROM `groups`,`students`,`discipline`,`grades` WHERE students.id_student=1 AND groups.group_name='ИС-22п+' AND grades.id_grades=3")) {
            int columCount = resultSet.getMetaData().getColumnCount();
            for (int i = 1; i <= columCount; i++) {
                System.out.print(resultSet.getMetaData().getColumnName(i) + "\t");
            }
            System.out.println();

            while (resultSet.next()) {
                for (int i = 1; i <= columCount; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void ZachetIvan() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();//SELECT students.student_surname, students.student_name, students.student_lastname, groups.group_name FROM `students`, `groups` WHERE students.student_group_id=groups.id_group;
             ResultSet resultSet = statement.executeQuery("SELECT groups.group_name, students.student_surname, students.student_name, students.student_lastname, discipline.discipline_name, grades.grades FROM `groups`,`students`,`discipline`,`grades` WHERE students.id_student=2 AND groups.group_name='ИС-22п+' AND grades.id_grades=2")) {
            int columCount = resultSet.getMetaData().getColumnCount();
            for (int i = 1; i <= columCount; i++) {
                System.out.print(resultSet.getMetaData().getColumnName(i) + "\t");
            }
            System.out.println();

            while (resultSet.next()) {
                for (int i = 1; i <= columCount; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void ZachetAleks() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();//SELECT students.student_surname, students.student_name, students.student_lastname, groups.group_name FROM `students`, `groups` WHERE students.student_group_id=groups.id_group;
             ResultSet resultSet = statement.executeQuery("SELECT groups.group_name, students.student_surname, students.student_name, students.student_lastname, discipline.discipline_name, grades.grades FROM `groups`,`students`,`discipline`,`grades` WHERE students.id_student=3 AND groups.group_name='ИС-22' AND grades.id_grades=1")) {
            int columCount = resultSet.getMetaData().getColumnCount();
            for (int i = 1; i <= columCount; i++) {
                System.out.print(resultSet.getMetaData().getColumnName(i) + "\t");
            }
            System.out.println();

            while (resultSet.next()) {
                for (int i = 1; i <= columCount; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void predmetPrepod() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();//SELECT students.student_surname, students.student_name, students.student_lastname, groups.group_name FROM `students`, `groups` WHERE students.student_group_id=groups.id_group;
             ResultSet resultSet = statement.executeQuery("SELECT teacher.teacher_surname, teacher.teacher_name, teacher.teacher_lastname, discipline.discipline_name FROM `teacher`,`discipline` WHERE teacher.id_teacher=1")) {
            int columCount = resultSet.getMetaData().getColumnCount();
            for (int i = 1; i <= columCount; i++) {
                System.out.print(resultSet.getMetaData().getColumnName(i) + "\t");
            }
            System.out.println();

            while (resultSet.next()) {
                for (int i = 1; i <= columCount; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void ocenkiPrepod() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();//SELECT students.student_surname, students.student_name, students.student_lastname, groups.group_name FROM `students`, `groups` WHERE students.student_group_id=groups.id_group;
             ResultSet resultSet = statement.executeQuery("SELECT teacher.teacher_surname, teacher.teacher_name, teacher.teacher_lastname, discipline.discipline_name, grades.grades FROM `teacher`,`discipline`,`grades` WHERE teacher.id_teacher=1")) {
            int columCount = resultSet.getMetaData().getColumnCount();
            for (int i = 1; i <= columCount; i++) {
                System.out.print(resultSet.getMetaData().getColumnName(i) + "\t");
            }
            System.out.println();

            while (resultSet.next()) {
                for (int i = 1; i <= columCount; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}