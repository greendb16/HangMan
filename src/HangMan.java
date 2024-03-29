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

            //turn word into collection of characters
            char[] test = activeWord.toCharArray();


            //Game Text
            System.out.println("\nLets play Hangman!\n");
            System.out.println("Here is the word im thinking of:\t");
            for (int i = 0; i < activeWord.length(); i++) {
                System.out.print(field[i] + "\t");
            }

            //Guess Prompt
            System.out.println("\n\nGuess a letter:");

            //Guess Counter
            int chance = 6;


            //Test
            while (Arrays.asList(field).contains("_") && chance > 0) {

                //input
                String answer = key.nextLine();
                char input = answer.charAt(0);

                //Word Guess Test
                if (answer.equalsIgnoreCase(activeWord)) {
                    for (int i = 0; i < activeWord.length(); i++) {
                        String word = String.valueOf(test[i]);
                        field[i] = word;
                        if (i == (activeWord.length() - 1)) {
                            break;
                        }
                    }
                }

                //Letter Guess Test
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

                //Guess Results
                if (fail > 0) {
                    chance--;

                    //Endgame
                    if (chance == 0) {
                        System.out.println("\nSorry, you ran out of guesses and lost! :(\nThe word was:\t" + activeWord);
                        break;
                    }


                    //Wrong guess
                    System.out.println("\nWrong guess, please try again (" + chance + " guesses remaining.)");
                    for (int i = 0; i < activeWord.length(); i++) {
                        System.out.print(field[i] + "\t");
                    }

                    System.out.println("\nGuess a letter:");

                    //Win condition
                } else if (!Arrays.asList(field).contains("_")) {
                    System.out.println("\nCongragulations! You Won!\nThe word was " + activeWord + ".");
                    break;


                    //Correct guess
                } else {
                    System.out.println("\nGood Guess!");

                    for (int i = 0; i < activeWord.length(); i++) {
                        System.out.print(field[i] + "\t");
                    }
                    System.out.println("\nGuess Again:");
                }
            }

            //Replay
            System.out.println("\n\nWould you like to play again? (Yes/No)");
            reDo = key.nextLine();
        } while (reDo.equalsIgnoreCase("yes"));
        System.out.println("Goodbye");


    }
}
