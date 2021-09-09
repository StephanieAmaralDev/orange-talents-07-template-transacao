package br.com.zup.edu.stephanie.dto.kafka;

import br.com.zup.edu.stephanie.model.Cartao;

public class CartaoKafka {
    private String id;
    private String email;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Cartao toModel() {
        return new Cartao(id, email);
    }
}
