package com.example.demo.http.requestContent;

public class TaskPathId {

    public Long getPathId(String requestUri, String uriPrefix) {
        return Long.parseLong(requestUri.substring(getPathUri(uriPrefix).length()));
    }

    public String getPathUri(String uriPrefix) {
        return uriPrefix;
    }
}
