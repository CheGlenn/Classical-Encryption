public class VigenereCipher{
  public static void main(String[] args) throws Exception{
    encode();

  }

  public static void createKey(){
    int base = 97;
    String word = "yetanothertest"; //word for encoding
    String keyword = "test"; //keyword for encoding
    char[] keywordChar = keyword.toCharArray(); //make char array for key word
    char[] key; //empty char array for final key
    key = new char[word.length()]; //set lenght of key to length of word
    int j = 0; //counter var

      for(int i = 0; i < word.length(); i++){ //loop through word
        key[i] = keywordChar[j]; //set index i in key to index j in keyword
        j++; //incrament counter

        if(j>=keyword.length()){ //check if j is greater than or equal to the length of keyword
          j = 0; //reset counter to 0
        }//if
      }//for
      String finalKey = new String(key);
    }
    //encode
  public static void encode(){
    char[] newWord;
    newWord = new char[word.length()];
    for (int i = 0; i < word.length(); i++){
      char letter = word.charAt(i); //saves char at String(i)
      char n = finalKey.charAt(i); //saves char at String(i)
      // System.out.println(letter);
      // System.out.println(n);
      int result = ((int) letter - base ) + ((int) n - base); //converts letter to corresponding int and calculates new value
      result = (result % 25); //loop around to start of character range
      newWord[i] = (char) (result + base);
      //converts result to corresponding charS and calculates new value

  } //for

      System.out.println(new String(newWord));
  }


  public static void decode(){

  }
}