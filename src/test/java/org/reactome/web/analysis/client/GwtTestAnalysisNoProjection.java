package org.reactome.web.analysis.client;

import com.google.gwt.junit.client.GWTTestCase;
import org.reactome.web.analysis.client.model.AnalysisError;
import org.reactome.web.analysis.client.model.AnalysisResult;
import org.reactome.web.analysis.client.model.PathwaySummary;

import java.util.Arrays;
import java.util.List;


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
public class GwtTestAnalysisNoProjection extends GWTTestCase {

    private static String token;
    /**
     * Must refer to a valid module that sources this class.
     */
    @Override
    public String getModuleName() {
        return "org.reactome.web.analysis.analysisJUnit";
    }

    /**
     * Tests the data analysis not projecting to human.
     */
    public void testAnalysisDataNoProjection() {
        // Since RPC calls are asynchronous, we will need to wait for a response
        // after this test method returns. This line tells the test runner to wait
        // up to 10 seconds before timing out.
        delayTestFinish(10000);

        AnalysisClient.SERVER = "http://dev.reactome.org";
        AnalysisClient.analyseData("#Test\nPTEN\nUNC5B", false, false, null, 1, 1, new AnalysisHandler.Result() {
            @Override
            public void onAnalysisServerException(String message) {
                fail(message);
            }

            @Override
            public void onAnalysisResult(AnalysisResult result, long time) {
                token = result.getSummary().getToken();
                assertTrue("There has to be more than one result", result.getPathwaysFound() > 0);
                finishTest();
            }

            @Override
            public void onAnalysisError(AnalysisError error) {
                fail(error.getReason());
            }
        });
    }

    /**
     * This test will send a request to the server using the greetServer method in
     * GreetingService and verify the response.
     */
    public void testPathwaysSummariesNoProjection() {
        // Since RPC calls are asynchronous, we will need to wait for a response
        // after this test method returns. This line tells the test runner to wait
        // up to 10 seconds before timing out.
        delayTestFinish(10000);

        AnalysisClient.SERVER = "http://dev.reactome.org";
        List<String> pathways = Arrays.asList("1257604","166520","187037","000000");
        AnalysisClient.getPathwaySummaries(token, "TOTAL", pathways, new AnalysisHandler.Summaries() {
            @Override
            public void onPathwaySummariesLoaded(List<PathwaySummary> pathwaySummaries, long time) {
                assertTrue("Only three of them should be there", pathwaySummaries.size() == 3);
                finishTest();
            }

            @Override
            public void onPathwaySummariesNotFound(long time) {
                fail("No pathways summaries found for " + token);
            }

            @Override
            public void onPathwaySummariesError(AnalysisError error) {
                fail(error.getReason());
            }

            @Override
            public void onAnalysisServerException(String message) {
                fail(message);
            }
        });
    }

}
