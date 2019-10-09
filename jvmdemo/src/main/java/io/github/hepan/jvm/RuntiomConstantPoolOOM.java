package io.github.hepan.jvm;

/**
 * @author hp
 * @Description:TODO
 * @date 2019-06-05 10:46
 */
public class RuntiomConstantPoolOOM {
    public static void main(String[] args) {
        String s = new String("1");

        String s1 = "1";
//        s.intern();
        System.out.println(s == s1);

        String s3 = new StringBuilder("1").append("1").toString();

        String s4 = "11";
        s3.intern();
        System.out.println(s3 == s4);
    }
}
