import java.util.LinkedList;
import java.util.stream.IntStream;

public class CyclicRotation {
    public static void main(String[] args) {

    }

    public int[] solution(int[] A, int K) {
        if(A.length == 0 || A.length == 1)
            return A;

        LinkedList<Integer> queue = new LinkedList<>();

        IntStream.range(0, A.length).forEach(i -> queue.add(A[A.length - 1 - i]));

        for (int i = 0; i < K; i++) {
            Integer remove = queue.remove();
            queue.add(remove);
        }

        int[] array = new int[queue.size()];
        IntStream.range(0, A.length).forEach(i -> {
            if (!queue.isEmpty()) {
                array[i] = queue.removeLast();
            }
        });

        return array;
    }
}
