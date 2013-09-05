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
    private ApplicationConfigurationStorage applicationConfigurationStorage;

    private ApplicationConfiguration applicationConfiguration;

    public ApplicationConfiguration get() {
        if(applicationConfiguration == null) {
            applicationConfiguration = applicationConfigurationStorage.load();
        }
        return applicationConfiguration;
    }

    public void set(ApplicationConfiguration applicationConfiguration) {
        this.applicationConfiguration = applicationConfiguration;
        applicationConfigurationStorage.store(applicationConfiguration);
    }


}
