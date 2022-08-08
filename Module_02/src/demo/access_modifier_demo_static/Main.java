package demo.access_modifier_demo_static;

public class Main {
    public static void main(String[] args) {
        AccessModifier accessModifier=new AccessModifier();
//        accessModifier.radius;  cái này chỉ mới lấy biến từ bên
//                                 accessModifier chưa yêu cầu lệnh
        System.out.println(accessModifier.radius); // này là oke nhé
        //gọi thẳng trực tiếp đến biến vì biến này đang ở status pulic
        System.out.println(accessModifier.getColor());
        System.out.println(accessModifier.getRadius());
    }
}
