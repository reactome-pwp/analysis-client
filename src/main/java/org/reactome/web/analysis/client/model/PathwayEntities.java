package org.reactome.web.analysis.client.model;

import java.util.List;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public interface PathwayEntities {

    List<String> getExpNames();

    List<PathwayEntity> getIdentifiers();

    List<String> getResources();

    Integer getFound();

}
