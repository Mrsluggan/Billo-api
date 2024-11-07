package com.idata.eboks.models;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Data
@Entity
public class Dispatch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String contentType;
    private LocalDateTime deliveryDateTime;
    private List<Attachment> attachments;
    private String recipient;
    private String status;
}