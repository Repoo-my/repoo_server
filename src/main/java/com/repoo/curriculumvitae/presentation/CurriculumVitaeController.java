package com.repoo.curriculumvitae.presentation;

import com.repoo.curriculumvitae.domain.CurriculumVitae;
import com.repoo.curriculumvitae.presentation.dto.PostRequestCurriculumVitae;
import com.repoo.curriculumvitae.service.CommandCurriculumVitaeService;
import com.repoo.curriculumvitae.service.QueryCurriculumVitaeService;
import com.repoo.curriculumvitae.service.implementation.CurriculumVitaeReader;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/curriculumvitae")
public class CurriculumVitaeController {

    private final CommandCurriculumVitaeService commandCurriculumVitaeService;
    private final QueryCurriculumVitaeService queryCurriculumVitaeService;

    @GetMapping("/")
    public List<CurriculumVitae> getCurriculumVitaes(
            @RequestParam Long userId
    ){
        return queryCurriculumVitaeService.getCurriculumVitaesByUser(userId);
    }

    @GetMapping("/detail/{curriculumVitaeId}")
    public CurriculumVitae getCurriculumVitae(
            @RequestParam Long curriculumVitaeId
    ){
        return queryCurriculumVitaeService.getCurriculumVitae(curriculumVitaeId);
    }

    @PostMapping("/")
    public void createCurriculumVitae(
            @RequestParam Long userId,
            @RequestBody PostRequestCurriculumVitae requestCurriculumVitae
    ){
        commandCurriculumVitaeService.save(userId, requestCurriculumVitae);
    }

}
