package com.practice.http.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Photo {

  Integer id;

  String sol;

  Camera camera;

  @JsonProperty("img_src")
  String imgSrc;

}
