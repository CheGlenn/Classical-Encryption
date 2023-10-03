public class VigenereCipher{
  public static void main(String[] args) throws Exception{
    if(args.length != 3){ //checks num of arguments in command line
      System.err.println("Incorrect number of parameters");
      System.exit(2);
       //throws error and exits if wrong num of args
  } //if
  else{
      if (args[0].equals("encode")){
          encode(args[1], args[2]); //checks if first param is encode then passes in word and key
      } //if 
      else if (args[0].equals("decode")){
          decode(args[1], args[2]); //checks if first param is decode then passes in word and key
      }
      else {
          System.err.println("Invalid parameter"); //throws error otherwise
          System.exit(1);
      }//else
  }//else
}//main

//pre-conditions: String word, String key
//post-conditions: String newKey
//keyCreation creates a new key by repeating the given key and shortening it to the length of the given word
public static String keyCreation(String word, String key){


  String newKey = key.repeat((word.length() / key.length()) + 1);
  // . repeat method repeats the word x amount of times

  newKey = newKey.substring(0, word.length());
  //cuts newKey back down to length of word

  return newKey;

}
  
  //pre-conditions: String s, String k
  //post-conditions: none

  //Encode creates a string from an initial key that is the same size as the plaintext
  //Then uses each corresponding letter from word and new key string to print final ciphertext
  public static void encode(String s, String k){

    if (k.length() < 1){
      System.err.println("Key of length 0 given");
    } else{
    
    int base = 97;
    String word = s; //word for encoding
    String keyWord = k; //keyword for encoding
    char[] newWord;
    newWord = new char[word.length()];
    for (int i = 0; i < word.length(); i++){
      char letter = word.charAt(i); //saves char at String(i)
      char n = keyCreation(word, keyWord).charAt(i); //saves char at String(i)
       
      int result = (int) ( letter - base ) + (n - base); //converts letter to corresponding int and calculates new value
      result = (result % 26); //loop around to start of character range
      newWord[i] = (char) (result + base);
      //converts result to corresponding charS and calculates new value

      }//for
    System.out.println(new String(newWord)); //prints new word
    }
  }//encode

  //pre-conditions: String s, String k
  //post-conditions: none
  //decode creates a String from an initial key that is the same size as the ciphertext
  //Then uses each corresponding letter from ciphertext and new key string to print final plaintext
  public static void decode(String s, String k){
    int base = 97;
    String word = s; //word for encoding
    String keyword = k; //keyword for encoding
    char[] newWord; //initialize array for new encoded word
    newWord = new char[word.length()]; //set length for newWord equal to size of inputted word
    for (int i = 0; i < word.length(); i++){
      char letter = word.charAt(i); //saves char at String(i)
      char n = keyCreation(word, keyword).charAt(i);
      int result = (int) (letter - base ) - (n - base); //converts letter to corresponding int and calculates new value
      result = (result % 26); //loop around to start of character range
      if(result < 0){ //checks if the resulting num is negative, if so turns the result into number range (25) + resulting number
        result = 26 + result;
      }
      newWord[i] = (char) (result + base);
      //converts result to corresponding chars and calculates new value
      } //for
        // loops through String word 
    System.out.println(new String(newWord));//prints out newly encrypted word
  }
}
