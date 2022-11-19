package com.example.dependency_microservice_consumer2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//@AutoConfigureMockMvc
//@AutoConfigureJsonTesters
//@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL,
//        ids = "org.springframework.boot:spring-cloud-dependencies:+:stubs:8080")
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK
)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class ThirdParty2IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void given_WhenCallCustomerBalances_ThenReturnAllCustomerWithBalances() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/customer-balances")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"name\":\"Manuel\",\"aggregatedBalance\":0}]"));
    }
}