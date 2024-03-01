package com.practice.base.threadlocal;

public class LocalThreadContext {
  private String sessionId;

  public LocalThreadContext() {
  }

  public String getSessionId() {
    return sessionId;
  }

  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }
}
