package com.example.demo.http.requestContent;

public class TaskPathId {

    private final String uriPrefix;

    public TaskPathId(final String pathUri) {
        this.uriPrefix = pathUri;
    }

    public Long getPathId(final String requestUri) {
        return Long.parseLong(requestUri.substring(this.uriPrefix.length()));
    }
}
