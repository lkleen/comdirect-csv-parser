package org.larsworks.accounting.gui.configuration.app;

import javax.inject.Inject;

/**
 * @author Lars Kleen
 * @since 0.1.0
 *        Date: 04.09.13
 *        Time: 19:57
 */
public class ApplicationConfigurationManager {

    @Inject
    private ApplicationConfigurationIO applicationConfigurationIO;

    private ApplicationConfiguration applicationConfiguration;

    public ApplicationConfiguration getApplicationConfiguration() {
        if(applicationConfiguration == null) {
            applicationConfiguration = applicationConfigurationIO.load();
        }
        return applicationConfiguration;
    }

    public void set(ApplicationConfiguration applicationConfiguration) {
        applicationConfigurationIO.save(applicationConfiguration);
    }


}
