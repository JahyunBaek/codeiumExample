package com.example.nds.codeium.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.nds.codeium.domain.Lotto;
import com.example.nds.codeium.dto.LottoRequestDto;
import com.example.nds.codeium.dto.LottoResponseDto;
import com.example.nds.codeium.service.LottoService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/lotto")
public class LottoController {

    private final LottoService lottoService;

    /**
     * Buys a lotto ticket based on the provided request data.
     *
     * @param  requestDto  the request data containing the name, lotto type, and lotto numbers
     * @return             a ResponseEntity containing the ID and lotto numbers of the bought lotto ticket
     */
    @PostMapping("/buy")
    public ResponseEntity<LottoResponseDto> buyLotto(@RequestBody LottoRequestDto requestDto) {
        Lotto lotto = lottoService.buyLotto(requestDto.getName(), requestDto.getLottoType(), requestDto.getLottoNumbers());
        return ResponseEntity.ok(new LottoResponseDto(lotto.getId(), lotto.getLottoNumbers()));
    }

    /**
     * Retrieves a lotto ticket with the specified ID and returns it as a ResponseEntity.
     *
     * @param  id  the ID of the lotto ticket to retrieve
     * @return     a ResponseEntity containing the ID and lotto numbers of the retrieved lotto ticket
     */
    @GetMapping("/{id}")
    public ResponseEntity<LottoResponseDto> getLotto(@PathVariable Long id) {
        Lotto lotto = lottoService.getLotto(id);
        return ResponseEntity.ok(new LottoResponseDto(lotto.getId(), lotto.getLottoNumbers()));
    }

    /**
     * Deletes a lotto ticket with the specified ID.
     *
     * @param  id  the ID of the lotto ticket to delete
     * @return     a ResponseEntity with no content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLotto(@PathVariable Long id) {
        lottoService.deleteLotto(id);
        return ResponseEntity.noContent().build();
    }
}
