public class AvaliadorBooleano {

    public static void main(String[] args) {
        String entrada = MyIO.readLine();

        while (!entrada.equals("0")) {
            boolean resultado = avaliarExpressao(entrada);
            MyIO.println(resultado ? "1" : "0");

            entrada = MyIO.readLine();
        }
    }

    public static boolean avaliarExpressao(String entrada) {
        int i = 0;

        // Pular o primeiro número (n) e os valores binários
        while (entrada.charAt(i) != ' ') i++;
        i++; // Pular o espaço após n

        int valoresBinariosIndex = 0;
        int[] valoresBinarios = new int[3]; // Suporte para até 3 variáveis booleanas A, B e C

        while (entrada.charAt(i) == '0' || entrada.charAt(i) == '1') {
            valoresBinarios[valoresBinariosIndex++] = entrada.charAt(i) - '0';
            i++;
            if (i < entrada.length() && entrada.charAt(i) == ' ') i++;
        }

        // Avaliar a expressão booleana
        return avaliar(entrada, valoresBinarios, i);
    }

    public static boolean avaliar(String entrada, int[] valoresBinarios, int i) {
        while (i < entrada.length()) {
            if (entrada.charAt(i) == 'n' && entrada.charAt(i + 1) == 'o' && entrada.charAt(i + 2) == 't') {
                i += 4; // Pular "not("
                boolean result = !avaliar(entrada, valoresBinarios, i);
                while (i < entrada.length() && entrada.charAt(i) != ')') i++;
                i++; // Pular ')'
                return result;
            } else if (entrada.charAt(i) == 'a' && entrada.charAt(i + 1) == 'n' && entrada.charAt(i + 2) == 'd') {
                i += 4; // Pular "and("
                boolean result = avaliar(entrada, valoresBinarios, i);
                while (i < entrada.length() && entrada.charAt(i) != ',') i++;
                i += 2; // Pular ", "
                result = result && avaliar(entrada, valoresBinarios, i);
                while (i < entrada.length() && entrada.charAt(i) != ')') i++;
                i++; // Pular ')'
                return result;
            } else if (entrada.charAt(i) == 'o' && entrada.charAt(i + 1) == 'r') {
                i += 3; // Pular "or("
                boolean result = avaliar(entrada, valoresBinarios, i);
                while (i < entrada.length() && entrada.charAt(i) != ',') i++;
                i += 2; // Pular ", "
                result = result || avaliar(entrada, valoresBinarios, i);
                while (i < entrada.length() && entrada.charAt(i) != ')') i++;
                i++; // Pular ')'
                return result;
            } else if (entrada.charAt(i) == 'A') {
                i++; // Pular 'A'
                return valoresBinarios[0] == 1;
            } else if (entrada.charAt(i) == 'B') {
                i++; // Pular 'B'
                return valoresBinarios[1] == 1;
            } else if (entrada.charAt(i) == 'C') {
                i++; // Pular 'C'
                return valoresBinarios[2] == 1;
            }
            i++;
        }
        return false; // Caso inesperado
    }
}
