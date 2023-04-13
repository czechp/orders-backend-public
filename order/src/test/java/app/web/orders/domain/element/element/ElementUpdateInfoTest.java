package app.web.orders.domain.element.element;

import app.web.orders.domain.element.element.event.ElementInfoUpdated;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ElementUpdateInfoTest {
    @Test
    @DisplayName("Element.updateInfo() - serial number different and unique")
    void updateInfoSerialNumberDifferentAndUnique() {
        //given
        String name = "Some name";
        String description = "Some description";
        String url = "http://someUrl.gmail.com";
        String serialNumber = "New serial number";

        Element element = ElementBasicImpl.builder()
                .withElementInfo(new ElementInfo("Old name", "Old description", "Old url", "Old serial number"))
                .build();
        //when
        ElementInfoUpdated event = element.updateInfo(name, description, serialNumber, url, (String number) -> false);
        //then
        assertEquals(name, event.getNewData().getName());
        assertEquals(description, event.getNewData().getDescription());
        assertEquals(url, event.getNewData().getUrl());
        assertEquals(serialNumber, event.getNewData().getSerialNumber());
    }

    @Test
    @DisplayName("Element.updateInfo() - serial number same")
    void updateInfoSerialNumerSameTest() {
        //given
        String name = "Some name";
        String description = "Some description";
        String url = "http://someUrl.gmail.com";
        String serialNumber = "New serial number";

        Element element = ElementBasicImpl.builder()
                .withElementInfo(new ElementInfo("Old name", "Old description", "Old url", serialNumber))
                .build();
        //when
        ElementInfoUpdated event = element.updateInfo(name, description, serialNumber, url, (String number) -> true);
        //then
        assertEquals(name, event.getNewData().getName());
        assertEquals(description, event.getNewData().getDescription());
        assertEquals(url, event.getNewData().getUrl());
        assertEquals(serialNumber, event.getNewData().getSerialNumber());
    }

    @Test
    @DisplayName("Element.updateInfo() - serial number different and not unique")
    void updateInfoSerialNumberDifferentAndNotUnique() {
        //given
        String name = "Some name";
        String description = "Some description";
        String url = "http://someUrl.gmail.com";
        String serialNumber = "New serial number";

        Element element = ElementBasicImpl.builder()
                .withElementInfo(new ElementInfo("Old name", "Old description", "Old url", "Old serial number"))
                .build();
        //when
        //then
        assertThrows(IllegalStateException.class, () -> {
            element.updateInfo(name, description, serialNumber, url, (String number) -> true);
        });
    }


}