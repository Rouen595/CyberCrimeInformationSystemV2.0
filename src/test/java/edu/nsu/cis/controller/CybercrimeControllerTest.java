package edu.nsu.cis.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CybercrimeControllerTest {

    @Autowired
    private CybercrimeController cybercrimeController;

    @Test
    public void contextLoadsTest() {
        // Given
        // When
        // Then
        assertThat(cybercrimeController).isNotNull();
    }

}