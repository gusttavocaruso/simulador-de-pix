package com.trybe.simuladordepix;

public abstract class ErroDePix extends Exception {

  /**
   * Método abstrato para erros.
   */
  public ErroDePix(String mensagem) {
    super(mensagem);
  }

}
