package com.idata.eboks.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContentUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ssn; // Required
    private String subject; // Required
    private String generatedAt;

    @Column(name = "user_type") 
    private String type; 

    private boolean retain;
    private Integer retentionDays;
    private String email;

    @ElementCollection
    private List<FileDetail> files;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "type", column = @Column(name = "context_type"))
    })
    private Context context;

    @Data
    @Embeddable
    public static class Context {
        @Embedded
        private Invoice invoice;

        @ElementCollection
        private List<Booking> booking;

        @Data
        @Embeddable
        public static class Invoice {
            @Embedded
            private Payment payment;

            private String invoiceReference;
        }

        @Data
        @Embeddable
        public static class Booking {
            private String title;
            private String description;
            private String location;
            private String infoUrl;
            private String startTime;
            private String endTime;
        }

        @Data
        @Embeddable
        public static class Payment {
            private String account;
            private String currency;
            private String dueDate;
            private String method;
            private Boolean payable;
            private String reference;
            private String totalOwed;
            private String type;
            private String minAmount;
        }
    }

    @Data
    @Embeddable
    public static class FileDetail { 
        @Column(name = "file_content_type") 
        private String contentType;

        private String data;
        private String name;

        @Embedded
        @AttributeOverrides({
            @AttributeOverride(name = "contentType", column = @Column(name = "responsive_content_type")),
            @AttributeOverride(name = "data", column = @Column(name = "responsive_data")),
            @AttributeOverride(name = "name", column = @Column(name = "responsive_name"))
        })
        private ResponsivePart responsivePart;

        @Data
        @Embeddable
        public static class ResponsivePart {
            private String contentType;
            private String data;
            private String name;
        }
    }
}
