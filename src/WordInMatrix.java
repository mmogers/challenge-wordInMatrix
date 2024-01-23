public class WordInMatrix {
    public static void main(String[] args) {

        char [][] matrix = {
            {'a', 'b', 'c', 'j'},
            {'d', 'e', 'f', 'o'},
            {'g', 'h', 'i', 'i'}
        };

        String word = "abcfii";
        System.out.println("Initial check: ");
        if (!initialCheck(matrix, word)){
            System.out.println("Cannot be");
        }else{
            System.out.println("Can be");
        }
        boolean result =false;
        for (int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if (matrix[i][j] == word.charAt(0)){
                    int[][] filledMatrix = new int[matrix.length][matrix[0].length];
                    result = findWord(matrix, word, i, j, 0, filledMatrix);
                }
            }
        }
        System.out.println("\nThe word: ");
        if (!result){
            System.out.print("Not found");
        }else{
            System.out.print("Found");
        }

    }

    private static boolean findWord(char[][] matrix, String word, int i, int j, int letterCount, int[][] filledMatrix ) {
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length){
            return false;
        }
        if (filledMatrix[i][j] == 1){
            return false;
        }
        if (matrix[i][j] != word.charAt(letterCount)){
            return false;
        }
        filledMatrix[i][j] = 1;
        if (letterCount == word.length()-1){
            return true;
        }

       return findWord(matrix, word, i + 1, j, letterCount + 1, filledMatrix) ||
                findWord(matrix, word, i - 1, j, letterCount + 1, filledMatrix) ||
                findWord(matrix, word, i , j +1, letterCount + 1, filledMatrix) ||
                findWord(matrix, word, i,  j -1, letterCount + 1, filledMatrix);
    }

    private static boolean initialCheck(char[][] matrix, String word) {
        //matrix to array of 26 letters
        int charArray [] = new int[26] ;
        int place = 0;
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                place = aChar - 'a';
                charArray[place]++;
            }
        }

        for (int i = 0; i < word.length();i++){
            place = word.charAt(i) - 'a';
            charArray[place]--;
            if (charArray[place] < 0){
                return false;
            }
        }
        return true;
    }
}
