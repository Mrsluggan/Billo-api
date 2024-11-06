package com.idata.eboks.Models;

import java.util.Date;

import lombok.Data;

@Data
public class MetaData {

    private String sender;
    private String recipient;
    private Date timeOfDispatch;
    private String contentSize;

}
