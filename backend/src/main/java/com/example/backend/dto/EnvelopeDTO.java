package com.example.backend.dto;

import java.util.List;

public class EnvelopeDTO<T> {
    private boolean last;

    private List<T> data;

    public EnvelopeDTO(boolean last, List<T> data) {
        this.last = last;
        this.data = data;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
