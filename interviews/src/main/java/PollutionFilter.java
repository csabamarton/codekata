import java.util.Arrays;
import java.util.Collections;

public class PollutionFilter {
    public int solution(int[] A) {
        //find the goal : sum of pullution / 2
        int sumOfPollution = Arrays.stream(A).sum();
        double halfPollution = (double) sumOfPollution / 2;

        double[] orderedFactories = Arrays.stream(A).boxed()
                .sorted(Collections.reverseOrder())
                .mapToDouble(Integer::doubleValue)
                .toArray();


        int i=0;
        int numOfFilters = 0;
        while (halfPollution > 0) {
            numOfFilters++;
            double filteredFactoryPollution = orderedFactories[i] / 2;
            orderedFactories[i] = filteredFactoryPollution;

            halfPollution = halfPollution - filteredFactoryPollution;

            if(halfPollution<=0)
                return numOfFilters;

            if(i < orderedFactories.length - 1) {
                if(orderedFactories[i+1] > filteredFactoryPollution)
                    i++;
            }
        }

        return 1;
    }
}
