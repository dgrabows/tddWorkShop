import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;


public class GildedRoseTest {

	private Item sulfuras;
	private Item vest;
	private Item concertTicket;

	@Before
	public void setUp() throws Exception {
		sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
		vest = new Item("+5 Dexterity Vest", 10, 20);
		concertTicket = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
	}

	@Test
	public void sulfurasKeepsQuality80AfterUpdate() throws Exception {
		sulfuras.setSellIn(1);
		setupItems(sulfuras);

		GildedRose.updateQuality();
		assertEquals(80, sulfuras.getQuality());
	}

	@Test
	public void updatingQualityShouldNotAddOrRemoveItems() throws Exception {
		setupItems(sulfuras);

		GildedRose.updateQuality();
		assertEquals(1, GildedRose.getItems().size());
		assertSame(sulfuras, GildedRose.getItems().get(0));
	}

	@Test
	public void updatingQualityShouldDecreaseSellInBy1() throws Exception {
		setupItems(vest);

		GildedRose.updateQuality();
		assertEquals(9, vest.getSellIn());
	}

	@Test
	public void updatingQualityShouldNotDecreaseSellInForSulfuras() throws Exception {
		setupItems(sulfuras);

		GildedRose.updateQuality();
		assertEquals(0, sulfuras.getSellIn());
	}

	@Test
	public void itemQualityDecreasesBy1BeforeSellInDate() throws Exception {
		setupItems(vest);

		GildedRose.updateQuality();
		assertEquals(19, this.vest.getQuality());
	}

	@Test
	public void itemQualityDecreasesBy2AfterSellInDate() throws Exception {
		vest.setSellIn(0);
		setupItems(vest);

		GildedRose.updateQuality();
		assertEquals(18, this.vest.getQuality());
	}

	@Test
	public void itemQualityCannotDecreaseBellow0() throws Exception {
		vest.setQuality(0);
		setupItems(vest);

		GildedRose.updateQuality();
		assertEquals(0, vest.getQuality());
	}

	@Test
	public void agedBrieIncreasesInQuality() throws Exception {
		Item brie = new Item("Aged Brie", 2, 0);
		setupItems(brie);

		GildedRose.updateQuality();
		assertEquals(1, brie.getQuality());
	}

	@Test
	public void agedBrieIncreasesInQualityPastSellByDate() throws Exception {
		Item brie = new Item("Aged Brie", 0, 0);
		Item olderBrie = new Item("Aged Brie", -1, 2);
		setupItems(brie, olderBrie);

		GildedRose.updateQuality();
		assertEquals(2, brie.getQuality());
		assertEquals(4, olderBrie.getQuality());
	}

	@Test
	public void concertTicketsIncreaseInQualityMoreThan10DaysLeft() throws Exception {
		setupItems(concertTicket);

		GildedRose.updateQuality();
		assertEquals(21, concertTicket.getQuality());
	}

	@Test
	public void concertTicketsIncreaseInQualityBetween6and10DaysLeft() throws Exception {
		concertTicket.setSellIn(10);
		setupItems(concertTicket);

		GildedRose.updateQuality();
		assertEquals(22, concertTicket.getQuality());
	}

	@Test
	public void concertTicketsIncreaseInQualityBetween5and1DaysLeft() throws Exception {
		concertTicket.setSellIn(5);
		setupItems(concertTicket);

		GildedRose.updateQuality();
		assertEquals(23, concertTicket.getQuality());
	}

	@Test
	public void concertTicketsIncreaseInQuality0DaysLeft() throws Exception {
		concertTicket.setSellIn(0);
		setupItems(concertTicket);

		GildedRose.updateQuality();
		assertEquals(0, concertTicket.getQuality());
	}

	private void setupItems(Item... items) {
		GildedRose.setItems(Arrays.asList(items));
	}
}
