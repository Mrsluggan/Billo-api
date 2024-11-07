package com.idata.eboks.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.idata.eboks.models.Dispatch;
import com.idata.eboks.models.DispatchResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DispatchService {

    private final RestTemplate restTemplate;



    public DispatchResponse createSingleDispatch(Dispatch dispatch) {

        DispatchResponse dispatchResponse = restTemplate.postForObject(null, dispatch, DispatchResponse.class);

        return dispatchResponse;
    }

    public Dispatch getDispatchStatus(String messageId) {
        // todo

        return new Dispatch();
    }

    public void recallDispatch(String messageId) {
        // todo

    }

}