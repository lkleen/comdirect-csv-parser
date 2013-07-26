package org.larsworks.comdirect.core.statistics;

import java.util.List;

import lombok.Data;

/**
 * Date: 7/25/13
 * Time: 1:27 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
@Data
public abstract class Statistic<D extends Statistic.Data> {

    static abstract class Data {}

    public abstract Generator<D> generator();

}
