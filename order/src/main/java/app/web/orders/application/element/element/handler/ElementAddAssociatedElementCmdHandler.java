package app.web.orders.application.element.element.handler;

import app.web.orders.application.element.element.cmd.ElementAddAssociatedElementCmd;
import app.web.orders.domain.element.element.Element;
import app.web.orders.domain.element.element.ElementRepository;
import app.web.orders.domain.element.element.event.ElementAssociatedElementAdded;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class ElementAddAssociatedElementCmdHandler {
    private final ElementRepository elementRepository;

    public ElementAssociatedElementAdded addAssociatedElement(ElementAddAssociatedElementCmd command) {
        Element element = elementRepository.findByIdOrThrowException(command.getElementId());
        Element elementToAdd = elementRepository.findByIdOrThrowException(command.getElementIdToAdd());
        return element.addAssociatedElement(elementToAdd);
    }

    ;
}
