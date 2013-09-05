package org.larsworks.accounting.core.configuration;

import com.google.gson.Gson;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.larsworks.accounting.core.controllers.AccountDataAnalyzer;
import org.larsworks.accounting.core.controllers.AccountDataMerger;
import org.larsworks.accounting.core.controllers.CategoryManager;
import org.larsworks.accounting.core.io.*;
import org.larsworks.accounting.core.model.AccountData;
import org.larsworks.accounting.core.parser.*;
import org.larsworks.accounting.core.storage.AccountDataStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.inject.Named;
import java.nio.charset.Charset;
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
    @Named("ISO-8859-1")
    public DirReader dirReaderCharsetISO_8859_1() {
        DirReader dirReader = new DirReader();
        dirReader.setCharset(Charset.forName("ISO-8859-1"));
        return dirReader;
    }

    @Bean
    @Named("UTF-8")
    public DirReader dirReaderCharsetUTF_8() {
        DirReader dirReader = new DirReader();
        dirReader.setCharset(Charset.forName("UTF-8"));
        return dirReader;
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

    @Bean
    @Named("accountDataXmlIO")
    public XmlIO<AccountData> accountDataXmlIO() {
        return new XmlIO<AccountData>(AccountData.class);
    }

    @Bean
    public FileHandler fileHandler() {
        return new FileHandler();
    }

    @Bean
    public AccountDataStorage accountDataStorage() {
        return new AccountDataStorage();
    }

}
