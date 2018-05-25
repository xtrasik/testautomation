package com.jsystems.apitest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Nonnull;
import java.io.Serializable;
import java.util.List;

public class DeviceObj implements Serializable {
    public String type;

    @Nonnull
    @JsonProperty(value = "device.model", required = true)
    public List<ComputerObj> deviceModel;

    @Override
    public String toString() {
        return "DeviceObj{" +
                "type='" + type + '\'' +
                ", deviceModel=" + deviceModel +
                '}';
    }
}
