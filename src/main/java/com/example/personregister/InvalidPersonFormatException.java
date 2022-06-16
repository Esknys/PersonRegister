package com.example.personregister;

import java.io.IOException;

public class InvalidPersonFormatException extends IOException {
    InvalidPersonFormatException(String msg) {
        super(msg);
    }
}
