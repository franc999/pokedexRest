
package com.certant.pokedex.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class PokemonNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(PokemonNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String pokemonNotFoundHandler(PokemonNotFoundException ex) {
    return ex.getMessage();
  }
}