public class Ciframento{
    public static void main (String [] args){

        String str = MyIO.readLine();

        while (str != null && !str.isEmpty()){
            char [] strChar = str.toCharArray();
            int i = 0;

            for(i=0;i<strChar.length; i++){
                    strChar[i] = (char) (strChar[i] + 3);
            }
        

        String result = new String(strChar);
            
        MyIO.println(result);
            
        str = MyIO.readLine();

        }

    }

        
}