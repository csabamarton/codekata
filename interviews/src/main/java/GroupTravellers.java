import java.util.Arrays;
import java.util.Collections;

public class GroupTravellers {
    public int solution(int[] P, int[] S) {
        //P array contains people ->
        int numberOfPeople = Arrays.stream(P).sum();

        int[] orderedCars = Arrays.stream(S).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        for(int i = 0; i<orderedCars.length; i++) {
            numberOfPeople = numberOfPeople - orderedCars[i];

            if(numberOfPeople<=0)
                return i + 1;
        }

        return S.length;
    }
}
