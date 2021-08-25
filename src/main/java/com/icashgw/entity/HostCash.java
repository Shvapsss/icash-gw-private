package com.icashgw.entity;

public class HostCash {
    private String host;
    private String port;
    private String serialNumber;

    public HostCash(String host, String port, String serialNumber) {
        this.host = host;
        this.port = port;
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
