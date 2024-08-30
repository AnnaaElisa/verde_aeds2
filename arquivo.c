#include <stdio.h>
#include <stdlib.h>

int temDuasCasasDecimais(double valor) {
    // Multiplica o valor por 100 para deslocar as duas primeiras casas decimais para a parte inteira
    int parteInteira = (int)(valor * 100);
    
    // Multiplica novamente por 10 para verificar a terceira casa decimal
    double testeTerceiraCasa = valor * 1000;

    // Se ao subtrair a parte inteira de "testeTerceiraCasa" e o resultado for zero, tem exatamente duas casas decimais
    return ((int)testeTerceiraCasa - parteInteira * 10) == 0;
}

int main() {
    int n;
    double valor;
    FILE *file;

    // Lê o número de valores a serem lidos
    printf("Digite a quantidade de valores reais: ");
    scanf("%d", &n);

    // Abre o arquivo para escrita ("wb" - write binary)
    file = fopen("valores.bin", "wb");
    if (file == NULL) {
        perror("Erro ao abrir o arquivo para escrita");
        return 1;
    }

    // Lê e grava os valores reais no arquivo
    for (int i = 0; i < n; i++) {
        scanf("%lf", &valor);
        fwrite(&valor, sizeof(double), 1, file);
    }

    // Fecha o arquivo após a escrita
    fclose(file);

    // Reabre o arquivo para leitura ("rb" - read binary)
    file = fopen("valores.bin", "rb");
    if (file == NULL) {
        perror("Erro ao abrir o arquivo para leitura");
        return 1;
    }

    // Calcula o tamanho de um double em bytes
    long tamanhoDouble = sizeof(double);

    // Move o ponteiro de leitura para o final do arquivo
    fseek(file, 0, SEEK_END);

    // Lê os valores de trás para frente e imprime na tela
    for (int i = 1; i <= n; i++) {
        // Posiciona o ponteiro de leitura no início do i-ésimo double a partir do fim
        fseek(file, -i * tamanhoDouble, SEEK_END);

        // Lê o valor e imprime na tela com a formatação adequada
        fread(&valor, sizeof(double), 1, file);

        // Verifica se o valor é um número inteiro ou um valor decimal
        if (valor == (int)valor) {
            printf("%.0f\n", valor);  // Imprime sem casas decimais se for inteiro
        } else if(temDuasCasasDecimais(valor)){
            printf("%.1f\n", valor); 
        }
        else {
            printf("%.3f\n", valor);  // Imprime com três casas decimais
        }
    }

    // Fecha o arquivo após a leitura
    fclose(file);

    return 0;
}