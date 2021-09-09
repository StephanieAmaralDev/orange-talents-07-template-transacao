package br.com.zup.edu.stephanie.repository;

import br.com.zup.edu.stephanie.model.Cartao;
import br.com.zup.edu.stephanie.model.Transacao;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TransacaoRepository extends PagingAndSortingRepository<Transacao, Long> {
    List<Transacao> findAllByCartao(Cartao cartao, Pageable pageable);
}
