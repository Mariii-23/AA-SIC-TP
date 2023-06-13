package com.example.backend.dto;

public class PaginationDTO {
    private int offset;
    private int numItems;

    public PaginationDTO() {
    }

    public PaginationDTO(int offset, int numItems) {
        this.offset = offset;
        this.numItems = numItems;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getNumItems() {
        return numItems;
    }

    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }
}
