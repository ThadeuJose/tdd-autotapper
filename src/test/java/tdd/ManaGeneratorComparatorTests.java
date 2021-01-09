package tdd;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import tdd.Card.CardGenerateMultiColor;
import tdd.Card.CardGenerateOneColor;
import tdd.Card.CardWithPriority;

public class ManaGeneratorComparatorTests {

	@Test
	public void testifAllWork() {
		ArrayList<CardWithPriority> test = new ArrayList<>();
		CardWithPriority c1 = new CardGenerateOneColor("C", "C");
		CardWithPriority c2 = new CardGenerateOneColor("G", "G");
		CardWithPriority c3 = new CardGenerateMultiColor("G", "R", "G");
		test.add(c3);
		test.add(c1);
		test.add(c2);
	
		Collections.sort(test, new ManaGeneratorComparator());	

		CardWithPriority result[] = test.toArray(new CardWithPriority[0]);
		CardWithPriority resp[] = { c1, c2, c3 };
		assertArrayEquals(resp, result);
	}

	@Test
	public void testQuantityGenerate() {
		ArrayList<CardWithPriority> test = new ArrayList<>();
		CardWithPriority c1 = new CardGenerateOneColor("C", "C");
		CardWithPriority c2 = new CardGenerateMultiColor("G", "R", "G");
		test.add(c1);
		test.add(c2);
	
		Collections.sort(test, new ManaGeneratorComparator());	

		CardWithPriority result[] = test.toArray(new CardWithPriority[0]);
		CardWithPriority resp[] = { c1, c2 };
		assertArrayEquals(resp, result);
	}

	@Test
	public void testifColorlessIsFirst() {
		ArrayList<CardWithPriority> test = new ArrayList<>();
		CardWithPriority c1 = new CardGenerateOneColor("C", "C");
		CardWithPriority c2 = new CardGenerateOneColor("G", "G");
		test.add(c1);
		test.add(c2);
	
		Collections.sort(test, new ManaGeneratorComparator());	

		CardWithPriority result[] = test.toArray(new CardWithPriority[0]);
		CardWithPriority resp[] = { c1, c2 };
		assertArrayEquals(resp, result);
	}

}