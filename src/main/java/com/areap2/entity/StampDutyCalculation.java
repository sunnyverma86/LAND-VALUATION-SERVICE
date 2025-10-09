package com.areap2.entity;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "areap2_stamp_duty_calculation", schema = "areap2landvaluation")
@NamedQuery(name = "StampDutyCalculation.findAll", query = "SELECT a FROM StampDutyCalculation a")
public class StampDutyCalculation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "areap2_stamp_duty_calculation_gen_id_seq", sequenceName = "areap2_stamp_duty_calculation_gen_id_seq", allocationSize = 1, schema = "areap2landvaluation")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "areap2_stamp_duty_calculation_gen_id_seq")
	@Column(name = "stamp_duty_calculation_gen_id")
	private Long StDutyCalculationGenId;

//	private String acknowledgement;// 1
//
//	private String administrativeBond;// 2
//
//	private String adoptionDeed;// 3
//
//	private String affidavitIncAffOfDeclaration;// 4
//
//	// private String agreement;//5
//
//	private String agreementOfConveyance;// 5A
//
//	private String agreementDevelopment;// 5B
//
//	private String agreementOts;// 5C
//
//	// private String agreementRelatingDawnOrPledge;//6
//
//	private String agreementRelatingDawnOrPledgeExceedLessThanOneThousand;// 6AI
//
//	private String agreementRelatingDawnOrPledgeExceedLessThanTenThousand;// 6AII
//
//	private String agreementRelatingDawnOrPledgeExceedMoreThanTenThousand;// 6AIII
//
//	private String agreementRelatingDawnOrPledgeThreeMonths;// 6B
//
//	private String appointmentInExecutionOfPwr;// 7
//
//	// private String appraisementOrVal;//8
//
//	private String appraisementOrValNotExceed;// 8A
//
//	private String appraisementOrValOtCase;// 8B
//
//	private String apprenticeshipDeed;// 9
//
//	// private String articlesOfAssoOfCompany;//10
//
//	private String articlesOfAssoOfCompanyNotExceed;// 10A
//
//	private String articlesOfAssoOfCompanyAbove;// 10B
//
//	private String articlesOfClerkship;// 11
//
//	// private String award;//12
//
//	private String awardNotExceed;// 12A
//
//	private String awardExceed;// 12B
//
//	private String billOfExchangeWherePayableOtwise;// 13OR 13B
//
//	private String billOfLading;
//
//	private String bond;// 15
//
//	private String bottomryBond;
//
//	private String cancellation;// 17
//
//	private String certificateOfSale;
//
//	private String certificateOrOtDocument;// 19
//
//	private String charterParty;// 20 missing 21 in the file
//
//	private String compositionDeed;// 22
//
//	private String saleConveyance;// 23
//
//	private String certifiedCopy;
//
//	private String counterpartOrDuplicateOfAnyInstrument;
//
//	// private String customsBond;//26
//
//	private String customsBondNotExceed;// 26
//
//	private String customsBondOtCase;// 26
//
//	private String debenture;// 27
//
//	private String debentureEndorsedNotExceed;// 27AI
//
//	private String debentureEndorsedExcess;// 27AII
//
//	private String debentureDeliveryNotExceed;// 27BI
//
//	private String debentureDeliveryExcess;// 27BII
//
//	private String deliveryOrderInRespectofGoods;
//
//	private String divorceDeed;// 29
//
//	// private String entryAsAnAdvocate;//30
//
//	private String entryAsAnAdvocateAdvocate;// 30A
//
//	private String entryAsAnAdvocateAttorney;// 30
//
//	private String exchangeOfProperty;// 31
//
//	// private String futherCharge;//32
//
//	private String futherChargeWithPossession;// 32A
//
//	private String futherChargeWithoutPossession;// 32B
//
//	private String futherChargtPossessionGiven;// 32BI
//
//	private String futherChargePossessionNotGiven;// 32BII
//
//	private String giftDeed;// 33
//
//	private String indemnityBond;// 34
//
//	// private String lease;//35
//
//	private String leaseRentFixed;// 35A
//
//	private String leaseLessThanOneYear;// 35AI
//
//	private String leaseLessThanFiveYear;// 35AII
//
//	private String leaseLessThanTenYear;// 35AIII
//
//	private String leaseLessThanTwentyYear;// 35AIV
//
//	private String leaseLessThanThirtyYear;// 35AV
//
//	private String leaseLessThanHundredYear;// 35AVI
//
//	private String leaseMoreThanHundredYear;// 35AVII
//
//	private String leaseNotDefiniteTerm;// 35AVIII
//
//	private String leaseNoRentReserved;// 35B
//
//	private String leaseAdditionOnRentReserved;// 35C
//
//	private String leaseRevisionNotification;// 35D
//
//	private String letterOfAllotmentOfShares;// 36
//
//	private String letterOfCredit;// 37
//
//	private String letterOfLicence;
//
//	private String memorandumOfAssoOfCompany;// 39
//
//	// private String mortgage;//40
//
//	private String mortgageWithPossession;// 40A
//
//	private String mortgageWithoutPossession;// 40B
//
//	// private String mortgageOfCrop;// 41
//
//	private String mortgageOfCropLessThanThree;// 41A
//
//	private String mortgageOfCropMoreThanThree;// 41B
//
//	private String notarialAct;
//
//	private String noteOrMemorandum;// 43
//
//	private String noteOfProtestByTheMasterOfShip;
//
//	private String partitionDeed;// 45
//
//	private String partnerShip;// 46A
//
//	private String partnerShipDissolution;// 46B
//
//	// private String policyOfIns;// 47
//
//	private String policyOfInsLessThanEighteen;// 47A.1.II
//
//	private String policyOfInsOneThousandFiveHundred;// 47A.1.II
//
//	private String policyOfInsOneThousand;// 47A.2.III
//
//	private String policyOfInsFireIns;// 47B.1.I
//
//	private String policyOfInsOts;// 47B.1.II
//
//	private String policyOfInsRenewalOriginalPol;// 47B.2
//
//	private String policyOfInsAccidental;// 47C.A
//
//	private String policyOfInsNotExceedOneThousand;// 47C.B
//
//	private String policyOfInsIndemnity;// 47C.C
//
//	private String policyOfInsLifeIns;// 47E.I
//
//	private String policyOfInsLessThanFiveHundred;// 47E.II
//
//	private String policyOfInsLessThanOneThousand;// 47E.III
//
//	private String policyOfInsReIns;// 47F
//
//	private String powerOfAttorneySpecial;// 48A
//
//	private String powerOfAttorneyGeneral;// 48B
//
//	// private String promissoryNote;// 49
//
//	private String promissoryNoteLessThanOneThousand;// 49AI
//
//	private String promissoryNoteOtCases;// 49AII
//
//	private String promissoryNoteDemand;// 49B
//
//	private String protestOfBillOrNote;
//
//	private String protestByTheMasterOfShip;// 51
//
//	private String proxy;
//
//	private String receipt;// 53
//
//	private String reconveyanceLessThanOneThousand;// 54---recorrect
//
//	private String reconveyanceOts;// 54---recorrect
//
//	private String releaseRelinquishmentOfRightLessThanOneThousand;// 55---recorrect
//
//	private String releaseRelinquishmentOfRightOts;// 55---recorrect
//
//	private String respondentiaBond;
//
//	private String securityBond;// 57
//
//	private String settlementInstrument;
//
//	private String shareWarrents;// 59
//
//	private String shippingOrder;// 60
//
//	private String surrenderOfLeaseNotExceesTen;// 61---recorrect
//
//	private String surrenderOfLeaseOts;// 61---recorrect
//
//	// private String transfer;//62
//
//	private String transferOfShares;// 62A
//
//	private String transferOfDebentures;// 62B
//
//	private String transferSecuredBond;// 62C
//
//	private String transferMorgageDeed;// 62C.I
//
//	private String transferOts;// 62C.II
//
//	private String transferAdministratorGeneral;// 62D
//
//	private String transferTrustProperty;// 62E
//
//	private String transferofLease;// 63
//
//	// private String trust;
//
//	private String trustBeingWill;// 64A
//
//	private String trustNotBeingWill;// 64B
//
//	private String warrentGoods;// 65

	private String maleStAcknowledgement;// 1

	private String maleStAdministrativeBond;// 2

	private String maleStAdoptionDeed;// 3

	private String maleStAffidavitIncAffOfDeclaration;// 4

	// private String maleStAgreement;//5

	private String maleStAgreementOfConveyance;// 5A

	private String maleStAgreementDevelopment;// 5B

	private String maleStAgreementOts;// 5C

	// private String maleStAgreeRelatDawnOrPledge;//6

	private String maleStAgreeRelatDawnOrPledgeExceedLessThanOneThousand;// 6AI

	private String maleStAgreeRelatDawnOrPledgeExceedLessThanTenThousand;// 6AII

	private String maleStAgreeRelatDawnOrPledgeExceedMoreThanTenThousand;// 6AIII

	private String maleStAgreeRelatDawnOrPledgeThreeMonths;// 6B

	private String maleStAppointmentInExecutionOfPwr;// 7

	// private String maleStAppOrVal;//8

	private String maleStAppOrValNotExceed;// 8A

	private String maleStAppOrValOtCase;// 8B

	private String maleStApprenticeshipDeed;// 9

	// private String maleStArtsOfAssoOfCompany;//10

	private String maleStArtsOfAssoOfCompanyNotExceed;// 10A

	private String maleStArtsOfAssoOfCompanyAbove;// 10B

	private String maleStArtsOfClerkship;// 11

	// private String maleStAward;//12

	private String maleStAwardNotExceed;// 12A

	private String maleStAwardExceed;// 12B

	private String maleStBillOfExchangeWherePayableOtwise;// 13OR 13B

	private String maleStBillOfLading;

	private String maleStBond;// 15

	private String maleStBottomryBond;

	private String maleStCancellation;// 17

	private String maleStCertificateOfSale;

	private String maleStCertificateOrOtDocument;// 19

	private String maleStCharterParty;// 20 missing 21 in the file

	private String maleStCompositionDeed;// 22

	private String maleStSaleConveyance;// 23

	private String maleStCertifiedCopy;

	private String maleStCounterpartOrDuplicateOfAnyInstrument;

	// private String maleStCustomsBond;//26

	private String maleStCustomsBondNotExceed;// 26

	private String maleStCustomsBondOtCase;// 26

	private String maleStDebenture;// 27

	private String maleStDebentureEndorsedNotExceed;// 27AI

	private String maleStDebentureEndorsedExcess;// 27AII

	private String maleStDebentureDeliveryNotExceed;// 27BI

	private String maleStDebentureDeliveryExcess;// 27BII

	private String maleStDeliveryOrderInRespectofGoods;

	private String maleStDivorceDeed;// 29

	// private String maleStEntryAsAnAdvocate;//30

	private String maleStEntryAsAnAdvocateAdvocate;// 30A

	private String maleStEntryAsAnAdvocateAttorney;// 30

	private String maleStExchangeOfProperty;// 31

	// private String maleStFutherCharge;//32

	private String maleStFutherChargeWithPossession;// 32A

	private String maleStFutherChargeWithoutPossession;// 32B

	private String maleStFutherChargtPossessionGiven;// 32BI

	private String maleStFutherChargePossessionNotGiven;// 32BII

	private String maleStGiftDeed;// 33

	private String maleStIndemnityBond;// 34

	// private String maleStLease;//35

	private String maleStLeaseRentFixed;// 35A

	private String maleStLeaseLessThanOneYear;// 35AI

	private String maleStLeaseLessThanFiveYear;// 35AII

	private String maleStLeaseLessThanTenYear;// 35AIII

	private String maleStLeaseLessThanTwentyYear;// 35AIV

	private String maleStLeaseLessThanThirtyYear;// 35AV

	private String maleStLeaseLessThanHundredYear;// 35AVI

	private String maleStLeaseMoreThanHundredYear;// 35AVII

	private String maleStLeaseNotDefiniteTerm;// 35AVIII

	private String maleStLeaseNoRentReserved;// 35B

	private String maleStLeaseAdditionOnRentReserved;// 35C

	private String maleStLeaseRevisionNotification;// 35D

	private String maleStLetterOfAllotmentOfShares;// 36

	private String maleStLetterOfCredit;// 37

	private String maleStLetterOfLicence;

	private String maleStMemorandumOfAssoOfCompany;// 39

	// private String maleStMortgage;//40

	private String maleStMortgageWithPossession;// 40A

	private String maleStMortgageWithoutPossession;// 40B

	// private String maleStMortgageOfCrop;// 41

	private String maleStMortgageOfCropLessThanThree;// 41A

	private String maleStMortgageOfCropMoreThanThree;// 41B

	private String maleStNotarialAct;

	private String maleStNoteOrMemorandum;// 43

	private String maleStNoteOfProtestByTheMasterOfShip;

	private String maleStPartitionDeed;// 45

	private String maleStPartnerShip;// 46A

	private String maleStPartnerShipDissolution;// 46B

	// private String maleStPolOfIns;// 47

	private String maleStPolOfInsLessThanEighteen;// 47A.1.II

	private String maleStPolOfInsOneThousandFiveHundred;// 47A.1.II

	private String maleStPolOfInsOneThousand;// 47A.2.III

	private String maleStPolOfInsFireIns;// 47B.1.I

	private String maleStPolOfInsOts;// 47B.1.II

	private String maleStPolOfInsRenewalOriginalPol;// 47B.2

	private String maleStPolOfInsAccidental;// 47C.A

	private String maleStPolOfInsNotExceedOneThousand;// 47C.B

	private String maleStPolOfInsIndemnity;// 47C.C

	private String maleStPolOfInsLifeIns;// 47E.I

	private String maleStPolOfInsLessThanFiveHundred;// 47E.II

	private String maleStPolOfInsLessThanOneThousand;// 47E.III

	private String maleStPolOfInsReIns;// 47F

	private String maleStPwrOfAttorneySpecial;// 48A

	private String maleStPwrOfAttorneyGeneral;// 48B

	// private String maleStPromissoryNote;// 49

	private String maleStPromissoryNoteLessThanOneThousand;// 49AI

	private String maleStPromissoryNoteOtCases;// 49AII

	private String maleStPromissoryNoteDemand;// 49B

	private String maleStProtestOfBillOrNote;

	private String maleStProtestByTheMasterOfShip;// 51

	private String maleStProxy;

	private String maleStReceipt;// 53

	private String maleStReconveyanceLessThanOneThousand;// 54---recorrect

	private String maleStReconveyanceOts;// 54---recorrect

	private String maleStReleaseRelinquishmentOfRightLessThanOneThousand;// 55---recorrect

	private String maleStReleaseRelinquishmentOfRightOts;// 55---recorrect

	private String maleStRespondentiaBond;

	private String maleStSecurityBond;// 57

	private String maleStSettlementInstrument;

	private String maleStShareWarrents;// 59

	private String maleStShippingOrder;// 60

	private String maleStSurrenderOfLeaseNotExceesTen;// 61---recorrect

	private String maleStSurrenderOfLeaseOts;// 61---recorrect

	// private String maleStTransfer;//62

	private String maleStTransferOfShares;// 62A

	private String maleStTransferOfDebentures;// 62B

	private String maleStTransferSecuredBond;// 62C

	private String maleStTransferMorgageDeed;// 62C.I

	private String maleStTransferOts;// 62C.II

	private String maleStTransferAdministratorGeneral;// 62D

	private String maleStTransferTrustProperty;// 62E

	private String maleStTransferofLease;// 63

	// private String maleStTrust;

	private String maleStTrustBeingWill;// 64A

	private String maleStTrustNotBeingWill;// 64B

	private String maleStWarrentGoods;// 65

	private String maleRegisAcknowledgement;// 1

	private String maleRegisAdministrativeBond;// 2

	private String maleRegisAdoptionDeed;// 3

	private String maleRegisAffidavitIncAffOfDeclaration;// 4

	// private String maleRegisAgreement;//5

	private String maleRegisAgreementOfConveyance;// 5A

	private String maleRegisAgreementDevelopment;// 5B

	private String maleRegisAgreementOts;// 5C

	// private String maleRegisAgreeRelatDawnOrPledge;//6

	private String maleRegisAgreeRelatDawnOrPledgeExceedLessThanOneThousand;// 6AI

	private String maleRegisAgreeRelatDawnOrPledgeExceedLessThanTenThousand;// 6AII

	private String maleRegisAgreeRelatDawnOrPledgeExceedMoreThanTenThousand;// 6AIII

	private String maleRegisAgreeRelatDawnOrPledgeThreeMonths;// 6B

	private String maleRegisAppointmentInExecutionOfPwr;// 7

	// private String maleRegisAppOrVal;//8

	private String maleRegisAppOrValNotExceed;// 8A

	private String maleRegisAppOrValOtCase;// 8B

	private String maleRegisApprenticeshipDeed;// 9

	// private String maleRegisArtsOfAssoOfCompany;//10

	private String maleRegisArtsOfAssoOfCompanyNotExceed;// 10A

	private String maleRegisArtsOfAssoOfCompanyAbove;// 10B

	private String maleRegisArtsOfClerkship;// 11

	// private String maleRegisAward;//12

	private String maleRegisAwardNotExceed;// 12A

	private String maleRegisAwardExceed;// 12B

	private String maleRegisBillOfExchangeWherePayableOtwise;// 13OR 13B

	private String maleRegisBillOfLading;

	private String maleRegisBond;// 15

	private String maleRegisBottomryBond;

	private String maleRegisCancellation;// 17

	private String maleRegisCertificateOfSale;

	private String maleRegisCertificateOrOtDocument;// 19

	private String maleRegisCharterParty;// 20 missing 21 in the file

	private String maleRegisCompositionDeed;// 22

	private String maleRegisSaleConveyance;// 23

	private String maleRegisCertifiedCopy;

	private String maleRegisCounterpartOrDuplicateOfAnyInstrument;

	// private String maleRegisCustomsBond;//26

	private String maleRegisCustomsBondNotExceed;// 26

	private String maleRegisCustomsBondOtCase;// 26

	private String maleRegisDebenture;// 27

	private String maleRegisDebentureEndorsedNotExceed;// 27AI

	private String maleRegisDebentureEndorsedExcess;// 27AII

	private String maleRegisDebentureDeliveryNotExceed;// 27BI

	private String maleRegisDebentureDeliveryExcess;// 27BII

	private String maleRegisDeliveryOrderInRespectofGoods;

	private String maleRegisDivorceDeed;// 29

	// private String maleRegisEntryAsAnAdvocate;//30

	private String maleRegisEntryAsAnAdvocateAdvocate;// 30A

	private String maleRegisEntryAsAnAdvocateAttorney;// 30

	private String maleRegisExchangeOfProperty;// 31

	// private String maleRegisFutherCharge;//32

	private String maleRegisFutherChargeWithPossession;// 32A

	private String maleRegisFutherChargeWithoutPossession;// 32B

	private String maleRegisFutherChargtPossessionGiven;// 32BI

	private String maleRegisFutherChargePossessionNotGiven;// 32BII

	private String maleRegisGiftDeed;// 33

	private String maleRegisIndemnityBond;// 34

	// private String maleRegisLease;//35

	private String maleRegisLeaseRentFixed;// 35A

	private String maleRegisLeaseLessThanOneYear;// 35AI

	private String maleRegisLeaseLessThanFiveYear;// 35AII

	private String maleRegisLeaseLessThanTenYear;// 35AIII

	private String maleRegisLeaseLessThanTwentyYear;// 35AIV

	private String maleRegisLeaseLessThanThirtyYear;// 35AV

	private String maleRegisLeaseLessThanHundredYear;// 35AVI

	private String maleRegisLeaseMoreThanHundredYear;// 35AVII

	private String maleRegisLeaseNotDefiniteTerm;// 35AVIII

	private String maleRegisLeaseNoRentReserved;// 35B

	private String maleRegisLeaseAdditionOnRentReserved;// 35C

	private String maleRegisLeaseRevisionNotification;// 35D

	private String maleRegisLetterOfAllotmentOfShares;// 36

	private String maleRegisLetterOfCredit;// 37

	private String maleRegisLetterOfLicence;

	private String maleRegisMemorandumOfAssoOfCompany;// 39

	// private String maleRegisMortgage;//40

	private String maleRegisMortgageWithPossession;// 40A

	private String maleRegisMortgageWithoutPossession;// 40B

	// private String maleRegisMortgageOfCrop;// 41

	private String maleRegisMortgageOfCropLessThanThree;// 41A

	private String maleRegisMortgageOfCropMoreThanThree;// 41B

	private String maleRegisNotarialAct;

	private String maleRegisNoteOrMemorandum;// 43

	private String maleRegisNoteOfProtestByTheMasterOfShip;

	private String maleRegisPartitionDeed;// 45

	private String maleRegisPartnerShip;// 46A

	private String maleRegisPartnerShipDissolution;// 46B

	// private String maleRegisPolOfIns;// 47

	private String maleRegisPolOfInsLessThanEighteen;// 47A.1.II

	private String maleRegisPolOfInsOneThousandFiveHundred;// 47A.1.II

	private String maleRegisPolOfInsOneThousand;// 47A.2.III

	private String maleRegisPolOfInsFireIns;// 47B.1.I

	private String maleRegisPolOfInsOts;// 47B.1.II

	private String maleRegisPolOfInsRenewalOriginalPol;// 47B.2

	private String maleRegisPolOfInsAccidental;// 47C.A

	private String maleRegisPolOfInsNotExceedOneThousand;// 47C.B

	private String maleRegisPolOfInsIndemnity;// 47C.C

	private String maleRegisPolOfInsLifeIns;// 47E.I

	private String maleRegisPolOfInsLessThanFiveHundred;// 47E.II

	private String maleRegisPolOfInsLessThanOneThousand;// 47E.III

	private String maleRegisPolOfInsReIns;// 47F

	private String maleRegisPwrOfAttorneySpecial;// 48A

	private String maleRegisPwrOfAttorneyGeneral;// 48B

	// private String maleRegisPromissoryNote;// 49

	private String maleRegisPromissoryNoteLessThanOneThousand;// 49AI

	private String maleRegisPromissoryNoteOtCases;// 49AII

	private String maleRegisPromissoryNoteDemand;// 49B

	private String maleRegisProtestOfBillOrNote;

	private String maleRegisProtestByTheMasterOfShip;// 51

	private String maleRegisProxy;

	private String maleRegisReceipt;// 53

	private String maleRegisReconveyanceLessThanOneThousand;// 54---recorrect

	private String maleRegisReconveyanceOts;// 54---recorrect

	private String maleRegisReleaseRelinquishmentOfRightLessThanOneThousand;// 55---recorrect

	private String maleRegisReleaseRelinquishmentOfRightOts;// 55---recorrect

	private String maleRegisRespondentiaBond;

	private String maleRegisSecurityBond;// 57

	private String maleRegisSettlementInstrument;

	private String maleRegisShareWarrents;// 59

	private String maleRegisShippingOrder;// 60

	private String maleRegisSurrenderOfLeaseNotExceesTen;// 61---recorrect

	private String maleRegisSurrenderOfLeaseOts;// 61---recorrect

	// private String maleRegisTransfer;//62

	private String maleRegisTransferOfShares;// 62A

	private String maleRegisTransferOfDebentures;// 62B

	private String maleRegisTransferSecuredBond;// 62C

	private String maleRegisTransferMorgageDeed;// 62C.I

	private String maleRegisTransferOts;// 62C.II

	private String maleRegisTransferAdministratorGeneral;// 62D

	private String maleRegisTransferTrustProperty;// 62E

	private String maleRegisTransferofLease;// 63

	// private String maleRegisTrust;

	private String maleRegisTrustBeingWill;// 64A

	private String maleRegisTrustNotBeingWill;// 64B

	private String maleRegisWarrentGoods;// 65

	private String femaleStAcknowledgement;// 1

	private String femaleStAdministrativeBond;// 2

	private String femaleStAdoptionDeed;// 3

	private String femaleStAffidavitIncAffOfDeclaration;// 4

	// private String femaleStAgreement;//5

	private String femaleStAgreementOfConveyance;// 5A

	private String femaleStAgreementDevelopment;// 5B

	private String femaleStAgreementOts;// 5C

	// private String femaleStAgreeRelatDawnOrPledge;//6

	private String femaleStAgreeRelatDawnOrPledgeExceedLessThanOneThousand;// 6AI

	private String femaleStAgreeRelatDawnOrPledgeExceedLessThanTenThousand;// 6AII

	private String femaleStAgreeRelatDawnOrPledgeExceedMoreThanTenThousand;// 6AIII

	private String femaleStAgreeRelatDawnOrPledgeThreeMonths;// 6B

	private String femaleStAppointmentInExecutionOfPwr;// 7

	// private String femaleStAppOrVal;//8

	private String femaleStAppOrValNotExceed;// 8A

	private String femaleStAppOrValOtCase;// 8B

	private String femaleStApprenticeshipDeed;// 9

	// private String femaleStArtsOfAssoOfCompany;//10

	private String femaleStArtsOfAssoOfCompanyNotExceed;// 10A

	private String femaleStArtsOfAssoOfCompanyAbove;// 10B

	private String femaleStArtsOfClerkship;// 11

	// private String femaleStAward;//12

	private String femaleStAwardNotExceed;// 12A

	private String femaleStAwardExceed;// 12B

	private String femaleStBillOfExchangeWherePayableOtwise;// 13OR 13B

	private String femaleStBillOfLading;

	private String femaleStBond;// 15

	private String femaleStBottomryBond;

	private String femaleStCancellation;// 17

	private String femaleStCertificateOfSale;

	private String femaleStCertificateOrOtDocument;// 19

	private String femaleStCharterParty;// 20 missing 21 in the file

	private String femaleStCompositionDeed;// 22

	private String femaleStSaleConveyance;// 23

	private String femaleStCertifiedCopy;

	private String femaleStCounterpartOrDuplicateOfAnyInstrument;

	// private String femaleStCustomsBond;//26

	private String femaleStCustomsBondNotExceed;// 26

	private String femaleStCustomsBondOtCase;// 26

	private String femaleStDebenture;// 27

	private String femaleStDebentureEndorsedNotExceed;// 27AI

	private String femaleStDebentureEndorsedExcess;// 27AII

	private String femaleStDebentureDeliveryNotExceed;// 27BI

	private String femaleStDebentureDeliveryExcess;// 27BII

	private String femaleStDeliveryOrderInRespectofGoods;

	private String femaleStDivorceDeed;// 29

	// private String femaleStEntryAsAnAdvocate;//30

	private String femaleStEntryAsAnAdvocateAdvocate;// 30A

	private String femaleStEntryAsAnAdvocateAttorney;// 30

	private String femaleStExchangeOfProperty;// 31

	// private String femaleStFutherCharge;//32

	private String femaleStFutherChargeWithPossession;// 32A

	private String femaleStFutherChargeWithoutPossession;// 32B

	private String femaleStFutherChargtPossessionGiven;// 32BI

	private String femaleStFutherChargePossessionNotGiven;// 32BII

	private String femaleStGiftDeed;// 33

	private String femaleStIndemnityBond;// 34

	// private String femaleStLease;//35

	private String femaleStLeaseRentFixed;// 35A

	private String femaleStLeaseLessThanOneYear;// 35AI

	private String femaleStLeaseLessThanFiveYear;// 35AII

	private String femaleStLeaseLessThanTenYear;// 35AIII

	private String femaleStLeaseLessThanTwentyYear;// 35AIV

	private String femaleStLeaseLessThanThirtyYear;// 35AV

	private String femaleStLeaseLessThanHundredYear;// 35AVI

	private String femaleStLeaseMoreThanHundredYear;// 35AVII

	private String femaleStLeaseNotDefiniteTerm;// 35AVIII

	private String femaleStLeaseNoRentReserved;// 35B

	private String femaleStLeaseAdditionOnRentReserved;// 35C

	private String femaleStLeaseRevisionNotification;// 35D

	private String femaleStLetterOfAllotmentOfShares;// 36

	private String femaleStLetterOfCredit;// 37

	private String femaleStLetterOfLicence;

	private String femaleStMemorandumOfAssoOfCompany;// 39

	// private String femaleStMortgage;//40

	private String femaleStMortgageWithPossession;// 40A

	private String femaleStMortgageWithoutPossession;// 40B

	// private String femaleStMortgageOfCrop;// 41

	private String femaleStMortgageOfCropLessThanThree;// 41A

	private String femaleStMortgageOfCropMoreThanThree;// 41B

	private String femaleStNotarialAct;

	private String femaleStNoteOrMemorandum;// 43

	private String femaleStNoteOfProtestByTheMasterOfShip;

	private String femaleStPartitionDeed;// 45

	private String femaleStPartnerShip;// 46A

	private String femaleStPartnerShipDissolution;// 46B

	// private String femaleStPolOfIns;// 47

	private String femaleStPolOfInsLessThanEighteen;// 47A.1.II

	private String femaleStPolOfInsOneThousandFiveHundred;// 47A.1.II

	private String femaleStPolOfInsOneThousand;// 47A.2.III

	private String femaleStPolOfInsFireIns;// 47B.1.I

	private String femaleStPolOfInsOts;// 47B.1.II

	private String femaleStPolOfInsRenewalOriginalPol;// 47B.2

	private String femaleStPolOfInsAccidental;// 47C.A

	private String femaleStPolOfInsNotExceedOneThousand;// 47C.B

	private String femaleStPolOfInsIndemnity;// 47C.C

	private String femaleStPolOfInsLifeIns;// 47E.I

	private String femaleStPolOfInsLessThanFiveHundred;// 47E.II

	private String femaleStPolOfInsLessThanOneThousand;// 47E.III

	private String femaleStPolOfInsReIns;// 47F

	private String femaleStPwrOfAttorneySpecial;// 48A

	private String femaleStPwrOfAttorneyGeneral;// 48B

	// private String femaleStPromissoryNote;// 49

	private String femaleStPromissoryNoteLessThanOneThousand;// 49AI

	private String femaleStPromissoryNoteOtCases;// 49AII

	private String femaleStPromissoryNoteDemand;// 49B

	private String femaleStProtestOfBillOrNote;

	private String femaleStProtestByTheMasterOfShip;// 51

	private String femaleStProxy;

	private String femaleStReceipt;// 53

	private String femaleStReconveyanceLessThanOneThousand;// 54---recorrect

	private String femaleStReconveyanceOts;// 54---recorrect

	private String femaleStReleaseRelinquishmentOfRightLessThanOneThousand;// 55---recorrect

	private String femaleStReleaseRelinquishmentOfRightOts;// 55---recorrect

	private String femaleStRespondentiaBond;

	private String femaleStSecurityBond;// 57

	private String femaleStSettlementInstrument;

	private String femaleStShareWarrents;// 59

	private String femaleStShippingOrder;// 60

	private String femaleStSurrenderOfLeaseNotExceesTen;// 61---recorrect

	private String femaleStSurrenderOfLeaseOts;// 61---recorrect

	// private String femaleStTransfer;//62

	private String femaleStTransferOfShares;// 62A

	private String femaleStTransferOfDebentures;// 62B

	private String femaleStTransferSecuredBond;// 62C

	private String femaleStTransferMorgageDeed;// 62C.I

	private String femaleStTransferOts;// 62C.II

	private String femaleStTransferAdministratorGeneral;// 62D

	private String femaleStTransferTrustProperty;// 62E

	private String femaleStTransferofLease;// 63

	// private String femaleStTrust;

	private String femaleStTrustBeingWill;// 64A

	private String femaleStTrustNotBeingWill;// 64B

	private String femaleStWarrentGoods;// 65

	private String femaleRegisAcknowledgement;// 1

	private String femaleRegisAdministrativeBond;// 2

	private String femaleRegisAdoptionDeed;// 3

	private String femaleRegisAffidavitIncAffOfDeclaration;// 4

	// private String femaleRegisAgreement;//5

	private String femaleRegisAgreementOfConveyance;// 5A

	private String femaleRegisAgreementDevelopment;// 5B

	private String femaleRegisAgreementOts;// 5C

	// private String femaleRegisAgreeRelatDawnOrPledge;//6

	private String femaleRegisAgreeRelatDawnOrPledgeExceedLessThanOneThousand;// 6AI

	private String femaleRegisAgreeRelatDawnOrPledgeExceedLessThanTenThousand;// 6AII

	private String femaleRegisAgreeRelatDawnOrPledgeExceedMoreThanTenThousand;// 6AIII

	private String femaleRegisAgreeRelatDawnOrPledgeThreeMonths;// 6B

	private String femaleRegisAppointmentInExecutionOfPwr;// 7

	// private String femaleRegisAppOrVal;//8

	private String femaleRegisAppOrValNotExceed;// 8A

	private String femaleRegisAppOrValOtCase;// 8B

	private String femaleRegisApprenticeshipDeed;// 9

	// private String femaleRegisArtsOfAssoOfCompany;//10

	private String femaleRegisArtsOfAssoOfCompanyNotExceed;// 10A

	private String femaleRegisArtsOfAssoOfCompanyAbove;// 10B

	private String femaleRegisArtsOfClerkship;// 11

	// private String femaleRegisAward;//12

	private String femaleRegisAwardNotExceed;// 12A

	private String femaleRegisAwardExceed;// 12B

	private String femaleRegisBillOfExchangeWherePayableOtwise;// 13OR 13B

	private String femaleRegisBillOfLading;

	private String femaleRegisBond;// 15

	private String femaleRegisBottomryBond;

	private String femaleRegisCancellation;// 17

	private String femaleRegisCertificateOfSale;

	private String femaleRegisCertificateOrOtDocument;// 19

	private String femaleRegisCharterParty;// 20 missing 21 in the file

	private String femaleRegisCompositionDeed;// 22

	private String femaleRegisSaleConveyance;// 23

	private String femaleRegisCertifiedCopy;

	private String femaleRegisCounterpartOrDuplicateOfAnyInstrument;

	// private String femaleRegisCustomsBond;//26

	private String femaleRegisCustomsBondNotExceed;// 26

	private String femaleRegisCustomsBondOtCase;// 26

	private String femaleRegisDebenture;// 27

	private String femaleRegisDebentureEndorsedNotExceed;// 27AI

	private String femaleRegisDebentureEndorsedExcess;// 27AII

	private String femaleRegisDebentureDeliveryNotExceed;// 27BI

	private String femaleRegisDebentureDeliveryExcess;// 27BII

	private String femaleRegisDeliveryOrderInRespectofGoods;

	private String femaleRegisDivorceDeed;// 29

	// private String femaleRegisEntryAsAnAdvocate;//30

	private String femaleRegisEntryAsAnAdvocateAdvocate;// 30A

	private String femaleRegisEntryAsAnAdvocateAttorney;// 30

	private String femaleRegisExchangeOfProperty;// 31

	// private String femaleRegisFutherCharge;//32

	private String femaleRegisFutherChargeWithPossession;// 32A

	private String femaleRegisFutherChargeWithoutPossession;// 32B

	private String femaleRegisFutherChargtPossessionGiven;// 32BI

	private String femaleRegisFutherChargePossessionNotGiven;// 32BII

	private String femaleRegisGiftDeed;// 33

	private String femaleRegisIndemnityBond;// 34

	// private String femaleRegisLease;//35

	private String femaleRegisLeaseRentFixed;// 35A

	private String femaleRegisLeaseLessThanOneYear;// 35AI

	private String femaleRegisLeaseLessThanFiveYear;// 35AII

	private String femaleRegisLeaseLessThanTenYear;// 35AIII

	private String femaleRegisLeaseLessThanTwentyYear;// 35AIV

	private String femaleRegisLeaseLessThanThirtyYear;// 35AV

	private String femaleRegisLeaseLessThanHundredYear;// 35AVI

	private String femaleRegisLeaseMoreThanHundredYear;// 35AVII

	private String femaleRegisLeaseNotDefiniteTerm;// 35AVIII

	private String femaleRegisLeaseNoRentReserved;// 35B

	private String femaleRegisLeaseAdditionOnRentReserved;// 35C

	private String femaleRegisLeaseRevisionNotification;// 35D

	private String femaleRegisLetterOfAllotmentOfShares;// 36

	private String femaleRegisLetterOfCredit;// 37

	private String femaleRegisLetterOfLicence;

	private String femaleRegisMemorandumOfAssoOfCompany;// 39

	// private String femaleRegisMortgage;//40

	private String femaleRegisMortgageWithPossession;// 40A

	private String femaleRegisMortgageWithoutPossession;// 40B

	// private String femaleRegisMortgageOfCrop;// 41

	private String femaleRegisMortgageOfCropLessThanThree;// 41A

	private String femaleRegisMortgageOfCropMoreThanThree;// 41B

	private String femaleRegisNotarialAct;

	private String femaleRegisNoteOrMemorandum;// 43

	private String femaleRegisNoteOfProtestByTheMasterOfShip;

	private String femaleRegisPartitionDeed;// 45

	private String femaleRegisPartnerShip;// 46A

	private String femaleRegisPartnerShipDissolution;// 46B

	// private String femaleRegisPolOfIns;// 47

	private String femaleRegisPolOfInsLessThanEighteen;// 47A.1.II

	private String femaleRegisPolOfInsOneThousandFiveHundred;// 47A.1.II

	private String femaleRegisPolOfInsOneThousand;// 47A.2.III

	private String femaleRegisPolOfInsFireIns;// 47B.1.I

	private String femaleRegisPolOfInsOts;// 47B.1.II

	private String femaleRegisPolOfInsRenewalOriginalPol;// 47B.2

	private String femaleRegisPolOfInsAccidental;// 47C.A

	private String femaleRegisPolOfInsNotExceedOneThousand;// 47C.B

	private String femaleRegisPolOfInsIndemnity;// 47C.C

	private String femaleRegisPolOfInsLifeIns;// 47E.I

	private String femaleRegisPolOfInsLessThanFiveHundred;// 47E.II

	private String femaleRegisPolOfInsLessThanOneThousand;// 47E.III

	private String femaleRegisPolOfInsReIns;// 47F

	private String femaleRegisPwrOfAttorneySpecial;// 48A

	private String femaleRegisPwrOfAttorneyGeneral;// 48B

	// private String femaleRegisPromissoryNote;// 49

	private String femaleRegisPromissoryNoteLessThanOneThousand;// 49AI

	private String femaleRegisPromissoryNoteOtCases;// 49AII

	private String femaleRegisPromissoryNoteDemand;// 49B

	private String femaleRegisProtestOfBillOrNote;

	private String femaleRegisProtestByTheMasterOfShip;// 51

	private String femaleRegisProxy;

	private String femaleRegisReceipt;// 53

	private String femaleRegisReconveyanceLessThanOneThousand;// 54---recorrect

	private String femaleRegisReconveyanceOts;// 54---recorrect

	private String femaleRegisReleaseRelinquishmentOfRightLessThanOneThousand;// 55---recorrect

	private String femaleRegisReleaseRelinquishmentOfRightOts;// 55---recorrect

	private String femaleRegisRespondentiaBond;

	private String femaleRegisSecurityBond;// 57

	private String femaleRegisSettlementInstrument;

	private String femaleRegisShareWarrents;// 59

	private String femaleRegisShippingOrder;// 60

	private String femaleRegisSurrenderOfLeaseNotExceesTen;// 61---recorrect

	private String femaleRegisSurrenderOfLeaseOts;// 61---recorrect

	// private String femaleRegisTransfer;//62

	private String femaleRegisTransferOfShares;// 62A

	private String femaleRegisTransferOfDebentures;// 62B

	private String femaleRegisTransferSecuredBond;// 62C

	private String femaleRegisTransferMorgageDeed;// 62C.I

	private String femaleRegisTransferOts;// 62C.II

	private String femaleRegisTransferAdministratorGeneral;// 62D

	private String femaleRegisTransferTrustProperty;// 62E

	private String femaleRegisTransferofLease;// 63

	// private String femaleRegisTrust;

	private String femaleRegisTrustBeingWill;// 64A

	private String femaleRegisTrustNotBeingWill;// 64B

	private String femaleRegisWarrentGoods;// 65

	private String jointStAcknowledgement;// 1

	private String jointStAdministrativeBond;// 2

	private String jointStAdoptionDeed;// 3

	private String jointStAffidavitIncAffOfDeclaration;// 4

	// private String jointStAgreement;//5

	private String jointStAgreementOfConveyance;// 5A

	private String jointStAgreementDevelopment;// 5B

	private String jointStAgreementOts;// 5C

	// private String jointStAgreeRelatDawnOrPledge;//6

	private String jointStAgreeRelatDawnOrPledgeExceedLessThanOneThousand;// 6AI

	private String jointStAgreeRelatDawnOrPledgeExceedLessThanTenThousand;// 6AII

	private String jointStAgreeRelatDawnOrPledgeExceedMoreThanTenThousand;// 6AIII

	private String jointStAgreeRelatDawnOrPledgeThreeMonths;// 6B

	private String jointStAppointmentInExecutionOfPwr;// 7

	// private String jointStAppOrVal;//8

	private String jointStAppOrValNotExceed;// 8A

	private String jointStAppOrValOtCase;// 8B

	private String jointStApprenticeshipDeed;// 9

	// private String jointStArtsOfAssoOfCompany;//10

	private String jointStArtsOfAssoOfCompanyNotExceed;// 10A

	private String jointStArtsOfAssoOfCompanyAbove;// 10B

	private String jointStArtsOfClerkship;// 11

	// private String jointStAward;//12

	private String jointStAwardNotExceed;// 12A

	private String jointStAwardExceed;// 12B

	private String jointStBillOfExchangeWherePayableOtwise;// 13OR 13B

	private String jointStBillOfLading;

	private String jointStBond;// 15

	private String jointStBottomryBond;

	private String jointStCancellation;// 17

	private String jointStCertificateOfSale;

	private String jointStCertificateOrOtDocument;// 19

	private String jointStCharterParty;// 20 missing 21 in the file

	private String jointStCompositionDeed;// 22

	private String jointStSaleConveyance;// 23

	private String jointStCertifiedCopy;

	private String jointStCounterpartOrDuplicateOfAnyInstrument;

	// private String jointStCustomsBond;//26

	private String jointStCustomsBondNotExceed;// 26

	private String jointStCustomsBondOtCase;// 26

	private String jointStDebenture;// 27

	private String jointStDebentureEndorsedNotExceed;// 27AI

	private String jointStDebentureEndorsedExcess;// 27AII

	private String jointStDebentureDeliveryNotExceed;// 27BI

	private String jointStDebentureDeliveryExcess;// 27BII

	private String jointStDeliveryOrderInRespectofGoods;

	private String jointStDivorceDeed;// 29

	// private String jointStEntryAsAnAdvocate;//30

	private String jointStEntryAsAnAdvocateAdvocate;// 30A

	private String jointStEntryAsAnAdvocateAttorney;// 30

	private String jointStExchangeOfProperty;// 31

	// private String jointStFutherCharge;//32

	private String jointStFutherChargeWithPossession;// 32A

	private String jointStFutherChargeWithoutPossession;// 32B

	private String jointStFutherChargtPossessionGiven;// 32BI

	private String jointStFutherChargePossessionNotGiven;// 32BII

	private String jointStGiftDeed;// 33

	private String jointStIndemnityBond;// 34

	// private String jointStLease;//35

	private String jointStLeaseRentFixed;// 35A

	private String jointStLeaseLessThanOneYear;// 35AI

	private String jointStLeaseLessThanFiveYear;// 35AII

	private String jointStLeaseLessThanTenYear;// 35AIII

	private String jointStLeaseLessThanTwentyYear;// 35AIV

	private String jointStLeaseLessThanThirtyYear;// 35AV

	private String jointStLeaseLessThanHundredYear;// 35AVI

	private String jointStLeaseMoreThanHundredYear;// 35AVII

	private String jointStLeaseNotDefiniteTerm;// 35AVIII

	private String jointStLeaseNoRentReserved;// 35B

	private String jointStLeaseAdditionOnRentReserved;// 35C

	private String jointStLeaseRevisionNotification;// 35D

	private String jointStLetterOfAllotmentOfShares;// 36

	private String jointStLetterOfCredit;// 37

	private String jointStLetterOfLicence;

	private String jointStMemorandumOfAssoOfCompany;// 39

	// private String jointStMortgage;//40

	private String jointStMortgageWithPossession;// 40A

	private String jointStMortgageWithoutPossession;// 40B

	// private String jointStMortgageOfCrop;// 41

	private String jointStMortgageOfCropLessThanThree;// 41A

	private String jointStMortgageOfCropMoreThanThree;// 41B

	private String jointStNotarialAct;

	private String jointStNoteOrMemorandum;// 43

	private String jointStNoteOfProtestByTheMasterOfShip;

	private String jointStPartitionDeed;// 45

	private String jointStPartnerShip;// 46A

	private String jointStPartnerShipDissolution;// 46B

	// private String jointStPolOfIns;// 47

	private String jointStPolOfInsLessThanEighteen;// 47A.1.II

	private String jointStPolOfInsOneThousandFiveHundred;// 47A.1.II

	private String jointStPolOfInsOneThousand;// 47A.2.III

	private String jointStPolOfInsFireIns;// 47B.1.I

	private String jointStPolOfInsOts;// 47B.1.II

	private String jointStPolOfInsRenewalOriginalPol;// 47B.2

	private String jointStPolOfInsAccidental;// 47C.A

	private String jointStPolOfInsNotExceedOneThousand;// 47C.B

	private String jointStPolOfInsIndemnity;// 47C.C

	private String jointStPolOfInsLifeIns;// 47E.I

	private String jointStPolOfInsLessThanFiveHundred;// 47E.II

	private String jointStPolOfInsLessThanOneThousand;// 47E.III

	private String jointStPolOfInsReIns;// 47F

	private String jointStPwrOfAttorneySpecial;// 48A

	private String jointStPwrOfAttorneyGeneral;// 48B

	// private String jointStPromissoryNote;// 49

	private String jointStPromissoryNoteLessThanOneThousand;// 49AI

	private String jointStPromissoryNoteOtCases;// 49AII

	private String jointStPromissoryNoteDemand;// 49B

	private String jointStProtestOfBillOrNote;

	private String jointStProtestByTheMasterOfShip;// 51

	private String jointStProxy;

	private String jointStReceipt;// 53

	private String jointStReconveyanceLessThanOneThousand;// 54---recorrect

	private String jointStReconveyanceOts;// 54---recorrect

	private String jointStReleaseRelinquishmentOfRightLessThanOneThousand;// 55---recorrect

	private String jointStReleaseRelinquishmentOfRightOts;// 55---recorrect

	private String jointStRespondentiaBond;

	private String jointStSecurityBond;// 57

	private String jointStSettlementInstrument;

	private String jointStShareWarrents;// 59

	private String jointStShippingOrder;// 60

	private String jointStSurrenderOfLeaseNotExceesTen;// 61---recorrect

	private String jointStSurrenderOfLeaseOts;// 61---recorrect

	// private String jointStTransfer;//62

	private String jointStTransferOfShares;// 62A

	private String jointStTransferOfDebentures;// 62B

	private String jointStTransferSecuredBond;// 62C

	private String jointStTransferMorgageDeed;// 62C.I

	private String jointStTransferOts;// 62C.II

	private String jointStTransferAdministratorGeneral;// 62D

	private String jointStTransferTrustProperty;// 62E

	private String jointStTransferofLease;// 63

	// private String jointStTrust;

	private String jointStTrustBeingWill;// 64A

	private String jointStTrustNotBeingWill;// 64B

	private String jointStWarrentGoods;// 65

	private String jointRegisAcknowledgement;// 1

	private String jointRegisAdministrativeBond;// 2

	private String jointRegisAdoptionDeed;// 3

	private String jointRegisAffidavitIncAffOfDeclaration;// 4

	// private String jointRegisAgreement;//5

	private String jointRegisAgreementOfConveyance;// 5A

	private String jointRegisAgreementDevelopment;// 5B

	private String jointRegisAgreementOts;// 5C

	// private String jointRegisAgreeRelatDawnOrPledge;//6

	private String jointRegisAgreeRelatDawnOrPledgeExceedLessThanOneThousand;// 6AI

	private String jointRegisAgreeRelatDawnOrPledgeExceedLessThanTenThousand;// 6AII

	private String jointRegisAgreeRelatDawnOrPledgeExceedMoreThanTenThousand;// 6AIII

	private String jointRegisAgreeRelatDawnOrPledgeThreeMonths;// 6B

	private String jointRegisAppointmentInExecutionOfPwr;// 7

	// private String jointRegisAppOrVal;//8

	private String jointRegisAppOrValNotExceed;// 8A

	private String jointRegisAppOrValOtCase;// 8B

	private String jointRegisApprenticeshipDeed;// 9

	// private String jointRegisArtsOfAssoOfCompany;//10

	private String jointRegisArtsOfAssoOfCompanyNotExceed;// 10A

	private String jointRegisArtsOfAssoOfCompanyAbove;// 10B

	private String jointRegisArtsOfClerkship;// 11

	// private String jointRegisAward;//12

	private String jointRegisAwardNotExceed;// 12A

	private String jointRegisAwardExceed;// 12B

	private String jointRegisBillOfExchangeWherePayableOtwise;// 13OR 13B

	private String jointRegisBillOfLading;

	private String jointRegisBond;// 15

	private String jointRegisBottomryBond;

	private String jointRegisCancellation;// 17

	private String jointRegisCertificateOfSale;

	private String jointRegisCertificateOrOtDocument;// 19

	private String jointRegisCharterParty;// 20 missing 21 in the file

	private String jointRegisCompositionDeed;// 22

	private String jointRegisSaleConveyance;// 23

	private String jointRegisCertifiedCopy;

	private String jointRegisCounterpartOrDuplicateOfAnyInstrument;

	// private String jointRegisCustomsBond;//26

	private String jointRegisCustomsBondNotExceed;// 26

	private String jointRegisCustomsBondOtCase;// 26

	private String jointRegisDebenture;// 27

	private String jointRegisDebentureEndorsedNotExceed;// 27AI

	private String jointRegisDebentureEndorsedExcess;// 27AII

	private String jointRegisDebentureDeliveryNotExceed;// 27BI

	private String jointRegisDebentureDeliveryExcess;// 27BII

	private String jointRegisDeliveryOrderInRespectofGoods;

	private String jointRegisDivorceDeed;// 29

	// private String jointRegisEntryAsAnAdvocate;//30

	private String jointRegisEntryAsAnAdvocateAdvocate;// 30A

	private String jointRegisEntryAsAnAdvocateAttorney;// 30

	private String jointRegisExchangeOfProperty;// 31

	// private String jointRegisFutherCharge;//32

	private String jointRegisFutherChargeWithPossession;// 32A

	private String jointRegisFutherChargeWithoutPossession;// 32B

	private String jointRegisFutherChargtPossessionGiven;// 32BI

	private String jointRegisFutherChargePossessionNotGiven;// 32BII

	private String jointRegisGiftDeed;// 33

	private String jointRegisIndemnityBond;// 34

	// private String jointRegisLease;//35

	private String jointRegisLeaseRentFixed;// 35A

	private String jointRegisLeaseLessThanOneYear;// 35AI

	private String jointRegisLeaseLessThanFiveYear;// 35AII

	private String jointRegisLeaseLessThanTenYear;// 35AIII

	private String jointRegisLeaseLessThanTwentyYear;// 35AIV

	private String jointRegisLeaseLessThanThirtyYear;// 35AV

	private String jointRegisLeaseLessThanHundredYear;// 35AVI

	private String jointRegisLeaseMoreThanHundredYear;// 35AVII

	private String jointRegisLeaseNotDefiniteTerm;// 35AVIII

	private String jointRegisLeaseNoRentReserved;// 35B

	private String jointRegisLeaseAdditionOnRentReserved;// 35C

	private String jointRegisLeaseRevisionNotification;// 35D

	private String jointRegisLetterOfAllotmentOfShares;// 36

	private String jointRegisLetterOfCredit;// 37

	private String jointRegisLetterOfLicence;

	private String jointRegisMemorandumOfAssoOfCompany;// 39

	// private String jointRegisMortgage;//40

	private String jointRegisMortgageWithPossession;// 40A

	private String jointRegisMortgageWithoutPossession;// 40B

	// private String jointRegisMortgageOfCrop;// 41

	private String jointRegisMortgageOfCropLessThanThree;// 41A

	private String jointRegisMortgageOfCropMoreThanThree;// 41B

	private String jointRegisNotarialAct;

	private String jointRegisNoteOrMemorandum;// 43

	private String jointRegisNoteOfProtestByTheMasterOfShip;

	private String jointRegisPartitionDeed;// 45

	private String jointRegisPartnerShip;// 46A

	private String jointRegisPartnerShipDissolution;// 46B

	// private String jointRegisPolOfIns;// 47

	private String jointRegisPolOfInsLessThanEighteen;// 47A.1.II

	private String jointRegisPolOfInsOneThousandFiveHundred;// 47A.1.II

	private String jointRegisPolOfInsOneThousand;// 47A.2.III

	private String jointRegisPolOfInsFireIns;// 47B.1.I

	private String jointRegisPolOfInsOts;// 47B.1.II

	private String jointRegisPolOfInsRenewalOriginalPol;// 47B.2

	private String jointRegisPolOfInsAccidental;// 47C.A

	private String jointRegisPolOfInsNotExceedOneThousand;// 47C.B

	private String jointRegisPolOfInsIndemnity;// 47C.C

	private String jointRegisPolOfInsLifeIns;// 47E.I

	private String jointRegisPolOfInsLessThanFiveHundred;// 47E.II

	private String jointRegisPolOfInsLessThanOneThousand;// 47E.III

	private String jointRegisPolOfInsReIns;// 47F

	private String jointRegisPwrOfAttorneySpecial;// 48A

	private String jointRegisPwrOfAttorneyGeneral;// 48B

	// private String jointRegisPromissoryNote;// 49

	private String jointRegisPromissoryNoteLessThanOneThousand;// 49AI

	private String jointRegisPromissoryNoteOtCases;// 49AII

	private String jointRegisPromissoryNoteDemand;// 49B

	private String jointRegisProtestOfBillOrNote;

	private String jointRegisProtestByTheMasterOfShip;// 51

	private String jointRegisProxy;

	private String jointRegisReceipt;// 53

	private String jointRegisReconveyanceLessThanOneThousand;// 54---recorrect

	private String jointRegisReconveyanceOts;// 54---recorrect

	private String jointRegisReleaseRelinquishmentOfRightLessThanOneThousand;// 55---recorrect

	private String jointRegisReleaseRelinquishmentOfRightOts;// 55---recorrect

	private String jointRegisRespondentiaBond;

	private String jointRegisSecurityBond;// 57

	private String jointRegisSettlementInstrument;

	private String jointRegisShareWarrents;// 59

	private String jointRegisShippingOrder;// 60

	private String jointRegisSurrenderOfLeaseNotExceesTen;// 61---recorrect

	private String jointRegisSurrenderOfLeaseOts;// 61---recorrect

	// private String jointRegisTransfer;//62

	private String jointRegisTransferOfShares;// 62A

	private String jointRegisTransferOfDebentures;// 62B

	private String jointRegisTransferSecuredBond;// 62C

	private String jointRegisTransferMorgageDeed;// 62C.I

	private String jointRegisTransferOts;// 62C.II

	private String jointRegisTransferAdministratorGeneral;// 62D

	private String jointRegisTransferTrustProperty;// 62E

	private String jointRegisTransferofLease;// 63

	// private String jointRegisTrust;

	private String jointRegisTrustBeingWill;// 64A

	private String jointRegisTrustNotBeingWill;// 64B

	private String jointRegisWarrentGoods;// 65

}


