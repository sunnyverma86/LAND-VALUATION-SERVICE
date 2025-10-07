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
}