package com.example.ikebanaStore;

import com.example.ikebanaStore.controller.WebController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;


import static java.nio.file.Paths.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@WebMvcTest(WebController.class)
public class WebControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHomePage() throws Exception{
       // mockMvc.perform(get(""))
             //   .andExpect(status().isOk())
          //  .andExpect(view().name("home")).andExpect(content().string(containsString("Welcome to...")));

    }
}
