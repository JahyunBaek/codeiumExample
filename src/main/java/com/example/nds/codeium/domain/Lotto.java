package com.example.nds.codeium.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 로또 객체 클래스
 *
 * @author 백자현
 * @since 2024. 06. 05
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Lotto {
    /**
     * 로또 고유 ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 로또 구매자 이름
     */
    private String name;

    /**
     * 로또 숫자
     */
    private String lottoNumbers;

    /**
     * 로또 구매 시간
     */
    @CreatedDate
    private LocalDateTime purchaseTime;

    /**
     * 로또 객체 생성자
     *
     * @param name         로또 이름
     * @param lottoNumbers 로또 숫자
     * @param purchaseTime 로또 구매 시간
     */
    @Builder
    public Lotto(String name, String lottoNumbers, LocalDateTime purchaseTime) {
        this.name = name;
        this.lottoNumbers = lottoNumbers;
        this.purchaseTime = purchaseTime;
    }

    /**
     * 로또 객체를 문자열로 반환
     *
     * @return 로또 객체 정보를 포함하는 문자열
     */
    @Override
    public String toString() {
        return "Lotto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lottoNumbers='" + lottoNumbers + '\'' +
                ", purchaseTime=" + purchaseTime +
                '}';
    }
}

