package com.idata.eboks.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.idata.eboks.models.Dispatch;
import com.idata.eboks.models.DispatchResponse;
import com.idata.eboks.repository.DispatchRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DispatchService {

    private final RestTemplate restTemplate;
    private final DispatchRepository dispatchRepository;

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

    public Dispatch updateDispatch(String messageId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateDispatch'");
    }

}