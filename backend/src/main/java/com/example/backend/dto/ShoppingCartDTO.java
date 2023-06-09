package com.example.backend.dto;

import java.util.List;

public class ShoppingCartDTO {
    private List<ItemDTO> itens;
    private double total;

    public ShoppingCartDTO() {
    }

    public ShoppingCartDTO(List<ItemDTO> itens, double total) {
        this.itens = itens;
        this.total = total;
    }

    public List<ItemDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemDTO> itens) {
        this.itens = itens;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
