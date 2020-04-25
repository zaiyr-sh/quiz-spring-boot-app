package kg.webproject.quiz.service.serviceInterfaces.implementations;

import kg.webproject.quiz.io.entities.QuestionEntity;
import kg.webproject.quiz.io.repositories.QuestionRepository;
import kg.webproject.quiz.service.serviceInterfaces.QuestionService;
import kg.webproject.quiz.shared.dto.AnswerDto;
import kg.webproject.quiz.shared.dto.QuestionDto;
import kg.webproject.quiz.ui.models.response.QuestionResponseModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuestionServiceImplementation implements QuestionService {

    private QuestionRepository _questionRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public QuestionServiceImplementation(QuestionRepository questionRepository){
        _questionRepository = questionRepository;
    }

    @Override
    public QuestionDto createQuestion(QuestionDto question) {

        if(_questionRepository.findByQuestionContent(question.getQuestionContent()) != null)
            throw new RuntimeException("Record already exists in Database");

        for(AnswerDto answer: question.getAnswers()){
            answer.setQuestion(question);
        }

        QuestionEntity questionEntity = modelMapper.map(question, QuestionEntity.class);
        QuestionDto returnValue = modelMapper.map(_questionRepository.save(questionEntity), QuestionDto.class);

        return returnValue;
    }

    @Override
    public QuestionDto getQuestionById(long id) {

        return modelMapper.map(_questionRepository.findById(id), QuestionDto.class);
    }

    @Override
    public String deleteQuestion(long id) {
        _questionRepository.deleteById(id);

        return "Operation successful";
    }

    @Override
    public QuestionDto updateQuestion(long Id, QuestionDto question) {
        return null;
//        QuestionDto questionUpdate = modelMapper.map(question, QuestionDto.class);
//
//        return modelMapper.map(_questionRepository.findByQuestionContent(
//                questionUpdate, Id), QuestionResponseModel.class);
    }

    @Override
    public Set<QuestionDto> getAllQuestions() {
        Set<QuestionDto> returnSet = new HashSet<>();
        for(QuestionEntity question: _questionRepository.findAll()){
            QuestionDto questionDto = modelMapper.map(question, QuestionDto.class);
            returnSet.add(questionDto);
        }
        return returnSet;
    }

    @Override
    public QuestionDto addAnswer(AnswerDto answer, long id) {
        QuestionEntity question = _questionRepository.findById(id);
        QuestionDto questionDto = modelMapper.map(question, QuestionDto.class);
        questionDto.getAnswers().add(answer);
        QuestionEntity returnQuestion = _questionRepository.save(modelMapper.map(questionDto, QuestionEntity.class));

        return modelMapper.map(returnQuestion, QuestionDto.class);
    }


}
