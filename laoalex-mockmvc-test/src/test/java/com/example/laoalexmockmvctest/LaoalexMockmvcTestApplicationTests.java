package com.example.laoalexmockmvctest;

import com.example.laoalexmockmvctest.controller.TestController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
class LaoalexMockmvcTestApplicationTests {
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        System.out.println("setup");
        mockMvc = MockMvcBuilders.standaloneSetup(new TestController()).build();
    }
    @Test
    public  void getTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getTest"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }
    @Test
    public void postTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/postTest")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"test\": 1}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"test\": 1}"));
    }

}
