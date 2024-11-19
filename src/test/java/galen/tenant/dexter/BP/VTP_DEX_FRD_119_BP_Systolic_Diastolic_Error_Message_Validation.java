package galen.tenant.dexter.BP;

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

public class VTP_DEX_FRD_119_BP_Systolic_Diastolic_Error_Message_Validation extends BaseTest {
    static String OBJECTIVE = "Objective";
    static String REQUIREMENTS = "Req";
    static String REFERENCES = "Ref";
    static String NOTES = "Notes";
    String reportName = "VTP_DEX_FRD_119_BP_Systolic_Diastolic_Error_Message_Validation";
    ArrayList<String> VERSIONHISTORY = new ArrayList<>();
    HashMap<String, String[]> PREEXECUTION = new HashMap<>();

    VTP_DEX_FRD_119_BP_Systolic_Diastolic_Error_Message_Validation() {
        VERSIONHISTORY.add("1.0;14NOV2022;Initial Test Script ;Tester");
    }

    @Test
    public void VTP_DEX_FRD_119_BP_Systolic_Diastolic_Error_Message_Validation_Test() throws Exception {

        report = new GalenReport(driver, reportName, OBJECTIVE, REQUIREMENTS, REFERENCES, NOTES,
                VERSIONHISTORY, PREEXECUTION);
        report.reportTitle = "VTP_DEX_FRD_119_BP_Systolic_Diastolic_Error_Message_Validation";
        DexterUser user = new DexterUserTemplates().createHappyFlow_IA_Initial_Assessment_to_Checkout_wBP_NonSmoker();
        DexterPageObj pageObj = new DexterPageObj(driver);
        CommonPageFeatures common = new CommonPageFeatures(driver);

        user.systolic = "0";
        user.diastolic = "70";
        pageObj.pritUnl.authenticateUserIfRequired(UrlType.DEXTER);
        new DexterHFWrappers(driver).runDexterHFNonsmokingwBP(user, pageObj.enterBP, report);
        pageObj.enterBP.enterBP(user, report);
        common.clickNext(report);
        pageObj.enterBP.verifyHasSystolicError(report);
        report.addScreenshotStep("Step2_Error_Message_Displayed");

        user.systolic = "120";
        user.diastolic = "0";
        pageObj.enterBP.enterBP(user, report);
        common.clickNext(report);
        pageObj.enterBP.verifyHasDiastolicError(report);
        report.addScreenshotStep("Step3_Error_Message_Displayed");

        user.systolic = "80";
        user.diastolic = "120";
        pageObj.enterBP.enterBP(user, report);
        common.clickNext(report);
        pageObj.enterBP.verifyModalDisplayed(report);
        report.addScreenshotStep("Step4_Confirmation_Modal_Displayed");
    }
}
