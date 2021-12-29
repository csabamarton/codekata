package algorithm;

import java.util.*;

public class FindFullDeck {


    public int solution2(String[] input) {

        if (input.length < 52)
            return 0;

        Map<String, Integer> cardMap = new HashMap<>();

        Arrays.stream(input).sequential().forEach(card -> {
            if (cardMap.containsKey(card)){
                cardMap.put(card, cardMap.get(card) + 1);
            } else {
                cardMap.put(card, 1);
            }
        });

        if (cardMap.size() < 52) return 0;

        int min = Integer.MAX_VALUE;
        for(Map.Entry<String, Integer> entry : cardMap.entrySet()) {
            if (entry.getValue() < min) min = entry.getValue();
        }

        return min;
    }

    public int solution(String[] input) {
        List<String> inputCards = Arrays.asList(input);

        if (input.length < 52)
            return 0;

        int numOfFullDeck = 0;

        List<String> deck = createFullDeck();

        for (String inputCard : inputCards) {
            if (!deck.contains(inputCard)) {
                return numOfFullDeck;
            }
            deck.remove(inputCard);
            if(deck.isEmpty()) {
                numOfFullDeck++;
                deck = createFullDeck();
            }
        }

        return numOfFullDeck;
    }

    private List<String> createFullDeck() {
        List<String> numbers = List.of("2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A");
        List<String> figures = List.of("S", "C", "H", "D");

        List<String> card = new ArrayList<>();
        for (String number: numbers) {
            for (String figure : figures){
                card.add(number + figure);
            }
        }

        return card;
    }
}
