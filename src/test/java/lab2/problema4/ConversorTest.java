import lab2.problema4.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConversorTest
{
	@Test
	void dollarKeepsAsDollar ()
	{
		double pre = 1000;
		double ans = Conversor.realizarConversion(pre, "USD", "USD");
		assertEquals(pre, ans);
	}

	@Test
	void unknownOriginIs0 ()
	{
		assertEquals(0, Conversor.realizarConversion(1000, "USD", "ASH"));
	}

	@Test
	void unknownDestinys0 ()
	{
		assertEquals(0, Conversor.realizarConversion(1000, "ASD", "USD"));
	}

	@Test
	void copIsLess ()
	{
		assertTrue(1000 > Conversor.realizarConversion(1000, "COP", "USD"));
	}
}
