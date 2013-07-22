package org.larsworks.comdirect.csv.parser;

import org.larsworks.comdirect.csv.io.TextFile;
import org.larsworks.comdirect.csv.model.AccountData;

import java.util.concurrent.Callable;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 26.05.13
 *        Time: 16:56
 */
public class FileParser implements Callable<AccountData> {

    final TextFile textFile;

    public FileParser(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public AccountData call() throws Exception {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
