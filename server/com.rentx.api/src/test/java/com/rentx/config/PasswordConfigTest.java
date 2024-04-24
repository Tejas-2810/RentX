package com.rentx.config;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PasswordConfigTest {

    @Test
    public void testPasswordEncoderBean() {
        PasswordConfig passwordConfig = new PasswordConfig();
        PasswordEncoder passwordEncoder = passwordConfig.passwordEncoder();

        assertNotNull(passwordEncoder);
    }
}
