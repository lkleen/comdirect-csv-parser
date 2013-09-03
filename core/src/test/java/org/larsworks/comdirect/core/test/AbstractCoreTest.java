package org.larsworks.comdirect.core.test;

import org.larsworks.comdirect.core.configuration.CoreConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * @author Lars Kleen
 * @since 0.1.0
 *        Date: 03.09.13
 *        Time: 19:37
 */
@ContextConfiguration(classes = CoreConfiguration.class)
public abstract class AbstractCoreTest extends AbstractTestNGSpringContextTests {
}
