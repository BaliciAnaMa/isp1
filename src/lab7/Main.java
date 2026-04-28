package lab7;

import lab7.forms.Circle;
import lab7.forms.Form;
import lab7.forms.Square;
import lab7.forms.Triangle;
import lab7.util.PasswordMaker;
import lab7.studentii.Student;

import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // 7.6.1. Contor instante
        Triangle tri = new Triangle(1.1F, 2.0F, "red");
        Circle c = new Circle(1.5F, "yellow");
        Square sq = new Square(1.2F, "blue");
        System.out.println("Area = " + tri.getArea()+" details: " + tri);
        System.out.println("Area = " + c.getArea() + " details: " + c);
        System.out.println("Area = " + sq.getArea() + " details: " + sq);
       System.out.println("Total instance count is " + Form.getInstanceCount());

       //7.6.2
        PasswordMaker pm2 = PasswordMaker.getInstance();
        System.out.println("\n7.6.2 a+b) Generated passwords: ");
        System.out.println("1:" + PasswordMaker.getInstance().getPassword());
        System.out.println("2:" + PasswordMaker.getInstance().getPassword());
        System.out.println("3:" + PasswordMaker.getInstance().getPassword());
        System.out.println("4:" + pm2.getPassword());
        System.out.println("5:" + pm2.getPassword());
        System.out.println("\n7.6.2 c) Number of time getInstance() has been called: " + PasswordMaker.getCallingCounts());

        //7.6.3
        Set<Student> studenti = new LinkedHashSet<>();
        studenti.add(new Student("Pop", "Ana", "001", "TI 211",9));
        studenti.add(new Student("Ion", "Maria", "002", "TI 211",8));
        studenti.add(new Student("Dan", "Alex", "003", "TI 211",7));
        studenti.add(new Student("Popa", "Ion", "004", "TI 211",10));
        studenti.add(new Student("Rus", "Ioana", "005", "TI 211",5));

        System.out.println("Studenti inainte de impartire:");
        for (Student st : studenti) {
            System.out.println(st);
        }

        studenti = imparteInDouaFormatii(studenti, "TI 211_1", "TI 211_2");

        System.out.println(" Studenti dupa impartire:");
        for (Student st : studenti) {
            System.out.println(st);
        }
    }
    static Student schimbaFormatia(Student st, String nouaFormatieDeStudiu) {
        return new Student(
                st.getNume(),
                st.getPrenume(),
                st.getNrMatricol(),
                nouaFormatieDeStudiu,
                st.getNota()
        );
    }
    static Set<Student> imparteInDouaFormatii(Set<Student> studenti, String formatia1, String formatia2) {
        Set<Student> rezultat = new LinkedHashSet<>();

        int total = studenti.size();
        int jumatate = total / 2;
        int dimFormatia1;
        if (total % 2 == 0) {
            dimFormatia1 = jumatate;
        } else {
            dimFormatia1 = jumatate + 1;
        }
        int index = 0;
        for (Student st : studenti) {
            if (index < dimFormatia1) {
                rezultat.add(schimbaFormatia(st, formatia1));
            } else {
                rezultat.add(schimbaFormatia(st, formatia2));
            }
            index++;
        }
        return rezultat;
    }
    }

