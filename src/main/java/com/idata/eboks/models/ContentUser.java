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
    private String generated_at;
    private File file;
    @Column(name = "user_type")
    private String type;

    private boolean retain;
    private Integer retention_days;
    private String email;

    @ElementCollection
    private List<File> files;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "type", column = @Column(name = "context_type"))
    })
    private Context context;

    @Data
    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Context {
        @Embedded
        private Invoice invoice;

        @ElementCollection
        private List<Booking> booking;

        @Data
        @Embeddable
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Invoice {
            @Embedded
            private Payment payment;

            private String invoice_reference;
        }

        @Data
        @Embeddable
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Booking {
            private String title;
            private String description;
            private String location;
            private String info_url;
            private String start_time;
            private String end_time;
        }

        @Data
        @Embeddable
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Payment {
            private String account;
            private String currency;
            private String due_date;
            private String method;
            private Boolean payable;
            private String reference;
            private String total_owed;
            private String type;
            private String min_amount;
        }
    }

}
