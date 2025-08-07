package com.example.assess.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
 private String status;
 private String message;
 private Object data;

public String getStatus() {
    return status;
}

public String getMessage() {
    return message;
}

public Object getData() {
    return data;
}
}
