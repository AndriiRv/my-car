package com.kent0k.customers.dto;

import java.util.Objects;

public class ResponseDto {

    private Object data;
    private String statusMsg;

    public ResponseDto(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public ResponseDto(Object data, String statusMsg) {
        this.data = data;
        this.statusMsg = statusMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseDto that = (ResponseDto) o;
        return Objects.equals(data, that.data) && Objects.equals(statusMsg, that.statusMsg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, statusMsg);
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "data=" + data +
                ", statusMsg='" + statusMsg + '\'' +
                '}';
    }
}
