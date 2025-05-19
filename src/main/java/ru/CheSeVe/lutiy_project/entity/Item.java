package ru.CheSeVe.lutiy_project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Item {
    private String itemName;
    private long buyCount;
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getItemName() {
        return itemName;
    }
    public void setBuyCount(long buyCount) {
        this.buyCount = buyCount;
    }

    public long getBuyCount() {
        return buyCount;
    }
}
