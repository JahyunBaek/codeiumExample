package com.example.nds.codeium.genai;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.nds.codeium.domain.Lotto;
import com.example.nds.codeium.repository.LottoRepository;
import com.example.nds.codeium.service.LottoService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class LottoServiceTest {
    
    @InjectMocks
    private LottoService lottoService;
    
    @Mock
    private LottoRepository lottoRepository;
    
    
    /**
     * 'buyLottoManual' 메서드의 기능을 테스트합니다.
     * 이 테스트는 LottoRepository를 모킹하고 반환된 Lotto 객체의 로또 번호가 예상된 값과 일치하는지 확인합니다.
     * 또한, LottoRepository의 'save' 메서드가 정확히 한 번 호출되었는지 확인합니다.
     *
     * @param  name         lotto 구매자의 이름
     * @param  lottoType    lotto 타입 (수동 또는 자동)
     * @param  lottoNumbers 구매자가 입력한 로또 번호
     * @return               'buyLottoManual' 메서드에서 반환된 Lotto 객체
     */
    @Test
    public void testBuyLottoManual() {

        //given
        String name = "John";
        String lottoType = "수동";
        String lottoNumbers = "1, 2, 3, 4, 5, 6";
        
        Lotto expectedLotto = new Lotto();
        expectedLotto.setName(name);
        expectedLotto.setLottoNumbers(lottoNumbers);
        //expectedLotto.setPurchaseTime(LocalDateTime.now());
        
        when(lottoRepository.save(Mockito.any(Lotto.class))).thenReturn(expectedLotto);
        
        //when
        Lotto actualLotto = lottoService.buyLotto(name, lottoType, lottoNumbers);
        
        //then
        assertEquals(expectedLotto.getLottoNumbers(), actualLotto.getLottoNumbers());
        verify(lottoRepository, times(1)).save(Mockito.any(Lotto.class));
    }

    /**
     * 'buyLottoAuto' 메서드의 기능을 테스트합니다.
     * 이 테스트는 LottoRepository를 모킹하고 반환된 Lotto 객체의 로또 번호가 예상된 Lotto와 다른지 확인합니다.
     * 또한, LottoRepository의 'save' 메서드가 정확히 한 번 호출되었는지 확인합니다.
     *
     * @return void
     */
    @Test
    public void testBuyLottoAuto() {

        //given
        String name = "John";
        String lottoType = "자동";
        String lottoNumbers = "1, 2, 3, 4, 5, 6";
        
        Lotto expectedLotto = new Lotto();
        expectedLotto.setName(name);
        expectedLotto.setLottoNumbers(lottoNumbers);
        //expectedLotto.setPurchaseTime(LocalDateTime.now());
        
        when(lottoRepository.save(Mockito.any(Lotto.class))).thenReturn(expectedLotto);
        
        //when
        Lotto actualLotto = lottoService.buyLotto(name, lottoType, lottoNumbers);
        
        //then
        assertNotEquals(expectedLotto.getLottoNumbers(), actualLotto.getLottoNumbers());
        verify(lottoRepository, times(1)).save(Mockito.any(Lotto.class));
    }
}
