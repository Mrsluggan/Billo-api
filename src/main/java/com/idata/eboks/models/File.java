package com.idata.eboks.models;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class File {
    @Column(name = "file_content_type")
    private String content_type;

    private String data;
    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "contentType", column = @Column(name = "responsive_content_type")),
            @AttributeOverride(name = "data", column = @Column(name = "responsive_data")),
            @AttributeOverride(name = "name", column = @Column(name = "responsive_name"))
    })
    private ResponsivePart responsive_part;



    @Data
    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResponsivePart {
        private String content_type;
        private String data;
        private String name;
    }
}