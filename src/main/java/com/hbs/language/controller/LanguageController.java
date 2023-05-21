package com.hbs.language.controller;

import com.hbs.language.model.Word;
import com.hbs.language.service.LanguageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/language")
@RequiredArgsConstructor
@Slf4j
public class LanguageController {
    private final LanguageService languageService;

    @PostMapping
    public Word saveWord(@RequestBody Word word) {
        return languageService.save(word);
    }

    @GetMapping("{id}")
    public Word getWord(@PathVariable("id") String wordId) {
        return languageService.getWordById(wordId);
    }

    @PutMapping("{id}")
    public String updateWord(@PathVariable("id") String wordId, @RequestBody Word word) {
        return languageService.update(wordId, word);
    }

    @DeleteMapping({"{id}"})
    public String deleteWord(@PathVariable("id") String wordId) {
        return languageService.delete(wordId);
    }

}
