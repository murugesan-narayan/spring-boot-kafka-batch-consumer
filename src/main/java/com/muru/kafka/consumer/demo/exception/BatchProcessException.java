package com.muru.kafka.consumer.demo.exception;

public class BatchProcessException extends RuntimeException {
    public BatchProcessException(String message) {
        super(message);
    }
}
