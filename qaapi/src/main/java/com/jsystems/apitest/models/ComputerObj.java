package com.jsystems.apitest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Nonnull;
import java.io.Serializable;

public class ComputerObj implements Serializable {

    public String produce;

    @Nonnull
    @JsonProperty(value = "screen.size", required = true)
    public String screen_size;

    @Override
    public String toString() {
        return "ComputerObj{" +
                "produce='" + produce + '\'' +
                ", screen_size='" + screen_size + '\'' +
                '}';
    }
}
