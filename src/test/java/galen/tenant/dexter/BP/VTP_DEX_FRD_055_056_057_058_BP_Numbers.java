package galen.tenant.dexter.BP;

import galen.base.BaseTest;
import galen.enums.framework.UrlType;
import galen.helpers.common.CommonPageFeatures;
import galen.helpers.common.GalenReport;
import galen.helpers.tenant.dexter.DexterHFWrappers;
import galen.helpers.tenant.dexter.DexterUser;
import galen.helpers.tenant.dexter.DexterUserTemplates;
import galen.pages.tenant.dexter.InitialAssessment.DexterPageObj;
import galen.pages.tenant.dexter.InitialAssessment.EnterBP;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class VTP_DEX_FRD_055_056_057_058_BP_Numbers extends BaseTest {
    static String OBJECTIVE = "Objective";
    static String REQUIREMENTS = "Req";
    static String REFERENCES = "Ref";
    static String NOTES = "Notes";
    String reportName = "VTP_DEX_FRD_055_056_057_058_BP_Numbers";
    ArrayList<String> VERSIONHISTORY = new ArrayList<>();
    HashMap<String, String[]> PREEXECUTION = new HashMap<>();

    VTP_DEX_FRD_055_056_057_058_BP_Numbers()  {
        VERSIONHISTORY.add("1.0;03NOV2022;Initial Test Script;Tester");
    }

    @Test
    public void VTP_DEX_FRD_055_056_057_058_BP_Numbers_Test() throws Exception {

        report = new GalenReport(driver, reportName, OBJECTIVE, REQUIREMENTS, REFERENCES, NOTES,
                VERSIONHISTORY, PREEXECUTION);
        report.reportTitle = "VTP_DEX_FRD_055_056_057_058 – BP Numbers Screen Validation";

        DexterUser user = new DexterUserTemplates().createHappyFlow_IA_Initial_Assessment_to_Checkout_wBP_NonSmoker();
        DexterPageObj pageObj = new DexterPageObj(driver);
        EnterBP bpPage=pageObj.enterBP;
        CommonPageFeatures common = new CommonPageFeatures(driver);


        // Sys 110, Dias 111 to Modal
        pageObj.pritUnl.authenticateUserIfRequired(UrlType.DEXTER);

        user.systolic="110";
        user.diastolic="111";
        new DexterHFWrappers(driver).runDexterHFNonsmokingwBP(user, pageObj.enterBP, report);
        bpPage.enterBP(user, report);
        common.clickNext(report);
        bpPage.verifyModalDisplayed(report);
        report.addScreenshotStep("Step2_Sys_110_Dias_111_Confirm");

        // Sys 0, Dias 0 to Error
        user.systolic="0";
        user.diastolic="0";
        bpPage.clickChangeButton(report);
        bpPage.enterBP(user, report);
        common.clickNext(report);
        bpPage.verifyHasSystolicError(report);
        bpPage.verifyHasDiastolicError(report);
        report.addScreenshotStep("Step4_Sys_0_Dias_0_FieldError");

        // Sys 121, Dias 70 to DNU
        user.systolic="121";
        user.diastolic="70";
        bpPage.enterBPAndProgress(user, pageObj.kickoutPage,report);
        report.addScreenshotStep("Step5_Sys_121_Dias_70_DNU");

        // Sys 110, Dias 81 to DNU
        user.systolic="110";
        user.diastolic="81";
        new DexterHFWrappers(driver).runDexterHFNonsmokingwBP(user, pageObj.enterBP, report);
        bpPage.enterBPAndProgress(user, pageObj.kickoutPage,report);
        report.addScreenshotStep("Step7_Sys_110_Dias_81_DNU");

        // Sys 121, Dias 81 to DNU
        user.systolic="121";
        user.diastolic="81";
        new DexterHFWrappers(driver).runDexterHFNonsmokingwBP(user, pageObj.enterBP, report);
        bpPage.enterBPAndProgress(user, pageObj.kickoutPage,report);
        report.addScreenshotStep("Step9_Sys_121_Dias_81_DNU");

        // Sys 181, Dias 70 to DNU
        user.systolic="181";
        user.diastolic="70";
        new DexterHFWrappers(driver).runDexterHFNonsmokingwBP(user, pageObj.enterBP, report);
        bpPage.enterBPAndProgress(user, pageObj.kickoutPage,report);
        report.addScreenshotStep("Step11_Sys_181_Dias_70_DNU");

        // Sys 180, Dias 70 to DNU
        user.systolic="180";
        user.diastolic="70";
        new DexterHFWrappers(driver).runDexterHFNonsmokingwBP(user, pageObj.enterBP, report);
        bpPage.enterBPAndProgress(user, pageObj.kickoutPage,report);
        report.addScreenshotStep("Step13_Sys_180_Dias_70_DNU");

        // Sys 125, Dias 121 to DNU
        user.systolic="125";
        user.diastolic="121";
        new DexterHFWrappers(driver).runDexterHFNonsmokingwBP(user, pageObj.enterBP, report);
        bpPage.enterBPAndProgress(user, pageObj.kickoutPage,report);
        report.addScreenshotStep("Step15_Sys_125_Dias_121_DNU");

        // Sys 121, Dias 120 to DNU
        user.systolic="121";
        user.diastolic="120";
        new DexterHFWrappers(driver).runDexterHFNonsmokingwBP(user, pageObj.enterBP, report);
        bpPage.enterBPAndProgress(user, pageObj.kickoutPage,report);
        report.addScreenshotStep("Step17_Sys_121_Dias_120_DNU");

        // Sys 181, Dias 121 to DNU
        user.systolic="181";
        user.diastolic="121";
        new DexterHFWrappers(driver).runDexterHFNonsmokingwBP(user, pageObj.enterBP, report);
        bpPage.enterBPAndProgress(user, pageObj.kickoutPage,report);
        report.addScreenshotStep("Step19_Sys_181_Dias_121_DNU");

        // Sys 180, Dias 120 to DNU
        user.systolic="180";
        user.diastolic="120";
        new DexterHFWrappers(driver).runDexterHFNonsmokingwBP(user, pageObj.enterBP, report);
        bpPage.enterBPAndProgress(user, pageObj.kickoutPage,report);
        report.addScreenshotStep("Step21_Sys_180_Dias_120_DNU");

        // Sys 179, Dias 119 to DNU
        user.systolic="179";
        user.diastolic="119";
        new DexterHFWrappers(driver).runDexterHFNonsmokingwBP(user, pageObj.enterBP, report);
        bpPage.enterBPAndProgress(user, pageObj.kickoutPage,report);
        report.addScreenshotStep("Step23_Sys_179_Dias_119_DNU");

        // Sys 120, Dias 80 to Review
        user.systolic="120";
        user.diastolic="80";
        new DexterHFWrappers(driver).runDexterHFNonsmokingwBP(user, pageObj.enterBP, report);
        bpPage.enterBPAndProgress(user, pageObj.review,report);
        report.addScreenshotStep("Step25_Sys_120_Dias_80_Review");
    }
}
