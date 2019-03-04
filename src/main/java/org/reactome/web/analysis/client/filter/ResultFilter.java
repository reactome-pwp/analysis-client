package org.reactome.web.analysis.client.filter;

import org.reactome.web.pwp.model.client.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Contains the different fields for which an analysis result can be filtered.
 *
 *
 * @author Antonio Fabregat (fabregat@ebi.ac.uk)
 */
public class ResultFilter {

    private String resource;
    private Double pValue;
    private boolean includeDisease = true;
    private Integer min;
    private Integer max;
    private List<String> speciesList;

    public ResultFilter() {
    }

    public ResultFilter(String resource, Double pValue, boolean includeDisease, Integer min, Integer max, List<String> speciesList) {
        this.resource = resource;
        this.pValue = pValue;
        this.includeDisease = includeDisease;
        this.min = min;
        this.max = max;
        this.speciesList = speciesList;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Double getpValue() {
        return pValue;
    }

    public void setpValue(Double pValue) {
        this.pValue = pValue;
    }

    public boolean getIncludeDisease() {
        return includeDisease;
    }

    public void setIncludeDisease(boolean includeDisease) {
        this.includeDisease = includeDisease;
    }

    public Integer getMin() {
        return min;
    }

    public Integer getMax() {
        return max;
    }

    public boolean setBoundaries(int min, int max) {
        if (min > max) return false;
        this.min = min;
        this.max = max;
        return true;
    }

    public void resetBourndaries() {
        this.min = this.max = null;
    }

    public List<String> getSpeciesList() {
        return speciesList;
    }

    public void setSpeciesList(List<String> speciesList) {
        this.speciesList = speciesList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultFilter filter = (ResultFilter) o;
        return includeDisease == filter.includeDisease &&
                Objects.equals(resource, filter.resource) &&
                Objects.equals(pValue, filter.pValue) &&
                Objects.equals(min, filter.min) &&
                Objects.equals(max, filter.max) &&
                Objects.equals(speciesList, filter.speciesList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resource, pValue, includeDisease, min, max, speciesList);
    }

    @Override
    public String toString() {
        List<String> rtn = new ArrayList<>();
        if (resource != null && !resource.isEmpty()) rtn.add("resource=" + resource);
        if (pValue != null) rtn.add("pValue=" + pValue);
        if (!includeDisease) rtn.add("includeDisease=" + includeDisease);
        if (min != null) rtn.add("min=" + min);
        if (max != null) rtn.add("max=" + max);
        String species = getSpeciesParameter(speciesList, ",");
        if (!species.isEmpty()) rtn.add(species);
        return StringUtils.join(rtn, "&");
    }

    public static String getSpeciesParameter(Collection<?> list, String separator) {
        return getSpeciesParameter(list, "", separator);
    }

    public static String getSpeciesParameter(Collection<?> list, String prefix, String separator) {
        if (list == null || list.isEmpty()) return "";
        return prefix + "species=" + StringUtils.join(list, separator);
    }
}
