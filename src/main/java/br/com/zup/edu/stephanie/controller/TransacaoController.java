package br.com.zup.edu.stephanie.controller;


import br.com.zup.edu.stephanie.dto.response.TransacaoResponse;
import br.com.zup.edu.stephanie.model.Cartao;
import br.com.zup.edu.stephanie.model.Transacao;
import br.com.zup.edu.stephanie.repository.CartaoRepository;
import br.com.zup.edu.stephanie.repository.TransacaoRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacaoRepository transacaoRepository;
    private final CartaoRepository cartaoRepository;

    public TransacaoController(TransacaoRepository transacaoRepository, CartaoRepository cartaoRepository) {
        this.transacaoRepository = transacaoRepository;
        this.cartaoRepository = cartaoRepository;
    }

    @GetMapping("/cartoes/{id}")
    public ResponseEntity<List<TransacaoResponse>> ultimasTransacoes(@PathVariable String id) {
        Optional<Cartao> cartaoBanco = cartaoRepository.findById(id);
        if (cartaoBanco.isEmpty())
            return ResponseEntity.notFound().build();

        Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "efetivadaEm");
        List<Transacao> transacaoList = transacaoRepository.findAllByCartao(cartaoBanco.get(), pageable);

        return ResponseEntity.ok(TransacaoResponse.converterLista(transacaoList));
    }
}