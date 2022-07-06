/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logistica.model;

import org.springframework.http.HttpStatus;

/**
 *
 * @author Administrador
 */

public class ResponseModel {
    private String error;
    private HttpStatus codigo;
    private Object data;

    public ResponseModel() {
    }

    public ResponseModel(String error, HttpStatus codigo, Object data) {
        this.error = error;
        this.codigo = codigo;
        this.data = data;
    }

    
    /**
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * @return the codigo
     */
    public HttpStatus getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(HttpStatus codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }
    
    
}
