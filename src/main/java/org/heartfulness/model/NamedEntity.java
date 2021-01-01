package org.heartfulness.model;

import javax.persistence.Column;

public class NamedEntity extends BaseEntity{

    @Column(name = "name")
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
