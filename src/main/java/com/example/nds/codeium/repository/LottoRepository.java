package com.example.nds.codeium.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nds.codeium.domain.Lotto;

public interface LottoRepository extends JpaRepository<Lotto, Long> {
}