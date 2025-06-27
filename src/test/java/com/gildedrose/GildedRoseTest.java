package com.gildedrose;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    @DisplayName("Item name should not change after update")
    void shouldReturnTheItemNameAsIs() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    @DisplayName("should validate the legacy output for 31 days")
    void shouldMatchGoldenOutputOver31Days() {
        Item[] items = new Item[]{new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)};

        GildedRose app = new GildedRose(items);
        StringBuilder output = new StringBuilder();

        for (int day = 0; day < 31; day++) {
            output.append("-------- day ").append(day).append(" --------\n");
            output.append("name, sellIn, quality").append("\n");
            for (Item item : items) {
                output.append(item).append("\n");
            }
            output.append("\n");
            app.updateQuality();
        }

        Approvals.verify(output.toString());
    }


}
