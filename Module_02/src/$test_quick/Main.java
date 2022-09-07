package $test_quick;

public class Main {
    class MyClass1 {
        public void method1() {
            System.out.println(1);
        }

        private void method2() {
            System.out.println(2);
        }

        void method3() {
            System.out.println(3);
        }
    }

    class MyClass2 {
        void method() {
            MyClass1 o1 = new MyClass1();
            o1.method1();
            o1.method2();
            o1.method3();
        }
    }
}
