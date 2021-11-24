import java.util.Comparator;
import java.util.stream.IntStream;

public class SmallestInt {

    public static void main(String[] args) {
        SmallestInt smallestInt = new SmallestInt();
        int solution = smallestInt.solution(new int[]{1, 3, 5, 6, 4, 1, 2});
        System.out.println(solution);
    }

    public int solution(int[] numbers) {

        int[] orderedNumbers = IntStream.of(numbers)
                .parallel()
                .filter(i -> i > 0)
                .distinct()
                .boxed()
                .sorted(Comparator.naturalOrder())
                .mapToInt(i -> i).toArray();

        if(orderedNumbers.length == 0)
            return 1;

        for (int i= 0; i<orderedNumbers.length; i++){
            if(orderedNumbers[i] != i+1)
                return i + 1;
        }

        return orderedNumbers.length + 1;
    }
}
