package org.larsworks.accounting.gui.configuration.app;

import lombok.extern.slf4j.Slf4j;
import org.larsworks.accounting.core.io.FileHandler;
import org.larsworks.accounting.core.io.XmlIO;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Lars Kleen
 * @since 0.1.0
 *        Date: 04.09.13
 *        Time: 19:16
 */

@Slf4j
public class ApplicationConfigurationIO {

    private final String filename;

    @Inject
    @Named("applicationConfigurationXmlIO")
    private XmlIO<ApplicationConfiguration> xmlIO;

    @Inject
    private FileHandler fileHandler;

    public ApplicationConfigurationIO(String filename) {
        this.filename = filename;
    }

    public ApplicationConfiguration load() {
        try {
            return xmlIO.reader().read(fileHandler.readFrom(filename));
        } catch (Exception e) {
            ApplicationConfigurationIO.log.info("could not read from file " + filename + " new configuration file created");
            return new ApplicationConfiguration();
        }
    }

    public void save(ApplicationConfiguration applicationConfiguration) {
        xmlIO.writer().write(fileHandler.writeTo(filename), applicationConfiguration);
    }

}
