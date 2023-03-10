package br.com.tiraboschi.bt22.model;

import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
@RequiredArgsConstructor
@Generated
public class TokenState {

  private final String accessToken;
  private final Long expiresIn;

}