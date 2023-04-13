package app.web.orders.application.element.element.cmd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ElementUpdateCategoryCmd {
    private long elementId;
    private long categoryId;
}
