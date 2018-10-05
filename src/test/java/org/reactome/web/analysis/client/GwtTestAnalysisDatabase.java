package org.reactome.web.analysis.client;

import com.google.gwt.junit.client.GWTTestCase;
import org.reactome.web.analysis.client.model.AnalysisError;


/**
 * GWT JUnit <b>integration</b> tests must extend GWTTestCase.
 * Using <code>"GwtTest*"</code> naming pattern exclude them from running with
 * surefire during the test phase.
 * <p/>
 * If you run the tests using the Maven command line, you will have to
 * navigate with your browser to a specific url given by Maven.
 * See https://gwt-maven-plugin.github.io/gwt-maven-plugin/user-guide/testing.html
 * for details.
 */
@SuppressWarnings("Duplicates")
public class GwtTestAnalysisDatabase extends GWTTestCase {

    /**
     * Must refer to a valid module that sources this class.
     */
    @Override
    public String getModuleName() {
        return "org.reactome.web.analysis.analysisJUnit";
    }

    /**
     * Tests the method that returns the database name used by the analysis.
     */
    public void testAnalysisDatabaseName() {
        // Since RPC calls are asynchronous, we will need to wait for a response
        // after this test method returns. This line tells the test runner to wait
        // up to 10 seconds before timing out.
        delayTestFinish(10000);

        AnalysisClient.SERVER = "http://reactomedev.oicr.on.ca";
        AnalysisClient.getDatabaseName(new AnalysisHandler.DatabaseName() {
            @Override
            public void onNameLoaded(String dbName) {
                assertNotNull(dbName);
                assertNotSame(dbName, "");
                finishTest();
            }

            @Override
            public void onNameError(AnalysisError error) {
                fail(error.getReason());
            }

            @Override
            public void onAnalysisServerException(String message) {
                fail(message);
            }
        });
    }

    /**
     * Tests the method that returns the database version (e.g. 66) used by the analysis.
     */
    public void testAnalysisDatabaseVersion() {
        // Since RPC calls are asynchronous, we will need to wait for a response
        // after this test method returns. This line tells the test runner to wait
        // up to 10 seconds before timing out.
        delayTestFinish(10000);

        AnalysisClient.SERVER = "http://reactomedev.oicr.on.ca";
        AnalysisClient.getDatabaseVersion(new AnalysisHandler.DatabaseVersion() {
            @Override
            public void onVersionLoaded(String dbVersion) {
                assertNotNull(dbVersion);
                assertNotSame(dbVersion, "");
                finishTest();
            }

            @Override
            public void onVersionError(AnalysisError error) {
                fail(error.getReason());
            }

            @Override
            public void onAnalysisServerException(String message) {
                fail(message);
            }
        });
    }
}
