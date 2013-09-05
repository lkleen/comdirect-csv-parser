package org.larsworks.accounting.gui.configuration.app;

import lombok.extern.slf4j.Slf4j;
import org.larsworks.accounting.core.io.FileHandler;
import org.larsworks.accounting.core.io.XmlIO;
import org.larsworks.accounting.core.storage.AbstractXmlStorage;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Lars Kleen
 * @since 0.1.0
 *        Date: 04.09.13
 *        Time: 19:16
 */

@Slf4j
public class ApplicationConfigurationStorage extends AbstractXmlStorage<ApplicationConfiguration> {

    @Inject
    @Named("applicationConfigurationXmlIO")
    private XmlIO<ApplicationConfiguration> xmlIO;

    @Inject
    private FileHandler fileHandler;

    public ApplicationConfigurationStorage(String filename) {
        super(filename);
    }

    @Override
    protected XmlIO<ApplicationConfiguration> getXmlIO() {
        return xmlIO;
    }

    @Override
    protected ApplicationConfiguration emptyInstance() {
        return new ApplicationConfiguration();
    }

}
