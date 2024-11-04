package Problem;
public class StringCompressionII {
    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a','a','b','b','b','c','c','c'}));
        System.out.println(compress(new char[]{'a'}));
        System.out.println(compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }

    public static int compress(char[] word) {
        StringBuilder comp = new StringBuilder("");

        // pos tracks our position in the input string
        int pos = 0;

        // Process until we reach end of string
        while (pos < word.length) {
            int consecutiveCount = 0;

            char currentChar = word[pos];

            // Count consecutive occurrences (maximum 9)
            while (
                pos < word.length &&
                word[pos] == currentChar
            ) {
                consecutiveCount++;
                pos++;
            }

            // Append count followed by character to result
            if(consecutiveCount>1)
                comp.append(consecutiveCount).append(currentChar);
            else
                comp.append(currentChar);
        }

        return comp.length();
    }
    
}