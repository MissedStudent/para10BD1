import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Main {
    public static DB db = new DB();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Выберите один из вариантов:
                1. поиск студента по фамилии
                2. запрос по фамилии студента, какие у него оценки
                3. вывести зачетку полностью и БЕЗ ID
                4. запрос по фамилии преподавателя, какие предметы у него
                5. запрос по фамилии преподавателя, каким выставил оценки и по каким предметам
                """);
        int swtch = scanner.nextInt();
        switch (swtch) {
            case 1: {//1. поиск студента по фамилии
                System.out.println("Введите фамилию студента:");
                String fam = scanner.next();
                db.findStudent(fam);
            }
            break;
            case 2: {//2. запрос по фамилии студента, какие у него оценки
                System.out.println("Введите фамилию студента:");
                String fam = scanner.next();
                db.gradeStudent(fam);
            }
            break;
            case 3:{//3. вывести зачетку полностью и БЕЗ ID
                System.out.println("Введите фамилию студента:");
                String fam = scanner.next();
                db.zachetStudent(fam);
            }break;
            case 4: {//4. запрос по фамилии преподавателя, какие предметы у него
                System.out.println("Введите фамилию преподавателя:");
                String fam = scanner.next();
                db.disciplineTeacher(fam);
            }
            break;
            case 5: {//5. запрос по фамилии преподавателя, каким выставил оценки и по каким предметам
                System.out.println("Введите фамилию преподавателя:");
                String fam = scanner.next();
                db.disciplineGradeTeacher(fam);
            }
            break;
            default: {
                System.out.println("Значение выходит за предусмотренные рамки");
            }
            break;
        }
    }
}