import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class OddOccurencesInArray {
    public int solution(int[] input) {
        Map<Integer, Integer> counterMap = new HashMap<>();

        IntStream.range(0, input.length).forEach(i-> {
            Integer num = input[i];
            if(!counterMap.containsKey(num)){
                    counterMap.put(num, 1);
                } else {
                    counterMap.remove(num);
                }
            }
        );

        return counterMap.entrySet()
                .stream()
                .findFirst()
                .get().getKey();
    }

    public int solution2(int[] input) {
        Map<Integer, Integer> counterMap = new HashMap<>();

        IntStream.range(0, input.length).forEach(i-> {
                    Integer num = input[i];
                    if(!counterMap.containsKey(num)){
                        counterMap.put(num, 1);
                    } else {
                        counterMap.put(num, counterMap.get(num) + 1);
                    }
                }
        );

        for (Map.Entry<Integer, Integer> entry : counterMap.entrySet()) {
            if(entry.getValue() % 2 != 0)
                return entry.getKey();
        }
        return 0;
    }


    public int solutionOld(int[] input) {
        List<Integer> nums = new ArrayList<>();
        IntStream.range(0, input.length).forEach(i-> {
                    Integer num = input[i];
                    if(!nums.contains(num)){
                        nums.add(num);
                    } else {
                        nums.remove(num);
                    }
                }
        );

        return nums.get(0);
    }
}
