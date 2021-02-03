package ir.ac.kntu;

public class MapConvertor {
    public static final char LF = '\n';
    public static final char CR = '\r';

    public static String chomp(String string) {
        if (isEmpty(string)) {
            return string;
        }

        if (string.length() == 1) {
            char ch = string.charAt(0);
            if (ch == CR || ch == LF) {
                return "";
            }
            return string;
        }

        int lastIdx = string.length() - 1;
        char last = string.charAt(lastIdx);

        if (last == LF) {
            if (string.charAt(lastIdx - 1) == CR) {
                lastIdx--;
            }
        } else if (last != CR) {
            lastIdx++;
        }
        return string.substring(0, lastIdx);
    }
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static char[][] StringTo2D_CharArray(String map, int rows, int cols) {
        String[] components = map.split("\n");
        char[][] chars = new char[components.length + 1][];
        for(int i = 0; i < components.length; i++) {
            String component = components[i];
            chars[i] = component.toCharArray();
        }
        chars[components.length] = new char[] { '\0' };
        return chars;
    }
}
