package br.com.zup.edu.stephanie.dto.kafka;

import br.com.zup.edu.stephanie.model.Cartao;
import br.com.zup.edu.stephanie.model.Estabelecimento;
import br.com.zup.edu.stephanie.model.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoKafka {

    private String id;
    private BigDecimal valor;
    private EstabelecimentoKafka estabelecimento;
    private CartaoKafka cartao;
    private LocalDateTime efetivadaEm;

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoKafka getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoKafka getCartao() {
        return cartao;
    }

    public Cartao getCartaoTransacao(){
        return cartao.toModel();
    }   

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Transacao toModel() {
        Cartao cartao = this.cartao.toModel();
        Estabelecimento estabelecimento = this.estabelecimento.toModel();

        return new Transacao(id, valor, estabelecimento, cartao, efetivadaEm);
    }

    public String getIdCartao() {
        return cartao.getId();

    }
}
