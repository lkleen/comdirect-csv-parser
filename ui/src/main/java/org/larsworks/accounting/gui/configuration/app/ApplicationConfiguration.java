package org.larsworks.accounting.gui.configuration.app;

import lombok.Data;

import java.io.File;

/**
 * @author Lars Kleen
 * @since 0.1.0
 *        Date: 04.09.13
 *        Time: 19:42
 */
@Data
public class ApplicationConfiguration {

    File lastImportLocation;

    File lastLoadLocation;

    File lastSaveLocation;

}
