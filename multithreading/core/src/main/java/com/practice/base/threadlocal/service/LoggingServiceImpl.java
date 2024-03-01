package com.practice.base.threadlocal.service;

import com.practice.base.threadlocal.SessionContextHolder;

public class LoggingServiceImpl {

  public LoggingServiceImpl() {
  }

  public void log() {
    String sessionId = SessionContextHolder.getContext().getSessionId();
    System.out.println("Session id - " + sessionId);
  }

}
