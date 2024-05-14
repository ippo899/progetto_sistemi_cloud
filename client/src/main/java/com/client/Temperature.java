package com.client;

import java.sql.Timestamp;

public class Temperature {
    private int idsensore;
    private String stanza;
    private float misura;
    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    public Timestamp getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
    public int getIdsensore() {
        return idsensore;
    }
    public void setIdsensore(int idsensore) {
        this.idsensore = idsensore;
    }
    public String getStanza() {
        return stanza;
    }
    public void setStanza(String stanza) {
        this.stanza = stanza;
    }
    public float getMisura() {
        return misura;
    }
    public void setMisura(float misura) {
        this.misura = misura;
    }

}
