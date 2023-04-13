package app.web.orders.user.application.service;

import app.web.orders.facade.user.UserFacade;
import app.web.orders.facade.user.UserSnap;
import app.web.orders.user.domain.User;
import app.web.orders.user.domain.UserRepository;
import app.web.orders.user.domain.UserRole;
import app.web.orders.user.domain.UserSnapshot;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
class UserFacadeImpl implements UserFacade {
    private final UserRepository userRepository;
    @Override
    public Optional<UserSnap> currentUser() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getName())
                .map(UserSnap::new);
    }

    @Override
    public List<String> managementEmails() {
        return userRepository.findAllByUserInfoRole(UserRole.MANAGEMENT)
                .stream()
                .map(User::getSnapshot)
                .map(UserSnapshot::getEmail)
                .collect(Collectors.toList());
    }
}
