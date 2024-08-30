#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int main (){

    char str[100];

    while (true) {
        
        fgets(str, sizeof(str), stdin);
        str[strcspn(str, "\n")] = '\0'; 

        if (strcmp(str, "FIM") == 0) {
            break;
        }

        int tam = strlen(str);
        bool palin = true;

        for (int i = 0, j = tam - 1; i < j; i++, j--) {
            if (str[i] != str[j]) {
                palin = false;
            }
        }

        if (palin) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }
    }

    return 0;
}
