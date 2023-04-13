package app.web.orders.application.element.element.handler;

import app.web.orders.application.element.element.cmd.ElementRemoveCmd;
import app.web.orders.domain.element.element.Element;
import app.web.orders.domain.element.element.ElementRepository;
import app.web.orders.domain.element.element.event.ElementRemoved;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ElementRemoveCmdHandler {
    private final ElementRepository elementRepository;

    public ElementRemoved removeElement(ElementRemoveCmd command){
        Element elementToRemove = elementRepository.findByIdOrThrowException(command.getElementId());
        elementRepository.findAllByAssociatedElements(command.getElementId())
                        .forEach(el->el.removeAssociatedElement(elementToRemove));
        elementRepository.deleteElement(elementToRemove);
        return new ElementRemoved(command.getElementId());
    }
}
