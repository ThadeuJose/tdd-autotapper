package autotapper;

import static org.junit.Assert.*;

import org.junit.Test;

public class TransformManaCostTests {

	@Test
	public void testTransform1toC() {
		String message = "Transform from 1 to C";
		String result = "C";
		assertEquals(message,TransformManaCost.transform("1"),result);
	}
	
	@Test
	public void testTransform2toCC() {
		String message = "Transform from 2 to CC";
		String result = "CC";
		assertEquals(message,TransformManaCost.transform("2"),result);
	}

	@Test
	public void tesTtransform7toCCCCCCC() {
		String message = "Transform from 7 to CCCCCCC";
		String result = "CCCCCCC";
		assertEquals(message,TransformManaCost.transform("7"),result);
	}
	
	@Test
	public void testtransform3WGRtoRGWCCC() {
		String message = "Transform from 3WGR to RGWCCC";
		String result = "RGWCCC";
		assertEquals(message,TransformManaCost.transform("3WGR"),result);
	}
	
	@Test
	public void testtransform10WGRtoRGWCCCCCCCCCC() {
		String message = "Transform from 10WGR to RGWCCCCCCCCCC";
		String result = "RGWCCCCCCCCCC";
		assertEquals(message,TransformManaCost.transform("10WGR"),result);
	}
	
	@Test
	public void testtransformGtoG() {
		String message = "Transform from G to G";
		String result = "G";
		assertEquals(message,TransformManaCost.transform("G"),result);
	}
	
	@Test
	public void testtransformGGtoGG() {
		String message = "Transform from GG to GG";
		String result = "GG";
		assertEquals(message,TransformManaCost.transform("GG"),result);
	}	
}

