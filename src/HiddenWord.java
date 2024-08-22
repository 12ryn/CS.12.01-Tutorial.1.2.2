public class HiddenWord {
    private String hiddenWord;

    public HiddenWord(String hiddenWord){

        this.hiddenWord = hiddenWord;

    }

    public String getHint(String test){

        for (char c : test.toCharArray()) {
            if (Character.isLetter(c) && !Character.isUpperCase(c)) {

                throw new IllegalArgumentException(
                        "Your guess ( " + test + " ) does not contain all uppercase letters. Your guess must contain all uppercase letters!"
                );

            }
        }

        String target = getHiddenWord();

        if (test.length() != target.length()) {

            throw new IllegalArgumentException(
                    "Your guess ( " + test + " ) has " + test.length() + " characters. The hidden word has " + target.length() + " characters. Your guess must be a word with " + target.length() + " characters!"
            );
        }

        boolean isPresent = false;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < test.length(); i++){

            char finder = test.charAt(i);

            for(int j = 0; j < target.length(); j++){

              char tester = target.charAt(j);

              if(tester == finder && i == j){ // same position same char

                  sb.append(tester);
                  isPresent = true;
                  break;

              } else if (tester == finder && i != j) { // diff position same char

                  sb.append("+");
                  isPresent = true;
                  break;

              } else {

                  isPresent = false;

              }

            }

            if(!isPresent){

                sb.append("*");

            }
        }

        return sb.toString();
    }

    public String getHiddenWord() {

        return hiddenWord.toUpperCase();

    }
}
