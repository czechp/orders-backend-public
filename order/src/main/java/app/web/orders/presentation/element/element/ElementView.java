package app.web.orders.presentation.element.element;

import app.web.orders.domain.element.element.ElementData;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Immutable;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = ElementData.BASIC_TABLE_NAME)
@NoArgsConstructor
@Immutable
@Getter
class ElementView {
    @Id
    private long id;
    private long version;
    @EqualsAndHashCode.Include
    private String uuid;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String modifiedBy;
    private String name;
    private String description;
    private String url;
    private String serialNumber;
    private String producer;
    private String category;
    private String provider;
    @JsonIgnore
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = ElementData.ASSOCIATED_ELEMENTS_TABLE, joinColumns = {@JoinColumn(name = "elementId")})
    @Column(name = "associatedElementId")
    @Fetch(FetchMode.SUBSELECT)
    private Set<Long> associatedElements = new HashSet<>();

}
