import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DataframeTest {

	@Test
	public void test() {
		Dataframe d = new Dataframe();
		assertEquals(1,d.marche());
	}
}
