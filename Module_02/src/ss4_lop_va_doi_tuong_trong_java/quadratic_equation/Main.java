package ss4_lop_va_doi_tuong_trong_java.quadratic_equation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập giá trị a");
        int a = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập giá trị b");
        int b = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập giá trị c");
        int c = Integer.parseInt(scanner.nextLine());
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        double delta = quadraticEquation.getDiscriminant();
        double n1 = quadraticEquation.getRoot1();
        double n2 = quadraticEquation.getRoot2();
        double n3 = quadraticEquation.getRoot3();
        System.out.println(delta);

        if (delta < 0) {
            System.out.println("phương trình vô nghiệm");
        }
        if (delta > 0) {
            System.out.printf("Phương trình có 2 nghiệm phân  biệc: Nghiệm x1= %f,nghiệm x2= %f ", n1, n2);
        }
        if (delta == 0) {
            System.out.printf("Phương trình có nghiệm kép: Nghiệm x1=x2=%f ", n3);
        }

    }
}
