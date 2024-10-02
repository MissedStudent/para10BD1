import java.sql.*;
public class DB{
    public static String url ="jdbc:mysql://localhost/college";
    public static String user = "root";
    public static String password ="";
    // открыть соединение
    public Connection openConnection() throws SQLException
    {
        return DriverManager.getConnection(url, user, password);
    }
    //закрыть соединение
    public void closeConnection(Connection connection)
    {
        if (connection!=null)
        {
            try
            {
                connection.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
    public void findStudent(String surname)
    {
        Connection connection = null;
        try {
            connection = openConnection();
            String query = "SELECT students.student_surname, students.student_name, groups.group_name " +
                    "FROM `students`, `groups` " +
                    "WHERE groups.id_group=students.student_group_id AND students.student_surname=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,surname);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                String surnam = resultSet.getString("student_surname");
                String nam = resultSet.getString("student_name");
                String group_name = resultSet.getString("group_name");
                System.out.println(surnam + " "+nam+" "+group_name);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection);
        }
    }
    public void gradeStudent(String surname)
    {
        Connection connection = null;
        try {
            connection = openConnection();
            String query = "SELECT students.student_surname, students.student_name, students.student_lastname, grades.grades FROM " +
                    "`students`,`grades` WHERE students.student_surname=? AND students.id_student=grades.grades_id_students";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,surname);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                String surnam = resultSet.getString("student_surname");
                String nam = resultSet.getString("student_name");
                String lastname = resultSet.getString("student_lastname");
                String grades = resultSet.getString("grades");
                System.out.println(surnam + " "+nam+" "+ lastname+" "+grades);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection);
        }
    }
    public void zachetStudent(String surname)
    {//препод + время
        Connection connection = null;
        try {
            connection = openConnection();
            String query = "SELECT teacher.teacher_surname, teacher.teacher_name, teacher.teacher_lastname, discipline.discipline_name, grades.grades, record.data FROM `students`,`groups`,`teacher`,`discipline`,`grades`,`record` WHERE students.student_surname=? AND students.id_student=grades.grades_id_students AND groups.id_group=students.student_group_id AND discipline.id_discipline=grades.grades_id_discipline AND discipline.discipline_id_teacher=teacher.id_teacher AND grades.id_grades=record.id_grades";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,surname);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                String Tsur = resultSet.getString("teacher_surname");
                String Tnm = resultSet.getString("teacher_name");
                String Tlt = resultSet.getString("teacher_lastname");
                String discipline = resultSet.getString("discipline_name");
                String grades = resultSet.getString("grades");
                String data = resultSet.getString("data");
                System.out.println(Tsur+" "+Tnm+" "+Tlt+" "+discipline+" "+grades+" "+data);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection);
        }
    }
    public void disciplineTeacher(String surname)
    {
        Connection connection = null;
        try {
            connection = openConnection();
            String query = "SELECT teacher.teacher_surname, teacher.teacher_name, teacher.teacher_lastname, discipline.discipline_name FROM `teacher`,`discipline` WHERE " +
                    "teacher.teacher_surname=? AND teacher.id_teacher=discipline.discipline_id_teacher";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,surname);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                String surnam = resultSet.getString("teacher_surname");
                String nam = resultSet.getString("teacher_name");
                String lastname = resultSet.getString("teacher_lastname");
                String discipline = resultSet.getString("discipline_name");
                System.out.println(surnam + " "+nam+" "+ lastname+" "+discipline);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection);
        }
    }
    public void disciplineGradeTeacher(String surname)
    {
        Connection connection = null;
        try {
            connection = openConnection();
            String query = "SELECT teacher.teacher_surname, teacher.teacher_name, teacher.teacher_lastname, discipline.discipline_name, grades.grades FROM `teacher`,`discipline`,`grades`" +
                    " WHERE teacher.teacher_surname=? AND teacher.id_teacher=discipline.discipline_id_teacher AND grades.grades_id_discipline=discipline.id_discipline";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,surname);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                String surnam = resultSet.getString("teacher_surname");
                String nam = resultSet.getString("teacher_name");
                String lastname = resultSet.getString("teacher_lastname");
                String discipline = resultSet.getString("discipline_name");
                String grade = resultSet.getString("grades");
                System.out.println(surnam + " "+nam+" "+ lastname+" "+discipline+" "+grade);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection);
        }
    }
}