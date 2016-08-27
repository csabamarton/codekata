import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sum {
	public static void main(String[] args)
	{
		List<Integer> numbers = Lists.newArrayList();

		for (int i = 0; i < 10; i++) {
			numbers.add(i);
		}

		//loopWithStream(numbers);

		Sum sum = new Sum();
		//sum.testClassLoop();

		sum.cutTheList(numbers);
	}

	private void cutTheList(List numbers){
		List reducedList = IntStream.range(3,numbers.size())
				.mapToObj(n -> n)
				.collect(Collectors.toList());

		String result = (String)reducedList.stream().map(i -> i.toString()).collect(Collectors.joining(" "));

		System.out.println(result);
	}

	private void testClassLoop()
	{
		List<Order> orders = Lists.newArrayList();
		orders.add(new Order(12.30));
		orders.add(new Order(22.40));
		orders.add(new Order(8.50));

		double sum = orders.stream().mapToDouble((Order o) -> o.getPrice()).sum();

		System.out.println(sum);
	}

	private static void loopWithStream(List<Integer> numbers)
	{
		Integer sum = 0;

		sum = numbers.stream().collect(Collectors.summingInt(n->n));

		System.out.println(sum);
	}

	class Order {
		double price;

		public Order(double price)
		{
			this.price = price;
		}

		public double getPrice()
		{
			return price;
		}
	}
}
