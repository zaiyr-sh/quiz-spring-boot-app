package kg.webproject.quiz.service.serviceInterfaces.implementations;

import kg.webproject.quiz.io.entities.QuestionEntity;
import kg.webproject.quiz.io.repositories.QuestionRepository;
import kg.webproject.quiz.service.serviceInterfaces.QuestionService;
import kg.webproject.quiz.shared.dto.AnswerDto;
import kg.webproject.quiz.shared.dto.QuestionDto;
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
            throw new RuntimeException("Question already exists in Database");
        
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
    public String deleteQuestionById(long id) {
        _questionRepository.deleteById(id);

        return "Operation successful";
    }

//    @Override
//    public QuestionDto updateQuestion(long Id, QuestionDto question) {
////        QuestionDto questionUpdate = modelMapper.map(question, QuestionDto.class);
////
////        return modelMapper.map(_questionRepository.findById(Id), (Type) QuestionResponseModel.class);
//        QuestionDto returnValue = new QuestionDto();
//
//        QuestionEntity questionEntity = _questionRepository.findById(Id);
//
//        questionEntity.setQuestionContent(question.getQuestionContent());
////        questionEntity.setAnswers(question.getAnswers());
//
//        QuestionEntity updatedQuestionDetails = _questionRepository.save(questionEntity);
//        BeanUtils.copyProperties(updatedQuestionDetails, returnValue);
//
//        return returnValue;
//    }

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
    public QuestionDto updateAnswer(AnswerDto answer, long id) {
        QuestionEntity question = _questionRepository.findById(id);
        QuestionDto questionDto = modelMapper.map(question, QuestionDto.class);
        questionDto.getAnswers().add(answer);
        QuestionEntity returnQuestion = _questionRepository.save(modelMapper.map(questionDto, QuestionEntity.class));

        return modelMapper.map(returnQuestion, QuestionDto.class);
    }

}
