public class CaesarCipher {
    public static void main(String[] args) throws Exception {
        if(args.length != 2){ //checks num of arguments in command line
            System.err.println("Incorrect number of parameters");
            System.exit(2);
             //throws error and exits if wrong num of args
        } //if
        else{
            if (args[0].equals("encode")){
                encode(args[1]);
            } //if 
            else if (args[0].equals("decode")){
                decode(args[1]);
            }
            else {
                System.err.println("Invalid parameter");
                System.exit(1);
            }//else
        }//else

       // encode("helloworld");
       // decode("ifmmpxpsme");
        
    }//main

    public static void encode(String s) {
        String word = s; //word for encoding
        int base = 97; //base to get a-z 0-25 
        char[] newWord; //initialize array for new encoded word
        newWord = new char[word.length()]; //set length for newWord equal to size of inputted word
        for (int key = 0; key < 25; key ++){//incraments key and prints every possible encode version
            for (int i = 0; i < word.length(); i++){
                char letter = word.charAt(i); //saves char at String(i)
                int result = ((int) letter - base ) + key; //converts letter to corresponding int and calculates new value
                result = (result % 25); //loop around to start of character range
                newWord[i] = (char) (result + base);
                //converts result to corresponding charS and calculates new value

            } //for
            // loops through String word 

           System.out.println(new String(newWord));//prints out newly encrypted word

        }//for

    }//encode

    public static void decode(String s) {
        String word = s; //word for encoding
        int base = 97; //base to get a-z 0-25
        char[] newWord; //initialize array for new encoded word
        newWord = new char[word.length()]; //set length for newWord equal to size of inputted word
        for (int key = 0; key < 26;key ++ ){//for loop incraments keys and prints each possible decryption
            for (int i = 0; i < word.length(); i++){
                char letter = word.charAt(i); //saves char at String(i)
                int result = ((int) letter - base ) - key; //converts letter to corresponding int and calculates new value
                result = (result % 25); //loop around to start of character range
                if(result < 0){ //checks if the resulting num is negative, if so turns the result into number range (25) + resulting number
                    result = 25 + result;
                }
                newWord[i] = (char) (result + base);
                //converts result to corresponding chars and calculates new value
            } //for
                // loops through String word 
           System.out.println(new String(newWord));//prints out newly encrypted word
        }
    }
}
