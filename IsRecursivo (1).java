public class IsRecursivo {

    public static boolean ehVogal(String string, int i) {
        if (i >= string.length()) {
            return true;
        }

        char c = string.charAt(i);
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
            return false; 
        }
        if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' &&
            c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
            return false;
        }

        return ehVogal(string, i + 1);
    }

    public static boolean ehCons(String string, int i) {
        if (i >= string.length()) {
            return true;
        }

        char c = string.charAt(i);
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
            return false; 
        }
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
            c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return false;
        }

        return ehCons(string, i + 1);
    }

    public static boolean ehInt(String string, int i) {
        if (i >= string.length()) {
            return true;
        }

        char c = string.charAt(i);
        if (c < '0' || c > '9') {
            return false;
        }

        return ehInt(string, i + 1);
    }

    public static boolean ehFloat(String string, int i) {
        if (i >= string.length()) {
            return true; 
        }

        char c = string.charAt(i);
        if (c != '.') {
                return false; //nao pode ter dois ponto
            }
        if (c < '0' || c > '9') {
            return false;
        }

        return ehFloat(string, i + 1);
    }

    
    public static void verificar(boolean v, boolean c, boolean ni, boolean nf) {
        MyIO.print(v ? "SIM " : "NAO ");
        MyIO.print(c ? "SIM " : "NAO ");
        MyIO.print(ni ? "SIM " : "NAO ");
        MyIO.print(nf ? "SIM " : "NAO ");
        MyIO.println("");
    }

    public static void entrada() {
        String str = MyIO.readLine();

        if (!str.equals("FIM")) {
            boolean vogal = ehVogal(str, 0);
            boolean cons = ehCons(str, 0);
            boolean numInt = ehInt(str, 0);
            boolean numF = ehFloat(str, 0);

            verificar(vogal, cons, numInt, numF);

            entrada(); 
        }
    }

    public static void main(String[] args) {
        MyIO.setCharset("UTF-8");
        entrada();
    }
}
