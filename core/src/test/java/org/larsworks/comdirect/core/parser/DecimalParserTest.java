package org.larsworks.comdirect.core.parser;

import org.larsworks.comdirect.core.test.AbstractCoreTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.inject.Inject;

import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 7/23/13
 * Time: 11:06 AM
 *
 * @author lkleen
 * @version 0.0.1
 */
public class DecimalParserTest extends AbstractCoreTest {

    @Inject
    private SimpleDecimalParser parser;

    @DataProvider(name = "parameters")
    public Object[][] parameters() {
        List<Object[]> parameters = new ArrayList<Object[]>();
        parameters.add(new Object[] {"-33,12", -33.12f});
        parameters.add(new Object[] {"-0,0", -0f});
        parameters.add(new Object[] {"-0", -0f});
        parameters.add(new Object[] {"0", 0f});
        parameters.add(new Object[] {"0,00", 0f});
        parameters.add(new Object[] {"-1.233,12", -1233.12f});
        parameters.add(new Object[] {"-1231,12", -1231.12f});
        parameters.add(new Object[] {"+1231,12", 1231.12f});
        parameters.add(new Object[] {"987.987.987", 987987987f});
        parameters.add(new Object[] {"9.000.000.000,01", 9000000000.01f});
        return parameters.toArray(new Object[parameters.size()][]);
    }


    @Test(dataProvider = "parameters")
    public void test(String decimal, float expected) {
        assertEquals(parser.parse(decimal), expected);
    }

}
