package com.epam.hackathon.emotional_help.testing.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class AnswersDto {

    private List<AnswerDto> answers;
}
