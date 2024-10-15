package com.iwillbfine.jenkinsproject.controller;

import com.iwillbfine.jenkinsproject.dto.CalculatorDTO;
import com.iwillbfine.jenkinsproject.service.CalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CalculatorController {

    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "I'm alive!";
    }

    @GetMapping("/api/plus")
    public ResponseEntity<CalculatorDTO> plusTwoNumbers(CalculatorDTO calculatorDTO) {
        log.info("plus 핸들러 실행여부 및 값 확인: " + calculatorDTO);

        /* service 계층에서 더한 값이 돌아오면 */
        int result = calculatorService.plusTwoNumbers(calculatorDTO);

        /* response body 에 담길 CalculatorDTO의 sum에 추가함 */
        calculatorDTO.setSum(result);

        return ResponseEntity.ok().body(calculatorDTO);
    }
}
