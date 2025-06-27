package com.gildedrose;

import static com.gildedrose.constants.TestConstants.AGED_BRIE;
import static com.gildedrose.constants.TestConstants.BACKSTAGE_PASSES;
import static com.gildedrose.constants.TestConstants.COLUMN_HEADING;
import static com.gildedrose.constants.TestConstants.DEXTERITY_VEST;
import static com.gildedrose.constants.TestConstants.ELIXIR_OF_THE_MONGOOSE;
import static com.gildedrose.constants.TestConstants.EXPIRED_BY_ONE_DAY;
import static com.gildedrose.constants.TestConstants.FIFTEEN_DAYS_TO_SELL;
import static com.gildedrose.constants.TestConstants.FIVE_DAYS_TO_SELL;
import static com.gildedrose.constants.TestConstants.HEADING_PREFIX;
import static com.gildedrose.constants.TestConstants.HEADING_SUFFIX;
import static com.gildedrose.constants.TestConstants.ITEM_NAME_FOO;
import static com.gildedrose.constants.TestConstants.LINE_BREAK;
import static com.gildedrose.constants.TestConstants.MIN_QUALITY;
import static com.gildedrose.constants.TestConstants.ONE_SHORT_OF_MAX_QUALITY;
import static com.gildedrose.constants.TestConstants.QUALITY_OF_SEVEN;
import static com.gildedrose.constants.TestConstants.QUALITY_OF_TWENTY;
import static com.gildedrose.constants.TestConstants.SULFURAS;
import static com.gildedrose.constants.TestConstants.SULFURAS_MAX_QUALITY;
import static com.gildedrose.constants.TestConstants.TEN_DAYS_TO_SELL;
import static com.gildedrose.constants.TestConstants.THIRTYONE_DAYS;
import static com.gildedrose.constants.TestConstants.TWO_DAYS_TO_SELL;
import static com.gildedrose.constants.TestConstants.ZERO_DAYS;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class GildedRoseTest {

    @Test
    @DisplayName("Item name should not change after update")
    void shouldReturnTheItemNameAsIs() {
        Item[] items = new Item[]{new Item(ITEM_NAME_FOO, ZERO_DAYS, ZERO_DAYS)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(ITEM_NAME_FOO, app.items[ZERO_DAYS].name);
    }

    @Test
    @DisplayName("should validate the legacy output for 31 days")
    void shouldMatchGoldenOutputOver31Days() {
        Item[] items = new Item[]{new Item(DEXTERITY_VEST, TEN_DAYS_TO_SELL, QUALITY_OF_TWENTY),
                new Item(AGED_BRIE, TWO_DAYS_TO_SELL, MIN_QUALITY),
                new Item(ELIXIR_OF_THE_MONGOOSE, FIVE_DAYS_TO_SELL, QUALITY_OF_SEVEN),
                new Item(SULFURAS, ZERO_DAYS, SULFURAS_MAX_QUALITY),
                new Item(SULFURAS, EXPIRED_BY_ONE_DAY, SULFURAS_MAX_QUALITY),
                new Item(BACKSTAGE_PASSES, FIFTEEN_DAYS_TO_SELL, QUALITY_OF_TWENTY),
                new Item(BACKSTAGE_PASSES, TEN_DAYS_TO_SELL, ONE_SHORT_OF_MAX_QUALITY),
                new Item(BACKSTAGE_PASSES, FIVE_DAYS_TO_SELL, ONE_SHORT_OF_MAX_QUALITY)};

        GildedRose app = new GildedRose(items);
        StringBuilder output = new StringBuilder();

        for (int day = ZERO_DAYS; day < THIRTYONE_DAYS; day++) {
            output.append(HEADING_PREFIX).append(day).append(HEADING_SUFFIX);
            output.append(COLUMN_HEADING).append(LINE_BREAK);
            for (Item item : items) {

                output.append(item).append(LINE_BREAK);
            }
            output.append(LINE_BREAK);
            app.updateQuality();
        }
        Approvals.verify(output.toString());
    }


}
