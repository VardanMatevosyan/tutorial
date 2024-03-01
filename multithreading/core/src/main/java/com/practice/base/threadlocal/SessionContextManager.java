package com.practice.base.threadlocal;

import static java.util.Objects.isNull;

import java.util.UUID;

public class SessionContextManager {

  public SessionContextManager() {
  }

  public void setSessionId() {
    LocalThreadContext context = SessionContextHolder.getContext();
    if (isNull(context.getSessionId())) {
      String sessionId = generateSessionId();
      context.setSessionId(sessionId);
    }
  }

  private String generateSessionId() {
    return UUID.randomUUID().toString();
  }
}
