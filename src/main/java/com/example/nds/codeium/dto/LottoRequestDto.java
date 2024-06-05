package com.example.nds.codeium.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * LottoRequestDto는 로또 요청에 사용되는 DTO 클래스입니다.
 * name은 로또 티켓의 이름을, lottoType은 로또 티켓의 타입을, lottoNumbers는 로또 번호를 나타냅니다.
 *
 * @author 백자현
 * @since 2024. 06. 05
 */
@Getter
@AllArgsConstructor
public class LottoRequestDto {
    /** 로또 티켓의 이름 */
    private String name;
    /** 로또 티켓의 타입 */
    private String lottoType;
    /** 로또 번호 */
    private String lottoNumbers;
}
