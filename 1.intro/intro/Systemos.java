package intro;

import java.util.ArrayList;

public class Systemos {

    public static class out {

        // Primitive datattyper
        //int, long, short, float, double, byte, boolean, char

        public static void println(String s) {
            System.out.println(s);
        }

        public static void println(int i) {
            System.out.println(i);
        }

        public static void println(double d) {
            System.out.println(d);
        }

        public static void println(long l) {
            System.out.println(l);
        }

        public static void println(float f) {
            System.out.println(f);
        }

        public static void println(char c) {
            System.out.println(c);
        }

        public static void println(boolean b) {
            System.out.println(b);
        }

        public static void println(byte b) {
            System.out.println(b);
        }

        public static void println(short s) {
            System.out.println(s);
        }

        public static void println(ArrayList<Object> content) {
            for(int i = 0; i < content.size(); i++) {
                System.out.print(content.get(i) + " ");
            }
        }

        public static void println(Object[] content) {

            for(Object o : content)
            {
                System.out.print(o + " ");
            }
        }

        public static void println(Object o) {
            System.out.println(o);
        }
    }
}
