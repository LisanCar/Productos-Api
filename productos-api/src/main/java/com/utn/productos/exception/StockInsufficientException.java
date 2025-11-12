package com.utn.productos.exception;

public class StockInsufficientException extends RuntimeException {

    public StockInsufficientException() {
        super("Stock insuficiente");
    }

    public StockInsufficientException(String mensaje) {
        super(mensaje);
    }
}