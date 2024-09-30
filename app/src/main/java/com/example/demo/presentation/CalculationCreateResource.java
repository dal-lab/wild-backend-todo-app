package com.example.demo.presentation;

import com.example.demo.application.Calculator;
import com.example.demo.presentation.dto.CalculationRequestDto;
import com.example.demo.presentation.dto.CalculationResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class CalculationCreateResource extends ResourceMethodHandler {
    public final static String KEY = "POST /calculations";

    private final Calculator calculator = new Calculator();

    private final ObjectMapper objectMapper = new ObjectMapper();

    public String handle(String content) throws IOException {
        CalculationRequestDto calculationRequestDto = objectMapper.readValue(
                content,
                CalculationRequestDto.class
        );

        int result = calculator.calculate(
                calculationRequestDto.getNumber1(),
                calculationRequestDto.getNumber2(),
                calculationRequestDto.getOperator()
        );

        return objectMapper.writeValueAsString(
                new CalculationResponseDto(
                        calculationRequestDto.getNumber1(),
                        calculationRequestDto.getNumber2(),
                        calculationRequestDto.getOperator(),
                        result
                )
        );
    }
}
