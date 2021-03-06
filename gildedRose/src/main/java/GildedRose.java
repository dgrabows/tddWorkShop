import java.util.ArrayList;
import java.util.List;


public class GildedRose {

    private static List<Item> items = null;

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("OMGHAI!");

        items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updateQuality();
    }


    public static void updateQuality() {
        for (int i = 0; i < items.size(); i++) {
            final Item item = items.get(i);

            if ("Sulfuras, Hand of Ragnaros".equals(item.getName())) {
                break;
            }

            if ((!"Aged Brie".equals(item.getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(item.getName()) && item.getQuality() > 0) {
                item.setQuality(item.getQuality() - 1);
            } else if ("Aged Brie".equals(item.getName()) && item.getQuality() < 50) {
                item.setQuality(item.getQuality() + 1);
            } else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName()) && item.getQuality() < 50) {
                item.setQuality(item.getQuality() + 1);
                if (item.getSellIn() < 11) {
                    if (item.getQuality() < 50) {
                        item.setQuality(item.getQuality() + 1);
                    }
                }

                if (item.getSellIn() < 6) {
                    if (item.getQuality() < 50) {
                        item.setQuality(item.getQuality() + 1);
                    }
                }
            }

            decrementSellIn(item);

            if (item.getSellIn() < 0) {
                if (!"Aged Brie".equals(item.getName()) && !"Backstage passes to a TAFKAL80ETC concert".equals(item.getName()) && item.getQuality() > 0) {
                    item.setQuality(item.getQuality() - 1);
                } else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
                    item.setQuality(0);
                } else if ("Aged Brie".equals(item.getName()) && item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);
                }
            }
        }
    }

    private static void decrementSellIn(Item item) {
        item.setSellIn(item.getSellIn() - 1);
    }

    public static List<Item> getItems() {
        return items;
    }

    public static void setItems(List<Item> items) {
        GildedRose.items = items;
    }
}