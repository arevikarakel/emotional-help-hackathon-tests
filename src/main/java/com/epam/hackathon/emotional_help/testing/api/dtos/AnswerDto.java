package com.epam.hackathon.emotional_help.testing.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AnswerDto {

    private String value;

    private Integer mark;

    private AnswerGroup answerGroup;
}
