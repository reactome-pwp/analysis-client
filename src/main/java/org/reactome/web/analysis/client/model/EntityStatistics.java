package org.reactome.web.analysis.client.model;

import java.util.List;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public interface EntityStatistics extends Statistics {

    Integer getCuratedTotal();

    Integer getCuratedFound();

    Integer getInteractorsTotal();

    Integer getInteractorsFound();

    Double getpValue();

    Double getFdr();

    List<Double> getExp();
}
