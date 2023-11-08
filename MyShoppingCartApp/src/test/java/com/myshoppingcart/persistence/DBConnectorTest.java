package com.myshoppingcart.persistence;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DBConnectorTest {

    @Test
    void connect_isOK() {
        DBConnector dbc = new DBConnector();
        try {
            dbc.connect();
            assertTrue(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}