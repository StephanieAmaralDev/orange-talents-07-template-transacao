package br.com.zup.edu.stephanie.dto.kafka.consumer;

import br.com.zup.edu.stephanie.dto.kafka.TransacaoKafka;
import br.com.zup.edu.stephanie.model.Cartao;
import br.com.zup.edu.stephanie.model.Transacao;
import br.com.zup.edu.stephanie.repository.CartaoRepository;
import br.com.zup.edu.stephanie.repository.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TransacaoConsumer {

    private final TransacaoRepository transacaoRepository;
    private final CartaoRepository cartaoRepository;
    private Logger log;

    public TransacaoConsumer(TransacaoRepository transacaoRepository, CartaoRepository cartaoRepository) {
        this.transacaoRepository = transacaoRepository;
        this.cartaoRepository = cartaoRepository;
        log = LoggerFactory.getLogger(TransacaoConsumer.class);
    }

    @KafkaListener(topics = "${kafka.consumer.topic}", containerFactory = "transacaoKafkaListenerContainerFactory")
    public void transacaoListener(TransacaoKafka transacaoKafka) {
        Optional<Cartao> cartao = cartaoRepository.findById(transacaoKafka.getIdCartao());
        if(cartao.isEmpty())
            cartaoRepository.save(transacaoKafka.getCartaoTransacao());

        Transacao transacao = transacaoKafka.toModel();
        transacaoRepository.save(transacao);
        log.info("Transação salva");
    }
}
