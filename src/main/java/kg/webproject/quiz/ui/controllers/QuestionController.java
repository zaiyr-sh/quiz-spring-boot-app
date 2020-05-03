package kg.webproject.quiz.ui.controllers;

import io.swagger.annotations.ApiOperation;
import kg.webproject.quiz.service.serviceInterfaces.QuestionService;
import kg.webproject.quiz.shared.dto.AnswerDto;
import kg.webproject.quiz.shared.dto.QuestionDto;
import kg.webproject.quiz.ui.models.request.AnswerRequestModel;
import kg.webproject.quiz.ui.models.request.QuestionRequestModel;
import kg.webproject.quiz.ui.models.response.QuestionResponseModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("questions") // http:localhost:8080/questions
public class QuestionController {

    @Autowired
    QuestionService questionService;

    private ModelMapper modelMapper = new ModelMapper();

    @CrossOrigin
    @PostMapping
    @ApiOperation(value = "addQuestion")
    public QuestionResponseModel createQuestion(@RequestBody QuestionRequestModel question){
        QuestionDto questionDto = modelMapper.map(question, QuestionDto.class);

        return modelMapper.map(questionService.createQuestion(questionDto), QuestionResponseModel.class);

    }

    @CrossOrigin
    @GetMapping(path = "/{id}")
    @ApiOperation(value = "getQuestion")
    public QuestionResponseModel getQuestionById(@PathVariable long id){
        return modelMapper.map(questionService.getQuestionById(id), QuestionResponseModel.class);
    }

    @CrossOrigin
    @GetMapping
    @ApiOperation(value = "getAllQuestions")
    public Set<QuestionResponseModel> getAllQuestions(){
        Set<QuestionResponseModel> returnValue = new HashSet<>();
        for(QuestionDto questionDto: questionService.getAllQuestions()){
            QuestionResponseModel questionResponseModel= modelMapper.map(questionDto, QuestionResponseModel.class);
            returnValue.add(questionResponseModel);
        }

        return returnValue;
    }

    @CrossOrigin
    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "deleteQuestion")
    public String deleteQuestionById(@PathVariable long id){

        questionService.deleteQuestionById(id);
        return "Operation successful";

    }

    @CrossOrigin
    @PutMapping(path = "/{id}")
    @ApiOperation(value = "updateAnswer")
    public QuestionResponseModel updateAnswer(@PathVariable long id, @RequestBody AnswerRequestModel answer){

        AnswerDto answerToAdd = modelMapper.map(answer, AnswerDto.class);

        return modelMapper.map(questionService.updateAnswer(answerToAdd, id), QuestionResponseModel.class);

    }


}
