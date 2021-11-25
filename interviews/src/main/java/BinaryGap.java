public class BinaryGap {
    public static void main(String[] args) {
        BinaryGap binaryGap = new BinaryGap();
        binaryGap.solution(32);
    }

    public int solution(int input) {
        String binary = Integer.toBinaryString(input);

        binary = removeTrailingZeroes(binary);

        int biggestGap = 0;
        int gapCounter = 0;

        for(int i = 0; i < binary.length(); i++) {
            char c = binary.charAt(i);
            if (c == '1') {
                if (gapCounter > biggestGap)
                    biggestGap = gapCounter;
                gapCounter = 0;
                continue;
            }
            gapCounter++;
        }

        return biggestGap;
    }

    String removeTrailingZeroes(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '0') {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}

