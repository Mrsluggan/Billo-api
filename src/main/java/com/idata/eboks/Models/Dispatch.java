package com.idata.eboks.models;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Data
@Entity
public class Dispatch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String contentType;
    private LocalDateTime deliveryDateTime;
   
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Attachment> attachments;
    private String recipient;
    private String status;
}