/*Crie um método iterativo que recebe uma string e retorna true se a mesma é composta somente por vogais. Crie outro método iterativo que recebe 
uma string e retorna true se a mesma é composta somente por consoantes. Crie um terceiro método iterativo que recebe uma string e retorna true 
se a mesma corresponde a um número inteiro. Crie um quarto método iterativo que recebe uma string e retorna true se a mesma corresponde a um 
número real. Na saída padrão, para cada linha de entrada, escreva outra de saída da seguinte forma X1 X2 X3 X4 onde cada X$i$ é um booleano 
indicando se a é entrada é: composta somente por vogais (X1); composta somente somente por consoantes (X2); um número inteiro (X3); um número 
real (X4). Se X$i$ for verdadeiro, seu valor será SIM , caso contrário, NÃO. */

public class Is{

    public static boolean ehVogal(String string){

        for(int i = 0; i < string.length(); i++){
            char c = string.charAt(i);
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
                return false; //nao e letra
            }
            if(c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' &&
                c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U'){
                return false;
            }
        }
        return true;
    }

    public static boolean ehCons(String string){
        
        for(int i = 0; i < string.length(); i++){
            char c = string.charAt(i);
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
                return false; 
            }
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
            c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
                return false;
            }
        }

        return true;
    }

    public static boolean ehInt(String string){

        for(int i = 0; i <string.length(); i++){
            char c = string.charAt(i);
            if((c < 0 || c > 9 || c == '.')){
                return false;
            }
        }

        return true;
    }

    public static boolean ehFloat(String string){

        
        for(int i = 0; i < string.length(); i++){
            char c = string.charAt(i);
            if(c != '.'){
                return false;
            }
            if(c < 0 || c>9){
                return false;
            }
        }
        
        return true;
    }

    public static void verificar(boolean v, boolean c, boolean ni, boolean nf){
        if(v == true){
            MyIO.print("SIM ");
        }
        else{
            MyIO.print("NAO ");
        }
        if(c == true){
            MyIO.print("SIM ");
        }
        else{
            MyIO.print("NAO ");
        }
        if(ni == true){
            MyIO.print("SIM ");
        }
        else{
            MyIO.print("NAO ");
        }
        if(nf == true){
            MyIO.print("SIM");
        }
        else{
            MyIO.print("NAO");
        }

        MyIO.print("\n");
        
    }

    public static void main (String [] args){

        MyIO.setCharset("UTF-8");

        String str = MyIO.readLine();

            while (!str.equals("FIM")) {
                boolean vogal = ehVogal(str);
                boolean cons = ehCons(str);
                boolean numInt = ehInt(str);
                boolean numF = ehFloat(str);

                verificar( vogal, cons, numInt, numF);

                str = MyIO.readLine();
            }
    }
}
