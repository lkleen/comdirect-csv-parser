package org.larsworks.comdirect.core.io;

import lombok.Data;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 26.05.13
 *        Time: 16:06
 */
@Data
public class TextFile {
    final TextLines lines;
    final String text;
}
