import java.io.IOException;
import java.io.RandomAccessFile;

public class Arquivo {
    public static void main(String[] args) {
        try {
            // Lê o número de valores a serem lidos
            int n = MyIO.readInt();

            // Abre o arquivo para escrita
            RandomAccessFile file = new RandomAccessFile("valores.txt", "rw");

            // Lê e grava os valores reais no arquivo
            for (int i = 0; i < n; i++) {
                double valor = MyIO.readDouble();
                file.writeDouble(valor);
            }

            // Fecha o arquivo após a escrita
            file.close();

            // Reabre o arquivo para leitura reversa
            file = new RandomAccessFile("valores.txt", "r");

            // Calcula o tamanho de um double em bytes
            long tamanhoDouble = 8;
            long posicao = file.length() - tamanhoDouble;  // Começa na última posição válida

            // Lê os valores de trás para frente usando um loop while
            while (posicao >= 0) {
                file.seek(posicao);  // Move o ponteiro para a posição correta
                double valor = file.readDouble();

                // Verifica se o valor é um inteiro
                if (valor == (int) valor) {
                    MyIO.println((int) valor);  // Imprime como inteiro
                } else {
                    MyIO.println(valor);  // Imprime como double
                }

                posicao -= tamanhoDouble;  // Move para a posição anterior
            }

            // Fecha o arquivo após a leitura
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
