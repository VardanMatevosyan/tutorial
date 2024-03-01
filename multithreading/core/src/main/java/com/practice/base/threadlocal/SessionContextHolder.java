package com.practice.base.threadlocal;

public class SessionContextHolder {
  private static final ThreadLocal<LocalThreadContext> LOCAL_THREAD_CONTEXT = ThreadLocal.withInitial(LocalThreadContext::new);

  public static void setContext(LocalThreadContext context) {
    LOCAL_THREAD_CONTEXT.set(context);
  }

  public static LocalThreadContext getContext() {
    return LOCAL_THREAD_CONTEXT.get();
  }

  public static void removeContext() {
    LOCAL_THREAD_CONTEXT.remove();
  }

}
