package com.hbs.language.service;

import com.hbs.language.model.Word;
import com.hbs.language.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LanguageService {

    private final LanguageRepository languageRepository;

    public Word save(Word word) {
        return languageRepository.save(word);
    }

    public Word getWordById(String wordId) {
        return languageRepository.getWordById(wordId);
    }

    public String delete(String wordId) {
        return languageRepository.delete(wordId);
    }

    public String update(String wordId, Word word) {
        return languageRepository.update(wordId, word);
    }
}
