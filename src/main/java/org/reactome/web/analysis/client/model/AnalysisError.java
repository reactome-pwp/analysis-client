package org.reactome.web.analysis.client.model;

import java.util.List;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public interface AnalysisError {

    Integer getCode();

    String getReason();

    List<String> getMessages();
}
