package com.hbs.language.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.hbs.language.model.Word;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LanguageRepository {

    private final DynamoDBMapper dynamoDBMapper;

    public Word save(Word word) {
        dynamoDBMapper.save(word);
        return word;
    }

    public Word getWordById(String wordId) {
        return dynamoDBMapper.load(Word.class, wordId);
    }

    public String delete(String wordId) {
        Word wordToDelete = dynamoDBMapper.load(Word.class, wordId);
        dynamoDBMapper.delete(wordToDelete);
        return wordId;
    }

    public String update(String wordId, Word word) {
        dynamoDBMapper.save(word,
                new DynamoDBSaveExpression()
                        .withExpectedEntry(
                                "wordId",
                                new ExpectedAttributeValue(
                                        new AttributeValue()
                                                .withS(wordId)
                                )
                        )
        );
        return wordId;
    }
}
