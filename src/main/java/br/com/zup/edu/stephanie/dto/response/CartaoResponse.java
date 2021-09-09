package br.com.zup.edu.stephanie.dto.response;

import br.com.zup.edu.stephanie.model.Cartao;

public class CartaoResponse {
    private String id;
    private String email;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public CartaoResponse(Cartao cartao) {
        this.id = cartao.getId();
        this.email = cartao.getEmail();
    }
}
