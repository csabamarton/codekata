import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CollectionsTest {

	List<Integer> contestents;

	@Before
	public void setUp() throws Exception
	{
		contestents = Lists.newArrayList();
		contestents.add(1);
		contestents.add(2);
		contestents.add(3);
		contestents.add(4);
		contestents.add(5);
		contestents.add(6);
		contestents.add(7);
		contestents.add(8);
		contestents.add(9);
	}

	@Test
	public void testTakingNElementFromList(){
		List<Integer> subList = IntStream.range(3, contestents.size())
				.mapToObj(i -> contestents.get(i))
				.collect(Collectors.toList());

		assertTrue("Must be equals", contestents.subList(3, contestents.size()).equals(subList));
	}

	@Test
	public void negateNumbersAndJoinForPrinting(){
		String result = IntStream.range(3, contestents.size())
				.mapToObj(i -> contestents.get(i) * -1)
				.map(Object::toString)
				.collect(Collectors.joining(" "));

		assertEquals(result, "-4 -5 -6 -7 -8 -9");
	}

}
