package galen.tenant.dexter.HappyFlows;

import galen.base.BaseTest;
import galen.enums.framework.UrlType;
import galen.helpers.common.BasicHelpers;
import galen.helpers.common.CommonPageFeatures;
import galen.helpers.common.GalenReport;
import galen.helpers.tenant.dexter.DexterUser;
import galen.helpers.tenant.dexter.DexterUserTemplates;
import galen.pages.tenant.dexter.InitialAssessment.DexterPageObj;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Thread.sleep;

public class HappyFlow_IA_Initial_Assessment_to_Checkout_wBP_NonSmoker extends BaseTest {
    static String OBJECTIVE = "This Happy Path flow covers the use-case scenario where the user successfully takes the Initial Assessment and completes checkout.\n" +
            "This is intended to provide a reference during testing for a user";
    static String NOTES = "None";
    static String REQUIREMENTS = "None";
    static String REFERENCES = "N/A";
    DexterPageObj pageObj;
    DexterUser user;
    String reportName = "HappyFlow_IA_Initial_Assessment_to_Checkout_wBP_NonSmoker";
    ArrayList<String> VERSIONHISTORY = new ArrayList<>();
    HashMap<String, String[]> PREEXECUTION = new HashMap<>();
    public BasicHelpers bh;

    HappyFlow_IA_Initial_Assessment_to_Checkout_wBP_NonSmoker() throws IOException {
        VERSIONHISTORY.add("1.0;13OCT2022;Initial Test Script; Name Redacted");
        VERSIONHISTORY.add("2.0;19SEP2023;Per CADENCE-359/CADENCE-360: Updated Test Steps navigation for " +
                "restructured cancer flow;Name Redacted");
        VERSIONHISTORY.add("3.0;12JUN2024;Per CADENCE-529: Updated Test Steps for adding verification and\n" +
                "capture screenshot. Also added Test Steps and Post Execution Approvals section\n" +
                "Per CADENCE-549: Removed Checkout related steps\n" +
                "Per CADENCE-569: Update Test Steps to align with new assessment flow and options;" +
                "Name Redacted");
    }

    @Test
    public void HappyFlow_IA_Initial_Assessment_to_Checkout_wBP_NonSmoker_Test() throws IOException, InterruptedException {
        report = new GalenReport(driver, reportName, OBJECTIVE, REQUIREMENTS, REFERENCES, NOTES,
                VERSIONHISTORY, PREEXECUTION);
        report.reportTitle = "HappyFlow_IA_Initial_Assessment_to_Checkout_wBP_NonSmoker";
        bh = new BasicHelpers(driver);
        pageObj = new DexterPageObj(driver);
        user = new DexterUserTemplates().createHappyFlow_IA_Initial_Assessment_to_Checkout_wBP_NonSmoker();
        CommonPageFeatures commonPageFeatures = new CommonPageFeatures(driver);
        pageObj.pritUnl.load(UrlType.DEXTER);

        pageObj.welcomePage.verifyAtPage(report);
        report.addScreenshotStep("Welcome");

        pageObj.welcomePage.clickBegin(report);
        report.addScreenshotStep("Privacy");

        pageObj.privacyPage.clickIAcceptBtnToPage(pageObj.numbers, report);
        report.addScreenshotStep("Numbers");

        pageObj.numbers.clickNextToPage(pageObj.oAuth, report);
        report.addScreenshotStep("Sign In");

        pageObj.oAuth.chooseAccountTypeAndProgress(user, pageObj.usedProduct, report);
        report.addScreenshotStep("HaveUsedProduct");

        pageObj.orderForSelf.clickYesNoNextToModal(user.productUsed, "Tooltip",report);
        pageObj.orderForSelf.clickConfirmModalToPage(pageObj.orderForSelf, report);
        report.addScreenshotStep("ConfirmCustomer");

        commonPageFeatures.clickYesNoNextToPage(user.orderForSelf,pageObj.pregnancy, report);
        report.addScreenshotStep("Prevent Pregnancy");

        commonPageFeatures.clickYesNoNextToPage(user.preventPregnancy,pageObj.menstrual, report);
        report.addScreenshotStep("Menstruation");

        commonPageFeatures.clickYesNoNextToPage(user.menstrualPeriod,pageObj.birthControl, report);
        report.addScreenshotStep("Birth Control");

        commonPageFeatures.clickYesNoNextToPage(user.birthControl,pageObj.smoking, report);
        report.addScreenshotStep("Smoking");

        pageObj.smoking.selectRadioResponseAndProgress(user.smokingType.label, pageObj.everHadCancer,report);
        report.addScreenshotStep("Ever Had Cancer");

        commonPageFeatures.clickYesNoNextToPage(user.everHadCancer, pageObj.bloodPressureMeds,report);
        report.addScreenshotStep("Blood Pressure Meds");

        commonPageFeatures.clickYesNoNextToPage(user.bloodPressureMeds,pageObj.cardiacRisk, report);
        report.addScreenshotStep("Heart Conditions");

        pageObj.cardiacRisk.selectCheckboxesAndProgress(user.chestPainType, pageObj.bloodClot, report);
        report.addScreenshotStep("Blood Clot");

        pageObj.bloodClot.selectCheckboxesAndProgress(user.bloodClot, pageObj.irregularHeartBeat, report);
        report.addScreenshotStep("Irregular Heartbeat");

        commonPageFeatures.clickYesNoNextToPage(user.irregularHeartBeat, pageObj.liverCancer, report);
        report.addScreenshotStep("Liver Cancer");

        pageObj.liverCancer.selectCheckboxesAndProgress(user.liverCancer, pageObj.vaginalBleeding, report);
        report.addScreenshotStep("Vaginal Bleeding");

        pageObj.vaginalBleeding.clickYesNoNextToPage(user.vaginalBleeding,pageObj.diabetes, report);
        report.addScreenshotStep("Diabetes");

        commonPageFeatures.clickYesNoNextToPage(user.diabetes, pageObj.pregnant, report);
        report.addScreenshotStep("Pregnant");

        commonPageFeatures.clickYesNoNextToPage(user.pregnant,pageObj.breastFeeding, report);
        report.addScreenshotStep("Breastfeeding");

        commonPageFeatures.clickYesNoNextToPage(user.breastfeeding,pageObj.pregnancyLoss, report);
        report.addScreenshotStep("Pregnancy Loss");

        commonPageFeatures.clickYesNoNextToPage(user.pregnancyLoss, pageObj.migraines, report);
        report.addScreenshotStep("Migraines");

        commonPageFeatures.clickYesNoNextToPage(user.migraines, pageObj.obesity,report);
        report.addScreenshotStep("Obesity");

        pageObj.obesity.enterHeightAndWeightAndProgress(user, pageObj.ddiCondition, report);
        report.addScreenshotStep("DDI Conditions");

        pageObj.ddiCondition.selectCheckboxesAndProgress(user.conditionType, pageObj.antifungal, report);
        report.addScreenshotStep("Antifungal");

        commonPageFeatures.clickYesNoNextToPage(user.isAntifungal, pageObj.otherMedication, report);
        report.addScreenshotStep("Other Medications");

        pageObj.otherMedication.selectCheckboxesAndProgress(user.otherMedicationType, pageObj.gallbladder, report);
        report.addScreenshotStep("Gall Bladder");

        commonPageFeatures.clickYesNoNextToPage(user.gallbladder, pageObj.depression,report);
        report.addScreenshotStep("Depression");

        commonPageFeatures.clickYesNoNextToPage(user.depression, pageObj.knowBPNumber,report);
        report.addScreenshotStep("KnowBP");

        pageObj.knowBPNumber.clickYesAndOpenModal(report);
        report.addScreenshotStep("VerifyThreeMonths");

        pageObj.knowBPNumber.clickYesNoModalToPage(user.measuredIn3Months, pageObj.enterBP,report);
        report.addScreenshotStep("Enter BP");

        pageObj.enterBP.enterBPAndProgress(user,pageObj.review, report);
        report.addScreenshotStep("Editable Summary");

        pageObj.review.clickConfirmToOpenModal(report);
        report.addScreenshotStep("Confirm Modal");

        pageObj.review.clickFinishToOauth(report);
        report.addScreenshotStep("Sign In");

        pageObj.oAuthPostReview.chooseAccountTypeAndProgress(user, pageObj.purchaseOptions,report);
        report.addScreenshotStep("Purchase Options");
    }
}
