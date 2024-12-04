package com.idata.eboks.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TokenServiceTest {

    private static final String CLIENT_ID ="idata.sandbox";
    private static final String CLIENT_SECRET = "!Xeru#NDx3^JjP";
    private static final String TOKEN_URI = "https://sandbox-identity.billo.life/connect/token";
    private static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static final String MOCKED_ACCESS_TOKEN = "{\"access_token\":\"mockedAccessToken\",\"expires_in\":3600,\"token_type\":\"Bearer\"}";

    @InjectMocks
    private TokenService tokenService;

    @MockBean
    private WebClient.Builder webClientBuilder;

    @Mock
    private WebClient webClient;

    @Mock
    private WebClient.RequestBodyUriSpec requestBodyUriSpec;

    @Mock
    private WebClient.RequestHeadersSpec<?> requestHeadersSpec;

    @Mock
    private WebClient.ResponseSpec responseSpec;

    @BeforeEach 
    public void setup() { 
        setupMocks();
        setClientCredentials();
    }

    private void setupMocks() {
        doReturn(webClient).when(webClientBuilder).build(); 
        doReturn(requestBodyUriSpec).when(webClient).post(); 
        doReturn(requestBodyUriSpec).when(requestBodyUriSpec).uri(anyString()); 
        doReturn(requestBodyUriSpec).when(requestBodyUriSpec).header(anyString(), anyString()); 
        doReturn(requestHeadersSpec).when(requestBodyUriSpec).bodyValue(anyString()); 
        doReturn(responseSpec).when(requestHeadersSpec).retrieve(); 
        doReturn(Mono.just(MOCKED_ACCESS_TOKEN)).when(responseSpec).bodyToMono(eq(String.class));
    }
    
    private void setClientCredentials() {
        ReflectionTestUtils.setField(tokenService, "clientId", CLIENT_ID);
        ReflectionTestUtils.setField(tokenService, "clientSecret", CLIENT_SECRET);
    }

    @Test
    public void shouldRetrieveAccessTokenWhenValidCredentialsProvided() {
        String result = tokenService.getAccessToken();
        assertEquals("mockedAccessToken", result);
        verifyCommonInteractions();
        verify(requestBodyUriSpec).bodyValue(anyString());
    }

    @Test
    public void shouldUseCorrectContentTypeHeader() {
        tokenService.getAccessToken();
        verifyCommonInteractions();
    }

    @Test
    public void shouldProperlyUrlEncodeClientIdAndClientSecret() {
        String encodedClientId = URLEncoder.encode(CLIENT_ID, StandardCharsets.UTF_8);
        String encodedClientSecret = URLEncoder.encode(CLIENT_SECRET, StandardCharsets.UTF_8);
        String expectedBodyValue = String.format("grant_type=client_credentials&client_id=%s&client_secret=%s", 
        encodedClientId, encodedClientSecret);
        tokenService.getAccessToken();
        verify(requestBodyUriSpec).bodyValue(expectedBodyValue);
    }

    @Test
    public void shouldUseCorrectUriForTokenEndpoint() {
        tokenService.getAccessToken();
        verify(requestBodyUriSpec).uri(TOKEN_URI);
    }

    private void verifyCommonInteractions() {
        verify(webClient).post();
        verify(requestBodyUriSpec).uri(TOKEN_URI);
        verify(requestBodyUriSpec).header("Content-Type", CONTENT_TYPE);
    }
}