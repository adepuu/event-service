package com.adepuu.eventservice.helpers;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
@ToString
public class Response<T> {
    private int statusCode;
    private String message;
    private boolean success;
    private T data;

    private Response(int statusCode, String message, boolean success, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public static <T> ResponseEntity<Response<Object>> ok(String message) {
        return builder()
                .message(message)
                .build();
    }

    public static <T> ResponseEntity<Response<Object>> ok(String message, T data) {
        return builder()
                .message(message)
                .data(data)
                .build();
    }

    public static <T> ResponseEntity<Response<Object>> error(HttpStatus status, String message) {
        return builder()
                .statusCode(status.value())
                .message(message)
                .success(false)
                .build();
    }

    public static <T> ResponseEntity<Response<Object>> error(HttpStatus status, String message, T data) {
        return builder()
                .statusCode(status.value())
                .message(message)
                .success(false)
                .data(data)
                .build();
    }

    public static class Builder<T> {
        private int statusCode = HttpStatus.OK.value();
        private String message = "";
        private boolean success = true;
        private T data = null;

        public Builder<T> statusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> success(boolean success) {
            this.success = success;
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ResponseEntity<Response<T>> build() {
            Response<T> response = new Response<>(statusCode, message, success, data);
            return ResponseEntity.status(statusCode).body(response);
        }
    }
}