package com.idata.eboks.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
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
    private List<String> files; // Assuming `files` is a simple list of Strings

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
    }
}
