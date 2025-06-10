package com.reservas.reservas.domain.model;

import java.util.UUID;

public class Space {

    private Long id;
    private String name;
    private String description;
    private int capacity;
    private SpaceType type;
    private boolean isActive;

    public Space(Long id, String name, String description, int capacity, SpaceType type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.capacity = capacity;
        this.type = type;
        this.isActive = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public SpaceType getType() {
        return type;
    }

    public void setType(SpaceType type) {
        this.type = type;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
