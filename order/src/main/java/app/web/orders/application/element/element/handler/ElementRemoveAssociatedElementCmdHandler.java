package app.web.orders.application.element.element.handler;

import app.web.orders.application.element.element.cmd.ElementRemoveAssociatedElementCmd;
import app.web.orders.domain.element.element.Element;
import app.web.orders.domain.element.element.ElementRepository;
import app.web.orders.domain.element.element.event.ElementAssociatedElementRemoved;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class ElementRemoveAssociatedElementCmdHandler {
    private ElementRepository elementRepository;

    public ElementAssociatedElementRemoved removeAssociatedElement(ElementRemoveAssociatedElementCmd command) {
        Element element = elementRepository.findByIdOrThrowException(command.getElementId());
        Element elementToRemove = elementRepository.findByIdOrThrowException(command.getElementIdToRemove());
        return element.removeAssociatedElement(elementToRemove);
    }
}
