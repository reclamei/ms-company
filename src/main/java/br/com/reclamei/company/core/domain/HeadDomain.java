package br.com.reclamei.company.core.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class HeadDomain {

    private Long id;
    private String email;
    private String name;
    private String phone;
    private Boolean isAdmin;
    private UUID externalId;
    private String status = "PENDING_CONFIRMATION";
    private LocalDateTime createdAt;

}
