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
@RequestMapping("questions")
@CrossOrigin
public class QuestionController {

    @Autowired
    QuestionService questionService;

    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping
    @ApiOperation(value = "addQuestion")
    public QuestionResponseModel addQuestion(@RequestBody QuestionRequestModel question){

        QuestionDto questionDto = modelMapper.map(question, QuestionDto.class);

        return modelMapper.map(questionService.createQuestion(questionDto), QuestionResponseModel.class);

    }
    @GetMapping(path = "/{id}")
    @ApiOperation(value = "getQuestion")
    public QuestionResponseModel getQuestion(@PathVariable long id){
        return modelMapper.map(questionService.getQuestionById(id), QuestionResponseModel.class);
    }

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

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "deleteQuestion")
    public String deleteQuestion(@PathVariable long id){

        questionService.deleteQuestion(id);
        return "Operation successful";

    }

    @PutMapping(path = "/{id}")
    @ApiOperation(value = "addAnswerToQuestion")
    public QuestionResponseModel addAnswerToQuestion(@PathVariable long id, @RequestBody AnswerRequestModel answer){

        AnswerDto answerToAdd = modelMapper.map(answer, AnswerDto.class);

        return modelMapper.map(questionService.addAnswer(answerToAdd, id), QuestionResponseModel.class);

    }


}
