package com.practice.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import com.practice.http.model.PhotoWrapper;

public class Main {

  private static final String NASA_API_URL = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=14&api_key=rnLIAL5BaEIjBxYdlbh0jeoGAxwdUyeAAS1PtxWr";

  public static void main(String[] args) {

    System.out.println();
    System.out.println("Sync request with string response");
    httpClientCallWithStringResponse();
    System.out.println("=========================================================");
    System.out.println();

    System.out.println();
    System.out.println("Sync request with dto response");
    httpClientCallWithDtoResponse();
    System.out.println("=========================================================");
    System.out.println();

    System.out.println();
    System.out.println("Async request with dto response");
    httpClientAsyncCallWithDtoResponse();
    System.out.println("=========================================================");
    System.out.println();
  }

  private static void httpClientCallWithDtoResponse() {
    HttpResponse<String> httpResponse = httpClientCallWithStringResponse();
    PhotoWrapper photoWrapper = buildPhotoWrapper(httpResponse.body());
    logPhotoWrapperData(photoWrapper);
  }

  private static PhotoWrapper buildPhotoWrapper(String body) {
    try {
      return buildObjectMapper().readValue(body, PhotoWrapper.class);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  private static ObjectMapper buildObjectMapper() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    return objectMapper;
  }

  private static HttpResponse<String> httpClientCallWithStringResponse() {
    HttpRequest httpRequest = getHttpRequest();
    HttpClient httpClient = getHttpClient();
    try {
      HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
      System.out.println("Body is " + httpResponse.body());
      System.out.println("Headers is " + httpResponse.headers().toString());
      System.out.println("StatusCode is " + httpResponse.statusCode());
      return httpResponse;
    } catch (IOException | InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  private static void httpClientAsyncCallWithDtoResponse() {
    CompletableFuture<HttpResponse<String>> future = httpClientAsyncCallWithStringResponse();
    try {
      HttpResponse<String> response = future.get();
      PhotoWrapper photoWrapper = buildPhotoWrapper(response.body());
      logPhotoWrapperData(photoWrapper);
    } catch (InterruptedException | ExecutionException e) {
      throw new RuntimeException(e);
    }
  }

  private static CompletableFuture<HttpResponse<String>> httpClientAsyncCallWithStringResponse() {
    HttpRequest httpRequest = getHttpRequest();
    HttpClient httpClient = getHttpClient();
    return httpClient.sendAsync(httpRequest, BodyHandlers.ofString());
  }

  private static void logPhotoWrapperData(PhotoWrapper photoWrapper) {
    System.out.println("Photos is " + photoWrapper.getPhotos());
    System.out.println("Photos size is " + photoWrapper.getPhotos().size());
    photoWrapper.getPhotos().forEach(photo ->
        System.out.println("Photo id = " + photo.getId() + " and camera is " + photo.getCamera()));
  }

  private static HttpClient getHttpClient() {
    return HttpClient.newHttpClient();
  }

  private static HttpRequest getHttpRequest() {
    return HttpRequest.newBuilder()
        .uri(URI.create(NASA_API_URL))
        .GET()
        .version(Version.HTTP_2)
        .build();
  }
}
