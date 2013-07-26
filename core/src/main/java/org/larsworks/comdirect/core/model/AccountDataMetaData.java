package org.larsworks.comdirect.core.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class AccountDataMetaData {
    final Map<String, String> metaData = new HashMap<String, String>();
}