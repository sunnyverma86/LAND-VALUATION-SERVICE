package com.areap2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StampDutyCalculationModel {

	private String acknowledgement;// 1

	private String administrativeBond;// 2

	private String adoptionDeed;// 3

	private String affidavitIncludingAffirmationOfDeclaration;// 4

	// private String agreement;//5

	private String agreementOfConveyance;// 5A

	private String agreementDevelopment;// 5B

	private String agreementOthers;// 5C

	// private String agreementRelatingDawnOrPledge;//6

	private String agreementRelatingDawnOrPledgeExceed;// 6AI

	private String agreementRelatingDawnOrPledgeNotExceed;// 6AII

	private String agreementRelatingDawnOrPledgeExcess;// 6AIII

	private String agreementRelatingDawnOrPledgeThreeMonths;// 6B

	private String appointmentInExecutionOfPowerExceed;// 7
	
	private String appointmentInExecutionOfPowerOther;

	// private String appraisementOrValuation;//8

	private String appraisementOrValuationNotExceed;// 8A

	private String appraisementOrValuationOtherCase;// 8B

	private String apprenticeshipDeed;// 9

	// private String articlesOfAssociationOfCompany;//10

	private String articlesOfAssociationOfCompanyNotExceed;// 10A

	private String articlesOfAssociationOfCompanyAbove;// 10B

	private String articlesOfClerkship;// 11

	// private String award;//12

	private String awardNotExceed;// 12A

	private String awardExceed;// 12B

	private String billOfExchangeWherePayableOtherwise;// 13OR 13B

	private String billOfLading;

	private String bond;// 15

	private String bottomryBond;

	private String cancellation;// 17

	private String certificateOfSale;

	private String certificateOrOtherDocument;// 19

	private String charterParty;// 20 missing 21 in the file

	private String compositionDeed;// 22

	private String saleConveyance;// 23

	private String certifiedCopy;

	private String counterpartOrDuplicateOfAnyInstrument;

	// private String customsBond;//26

	private String customsBondNotExceed;// 26

	private String customsBondOtherCase;// 26

	private String debenture;// 27

	private String debentureEndorsedNotExceed;// 27AI

	private String debentureEndorsedExcess;// 27AII

	private String debentureDeliveryNotExceed;// 27BI

	private String debentureDeliveryExcess;// 27BII

	private String deliveryOrderInRespectofGoods;

	private String divorceDeed;// 29

	// private String entryAsAnAdvocate;//30

	private String entryAsAnAdvocateAdvocate;// 30A

	private String entryAsAnAdvocateAttorney;// 30

	private String exchangeOfProperty;// 31

	// private String futherCharge;//32

	private String futherChargeWithPossession;// 32A

	private String futherChargeWithoutPossession;// 32B

	private String futherChargtPossessionGiven;// 32BI

	private String futherChargePossessionNotGiven;// 32BII

	private String giftDeed;// 33

	private String indemnityBond;// 34

	// private String lease;//35

	private String leaseRentFixed;// 35A

	private String leaseLessThanOneYear;// 35AI

	private String leaseLessThanFiveYear;// 35AII

	private String leaseLessThanTenYear;// 35AIII

	private String leaseLessThanTwentyYear;// 35AIV

	private String leaseLessThanThirtyYear;// 35AV

	private String leaseLessThanHundredYear;// 35AVI

	private String leaseMoreThanHundredYear;// 35AVII

	private String leaseNotDefiniteTerm;// 35AVIII

	private String leaseNoRentReserved;// 35B

	private String leaseAdditionOnRentReserved;// 35C

	private String leaseRevisionNotification;// 35D

	private String letterOfAllotmentOfShares;// 36

	private String letterOfCredit;// 37

	private String letterOfLicence;

	private String memorandumOfAssociationOfCompany;// 39

	// private String mortgage;//40

	private String mortgageWithPossession;// 40A

	private String mortgageWithoutPossession;// 40B

	//private String mortgageOfCrop;// 41
	
	private String mortgageOfCropLessThanThree;// 41A
	
	private String mortgageOfCropMoreThanThree;// 41B

	private String notarialAct;

	private String noteOrMemorandum;// 43

	private String noteOfProtestByTheMasterOfShip;

	private String partitionDeed;// 45

	private String partnerShip;//46A
	
	private String partnerShipDissolution;//46B

	//private String policyOfInsurance;// 47
	
	private String policyOfInsuranceLessThanEighteen;// 47A.1.II
	
	private String policyOfInsuranceOneThousandFiveHundred;// 47A.1.II
	
	private String policyOfInsuranceOneThousand;// 47A.2.III
	
	private String policyOfInsuranceFireInsurance;// 47B.1.I
	
	private String policyOfInsuranceOthers;// 47B.1.II
	
	private String policyOfInsuranceRenewalOriginalPolicy;// 47B.2
	
	private String policyOfInsuranceAccidental;// 47C.A
	
	private String policyOfInsuranceNotExceedOneThousand;// 47C.B
	
	private String policyOfInsuranceIndemnity;// 47C.C
	
	private String policyOfInsuranceLifeInsurance;// 47E.I
	
	private String policyOfInsuranceLessThanFiveHundred;// 47E.II
	
	private String policyOfInsuranceLessThanOneThousand;// 47E.III
	
	private String policyOfInsuranceReInsurance;// 47F

	private String powerOfAttorneySpecial;// 48A
	
	private String powerOfAttorneyGeneral;// 48B

	//private String promissoryNote;// 49
	
	private String promissoryNoteLessThanOneThousand;// 49AI
	
	private String promissoryNoteOtherCases;// 49AII
	
	private String promissoryNoteDemand;// 49B

	private String protestOfBillOrNote;

	private String protestByTheMasterOfShip;// 51

	private String proxy;

	private String receipt;// 53

	private String reconveyanceLessThanOneThousand;//54---recorrect
	
	private String reconveyanceOthers;//54---recorrect

	private String releaseRelinquishmentOfRightLessThanOneThousand;// 55---recorrect
	
	private String releaseRelinquishmentOfRightOthers;// 55---recorrect

	private String respondentiaBond;

	private String securityBond;// 57

	private String settlementInstrument;

	private String shareWarrents;// 59

	private String shippingOrder;// 60

	private String surrenderOfLeaseNotExceesTen;// 61---recorrect
	
	private String surrenderOfLeaseOthers;// 61---recorrect

	//private String transfer;//62
	
	private String transferOfShares;//62A
	
	private String transferOfDebentures;//62B
	
	private String transferSecuredBond;//62C
	
	private String transferMorgageDeed;//62C.I
	
	private String transferOthers;//62C.II
	
	private String transferAdministratorGeneral;//62D
	
	private String transferTrustProperty;//62E

	private String transferofLease;// 63

	//private String trust;
	
	private String trustBeingWill;//64A
	
	private String trustNotBeingWill;//64B

	private String warrentGoods;// 65

	public String getAcknowledgement() {
		return acknowledgement;
	}

	public void setAcknowledgement(String acknowledgement) {
		this.acknowledgement = acknowledgement;
	}

	public String getAdministrativeBond() {
		return administrativeBond;
	}

	public void setAdministrativeBond(String administrativeBond) {
		this.administrativeBond = administrativeBond;
	}

	public String getAdoptionDeed() {
		return adoptionDeed;
	}

	public void setAdoptionDeed(String adoptionDeed) {
		this.adoptionDeed = adoptionDeed;
	}

	public String getAffidavitIncludingAffirmationOfDeclaration() {
		return affidavitIncludingAffirmationOfDeclaration;
	}

	public void setAffidavitIncludingAffirmationOfDeclaration(String affidavitIncludingAffirmationOfDeclaration) {
		this.affidavitIncludingAffirmationOfDeclaration = affidavitIncludingAffirmationOfDeclaration;
	}

	public String getAgreementOfConveyance() {
		return agreementOfConveyance;
	}

	public void setAgreementOfConveyance(String agreementOfConveyance) {
		this.agreementOfConveyance = agreementOfConveyance;
	}

	public String getAgreementDevelopment() {
		return agreementDevelopment;
	}

	public void setAgreementDevelopment(String agreementDevelopment) {
		this.agreementDevelopment = agreementDevelopment;
	}

	public String getAgreementOthers() {
		return agreementOthers;
	}

	public void setAgreementOthers(String agreementOthers) {
		this.agreementOthers = agreementOthers;
	}

	public String getAgreementRelatingDawnOrPledgeExceed() {
		return agreementRelatingDawnOrPledgeExceed;
	}

	public void setAgreementRelatingDawnOrPledgeExceed(String agreementRelatingDawnOrPledgeExceed) {
		this.agreementRelatingDawnOrPledgeExceed = agreementRelatingDawnOrPledgeExceed;
	}

	public String getAgreementRelatingDawnOrPledgeNotExceed() {
		return agreementRelatingDawnOrPledgeNotExceed;
	}

	public void setAgreementRelatingDawnOrPledgeNotExceed(String agreementRelatingDawnOrPledgeNotExceed) {
		this.agreementRelatingDawnOrPledgeNotExceed = agreementRelatingDawnOrPledgeNotExceed;
	}

	public String getAgreementRelatingDawnOrPledgeExcess() {
		return agreementRelatingDawnOrPledgeExcess;
	}

	public void setAgreementRelatingDawnOrPledgeExcess(String agreementRelatingDawnOrPledgeExcess) {
		this.agreementRelatingDawnOrPledgeExcess = agreementRelatingDawnOrPledgeExcess;
	}

	public String getAgreementRelatingDawnOrPledgeThreeMonths() {
		return agreementRelatingDawnOrPledgeThreeMonths;
	}

	public void setAgreementRelatingDawnOrPledgeThreeMonths(String agreementRelatingDawnOrPledgeThreeMonths) {
		this.agreementRelatingDawnOrPledgeThreeMonths = agreementRelatingDawnOrPledgeThreeMonths;
	}

	public String getAppointmentInExecutionOfPowerExceed() {
		return appointmentInExecutionOfPowerExceed;
	}

	public void setAppointmentInExecutionOfPowerExceed(String appointmentInExecutionOfPowerExceed) {
		this.appointmentInExecutionOfPowerExceed = appointmentInExecutionOfPowerExceed;
	}

	public String getAppointmentInExecutionOfPowerOther() {
		return appointmentInExecutionOfPowerOther;
	}

	public void setAppointmentInExecutionOfPowerOther(String appointmentInExecutionOfPowerOther) {
		this.appointmentInExecutionOfPowerOther = appointmentInExecutionOfPowerOther;
	}

	public String getAppraisementOrValuationNotExceed() {
		return appraisementOrValuationNotExceed;
	}

	public void setAppraisementOrValuationNotExceed(String appraisementOrValuationNotExceed) {
		this.appraisementOrValuationNotExceed = appraisementOrValuationNotExceed;
	}

	public String getAppraisementOrValuationOtherCase() {
		return appraisementOrValuationOtherCase;
	}

	public void setAppraisementOrValuationOtherCase(String appraisementOrValuationOtherCase) {
		this.appraisementOrValuationOtherCase = appraisementOrValuationOtherCase;
	}

	public String getApprenticeshipDeed() {
		return apprenticeshipDeed;
	}

	public void setApprenticeshipDeed(String apprenticeshipDeed) {
		this.apprenticeshipDeed = apprenticeshipDeed;
	}

	public String getArticlesOfAssociationOfCompanyNotExceed() {
		return articlesOfAssociationOfCompanyNotExceed;
	}

	public void setArticlesOfAssociationOfCompanyNotExceed(String articlesOfAssociationOfCompanyNotExceed) {
		this.articlesOfAssociationOfCompanyNotExceed = articlesOfAssociationOfCompanyNotExceed;
	}

	public String getArticlesOfAssociationOfCompanyAbove() {
		return articlesOfAssociationOfCompanyAbove;
	}

	public void setArticlesOfAssociationOfCompanyAbove(String articlesOfAssociationOfCompanyAbove) {
		this.articlesOfAssociationOfCompanyAbove = articlesOfAssociationOfCompanyAbove;
	}

	public String getArticlesOfClerkship() {
		return articlesOfClerkship;
	}

	public void setArticlesOfClerkship(String articlesOfClerkship) {
		this.articlesOfClerkship = articlesOfClerkship;
	}

	public String getAwardNotExceed() {
		return awardNotExceed;
	}

	public void setAwardNotExceed(String awardNotExceed) {
		this.awardNotExceed = awardNotExceed;
	}

	public String getAwardExceed() {
		return awardExceed;
	}

	public void setAwardExceed(String awardExceed) {
		this.awardExceed = awardExceed;
	}

	public String getBillOfExchangeWherePayableOtherwise() {
		return billOfExchangeWherePayableOtherwise;
	}

	public void setBillOfExchangeWherePayableOtherwise(String billOfExchangeWherePayableOtherwise) {
		this.billOfExchangeWherePayableOtherwise = billOfExchangeWherePayableOtherwise;
	}

	public String getBillOfLading() {
		return billOfLading;
	}

	public void setBillOfLading(String billOfLading) {
		this.billOfLading = billOfLading;
	}

	public String getBond() {
		return bond;
	}

	public void setBond(String bond) {
		this.bond = bond;
	}

	public String getBottomryBond() {
		return bottomryBond;
	}

	public void setBottomryBond(String bottomryBond) {
		this.bottomryBond = bottomryBond;
	}

	public String getCancellation() {
		return cancellation;
	}

	public void setCancellation(String cancellation) {
		this.cancellation = cancellation;
	}

	public String getCertificateOfSale() {
		return certificateOfSale;
	}

	public void setCertificateOfSale(String certificateOfSale) {
		this.certificateOfSale = certificateOfSale;
	}

	public String getCertificateOrOtherDocument() {
		return certificateOrOtherDocument;
	}

	public void setCertificateOrOtherDocument(String certificateOrOtherDocument) {
		this.certificateOrOtherDocument = certificateOrOtherDocument;
	}

	public String getCharterParty() {
		return charterParty;
	}

	public void setCharterParty(String charterParty) {
		this.charterParty = charterParty;
	}

	public String getCompositionDeed() {
		return compositionDeed;
	}

	public void setCompositionDeed(String compositionDeed) {
		this.compositionDeed = compositionDeed;
	}

	public String getSaleConveyance() {
		return saleConveyance;
	}

	public void setSaleConveyance(String saleConveyance) {
		this.saleConveyance = saleConveyance;
	}

	public String getCertifiedCopy() {
		return certifiedCopy;
	}

	public void setCertifiedCopy(String certifiedCopy) {
		this.certifiedCopy = certifiedCopy;
	}

	public String getCounterpartOrDuplicateOfAnyInstrument() {
		return counterpartOrDuplicateOfAnyInstrument;
	}

	public void setCounterpartOrDuplicateOfAnyInstrument(String counterpartOrDuplicateOfAnyInstrument) {
		this.counterpartOrDuplicateOfAnyInstrument = counterpartOrDuplicateOfAnyInstrument;
	}

	public String getCustomsBondNotExceed() {
		return customsBondNotExceed;
	}

	public void setCustomsBondNotExceed(String customsBondNotExceed) {
		this.customsBondNotExceed = customsBondNotExceed;
	}

	public String getCustomsBondOtherCase() {
		return customsBondOtherCase;
	}

	public void setCustomsBondOtherCase(String customsBondOtherCase) {
		this.customsBondOtherCase = customsBondOtherCase;
	}

	public String getDebenture() {
		return debenture;
	}

	public void setDebenture(String debenture) {
		this.debenture = debenture;
	}

	public String getDebentureEndorsedNotExceed() {
		return debentureEndorsedNotExceed;
	}

	public void setDebentureEndorsedNotExceed(String debentureEndorsedNotExceed) {
		this.debentureEndorsedNotExceed = debentureEndorsedNotExceed;
	}

	public String getDebentureEndorsedExcess() {
		return debentureEndorsedExcess;
	}

	public void setDebentureEndorsedExcess(String debentureEndorsedExcess) {
		this.debentureEndorsedExcess = debentureEndorsedExcess;
	}

	public String getDebentureDeliveryNotExceed() {
		return debentureDeliveryNotExceed;
	}

	public void setDebentureDeliveryNotExceed(String debentureDeliveryNotExceed) {
		this.debentureDeliveryNotExceed = debentureDeliveryNotExceed;
	}

	public String getDebentureDeliveryExcess() {
		return debentureDeliveryExcess;
	}

	public void setDebentureDeliveryExcess(String debentureDeliveryExcess) {
		this.debentureDeliveryExcess = debentureDeliveryExcess;
	}

	public String getDeliveryOrderInRespectofGoods() {
		return deliveryOrderInRespectofGoods;
	}

	public void setDeliveryOrderInRespectofGoods(String deliveryOrderInRespectofGoods) {
		this.deliveryOrderInRespectofGoods = deliveryOrderInRespectofGoods;
	}

	public String getDivorceDeed() {
		return divorceDeed;
	}

	public void setDivorceDeed(String divorceDeed) {
		this.divorceDeed = divorceDeed;
	}

	public String getEntryAsAnAdvocateAdvocate() {
		return entryAsAnAdvocateAdvocate;
	}

	public void setEntryAsAnAdvocateAdvocate(String entryAsAnAdvocateAdvocate) {
		this.entryAsAnAdvocateAdvocate = entryAsAnAdvocateAdvocate;
	}

	public String getEntryAsAnAdvocateAttorney() {
		return entryAsAnAdvocateAttorney;
	}

	public void setEntryAsAnAdvocateAttorney(String entryAsAnAdvocateAttorney) {
		this.entryAsAnAdvocateAttorney = entryAsAnAdvocateAttorney;
	}

	public String getExchangeOfProperty() {
		return exchangeOfProperty;
	}

	public void setExchangeOfProperty(String exchangeOfProperty) {
		this.exchangeOfProperty = exchangeOfProperty;
	}

	public String getFutherChargeWithPossession() {
		return futherChargeWithPossession;
	}

	public void setFutherChargeWithPossession(String futherChargeWithPossession) {
		this.futherChargeWithPossession = futherChargeWithPossession;
	}

	public String getFutherChargeWithoutPossession() {
		return futherChargeWithoutPossession;
	}

	public void setFutherChargeWithoutPossession(String futherChargeWithoutPossession) {
		this.futherChargeWithoutPossession = futherChargeWithoutPossession;
	}

	public String getFutherChargtPossessionGiven() {
		return futherChargtPossessionGiven;
	}

	public void setFutherChargtPossessionGiven(String futherChargtPossessionGiven) {
		this.futherChargtPossessionGiven = futherChargtPossessionGiven;
	}

	public String getFutherChargePossessionNotGiven() {
		return futherChargePossessionNotGiven;
	}

	public void setFutherChargePossessionNotGiven(String futherChargePossessionNotGiven) {
		this.futherChargePossessionNotGiven = futherChargePossessionNotGiven;
	}

	public String getGiftDeed() {
		return giftDeed;
	}

	public void setGiftDeed(String giftDeed) {
		this.giftDeed = giftDeed;
	}

	public String getIndemnityBond() {
		return indemnityBond;
	}

	public void setIndemnityBond(String indemnityBond) {
		this.indemnityBond = indemnityBond;
	}

	public String getLeaseRentFixed() {
		return leaseRentFixed;
	}

	public void setLeaseRentFixed(String leaseRentFixed) {
		this.leaseRentFixed = leaseRentFixed;
	}

	public String getLeaseLessThanOneYear() {
		return leaseLessThanOneYear;
	}

	public void setLeaseLessThanOneYear(String leaseLessThanOneYear) {
		this.leaseLessThanOneYear = leaseLessThanOneYear;
	}

	public String getLeaseLessThanFiveYear() {
		return leaseLessThanFiveYear;
	}

	public void setLeaseLessThanFiveYear(String leaseLessThanFiveYear) {
		this.leaseLessThanFiveYear = leaseLessThanFiveYear;
	}

	public String getLeaseLessThanTenYear() {
		return leaseLessThanTenYear;
	}

	public void setLeaseLessThanTenYear(String leaseLessThanTenYear) {
		this.leaseLessThanTenYear = leaseLessThanTenYear;
	}

	public String getLeaseLessThanTwentyYear() {
		return leaseLessThanTwentyYear;
	}

	public void setLeaseLessThanTwentyYear(String leaseLessThanTwentyYear) {
		this.leaseLessThanTwentyYear = leaseLessThanTwentyYear;
	}

	public String getLeaseLessThanThirtyYear() {
		return leaseLessThanThirtyYear;
	}

	public void setLeaseLessThanThirtyYear(String leaseLessThanThirtyYear) {
		this.leaseLessThanThirtyYear = leaseLessThanThirtyYear;
	}

	public String getLeaseLessThanHundredYear() {
		return leaseLessThanHundredYear;
	}

	public void setLeaseLessThanHundredYear(String leaseLessThanHundredYear) {
		this.leaseLessThanHundredYear = leaseLessThanHundredYear;
	}

	public String getLeaseMoreThanHundredYear() {
		return leaseMoreThanHundredYear;
	}

	public void setLeaseMoreThanHundredYear(String leaseMoreThanHundredYear) {
		this.leaseMoreThanHundredYear = leaseMoreThanHundredYear;
	}

	public String getLeaseNotDefiniteTerm() {
		return leaseNotDefiniteTerm;
	}

	public void setLeaseNotDefiniteTerm(String leaseNotDefiniteTerm) {
		this.leaseNotDefiniteTerm = leaseNotDefiniteTerm;
	}

	public String getLeaseNoRentReserved() {
		return leaseNoRentReserved;
	}

	public void setLeaseNoRentReserved(String leaseNoRentReserved) {
		this.leaseNoRentReserved = leaseNoRentReserved;
	}

	public String getLeaseAdditionOnRentReserved() {
		return leaseAdditionOnRentReserved;
	}

	public void setLeaseAdditionOnRentReserved(String leaseAdditionOnRentReserved) {
		this.leaseAdditionOnRentReserved = leaseAdditionOnRentReserved;
	}

	public String getLeaseRevisionNotification() {
		return leaseRevisionNotification;
	}

	public void setLeaseRevisionNotification(String leaseRevisionNotification) {
		this.leaseRevisionNotification = leaseRevisionNotification;
	}

	public String getLetterOfAllotmentOfShares() {
		return letterOfAllotmentOfShares;
	}

	public void setLetterOfAllotmentOfShares(String letterOfAllotmentOfShares) {
		this.letterOfAllotmentOfShares = letterOfAllotmentOfShares;
	}

	public String getLetterOfCredit() {
		return letterOfCredit;
	}

	public void setLetterOfCredit(String letterOfCredit) {
		this.letterOfCredit = letterOfCredit;
	}

	public String getLetterOfLicence() {
		return letterOfLicence;
	}

	public void setLetterOfLicence(String letterOfLicence) {
		this.letterOfLicence = letterOfLicence;
	}

	public String getMemorandumOfAssociationOfCompany() {
		return memorandumOfAssociationOfCompany;
	}

	public void setMemorandumOfAssociationOfCompany(String memorandumOfAssociationOfCompany) {
		this.memorandumOfAssociationOfCompany = memorandumOfAssociationOfCompany;
	}

	public String getMortgageWithPossession() {
		return mortgageWithPossession;
	}

	public void setMortgageWithPossession(String mortgageWithPossession) {
		this.mortgageWithPossession = mortgageWithPossession;
	}

	public String getMortgageWithoutPossession() {
		return mortgageWithoutPossession;
	}

	public void setMortgageWithoutPossession(String mortgageWithoutPossession) {
		this.mortgageWithoutPossession = mortgageWithoutPossession;
	}

	public String getMortgageOfCropLessThanThree() {
		return mortgageOfCropLessThanThree;
	}

	public void setMortgageOfCropLessThanThree(String mortgageOfCropLessThanThree) {
		this.mortgageOfCropLessThanThree = mortgageOfCropLessThanThree;
	}

	public String getMortgageOfCropMoreThanThree() {
		return mortgageOfCropMoreThanThree;
	}

	public void setMortgageOfCropMoreThanThree(String mortgageOfCropMoreThanThree) {
		this.mortgageOfCropMoreThanThree = mortgageOfCropMoreThanThree;
	}

	public String getNotarialAct() {
		return notarialAct;
	}

	public void setNotarialAct(String notarialAct) {
		this.notarialAct = notarialAct;
	}

	public String getNoteOrMemorandum() {
		return noteOrMemorandum;
	}

	public void setNoteOrMemorandum(String noteOrMemorandum) {
		this.noteOrMemorandum = noteOrMemorandum;
	}

	public String getNoteOfProtestByTheMasterOfShip() {
		return noteOfProtestByTheMasterOfShip;
	}

	public void setNoteOfProtestByTheMasterOfShip(String noteOfProtestByTheMasterOfShip) {
		this.noteOfProtestByTheMasterOfShip = noteOfProtestByTheMasterOfShip;
	}

	public String getPartitionDeed() {
		return partitionDeed;
	}

	public void setPartitionDeed(String partitionDeed) {
		this.partitionDeed = partitionDeed;
	}

	public String getPartnerShip() {
		return partnerShip;
	}

	public void setPartnerShip(String partnerShip) {
		this.partnerShip = partnerShip;
	}

	public String getPartnerShipDissolution() {
		return partnerShipDissolution;
	}

	public void setPartnerShipDissolution(String partnerShipDissolution) {
		this.partnerShipDissolution = partnerShipDissolution;
	}

	public String getPolicyOfInsuranceLessThanEighteen() {
		return policyOfInsuranceLessThanEighteen;
	}

	public void setPolicyOfInsuranceLessThanEighteen(String policyOfInsuranceLessThanEighteen) {
		this.policyOfInsuranceLessThanEighteen = policyOfInsuranceLessThanEighteen;
	}

	public String getPolicyOfInsuranceOneThousandFiveHundred() {
		return policyOfInsuranceOneThousandFiveHundred;
	}

	public void setPolicyOfInsuranceOneThousandFiveHundred(String policyOfInsuranceOneThousandFiveHundred) {
		this.policyOfInsuranceOneThousandFiveHundred = policyOfInsuranceOneThousandFiveHundred;
	}

	public String getPolicyOfInsuranceOneThousand() {
		return policyOfInsuranceOneThousand;
	}

	public void setPolicyOfInsuranceOneThousand(String policyOfInsuranceOneThousand) {
		this.policyOfInsuranceOneThousand = policyOfInsuranceOneThousand;
	}

	public String getPolicyOfInsuranceFireInsurance() {
		return policyOfInsuranceFireInsurance;
	}

	public void setPolicyOfInsuranceFireInsurance(String policyOfInsuranceFireInsurance) {
		this.policyOfInsuranceFireInsurance = policyOfInsuranceFireInsurance;
	}

	public String getPolicyOfInsuranceOthers() {
		return policyOfInsuranceOthers;
	}

	public void setPolicyOfInsuranceOthers(String policyOfInsuranceOthers) {
		this.policyOfInsuranceOthers = policyOfInsuranceOthers;
	}

	public String getPolicyOfInsuranceRenewalOriginalPolicy() {
		return policyOfInsuranceRenewalOriginalPolicy;
	}

	public void setPolicyOfInsuranceRenewalOriginalPolicy(String policyOfInsuranceRenewalOriginalPolicy) {
		this.policyOfInsuranceRenewalOriginalPolicy = policyOfInsuranceRenewalOriginalPolicy;
	}

	public String getPolicyOfInsuranceAccidental() {
		return policyOfInsuranceAccidental;
	}

	public void setPolicyOfInsuranceAccidental(String policyOfInsuranceAccidental) {
		this.policyOfInsuranceAccidental = policyOfInsuranceAccidental;
	}

	public String getPolicyOfInsuranceNotExceedOneThousand() {
		return policyOfInsuranceNotExceedOneThousand;
	}

	public void setPolicyOfInsuranceNotExceedOneThousand(String policyOfInsuranceNotExceedOneThousand) {
		this.policyOfInsuranceNotExceedOneThousand = policyOfInsuranceNotExceedOneThousand;
	}

	public String getPolicyOfInsuranceIndemnity() {
		return policyOfInsuranceIndemnity;
	}

	public void setPolicyOfInsuranceIndemnity(String policyOfInsuranceIndemnity) {
		this.policyOfInsuranceIndemnity = policyOfInsuranceIndemnity;
	}

	public String getPolicyOfInsuranceLifeInsurance() {
		return policyOfInsuranceLifeInsurance;
	}

	public void setPolicyOfInsuranceLifeInsurance(String policyOfInsuranceLifeInsurance) {
		this.policyOfInsuranceLifeInsurance = policyOfInsuranceLifeInsurance;
	}

	public String getPolicyOfInsuranceLessThanFiveHundred() {
		return policyOfInsuranceLessThanFiveHundred;
	}

	public void setPolicyOfInsuranceLessThanFiveHundred(String policyOfInsuranceLessThanFiveHundred) {
		this.policyOfInsuranceLessThanFiveHundred = policyOfInsuranceLessThanFiveHundred;
	}

	public String getPolicyOfInsuranceLessThanOneThousand() {
		return policyOfInsuranceLessThanOneThousand;
	}

	public void setPolicyOfInsuranceLessThanOneThousand(String policyOfInsuranceLessThanOneThousand) {
		this.policyOfInsuranceLessThanOneThousand = policyOfInsuranceLessThanOneThousand;
	}

	public String getPolicyOfInsuranceReInsurance() {
		return policyOfInsuranceReInsurance;
	}

	public void setPolicyOfInsuranceReInsurance(String policyOfInsuranceReInsurance) {
		this.policyOfInsuranceReInsurance = policyOfInsuranceReInsurance;
	}

	public String getPowerOfAttorneySpecial() {
		return powerOfAttorneySpecial;
	}

	public void setPowerOfAttorneySpecial(String powerOfAttorneySpecial) {
		this.powerOfAttorneySpecial = powerOfAttorneySpecial;
	}

	public String getPowerOfAttorneyGeneral() {
		return powerOfAttorneyGeneral;
	}

	public void setPowerOfAttorneyGeneral(String powerOfAttorneyGeneral) {
		this.powerOfAttorneyGeneral = powerOfAttorneyGeneral;
	}

	public String getPromissoryNoteLessThanOneThousand() {
		return promissoryNoteLessThanOneThousand;
	}

	public void setPromissoryNoteLessThanOneThousand(String promissoryNoteLessThanOneThousand) {
		this.promissoryNoteLessThanOneThousand = promissoryNoteLessThanOneThousand;
	}

	public String getPromissoryNoteOtherCases() {
		return promissoryNoteOtherCases;
	}

	public void setPromissoryNoteOtherCases(String promissoryNoteOtherCases) {
		this.promissoryNoteOtherCases = promissoryNoteOtherCases;
	}

	public String getPromissoryNoteDemand() {
		return promissoryNoteDemand;
	}

	public void setPromissoryNoteDemand(String promissoryNoteDemand) {
		this.promissoryNoteDemand = promissoryNoteDemand;
	}

	public String getProtestOfBillOrNote() {
		return protestOfBillOrNote;
	}

	public void setProtestOfBillOrNote(String protestOfBillOrNote) {
		this.protestOfBillOrNote = protestOfBillOrNote;
	}

	public String getProtestByTheMasterOfShip() {
		return protestByTheMasterOfShip;
	}

	public void setProtestByTheMasterOfShip(String protestByTheMasterOfShip) {
		this.protestByTheMasterOfShip = protestByTheMasterOfShip;
	}

	public String getProxy() {
		return proxy;
	}

	public void setProxy(String proxy) {
		this.proxy = proxy;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public String getReconveyanceLessThanOneThousand() {
		return reconveyanceLessThanOneThousand;
	}

	public void setReconveyanceLessThanOneThousand(String reconveyanceLessThanOneThousand) {
		this.reconveyanceLessThanOneThousand = reconveyanceLessThanOneThousand;
	}

	public String getReconveyanceOthers() {
		return reconveyanceOthers;
	}

	public void setReconveyanceOthers(String reconveyanceOthers) {
		this.reconveyanceOthers = reconveyanceOthers;
	}

	public String getReleaseRelinquishmentOfRightLessThanOneThousand() {
		return releaseRelinquishmentOfRightLessThanOneThousand;
	}

	public void setReleaseRelinquishmentOfRightLessThanOneThousand(String releaseRelinquishmentOfRightLessThanOneThousand) {
		this.releaseRelinquishmentOfRightLessThanOneThousand = releaseRelinquishmentOfRightLessThanOneThousand;
	}

	public String getReleaseRelinquishmentOfRightOthers() {
		return releaseRelinquishmentOfRightOthers;
	}

	public void setReleaseRelinquishmentOfRightOthers(String releaseRelinquishmentOfRightOthers) {
		this.releaseRelinquishmentOfRightOthers = releaseRelinquishmentOfRightOthers;
	}

	public String getRespondentiaBond() {
		return respondentiaBond;
	}

	public void setRespondentiaBond(String respondentiaBond) {
		this.respondentiaBond = respondentiaBond;
	}

	public String getSecurityBond() {
		return securityBond;
	}

	public void setSecurityBond(String securityBond) {
		this.securityBond = securityBond;
	}

	public String getSettlementInstrument() {
		return settlementInstrument;
	}

	public void setSettlementInstrument(String settlementInstrument) {
		this.settlementInstrument = settlementInstrument;
	}

	public String getShareWarrents() {
		return shareWarrents;
	}

	public void setShareWarrents(String shareWarrents) {
		this.shareWarrents = shareWarrents;
	}

	public String getShippingOrder() {
		return shippingOrder;
	}

	public void setShippingOrder(String shippingOrder) {
		this.shippingOrder = shippingOrder;
	}

	public String getSurrenderOfLeaseNotExceesTen() {
		return surrenderOfLeaseNotExceesTen;
	}

	public void setSurrenderOfLeaseNotExceesTen(String surrenderOfLeaseNotExceesTen) {
		this.surrenderOfLeaseNotExceesTen = surrenderOfLeaseNotExceesTen;
	}

	public String getSurrenderOfLeaseOthers() {
		return surrenderOfLeaseOthers;
	}

	public void setSurrenderOfLeaseOthers(String surrenderOfLeaseOthers) {
		this.surrenderOfLeaseOthers = surrenderOfLeaseOthers;
	}

	public String getTransferOfShares() {
		return transferOfShares;
	}

	public void setTransferOfShares(String transferOfShares) {
		this.transferOfShares = transferOfShares;
	}

	public String getTransferOfDebentures() {
		return transferOfDebentures;
	}

	public void setTransferOfDebentures(String transferOfDebentures) {
		this.transferOfDebentures = transferOfDebentures;
	}

	public String getTransferSecuredBond() {
		return transferSecuredBond;
	}

	public void setTransferSecuredBond(String transferSecuredBond) {
		this.transferSecuredBond = transferSecuredBond;
	}

	public String getTransferMorgageDeed() {
		return transferMorgageDeed;
	}

	public void setTransferMorgageDeed(String transferMorgageDeed) {
		this.transferMorgageDeed = transferMorgageDeed;
	}

	public String getTransferOthers() {
		return transferOthers;
	}

	public void setTransferOthers(String transferOthers) {
		this.transferOthers = transferOthers;
	}

	public String getTransferAdministratorGeneral() {
		return transferAdministratorGeneral;
	}

	public void setTransferAdministratorGeneral(String transferAdministratorGeneral) {
		this.transferAdministratorGeneral = transferAdministratorGeneral;
	}

	public String getTransferTrustProperty() {
		return transferTrustProperty;
	}

	public void setTransferTrustProperty(String transferTrustProperty) {
		this.transferTrustProperty = transferTrustProperty;
	}

	public String getTransferofLease() {
		return transferofLease;
	}

	public void setTransferofLease(String transferofLease) {
		this.transferofLease = transferofLease;
	}

	public String getTrustBeingWill() {
		return trustBeingWill;
	}

	public void setTrustBeingWill(String trustBeingWill) {
		this.trustBeingWill = trustBeingWill;
	}

	public String getTrustNotBeingWill() {
		return trustNotBeingWill;
	}

	public void setTrustNotBeingWill(String trustNotBeingWill) {
		this.trustNotBeingWill = trustNotBeingWill;
	}

	public String getWarrentGoods() {
		return warrentGoods;
	}

	public void setWarrentGoods(String warrentGoods) {
		this.warrentGoods = warrentGoods;
	}
	
	
	
	
}