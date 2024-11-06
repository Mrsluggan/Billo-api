package com.idata.eboks.models;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Dispatch {
    private String id;
    private String title;
    private String contentType;
    private LocalDateTime deliveryDateTime;
    private List<Attachment> attachments;
    private String recipient;
    private String status;
}