package com.test.jnosql.model;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;
import org.jnosql.artemis.Id;

@Entity
public class Test {

    @Id
    private String id;

    @Column
    private String dummy;


    public String getId() {
        return id;
    }

    public Test setId(String id) {
        this.id = id;
        return this;
    }

    public String getDummy() {
        return dummy;
    }

    public Test setDummy(String dummy) {
        this.dummy = dummy;
        return this;
    }
}
