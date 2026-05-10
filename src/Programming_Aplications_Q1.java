public class Programming_Aplications_Q1 {

    public static void main(String[] args) {

    }




    public static int validSquare(char inputCharacter){

        if(inputCharacter.isEmpty || !Character.isLetter(inputCharacter)){
            return 1;
        }

        if (inputCharacter == Character.toUpperCase(inputCharacter)){
            return 0;
        }
        else{
            return 1;
        }
    }
}
