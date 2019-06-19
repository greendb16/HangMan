import java.util.*;


public class HangMan {
    public static void main(String[]args){

        //Generate Word Bank
        ArrayList<String> gameList = new ArrayList<>();
        List<String> wordList = Arrays.asList("tree", "rain", "bear", "encourage", "promise", "soup", "chess", "insurance","pancakes","stream");
        gameList.addAll(wordList);

        //Select Random Word
        Random ranGen = new Random();
        int ran = ranGen.nextInt(10)-1;
        String activeWord = gameList.get(ran);

        //Create Blank Field
        ArrayList<String> field = new ArrayList<>();
        for (int i =0; i<activeWord.length(); i++){
            field.add(i, "_");
        }



        System.out.println(activeWord);
        System.out.println("Lets play Hangman!");
        System.out.println("Here is the word im thinking of:\t");
        for( int i =0; i< activeWord.length(); i++){
            System.out.print(field.get(i) + "\t");
        }
    }



    }


