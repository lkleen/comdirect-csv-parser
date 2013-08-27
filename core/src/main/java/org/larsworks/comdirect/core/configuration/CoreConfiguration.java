package org.larsworks.comdirect.core.configuration;

import com.google.gson.Gson;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.larsworks.comdirect.core.controllers.AccountDataAnalyzer;
import org.larsworks.comdirect.core.controllers.AccountDataMerger;
import org.larsworks.comdirect.core.controllers.CategoryManager;
import org.larsworks.comdirect.core.io.DirReader;
import org.larsworks.comdirect.core.io.FileWriter;
import org.larsworks.comdirect.core.io.TextFileReader;
import org.larsworks.comdirect.core.parser.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author Lars Kleen
 * @since 0.1.0
 *        Date: 27.08.13
 *        Time: 20:16
 */
@Configuration
public class CoreConfiguration {

    @Bean
    public SimpleDecimalParser decimalParser() {
        return new SimpleDecimalParser();
    }

    @Bean
    public SimpleDateTimeParser dateTimeParser() {
        return new SimpleDateTimeParser();
    }

    @Bean
    public Tokenizer tokenizer() {
        return new Tokenizer();
    }

    @Bean
    public TextFileReader textFileReader() {
        return new TextFileReader();
    }

    @Bean
    public FileWriter fileWriter() {
        return new FileWriter();
    }

    @Bean
    public Gson gson() {
        return new Gson();
    }

    @Bean
    public DirReader dirReader() {
        return new DirReader();
    }

    @Bean
    public AccountDataMetaDataParser accountDataMetaDataParser() {
        return new AccountDataMetaDataParser();
    }

    @Bean
    public AccountDataEntryParser accountDataEntryParser() {
        return new AccountDataEntryParser();
    }

    @Bean
    public AccountDataParser accountDataParser() {
        return new AccountDataParser();
    }

    @Bean
    public AccountDataMerger accountDataMerger() {
        return new AccountDataMerger();
    }

    @Bean
    public DateTimeFormatter dateTimeFormatter() {
        return DateTimeFormat.forPattern("dd.MM.yyyy");
    }

    @Bean
    public NumberFormat numberFormat() {
        return NumberFormat.getNumberInstance(Locale.GERMANY);
    }

    @Bean
    public CategoryManager categoryManager() {
        return new CategoryManager();
    }

    @Bean
    public AccountDataAnalyzer accountDataAnalyzer() {
        return new AccountDataAnalyzer();
    }

}
