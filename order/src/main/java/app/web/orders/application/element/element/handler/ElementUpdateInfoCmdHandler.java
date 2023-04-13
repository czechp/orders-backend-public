package app.web.orders.application.element.element.handler;

import app.web.orders.application.element.element.cmd.ElementUpdateInfoCmd;
import app.web.orders.domain.element.element.Element;
import app.web.orders.domain.element.element.ElementRepository;
import app.web.orders.domain.element.element.event.ElementInfoUpdated;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ElementUpdateInfoCmdHandler {
    private final ElementRepository elementRepository;

    public ElementInfoUpdated updateInfo(ElementUpdateInfoCmd command) {
        Element elementToUpdate = elementRepository.findByIdOrThrowException(command.getElementId());
        ElementInfoUpdated event = elementToUpdate.updateInfo(
                command.getName(),
                command.getDescription(),
                command.getSerialNumber(),
                command.getUrl(),
                elementRepository::existsByElementInfoSerialNumber
        );
        return event;
    }
}
