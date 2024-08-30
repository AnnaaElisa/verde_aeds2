public class Palindromo {

    public static boolean calcular(String str){  //verificar se eh palindromo
        int i, j;
        for(i = 0, j = str.length() - 1; i<str.length(); i++, j--){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
        }

        return true;

    }
    public static void main (String [] args){
        String str = MyIO.readLine();
        while(!fim(str)){
            
        boolean palin = calcular(str);

        if(palin){
            MyIO.println("SIM");
        }
        else{
            MyIO.println("NAO");
        }

        str = MyIO.readLine();
        }
        
    }

    private static boolean fim(String str) { //verificar se a string eh FIM
        if (str.length() != 3) return false;
        return str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M';
    }
}
