public class FrogJump {
    public int solution(int X, int Y, int D) {
        int numOfJump = (int) Math.floor((Y - X) / D);
        if (X + D * numOfJump == Y) {
            return numOfJump;
        } else  return numOfJump + 1;
    }
}
