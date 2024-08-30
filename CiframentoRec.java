public class CiframentoRec {

    public static String Calculo (String str, int i){
        if (i >=str.length()){
            return "";
        }

        char cifra = (char) (str.charAt(i) + 3);

        return cifra + Calculo(str, i + 1);
    }
    public static void main (String [] args){

        String str = MyIO.readLine();
        while(str != null && !str.isEmpty()){

            String result = Calculo(str, 0);

            MyIO.println(result);

            str= MyIO.readLine();
        }
    }
}
