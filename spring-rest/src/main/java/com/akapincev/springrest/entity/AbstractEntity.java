package com.akapincev.springrest.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public abstract class AbstractEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(insertable = false, updatable = false, nullable = false, columnDefinition = "DATETIME(3) DEFAULT CURRENT_TIMESTAMP")
    @Generated(GenerationTime.ALWAYS)
    private LocalDateTime creationDate;

    @Column(columnDefinition = "DATETIME(3) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP")
    @Generated(GenerationTime.ALWAYS)
    private LocalDateTime lastModifiedDate;
}
