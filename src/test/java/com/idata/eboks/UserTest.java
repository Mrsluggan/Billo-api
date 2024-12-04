package com.idata.eboks;

import com.idata.eboks.Services.UserService;
import com.idata.eboks.controller.UserController;

import com.idata.eboks.models.UserMatch;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class UserTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void testUserMatch() throws Exception {
        Mockito.when(userService.matchUsers(Mockito.anyString(), Mockito.any(UserMatch.class)))
                .thenReturn(new UserMatch(Collections.emptyList()));

        mockMvc.perform(post("/v1/tenant/tenant123/usermatch")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"ssns\": []}"))
                .andExpect(status().isOk());
    }

    @Test
    void testFindAllUsers() throws Exception {
        Mockito.when(userService.findUsersFromTenants(Mockito.anyString()))
                .thenReturn(Collections.emptyList());

        mockMvc.perform(get("/v1/tenant/tenant123/users"))
                .andExpect(status().isOk());
    }
}
