package com.king.myapp.service.dto;

import java.util.List;

public class HuobiResDTO {

    private List<HuobiDatumDTO> data = List.of();
    private String status;
    private Long ts;

    public List<HuobiDatumDTO> getData() {
        return data;
    }

    public void setData(List<HuobiDatumDTO> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }
}
