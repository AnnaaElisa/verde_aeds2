#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

bool ehPalin(char str []){

    int tam = strlen(str);

    if(tam <= 1){
        return true;
    }
    
    char primeiro = str[0];
    char ultimo = str[tam-1];

    if(primeiro != ultimo){
        return false;
    }

    char result[tam-1];

    for(int i = 0;i< tam - 1; i++){
        result[i-1] = str[i];
    }

    result[tam-2] = '\0';

    return ehPalin(result);

}

void entrada(){
    char str[100];

        fgets(str, sizeof(str), stdin);
        str[strcspn(str, "\n")] = '\0'; 

        if (strcmp(str, "FIM") != 0) {
            bool p = ehPalin(str);
            if(p == true){
                printf("SIM\n");
            }
            else{
                printf("NAO\n");
            }
            entrada();
        }
}
int main (){
    
    entrada();

    return 0;

}