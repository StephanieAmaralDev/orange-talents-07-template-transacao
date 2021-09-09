package br.com.zup.edu.stephanie.dto.response;

import br.com.zup.edu.stephanie.model.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransacaoResponse {

    private BigDecimal valor;
    private EstabelecimentoResponse estabelecimento;
    private CartaoResponse cartao;
    private LocalDateTime efetivadaEm;

    public TransacaoResponse(Transacao transacao){
        this.valor = transacao.getValor();
        this.efetivadaEm = transacao.getEfetivadaEm();
        this.cartao = new CartaoResponse(transacao.getCartao());
        this.estabelecimento = new EstabelecimentoResponse(transacao.getEstabelecimento());
    }

    public static List<TransacaoResponse> converterLista(List<Transacao> transacoesBanco) {
        List<TransacaoResponse> transacoesList = new ArrayList<>();
        transacoesBanco.forEach(t -> transacoesList.add(new TransacaoResponse(t)));

        return transacoesList;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoResponse getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}