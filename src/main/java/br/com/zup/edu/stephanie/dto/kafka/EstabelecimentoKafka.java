package br.com.zup.edu.stephanie.dto.kafka;

import br.com.zup.edu.stephanie.model.Estabelecimento;

public class EstabelecimentoKafka {
    private String nome;
    private String cidade;
    private String endereco;

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public Estabelecimento toModel() {
        return new Estabelecimento(nome, cidade, endereco);
    }
}
