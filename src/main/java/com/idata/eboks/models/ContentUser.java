package com.idata.eboks.models;

import java.util.List;

import lombok.Data;

@Data
public class ContentUser {
    private String ssn; // Required
    private String subject; // Required
    private String generatedAt;
    private String type;
    private boolean retain;
    private Integer retentionDays;
    private String email;
    private List<File> files; // Required
    private Context context;

    @Data
    public static class Context {
        private Invoice invoice;
        private List<Booking> booking;

        @Data
        public static class Invoice {
            private Payment payment;
            private String invoiceReference;

        }

        @Data
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