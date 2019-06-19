import java.util.*;


public class HangMan {
    public static void main(String[] args) {

        Scanner key = new Scanner(System.in);
        String reDo;
        //Generate Word Bank
        ArrayList<String> gameList = new ArrayList<>();
        List<String> wordList = Arrays.asList("tree", "rain", "bear", "encourage", "promise", "soup", "chess", "insurance", "pancakes", "stream");
        gameList.addAll(wordList);


        do {

            //Select Random Word
            Random ranGen = new Random();
            int ran = ranGen.nextInt(10);
            String activeWord = gameList.get(ran);


            //Create Blank Field
            String[] field = new String[activeWord.length()];
            for (int i = 0; i < activeWord.length(); i++) {
                field[i] = ("_");
            }
            char[] test = activeWord.toCharArray();


            //Game Text
            System.out.println(activeWord);
            System.out.println("Lets play Hangman!\n");
            System.out.println("Here is the word im thinking of:\t");
            for (int i = 0; i < activeWord.length(); i++) {
                System.out.print(field[i] + "\t");
            }

            //Guess
            System.out.println("\n\nGuess a letter:");
            char input = key.next().charAt(0);
            int chance = 6;


            //Test
            while (Arrays.asList(field).contains("_") && chance > 0) {

                int fail = 0;
                for (int i = 0, p = 0; i < test.length; i++) {
                    if (test[i] == input) {
                        String test2 = String.valueOf(input);
                        field[i] = test2;
                        p++;
                    }
                    if (i == (test.length - 1) && p == 0) {
                        fail++;
                    }

                }
                if (fail > 0) {

                    chance--;
                    //Endgame
                    if (chance == 0) {
                        System.out.println("Sorry, you ran out of guesses and lost! :(\nThe word was:\t" + activeWord);
                        break;
                    }


                    //Wrong guess
                    System.out.println("\nWrong guess, please try again (" + chance + " guesses remaining.)");
                    for (int i = 0; i < activeWord.length(); i++) {
                        System.out.print(field[i] + "\t");
                    }
                    if (chance > 0) {
                        System.out.println("\nGuess a letter:");
                        input = key.next().charAt(0);
                    }


                    //Win condition
                } else if (!Arrays.asList(field).contains("_")) {
                    System.out.println("\nCongragulations! You Won!\nThe word was " + activeWord + ".");
                    break;


                    //correct guess
                } else {
                    System.out.println("\nGood Guess!");

                    for (int i = 0; i < activeWord.length(); i++) {
                        System.out.print(field[i] + "\t");
                    }
                    System.out.println("\nGuess Again:");
                    input = key.next().charAt(0);


                }
            }
            //Replay
            System.out.println("\n\nWould you like to play again? (Yes/No)");
            key.nextLine();
            reDo = key.nextLine();
        } while (reDo.equalsIgnoreCase("yes"));
        System.out.println("Goodbye");


    }
}
