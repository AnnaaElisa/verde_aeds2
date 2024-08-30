
public class PalinRecursivo {

    public static boolean ehPalin(String str, int primeiro, int ultimo){
        if(primeiro >= ultimo){
            return true;
        }

        if(str.charAt(primeiro) != str.charAt(ultimo)){
            return false;
        }


        return ehPalin(str, primeiro+1, ultimo-1);

    }
    public static void main (String [] args){

        String str = MyIO.readLine();

        while(!fim(str)){
            boolean palin = ehPalin(str, 0, str.length()-1);

        if(palin){
            MyIO.println("SIM");
        }
        else{
            MyIO.println("NAO");
        }

        str = MyIO.readLine();
        }

    }

    private static boolean fim(String str) {
        if (str.length() != 3) return false;
        return str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M';
    }
}
