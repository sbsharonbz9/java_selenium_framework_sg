package galen.tenant.dexter.SinglePageContent;

import galen.base.BaseTest;
import galen.helpers.common.GalenReport;
import galen.helpers.tenant.dexter.DexterHFWrappers;
import galen.helpers.tenant.dexter.DexterUser;
import galen.pages.common.PritUnlPage;
import galen.pages.tenant.dexter.InitialAssessment.DexterPageObj;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Thread.sleep;

public class VTP_DEX_FRD_263_Clinical_Depression_Screen  extends BaseTest {
    static String OBJECTIVE = "To verify the Clinical Depression Screen provides controls that allow users to input "+
            "a confirmation or denial response.";
    static String NOTES = "This protocol contains the following scenario(s):\n" +
            "-\tClinical Depression Screen has controls that allow the user to select whether they confirm or deny a question. \n";
    static String REQUIREMENTS = "DEX_FRD_263";
    static String REFERENCES = "HappyFlow_IA_Initial_Assessment_to_Checkout_wBP_NonSmoker.docx";
    String reportName = "VTP_DEX_FRD_263_Clinical_Depression_Screen";
    ArrayList<String> VERSIONHISTORY = new ArrayList<>();
    HashMap<String, String[]> PREEXECUTION = new HashMap<>();

    VTP_DEX_FRD_263_Clinical_Depression_Screen()  {
        VERSIONHISTORY.add("1.0;20JUN2024;Initial Test Script;Name Redacted");
    }

    @Test
    public void VTP_DEX_FRD_263_Clinical_Depression_Screen_Test() throws Exception {

        report = new GalenReport(driver, reportName, OBJECTIVE, REQUIREMENTS, REFERENCES, NOTES,
                VERSIONHISTORY, PREEXECUTION);
        report.reportTitle = "VTP_DEX_FRD_263 – Clinical Depression Screen";

        DexterUser user = new DexterUser();
        DexterPageObj pageObj = new DexterPageObj(driver);

        new PritUnlPage(driver).authenticateUserIfRequired();
        new DexterHFWrappers(driver).runDexterHFNonsmokingwBP(user, pageObj.depression, report);
        pageObj.depression.clickYesOrNo("Yes", report);
        pageObj.depression.clickNextToPage(pageObj.diagnosedDepression, report);
        pageObj.diagnosedDepression.verifyYesNoPresent(report);
        report.addScreenshotStep("Step2_YesNoPresent");

        pageObj.diagnosedDepression.clickYesOrNo("Yes", report);
        sleep(1000);
        pageObj.diagnosedDepression.verifyNextButtonEnabled(report);
        report.addScreenshotStep("Step3_Next Button Enabled");

        pageObj.diagnosedDepression.clickYesOrNo("No", report);
        sleep(1000);
        pageObj.diagnosedDepression.verifyNextButtonEnabled(report);
        report.addScreenshotStep("Step4_Next Button Enabled");

    }
}
