public class CaesarCipher {
  public static void main(String[] args) throws Exception {
    if(args.length != 2){ //checks num of arguments in command line
      System.err.println("Incorrect number of parameters"); //throws error and exits if wrong num of args
      System.exit(2);
             
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
  }//main

    public static void encode(String s) {
      
      int base = 97; //base to get a-z 0-25 

        for (int key = 0; key < 26; key++){//incraments key and prints every possible encode version
          char[] word = s.toCharArray(); //word for encoding 
          for (int i = 0; i < s.length(); i++){


            char letter = word[i]; //saves char at i
            char result = (char) ((letter - base ) + key); //converts letter to corresponding int and calculates new value
            result = (char) (result % 26); //loop around to start of character range
            result = (char) (result + base); //converts result to corresponding char and calculates new value
            word[i] = result; //set index i to new char
          } //for;
          System.out.println("key = " + key + " : " + new String(word));//prints out newly encrypted word
        }//for
    }//encode

    public static void decode(String s) {
      int base = 97; //base to get a-z 0-25

      for (int key = 0; key < 26; key ++ ){//for loop incraments keys and prints each possible decryption
        char[] word = s.toCharArray();
        for (int i = 0; i < s.length(); i++){
          char letter = word[i]; //saves char at i
          int result = (int) (letter - base ) - key; //converts letter to corresponding int and calculates new value
          result = (result % 25); //loop around to start of character range


          if(result < 0){ //checks if the resulting num is negative, if so turns the result into number range (25) + resulting number
            result = 26 + result;
          }
          result = (char) (result + base);  //converts result to corresponding chars and calculates new value
          word[i] = (char) result;
          
        } //for
                // loops through String word 
        System.out.println(new String(word));//prints out newly encrypted word
      }
    }
}