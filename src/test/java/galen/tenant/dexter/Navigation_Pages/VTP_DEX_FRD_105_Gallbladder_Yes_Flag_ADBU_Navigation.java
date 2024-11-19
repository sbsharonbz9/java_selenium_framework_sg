package galen.tenant.dexter.Navigation_Pages;

import galen.base.BaseTest;
import galen.enums.framework.UrlType;
import galen.helpers.common.CommonPageFeatures;
import galen.helpers.common.GalenReport;
import galen.helpers.tenant.dexter.DexterHFWrappers;
import galen.helpers.tenant.dexter.DexterUser;
import galen.helpers.tenant.dexter.DexterUserTemplates;
import galen.pages.tenant.dexter.InitialAssessment.DexterPageObj;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class VTP_DEX_FRD_105_Gallbladder_Yes_Flag_ADBU_Navigation extends BaseTest {

    static String OBJECTIVE = "Verify on the Gallbladder screen, if the user answers yes indicating that they do " +
            "currently have or previously had gallbladder disease, the application shall flag for ADBU and " +
            "navigate to the Depression screen.";
    static String NOTES = "The following scenario(s) are verified in this protocol:\n" +
            "•\tSubmitting Yes on Gallbladder screen navigates to the Depression Screen \n" +
            "•\tGallbladder is listed on the ADBU screen\n";
    static String REQUIREMENTS = "DEX_FRD_105";
    static String REFERENCES = "HappyFlow_IA_Initial_Assessment_to_Checkout_wBP_NonSmoker.docx";
    String reportName = "VTP_DEX_FRD_105_Gallbladder_Yes_Flag_ADBU_Navigation";
    ArrayList<String> VERSIONHISTORY = new ArrayList<>();
    HashMap<String, String[]> PREEXECUTION = new HashMap<>();

    VTP_DEX_FRD_105_Gallbladder_Yes_Flag_ADBU_Navigation()  {
        VERSIONHISTORY.add("1.0;20JUN2024;Initial Test Script;Tester");
    }

    @Test
    public void VTP_DEX_FRD_105_Gallbladder_Yes_Flag_ADBU_Navigation_Test() throws Exception {

        report = new GalenReport(driver, reportName, OBJECTIVE, REQUIREMENTS, REFERENCES, NOTES,
                VERSIONHISTORY, PREEXECUTION);
        report.reportTitle = "VTP_DEX_FRD_105 – Gallbladder Yes Flag ADBU and Navigation";
        DexterUser user = new DexterUserTemplates().createHappyFlow_IA_Initial_Assessment_to_Checkout_wBP_NonSmoker();
        DexterPageObj pageObj = new DexterPageObj(driver);

        pageObj.pritUnl.authenticateUserIfRequired(UrlType.DEXTER);
        new DexterHFWrappers(driver).runDexterHFNonsmokingwBP(user, pageObj.gallbladder, report);
        new CommonPageFeatures(driver).clickYesNoNextToPage("Yes", pageObj.depression, report);
        report.addScreenshotStep("Step2_DepressionScreen");

        new DexterHFWrappers(driver).runAntifungalToADBU(user, pageObj.depression, pageObj.adbu, report);
        pageObj.adbu.verifyConditionIsListed(pageObj.adbu.gallBladderCondition, report);
        report.addScreenshotStep("Step5_ADBUScreen");
    }
}
