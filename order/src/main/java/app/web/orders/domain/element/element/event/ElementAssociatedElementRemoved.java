package app.web.orders.domain.element.element.event;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ElementAssociatedElementRemoved {
    private long elementId;
    private long elementIdToRemove;
}
