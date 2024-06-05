package com.example.nds.codeium.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nds.codeium.domain.Lotto;
import com.example.nds.codeium.repository.LottoRepository;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class LottoService {
    private final LottoRepository lottoRepository;

    /**
     * LottoService 생성자. LottoRepository를 주입받아 인스턴스 변수에 저장합니다.
     *
     * @param  lottoRepository 로또 정보를 저장하고 조회하는 데 사용되는 LottoRepository 객체
     */
    @Autowired
    public LottoService(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    /**
     * 주어진 이름, 로또 타입, 로또 번호로 새로운 로또 객체를 생성합니다.
     *
     * @param  name        로또 티켓 이름
     * @param  lottoType   로또 티켓 타입("수동"은 수동, "자동"은 자동)
     * @param  lottoNumbers   로또 번호를 쉼표로 구분한 문자열
     * @return              새로 생성된 로또 객체
     */
    public Lotto buyLotto(String name, String lottoType, String lottoNumbers) {
        Lotto lotto = new Lotto();
        lotto.setName(name);
        if (lottoType.equals("수동")) {
            lotto.setLottoNumbers(lottoNumbers);
        } else if (lottoType.equals("자동")) {
            lotto.setLottoNumbers(generateLottoNumbers());
        }
        
        //lotto.setPurchaseTime(LocalDateTime.now());
        Lotto savedLotto = lottoRepository.save(lotto);

        return lotto;
    }

    /**
     * 6개의 무작위 로또 번호로 구성된 문자열을 생성합니다.
     *
     * @return 6개의 무작위 로또 번호로 구성된 쉼표로 구분된 문자열
     */
    private String generateLottoNumbers() {
        int[] numbers = new int[6];
        for (int i = 0; i < 6; i++) {
            numbers[i] = (int) (Math.random() * 45) + 1;
        }
        return Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
    }

    /**
     * 주어진 ID로 로또 객체를 저장소에서 조회하여 반환합니다.
     *
     * @param  id  조회할 로또 객체의 ID
     * @return     조회된 로또 객체. 없으면 RuntimeException을 발생시킵니다.
     */
    public Lotto getLotto(Long id) {
        return lottoRepository.findById(id).orElseThrow(() -> new RuntimeException("Lotto not found"));
    }

    /**
     * 주어진 ID로 로또 티켓을 삭제합니다.
     *
     * @param  id  삭제할 로또 티켓의 ID
     */
    public void deleteLotto(Long id) {
        lottoRepository.deleteById(id);
    }
}
