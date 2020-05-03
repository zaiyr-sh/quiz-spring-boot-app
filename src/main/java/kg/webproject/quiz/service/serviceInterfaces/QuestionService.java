package kg.webproject.quiz.service.serviceInterfaces;

import kg.webproject.quiz.shared.dto.AnswerDto;
import kg.webproject.quiz.shared.dto.QuestionDto;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface QuestionService {

    QuestionDto createQuestion(QuestionDto questionDto);
    Set<QuestionDto> getAllQuestions();
    QuestionDto getQuestionById(long id);
    QuestionDto updateAnswer(AnswerDto answerDto, long id);
//    QuestionDto updateQuestion(long id, QuestionDto questionDto);
    String deleteQuestionById(long id);
}
