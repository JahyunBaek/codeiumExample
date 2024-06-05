package com.example.nds.codeium.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * LottoResponseDto는 로또 티켓의 정보를 DTO로 담아서 반환하는 클래스입니다.
 * 로또 티켓의 고유 식별자인 id와 로또 번호를 포함합니다.
 */
public class LottoResponseDto {
    /**
     * 로또 티켓의 고유 식별자입니다.
     */
    private Long id;

    /**
     * 로또 번호를 포함하는 문자열입니다.
     * 로또 번호는 쉼표로 구분되어 있습니다.
     */
    private String lottoNumbers;

}
