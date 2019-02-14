package com.frankeser.webapp.http;

import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class HttpClient extends com.ticinocom.tools.httpclient.HttpClient {

    public HttpClient() {
        super();
    }

    @Inject
    private Logger log;

    @PostConstruct
    private void initHttpClient() {
        this.construct(this.log, true);
    }

    @PreDestroy
    private void destructHttpClient() {
        try {
            this.close();
        } catch (Exception ex) {
        }
    }

    public static JsonObject toJsonObject(Response response) {
        return Json.createReader(new StringReader(response.toString())).readObject();
    }

    public static JsonArray toJsonArray(Response response) {
        return Json.createReader(new StringReader(response.toString())).readArray();
    }

}
