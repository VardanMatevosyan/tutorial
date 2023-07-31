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
public class Camera {

  Integer id;

  String name;

  @JsonProperty("rover_id")
  Integer roverId;

  @JsonProperty("full_name")
  String fullName;

}
