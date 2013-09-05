package org.larsworks.accounting.core.storage;

import org.larsworks.accounting.core.io.XmlIO;
import org.larsworks.accounting.core.model.AccountData;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Lars Kleen
 * @since 0.1.0
 *        Date: 05.09.13
 *        Time: 20:05
 */
public class AccountDataStorage extends AbstractXmlStorage<AccountData> {

    @Inject
    @Named("accountDataXmlIO")
    private XmlIO<AccountData> xmlIO;

    @Override
    protected XmlIO<AccountData> getXmlIO() {
        return xmlIO;
    }

    @Override
    protected AccountData emptyInstance() {
        return new AccountData();
    }
}
