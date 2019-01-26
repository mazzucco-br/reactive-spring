package com.mazzucco.reactivespring.msusuarios.client.msTwo;

import org.springframework.stereotype.Component;

@Component
class MicroserviceTwoFallback implements IMicroserviceTwoClient {
    public ResponseTwo testCallTwo() {
        ResponseTwo response = new ResponseTwo();
        response.setResult("FAKED RESULT (FALLBACK)");
        return response;
    }
}