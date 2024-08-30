/*Crie um método iterativo que recebe uma string, sorteia duas letras minúsculas aleatórias (código ASCII > 'a' e < 'z'), substitui todas as 
ocorrências da primeira letra na string pela segunda e retorna a string com as alterações efetuadas. Na saída padrão, para cada linha de 
entrada, execute o método desenvolvido nesta questão e mostre a string retornada como uma linha de saída. Abaixo, observamos um exemplo de 
entrada supondo que para a primeira linha as letras sorteados foram o 'a' e o 'q'. Para a segunda linha, foram o 'e' e o 'k'.

A classe Random do Java gera números (ou letras) aleatórios e o exemplo abaixo mostra uma letra minúscula na tela. Em especial, destacamos que: 
i) \textit{seed} é a semente para geração de números aleatórios; ii) nesta questão, por causa da correção automática, a \textit{seed} será 
quatro; iii) a disciplina de Estatística e Probabilidade faz uma discussão sobre ``aleatório''.

Random gerador = new Random();
gerador.setSeed(4);
System.out.println((char)('a' + (Math.abs(gerador.nextInt()) % 26))); */

import java.util.Random;

public class Alteracao {

    public static String substituirLetras(String str, char letra1, char letra2) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == letra1) {
                result += letra2;
            } else {
                result += c;
            }
        }

        return result;
    }

    public static void main (String [] args){

        Random rand = new Random();
        rand.setSeed(4);

        String str = MyIO.readLine();

        while(!str.equals("FIM")){
        char letra1 = (char) ('a' +(Math.abs(rand.nextInt()) % 26));
        char letra2 = (char) ('a' + (Math.abs(rand.nextInt())%26));

        String result = substituirLetras(str, letra1, letra2);

            MyIO.println(result);

            str = MyIO.readLine();
        }

        

    }
    
}
