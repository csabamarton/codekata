import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class PermMissingElem {


    public int solution(int[] A) {
        int maximumNumber = A.length + 1;
        int totalSum = (maximumNumber * (maximumNumber + 1)) / 2;
        int partialSum = 0;
        for(int i = 0; i < A.length; i++) {
            partialSum += A[i];
        }

        return totalSum - partialSum;
    }

    public int solution2(int[] A) {
        Set<Integer> orderedNumbers = Arrays.stream(A).boxed().collect(Collectors.toSet());

        int i = 0;
        for(Integer number : orderedNumbers) {
            if(number != i + 1)
                return i+1;
            i++;
        }
        return 0;
    }
}
