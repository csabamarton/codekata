public class LetterCutter {
    public String solution(String message, int K) {

        if(message.length() <= K)
            return message;

        char cutLetter = message.charAt(K-1);
        if(cutLetter == ' ')
            return message.substring(0,K-1);

        String result = message.substring(0, K);
        if (message.charAt(K) == ' ')
            return result;

        if (message.charAt(K-1) != ' ') {
            if(!result.contains(" "))
                return "";
            result = result.substring(0, result.lastIndexOf(" "));
        }

        return result;
    }
}
