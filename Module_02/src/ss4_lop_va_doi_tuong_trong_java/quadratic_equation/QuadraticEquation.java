package ss4_lop_va_doi_tuong_trong_java.quadratic_equation;

import javax.security.auth.login.CredentialNotFoundException;

public class QuadraticEquation {
    int a;
    int b;
    int c;

    public QuadraticEquation() {
    }

    public QuadraticEquation(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }


    public double getDiscriminant() {
        return this.b * this.b - 4 * this.a * this.c;
    }

    public double getRoot1() {
        return (-this.b + Math.sqrt(this.b * this.b - 4 * this.a * this.c)) / (2 * this.a);
    }

    public double getRoot2() {
        return (-this.b - Math.sqrt(this.b * this.b - 4 * this.a * this.c)) / (2 * this.a);
    }

    public double getRoot3() {
        return ((-this.b) / (2 * this.a));
    }


}
