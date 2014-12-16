import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Random;

public class SomeClassTest {

	@Test
	public void testReturnValueMustBeEitherBaconOrTofu() throws Exception {
		String returnValue = new SomeClass(new ProteinSelector()).someMethod();
		assertTrue(returnValue.equals("Bacon") || returnValue.equals("Tofu"));
	}

	@Test
	public void testAllRandomsTrueReturnsBacon() {
		SomeClass someClass = new SomeClass(new ProteinSelector(new RandomBooleanGenerator() {
			@Override
			public boolean getNextRandomBoolean() {
				return true;
			}
		}));

		String result = someClass.someMethod();

		assertEquals("Bacon", result);
	}

	@Test
	public void testAllRandomsFalseReturnsTofu() throws Exception {
		SomeClass someClass = new SomeClass(new ProteinSelector(new RandomBooleanGenerator() {
			@Override
			public boolean getNextRandomBoolean() {
				return false;
			}
		}));

		String result = someClass.someMethod();

		assertEquals("Tofu", result);
	}
}
