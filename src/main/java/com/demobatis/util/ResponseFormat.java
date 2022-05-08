package com.demobatis.util;

import lombok.Data;

@Data
public class ResponseFormat {
    private String responseFlag;
    private Object data;
    private String errorMsg;

    public ResponseFormat() {
    }

    public ResponseFormat(String responseFlag) {
        this.responseFlag = responseFlag;
    }

    public ResponseFormat(String responseFlag, Object data) {
        this.responseFlag = responseFlag;
        this.data = data;
    }

    public ResponseFormat(String responseFlag, String errorMsg) {
        this.responseFlag = responseFlag;
        this.errorMsg = errorMsg;
    }
}
