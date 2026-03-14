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

	public Long getStDutyCalculationGenId() {
		return StDutyCalculationGenId;
	}

	public void setStDutyCalculationGenId(Long stDutyCalculationGenId) {
		StDutyCalculationGenId = stDutyCalculationGenId;
	}

	public String getMaleStAcknowledgement() {
		return maleStAcknowledgement;
	}

	public void setMaleStAcknowledgement(String maleStAcknowledgement) {
		this.maleStAcknowledgement = maleStAcknowledgement;
	}

	public String getMaleStAdministrativeBond() {
		return maleStAdministrativeBond;
	}

	public void setMaleStAdministrativeBond(String maleStAdministrativeBond) {
		this.maleStAdministrativeBond = maleStAdministrativeBond;
	}

	public String getMaleStAdoptionDeed() {
		return maleStAdoptionDeed;
	}

	public void setMaleStAdoptionDeed(String maleStAdoptionDeed) {
		this.maleStAdoptionDeed = maleStAdoptionDeed;
	}

	public String getMaleStAffidavitIncAffOfDeclaration() {
		return maleStAffidavitIncAffOfDeclaration;
	}

	public void setMaleStAffidavitIncAffOfDeclaration(String maleStAffidavitIncAffOfDeclaration) {
		this.maleStAffidavitIncAffOfDeclaration = maleStAffidavitIncAffOfDeclaration;
	}

	public String getMaleStAgreementOfConveyance() {
		return maleStAgreementOfConveyance;
	}

	public void setMaleStAgreementOfConveyance(String maleStAgreementOfConveyance) {
		this.maleStAgreementOfConveyance = maleStAgreementOfConveyance;
	}

	public String getMaleStAgreementDevelopment() {
		return maleStAgreementDevelopment;
	}

	public void setMaleStAgreementDevelopment(String maleStAgreementDevelopment) {
		this.maleStAgreementDevelopment = maleStAgreementDevelopment;
	}

	public String getMaleStAgreementOts() {
		return maleStAgreementOts;
	}

	public void setMaleStAgreementOts(String maleStAgreementOts) {
		this.maleStAgreementOts = maleStAgreementOts;
	}

	public String getMaleStAgreeRelatDawnOrPledgeExceedLessThanOneThousand() {
		return maleStAgreeRelatDawnOrPledgeExceedLessThanOneThousand;
	}

	public void setMaleStAgreeRelatDawnOrPledgeExceedLessThanOneThousand(
			String maleStAgreeRelatDawnOrPledgeExceedLessThanOneThousand) {
		this.maleStAgreeRelatDawnOrPledgeExceedLessThanOneThousand = maleStAgreeRelatDawnOrPledgeExceedLessThanOneThousand;
	}

	public String getMaleStAgreeRelatDawnOrPledgeExceedLessThanTenThousand() {
		return maleStAgreeRelatDawnOrPledgeExceedLessThanTenThousand;
	}

	public void setMaleStAgreeRelatDawnOrPledgeExceedLessThanTenThousand(
			String maleStAgreeRelatDawnOrPledgeExceedLessThanTenThousand) {
		this.maleStAgreeRelatDawnOrPledgeExceedLessThanTenThousand = maleStAgreeRelatDawnOrPledgeExceedLessThanTenThousand;
	}

	public String getMaleStAgreeRelatDawnOrPledgeExceedMoreThanTenThousand() {
		return maleStAgreeRelatDawnOrPledgeExceedMoreThanTenThousand;
	}

	public void setMaleStAgreeRelatDawnOrPledgeExceedMoreThanTenThousand(
			String maleStAgreeRelatDawnOrPledgeExceedMoreThanTenThousand) {
		this.maleStAgreeRelatDawnOrPledgeExceedMoreThanTenThousand = maleStAgreeRelatDawnOrPledgeExceedMoreThanTenThousand;
	}

	public String getMaleStAgreeRelatDawnOrPledgeThreeMonths() {
		return maleStAgreeRelatDawnOrPledgeThreeMonths;
	}

	public void setMaleStAgreeRelatDawnOrPledgeThreeMonths(String maleStAgreeRelatDawnOrPledgeThreeMonths) {
		this.maleStAgreeRelatDawnOrPledgeThreeMonths = maleStAgreeRelatDawnOrPledgeThreeMonths;
	}

	public String getMaleStAppointmentInExecutionOfPwr() {
		return maleStAppointmentInExecutionOfPwr;
	}

	public void setMaleStAppointmentInExecutionOfPwr(String maleStAppointmentInExecutionOfPwr) {
		this.maleStAppointmentInExecutionOfPwr = maleStAppointmentInExecutionOfPwr;
	}

	public String getMaleStAppOrValNotExceed() {
		return maleStAppOrValNotExceed;
	}

	public void setMaleStAppOrValNotExceed(String maleStAppOrValNotExceed) {
		this.maleStAppOrValNotExceed = maleStAppOrValNotExceed;
	}

	public String getMaleStAppOrValOtCase() {
		return maleStAppOrValOtCase;
	}

	public void setMaleStAppOrValOtCase(String maleStAppOrValOtCase) {
		this.maleStAppOrValOtCase = maleStAppOrValOtCase;
	}

	public String getMaleStApprenticeshipDeed() {
		return maleStApprenticeshipDeed;
	}

	public void setMaleStApprenticeshipDeed(String maleStApprenticeshipDeed) {
		this.maleStApprenticeshipDeed = maleStApprenticeshipDeed;
	}

	public String getMaleStArtsOfAssoOfCompanyNotExceed() {
		return maleStArtsOfAssoOfCompanyNotExceed;
	}

	public void setMaleStArtsOfAssoOfCompanyNotExceed(String maleStArtsOfAssoOfCompanyNotExceed) {
		this.maleStArtsOfAssoOfCompanyNotExceed = maleStArtsOfAssoOfCompanyNotExceed;
	}

	public String getMaleStArtsOfAssoOfCompanyAbove() {
		return maleStArtsOfAssoOfCompanyAbove;
	}

	public void setMaleStArtsOfAssoOfCompanyAbove(String maleStArtsOfAssoOfCompanyAbove) {
		this.maleStArtsOfAssoOfCompanyAbove = maleStArtsOfAssoOfCompanyAbove;
	}

	public String getMaleStArtsOfClerkship() {
		return maleStArtsOfClerkship;
	}

	public void setMaleStArtsOfClerkship(String maleStArtsOfClerkship) {
		this.maleStArtsOfClerkship = maleStArtsOfClerkship;
	}

	public String getMaleStAwardNotExceed() {
		return maleStAwardNotExceed;
	}

	public void setMaleStAwardNotExceed(String maleStAwardNotExceed) {
		this.maleStAwardNotExceed = maleStAwardNotExceed;
	}

	public String getMaleStAwardExceed() {
		return maleStAwardExceed;
	}

	public void setMaleStAwardExceed(String maleStAwardExceed) {
		this.maleStAwardExceed = maleStAwardExceed;
	}

	public String getMaleStBillOfExchangeWherePayableOtwise() {
		return maleStBillOfExchangeWherePayableOtwise;
	}

	public void setMaleStBillOfExchangeWherePayableOtwise(String maleStBillOfExchangeWherePayableOtwise) {
		this.maleStBillOfExchangeWherePayableOtwise = maleStBillOfExchangeWherePayableOtwise;
	}

	public String getMaleStBillOfLading() {
		return maleStBillOfLading;
	}

	public void setMaleStBillOfLading(String maleStBillOfLading) {
		this.maleStBillOfLading = maleStBillOfLading;
	}

	public String getMaleStBond() {
		return maleStBond;
	}

	public void setMaleStBond(String maleStBond) {
		this.maleStBond = maleStBond;
	}

	public String getMaleStBottomryBond() {
		return maleStBottomryBond;
	}

	public void setMaleStBottomryBond(String maleStBottomryBond) {
		this.maleStBottomryBond = maleStBottomryBond;
	}

	public String getMaleStCancellation() {
		return maleStCancellation;
	}

	public void setMaleStCancellation(String maleStCancellation) {
		this.maleStCancellation = maleStCancellation;
	}

	public String getMaleStCertificateOfSale() {
		return maleStCertificateOfSale;
	}

	public void setMaleStCertificateOfSale(String maleStCertificateOfSale) {
		this.maleStCertificateOfSale = maleStCertificateOfSale;
	}

	public String getMaleStCertificateOrOtDocument() {
		return maleStCertificateOrOtDocument;
	}

	public void setMaleStCertificateOrOtDocument(String maleStCertificateOrOtDocument) {
		this.maleStCertificateOrOtDocument = maleStCertificateOrOtDocument;
	}

	public String getMaleStCharterParty() {
		return maleStCharterParty;
	}

	public void setMaleStCharterParty(String maleStCharterParty) {
		this.maleStCharterParty = maleStCharterParty;
	}

	public String getMaleStCompositionDeed() {
		return maleStCompositionDeed;
	}

	public void setMaleStCompositionDeed(String maleStCompositionDeed) {
		this.maleStCompositionDeed = maleStCompositionDeed;
	}

	public String getMaleStSaleConveyance() {
		return maleStSaleConveyance;
	}

	public void setMaleStSaleConveyance(String maleStSaleConveyance) {
		this.maleStSaleConveyance = maleStSaleConveyance;
	}

	public String getMaleStCertifiedCopy() {
		return maleStCertifiedCopy;
	}

	public void setMaleStCertifiedCopy(String maleStCertifiedCopy) {
		this.maleStCertifiedCopy = maleStCertifiedCopy;
	}

	public String getMaleStCounterpartOrDuplicateOfAnyInstrument() {
		return maleStCounterpartOrDuplicateOfAnyInstrument;
	}

	public void setMaleStCounterpartOrDuplicateOfAnyInstrument(String maleStCounterpartOrDuplicateOfAnyInstrument) {
		this.maleStCounterpartOrDuplicateOfAnyInstrument = maleStCounterpartOrDuplicateOfAnyInstrument;
	}

	public String getMaleStCustomsBondNotExceed() {
		return maleStCustomsBondNotExceed;
	}

	public void setMaleStCustomsBondNotExceed(String maleStCustomsBondNotExceed) {
		this.maleStCustomsBondNotExceed = maleStCustomsBondNotExceed;
	}

	public String getMaleStCustomsBondOtCase() {
		return maleStCustomsBondOtCase;
	}

	public void setMaleStCustomsBondOtCase(String maleStCustomsBondOtCase) {
		this.maleStCustomsBondOtCase = maleStCustomsBondOtCase;
	}

	public String getMaleStDebenture() {
		return maleStDebenture;
	}

	public void setMaleStDebenture(String maleStDebenture) {
		this.maleStDebenture = maleStDebenture;
	}

	public String getMaleStDebentureEndorsedNotExceed() {
		return maleStDebentureEndorsedNotExceed;
	}

	public void setMaleStDebentureEndorsedNotExceed(String maleStDebentureEndorsedNotExceed) {
		this.maleStDebentureEndorsedNotExceed = maleStDebentureEndorsedNotExceed;
	}

	public String getMaleStDebentureEndorsedExcess() {
		return maleStDebentureEndorsedExcess;
	}

	public void setMaleStDebentureEndorsedExcess(String maleStDebentureEndorsedExcess) {
		this.maleStDebentureEndorsedExcess = maleStDebentureEndorsedExcess;
	}

	public String getMaleStDebentureDeliveryNotExceed() {
		return maleStDebentureDeliveryNotExceed;
	}

	public void setMaleStDebentureDeliveryNotExceed(String maleStDebentureDeliveryNotExceed) {
		this.maleStDebentureDeliveryNotExceed = maleStDebentureDeliveryNotExceed;
	}

	public String getMaleStDebentureDeliveryExcess() {
		return maleStDebentureDeliveryExcess;
	}

	public void setMaleStDebentureDeliveryExcess(String maleStDebentureDeliveryExcess) {
		this.maleStDebentureDeliveryExcess = maleStDebentureDeliveryExcess;
	}

	public String getMaleStDeliveryOrderInRespectofGoods() {
		return maleStDeliveryOrderInRespectofGoods;
	}

	public void setMaleStDeliveryOrderInRespectofGoods(String maleStDeliveryOrderInRespectofGoods) {
		this.maleStDeliveryOrderInRespectofGoods = maleStDeliveryOrderInRespectofGoods;
	}

	public String getMaleStDivorceDeed() {
		return maleStDivorceDeed;
	}

	public void setMaleStDivorceDeed(String maleStDivorceDeed) {
		this.maleStDivorceDeed = maleStDivorceDeed;
	}

	public String getMaleStEntryAsAnAdvocateAdvocate() {
		return maleStEntryAsAnAdvocateAdvocate;
	}

	public void setMaleStEntryAsAnAdvocateAdvocate(String maleStEntryAsAnAdvocateAdvocate) {
		this.maleStEntryAsAnAdvocateAdvocate = maleStEntryAsAnAdvocateAdvocate;
	}

	public String getMaleStEntryAsAnAdvocateAttorney() {
		return maleStEntryAsAnAdvocateAttorney;
	}

	public void setMaleStEntryAsAnAdvocateAttorney(String maleStEntryAsAnAdvocateAttorney) {
		this.maleStEntryAsAnAdvocateAttorney = maleStEntryAsAnAdvocateAttorney;
	}

	public String getMaleStExchangeOfProperty() {
		return maleStExchangeOfProperty;
	}

	public void setMaleStExchangeOfProperty(String maleStExchangeOfProperty) {
		this.maleStExchangeOfProperty = maleStExchangeOfProperty;
	}

	public String getMaleStFutherChargeWithPossession() {
		return maleStFutherChargeWithPossession;
	}

	public void setMaleStFutherChargeWithPossession(String maleStFutherChargeWithPossession) {
		this.maleStFutherChargeWithPossession = maleStFutherChargeWithPossession;
	}

	public String getMaleStFutherChargeWithoutPossession() {
		return maleStFutherChargeWithoutPossession;
	}

	public void setMaleStFutherChargeWithoutPossession(String maleStFutherChargeWithoutPossession) {
		this.maleStFutherChargeWithoutPossession = maleStFutherChargeWithoutPossession;
	}

	public String getMaleStFutherChargtPossessionGiven() {
		return maleStFutherChargtPossessionGiven;
	}

	public void setMaleStFutherChargtPossessionGiven(String maleStFutherChargtPossessionGiven) {
		this.maleStFutherChargtPossessionGiven = maleStFutherChargtPossessionGiven;
	}

	public String getMaleStFutherChargePossessionNotGiven() {
		return maleStFutherChargePossessionNotGiven;
	}

	public void setMaleStFutherChargePossessionNotGiven(String maleStFutherChargePossessionNotGiven) {
		this.maleStFutherChargePossessionNotGiven = maleStFutherChargePossessionNotGiven;
	}

	public String getMaleStGiftDeed() {
		return maleStGiftDeed;
	}

	public void setMaleStGiftDeed(String maleStGiftDeed) {
		this.maleStGiftDeed = maleStGiftDeed;
	}

	public String getMaleStIndemnityBond() {
		return maleStIndemnityBond;
	}

	public void setMaleStIndemnityBond(String maleStIndemnityBond) {
		this.maleStIndemnityBond = maleStIndemnityBond;
	}

	public String getMaleStLeaseRentFixed() {
		return maleStLeaseRentFixed;
	}

	public void setMaleStLeaseRentFixed(String maleStLeaseRentFixed) {
		this.maleStLeaseRentFixed = maleStLeaseRentFixed;
	}

	public String getMaleStLeaseLessThanOneYear() {
		return maleStLeaseLessThanOneYear;
	}

	public void setMaleStLeaseLessThanOneYear(String maleStLeaseLessThanOneYear) {
		this.maleStLeaseLessThanOneYear = maleStLeaseLessThanOneYear;
	}

	public String getMaleStLeaseLessThanFiveYear() {
		return maleStLeaseLessThanFiveYear;
	}

	public void setMaleStLeaseLessThanFiveYear(String maleStLeaseLessThanFiveYear) {
		this.maleStLeaseLessThanFiveYear = maleStLeaseLessThanFiveYear;
	}

	public String getMaleStLeaseLessThanTenYear() {
		return maleStLeaseLessThanTenYear;
	}

	public void setMaleStLeaseLessThanTenYear(String maleStLeaseLessThanTenYear) {
		this.maleStLeaseLessThanTenYear = maleStLeaseLessThanTenYear;
	}

	public String getMaleStLeaseLessThanTwentyYear() {
		return maleStLeaseLessThanTwentyYear;
	}

	public void setMaleStLeaseLessThanTwentyYear(String maleStLeaseLessThanTwentyYear) {
		this.maleStLeaseLessThanTwentyYear = maleStLeaseLessThanTwentyYear;
	}

	public String getMaleStLeaseLessThanThirtyYear() {
		return maleStLeaseLessThanThirtyYear;
	}

	public void setMaleStLeaseLessThanThirtyYear(String maleStLeaseLessThanThirtyYear) {
		this.maleStLeaseLessThanThirtyYear = maleStLeaseLessThanThirtyYear;
	}

	public String getMaleStLeaseLessThanHundredYear() {
		return maleStLeaseLessThanHundredYear;
	}

	public void setMaleStLeaseLessThanHundredYear(String maleStLeaseLessThanHundredYear) {
		this.maleStLeaseLessThanHundredYear = maleStLeaseLessThanHundredYear;
	}

	public String getMaleStLeaseMoreThanHundredYear() {
		return maleStLeaseMoreThanHundredYear;
	}

	public void setMaleStLeaseMoreThanHundredYear(String maleStLeaseMoreThanHundredYear) {
		this.maleStLeaseMoreThanHundredYear = maleStLeaseMoreThanHundredYear;
	}

	public String getMaleStLeaseNotDefiniteTerm() {
		return maleStLeaseNotDefiniteTerm;
	}

	public void setMaleStLeaseNotDefiniteTerm(String maleStLeaseNotDefiniteTerm) {
		this.maleStLeaseNotDefiniteTerm = maleStLeaseNotDefiniteTerm;
	}

	public String getMaleStLeaseNoRentReserved() {
		return maleStLeaseNoRentReserved;
	}

	public void setMaleStLeaseNoRentReserved(String maleStLeaseNoRentReserved) {
		this.maleStLeaseNoRentReserved = maleStLeaseNoRentReserved;
	}

	public String getMaleStLeaseAdditionOnRentReserved() {
		return maleStLeaseAdditionOnRentReserved;
	}

	public void setMaleStLeaseAdditionOnRentReserved(String maleStLeaseAdditionOnRentReserved) {
		this.maleStLeaseAdditionOnRentReserved = maleStLeaseAdditionOnRentReserved;
	}

	public String getMaleStLeaseRevisionNotification() {
		return maleStLeaseRevisionNotification;
	}

	public void setMaleStLeaseRevisionNotification(String maleStLeaseRevisionNotification) {
		this.maleStLeaseRevisionNotification = maleStLeaseRevisionNotification;
	}

	public String getMaleStLetterOfAllotmentOfShares() {
		return maleStLetterOfAllotmentOfShares;
	}

	public void setMaleStLetterOfAllotmentOfShares(String maleStLetterOfAllotmentOfShares) {
		this.maleStLetterOfAllotmentOfShares = maleStLetterOfAllotmentOfShares;
	}

	public String getMaleStLetterOfCredit() {
		return maleStLetterOfCredit;
	}

	public void setMaleStLetterOfCredit(String maleStLetterOfCredit) {
		this.maleStLetterOfCredit = maleStLetterOfCredit;
	}

	public String getMaleStLetterOfLicence() {
		return maleStLetterOfLicence;
	}

	public void setMaleStLetterOfLicence(String maleStLetterOfLicence) {
		this.maleStLetterOfLicence = maleStLetterOfLicence;
	}

	public String getMaleStMemorandumOfAssoOfCompany() {
		return maleStMemorandumOfAssoOfCompany;
	}

	public void setMaleStMemorandumOfAssoOfCompany(String maleStMemorandumOfAssoOfCompany) {
		this.maleStMemorandumOfAssoOfCompany = maleStMemorandumOfAssoOfCompany;
	}

	public String getMaleStMortgageWithPossession() {
		return maleStMortgageWithPossession;
	}

	public void setMaleStMortgageWithPossession(String maleStMortgageWithPossession) {
		this.maleStMortgageWithPossession = maleStMortgageWithPossession;
	}

	public String getMaleStMortgageWithoutPossession() {
		return maleStMortgageWithoutPossession;
	}

	public void setMaleStMortgageWithoutPossession(String maleStMortgageWithoutPossession) {
		this.maleStMortgageWithoutPossession = maleStMortgageWithoutPossession;
	}

	public String getMaleStMortgageOfCropLessThanThree() {
		return maleStMortgageOfCropLessThanThree;
	}

	public void setMaleStMortgageOfCropLessThanThree(String maleStMortgageOfCropLessThanThree) {
		this.maleStMortgageOfCropLessThanThree = maleStMortgageOfCropLessThanThree;
	}

	public String getMaleStMortgageOfCropMoreThanThree() {
		return maleStMortgageOfCropMoreThanThree;
	}

	public void setMaleStMortgageOfCropMoreThanThree(String maleStMortgageOfCropMoreThanThree) {
		this.maleStMortgageOfCropMoreThanThree = maleStMortgageOfCropMoreThanThree;
	}

	public String getMaleStNotarialAct() {
		return maleStNotarialAct;
	}

	public void setMaleStNotarialAct(String maleStNotarialAct) {
		this.maleStNotarialAct = maleStNotarialAct;
	}

	public String getMaleStNoteOrMemorandum() {
		return maleStNoteOrMemorandum;
	}

	public void setMaleStNoteOrMemorandum(String maleStNoteOrMemorandum) {
		this.maleStNoteOrMemorandum = maleStNoteOrMemorandum;
	}

	public String getMaleStNoteOfProtestByTheMasterOfShip() {
		return maleStNoteOfProtestByTheMasterOfShip;
	}

	public void setMaleStNoteOfProtestByTheMasterOfShip(String maleStNoteOfProtestByTheMasterOfShip) {
		this.maleStNoteOfProtestByTheMasterOfShip = maleStNoteOfProtestByTheMasterOfShip;
	}

	public String getMaleStPartitionDeed() {
		return maleStPartitionDeed;
	}

	public void setMaleStPartitionDeed(String maleStPartitionDeed) {
		this.maleStPartitionDeed = maleStPartitionDeed;
	}

	public String getMaleStPartnerShip() {
		return maleStPartnerShip;
	}

	public void setMaleStPartnerShip(String maleStPartnerShip) {
		this.maleStPartnerShip = maleStPartnerShip;
	}

	public String getMaleStPartnerShipDissolution() {
		return maleStPartnerShipDissolution;
	}

	public void setMaleStPartnerShipDissolution(String maleStPartnerShipDissolution) {
		this.maleStPartnerShipDissolution = maleStPartnerShipDissolution;
	}

	public String getMaleStPolOfInsLessThanEighteen() {
		return maleStPolOfInsLessThanEighteen;
	}

	public void setMaleStPolOfInsLessThanEighteen(String maleStPolOfInsLessThanEighteen) {
		this.maleStPolOfInsLessThanEighteen = maleStPolOfInsLessThanEighteen;
	}

	public String getMaleStPolOfInsOneThousandFiveHundred() {
		return maleStPolOfInsOneThousandFiveHundred;
	}

	public void setMaleStPolOfInsOneThousandFiveHundred(String maleStPolOfInsOneThousandFiveHundred) {
		this.maleStPolOfInsOneThousandFiveHundred = maleStPolOfInsOneThousandFiveHundred;
	}

	public String getMaleStPolOfInsOneThousand() {
		return maleStPolOfInsOneThousand;
	}

	public void setMaleStPolOfInsOneThousand(String maleStPolOfInsOneThousand) {
		this.maleStPolOfInsOneThousand = maleStPolOfInsOneThousand;
	}

	public String getMaleStPolOfInsFireIns() {
		return maleStPolOfInsFireIns;
	}

	public void setMaleStPolOfInsFireIns(String maleStPolOfInsFireIns) {
		this.maleStPolOfInsFireIns = maleStPolOfInsFireIns;
	}

	public String getMaleStPolOfInsOts() {
		return maleStPolOfInsOts;
	}

	public void setMaleStPolOfInsOts(String maleStPolOfInsOts) {
		this.maleStPolOfInsOts = maleStPolOfInsOts;
	}

	public String getMaleStPolOfInsRenewalOriginalPol() {
		return maleStPolOfInsRenewalOriginalPol;
	}

	public void setMaleStPolOfInsRenewalOriginalPol(String maleStPolOfInsRenewalOriginalPol) {
		this.maleStPolOfInsRenewalOriginalPol = maleStPolOfInsRenewalOriginalPol;
	}

	public String getMaleStPolOfInsAccidental() {
		return maleStPolOfInsAccidental;
	}

	public void setMaleStPolOfInsAccidental(String maleStPolOfInsAccidental) {
		this.maleStPolOfInsAccidental = maleStPolOfInsAccidental;
	}

	public String getMaleStPolOfInsNotExceedOneThousand() {
		return maleStPolOfInsNotExceedOneThousand;
	}

	public void setMaleStPolOfInsNotExceedOneThousand(String maleStPolOfInsNotExceedOneThousand) {
		this.maleStPolOfInsNotExceedOneThousand = maleStPolOfInsNotExceedOneThousand;
	}

	public String getMaleStPolOfInsIndemnity() {
		return maleStPolOfInsIndemnity;
	}

	public void setMaleStPolOfInsIndemnity(String maleStPolOfInsIndemnity) {
		this.maleStPolOfInsIndemnity = maleStPolOfInsIndemnity;
	}

	public String getMaleStPolOfInsLifeIns() {
		return maleStPolOfInsLifeIns;
	}

	public void setMaleStPolOfInsLifeIns(String maleStPolOfInsLifeIns) {
		this.maleStPolOfInsLifeIns = maleStPolOfInsLifeIns;
	}

	public String getMaleStPolOfInsLessThanFiveHundred() {
		return maleStPolOfInsLessThanFiveHundred;
	}

	public void setMaleStPolOfInsLessThanFiveHundred(String maleStPolOfInsLessThanFiveHundred) {
		this.maleStPolOfInsLessThanFiveHundred = maleStPolOfInsLessThanFiveHundred;
	}

	public String getMaleStPolOfInsLessThanOneThousand() {
		return maleStPolOfInsLessThanOneThousand;
	}

	public void setMaleStPolOfInsLessThanOneThousand(String maleStPolOfInsLessThanOneThousand) {
		this.maleStPolOfInsLessThanOneThousand = maleStPolOfInsLessThanOneThousand;
	}

	public String getMaleStPolOfInsReIns() {
		return maleStPolOfInsReIns;
	}

	public void setMaleStPolOfInsReIns(String maleStPolOfInsReIns) {
		this.maleStPolOfInsReIns = maleStPolOfInsReIns;
	}

	public String getMaleStPwrOfAttorneySpecial() {
		return maleStPwrOfAttorneySpecial;
	}

	public void setMaleStPwrOfAttorneySpecial(String maleStPwrOfAttorneySpecial) {
		this.maleStPwrOfAttorneySpecial = maleStPwrOfAttorneySpecial;
	}

	public String getMaleStPwrOfAttorneyGeneral() {
		return maleStPwrOfAttorneyGeneral;
	}

	public void setMaleStPwrOfAttorneyGeneral(String maleStPwrOfAttorneyGeneral) {
		this.maleStPwrOfAttorneyGeneral = maleStPwrOfAttorneyGeneral;
	}

	public String getMaleStPromissoryNoteLessThanOneThousand() {
		return maleStPromissoryNoteLessThanOneThousand;
	}

	public void setMaleStPromissoryNoteLessThanOneThousand(String maleStPromissoryNoteLessThanOneThousand) {
		this.maleStPromissoryNoteLessThanOneThousand = maleStPromissoryNoteLessThanOneThousand;
	}

	public String getMaleStPromissoryNoteOtCases() {
		return maleStPromissoryNoteOtCases;
	}

	public void setMaleStPromissoryNoteOtCases(String maleStPromissoryNoteOtCases) {
		this.maleStPromissoryNoteOtCases = maleStPromissoryNoteOtCases;
	}

	public String getMaleStPromissoryNoteDemand() {
		return maleStPromissoryNoteDemand;
	}

	public void setMaleStPromissoryNoteDemand(String maleStPromissoryNoteDemand) {
		this.maleStPromissoryNoteDemand = maleStPromissoryNoteDemand;
	}

	public String getMaleStProtestOfBillOrNote() {
		return maleStProtestOfBillOrNote;
	}

	public void setMaleStProtestOfBillOrNote(String maleStProtestOfBillOrNote) {
		this.maleStProtestOfBillOrNote = maleStProtestOfBillOrNote;
	}

	public String getMaleStProtestByTheMasterOfShip() {
		return maleStProtestByTheMasterOfShip;
	}

	public void setMaleStProtestByTheMasterOfShip(String maleStProtestByTheMasterOfShip) {
		this.maleStProtestByTheMasterOfShip = maleStProtestByTheMasterOfShip;
	}

	public String getMaleStProxy() {
		return maleStProxy;
	}

	public void setMaleStProxy(String maleStProxy) {
		this.maleStProxy = maleStProxy;
	}

	public String getMaleStReceipt() {
		return maleStReceipt;
	}

	public void setMaleStReceipt(String maleStReceipt) {
		this.maleStReceipt = maleStReceipt;
	}

	public String getMaleStReconveyanceLessThanOneThousand() {
		return maleStReconveyanceLessThanOneThousand;
	}

	public void setMaleStReconveyanceLessThanOneThousand(String maleStReconveyanceLessThanOneThousand) {
		this.maleStReconveyanceLessThanOneThousand = maleStReconveyanceLessThanOneThousand;
	}

	public String getMaleStReconveyanceOts() {
		return maleStReconveyanceOts;
	}

	public void setMaleStReconveyanceOts(String maleStReconveyanceOts) {
		this.maleStReconveyanceOts = maleStReconveyanceOts;
	}

	public String getMaleStReleaseRelinquishmentOfRightLessThanOneThousand() {
		return maleStReleaseRelinquishmentOfRightLessThanOneThousand;
	}

	public void setMaleStReleaseRelinquishmentOfRightLessThanOneThousand(
			String maleStReleaseRelinquishmentOfRightLessThanOneThousand) {
		this.maleStReleaseRelinquishmentOfRightLessThanOneThousand = maleStReleaseRelinquishmentOfRightLessThanOneThousand;
	}

	public String getMaleStReleaseRelinquishmentOfRightOts() {
		return maleStReleaseRelinquishmentOfRightOts;
	}

	public void setMaleStReleaseRelinquishmentOfRightOts(String maleStReleaseRelinquishmentOfRightOts) {
		this.maleStReleaseRelinquishmentOfRightOts = maleStReleaseRelinquishmentOfRightOts;
	}

	public String getMaleStRespondentiaBond() {
		return maleStRespondentiaBond;
	}

	public void setMaleStRespondentiaBond(String maleStRespondentiaBond) {
		this.maleStRespondentiaBond = maleStRespondentiaBond;
	}

	public String getMaleStSecurityBond() {
		return maleStSecurityBond;
	}

	public void setMaleStSecurityBond(String maleStSecurityBond) {
		this.maleStSecurityBond = maleStSecurityBond;
	}

	public String getMaleStSettlementInstrument() {
		return maleStSettlementInstrument;
	}

	public void setMaleStSettlementInstrument(String maleStSettlementInstrument) {
		this.maleStSettlementInstrument = maleStSettlementInstrument;
	}

	public String getMaleStShareWarrents() {
		return maleStShareWarrents;
	}

	public void setMaleStShareWarrents(String maleStShareWarrents) {
		this.maleStShareWarrents = maleStShareWarrents;
	}

	public String getMaleStShippingOrder() {
		return maleStShippingOrder;
	}

	public void setMaleStShippingOrder(String maleStShippingOrder) {
		this.maleStShippingOrder = maleStShippingOrder;
	}

	public String getMaleStSurrenderOfLeaseNotExceesTen() {
		return maleStSurrenderOfLeaseNotExceesTen;
	}

	public void setMaleStSurrenderOfLeaseNotExceesTen(String maleStSurrenderOfLeaseNotExceesTen) {
		this.maleStSurrenderOfLeaseNotExceesTen = maleStSurrenderOfLeaseNotExceesTen;
	}

	public String getMaleStSurrenderOfLeaseOts() {
		return maleStSurrenderOfLeaseOts;
	}

	public void setMaleStSurrenderOfLeaseOts(String maleStSurrenderOfLeaseOts) {
		this.maleStSurrenderOfLeaseOts = maleStSurrenderOfLeaseOts;
	}

	public String getMaleStTransferOfShares() {
		return maleStTransferOfShares;
	}

	public void setMaleStTransferOfShares(String maleStTransferOfShares) {
		this.maleStTransferOfShares = maleStTransferOfShares;
	}

	public String getMaleStTransferOfDebentures() {
		return maleStTransferOfDebentures;
	}

	public void setMaleStTransferOfDebentures(String maleStTransferOfDebentures) {
		this.maleStTransferOfDebentures = maleStTransferOfDebentures;
	}

	public String getMaleStTransferSecuredBond() {
		return maleStTransferSecuredBond;
	}

	public void setMaleStTransferSecuredBond(String maleStTransferSecuredBond) {
		this.maleStTransferSecuredBond = maleStTransferSecuredBond;
	}

	public String getMaleStTransferMorgageDeed() {
		return maleStTransferMorgageDeed;
	}

	public void setMaleStTransferMorgageDeed(String maleStTransferMorgageDeed) {
		this.maleStTransferMorgageDeed = maleStTransferMorgageDeed;
	}

	public String getMaleStTransferOts() {
		return maleStTransferOts;
	}

	public void setMaleStTransferOts(String maleStTransferOts) {
		this.maleStTransferOts = maleStTransferOts;
	}

	public String getMaleStTransferAdministratorGeneral() {
		return maleStTransferAdministratorGeneral;
	}

	public void setMaleStTransferAdministratorGeneral(String maleStTransferAdministratorGeneral) {
		this.maleStTransferAdministratorGeneral = maleStTransferAdministratorGeneral;
	}

	public String getMaleStTransferTrustProperty() {
		return maleStTransferTrustProperty;
	}

	public void setMaleStTransferTrustProperty(String maleStTransferTrustProperty) {
		this.maleStTransferTrustProperty = maleStTransferTrustProperty;
	}

	public String getMaleStTransferofLease() {
		return maleStTransferofLease;
	}

	public void setMaleStTransferofLease(String maleStTransferofLease) {
		this.maleStTransferofLease = maleStTransferofLease;
	}

	public String getMaleStTrustBeingWill() {
		return maleStTrustBeingWill;
	}

	public void setMaleStTrustBeingWill(String maleStTrustBeingWill) {
		this.maleStTrustBeingWill = maleStTrustBeingWill;
	}

	public String getMaleStTrustNotBeingWill() {
		return maleStTrustNotBeingWill;
	}

	public void setMaleStTrustNotBeingWill(String maleStTrustNotBeingWill) {
		this.maleStTrustNotBeingWill = maleStTrustNotBeingWill;
	}

	public String getMaleStWarrentGoods() {
		return maleStWarrentGoods;
	}

	public void setMaleStWarrentGoods(String maleStWarrentGoods) {
		this.maleStWarrentGoods = maleStWarrentGoods;
	}

	public String getMaleRegisAcknowledgement() {
		return maleRegisAcknowledgement;
	}

	public void setMaleRegisAcknowledgement(String maleRegisAcknowledgement) {
		this.maleRegisAcknowledgement = maleRegisAcknowledgement;
	}

	public String getMaleRegisAdministrativeBond() {
		return maleRegisAdministrativeBond;
	}

	public void setMaleRegisAdministrativeBond(String maleRegisAdministrativeBond) {
		this.maleRegisAdministrativeBond = maleRegisAdministrativeBond;
	}

	public String getMaleRegisAdoptionDeed() {
		return maleRegisAdoptionDeed;
	}

	public void setMaleRegisAdoptionDeed(String maleRegisAdoptionDeed) {
		this.maleRegisAdoptionDeed = maleRegisAdoptionDeed;
	}

	public String getMaleRegisAffidavitIncAffOfDeclaration() {
		return maleRegisAffidavitIncAffOfDeclaration;
	}

	public void setMaleRegisAffidavitIncAffOfDeclaration(String maleRegisAffidavitIncAffOfDeclaration) {
		this.maleRegisAffidavitIncAffOfDeclaration = maleRegisAffidavitIncAffOfDeclaration;
	}

	public String getMaleRegisAgreementOfConveyance() {
		return maleRegisAgreementOfConveyance;
	}

	public void setMaleRegisAgreementOfConveyance(String maleRegisAgreementOfConveyance) {
		this.maleRegisAgreementOfConveyance = maleRegisAgreementOfConveyance;
	}

	public String getMaleRegisAgreementDevelopment() {
		return maleRegisAgreementDevelopment;
	}

	public void setMaleRegisAgreementDevelopment(String maleRegisAgreementDevelopment) {
		this.maleRegisAgreementDevelopment = maleRegisAgreementDevelopment;
	}

	public String getMaleRegisAgreementOts() {
		return maleRegisAgreementOts;
	}

	public void setMaleRegisAgreementOts(String maleRegisAgreementOts) {
		this.maleRegisAgreementOts = maleRegisAgreementOts;
	}

	public String getMaleRegisAgreeRelatDawnOrPledgeExceedLessThanOneThousand() {
		return maleRegisAgreeRelatDawnOrPledgeExceedLessThanOneThousand;
	}

	public void setMaleRegisAgreeRelatDawnOrPledgeExceedLessThanOneThousand(
			String maleRegisAgreeRelatDawnOrPledgeExceedLessThanOneThousand) {
		this.maleRegisAgreeRelatDawnOrPledgeExceedLessThanOneThousand = maleRegisAgreeRelatDawnOrPledgeExceedLessThanOneThousand;
	}

	public String getMaleRegisAgreeRelatDawnOrPledgeExceedLessThanTenThousand() {
		return maleRegisAgreeRelatDawnOrPledgeExceedLessThanTenThousand;
	}

	public void setMaleRegisAgreeRelatDawnOrPledgeExceedLessThanTenThousand(
			String maleRegisAgreeRelatDawnOrPledgeExceedLessThanTenThousand) {
		this.maleRegisAgreeRelatDawnOrPledgeExceedLessThanTenThousand = maleRegisAgreeRelatDawnOrPledgeExceedLessThanTenThousand;
	}

	public String getMaleRegisAgreeRelatDawnOrPledgeExceedMoreThanTenThousand() {
		return maleRegisAgreeRelatDawnOrPledgeExceedMoreThanTenThousand;
	}

	public void setMaleRegisAgreeRelatDawnOrPledgeExceedMoreThanTenThousand(
			String maleRegisAgreeRelatDawnOrPledgeExceedMoreThanTenThousand) {
		this.maleRegisAgreeRelatDawnOrPledgeExceedMoreThanTenThousand = maleRegisAgreeRelatDawnOrPledgeExceedMoreThanTenThousand;
	}

	public String getMaleRegisAgreeRelatDawnOrPledgeThreeMonths() {
		return maleRegisAgreeRelatDawnOrPledgeThreeMonths;
	}

	public void setMaleRegisAgreeRelatDawnOrPledgeThreeMonths(String maleRegisAgreeRelatDawnOrPledgeThreeMonths) {
		this.maleRegisAgreeRelatDawnOrPledgeThreeMonths = maleRegisAgreeRelatDawnOrPledgeThreeMonths;
	}

	public String getMaleRegisAppointmentInExecutionOfPwr() {
		return maleRegisAppointmentInExecutionOfPwr;
	}

	public void setMaleRegisAppointmentInExecutionOfPwr(String maleRegisAppointmentInExecutionOfPwr) {
		this.maleRegisAppointmentInExecutionOfPwr = maleRegisAppointmentInExecutionOfPwr;
	}

	public String getMaleRegisAppOrValNotExceed() {
		return maleRegisAppOrValNotExceed;
	}

	public void setMaleRegisAppOrValNotExceed(String maleRegisAppOrValNotExceed) {
		this.maleRegisAppOrValNotExceed = maleRegisAppOrValNotExceed;
	}

	public String getMaleRegisAppOrValOtCase() {
		return maleRegisAppOrValOtCase;
	}

	public void setMaleRegisAppOrValOtCase(String maleRegisAppOrValOtCase) {
		this.maleRegisAppOrValOtCase = maleRegisAppOrValOtCase;
	}

	public String getMaleRegisApprenticeshipDeed() {
		return maleRegisApprenticeshipDeed;
	}

	public void setMaleRegisApprenticeshipDeed(String maleRegisApprenticeshipDeed) {
		this.maleRegisApprenticeshipDeed = maleRegisApprenticeshipDeed;
	}

	public String getMaleRegisArtsOfAssoOfCompanyNotExceed() {
		return maleRegisArtsOfAssoOfCompanyNotExceed;
	}

	public void setMaleRegisArtsOfAssoOfCompanyNotExceed(String maleRegisArtsOfAssoOfCompanyNotExceed) {
		this.maleRegisArtsOfAssoOfCompanyNotExceed = maleRegisArtsOfAssoOfCompanyNotExceed;
	}

	public String getMaleRegisArtsOfAssoOfCompanyAbove() {
		return maleRegisArtsOfAssoOfCompanyAbove;
	}

	public void setMaleRegisArtsOfAssoOfCompanyAbove(String maleRegisArtsOfAssoOfCompanyAbove) {
		this.maleRegisArtsOfAssoOfCompanyAbove = maleRegisArtsOfAssoOfCompanyAbove;
	}

	public String getMaleRegisArtsOfClerkship() {
		return maleRegisArtsOfClerkship;
	}

	public void setMaleRegisArtsOfClerkship(String maleRegisArtsOfClerkship) {
		this.maleRegisArtsOfClerkship = maleRegisArtsOfClerkship;
	}

	public String getMaleRegisAwardNotExceed() {
		return maleRegisAwardNotExceed;
	}

	public void setMaleRegisAwardNotExceed(String maleRegisAwardNotExceed) {
		this.maleRegisAwardNotExceed = maleRegisAwardNotExceed;
	}

	public String getMaleRegisAwardExceed() {
		return maleRegisAwardExceed;
	}

	public void setMaleRegisAwardExceed(String maleRegisAwardExceed) {
		this.maleRegisAwardExceed = maleRegisAwardExceed;
	}

	public String getMaleRegisBillOfExchangeWherePayableOtwise() {
		return maleRegisBillOfExchangeWherePayableOtwise;
	}

	public void setMaleRegisBillOfExchangeWherePayableOtwise(String maleRegisBillOfExchangeWherePayableOtwise) {
		this.maleRegisBillOfExchangeWherePayableOtwise = maleRegisBillOfExchangeWherePayableOtwise;
	}

	public String getMaleRegisBillOfLading() {
		return maleRegisBillOfLading;
	}

	public void setMaleRegisBillOfLading(String maleRegisBillOfLading) {
		this.maleRegisBillOfLading = maleRegisBillOfLading;
	}

	public String getMaleRegisBond() {
		return maleRegisBond;
	}

	public void setMaleRegisBond(String maleRegisBond) {
		this.maleRegisBond = maleRegisBond;
	}

	public String getMaleRegisBottomryBond() {
		return maleRegisBottomryBond;
	}

	public void setMaleRegisBottomryBond(String maleRegisBottomryBond) {
		this.maleRegisBottomryBond = maleRegisBottomryBond;
	}

	public String getMaleRegisCancellation() {
		return maleRegisCancellation;
	}

	public void setMaleRegisCancellation(String maleRegisCancellation) {
		this.maleRegisCancellation = maleRegisCancellation;
	}

	public String getMaleRegisCertificateOfSale() {
		return maleRegisCertificateOfSale;
	}

	public void setMaleRegisCertificateOfSale(String maleRegisCertificateOfSale) {
		this.maleRegisCertificateOfSale = maleRegisCertificateOfSale;
	}

	public String getMaleRegisCertificateOrOtDocument() {
		return maleRegisCertificateOrOtDocument;
	}

	public void setMaleRegisCertificateOrOtDocument(String maleRegisCertificateOrOtDocument) {
		this.maleRegisCertificateOrOtDocument = maleRegisCertificateOrOtDocument;
	}

	public String getMaleRegisCharterParty() {
		return maleRegisCharterParty;
	}

	public void setMaleRegisCharterParty(String maleRegisCharterParty) {
		this.maleRegisCharterParty = maleRegisCharterParty;
	}

	public String getMaleRegisCompositionDeed() {
		return maleRegisCompositionDeed;
	}

	public void setMaleRegisCompositionDeed(String maleRegisCompositionDeed) {
		this.maleRegisCompositionDeed = maleRegisCompositionDeed;
	}

	public String getMaleRegisSaleConveyance() {
		return maleRegisSaleConveyance;
	}

	public void setMaleRegisSaleConveyance(String maleRegisSaleConveyance) {
		this.maleRegisSaleConveyance = maleRegisSaleConveyance;
	}

	public String getMaleRegisCertifiedCopy() {
		return maleRegisCertifiedCopy;
	}

	public void setMaleRegisCertifiedCopy(String maleRegisCertifiedCopy) {
		this.maleRegisCertifiedCopy = maleRegisCertifiedCopy;
	}

	public String getMaleRegisCounterpartOrDuplicateOfAnyInstrument() {
		return maleRegisCounterpartOrDuplicateOfAnyInstrument;
	}

	public void setMaleRegisCounterpartOrDuplicateOfAnyInstrument(String maleRegisCounterpartOrDuplicateOfAnyInstrument) {
		this.maleRegisCounterpartOrDuplicateOfAnyInstrument = maleRegisCounterpartOrDuplicateOfAnyInstrument;
	}

	public String getMaleRegisCustomsBondNotExceed() {
		return maleRegisCustomsBondNotExceed;
	}

	public void setMaleRegisCustomsBondNotExceed(String maleRegisCustomsBondNotExceed) {
		this.maleRegisCustomsBondNotExceed = maleRegisCustomsBondNotExceed;
	}

	public String getMaleRegisCustomsBondOtCase() {
		return maleRegisCustomsBondOtCase;
	}

	public void setMaleRegisCustomsBondOtCase(String maleRegisCustomsBondOtCase) {
		this.maleRegisCustomsBondOtCase = maleRegisCustomsBondOtCase;
	}

	public String getMaleRegisDebenture() {
		return maleRegisDebenture;
	}

	public void setMaleRegisDebenture(String maleRegisDebenture) {
		this.maleRegisDebenture = maleRegisDebenture;
	}

	public String getMaleRegisDebentureEndorsedNotExceed() {
		return maleRegisDebentureEndorsedNotExceed;
	}

	public void setMaleRegisDebentureEndorsedNotExceed(String maleRegisDebentureEndorsedNotExceed) {
		this.maleRegisDebentureEndorsedNotExceed = maleRegisDebentureEndorsedNotExceed;
	}

	public String getMaleRegisDebentureEndorsedExcess() {
		return maleRegisDebentureEndorsedExcess;
	}

	public void setMaleRegisDebentureEndorsedExcess(String maleRegisDebentureEndorsedExcess) {
		this.maleRegisDebentureEndorsedExcess = maleRegisDebentureEndorsedExcess;
	}

	public String getMaleRegisDebentureDeliveryNotExceed() {
		return maleRegisDebentureDeliveryNotExceed;
	}

	public void setMaleRegisDebentureDeliveryNotExceed(String maleRegisDebentureDeliveryNotExceed) {
		this.maleRegisDebentureDeliveryNotExceed = maleRegisDebentureDeliveryNotExceed;
	}

	public String getMaleRegisDebentureDeliveryExcess() {
		return maleRegisDebentureDeliveryExcess;
	}

	public void setMaleRegisDebentureDeliveryExcess(String maleRegisDebentureDeliveryExcess) {
		this.maleRegisDebentureDeliveryExcess = maleRegisDebentureDeliveryExcess;
	}

	public String getMaleRegisDeliveryOrderInRespectofGoods() {
		return maleRegisDeliveryOrderInRespectofGoods;
	}

	public void setMaleRegisDeliveryOrderInRespectofGoods(String maleRegisDeliveryOrderInRespectofGoods) {
		this.maleRegisDeliveryOrderInRespectofGoods = maleRegisDeliveryOrderInRespectofGoods;
	}

	public String getMaleRegisDivorceDeed() {
		return maleRegisDivorceDeed;
	}

	public void setMaleRegisDivorceDeed(String maleRegisDivorceDeed) {
		this.maleRegisDivorceDeed = maleRegisDivorceDeed;
	}

	public String getMaleRegisEntryAsAnAdvocateAdvocate() {
		return maleRegisEntryAsAnAdvocateAdvocate;
	}

	public void setMaleRegisEntryAsAnAdvocateAdvocate(String maleRegisEntryAsAnAdvocateAdvocate) {
		this.maleRegisEntryAsAnAdvocateAdvocate = maleRegisEntryAsAnAdvocateAdvocate;
	}

	public String getMaleRegisEntryAsAnAdvocateAttorney() {
		return maleRegisEntryAsAnAdvocateAttorney;
	}

	public void setMaleRegisEntryAsAnAdvocateAttorney(String maleRegisEntryAsAnAdvocateAttorney) {
		this.maleRegisEntryAsAnAdvocateAttorney = maleRegisEntryAsAnAdvocateAttorney;
	}

	public String getMaleRegisExchangeOfProperty() {
		return maleRegisExchangeOfProperty;
	}

	public void setMaleRegisExchangeOfProperty(String maleRegisExchangeOfProperty) {
		this.maleRegisExchangeOfProperty = maleRegisExchangeOfProperty;
	}

	public String getMaleRegisFutherChargeWithPossession() {
		return maleRegisFutherChargeWithPossession;
	}

	public void setMaleRegisFutherChargeWithPossession(String maleRegisFutherChargeWithPossession) {
		this.maleRegisFutherChargeWithPossession = maleRegisFutherChargeWithPossession;
	}

	public String getMaleRegisFutherChargeWithoutPossession() {
		return maleRegisFutherChargeWithoutPossession;
	}

	public void setMaleRegisFutherChargeWithoutPossession(String maleRegisFutherChargeWithoutPossession) {
		this.maleRegisFutherChargeWithoutPossession = maleRegisFutherChargeWithoutPossession;
	}

	public String getMaleRegisFutherChargtPossessionGiven() {
		return maleRegisFutherChargtPossessionGiven;
	}

	public void setMaleRegisFutherChargtPossessionGiven(String maleRegisFutherChargtPossessionGiven) {
		this.maleRegisFutherChargtPossessionGiven = maleRegisFutherChargtPossessionGiven;
	}

	public String getMaleRegisFutherChargePossessionNotGiven() {
		return maleRegisFutherChargePossessionNotGiven;
	}

	public void setMaleRegisFutherChargePossessionNotGiven(String maleRegisFutherChargePossessionNotGiven) {
		this.maleRegisFutherChargePossessionNotGiven = maleRegisFutherChargePossessionNotGiven;
	}

	public String getMaleRegisGiftDeed() {
		return maleRegisGiftDeed;
	}

	public void setMaleRegisGiftDeed(String maleRegisGiftDeed) {
		this.maleRegisGiftDeed = maleRegisGiftDeed;
	}

	public String getMaleRegisIndemnityBond() {
		return maleRegisIndemnityBond;
	}

	public void setMaleRegisIndemnityBond(String maleRegisIndemnityBond) {
		this.maleRegisIndemnityBond = maleRegisIndemnityBond;
	}

	public String getMaleRegisLeaseRentFixed() {
		return maleRegisLeaseRentFixed;
	}

	public void setMaleRegisLeaseRentFixed(String maleRegisLeaseRentFixed) {
		this.maleRegisLeaseRentFixed = maleRegisLeaseRentFixed;
	}

	public String getMaleRegisLeaseLessThanOneYear() {
		return maleRegisLeaseLessThanOneYear;
	}

	public void setMaleRegisLeaseLessThanOneYear(String maleRegisLeaseLessThanOneYear) {
		this.maleRegisLeaseLessThanOneYear = maleRegisLeaseLessThanOneYear;
	}

	public String getMaleRegisLeaseLessThanFiveYear() {
		return maleRegisLeaseLessThanFiveYear;
	}

	public void setMaleRegisLeaseLessThanFiveYear(String maleRegisLeaseLessThanFiveYear) {
		this.maleRegisLeaseLessThanFiveYear = maleRegisLeaseLessThanFiveYear;
	}

	public String getMaleRegisLeaseLessThanTenYear() {
		return maleRegisLeaseLessThanTenYear;
	}

	public void setMaleRegisLeaseLessThanTenYear(String maleRegisLeaseLessThanTenYear) {
		this.maleRegisLeaseLessThanTenYear = maleRegisLeaseLessThanTenYear;
	}

	public String getMaleRegisLeaseLessThanTwentyYear() {
		return maleRegisLeaseLessThanTwentyYear;
	}

	public void setMaleRegisLeaseLessThanTwentyYear(String maleRegisLeaseLessThanTwentyYear) {
		this.maleRegisLeaseLessThanTwentyYear = maleRegisLeaseLessThanTwentyYear;
	}

	public String getMaleRegisLeaseLessThanThirtyYear() {
		return maleRegisLeaseLessThanThirtyYear;
	}

	public void setMaleRegisLeaseLessThanThirtyYear(String maleRegisLeaseLessThanThirtyYear) {
		this.maleRegisLeaseLessThanThirtyYear = maleRegisLeaseLessThanThirtyYear;
	}

	public String getMaleRegisLeaseLessThanHundredYear() {
		return maleRegisLeaseLessThanHundredYear;
	}

	public void setMaleRegisLeaseLessThanHundredYear(String maleRegisLeaseLessThanHundredYear) {
		this.maleRegisLeaseLessThanHundredYear = maleRegisLeaseLessThanHundredYear;
	}

	public String getMaleRegisLeaseMoreThanHundredYear() {
		return maleRegisLeaseMoreThanHundredYear;
	}

	public void setMaleRegisLeaseMoreThanHundredYear(String maleRegisLeaseMoreThanHundredYear) {
		this.maleRegisLeaseMoreThanHundredYear = maleRegisLeaseMoreThanHundredYear;
	}

	public String getMaleRegisLeaseNotDefiniteTerm() {
		return maleRegisLeaseNotDefiniteTerm;
	}

	public void setMaleRegisLeaseNotDefiniteTerm(String maleRegisLeaseNotDefiniteTerm) {
		this.maleRegisLeaseNotDefiniteTerm = maleRegisLeaseNotDefiniteTerm;
	}

	public String getMaleRegisLeaseNoRentReserved() {
		return maleRegisLeaseNoRentReserved;
	}

	public void setMaleRegisLeaseNoRentReserved(String maleRegisLeaseNoRentReserved) {
		this.maleRegisLeaseNoRentReserved = maleRegisLeaseNoRentReserved;
	}

	public String getMaleRegisLeaseAdditionOnRentReserved() {
		return maleRegisLeaseAdditionOnRentReserved;
	}

	public void setMaleRegisLeaseAdditionOnRentReserved(String maleRegisLeaseAdditionOnRentReserved) {
		this.maleRegisLeaseAdditionOnRentReserved = maleRegisLeaseAdditionOnRentReserved;
	}

	public String getMaleRegisLeaseRevisionNotification() {
		return maleRegisLeaseRevisionNotification;
	}

	public void setMaleRegisLeaseRevisionNotification(String maleRegisLeaseRevisionNotification) {
		this.maleRegisLeaseRevisionNotification = maleRegisLeaseRevisionNotification;
	}

	public String getMaleRegisLetterOfAllotmentOfShares() {
		return maleRegisLetterOfAllotmentOfShares;
	}

	public void setMaleRegisLetterOfAllotmentOfShares(String maleRegisLetterOfAllotmentOfShares) {
		this.maleRegisLetterOfAllotmentOfShares = maleRegisLetterOfAllotmentOfShares;
	}

	public String getMaleRegisLetterOfCredit() {
		return maleRegisLetterOfCredit;
	}

	public void setMaleRegisLetterOfCredit(String maleRegisLetterOfCredit) {
		this.maleRegisLetterOfCredit = maleRegisLetterOfCredit;
	}

	public String getMaleRegisLetterOfLicence() {
		return maleRegisLetterOfLicence;
	}

	public void setMaleRegisLetterOfLicence(String maleRegisLetterOfLicence) {
		this.maleRegisLetterOfLicence = maleRegisLetterOfLicence;
	}

	public String getMaleRegisMemorandumOfAssoOfCompany() {
		return maleRegisMemorandumOfAssoOfCompany;
	}

	public void setMaleRegisMemorandumOfAssoOfCompany(String maleRegisMemorandumOfAssoOfCompany) {
		this.maleRegisMemorandumOfAssoOfCompany = maleRegisMemorandumOfAssoOfCompany;
	}

	public String getMaleRegisMortgageWithPossession() {
		return maleRegisMortgageWithPossession;
	}

	public void setMaleRegisMortgageWithPossession(String maleRegisMortgageWithPossession) {
		this.maleRegisMortgageWithPossession = maleRegisMortgageWithPossession;
	}

	public String getMaleRegisMortgageWithoutPossession() {
		return maleRegisMortgageWithoutPossession;
	}

	public void setMaleRegisMortgageWithoutPossession(String maleRegisMortgageWithoutPossession) {
		this.maleRegisMortgageWithoutPossession = maleRegisMortgageWithoutPossession;
	}

	public String getMaleRegisMortgageOfCropLessThanThree() {
		return maleRegisMortgageOfCropLessThanThree;
	}

	public void setMaleRegisMortgageOfCropLessThanThree(String maleRegisMortgageOfCropLessThanThree) {
		this.maleRegisMortgageOfCropLessThanThree = maleRegisMortgageOfCropLessThanThree;
	}

	public String getMaleRegisMortgageOfCropMoreThanThree() {
		return maleRegisMortgageOfCropMoreThanThree;
	}

	public void setMaleRegisMortgageOfCropMoreThanThree(String maleRegisMortgageOfCropMoreThanThree) {
		this.maleRegisMortgageOfCropMoreThanThree = maleRegisMortgageOfCropMoreThanThree;
	}

	public String getMaleRegisNotarialAct() {
		return maleRegisNotarialAct;
	}

	public void setMaleRegisNotarialAct(String maleRegisNotarialAct) {
		this.maleRegisNotarialAct = maleRegisNotarialAct;
	}

	public String getMaleRegisNoteOrMemorandum() {
		return maleRegisNoteOrMemorandum;
	}

	public void setMaleRegisNoteOrMemorandum(String maleRegisNoteOrMemorandum) {
		this.maleRegisNoteOrMemorandum = maleRegisNoteOrMemorandum;
	}

	public String getMaleRegisNoteOfProtestByTheMasterOfShip() {
		return maleRegisNoteOfProtestByTheMasterOfShip;
	}

	public void setMaleRegisNoteOfProtestByTheMasterOfShip(String maleRegisNoteOfProtestByTheMasterOfShip) {
		this.maleRegisNoteOfProtestByTheMasterOfShip = maleRegisNoteOfProtestByTheMasterOfShip;
	}

	public String getMaleRegisPartitionDeed() {
		return maleRegisPartitionDeed;
	}

	public void setMaleRegisPartitionDeed(String maleRegisPartitionDeed) {
		this.maleRegisPartitionDeed = maleRegisPartitionDeed;
	}

	public String getMaleRegisPartnerShip() {
		return maleRegisPartnerShip;
	}

	public void setMaleRegisPartnerShip(String maleRegisPartnerShip) {
		this.maleRegisPartnerShip = maleRegisPartnerShip;
	}

	public String getMaleRegisPartnerShipDissolution() {
		return maleRegisPartnerShipDissolution;
	}

	public void setMaleRegisPartnerShipDissolution(String maleRegisPartnerShipDissolution) {
		this.maleRegisPartnerShipDissolution = maleRegisPartnerShipDissolution;
	}

	public String getMaleRegisPolOfInsLessThanEighteen() {
		return maleRegisPolOfInsLessThanEighteen;
	}

	public void setMaleRegisPolOfInsLessThanEighteen(String maleRegisPolOfInsLessThanEighteen) {
		this.maleRegisPolOfInsLessThanEighteen = maleRegisPolOfInsLessThanEighteen;
	}

	public String getMaleRegisPolOfInsOneThousandFiveHundred() {
		return maleRegisPolOfInsOneThousandFiveHundred;
	}

	public void setMaleRegisPolOfInsOneThousandFiveHundred(String maleRegisPolOfInsOneThousandFiveHundred) {
		this.maleRegisPolOfInsOneThousandFiveHundred = maleRegisPolOfInsOneThousandFiveHundred;
	}

	public String getMaleRegisPolOfInsOneThousand() {
		return maleRegisPolOfInsOneThousand;
	}

	public void setMaleRegisPolOfInsOneThousand(String maleRegisPolOfInsOneThousand) {
		this.maleRegisPolOfInsOneThousand = maleRegisPolOfInsOneThousand;
	}

	public String getMaleRegisPolOfInsFireIns() {
		return maleRegisPolOfInsFireIns;
	}

	public void setMaleRegisPolOfInsFireIns(String maleRegisPolOfInsFireIns) {
		this.maleRegisPolOfInsFireIns = maleRegisPolOfInsFireIns;
	}

	public String getMaleRegisPolOfInsOts() {
		return maleRegisPolOfInsOts;
	}

	public void setMaleRegisPolOfInsOts(String maleRegisPolOfInsOts) {
		this.maleRegisPolOfInsOts = maleRegisPolOfInsOts;
	}

	public String getMaleRegisPolOfInsRenewalOriginalPol() {
		return maleRegisPolOfInsRenewalOriginalPol;
	}

	public void setMaleRegisPolOfInsRenewalOriginalPol(String maleRegisPolOfInsRenewalOriginalPol) {
		this.maleRegisPolOfInsRenewalOriginalPol = maleRegisPolOfInsRenewalOriginalPol;
	}

	public String getMaleRegisPolOfInsAccidental() {
		return maleRegisPolOfInsAccidental;
	}

	public void setMaleRegisPolOfInsAccidental(String maleRegisPolOfInsAccidental) {
		this.maleRegisPolOfInsAccidental = maleRegisPolOfInsAccidental;
	}

	public String getMaleRegisPolOfInsNotExceedOneThousand() {
		return maleRegisPolOfInsNotExceedOneThousand;
	}

	public void setMaleRegisPolOfInsNotExceedOneThousand(String maleRegisPolOfInsNotExceedOneThousand) {
		this.maleRegisPolOfInsNotExceedOneThousand = maleRegisPolOfInsNotExceedOneThousand;
	}

	public String getMaleRegisPolOfInsIndemnity() {
		return maleRegisPolOfInsIndemnity;
	}

	public void setMaleRegisPolOfInsIndemnity(String maleRegisPolOfInsIndemnity) {
		this.maleRegisPolOfInsIndemnity = maleRegisPolOfInsIndemnity;
	}

	public String getMaleRegisPolOfInsLifeIns() {
		return maleRegisPolOfInsLifeIns;
	}

	public void setMaleRegisPolOfInsLifeIns(String maleRegisPolOfInsLifeIns) {
		this.maleRegisPolOfInsLifeIns = maleRegisPolOfInsLifeIns;
	}

	public String getMaleRegisPolOfInsLessThanFiveHundred() {
		return maleRegisPolOfInsLessThanFiveHundred;
	}

	public void setMaleRegisPolOfInsLessThanFiveHundred(String maleRegisPolOfInsLessThanFiveHundred) {
		this.maleRegisPolOfInsLessThanFiveHundred = maleRegisPolOfInsLessThanFiveHundred;
	}

	public String getMaleRegisPolOfInsLessThanOneThousand() {
		return maleRegisPolOfInsLessThanOneThousand;
	}

	public void setMaleRegisPolOfInsLessThanOneThousand(String maleRegisPolOfInsLessThanOneThousand) {
		this.maleRegisPolOfInsLessThanOneThousand = maleRegisPolOfInsLessThanOneThousand;
	}

	public String getMaleRegisPolOfInsReIns() {
		return maleRegisPolOfInsReIns;
	}

	public void setMaleRegisPolOfInsReIns(String maleRegisPolOfInsReIns) {
		this.maleRegisPolOfInsReIns = maleRegisPolOfInsReIns;
	}

	public String getMaleRegisPwrOfAttorneySpecial() {
		return maleRegisPwrOfAttorneySpecial;
	}

	public void setMaleRegisPwrOfAttorneySpecial(String maleRegisPwrOfAttorneySpecial) {
		this.maleRegisPwrOfAttorneySpecial = maleRegisPwrOfAttorneySpecial;
	}

	public String getMaleRegisPwrOfAttorneyGeneral() {
		return maleRegisPwrOfAttorneyGeneral;
	}

	public void setMaleRegisPwrOfAttorneyGeneral(String maleRegisPwrOfAttorneyGeneral) {
		this.maleRegisPwrOfAttorneyGeneral = maleRegisPwrOfAttorneyGeneral;
	}

	public String getMaleRegisPromissoryNoteLessThanOneThousand() {
		return maleRegisPromissoryNoteLessThanOneThousand;
	}

	public void setMaleRegisPromissoryNoteLessThanOneThousand(String maleRegisPromissoryNoteLessThanOneThousand) {
		this.maleRegisPromissoryNoteLessThanOneThousand = maleRegisPromissoryNoteLessThanOneThousand;
	}

	public String getMaleRegisPromissoryNoteOtCases() {
		return maleRegisPromissoryNoteOtCases;
	}

	public void setMaleRegisPromissoryNoteOtCases(String maleRegisPromissoryNoteOtCases) {
		this.maleRegisPromissoryNoteOtCases = maleRegisPromissoryNoteOtCases;
	}

	public String getMaleRegisPromissoryNoteDemand() {
		return maleRegisPromissoryNoteDemand;
	}

	public void setMaleRegisPromissoryNoteDemand(String maleRegisPromissoryNoteDemand) {
		this.maleRegisPromissoryNoteDemand = maleRegisPromissoryNoteDemand;
	}

	public String getMaleRegisProtestOfBillOrNote() {
		return maleRegisProtestOfBillOrNote;
	}

	public void setMaleRegisProtestOfBillOrNote(String maleRegisProtestOfBillOrNote) {
		this.maleRegisProtestOfBillOrNote = maleRegisProtestOfBillOrNote;
	}

	public String getMaleRegisProtestByTheMasterOfShip() {
		return maleRegisProtestByTheMasterOfShip;
	}

	public void setMaleRegisProtestByTheMasterOfShip(String maleRegisProtestByTheMasterOfShip) {
		this.maleRegisProtestByTheMasterOfShip = maleRegisProtestByTheMasterOfShip;
	}

	public String getMaleRegisProxy() {
		return maleRegisProxy;
	}

	public void setMaleRegisProxy(String maleRegisProxy) {
		this.maleRegisProxy = maleRegisProxy;
	}

	public String getMaleRegisReceipt() {
		return maleRegisReceipt;
	}

	public void setMaleRegisReceipt(String maleRegisReceipt) {
		this.maleRegisReceipt = maleRegisReceipt;
	}

	public String getMaleRegisReconveyanceLessThanOneThousand() {
		return maleRegisReconveyanceLessThanOneThousand;
	}

	public void setMaleRegisReconveyanceLessThanOneThousand(String maleRegisReconveyanceLessThanOneThousand) {
		this.maleRegisReconveyanceLessThanOneThousand = maleRegisReconveyanceLessThanOneThousand;
	}

	public String getMaleRegisReconveyanceOts() {
		return maleRegisReconveyanceOts;
	}

	public void setMaleRegisReconveyanceOts(String maleRegisReconveyanceOts) {
		this.maleRegisReconveyanceOts = maleRegisReconveyanceOts;
	}

	public String getMaleRegisReleaseRelinquishmentOfRightLessThanOneThousand() {
		return maleRegisReleaseRelinquishmentOfRightLessThanOneThousand;
	}

	public void setMaleRegisReleaseRelinquishmentOfRightLessThanOneThousand(
			String maleRegisReleaseRelinquishmentOfRightLessThanOneThousand) {
		this.maleRegisReleaseRelinquishmentOfRightLessThanOneThousand = maleRegisReleaseRelinquishmentOfRightLessThanOneThousand;
	}

	public String getMaleRegisReleaseRelinquishmentOfRightOts() {
		return maleRegisReleaseRelinquishmentOfRightOts;
	}

	public void setMaleRegisReleaseRelinquishmentOfRightOts(String maleRegisReleaseRelinquishmentOfRightOts) {
		this.maleRegisReleaseRelinquishmentOfRightOts = maleRegisReleaseRelinquishmentOfRightOts;
	}

	public String getMaleRegisRespondentiaBond() {
		return maleRegisRespondentiaBond;
	}

	public void setMaleRegisRespondentiaBond(String maleRegisRespondentiaBond) {
		this.maleRegisRespondentiaBond = maleRegisRespondentiaBond;
	}

	public String getMaleRegisSecurityBond() {
		return maleRegisSecurityBond;
	}

	public void setMaleRegisSecurityBond(String maleRegisSecurityBond) {
		this.maleRegisSecurityBond = maleRegisSecurityBond;
	}

	public String getMaleRegisSettlementInstrument() {
		return maleRegisSettlementInstrument;
	}

	public void setMaleRegisSettlementInstrument(String maleRegisSettlementInstrument) {
		this.maleRegisSettlementInstrument = maleRegisSettlementInstrument;
	}

	public String getMaleRegisShareWarrents() {
		return maleRegisShareWarrents;
	}

	public void setMaleRegisShareWarrents(String maleRegisShareWarrents) {
		this.maleRegisShareWarrents = maleRegisShareWarrents;
	}

	public String getMaleRegisShippingOrder() {
		return maleRegisShippingOrder;
	}

	public void setMaleRegisShippingOrder(String maleRegisShippingOrder) {
		this.maleRegisShippingOrder = maleRegisShippingOrder;
	}

	public String getMaleRegisSurrenderOfLeaseNotExceesTen() {
		return maleRegisSurrenderOfLeaseNotExceesTen;
	}

	public void setMaleRegisSurrenderOfLeaseNotExceesTen(String maleRegisSurrenderOfLeaseNotExceesTen) {
		this.maleRegisSurrenderOfLeaseNotExceesTen = maleRegisSurrenderOfLeaseNotExceesTen;
	}

	public String getMaleRegisSurrenderOfLeaseOts() {
		return maleRegisSurrenderOfLeaseOts;
	}

	public void setMaleRegisSurrenderOfLeaseOts(String maleRegisSurrenderOfLeaseOts) {
		this.maleRegisSurrenderOfLeaseOts = maleRegisSurrenderOfLeaseOts;
	}

	public String getMaleRegisTransferOfShares() {
		return maleRegisTransferOfShares;
	}

	public void setMaleRegisTransferOfShares(String maleRegisTransferOfShares) {
		this.maleRegisTransferOfShares = maleRegisTransferOfShares;
	}

	public String getMaleRegisTransferOfDebentures() {
		return maleRegisTransferOfDebentures;
	}

	public void setMaleRegisTransferOfDebentures(String maleRegisTransferOfDebentures) {
		this.maleRegisTransferOfDebentures = maleRegisTransferOfDebentures;
	}

	public String getMaleRegisTransferSecuredBond() {
		return maleRegisTransferSecuredBond;
	}

	public void setMaleRegisTransferSecuredBond(String maleRegisTransferSecuredBond) {
		this.maleRegisTransferSecuredBond = maleRegisTransferSecuredBond;
	}

	public String getMaleRegisTransferMorgageDeed() {
		return maleRegisTransferMorgageDeed;
	}

	public void setMaleRegisTransferMorgageDeed(String maleRegisTransferMorgageDeed) {
		this.maleRegisTransferMorgageDeed = maleRegisTransferMorgageDeed;
	}

	public String getMaleRegisTransferOts() {
		return maleRegisTransferOts;
	}

	public void setMaleRegisTransferOts(String maleRegisTransferOts) {
		this.maleRegisTransferOts = maleRegisTransferOts;
	}

	public String getMaleRegisTransferAdministratorGeneral() {
		return maleRegisTransferAdministratorGeneral;
	}

	public void setMaleRegisTransferAdministratorGeneral(String maleRegisTransferAdministratorGeneral) {
		this.maleRegisTransferAdministratorGeneral = maleRegisTransferAdministratorGeneral;
	}

	public String getMaleRegisTransferTrustProperty() {
		return maleRegisTransferTrustProperty;
	}

	public void setMaleRegisTransferTrustProperty(String maleRegisTransferTrustProperty) {
		this.maleRegisTransferTrustProperty = maleRegisTransferTrustProperty;
	}

	public String getMaleRegisTransferofLease() {
		return maleRegisTransferofLease;
	}

	public void setMaleRegisTransferofLease(String maleRegisTransferofLease) {
		this.maleRegisTransferofLease = maleRegisTransferofLease;
	}

	public String getMaleRegisTrustBeingWill() {
		return maleRegisTrustBeingWill;
	}

	public void setMaleRegisTrustBeingWill(String maleRegisTrustBeingWill) {
		this.maleRegisTrustBeingWill = maleRegisTrustBeingWill;
	}

	public String getMaleRegisTrustNotBeingWill() {
		return maleRegisTrustNotBeingWill;
	}

	public void setMaleRegisTrustNotBeingWill(String maleRegisTrustNotBeingWill) {
		this.maleRegisTrustNotBeingWill = maleRegisTrustNotBeingWill;
	}

	public String getMaleRegisWarrentGoods() {
		return maleRegisWarrentGoods;
	}

	public void setMaleRegisWarrentGoods(String maleRegisWarrentGoods) {
		this.maleRegisWarrentGoods = maleRegisWarrentGoods;
	}

	public String getFemaleStAcknowledgement() {
		return femaleStAcknowledgement;
	}

	public void setFemaleStAcknowledgement(String femaleStAcknowledgement) {
		this.femaleStAcknowledgement = femaleStAcknowledgement;
	}

	public String getFemaleStAdministrativeBond() {
		return femaleStAdministrativeBond;
	}

	public void setFemaleStAdministrativeBond(String femaleStAdministrativeBond) {
		this.femaleStAdministrativeBond = femaleStAdministrativeBond;
	}

	public String getFemaleStAdoptionDeed() {
		return femaleStAdoptionDeed;
	}

	public void setFemaleStAdoptionDeed(String femaleStAdoptionDeed) {
		this.femaleStAdoptionDeed = femaleStAdoptionDeed;
	}

	public String getFemaleStAffidavitIncAffOfDeclaration() {
		return femaleStAffidavitIncAffOfDeclaration;
	}

	public void setFemaleStAffidavitIncAffOfDeclaration(String femaleStAffidavitIncAffOfDeclaration) {
		this.femaleStAffidavitIncAffOfDeclaration = femaleStAffidavitIncAffOfDeclaration;
	}

	public String getFemaleStAgreementOfConveyance() {
		return femaleStAgreementOfConveyance;
	}

	public void setFemaleStAgreementOfConveyance(String femaleStAgreementOfConveyance) {
		this.femaleStAgreementOfConveyance = femaleStAgreementOfConveyance;
	}

	public String getFemaleStAgreementDevelopment() {
		return femaleStAgreementDevelopment;
	}

	public void setFemaleStAgreementDevelopment(String femaleStAgreementDevelopment) {
		this.femaleStAgreementDevelopment = femaleStAgreementDevelopment;
	}

	public String getFemaleStAgreementOts() {
		return femaleStAgreementOts;
	}

	public void setFemaleStAgreementOts(String femaleStAgreementOts) {
		this.femaleStAgreementOts = femaleStAgreementOts;
	}

	public String getFemaleStAgreeRelatDawnOrPledgeExceedLessThanOneThousand() {
		return femaleStAgreeRelatDawnOrPledgeExceedLessThanOneThousand;
	}

	public void setFemaleStAgreeRelatDawnOrPledgeExceedLessThanOneThousand(
			String femaleStAgreeRelatDawnOrPledgeExceedLessThanOneThousand) {
		this.femaleStAgreeRelatDawnOrPledgeExceedLessThanOneThousand = femaleStAgreeRelatDawnOrPledgeExceedLessThanOneThousand;
	}

	public String getFemaleStAgreeRelatDawnOrPledgeExceedLessThanTenThousand() {
		return femaleStAgreeRelatDawnOrPledgeExceedLessThanTenThousand;
	}

	public void setFemaleStAgreeRelatDawnOrPledgeExceedLessThanTenThousand(
			String femaleStAgreeRelatDawnOrPledgeExceedLessThanTenThousand) {
		this.femaleStAgreeRelatDawnOrPledgeExceedLessThanTenThousand = femaleStAgreeRelatDawnOrPledgeExceedLessThanTenThousand;
	}

	public String getFemaleStAgreeRelatDawnOrPledgeExceedMoreThanTenThousand() {
		return femaleStAgreeRelatDawnOrPledgeExceedMoreThanTenThousand;
	}

	public void setFemaleStAgreeRelatDawnOrPledgeExceedMoreThanTenThousand(
			String femaleStAgreeRelatDawnOrPledgeExceedMoreThanTenThousand) {
		this.femaleStAgreeRelatDawnOrPledgeExceedMoreThanTenThousand = femaleStAgreeRelatDawnOrPledgeExceedMoreThanTenThousand;
	}

	public String getFemaleStAgreeRelatDawnOrPledgeThreeMonths() {
		return femaleStAgreeRelatDawnOrPledgeThreeMonths;
	}

	public void setFemaleStAgreeRelatDawnOrPledgeThreeMonths(String femaleStAgreeRelatDawnOrPledgeThreeMonths) {
		this.femaleStAgreeRelatDawnOrPledgeThreeMonths = femaleStAgreeRelatDawnOrPledgeThreeMonths;
	}

	public String getFemaleStAppointmentInExecutionOfPwr() {
		return femaleStAppointmentInExecutionOfPwr;
	}

	public void setFemaleStAppointmentInExecutionOfPwr(String femaleStAppointmentInExecutionOfPwr) {
		this.femaleStAppointmentInExecutionOfPwr = femaleStAppointmentInExecutionOfPwr;
	}

	public String getFemaleStAppOrValNotExceed() {
		return femaleStAppOrValNotExceed;
	}

	public void setFemaleStAppOrValNotExceed(String femaleStAppOrValNotExceed) {
		this.femaleStAppOrValNotExceed = femaleStAppOrValNotExceed;
	}

	public String getFemaleStAppOrValOtCase() {
		return femaleStAppOrValOtCase;
	}

	public void setFemaleStAppOrValOtCase(String femaleStAppOrValOtCase) {
		this.femaleStAppOrValOtCase = femaleStAppOrValOtCase;
	}

	public String getFemaleStApprenticeshipDeed() {
		return femaleStApprenticeshipDeed;
	}

	public void setFemaleStApprenticeshipDeed(String femaleStApprenticeshipDeed) {
		this.femaleStApprenticeshipDeed = femaleStApprenticeshipDeed;
	}

	public String getFemaleStArtsOfAssoOfCompanyNotExceed() {
		return femaleStArtsOfAssoOfCompanyNotExceed;
	}

	public void setFemaleStArtsOfAssoOfCompanyNotExceed(String femaleStArtsOfAssoOfCompanyNotExceed) {
		this.femaleStArtsOfAssoOfCompanyNotExceed = femaleStArtsOfAssoOfCompanyNotExceed;
	}

	public String getFemaleStArtsOfAssoOfCompanyAbove() {
		return femaleStArtsOfAssoOfCompanyAbove;
	}

	public void setFemaleStArtsOfAssoOfCompanyAbove(String femaleStArtsOfAssoOfCompanyAbove) {
		this.femaleStArtsOfAssoOfCompanyAbove = femaleStArtsOfAssoOfCompanyAbove;
	}

	public String getFemaleStArtsOfClerkship() {
		return femaleStArtsOfClerkship;
	}

	public void setFemaleStArtsOfClerkship(String femaleStArtsOfClerkship) {
		this.femaleStArtsOfClerkship = femaleStArtsOfClerkship;
	}

	public String getFemaleStAwardNotExceed() {
		return femaleStAwardNotExceed;
	}

	public void setFemaleStAwardNotExceed(String femaleStAwardNotExceed) {
		this.femaleStAwardNotExceed = femaleStAwardNotExceed;
	}

	public String getFemaleStAwardExceed() {
		return femaleStAwardExceed;
	}

	public void setFemaleStAwardExceed(String femaleStAwardExceed) {
		this.femaleStAwardExceed = femaleStAwardExceed;
	}

	public String getFemaleStBillOfExchangeWherePayableOtwise() {
		return femaleStBillOfExchangeWherePayableOtwise;
	}

	public void setFemaleStBillOfExchangeWherePayableOtwise(String femaleStBillOfExchangeWherePayableOtwise) {
		this.femaleStBillOfExchangeWherePayableOtwise = femaleStBillOfExchangeWherePayableOtwise;
	}

	public String getFemaleStBillOfLading() {
		return femaleStBillOfLading;
	}

	public void setFemaleStBillOfLading(String femaleStBillOfLading) {
		this.femaleStBillOfLading = femaleStBillOfLading;
	}

	public String getFemaleStBond() {
		return femaleStBond;
	}

	public void setFemaleStBond(String femaleStBond) {
		this.femaleStBond = femaleStBond;
	}

	public String getFemaleStBottomryBond() {
		return femaleStBottomryBond;
	}

	public void setFemaleStBottomryBond(String femaleStBottomryBond) {
		this.femaleStBottomryBond = femaleStBottomryBond;
	}

	public String getFemaleStCancellation() {
		return femaleStCancellation;
	}

	public void setFemaleStCancellation(String femaleStCancellation) {
		this.femaleStCancellation = femaleStCancellation;
	}

	public String getFemaleStCertificateOfSale() {
		return femaleStCertificateOfSale;
	}

	public void setFemaleStCertificateOfSale(String femaleStCertificateOfSale) {
		this.femaleStCertificateOfSale = femaleStCertificateOfSale;
	}

	public String getFemaleStCertificateOrOtDocument() {
		return femaleStCertificateOrOtDocument;
	}

	public void setFemaleStCertificateOrOtDocument(String femaleStCertificateOrOtDocument) {
		this.femaleStCertificateOrOtDocument = femaleStCertificateOrOtDocument;
	}

	public String getFemaleStCharterParty() {
		return femaleStCharterParty;
	}

	public void setFemaleStCharterParty(String femaleStCharterParty) {
		this.femaleStCharterParty = femaleStCharterParty;
	}

	public String getFemaleStCompositionDeed() {
		return femaleStCompositionDeed;
	}

	public void setFemaleStCompositionDeed(String femaleStCompositionDeed) {
		this.femaleStCompositionDeed = femaleStCompositionDeed;
	}

	public String getFemaleStSaleConveyance() {
		return femaleStSaleConveyance;
	}

	public void setFemaleStSaleConveyance(String femaleStSaleConveyance) {
		this.femaleStSaleConveyance = femaleStSaleConveyance;
	}

	public String getFemaleStCertifiedCopy() {
		return femaleStCertifiedCopy;
	}

	public void setFemaleStCertifiedCopy(String femaleStCertifiedCopy) {
		this.femaleStCertifiedCopy = femaleStCertifiedCopy;
	}

	public String getFemaleStCounterpartOrDuplicateOfAnyInstrument() {
		return femaleStCounterpartOrDuplicateOfAnyInstrument;
	}

	public void setFemaleStCounterpartOrDuplicateOfAnyInstrument(String femaleStCounterpartOrDuplicateOfAnyInstrument) {
		this.femaleStCounterpartOrDuplicateOfAnyInstrument = femaleStCounterpartOrDuplicateOfAnyInstrument;
	}

	public String getFemaleStCustomsBondNotExceed() {
		return femaleStCustomsBondNotExceed;
	}

	public void setFemaleStCustomsBondNotExceed(String femaleStCustomsBondNotExceed) {
		this.femaleStCustomsBondNotExceed = femaleStCustomsBondNotExceed;
	}

	public String getFemaleStCustomsBondOtCase() {
		return femaleStCustomsBondOtCase;
	}

	public void setFemaleStCustomsBondOtCase(String femaleStCustomsBondOtCase) {
		this.femaleStCustomsBondOtCase = femaleStCustomsBondOtCase;
	}

	public String getFemaleStDebenture() {
		return femaleStDebenture;
	}

	public void setFemaleStDebenture(String femaleStDebenture) {
		this.femaleStDebenture = femaleStDebenture;
	}

	public String getFemaleStDebentureEndorsedNotExceed() {
		return femaleStDebentureEndorsedNotExceed;
	}

	public void setFemaleStDebentureEndorsedNotExceed(String femaleStDebentureEndorsedNotExceed) {
		this.femaleStDebentureEndorsedNotExceed = femaleStDebentureEndorsedNotExceed;
	}

	public String getFemaleStDebentureEndorsedExcess() {
		return femaleStDebentureEndorsedExcess;
	}

	public void setFemaleStDebentureEndorsedExcess(String femaleStDebentureEndorsedExcess) {
		this.femaleStDebentureEndorsedExcess = femaleStDebentureEndorsedExcess;
	}

	public String getFemaleStDebentureDeliveryNotExceed() {
		return femaleStDebentureDeliveryNotExceed;
	}

	public void setFemaleStDebentureDeliveryNotExceed(String femaleStDebentureDeliveryNotExceed) {
		this.femaleStDebentureDeliveryNotExceed = femaleStDebentureDeliveryNotExceed;
	}

	public String getFemaleStDebentureDeliveryExcess() {
		return femaleStDebentureDeliveryExcess;
	}

	public void setFemaleStDebentureDeliveryExcess(String femaleStDebentureDeliveryExcess) {
		this.femaleStDebentureDeliveryExcess = femaleStDebentureDeliveryExcess;
	}

	public String getFemaleStDeliveryOrderInRespectofGoods() {
		return femaleStDeliveryOrderInRespectofGoods;
	}

	public void setFemaleStDeliveryOrderInRespectofGoods(String femaleStDeliveryOrderInRespectofGoods) {
		this.femaleStDeliveryOrderInRespectofGoods = femaleStDeliveryOrderInRespectofGoods;
	}

	public String getFemaleStDivorceDeed() {
		return femaleStDivorceDeed;
	}

	public void setFemaleStDivorceDeed(String femaleStDivorceDeed) {
		this.femaleStDivorceDeed = femaleStDivorceDeed;
	}

	public String getFemaleStEntryAsAnAdvocateAdvocate() {
		return femaleStEntryAsAnAdvocateAdvocate;
	}

	public void setFemaleStEntryAsAnAdvocateAdvocate(String femaleStEntryAsAnAdvocateAdvocate) {
		this.femaleStEntryAsAnAdvocateAdvocate = femaleStEntryAsAnAdvocateAdvocate;
	}

	public String getFemaleStEntryAsAnAdvocateAttorney() {
		return femaleStEntryAsAnAdvocateAttorney;
	}

	public void setFemaleStEntryAsAnAdvocateAttorney(String femaleStEntryAsAnAdvocateAttorney) {
		this.femaleStEntryAsAnAdvocateAttorney = femaleStEntryAsAnAdvocateAttorney;
	}

	public String getFemaleStExchangeOfProperty() {
		return femaleStExchangeOfProperty;
	}

	public void setFemaleStExchangeOfProperty(String femaleStExchangeOfProperty) {
		this.femaleStExchangeOfProperty = femaleStExchangeOfProperty;
	}

	public String getFemaleStFutherChargeWithPossession() {
		return femaleStFutherChargeWithPossession;
	}

	public void setFemaleStFutherChargeWithPossession(String femaleStFutherChargeWithPossession) {
		this.femaleStFutherChargeWithPossession = femaleStFutherChargeWithPossession;
	}

	public String getFemaleStFutherChargeWithoutPossession() {
		return femaleStFutherChargeWithoutPossession;
	}

	public void setFemaleStFutherChargeWithoutPossession(String femaleStFutherChargeWithoutPossession) {
		this.femaleStFutherChargeWithoutPossession = femaleStFutherChargeWithoutPossession;
	}

	public String getFemaleStFutherChargtPossessionGiven() {
		return femaleStFutherChargtPossessionGiven;
	}

	public void setFemaleStFutherChargtPossessionGiven(String femaleStFutherChargtPossessionGiven) {
		this.femaleStFutherChargtPossessionGiven = femaleStFutherChargtPossessionGiven;
	}

	public String getFemaleStFutherChargePossessionNotGiven() {
		return femaleStFutherChargePossessionNotGiven;
	}

	public void setFemaleStFutherChargePossessionNotGiven(String femaleStFutherChargePossessionNotGiven) {
		this.femaleStFutherChargePossessionNotGiven = femaleStFutherChargePossessionNotGiven;
	}

	public String getFemaleStGiftDeed() {
		return femaleStGiftDeed;
	}

	public void setFemaleStGiftDeed(String femaleStGiftDeed) {
		this.femaleStGiftDeed = femaleStGiftDeed;
	}

	public String getFemaleStIndemnityBond() {
		return femaleStIndemnityBond;
	}

	public void setFemaleStIndemnityBond(String femaleStIndemnityBond) {
		this.femaleStIndemnityBond = femaleStIndemnityBond;
	}

	public String getFemaleStLeaseRentFixed() {
		return femaleStLeaseRentFixed;
	}

	public void setFemaleStLeaseRentFixed(String femaleStLeaseRentFixed) {
		this.femaleStLeaseRentFixed = femaleStLeaseRentFixed;
	}

	public String getFemaleStLeaseLessThanOneYear() {
		return femaleStLeaseLessThanOneYear;
	}

	public void setFemaleStLeaseLessThanOneYear(String femaleStLeaseLessThanOneYear) {
		this.femaleStLeaseLessThanOneYear = femaleStLeaseLessThanOneYear;
	}

	public String getFemaleStLeaseLessThanFiveYear() {
		return femaleStLeaseLessThanFiveYear;
	}

	public void setFemaleStLeaseLessThanFiveYear(String femaleStLeaseLessThanFiveYear) {
		this.femaleStLeaseLessThanFiveYear = femaleStLeaseLessThanFiveYear;
	}

	public String getFemaleStLeaseLessThanTenYear() {
		return femaleStLeaseLessThanTenYear;
	}

	public void setFemaleStLeaseLessThanTenYear(String femaleStLeaseLessThanTenYear) {
		this.femaleStLeaseLessThanTenYear = femaleStLeaseLessThanTenYear;
	}

	public String getFemaleStLeaseLessThanTwentyYear() {
		return femaleStLeaseLessThanTwentyYear;
	}

	public void setFemaleStLeaseLessThanTwentyYear(String femaleStLeaseLessThanTwentyYear) {
		this.femaleStLeaseLessThanTwentyYear = femaleStLeaseLessThanTwentyYear;
	}

	public String getFemaleStLeaseLessThanThirtyYear() {
		return femaleStLeaseLessThanThirtyYear;
	}

	public void setFemaleStLeaseLessThanThirtyYear(String femaleStLeaseLessThanThirtyYear) {
		this.femaleStLeaseLessThanThirtyYear = femaleStLeaseLessThanThirtyYear;
	}

	public String getFemaleStLeaseLessThanHundredYear() {
		return femaleStLeaseLessThanHundredYear;
	}

	public void setFemaleStLeaseLessThanHundredYear(String femaleStLeaseLessThanHundredYear) {
		this.femaleStLeaseLessThanHundredYear = femaleStLeaseLessThanHundredYear;
	}

	public String getFemaleStLeaseMoreThanHundredYear() {
		return femaleStLeaseMoreThanHundredYear;
	}

	public void setFemaleStLeaseMoreThanHundredYear(String femaleStLeaseMoreThanHundredYear) {
		this.femaleStLeaseMoreThanHundredYear = femaleStLeaseMoreThanHundredYear;
	}

	public String getFemaleStLeaseNotDefiniteTerm() {
		return femaleStLeaseNotDefiniteTerm;
	}

	public void setFemaleStLeaseNotDefiniteTerm(String femaleStLeaseNotDefiniteTerm) {
		this.femaleStLeaseNotDefiniteTerm = femaleStLeaseNotDefiniteTerm;
	}

	public String getFemaleStLeaseNoRentReserved() {
		return femaleStLeaseNoRentReserved;
	}

	public void setFemaleStLeaseNoRentReserved(String femaleStLeaseNoRentReserved) {
		this.femaleStLeaseNoRentReserved = femaleStLeaseNoRentReserved;
	}

	public String getFemaleStLeaseAdditionOnRentReserved() {
		return femaleStLeaseAdditionOnRentReserved;
	}

	public void setFemaleStLeaseAdditionOnRentReserved(String femaleStLeaseAdditionOnRentReserved) {
		this.femaleStLeaseAdditionOnRentReserved = femaleStLeaseAdditionOnRentReserved;
	}

	public String getFemaleStLeaseRevisionNotification() {
		return femaleStLeaseRevisionNotification;
	}

	public void setFemaleStLeaseRevisionNotification(String femaleStLeaseRevisionNotification) {
		this.femaleStLeaseRevisionNotification = femaleStLeaseRevisionNotification;
	}

	public String getFemaleStLetterOfAllotmentOfShares() {
		return femaleStLetterOfAllotmentOfShares;
	}

	public void setFemaleStLetterOfAllotmentOfShares(String femaleStLetterOfAllotmentOfShares) {
		this.femaleStLetterOfAllotmentOfShares = femaleStLetterOfAllotmentOfShares;
	}

	public String getFemaleStLetterOfCredit() {
		return femaleStLetterOfCredit;
	}

	public void setFemaleStLetterOfCredit(String femaleStLetterOfCredit) {
		this.femaleStLetterOfCredit = femaleStLetterOfCredit;
	}

	public String getFemaleStLetterOfLicence() {
		return femaleStLetterOfLicence;
	}

	public void setFemaleStLetterOfLicence(String femaleStLetterOfLicence) {
		this.femaleStLetterOfLicence = femaleStLetterOfLicence;
	}

	public String getFemaleStMemorandumOfAssoOfCompany() {
		return femaleStMemorandumOfAssoOfCompany;
	}

	public void setFemaleStMemorandumOfAssoOfCompany(String femaleStMemorandumOfAssoOfCompany) {
		this.femaleStMemorandumOfAssoOfCompany = femaleStMemorandumOfAssoOfCompany;
	}

	public String getFemaleStMortgageWithPossession() {
		return femaleStMortgageWithPossession;
	}

	public void setFemaleStMortgageWithPossession(String femaleStMortgageWithPossession) {
		this.femaleStMortgageWithPossession = femaleStMortgageWithPossession;
	}

	public String getFemaleStMortgageWithoutPossession() {
		return femaleStMortgageWithoutPossession;
	}

	public void setFemaleStMortgageWithoutPossession(String femaleStMortgageWithoutPossession) {
		this.femaleStMortgageWithoutPossession = femaleStMortgageWithoutPossession;
	}

	public String getFemaleStMortgageOfCropLessThanThree() {
		return femaleStMortgageOfCropLessThanThree;
	}

	public void setFemaleStMortgageOfCropLessThanThree(String femaleStMortgageOfCropLessThanThree) {
		this.femaleStMortgageOfCropLessThanThree = femaleStMortgageOfCropLessThanThree;
	}

	public String getFemaleStMortgageOfCropMoreThanThree() {
		return femaleStMortgageOfCropMoreThanThree;
	}

	public void setFemaleStMortgageOfCropMoreThanThree(String femaleStMortgageOfCropMoreThanThree) {
		this.femaleStMortgageOfCropMoreThanThree = femaleStMortgageOfCropMoreThanThree;
	}

	public String getFemaleStNotarialAct() {
		return femaleStNotarialAct;
	}

	public void setFemaleStNotarialAct(String femaleStNotarialAct) {
		this.femaleStNotarialAct = femaleStNotarialAct;
	}

	public String getFemaleStNoteOrMemorandum() {
		return femaleStNoteOrMemorandum;
	}

	public void setFemaleStNoteOrMemorandum(String femaleStNoteOrMemorandum) {
		this.femaleStNoteOrMemorandum = femaleStNoteOrMemorandum;
	}

	public String getFemaleStNoteOfProtestByTheMasterOfShip() {
		return femaleStNoteOfProtestByTheMasterOfShip;
	}

	public void setFemaleStNoteOfProtestByTheMasterOfShip(String femaleStNoteOfProtestByTheMasterOfShip) {
		this.femaleStNoteOfProtestByTheMasterOfShip = femaleStNoteOfProtestByTheMasterOfShip;
	}

	public String getFemaleStPartitionDeed() {
		return femaleStPartitionDeed;
	}

	public void setFemaleStPartitionDeed(String femaleStPartitionDeed) {
		this.femaleStPartitionDeed = femaleStPartitionDeed;
	}

	public String getFemaleStPartnerShip() {
		return femaleStPartnerShip;
	}

	public void setFemaleStPartnerShip(String femaleStPartnerShip) {
		this.femaleStPartnerShip = femaleStPartnerShip;
	}

	public String getFemaleStPartnerShipDissolution() {
		return femaleStPartnerShipDissolution;
	}

	public void setFemaleStPartnerShipDissolution(String femaleStPartnerShipDissolution) {
		this.femaleStPartnerShipDissolution = femaleStPartnerShipDissolution;
	}

	public String getFemaleStPolOfInsLessThanEighteen() {
		return femaleStPolOfInsLessThanEighteen;
	}

	public void setFemaleStPolOfInsLessThanEighteen(String femaleStPolOfInsLessThanEighteen) {
		this.femaleStPolOfInsLessThanEighteen = femaleStPolOfInsLessThanEighteen;
	}

	public String getFemaleStPolOfInsOneThousandFiveHundred() {
		return femaleStPolOfInsOneThousandFiveHundred;
	}

	public void setFemaleStPolOfInsOneThousandFiveHundred(String femaleStPolOfInsOneThousandFiveHundred) {
		this.femaleStPolOfInsOneThousandFiveHundred = femaleStPolOfInsOneThousandFiveHundred;
	}

	public String getFemaleStPolOfInsOneThousand() {
		return femaleStPolOfInsOneThousand;
	}

	public void setFemaleStPolOfInsOneThousand(String femaleStPolOfInsOneThousand) {
		this.femaleStPolOfInsOneThousand = femaleStPolOfInsOneThousand;
	}

	public String getFemaleStPolOfInsFireIns() {
		return femaleStPolOfInsFireIns;
	}

	public void setFemaleStPolOfInsFireIns(String femaleStPolOfInsFireIns) {
		this.femaleStPolOfInsFireIns = femaleStPolOfInsFireIns;
	}

	public String getFemaleStPolOfInsOts() {
		return femaleStPolOfInsOts;
	}

	public void setFemaleStPolOfInsOts(String femaleStPolOfInsOts) {
		this.femaleStPolOfInsOts = femaleStPolOfInsOts;
	}

	public String getFemaleStPolOfInsRenewalOriginalPol() {
		return femaleStPolOfInsRenewalOriginalPol;
	}

	public void setFemaleStPolOfInsRenewalOriginalPol(String femaleStPolOfInsRenewalOriginalPol) {
		this.femaleStPolOfInsRenewalOriginalPol = femaleStPolOfInsRenewalOriginalPol;
	}

	public String getFemaleStPolOfInsAccidental() {
		return femaleStPolOfInsAccidental;
	}

	public void setFemaleStPolOfInsAccidental(String femaleStPolOfInsAccidental) {
		this.femaleStPolOfInsAccidental = femaleStPolOfInsAccidental;
	}

	public String getFemaleStPolOfInsNotExceedOneThousand() {
		return femaleStPolOfInsNotExceedOneThousand;
	}

	public void setFemaleStPolOfInsNotExceedOneThousand(String femaleStPolOfInsNotExceedOneThousand) {
		this.femaleStPolOfInsNotExceedOneThousand = femaleStPolOfInsNotExceedOneThousand;
	}

	public String getFemaleStPolOfInsIndemnity() {
		return femaleStPolOfInsIndemnity;
	}

	public void setFemaleStPolOfInsIndemnity(String femaleStPolOfInsIndemnity) {
		this.femaleStPolOfInsIndemnity = femaleStPolOfInsIndemnity;
	}

	public String getFemaleStPolOfInsLifeIns() {
		return femaleStPolOfInsLifeIns;
	}

	public void setFemaleStPolOfInsLifeIns(String femaleStPolOfInsLifeIns) {
		this.femaleStPolOfInsLifeIns = femaleStPolOfInsLifeIns;
	}

	public String getFemaleStPolOfInsLessThanFiveHundred() {
		return femaleStPolOfInsLessThanFiveHundred;
	}

	public void setFemaleStPolOfInsLessThanFiveHundred(String femaleStPolOfInsLessThanFiveHundred) {
		this.femaleStPolOfInsLessThanFiveHundred = femaleStPolOfInsLessThanFiveHundred;
	}

	public String getFemaleStPolOfInsLessThanOneThousand() {
		return femaleStPolOfInsLessThanOneThousand;
	}

	public void setFemaleStPolOfInsLessThanOneThousand(String femaleStPolOfInsLessThanOneThousand) {
		this.femaleStPolOfInsLessThanOneThousand = femaleStPolOfInsLessThanOneThousand;
	}

	public String getFemaleStPolOfInsReIns() {
		return femaleStPolOfInsReIns;
	}

	public void setFemaleStPolOfInsReIns(String femaleStPolOfInsReIns) {
		this.femaleStPolOfInsReIns = femaleStPolOfInsReIns;
	}

	public String getFemaleStPwrOfAttorneySpecial() {
		return femaleStPwrOfAttorneySpecial;
	}

	public void setFemaleStPwrOfAttorneySpecial(String femaleStPwrOfAttorneySpecial) {
		this.femaleStPwrOfAttorneySpecial = femaleStPwrOfAttorneySpecial;
	}

	public String getFemaleStPwrOfAttorneyGeneral() {
		return femaleStPwrOfAttorneyGeneral;
	}

	public void setFemaleStPwrOfAttorneyGeneral(String femaleStPwrOfAttorneyGeneral) {
		this.femaleStPwrOfAttorneyGeneral = femaleStPwrOfAttorneyGeneral;
	}

	public String getFemaleStPromissoryNoteLessThanOneThousand() {
		return femaleStPromissoryNoteLessThanOneThousand;
	}

	public void setFemaleStPromissoryNoteLessThanOneThousand(String femaleStPromissoryNoteLessThanOneThousand) {
		this.femaleStPromissoryNoteLessThanOneThousand = femaleStPromissoryNoteLessThanOneThousand;
	}

	public String getFemaleStPromissoryNoteOtCases() {
		return femaleStPromissoryNoteOtCases;
	}

	public void setFemaleStPromissoryNoteOtCases(String femaleStPromissoryNoteOtCases) {
		this.femaleStPromissoryNoteOtCases = femaleStPromissoryNoteOtCases;
	}

	public String getFemaleStPromissoryNoteDemand() {
		return femaleStPromissoryNoteDemand;
	}

	public void setFemaleStPromissoryNoteDemand(String femaleStPromissoryNoteDemand) {
		this.femaleStPromissoryNoteDemand = femaleStPromissoryNoteDemand;
	}

	public String getFemaleStProtestOfBillOrNote() {
		return femaleStProtestOfBillOrNote;
	}

	public void setFemaleStProtestOfBillOrNote(String femaleStProtestOfBillOrNote) {
		this.femaleStProtestOfBillOrNote = femaleStProtestOfBillOrNote;
	}

	public String getFemaleStProtestByTheMasterOfShip() {
		return femaleStProtestByTheMasterOfShip;
	}

	public void setFemaleStProtestByTheMasterOfShip(String femaleStProtestByTheMasterOfShip) {
		this.femaleStProtestByTheMasterOfShip = femaleStProtestByTheMasterOfShip;
	}

	public String getFemaleStProxy() {
		return femaleStProxy;
	}

	public void setFemaleStProxy(String femaleStProxy) {
		this.femaleStProxy = femaleStProxy;
	}

	public String getFemaleStReceipt() {
		return femaleStReceipt;
	}

	public void setFemaleStReceipt(String femaleStReceipt) {
		this.femaleStReceipt = femaleStReceipt;
	}

	public String getFemaleStReconveyanceLessThanOneThousand() {
		return femaleStReconveyanceLessThanOneThousand;
	}

	public void setFemaleStReconveyanceLessThanOneThousand(String femaleStReconveyanceLessThanOneThousand) {
		this.femaleStReconveyanceLessThanOneThousand = femaleStReconveyanceLessThanOneThousand;
	}

	public String getFemaleStReconveyanceOts() {
		return femaleStReconveyanceOts;
	}

	public void setFemaleStReconveyanceOts(String femaleStReconveyanceOts) {
		this.femaleStReconveyanceOts = femaleStReconveyanceOts;
	}

	public String getFemaleStReleaseRelinquishmentOfRightLessThanOneThousand() {
		return femaleStReleaseRelinquishmentOfRightLessThanOneThousand;
	}

	public void setFemaleStReleaseRelinquishmentOfRightLessThanOneThousand(
			String femaleStReleaseRelinquishmentOfRightLessThanOneThousand) {
		this.femaleStReleaseRelinquishmentOfRightLessThanOneThousand = femaleStReleaseRelinquishmentOfRightLessThanOneThousand;
	}

	public String getFemaleStReleaseRelinquishmentOfRightOts() {
		return femaleStReleaseRelinquishmentOfRightOts;
	}

	public void setFemaleStReleaseRelinquishmentOfRightOts(String femaleStReleaseRelinquishmentOfRightOts) {
		this.femaleStReleaseRelinquishmentOfRightOts = femaleStReleaseRelinquishmentOfRightOts;
	}

	public String getFemaleStRespondentiaBond() {
		return femaleStRespondentiaBond;
	}

	public void setFemaleStRespondentiaBond(String femaleStRespondentiaBond) {
		this.femaleStRespondentiaBond = femaleStRespondentiaBond;
	}

	public String getFemaleStSecurityBond() {
		return femaleStSecurityBond;
	}

	public void setFemaleStSecurityBond(String femaleStSecurityBond) {
		this.femaleStSecurityBond = femaleStSecurityBond;
	}

	public String getFemaleStSettlementInstrument() {
		return femaleStSettlementInstrument;
	}

	public void setFemaleStSettlementInstrument(String femaleStSettlementInstrument) {
		this.femaleStSettlementInstrument = femaleStSettlementInstrument;
	}

	public String getFemaleStShareWarrents() {
		return femaleStShareWarrents;
	}

	public void setFemaleStShareWarrents(String femaleStShareWarrents) {
		this.femaleStShareWarrents = femaleStShareWarrents;
	}

	public String getFemaleStShippingOrder() {
		return femaleStShippingOrder;
	}

	public void setFemaleStShippingOrder(String femaleStShippingOrder) {
		this.femaleStShippingOrder = femaleStShippingOrder;
	}

	public String getFemaleStSurrenderOfLeaseNotExceesTen() {
		return femaleStSurrenderOfLeaseNotExceesTen;
	}

	public void setFemaleStSurrenderOfLeaseNotExceesTen(String femaleStSurrenderOfLeaseNotExceesTen) {
		this.femaleStSurrenderOfLeaseNotExceesTen = femaleStSurrenderOfLeaseNotExceesTen;
	}

	public String getFemaleStSurrenderOfLeaseOts() {
		return femaleStSurrenderOfLeaseOts;
	}

	public void setFemaleStSurrenderOfLeaseOts(String femaleStSurrenderOfLeaseOts) {
		this.femaleStSurrenderOfLeaseOts = femaleStSurrenderOfLeaseOts;
	}

	public String getFemaleStTransferOfShares() {
		return femaleStTransferOfShares;
	}

	public void setFemaleStTransferOfShares(String femaleStTransferOfShares) {
		this.femaleStTransferOfShares = femaleStTransferOfShares;
	}

	public String getFemaleStTransferOfDebentures() {
		return femaleStTransferOfDebentures;
	}

	public void setFemaleStTransferOfDebentures(String femaleStTransferOfDebentures) {
		this.femaleStTransferOfDebentures = femaleStTransferOfDebentures;
	}

	public String getFemaleStTransferSecuredBond() {
		return femaleStTransferSecuredBond;
	}

	public void setFemaleStTransferSecuredBond(String femaleStTransferSecuredBond) {
		this.femaleStTransferSecuredBond = femaleStTransferSecuredBond;
	}

	public String getFemaleStTransferMorgageDeed() {
		return femaleStTransferMorgageDeed;
	}

	public void setFemaleStTransferMorgageDeed(String femaleStTransferMorgageDeed) {
		this.femaleStTransferMorgageDeed = femaleStTransferMorgageDeed;
	}

	public String getFemaleStTransferOts() {
		return femaleStTransferOts;
	}

	public void setFemaleStTransferOts(String femaleStTransferOts) {
		this.femaleStTransferOts = femaleStTransferOts;
	}

	public String getFemaleStTransferAdministratorGeneral() {
		return femaleStTransferAdministratorGeneral;
	}

	public void setFemaleStTransferAdministratorGeneral(String femaleStTransferAdministratorGeneral) {
		this.femaleStTransferAdministratorGeneral = femaleStTransferAdministratorGeneral;
	}

	public String getFemaleStTransferTrustProperty() {
		return femaleStTransferTrustProperty;
	}

	public void setFemaleStTransferTrustProperty(String femaleStTransferTrustProperty) {
		this.femaleStTransferTrustProperty = femaleStTransferTrustProperty;
	}

	public String getFemaleStTransferofLease() {
		return femaleStTransferofLease;
	}

	public void setFemaleStTransferofLease(String femaleStTransferofLease) {
		this.femaleStTransferofLease = femaleStTransferofLease;
	}

	public String getFemaleStTrustBeingWill() {
		return femaleStTrustBeingWill;
	}

	public void setFemaleStTrustBeingWill(String femaleStTrustBeingWill) {
		this.femaleStTrustBeingWill = femaleStTrustBeingWill;
	}

	public String getFemaleStTrustNotBeingWill() {
		return femaleStTrustNotBeingWill;
	}

	public void setFemaleStTrustNotBeingWill(String femaleStTrustNotBeingWill) {
		this.femaleStTrustNotBeingWill = femaleStTrustNotBeingWill;
	}

	public String getFemaleStWarrentGoods() {
		return femaleStWarrentGoods;
	}

	public void setFemaleStWarrentGoods(String femaleStWarrentGoods) {
		this.femaleStWarrentGoods = femaleStWarrentGoods;
	}

	public String getFemaleRegisAcknowledgement() {
		return femaleRegisAcknowledgement;
	}

	public void setFemaleRegisAcknowledgement(String femaleRegisAcknowledgement) {
		this.femaleRegisAcknowledgement = femaleRegisAcknowledgement;
	}

	public String getFemaleRegisAdministrativeBond() {
		return femaleRegisAdministrativeBond;
	}

	public void setFemaleRegisAdministrativeBond(String femaleRegisAdministrativeBond) {
		this.femaleRegisAdministrativeBond = femaleRegisAdministrativeBond;
	}

	public String getFemaleRegisAdoptionDeed() {
		return femaleRegisAdoptionDeed;
	}

	public void setFemaleRegisAdoptionDeed(String femaleRegisAdoptionDeed) {
		this.femaleRegisAdoptionDeed = femaleRegisAdoptionDeed;
	}

	public String getFemaleRegisAffidavitIncAffOfDeclaration() {
		return femaleRegisAffidavitIncAffOfDeclaration;
	}

	public void setFemaleRegisAffidavitIncAffOfDeclaration(String femaleRegisAffidavitIncAffOfDeclaration) {
		this.femaleRegisAffidavitIncAffOfDeclaration = femaleRegisAffidavitIncAffOfDeclaration;
	}

	public String getFemaleRegisAgreementOfConveyance() {
		return femaleRegisAgreementOfConveyance;
	}

	public void setFemaleRegisAgreementOfConveyance(String femaleRegisAgreementOfConveyance) {
		this.femaleRegisAgreementOfConveyance = femaleRegisAgreementOfConveyance;
	}

	public String getFemaleRegisAgreementDevelopment() {
		return femaleRegisAgreementDevelopment;
	}

	public void setFemaleRegisAgreementDevelopment(String femaleRegisAgreementDevelopment) {
		this.femaleRegisAgreementDevelopment = femaleRegisAgreementDevelopment;
	}

	public String getFemaleRegisAgreementOts() {
		return femaleRegisAgreementOts;
	}

	public void setFemaleRegisAgreementOts(String femaleRegisAgreementOts) {
		this.femaleRegisAgreementOts = femaleRegisAgreementOts;
	}

	public String getFemaleRegisAgreeRelatDawnOrPledgeExceedLessThanOneThousand() {
		return femaleRegisAgreeRelatDawnOrPledgeExceedLessThanOneThousand;
	}

	public void setFemaleRegisAgreeRelatDawnOrPledgeExceedLessThanOneThousand(
			String femaleRegisAgreeRelatDawnOrPledgeExceedLessThanOneThousand) {
		this.femaleRegisAgreeRelatDawnOrPledgeExceedLessThanOneThousand = femaleRegisAgreeRelatDawnOrPledgeExceedLessThanOneThousand;
	}

	public String getFemaleRegisAgreeRelatDawnOrPledgeExceedLessThanTenThousand() {
		return femaleRegisAgreeRelatDawnOrPledgeExceedLessThanTenThousand;
	}

	public void setFemaleRegisAgreeRelatDawnOrPledgeExceedLessThanTenThousand(
			String femaleRegisAgreeRelatDawnOrPledgeExceedLessThanTenThousand) {
		this.femaleRegisAgreeRelatDawnOrPledgeExceedLessThanTenThousand = femaleRegisAgreeRelatDawnOrPledgeExceedLessThanTenThousand;
	}

	public String getFemaleRegisAgreeRelatDawnOrPledgeExceedMoreThanTenThousand() {
		return femaleRegisAgreeRelatDawnOrPledgeExceedMoreThanTenThousand;
	}

	public void setFemaleRegisAgreeRelatDawnOrPledgeExceedMoreThanTenThousand(
			String femaleRegisAgreeRelatDawnOrPledgeExceedMoreThanTenThousand) {
		this.femaleRegisAgreeRelatDawnOrPledgeExceedMoreThanTenThousand = femaleRegisAgreeRelatDawnOrPledgeExceedMoreThanTenThousand;
	}

	public String getFemaleRegisAgreeRelatDawnOrPledgeThreeMonths() {
		return femaleRegisAgreeRelatDawnOrPledgeThreeMonths;
	}

	public void setFemaleRegisAgreeRelatDawnOrPledgeThreeMonths(String femaleRegisAgreeRelatDawnOrPledgeThreeMonths) {
		this.femaleRegisAgreeRelatDawnOrPledgeThreeMonths = femaleRegisAgreeRelatDawnOrPledgeThreeMonths;
	}

	public String getFemaleRegisAppointmentInExecutionOfPwr() {
		return femaleRegisAppointmentInExecutionOfPwr;
	}

	public void setFemaleRegisAppointmentInExecutionOfPwr(String femaleRegisAppointmentInExecutionOfPwr) {
		this.femaleRegisAppointmentInExecutionOfPwr = femaleRegisAppointmentInExecutionOfPwr;
	}

	public String getFemaleRegisAppOrValNotExceed() {
		return femaleRegisAppOrValNotExceed;
	}

	public void setFemaleRegisAppOrValNotExceed(String femaleRegisAppOrValNotExceed) {
		this.femaleRegisAppOrValNotExceed = femaleRegisAppOrValNotExceed;
	}

	public String getFemaleRegisAppOrValOtCase() {
		return femaleRegisAppOrValOtCase;
	}

	public void setFemaleRegisAppOrValOtCase(String femaleRegisAppOrValOtCase) {
		this.femaleRegisAppOrValOtCase = femaleRegisAppOrValOtCase;
	}

	public String getFemaleRegisApprenticeshipDeed() {
		return femaleRegisApprenticeshipDeed;
	}

	public void setFemaleRegisApprenticeshipDeed(String femaleRegisApprenticeshipDeed) {
		this.femaleRegisApprenticeshipDeed = femaleRegisApprenticeshipDeed;
	}

	public String getFemaleRegisArtsOfAssoOfCompanyNotExceed() {
		return femaleRegisArtsOfAssoOfCompanyNotExceed;
	}

	public void setFemaleRegisArtsOfAssoOfCompanyNotExceed(String femaleRegisArtsOfAssoOfCompanyNotExceed) {
		this.femaleRegisArtsOfAssoOfCompanyNotExceed = femaleRegisArtsOfAssoOfCompanyNotExceed;
	}

	public String getFemaleRegisArtsOfAssoOfCompanyAbove() {
		return femaleRegisArtsOfAssoOfCompanyAbove;
	}

	public void setFemaleRegisArtsOfAssoOfCompanyAbove(String femaleRegisArtsOfAssoOfCompanyAbove) {
		this.femaleRegisArtsOfAssoOfCompanyAbove = femaleRegisArtsOfAssoOfCompanyAbove;
	}

	public String getFemaleRegisArtsOfClerkship() {
		return femaleRegisArtsOfClerkship;
	}

	public void setFemaleRegisArtsOfClerkship(String femaleRegisArtsOfClerkship) {
		this.femaleRegisArtsOfClerkship = femaleRegisArtsOfClerkship;
	}

	public String getFemaleRegisAwardNotExceed() {
		return femaleRegisAwardNotExceed;
	}

	public void setFemaleRegisAwardNotExceed(String femaleRegisAwardNotExceed) {
		this.femaleRegisAwardNotExceed = femaleRegisAwardNotExceed;
	}

	public String getFemaleRegisAwardExceed() {
		return femaleRegisAwardExceed;
	}

	public void setFemaleRegisAwardExceed(String femaleRegisAwardExceed) {
		this.femaleRegisAwardExceed = femaleRegisAwardExceed;
	}

	public String getFemaleRegisBillOfExchangeWherePayableOtwise() {
		return femaleRegisBillOfExchangeWherePayableOtwise;
	}

	public void setFemaleRegisBillOfExchangeWherePayableOtwise(String femaleRegisBillOfExchangeWherePayableOtwise) {
		this.femaleRegisBillOfExchangeWherePayableOtwise = femaleRegisBillOfExchangeWherePayableOtwise;
	}

	public String getFemaleRegisBillOfLading() {
		return femaleRegisBillOfLading;
	}

	public void setFemaleRegisBillOfLading(String femaleRegisBillOfLading) {
		this.femaleRegisBillOfLading = femaleRegisBillOfLading;
	}

	public String getFemaleRegisBond() {
		return femaleRegisBond;
	}

	public void setFemaleRegisBond(String femaleRegisBond) {
		this.femaleRegisBond = femaleRegisBond;
	}

	public String getFemaleRegisBottomryBond() {
		return femaleRegisBottomryBond;
	}

	public void setFemaleRegisBottomryBond(String femaleRegisBottomryBond) {
		this.femaleRegisBottomryBond = femaleRegisBottomryBond;
	}

	public String getFemaleRegisCancellation() {
		return femaleRegisCancellation;
	}

	public void setFemaleRegisCancellation(String femaleRegisCancellation) {
		this.femaleRegisCancellation = femaleRegisCancellation;
	}

	public String getFemaleRegisCertificateOfSale() {
		return femaleRegisCertificateOfSale;
	}

	public void setFemaleRegisCertificateOfSale(String femaleRegisCertificateOfSale) {
		this.femaleRegisCertificateOfSale = femaleRegisCertificateOfSale;
	}

	public String getFemaleRegisCertificateOrOtDocument() {
		return femaleRegisCertificateOrOtDocument;
	}

	public void setFemaleRegisCertificateOrOtDocument(String femaleRegisCertificateOrOtDocument) {
		this.femaleRegisCertificateOrOtDocument = femaleRegisCertificateOrOtDocument;
	}

	public String getFemaleRegisCharterParty() {
		return femaleRegisCharterParty;
	}

	public void setFemaleRegisCharterParty(String femaleRegisCharterParty) {
		this.femaleRegisCharterParty = femaleRegisCharterParty;
	}

	public String getFemaleRegisCompositionDeed() {
		return femaleRegisCompositionDeed;
	}

	public void setFemaleRegisCompositionDeed(String femaleRegisCompositionDeed) {
		this.femaleRegisCompositionDeed = femaleRegisCompositionDeed;
	}

	public String getFemaleRegisSaleConveyance() {
		return femaleRegisSaleConveyance;
	}

	public void setFemaleRegisSaleConveyance(String femaleRegisSaleConveyance) {
		this.femaleRegisSaleConveyance = femaleRegisSaleConveyance;
	}

	public String getFemaleRegisCertifiedCopy() {
		return femaleRegisCertifiedCopy;
	}

	public void setFemaleRegisCertifiedCopy(String femaleRegisCertifiedCopy) {
		this.femaleRegisCertifiedCopy = femaleRegisCertifiedCopy;
	}

	public String getFemaleRegisCounterpartOrDuplicateOfAnyInstrument() {
		return femaleRegisCounterpartOrDuplicateOfAnyInstrument;
	}

	public void setFemaleRegisCounterpartOrDuplicateOfAnyInstrument(
			String femaleRegisCounterpartOrDuplicateOfAnyInstrument) {
		this.femaleRegisCounterpartOrDuplicateOfAnyInstrument = femaleRegisCounterpartOrDuplicateOfAnyInstrument;
	}

	public String getFemaleRegisCustomsBondNotExceed() {
		return femaleRegisCustomsBondNotExceed;
	}

	public void setFemaleRegisCustomsBondNotExceed(String femaleRegisCustomsBondNotExceed) {
		this.femaleRegisCustomsBondNotExceed = femaleRegisCustomsBondNotExceed;
	}

	public String getFemaleRegisCustomsBondOtCase() {
		return femaleRegisCustomsBondOtCase;
	}

	public void setFemaleRegisCustomsBondOtCase(String femaleRegisCustomsBondOtCase) {
		this.femaleRegisCustomsBondOtCase = femaleRegisCustomsBondOtCase;
	}

	public String getFemaleRegisDebenture() {
		return femaleRegisDebenture;
	}

	public void setFemaleRegisDebenture(String femaleRegisDebenture) {
		this.femaleRegisDebenture = femaleRegisDebenture;
	}

	public String getFemaleRegisDebentureEndorsedNotExceed() {
		return femaleRegisDebentureEndorsedNotExceed;
	}

	public void setFemaleRegisDebentureEndorsedNotExceed(String femaleRegisDebentureEndorsedNotExceed) {
		this.femaleRegisDebentureEndorsedNotExceed = femaleRegisDebentureEndorsedNotExceed;
	}

	public String getFemaleRegisDebentureEndorsedExcess() {
		return femaleRegisDebentureEndorsedExcess;
	}

	public void setFemaleRegisDebentureEndorsedExcess(String femaleRegisDebentureEndorsedExcess) {
		this.femaleRegisDebentureEndorsedExcess = femaleRegisDebentureEndorsedExcess;
	}

	public String getFemaleRegisDebentureDeliveryNotExceed() {
		return femaleRegisDebentureDeliveryNotExceed;
	}

	public void setFemaleRegisDebentureDeliveryNotExceed(String femaleRegisDebentureDeliveryNotExceed) {
		this.femaleRegisDebentureDeliveryNotExceed = femaleRegisDebentureDeliveryNotExceed;
	}

	public String getFemaleRegisDebentureDeliveryExcess() {
		return femaleRegisDebentureDeliveryExcess;
	}

	public void setFemaleRegisDebentureDeliveryExcess(String femaleRegisDebentureDeliveryExcess) {
		this.femaleRegisDebentureDeliveryExcess = femaleRegisDebentureDeliveryExcess;
	}

	public String getFemaleRegisDeliveryOrderInRespectofGoods() {
		return femaleRegisDeliveryOrderInRespectofGoods;
	}

	public void setFemaleRegisDeliveryOrderInRespectofGoods(String femaleRegisDeliveryOrderInRespectofGoods) {
		this.femaleRegisDeliveryOrderInRespectofGoods = femaleRegisDeliveryOrderInRespectofGoods;
	}

	public String getFemaleRegisDivorceDeed() {
		return femaleRegisDivorceDeed;
	}

	public void setFemaleRegisDivorceDeed(String femaleRegisDivorceDeed) {
		this.femaleRegisDivorceDeed = femaleRegisDivorceDeed;
	}

	public String getFemaleRegisEntryAsAnAdvocateAdvocate() {
		return femaleRegisEntryAsAnAdvocateAdvocate;
	}

	public void setFemaleRegisEntryAsAnAdvocateAdvocate(String femaleRegisEntryAsAnAdvocateAdvocate) {
		this.femaleRegisEntryAsAnAdvocateAdvocate = femaleRegisEntryAsAnAdvocateAdvocate;
	}

	public String getFemaleRegisEntryAsAnAdvocateAttorney() {
		return femaleRegisEntryAsAnAdvocateAttorney;
	}

	public void setFemaleRegisEntryAsAnAdvocateAttorney(String femaleRegisEntryAsAnAdvocateAttorney) {
		this.femaleRegisEntryAsAnAdvocateAttorney = femaleRegisEntryAsAnAdvocateAttorney;
	}

	public String getFemaleRegisExchangeOfProperty() {
		return femaleRegisExchangeOfProperty;
	}

	public void setFemaleRegisExchangeOfProperty(String femaleRegisExchangeOfProperty) {
		this.femaleRegisExchangeOfProperty = femaleRegisExchangeOfProperty;
	}

	public String getFemaleRegisFutherChargeWithPossession() {
		return femaleRegisFutherChargeWithPossession;
	}

	public void setFemaleRegisFutherChargeWithPossession(String femaleRegisFutherChargeWithPossession) {
		this.femaleRegisFutherChargeWithPossession = femaleRegisFutherChargeWithPossession;
	}

	public String getFemaleRegisFutherChargeWithoutPossession() {
		return femaleRegisFutherChargeWithoutPossession;
	}

	public void setFemaleRegisFutherChargeWithoutPossession(String femaleRegisFutherChargeWithoutPossession) {
		this.femaleRegisFutherChargeWithoutPossession = femaleRegisFutherChargeWithoutPossession;
	}

	public String getFemaleRegisFutherChargtPossessionGiven() {
		return femaleRegisFutherChargtPossessionGiven;
	}

	public void setFemaleRegisFutherChargtPossessionGiven(String femaleRegisFutherChargtPossessionGiven) {
		this.femaleRegisFutherChargtPossessionGiven = femaleRegisFutherChargtPossessionGiven;
	}

	public String getFemaleRegisFutherChargePossessionNotGiven() {
		return femaleRegisFutherChargePossessionNotGiven;
	}

	public void setFemaleRegisFutherChargePossessionNotGiven(String femaleRegisFutherChargePossessionNotGiven) {
		this.femaleRegisFutherChargePossessionNotGiven = femaleRegisFutherChargePossessionNotGiven;
	}

	public String getFemaleRegisGiftDeed() {
		return femaleRegisGiftDeed;
	}

	public void setFemaleRegisGiftDeed(String femaleRegisGiftDeed) {
		this.femaleRegisGiftDeed = femaleRegisGiftDeed;
	}

	public String getFemaleRegisIndemnityBond() {
		return femaleRegisIndemnityBond;
	}

	public void setFemaleRegisIndemnityBond(String femaleRegisIndemnityBond) {
		this.femaleRegisIndemnityBond = femaleRegisIndemnityBond;
	}

	public String getFemaleRegisLeaseRentFixed() {
		return femaleRegisLeaseRentFixed;
	}

	public void setFemaleRegisLeaseRentFixed(String femaleRegisLeaseRentFixed) {
		this.femaleRegisLeaseRentFixed = femaleRegisLeaseRentFixed;
	}

	public String getFemaleRegisLeaseLessThanOneYear() {
		return femaleRegisLeaseLessThanOneYear;
	}

	public void setFemaleRegisLeaseLessThanOneYear(String femaleRegisLeaseLessThanOneYear) {
		this.femaleRegisLeaseLessThanOneYear = femaleRegisLeaseLessThanOneYear;
	}

	public String getFemaleRegisLeaseLessThanFiveYear() {
		return femaleRegisLeaseLessThanFiveYear;
	}

	public void setFemaleRegisLeaseLessThanFiveYear(String femaleRegisLeaseLessThanFiveYear) {
		this.femaleRegisLeaseLessThanFiveYear = femaleRegisLeaseLessThanFiveYear;
	}

	public String getFemaleRegisLeaseLessThanTenYear() {
		return femaleRegisLeaseLessThanTenYear;
	}

	public void setFemaleRegisLeaseLessThanTenYear(String femaleRegisLeaseLessThanTenYear) {
		this.femaleRegisLeaseLessThanTenYear = femaleRegisLeaseLessThanTenYear;
	}

	public String getFemaleRegisLeaseLessThanTwentyYear() {
		return femaleRegisLeaseLessThanTwentyYear;
	}

	public void setFemaleRegisLeaseLessThanTwentyYear(String femaleRegisLeaseLessThanTwentyYear) {
		this.femaleRegisLeaseLessThanTwentyYear = femaleRegisLeaseLessThanTwentyYear;
	}

	public String getFemaleRegisLeaseLessThanThirtyYear() {
		return femaleRegisLeaseLessThanThirtyYear;
	}

	public void setFemaleRegisLeaseLessThanThirtyYear(String femaleRegisLeaseLessThanThirtyYear) {
		this.femaleRegisLeaseLessThanThirtyYear = femaleRegisLeaseLessThanThirtyYear;
	}

	public String getFemaleRegisLeaseLessThanHundredYear() {
		return femaleRegisLeaseLessThanHundredYear;
	}

	public void setFemaleRegisLeaseLessThanHundredYear(String femaleRegisLeaseLessThanHundredYear) {
		this.femaleRegisLeaseLessThanHundredYear = femaleRegisLeaseLessThanHundredYear;
	}

	public String getFemaleRegisLeaseMoreThanHundredYear() {
		return femaleRegisLeaseMoreThanHundredYear;
	}

	public void setFemaleRegisLeaseMoreThanHundredYear(String femaleRegisLeaseMoreThanHundredYear) {
		this.femaleRegisLeaseMoreThanHundredYear = femaleRegisLeaseMoreThanHundredYear;
	}

	public String getFemaleRegisLeaseNotDefiniteTerm() {
		return femaleRegisLeaseNotDefiniteTerm;
	}

	public void setFemaleRegisLeaseNotDefiniteTerm(String femaleRegisLeaseNotDefiniteTerm) {
		this.femaleRegisLeaseNotDefiniteTerm = femaleRegisLeaseNotDefiniteTerm;
	}

	public String getFemaleRegisLeaseNoRentReserved() {
		return femaleRegisLeaseNoRentReserved;
	}

	public void setFemaleRegisLeaseNoRentReserved(String femaleRegisLeaseNoRentReserved) {
		this.femaleRegisLeaseNoRentReserved = femaleRegisLeaseNoRentReserved;
	}

	public String getFemaleRegisLeaseAdditionOnRentReserved() {
		return femaleRegisLeaseAdditionOnRentReserved;
	}

	public void setFemaleRegisLeaseAdditionOnRentReserved(String femaleRegisLeaseAdditionOnRentReserved) {
		this.femaleRegisLeaseAdditionOnRentReserved = femaleRegisLeaseAdditionOnRentReserved;
	}

	public String getFemaleRegisLeaseRevisionNotification() {
		return femaleRegisLeaseRevisionNotification;
	}

	public void setFemaleRegisLeaseRevisionNotification(String femaleRegisLeaseRevisionNotification) {
		this.femaleRegisLeaseRevisionNotification = femaleRegisLeaseRevisionNotification;
	}

	public String getFemaleRegisLetterOfAllotmentOfShares() {
		return femaleRegisLetterOfAllotmentOfShares;
	}

	public void setFemaleRegisLetterOfAllotmentOfShares(String femaleRegisLetterOfAllotmentOfShares) {
		this.femaleRegisLetterOfAllotmentOfShares = femaleRegisLetterOfAllotmentOfShares;
	}

	public String getFemaleRegisLetterOfCredit() {
		return femaleRegisLetterOfCredit;
	}

	public void setFemaleRegisLetterOfCredit(String femaleRegisLetterOfCredit) {
		this.femaleRegisLetterOfCredit = femaleRegisLetterOfCredit;
	}

	public String getFemaleRegisLetterOfLicence() {
		return femaleRegisLetterOfLicence;
	}

	public void setFemaleRegisLetterOfLicence(String femaleRegisLetterOfLicence) {
		this.femaleRegisLetterOfLicence = femaleRegisLetterOfLicence;
	}

	public String getFemaleRegisMemorandumOfAssoOfCompany() {
		return femaleRegisMemorandumOfAssoOfCompany;
	}

	public void setFemaleRegisMemorandumOfAssoOfCompany(String femaleRegisMemorandumOfAssoOfCompany) {
		this.femaleRegisMemorandumOfAssoOfCompany = femaleRegisMemorandumOfAssoOfCompany;
	}

	public String getFemaleRegisMortgageWithPossession() {
		return femaleRegisMortgageWithPossession;
	}

	public void setFemaleRegisMortgageWithPossession(String femaleRegisMortgageWithPossession) {
		this.femaleRegisMortgageWithPossession = femaleRegisMortgageWithPossession;
	}

	public String getFemaleRegisMortgageWithoutPossession() {
		return femaleRegisMortgageWithoutPossession;
	}

	public void setFemaleRegisMortgageWithoutPossession(String femaleRegisMortgageWithoutPossession) {
		this.femaleRegisMortgageWithoutPossession = femaleRegisMortgageWithoutPossession;
	}

	public String getFemaleRegisMortgageOfCropLessThanThree() {
		return femaleRegisMortgageOfCropLessThanThree;
	}

	public void setFemaleRegisMortgageOfCropLessThanThree(String femaleRegisMortgageOfCropLessThanThree) {
		this.femaleRegisMortgageOfCropLessThanThree = femaleRegisMortgageOfCropLessThanThree;
	}

	public String getFemaleRegisMortgageOfCropMoreThanThree() {
		return femaleRegisMortgageOfCropMoreThanThree;
	}

	public void setFemaleRegisMortgageOfCropMoreThanThree(String femaleRegisMortgageOfCropMoreThanThree) {
		this.femaleRegisMortgageOfCropMoreThanThree = femaleRegisMortgageOfCropMoreThanThree;
	}

	public String getFemaleRegisNotarialAct() {
		return femaleRegisNotarialAct;
	}

	public void setFemaleRegisNotarialAct(String femaleRegisNotarialAct) {
		this.femaleRegisNotarialAct = femaleRegisNotarialAct;
	}

	public String getFemaleRegisNoteOrMemorandum() {
		return femaleRegisNoteOrMemorandum;
	}

	public void setFemaleRegisNoteOrMemorandum(String femaleRegisNoteOrMemorandum) {
		this.femaleRegisNoteOrMemorandum = femaleRegisNoteOrMemorandum;
	}

	public String getFemaleRegisNoteOfProtestByTheMasterOfShip() {
		return femaleRegisNoteOfProtestByTheMasterOfShip;
	}

	public void setFemaleRegisNoteOfProtestByTheMasterOfShip(String femaleRegisNoteOfProtestByTheMasterOfShip) {
		this.femaleRegisNoteOfProtestByTheMasterOfShip = femaleRegisNoteOfProtestByTheMasterOfShip;
	}

	public String getFemaleRegisPartitionDeed() {
		return femaleRegisPartitionDeed;
	}

	public void setFemaleRegisPartitionDeed(String femaleRegisPartitionDeed) {
		this.femaleRegisPartitionDeed = femaleRegisPartitionDeed;
	}

	public String getFemaleRegisPartnerShip() {
		return femaleRegisPartnerShip;
	}

	public void setFemaleRegisPartnerShip(String femaleRegisPartnerShip) {
		this.femaleRegisPartnerShip = femaleRegisPartnerShip;
	}

	public String getFemaleRegisPartnerShipDissolution() {
		return femaleRegisPartnerShipDissolution;
	}

	public void setFemaleRegisPartnerShipDissolution(String femaleRegisPartnerShipDissolution) {
		this.femaleRegisPartnerShipDissolution = femaleRegisPartnerShipDissolution;
	}

	public String getFemaleRegisPolOfInsLessThanEighteen() {
		return femaleRegisPolOfInsLessThanEighteen;
	}

	public void setFemaleRegisPolOfInsLessThanEighteen(String femaleRegisPolOfInsLessThanEighteen) {
		this.femaleRegisPolOfInsLessThanEighteen = femaleRegisPolOfInsLessThanEighteen;
	}

	public String getFemaleRegisPolOfInsOneThousandFiveHundred() {
		return femaleRegisPolOfInsOneThousandFiveHundred;
	}

	public void setFemaleRegisPolOfInsOneThousandFiveHundred(String femaleRegisPolOfInsOneThousandFiveHundred) {
		this.femaleRegisPolOfInsOneThousandFiveHundred = femaleRegisPolOfInsOneThousandFiveHundred;
	}

	public String getFemaleRegisPolOfInsOneThousand() {
		return femaleRegisPolOfInsOneThousand;
	}

	public void setFemaleRegisPolOfInsOneThousand(String femaleRegisPolOfInsOneThousand) {
		this.femaleRegisPolOfInsOneThousand = femaleRegisPolOfInsOneThousand;
	}

	public String getFemaleRegisPolOfInsFireIns() {
		return femaleRegisPolOfInsFireIns;
	}

	public void setFemaleRegisPolOfInsFireIns(String femaleRegisPolOfInsFireIns) {
		this.femaleRegisPolOfInsFireIns = femaleRegisPolOfInsFireIns;
	}

	public String getFemaleRegisPolOfInsOts() {
		return femaleRegisPolOfInsOts;
	}

	public void setFemaleRegisPolOfInsOts(String femaleRegisPolOfInsOts) {
		this.femaleRegisPolOfInsOts = femaleRegisPolOfInsOts;
	}

	public String getFemaleRegisPolOfInsRenewalOriginalPol() {
		return femaleRegisPolOfInsRenewalOriginalPol;
	}

	public void setFemaleRegisPolOfInsRenewalOriginalPol(String femaleRegisPolOfInsRenewalOriginalPol) {
		this.femaleRegisPolOfInsRenewalOriginalPol = femaleRegisPolOfInsRenewalOriginalPol;
	}

	public String getFemaleRegisPolOfInsAccidental() {
		return femaleRegisPolOfInsAccidental;
	}

	public void setFemaleRegisPolOfInsAccidental(String femaleRegisPolOfInsAccidental) {
		this.femaleRegisPolOfInsAccidental = femaleRegisPolOfInsAccidental;
	}

	public String getFemaleRegisPolOfInsNotExceedOneThousand() {
		return femaleRegisPolOfInsNotExceedOneThousand;
	}

	public void setFemaleRegisPolOfInsNotExceedOneThousand(String femaleRegisPolOfInsNotExceedOneThousand) {
		this.femaleRegisPolOfInsNotExceedOneThousand = femaleRegisPolOfInsNotExceedOneThousand;
	}

	public String getFemaleRegisPolOfInsIndemnity() {
		return femaleRegisPolOfInsIndemnity;
	}

	public void setFemaleRegisPolOfInsIndemnity(String femaleRegisPolOfInsIndemnity) {
		this.femaleRegisPolOfInsIndemnity = femaleRegisPolOfInsIndemnity;
	}

	public String getFemaleRegisPolOfInsLifeIns() {
		return femaleRegisPolOfInsLifeIns;
	}

	public void setFemaleRegisPolOfInsLifeIns(String femaleRegisPolOfInsLifeIns) {
		this.femaleRegisPolOfInsLifeIns = femaleRegisPolOfInsLifeIns;
	}

	public String getFemaleRegisPolOfInsLessThanFiveHundred() {
		return femaleRegisPolOfInsLessThanFiveHundred;
	}

	public void setFemaleRegisPolOfInsLessThanFiveHundred(String femaleRegisPolOfInsLessThanFiveHundred) {
		this.femaleRegisPolOfInsLessThanFiveHundred = femaleRegisPolOfInsLessThanFiveHundred;
	}

	public String getFemaleRegisPolOfInsLessThanOneThousand() {
		return femaleRegisPolOfInsLessThanOneThousand;
	}

	public void setFemaleRegisPolOfInsLessThanOneThousand(String femaleRegisPolOfInsLessThanOneThousand) {
		this.femaleRegisPolOfInsLessThanOneThousand = femaleRegisPolOfInsLessThanOneThousand;
	}

	public String getFemaleRegisPolOfInsReIns() {
		return femaleRegisPolOfInsReIns;
	}

	public void setFemaleRegisPolOfInsReIns(String femaleRegisPolOfInsReIns) {
		this.femaleRegisPolOfInsReIns = femaleRegisPolOfInsReIns;
	}

	public String getFemaleRegisPwrOfAttorneySpecial() {
		return femaleRegisPwrOfAttorneySpecial;
	}

	public void setFemaleRegisPwrOfAttorneySpecial(String femaleRegisPwrOfAttorneySpecial) {
		this.femaleRegisPwrOfAttorneySpecial = femaleRegisPwrOfAttorneySpecial;
	}

	public String getFemaleRegisPwrOfAttorneyGeneral() {
		return femaleRegisPwrOfAttorneyGeneral;
	}

	public void setFemaleRegisPwrOfAttorneyGeneral(String femaleRegisPwrOfAttorneyGeneral) {
		this.femaleRegisPwrOfAttorneyGeneral = femaleRegisPwrOfAttorneyGeneral;
	}

	public String getFemaleRegisPromissoryNoteLessThanOneThousand() {
		return femaleRegisPromissoryNoteLessThanOneThousand;
	}

	public void setFemaleRegisPromissoryNoteLessThanOneThousand(String femaleRegisPromissoryNoteLessThanOneThousand) {
		this.femaleRegisPromissoryNoteLessThanOneThousand = femaleRegisPromissoryNoteLessThanOneThousand;
	}

	public String getFemaleRegisPromissoryNoteOtCases() {
		return femaleRegisPromissoryNoteOtCases;
	}

	public void setFemaleRegisPromissoryNoteOtCases(String femaleRegisPromissoryNoteOtCases) {
		this.femaleRegisPromissoryNoteOtCases = femaleRegisPromissoryNoteOtCases;
	}

	public String getFemaleRegisPromissoryNoteDemand() {
		return femaleRegisPromissoryNoteDemand;
	}

	public void setFemaleRegisPromissoryNoteDemand(String femaleRegisPromissoryNoteDemand) {
		this.femaleRegisPromissoryNoteDemand = femaleRegisPromissoryNoteDemand;
	}

	public String getFemaleRegisProtestOfBillOrNote() {
		return femaleRegisProtestOfBillOrNote;
	}

	public void setFemaleRegisProtestOfBillOrNote(String femaleRegisProtestOfBillOrNote) {
		this.femaleRegisProtestOfBillOrNote = femaleRegisProtestOfBillOrNote;
	}

	public String getFemaleRegisProtestByTheMasterOfShip() {
		return femaleRegisProtestByTheMasterOfShip;
	}

	public void setFemaleRegisProtestByTheMasterOfShip(String femaleRegisProtestByTheMasterOfShip) {
		this.femaleRegisProtestByTheMasterOfShip = femaleRegisProtestByTheMasterOfShip;
	}

	public String getFemaleRegisProxy() {
		return femaleRegisProxy;
	}

	public void setFemaleRegisProxy(String femaleRegisProxy) {
		this.femaleRegisProxy = femaleRegisProxy;
	}

	public String getFemaleRegisReceipt() {
		return femaleRegisReceipt;
	}

	public void setFemaleRegisReceipt(String femaleRegisReceipt) {
		this.femaleRegisReceipt = femaleRegisReceipt;
	}

	public String getFemaleRegisReconveyanceLessThanOneThousand() {
		return femaleRegisReconveyanceLessThanOneThousand;
	}

	public void setFemaleRegisReconveyanceLessThanOneThousand(String femaleRegisReconveyanceLessThanOneThousand) {
		this.femaleRegisReconveyanceLessThanOneThousand = femaleRegisReconveyanceLessThanOneThousand;
	}

	public String getFemaleRegisReconveyanceOts() {
		return femaleRegisReconveyanceOts;
	}

	public void setFemaleRegisReconveyanceOts(String femaleRegisReconveyanceOts) {
		this.femaleRegisReconveyanceOts = femaleRegisReconveyanceOts;
	}

	public String getFemaleRegisReleaseRelinquishmentOfRightLessThanOneThousand() {
		return femaleRegisReleaseRelinquishmentOfRightLessThanOneThousand;
	}

	public void setFemaleRegisReleaseRelinquishmentOfRightLessThanOneThousand(
			String femaleRegisReleaseRelinquishmentOfRightLessThanOneThousand) {
		this.femaleRegisReleaseRelinquishmentOfRightLessThanOneThousand = femaleRegisReleaseRelinquishmentOfRightLessThanOneThousand;
	}

	public String getFemaleRegisReleaseRelinquishmentOfRightOts() {
		return femaleRegisReleaseRelinquishmentOfRightOts;
	}

	public void setFemaleRegisReleaseRelinquishmentOfRightOts(String femaleRegisReleaseRelinquishmentOfRightOts) {
		this.femaleRegisReleaseRelinquishmentOfRightOts = femaleRegisReleaseRelinquishmentOfRightOts;
	}

	public String getFemaleRegisRespondentiaBond() {
		return femaleRegisRespondentiaBond;
	}

	public void setFemaleRegisRespondentiaBond(String femaleRegisRespondentiaBond) {
		this.femaleRegisRespondentiaBond = femaleRegisRespondentiaBond;
	}

	public String getFemaleRegisSecurityBond() {
		return femaleRegisSecurityBond;
	}

	public void setFemaleRegisSecurityBond(String femaleRegisSecurityBond) {
		this.femaleRegisSecurityBond = femaleRegisSecurityBond;
	}

	public String getFemaleRegisSettlementInstrument() {
		return femaleRegisSettlementInstrument;
	}

	public void setFemaleRegisSettlementInstrument(String femaleRegisSettlementInstrument) {
		this.femaleRegisSettlementInstrument = femaleRegisSettlementInstrument;
	}

	public String getFemaleRegisShareWarrents() {
		return femaleRegisShareWarrents;
	}

	public void setFemaleRegisShareWarrents(String femaleRegisShareWarrents) {
		this.femaleRegisShareWarrents = femaleRegisShareWarrents;
	}

	public String getFemaleRegisShippingOrder() {
		return femaleRegisShippingOrder;
	}

	public void setFemaleRegisShippingOrder(String femaleRegisShippingOrder) {
		this.femaleRegisShippingOrder = femaleRegisShippingOrder;
	}

	public String getFemaleRegisSurrenderOfLeaseNotExceesTen() {
		return femaleRegisSurrenderOfLeaseNotExceesTen;
	}

	public void setFemaleRegisSurrenderOfLeaseNotExceesTen(String femaleRegisSurrenderOfLeaseNotExceesTen) {
		this.femaleRegisSurrenderOfLeaseNotExceesTen = femaleRegisSurrenderOfLeaseNotExceesTen;
	}

	public String getFemaleRegisSurrenderOfLeaseOts() {
		return femaleRegisSurrenderOfLeaseOts;
	}

	public void setFemaleRegisSurrenderOfLeaseOts(String femaleRegisSurrenderOfLeaseOts) {
		this.femaleRegisSurrenderOfLeaseOts = femaleRegisSurrenderOfLeaseOts;
	}

	public String getFemaleRegisTransferOfShares() {
		return femaleRegisTransferOfShares;
	}

	public void setFemaleRegisTransferOfShares(String femaleRegisTransferOfShares) {
		this.femaleRegisTransferOfShares = femaleRegisTransferOfShares;
	}

	public String getFemaleRegisTransferOfDebentures() {
		return femaleRegisTransferOfDebentures;
	}

	public void setFemaleRegisTransferOfDebentures(String femaleRegisTransferOfDebentures) {
		this.femaleRegisTransferOfDebentures = femaleRegisTransferOfDebentures;
	}

	public String getFemaleRegisTransferSecuredBond() {
		return femaleRegisTransferSecuredBond;
	}

	public void setFemaleRegisTransferSecuredBond(String femaleRegisTransferSecuredBond) {
		this.femaleRegisTransferSecuredBond = femaleRegisTransferSecuredBond;
	}

	public String getFemaleRegisTransferMorgageDeed() {
		return femaleRegisTransferMorgageDeed;
	}

	public void setFemaleRegisTransferMorgageDeed(String femaleRegisTransferMorgageDeed) {
		this.femaleRegisTransferMorgageDeed = femaleRegisTransferMorgageDeed;
	}

	public String getFemaleRegisTransferOts() {
		return femaleRegisTransferOts;
	}

	public void setFemaleRegisTransferOts(String femaleRegisTransferOts) {
		this.femaleRegisTransferOts = femaleRegisTransferOts;
	}

	public String getFemaleRegisTransferAdministratorGeneral() {
		return femaleRegisTransferAdministratorGeneral;
	}

	public void setFemaleRegisTransferAdministratorGeneral(String femaleRegisTransferAdministratorGeneral) {
		this.femaleRegisTransferAdministratorGeneral = femaleRegisTransferAdministratorGeneral;
	}

	public String getFemaleRegisTransferTrustProperty() {
		return femaleRegisTransferTrustProperty;
	}

	public void setFemaleRegisTransferTrustProperty(String femaleRegisTransferTrustProperty) {
		this.femaleRegisTransferTrustProperty = femaleRegisTransferTrustProperty;
	}

	public String getFemaleRegisTransferofLease() {
		return femaleRegisTransferofLease;
	}

	public void setFemaleRegisTransferofLease(String femaleRegisTransferofLease) {
		this.femaleRegisTransferofLease = femaleRegisTransferofLease;
	}

	public String getFemaleRegisTrustBeingWill() {
		return femaleRegisTrustBeingWill;
	}

	public void setFemaleRegisTrustBeingWill(String femaleRegisTrustBeingWill) {
		this.femaleRegisTrustBeingWill = femaleRegisTrustBeingWill;
	}

	public String getFemaleRegisTrustNotBeingWill() {
		return femaleRegisTrustNotBeingWill;
	}

	public void setFemaleRegisTrustNotBeingWill(String femaleRegisTrustNotBeingWill) {
		this.femaleRegisTrustNotBeingWill = femaleRegisTrustNotBeingWill;
	}

	public String getFemaleRegisWarrentGoods() {
		return femaleRegisWarrentGoods;
	}

	public void setFemaleRegisWarrentGoods(String femaleRegisWarrentGoods) {
		this.femaleRegisWarrentGoods = femaleRegisWarrentGoods;
	}

	public String getJointStAcknowledgement() {
		return jointStAcknowledgement;
	}

	public void setJointStAcknowledgement(String jointStAcknowledgement) {
		this.jointStAcknowledgement = jointStAcknowledgement;
	}

	public String getJointStAdministrativeBond() {
		return jointStAdministrativeBond;
	}

	public void setJointStAdministrativeBond(String jointStAdministrativeBond) {
		this.jointStAdministrativeBond = jointStAdministrativeBond;
	}

	public String getJointStAdoptionDeed() {
		return jointStAdoptionDeed;
	}

	public void setJointStAdoptionDeed(String jointStAdoptionDeed) {
		this.jointStAdoptionDeed = jointStAdoptionDeed;
	}

	public String getJointStAffidavitIncAffOfDeclaration() {
		return jointStAffidavitIncAffOfDeclaration;
	}

	public void setJointStAffidavitIncAffOfDeclaration(String jointStAffidavitIncAffOfDeclaration) {
		this.jointStAffidavitIncAffOfDeclaration = jointStAffidavitIncAffOfDeclaration;
	}

	public String getJointStAgreementOfConveyance() {
		return jointStAgreementOfConveyance;
	}

	public void setJointStAgreementOfConveyance(String jointStAgreementOfConveyance) {
		this.jointStAgreementOfConveyance = jointStAgreementOfConveyance;
	}

	public String getJointStAgreementDevelopment() {
		return jointStAgreementDevelopment;
	}

	public void setJointStAgreementDevelopment(String jointStAgreementDevelopment) {
		this.jointStAgreementDevelopment = jointStAgreementDevelopment;
	}

	public String getJointStAgreementOts() {
		return jointStAgreementOts;
	}

	public void setJointStAgreementOts(String jointStAgreementOts) {
		this.jointStAgreementOts = jointStAgreementOts;
	}

	public String getJointStAgreeRelatDawnOrPledgeExceedLessThanOneThousand() {
		return jointStAgreeRelatDawnOrPledgeExceedLessThanOneThousand;
	}

	public void setJointStAgreeRelatDawnOrPledgeExceedLessThanOneThousand(
			String jointStAgreeRelatDawnOrPledgeExceedLessThanOneThousand) {
		this.jointStAgreeRelatDawnOrPledgeExceedLessThanOneThousand = jointStAgreeRelatDawnOrPledgeExceedLessThanOneThousand;
	}

	public String getJointStAgreeRelatDawnOrPledgeExceedLessThanTenThousand() {
		return jointStAgreeRelatDawnOrPledgeExceedLessThanTenThousand;
	}

	public void setJointStAgreeRelatDawnOrPledgeExceedLessThanTenThousand(
			String jointStAgreeRelatDawnOrPledgeExceedLessThanTenThousand) {
		this.jointStAgreeRelatDawnOrPledgeExceedLessThanTenThousand = jointStAgreeRelatDawnOrPledgeExceedLessThanTenThousand;
	}

	public String getJointStAgreeRelatDawnOrPledgeExceedMoreThanTenThousand() {
		return jointStAgreeRelatDawnOrPledgeExceedMoreThanTenThousand;
	}

	public void setJointStAgreeRelatDawnOrPledgeExceedMoreThanTenThousand(
			String jointStAgreeRelatDawnOrPledgeExceedMoreThanTenThousand) {
		this.jointStAgreeRelatDawnOrPledgeExceedMoreThanTenThousand = jointStAgreeRelatDawnOrPledgeExceedMoreThanTenThousand;
	}

	public String getJointStAgreeRelatDawnOrPledgeThreeMonths() {
		return jointStAgreeRelatDawnOrPledgeThreeMonths;
	}

	public void setJointStAgreeRelatDawnOrPledgeThreeMonths(String jointStAgreeRelatDawnOrPledgeThreeMonths) {
		this.jointStAgreeRelatDawnOrPledgeThreeMonths = jointStAgreeRelatDawnOrPledgeThreeMonths;
	}

	public String getJointStAppointmentInExecutionOfPwr() {
		return jointStAppointmentInExecutionOfPwr;
	}

	public void setJointStAppointmentInExecutionOfPwr(String jointStAppointmentInExecutionOfPwr) {
		this.jointStAppointmentInExecutionOfPwr = jointStAppointmentInExecutionOfPwr;
	}

	public String getJointStAppOrValNotExceed() {
		return jointStAppOrValNotExceed;
	}

	public void setJointStAppOrValNotExceed(String jointStAppOrValNotExceed) {
		this.jointStAppOrValNotExceed = jointStAppOrValNotExceed;
	}

	public String getJointStAppOrValOtCase() {
		return jointStAppOrValOtCase;
	}

	public void setJointStAppOrValOtCase(String jointStAppOrValOtCase) {
		this.jointStAppOrValOtCase = jointStAppOrValOtCase;
	}

	public String getJointStApprenticeshipDeed() {
		return jointStApprenticeshipDeed;
	}

	public void setJointStApprenticeshipDeed(String jointStApprenticeshipDeed) {
		this.jointStApprenticeshipDeed = jointStApprenticeshipDeed;
	}

	public String getJointStArtsOfAssoOfCompanyNotExceed() {
		return jointStArtsOfAssoOfCompanyNotExceed;
	}

	public void setJointStArtsOfAssoOfCompanyNotExceed(String jointStArtsOfAssoOfCompanyNotExceed) {
		this.jointStArtsOfAssoOfCompanyNotExceed = jointStArtsOfAssoOfCompanyNotExceed;
	}

	public String getJointStArtsOfAssoOfCompanyAbove() {
		return jointStArtsOfAssoOfCompanyAbove;
	}

	public void setJointStArtsOfAssoOfCompanyAbove(String jointStArtsOfAssoOfCompanyAbove) {
		this.jointStArtsOfAssoOfCompanyAbove = jointStArtsOfAssoOfCompanyAbove;
	}

	public String getJointStArtsOfClerkship() {
		return jointStArtsOfClerkship;
	}

	public void setJointStArtsOfClerkship(String jointStArtsOfClerkship) {
		this.jointStArtsOfClerkship = jointStArtsOfClerkship;
	}

	public String getJointStAwardNotExceed() {
		return jointStAwardNotExceed;
	}

	public void setJointStAwardNotExceed(String jointStAwardNotExceed) {
		this.jointStAwardNotExceed = jointStAwardNotExceed;
	}

	public String getJointStAwardExceed() {
		return jointStAwardExceed;
	}

	public void setJointStAwardExceed(String jointStAwardExceed) {
		this.jointStAwardExceed = jointStAwardExceed;
	}

	public String getJointStBillOfExchangeWherePayableOtwise() {
		return jointStBillOfExchangeWherePayableOtwise;
	}

	public void setJointStBillOfExchangeWherePayableOtwise(String jointStBillOfExchangeWherePayableOtwise) {
		this.jointStBillOfExchangeWherePayableOtwise = jointStBillOfExchangeWherePayableOtwise;
	}

	public String getJointStBillOfLading() {
		return jointStBillOfLading;
	}

	public void setJointStBillOfLading(String jointStBillOfLading) {
		this.jointStBillOfLading = jointStBillOfLading;
	}

	public String getJointStBond() {
		return jointStBond;
	}

	public void setJointStBond(String jointStBond) {
		this.jointStBond = jointStBond;
	}

	public String getJointStBottomryBond() {
		return jointStBottomryBond;
	}

	public void setJointStBottomryBond(String jointStBottomryBond) {
		this.jointStBottomryBond = jointStBottomryBond;
	}

	public String getJointStCancellation() {
		return jointStCancellation;
	}

	public void setJointStCancellation(String jointStCancellation) {
		this.jointStCancellation = jointStCancellation;
	}

	public String getJointStCertificateOfSale() {
		return jointStCertificateOfSale;
	}

	public void setJointStCertificateOfSale(String jointStCertificateOfSale) {
		this.jointStCertificateOfSale = jointStCertificateOfSale;
	}

	public String getJointStCertificateOrOtDocument() {
		return jointStCertificateOrOtDocument;
	}

	public void setJointStCertificateOrOtDocument(String jointStCertificateOrOtDocument) {
		this.jointStCertificateOrOtDocument = jointStCertificateOrOtDocument;
	}

	public String getJointStCharterParty() {
		return jointStCharterParty;
	}

	public void setJointStCharterParty(String jointStCharterParty) {
		this.jointStCharterParty = jointStCharterParty;
	}

	public String getJointStCompositionDeed() {
		return jointStCompositionDeed;
	}

	public void setJointStCompositionDeed(String jointStCompositionDeed) {
		this.jointStCompositionDeed = jointStCompositionDeed;
	}

	public String getJointStSaleConveyance() {
		return jointStSaleConveyance;
	}

	public void setJointStSaleConveyance(String jointStSaleConveyance) {
		this.jointStSaleConveyance = jointStSaleConveyance;
	}

	public String getJointStCertifiedCopy() {
		return jointStCertifiedCopy;
	}

	public void setJointStCertifiedCopy(String jointStCertifiedCopy) {
		this.jointStCertifiedCopy = jointStCertifiedCopy;
	}

	public String getJointStCounterpartOrDuplicateOfAnyInstrument() {
		return jointStCounterpartOrDuplicateOfAnyInstrument;
	}

	public void setJointStCounterpartOrDuplicateOfAnyInstrument(String jointStCounterpartOrDuplicateOfAnyInstrument) {
		this.jointStCounterpartOrDuplicateOfAnyInstrument = jointStCounterpartOrDuplicateOfAnyInstrument;
	}

	public String getJointStCustomsBondNotExceed() {
		return jointStCustomsBondNotExceed;
	}

	public void setJointStCustomsBondNotExceed(String jointStCustomsBondNotExceed) {
		this.jointStCustomsBondNotExceed = jointStCustomsBondNotExceed;
	}

	public String getJointStCustomsBondOtCase() {
		return jointStCustomsBondOtCase;
	}

	public void setJointStCustomsBondOtCase(String jointStCustomsBondOtCase) {
		this.jointStCustomsBondOtCase = jointStCustomsBondOtCase;
	}

	public String getJointStDebenture() {
		return jointStDebenture;
	}

	public void setJointStDebenture(String jointStDebenture) {
		this.jointStDebenture = jointStDebenture;
	}

	public String getJointStDebentureEndorsedNotExceed() {
		return jointStDebentureEndorsedNotExceed;
	}

	public void setJointStDebentureEndorsedNotExceed(String jointStDebentureEndorsedNotExceed) {
		this.jointStDebentureEndorsedNotExceed = jointStDebentureEndorsedNotExceed;
	}

	public String getJointStDebentureEndorsedExcess() {
		return jointStDebentureEndorsedExcess;
	}

	public void setJointStDebentureEndorsedExcess(String jointStDebentureEndorsedExcess) {
		this.jointStDebentureEndorsedExcess = jointStDebentureEndorsedExcess;
	}

	public String getJointStDebentureDeliveryNotExceed() {
		return jointStDebentureDeliveryNotExceed;
	}

	public void setJointStDebentureDeliveryNotExceed(String jointStDebentureDeliveryNotExceed) {
		this.jointStDebentureDeliveryNotExceed = jointStDebentureDeliveryNotExceed;
	}

	public String getJointStDebentureDeliveryExcess() {
		return jointStDebentureDeliveryExcess;
	}

	public void setJointStDebentureDeliveryExcess(String jointStDebentureDeliveryExcess) {
		this.jointStDebentureDeliveryExcess = jointStDebentureDeliveryExcess;
	}

	public String getJointStDeliveryOrderInRespectofGoods() {
		return jointStDeliveryOrderInRespectofGoods;
	}

	public void setJointStDeliveryOrderInRespectofGoods(String jointStDeliveryOrderInRespectofGoods) {
		this.jointStDeliveryOrderInRespectofGoods = jointStDeliveryOrderInRespectofGoods;
	}

	public String getJointStDivorceDeed() {
		return jointStDivorceDeed;
	}

	public void setJointStDivorceDeed(String jointStDivorceDeed) {
		this.jointStDivorceDeed = jointStDivorceDeed;
	}

	public String getJointStEntryAsAnAdvocateAdvocate() {
		return jointStEntryAsAnAdvocateAdvocate;
	}

	public void setJointStEntryAsAnAdvocateAdvocate(String jointStEntryAsAnAdvocateAdvocate) {
		this.jointStEntryAsAnAdvocateAdvocate = jointStEntryAsAnAdvocateAdvocate;
	}

	public String getJointStEntryAsAnAdvocateAttorney() {
		return jointStEntryAsAnAdvocateAttorney;
	}

	public void setJointStEntryAsAnAdvocateAttorney(String jointStEntryAsAnAdvocateAttorney) {
		this.jointStEntryAsAnAdvocateAttorney = jointStEntryAsAnAdvocateAttorney;
	}

	public String getJointStExchangeOfProperty() {
		return jointStExchangeOfProperty;
	}

	public void setJointStExchangeOfProperty(String jointStExchangeOfProperty) {
		this.jointStExchangeOfProperty = jointStExchangeOfProperty;
	}

	public String getJointStFutherChargeWithPossession() {
		return jointStFutherChargeWithPossession;
	}

	public void setJointStFutherChargeWithPossession(String jointStFutherChargeWithPossession) {
		this.jointStFutherChargeWithPossession = jointStFutherChargeWithPossession;
	}

	public String getJointStFutherChargeWithoutPossession() {
		return jointStFutherChargeWithoutPossession;
	}

	public void setJointStFutherChargeWithoutPossession(String jointStFutherChargeWithoutPossession) {
		this.jointStFutherChargeWithoutPossession = jointStFutherChargeWithoutPossession;
	}

	public String getJointStFutherChargtPossessionGiven() {
		return jointStFutherChargtPossessionGiven;
	}

	public void setJointStFutherChargtPossessionGiven(String jointStFutherChargtPossessionGiven) {
		this.jointStFutherChargtPossessionGiven = jointStFutherChargtPossessionGiven;
	}

	public String getJointStFutherChargePossessionNotGiven() {
		return jointStFutherChargePossessionNotGiven;
	}

	public void setJointStFutherChargePossessionNotGiven(String jointStFutherChargePossessionNotGiven) {
		this.jointStFutherChargePossessionNotGiven = jointStFutherChargePossessionNotGiven;
	}

	public String getJointStGiftDeed() {
		return jointStGiftDeed;
	}

	public void setJointStGiftDeed(String jointStGiftDeed) {
		this.jointStGiftDeed = jointStGiftDeed;
	}

	public String getJointStIndemnityBond() {
		return jointStIndemnityBond;
	}

	public void setJointStIndemnityBond(String jointStIndemnityBond) {
		this.jointStIndemnityBond = jointStIndemnityBond;
	}

	public String getJointStLeaseRentFixed() {
		return jointStLeaseRentFixed;
	}

	public void setJointStLeaseRentFixed(String jointStLeaseRentFixed) {
		this.jointStLeaseRentFixed = jointStLeaseRentFixed;
	}

	public String getJointStLeaseLessThanOneYear() {
		return jointStLeaseLessThanOneYear;
	}

	public void setJointStLeaseLessThanOneYear(String jointStLeaseLessThanOneYear) {
		this.jointStLeaseLessThanOneYear = jointStLeaseLessThanOneYear;
	}

	public String getJointStLeaseLessThanFiveYear() {
		return jointStLeaseLessThanFiveYear;
	}

	public void setJointStLeaseLessThanFiveYear(String jointStLeaseLessThanFiveYear) {
		this.jointStLeaseLessThanFiveYear = jointStLeaseLessThanFiveYear;
	}

	public String getJointStLeaseLessThanTenYear() {
		return jointStLeaseLessThanTenYear;
	}

	public void setJointStLeaseLessThanTenYear(String jointStLeaseLessThanTenYear) {
		this.jointStLeaseLessThanTenYear = jointStLeaseLessThanTenYear;
	}

	public String getJointStLeaseLessThanTwentyYear() {
		return jointStLeaseLessThanTwentyYear;
	}

	public void setJointStLeaseLessThanTwentyYear(String jointStLeaseLessThanTwentyYear) {
		this.jointStLeaseLessThanTwentyYear = jointStLeaseLessThanTwentyYear;
	}

	public String getJointStLeaseLessThanThirtyYear() {
		return jointStLeaseLessThanThirtyYear;
	}

	public void setJointStLeaseLessThanThirtyYear(String jointStLeaseLessThanThirtyYear) {
		this.jointStLeaseLessThanThirtyYear = jointStLeaseLessThanThirtyYear;
	}

	public String getJointStLeaseLessThanHundredYear() {
		return jointStLeaseLessThanHundredYear;
	}

	public void setJointStLeaseLessThanHundredYear(String jointStLeaseLessThanHundredYear) {
		this.jointStLeaseLessThanHundredYear = jointStLeaseLessThanHundredYear;
	}

	public String getJointStLeaseMoreThanHundredYear() {
		return jointStLeaseMoreThanHundredYear;
	}

	public void setJointStLeaseMoreThanHundredYear(String jointStLeaseMoreThanHundredYear) {
		this.jointStLeaseMoreThanHundredYear = jointStLeaseMoreThanHundredYear;
	}

	public String getJointStLeaseNotDefiniteTerm() {
		return jointStLeaseNotDefiniteTerm;
	}

	public void setJointStLeaseNotDefiniteTerm(String jointStLeaseNotDefiniteTerm) {
		this.jointStLeaseNotDefiniteTerm = jointStLeaseNotDefiniteTerm;
	}

	public String getJointStLeaseNoRentReserved() {
		return jointStLeaseNoRentReserved;
	}

	public void setJointStLeaseNoRentReserved(String jointStLeaseNoRentReserved) {
		this.jointStLeaseNoRentReserved = jointStLeaseNoRentReserved;
	}

	public String getJointStLeaseAdditionOnRentReserved() {
		return jointStLeaseAdditionOnRentReserved;
	}

	public void setJointStLeaseAdditionOnRentReserved(String jointStLeaseAdditionOnRentReserved) {
		this.jointStLeaseAdditionOnRentReserved = jointStLeaseAdditionOnRentReserved;
	}

	public String getJointStLeaseRevisionNotification() {
		return jointStLeaseRevisionNotification;
	}

	public void setJointStLeaseRevisionNotification(String jointStLeaseRevisionNotification) {
		this.jointStLeaseRevisionNotification = jointStLeaseRevisionNotification;
	}

	public String getJointStLetterOfAllotmentOfShares() {
		return jointStLetterOfAllotmentOfShares;
	}

	public void setJointStLetterOfAllotmentOfShares(String jointStLetterOfAllotmentOfShares) {
		this.jointStLetterOfAllotmentOfShares = jointStLetterOfAllotmentOfShares;
	}

	public String getJointStLetterOfCredit() {
		return jointStLetterOfCredit;
	}

	public void setJointStLetterOfCredit(String jointStLetterOfCredit) {
		this.jointStLetterOfCredit = jointStLetterOfCredit;
	}

	public String getJointStLetterOfLicence() {
		return jointStLetterOfLicence;
	}

	public void setJointStLetterOfLicence(String jointStLetterOfLicence) {
		this.jointStLetterOfLicence = jointStLetterOfLicence;
	}

	public String getJointStMemorandumOfAssoOfCompany() {
		return jointStMemorandumOfAssoOfCompany;
	}

	public void setJointStMemorandumOfAssoOfCompany(String jointStMemorandumOfAssoOfCompany) {
		this.jointStMemorandumOfAssoOfCompany = jointStMemorandumOfAssoOfCompany;
	}

	public String getJointStMortgageWithPossession() {
		return jointStMortgageWithPossession;
	}

	public void setJointStMortgageWithPossession(String jointStMortgageWithPossession) {
		this.jointStMortgageWithPossession = jointStMortgageWithPossession;
	}

	public String getJointStMortgageWithoutPossession() {
		return jointStMortgageWithoutPossession;
	}

	public void setJointStMortgageWithoutPossession(String jointStMortgageWithoutPossession) {
		this.jointStMortgageWithoutPossession = jointStMortgageWithoutPossession;
	}

	public String getJointStMortgageOfCropLessThanThree() {
		return jointStMortgageOfCropLessThanThree;
	}

	public void setJointStMortgageOfCropLessThanThree(String jointStMortgageOfCropLessThanThree) {
		this.jointStMortgageOfCropLessThanThree = jointStMortgageOfCropLessThanThree;
	}

	public String getJointStMortgageOfCropMoreThanThree() {
		return jointStMortgageOfCropMoreThanThree;
	}

	public void setJointStMortgageOfCropMoreThanThree(String jointStMortgageOfCropMoreThanThree) {
		this.jointStMortgageOfCropMoreThanThree = jointStMortgageOfCropMoreThanThree;
	}

	public String getJointStNotarialAct() {
		return jointStNotarialAct;
	}

	public void setJointStNotarialAct(String jointStNotarialAct) {
		this.jointStNotarialAct = jointStNotarialAct;
	}

	public String getJointStNoteOrMemorandum() {
		return jointStNoteOrMemorandum;
	}

	public void setJointStNoteOrMemorandum(String jointStNoteOrMemorandum) {
		this.jointStNoteOrMemorandum = jointStNoteOrMemorandum;
	}

	public String getJointStNoteOfProtestByTheMasterOfShip() {
		return jointStNoteOfProtestByTheMasterOfShip;
	}

	public void setJointStNoteOfProtestByTheMasterOfShip(String jointStNoteOfProtestByTheMasterOfShip) {
		this.jointStNoteOfProtestByTheMasterOfShip = jointStNoteOfProtestByTheMasterOfShip;
	}

	public String getJointStPartitionDeed() {
		return jointStPartitionDeed;
	}

	public void setJointStPartitionDeed(String jointStPartitionDeed) {
		this.jointStPartitionDeed = jointStPartitionDeed;
	}

	public String getJointStPartnerShip() {
		return jointStPartnerShip;
	}

	public void setJointStPartnerShip(String jointStPartnerShip) {
		this.jointStPartnerShip = jointStPartnerShip;
	}

	public String getJointStPartnerShipDissolution() {
		return jointStPartnerShipDissolution;
	}

	public void setJointStPartnerShipDissolution(String jointStPartnerShipDissolution) {
		this.jointStPartnerShipDissolution = jointStPartnerShipDissolution;
	}

	public String getJointStPolOfInsLessThanEighteen() {
		return jointStPolOfInsLessThanEighteen;
	}

	public void setJointStPolOfInsLessThanEighteen(String jointStPolOfInsLessThanEighteen) {
		this.jointStPolOfInsLessThanEighteen = jointStPolOfInsLessThanEighteen;
	}

	public String getJointStPolOfInsOneThousandFiveHundred() {
		return jointStPolOfInsOneThousandFiveHundred;
	}

	public void setJointStPolOfInsOneThousandFiveHundred(String jointStPolOfInsOneThousandFiveHundred) {
		this.jointStPolOfInsOneThousandFiveHundred = jointStPolOfInsOneThousandFiveHundred;
	}

	public String getJointStPolOfInsOneThousand() {
		return jointStPolOfInsOneThousand;
	}

	public void setJointStPolOfInsOneThousand(String jointStPolOfInsOneThousand) {
		this.jointStPolOfInsOneThousand = jointStPolOfInsOneThousand;
	}

	public String getJointStPolOfInsFireIns() {
		return jointStPolOfInsFireIns;
	}

	public void setJointStPolOfInsFireIns(String jointStPolOfInsFireIns) {
		this.jointStPolOfInsFireIns = jointStPolOfInsFireIns;
	}

	public String getJointStPolOfInsOts() {
		return jointStPolOfInsOts;
	}

	public void setJointStPolOfInsOts(String jointStPolOfInsOts) {
		this.jointStPolOfInsOts = jointStPolOfInsOts;
	}

	public String getJointStPolOfInsRenewalOriginalPol() {
		return jointStPolOfInsRenewalOriginalPol;
	}

	public void setJointStPolOfInsRenewalOriginalPol(String jointStPolOfInsRenewalOriginalPol) {
		this.jointStPolOfInsRenewalOriginalPol = jointStPolOfInsRenewalOriginalPol;
	}

	public String getJointStPolOfInsAccidental() {
		return jointStPolOfInsAccidental;
	}

	public void setJointStPolOfInsAccidental(String jointStPolOfInsAccidental) {
		this.jointStPolOfInsAccidental = jointStPolOfInsAccidental;
	}

	public String getJointStPolOfInsNotExceedOneThousand() {
		return jointStPolOfInsNotExceedOneThousand;
	}

	public void setJointStPolOfInsNotExceedOneThousand(String jointStPolOfInsNotExceedOneThousand) {
		this.jointStPolOfInsNotExceedOneThousand = jointStPolOfInsNotExceedOneThousand;
	}

	public String getJointStPolOfInsIndemnity() {
		return jointStPolOfInsIndemnity;
	}

	public void setJointStPolOfInsIndemnity(String jointStPolOfInsIndemnity) {
		this.jointStPolOfInsIndemnity = jointStPolOfInsIndemnity;
	}

	public String getJointStPolOfInsLifeIns() {
		return jointStPolOfInsLifeIns;
	}

	public void setJointStPolOfInsLifeIns(String jointStPolOfInsLifeIns) {
		this.jointStPolOfInsLifeIns = jointStPolOfInsLifeIns;
	}

	public String getJointStPolOfInsLessThanFiveHundred() {
		return jointStPolOfInsLessThanFiveHundred;
	}

	public void setJointStPolOfInsLessThanFiveHundred(String jointStPolOfInsLessThanFiveHundred) {
		this.jointStPolOfInsLessThanFiveHundred = jointStPolOfInsLessThanFiveHundred;
	}

	public String getJointStPolOfInsLessThanOneThousand() {
		return jointStPolOfInsLessThanOneThousand;
	}

	public void setJointStPolOfInsLessThanOneThousand(String jointStPolOfInsLessThanOneThousand) {
		this.jointStPolOfInsLessThanOneThousand = jointStPolOfInsLessThanOneThousand;
	}

	public String getJointStPolOfInsReIns() {
		return jointStPolOfInsReIns;
	}

	public void setJointStPolOfInsReIns(String jointStPolOfInsReIns) {
		this.jointStPolOfInsReIns = jointStPolOfInsReIns;
	}

	public String getJointStPwrOfAttorneySpecial() {
		return jointStPwrOfAttorneySpecial;
	}

	public void setJointStPwrOfAttorneySpecial(String jointStPwrOfAttorneySpecial) {
		this.jointStPwrOfAttorneySpecial = jointStPwrOfAttorneySpecial;
	}

	public String getJointStPwrOfAttorneyGeneral() {
		return jointStPwrOfAttorneyGeneral;
	}

	public void setJointStPwrOfAttorneyGeneral(String jointStPwrOfAttorneyGeneral) {
		this.jointStPwrOfAttorneyGeneral = jointStPwrOfAttorneyGeneral;
	}

	public String getJointStPromissoryNoteLessThanOneThousand() {
		return jointStPromissoryNoteLessThanOneThousand;
	}

	public void setJointStPromissoryNoteLessThanOneThousand(String jointStPromissoryNoteLessThanOneThousand) {
		this.jointStPromissoryNoteLessThanOneThousand = jointStPromissoryNoteLessThanOneThousand;
	}

	public String getJointStPromissoryNoteOtCases() {
		return jointStPromissoryNoteOtCases;
	}

	public void setJointStPromissoryNoteOtCases(String jointStPromissoryNoteOtCases) {
		this.jointStPromissoryNoteOtCases = jointStPromissoryNoteOtCases;
	}

	public String getJointStPromissoryNoteDemand() {
		return jointStPromissoryNoteDemand;
	}

	public void setJointStPromissoryNoteDemand(String jointStPromissoryNoteDemand) {
		this.jointStPromissoryNoteDemand = jointStPromissoryNoteDemand;
	}

	public String getJointStProtestOfBillOrNote() {
		return jointStProtestOfBillOrNote;
	}

	public void setJointStProtestOfBillOrNote(String jointStProtestOfBillOrNote) {
		this.jointStProtestOfBillOrNote = jointStProtestOfBillOrNote;
	}

	public String getJointStProtestByTheMasterOfShip() {
		return jointStProtestByTheMasterOfShip;
	}

	public void setJointStProtestByTheMasterOfShip(String jointStProtestByTheMasterOfShip) {
		this.jointStProtestByTheMasterOfShip = jointStProtestByTheMasterOfShip;
	}

	public String getJointStProxy() {
		return jointStProxy;
	}

	public void setJointStProxy(String jointStProxy) {
		this.jointStProxy = jointStProxy;
	}

	public String getJointStReceipt() {
		return jointStReceipt;
	}

	public void setJointStReceipt(String jointStReceipt) {
		this.jointStReceipt = jointStReceipt;
	}

	public String getJointStReconveyanceLessThanOneThousand() {
		return jointStReconveyanceLessThanOneThousand;
	}

	public void setJointStReconveyanceLessThanOneThousand(String jointStReconveyanceLessThanOneThousand) {
		this.jointStReconveyanceLessThanOneThousand = jointStReconveyanceLessThanOneThousand;
	}

	public String getJointStReconveyanceOts() {
		return jointStReconveyanceOts;
	}

	public void setJointStReconveyanceOts(String jointStReconveyanceOts) {
		this.jointStReconveyanceOts = jointStReconveyanceOts;
	}

	public String getJointStReleaseRelinquishmentOfRightLessThanOneThousand() {
		return jointStReleaseRelinquishmentOfRightLessThanOneThousand;
	}

	public void setJointStReleaseRelinquishmentOfRightLessThanOneThousand(
			String jointStReleaseRelinquishmentOfRightLessThanOneThousand) {
		this.jointStReleaseRelinquishmentOfRightLessThanOneThousand = jointStReleaseRelinquishmentOfRightLessThanOneThousand;
	}

	public String getJointStReleaseRelinquishmentOfRightOts() {
		return jointStReleaseRelinquishmentOfRightOts;
	}

	public void setJointStReleaseRelinquishmentOfRightOts(String jointStReleaseRelinquishmentOfRightOts) {
		this.jointStReleaseRelinquishmentOfRightOts = jointStReleaseRelinquishmentOfRightOts;
	}

	public String getJointStRespondentiaBond() {
		return jointStRespondentiaBond;
	}

	public void setJointStRespondentiaBond(String jointStRespondentiaBond) {
		this.jointStRespondentiaBond = jointStRespondentiaBond;
	}

	public String getJointStSecurityBond() {
		return jointStSecurityBond;
	}

	public void setJointStSecurityBond(String jointStSecurityBond) {
		this.jointStSecurityBond = jointStSecurityBond;
	}

	public String getJointStSettlementInstrument() {
		return jointStSettlementInstrument;
	}

	public void setJointStSettlementInstrument(String jointStSettlementInstrument) {
		this.jointStSettlementInstrument = jointStSettlementInstrument;
	}

	public String getJointStShareWarrents() {
		return jointStShareWarrents;
	}

	public void setJointStShareWarrents(String jointStShareWarrents) {
		this.jointStShareWarrents = jointStShareWarrents;
	}

	public String getJointStShippingOrder() {
		return jointStShippingOrder;
	}

	public void setJointStShippingOrder(String jointStShippingOrder) {
		this.jointStShippingOrder = jointStShippingOrder;
	}

	public String getJointStSurrenderOfLeaseNotExceesTen() {
		return jointStSurrenderOfLeaseNotExceesTen;
	}

	public void setJointStSurrenderOfLeaseNotExceesTen(String jointStSurrenderOfLeaseNotExceesTen) {
		this.jointStSurrenderOfLeaseNotExceesTen = jointStSurrenderOfLeaseNotExceesTen;
	}

	public String getJointStSurrenderOfLeaseOts() {
		return jointStSurrenderOfLeaseOts;
	}

	public void setJointStSurrenderOfLeaseOts(String jointStSurrenderOfLeaseOts) {
		this.jointStSurrenderOfLeaseOts = jointStSurrenderOfLeaseOts;
	}

	public String getJointStTransferOfShares() {
		return jointStTransferOfShares;
	}

	public void setJointStTransferOfShares(String jointStTransferOfShares) {
		this.jointStTransferOfShares = jointStTransferOfShares;
	}

	public String getJointStTransferOfDebentures() {
		return jointStTransferOfDebentures;
	}

	public void setJointStTransferOfDebentures(String jointStTransferOfDebentures) {
		this.jointStTransferOfDebentures = jointStTransferOfDebentures;
	}

	public String getJointStTransferSecuredBond() {
		return jointStTransferSecuredBond;
	}

	public void setJointStTransferSecuredBond(String jointStTransferSecuredBond) {
		this.jointStTransferSecuredBond = jointStTransferSecuredBond;
	}

	public String getJointStTransferMorgageDeed() {
		return jointStTransferMorgageDeed;
	}

	public void setJointStTransferMorgageDeed(String jointStTransferMorgageDeed) {
		this.jointStTransferMorgageDeed = jointStTransferMorgageDeed;
	}

	public String getJointStTransferOts() {
		return jointStTransferOts;
	}

	public void setJointStTransferOts(String jointStTransferOts) {
		this.jointStTransferOts = jointStTransferOts;
	}

	public String getJointStTransferAdministratorGeneral() {
		return jointStTransferAdministratorGeneral;
	}

	public void setJointStTransferAdministratorGeneral(String jointStTransferAdministratorGeneral) {
		this.jointStTransferAdministratorGeneral = jointStTransferAdministratorGeneral;
	}

	public String getJointStTransferTrustProperty() {
		return jointStTransferTrustProperty;
	}

	public void setJointStTransferTrustProperty(String jointStTransferTrustProperty) {
		this.jointStTransferTrustProperty = jointStTransferTrustProperty;
	}

	public String getJointStTransferofLease() {
		return jointStTransferofLease;
	}

	public void setJointStTransferofLease(String jointStTransferofLease) {
		this.jointStTransferofLease = jointStTransferofLease;
	}

	public String getJointStTrustBeingWill() {
		return jointStTrustBeingWill;
	}

	public void setJointStTrustBeingWill(String jointStTrustBeingWill) {
		this.jointStTrustBeingWill = jointStTrustBeingWill;
	}

	public String getJointStTrustNotBeingWill() {
		return jointStTrustNotBeingWill;
	}

	public void setJointStTrustNotBeingWill(String jointStTrustNotBeingWill) {
		this.jointStTrustNotBeingWill = jointStTrustNotBeingWill;
	}

	public String getJointStWarrentGoods() {
		return jointStWarrentGoods;
	}

	public void setJointStWarrentGoods(String jointStWarrentGoods) {
		this.jointStWarrentGoods = jointStWarrentGoods;
	}

	public String getJointRegisAcknowledgement() {
		return jointRegisAcknowledgement;
	}

	public void setJointRegisAcknowledgement(String jointRegisAcknowledgement) {
		this.jointRegisAcknowledgement = jointRegisAcknowledgement;
	}

	public String getJointRegisAdministrativeBond() {
		return jointRegisAdministrativeBond;
	}

	public void setJointRegisAdministrativeBond(String jointRegisAdministrativeBond) {
		this.jointRegisAdministrativeBond = jointRegisAdministrativeBond;
	}

	public String getJointRegisAdoptionDeed() {
		return jointRegisAdoptionDeed;
	}

	public void setJointRegisAdoptionDeed(String jointRegisAdoptionDeed) {
		this.jointRegisAdoptionDeed = jointRegisAdoptionDeed;
	}

	public String getJointRegisAffidavitIncAffOfDeclaration() {
		return jointRegisAffidavitIncAffOfDeclaration;
	}

	public void setJointRegisAffidavitIncAffOfDeclaration(String jointRegisAffidavitIncAffOfDeclaration) {
		this.jointRegisAffidavitIncAffOfDeclaration = jointRegisAffidavitIncAffOfDeclaration;
	}

	public String getJointRegisAgreementOfConveyance() {
		return jointRegisAgreementOfConveyance;
	}

	public void setJointRegisAgreementOfConveyance(String jointRegisAgreementOfConveyance) {
		this.jointRegisAgreementOfConveyance = jointRegisAgreementOfConveyance;
	}

	public String getJointRegisAgreementDevelopment() {
		return jointRegisAgreementDevelopment;
	}

	public void setJointRegisAgreementDevelopment(String jointRegisAgreementDevelopment) {
		this.jointRegisAgreementDevelopment = jointRegisAgreementDevelopment;
	}

	public String getJointRegisAgreementOts() {
		return jointRegisAgreementOts;
	}

	public void setJointRegisAgreementOts(String jointRegisAgreementOts) {
		this.jointRegisAgreementOts = jointRegisAgreementOts;
	}

	public String getJointRegisAgreeRelatDawnOrPledgeExceedLessThanOneThousand() {
		return jointRegisAgreeRelatDawnOrPledgeExceedLessThanOneThousand;
	}

	public void setJointRegisAgreeRelatDawnOrPledgeExceedLessThanOneThousand(
			String jointRegisAgreeRelatDawnOrPledgeExceedLessThanOneThousand) {
		this.jointRegisAgreeRelatDawnOrPledgeExceedLessThanOneThousand = jointRegisAgreeRelatDawnOrPledgeExceedLessThanOneThousand;
	}

	public String getJointRegisAgreeRelatDawnOrPledgeExceedLessThanTenThousand() {
		return jointRegisAgreeRelatDawnOrPledgeExceedLessThanTenThousand;
	}

	public void setJointRegisAgreeRelatDawnOrPledgeExceedLessThanTenThousand(
			String jointRegisAgreeRelatDawnOrPledgeExceedLessThanTenThousand) {
		this.jointRegisAgreeRelatDawnOrPledgeExceedLessThanTenThousand = jointRegisAgreeRelatDawnOrPledgeExceedLessThanTenThousand;
	}

	public String getJointRegisAgreeRelatDawnOrPledgeExceedMoreThanTenThousand() {
		return jointRegisAgreeRelatDawnOrPledgeExceedMoreThanTenThousand;
	}

	public void setJointRegisAgreeRelatDawnOrPledgeExceedMoreThanTenThousand(
			String jointRegisAgreeRelatDawnOrPledgeExceedMoreThanTenThousand) {
		this.jointRegisAgreeRelatDawnOrPledgeExceedMoreThanTenThousand = jointRegisAgreeRelatDawnOrPledgeExceedMoreThanTenThousand;
	}

	public String getJointRegisAgreeRelatDawnOrPledgeThreeMonths() {
		return jointRegisAgreeRelatDawnOrPledgeThreeMonths;
	}

	public void setJointRegisAgreeRelatDawnOrPledgeThreeMonths(String jointRegisAgreeRelatDawnOrPledgeThreeMonths) {
		this.jointRegisAgreeRelatDawnOrPledgeThreeMonths = jointRegisAgreeRelatDawnOrPledgeThreeMonths;
	}

	public String getJointRegisAppointmentInExecutionOfPwr() {
		return jointRegisAppointmentInExecutionOfPwr;
	}

	public void setJointRegisAppointmentInExecutionOfPwr(String jointRegisAppointmentInExecutionOfPwr) {
		this.jointRegisAppointmentInExecutionOfPwr = jointRegisAppointmentInExecutionOfPwr;
	}

	public String getJointRegisAppOrValNotExceed() {
		return jointRegisAppOrValNotExceed;
	}

	public void setJointRegisAppOrValNotExceed(String jointRegisAppOrValNotExceed) {
		this.jointRegisAppOrValNotExceed = jointRegisAppOrValNotExceed;
	}

	public String getJointRegisAppOrValOtCase() {
		return jointRegisAppOrValOtCase;
	}

	public void setJointRegisAppOrValOtCase(String jointRegisAppOrValOtCase) {
		this.jointRegisAppOrValOtCase = jointRegisAppOrValOtCase;
	}

	public String getJointRegisApprenticeshipDeed() {
		return jointRegisApprenticeshipDeed;
	}

	public void setJointRegisApprenticeshipDeed(String jointRegisApprenticeshipDeed) {
		this.jointRegisApprenticeshipDeed = jointRegisApprenticeshipDeed;
	}

	public String getJointRegisArtsOfAssoOfCompanyNotExceed() {
		return jointRegisArtsOfAssoOfCompanyNotExceed;
	}

	public void setJointRegisArtsOfAssoOfCompanyNotExceed(String jointRegisArtsOfAssoOfCompanyNotExceed) {
		this.jointRegisArtsOfAssoOfCompanyNotExceed = jointRegisArtsOfAssoOfCompanyNotExceed;
	}

	public String getJointRegisArtsOfAssoOfCompanyAbove() {
		return jointRegisArtsOfAssoOfCompanyAbove;
	}

	public void setJointRegisArtsOfAssoOfCompanyAbove(String jointRegisArtsOfAssoOfCompanyAbove) {
		this.jointRegisArtsOfAssoOfCompanyAbove = jointRegisArtsOfAssoOfCompanyAbove;
	}

	public String getJointRegisArtsOfClerkship() {
		return jointRegisArtsOfClerkship;
	}

	public void setJointRegisArtsOfClerkship(String jointRegisArtsOfClerkship) {
		this.jointRegisArtsOfClerkship = jointRegisArtsOfClerkship;
	}

	public String getJointRegisAwardNotExceed() {
		return jointRegisAwardNotExceed;
	}

	public void setJointRegisAwardNotExceed(String jointRegisAwardNotExceed) {
		this.jointRegisAwardNotExceed = jointRegisAwardNotExceed;
	}

	public String getJointRegisAwardExceed() {
		return jointRegisAwardExceed;
	}

	public void setJointRegisAwardExceed(String jointRegisAwardExceed) {
		this.jointRegisAwardExceed = jointRegisAwardExceed;
	}

	public String getJointRegisBillOfExchangeWherePayableOtwise() {
		return jointRegisBillOfExchangeWherePayableOtwise;
	}

	public void setJointRegisBillOfExchangeWherePayableOtwise(String jointRegisBillOfExchangeWherePayableOtwise) {
		this.jointRegisBillOfExchangeWherePayableOtwise = jointRegisBillOfExchangeWherePayableOtwise;
	}

	public String getJointRegisBillOfLading() {
		return jointRegisBillOfLading;
	}

	public void setJointRegisBillOfLading(String jointRegisBillOfLading) {
		this.jointRegisBillOfLading = jointRegisBillOfLading;
	}

	public String getJointRegisBond() {
		return jointRegisBond;
	}

	public void setJointRegisBond(String jointRegisBond) {
		this.jointRegisBond = jointRegisBond;
	}

	public String getJointRegisBottomryBond() {
		return jointRegisBottomryBond;
	}

	public void setJointRegisBottomryBond(String jointRegisBottomryBond) {
		this.jointRegisBottomryBond = jointRegisBottomryBond;
	}

	public String getJointRegisCancellation() {
		return jointRegisCancellation;
	}

	public void setJointRegisCancellation(String jointRegisCancellation) {
		this.jointRegisCancellation = jointRegisCancellation;
	}

	public String getJointRegisCertificateOfSale() {
		return jointRegisCertificateOfSale;
	}

	public void setJointRegisCertificateOfSale(String jointRegisCertificateOfSale) {
		this.jointRegisCertificateOfSale = jointRegisCertificateOfSale;
	}

	public String getJointRegisCertificateOrOtDocument() {
		return jointRegisCertificateOrOtDocument;
	}

	public void setJointRegisCertificateOrOtDocument(String jointRegisCertificateOrOtDocument) {
		this.jointRegisCertificateOrOtDocument = jointRegisCertificateOrOtDocument;
	}

	public String getJointRegisCharterParty() {
		return jointRegisCharterParty;
	}

	public void setJointRegisCharterParty(String jointRegisCharterParty) {
		this.jointRegisCharterParty = jointRegisCharterParty;
	}

	public String getJointRegisCompositionDeed() {
		return jointRegisCompositionDeed;
	}

	public void setJointRegisCompositionDeed(String jointRegisCompositionDeed) {
		this.jointRegisCompositionDeed = jointRegisCompositionDeed;
	}

	public String getJointRegisSaleConveyance() {
		return jointRegisSaleConveyance;
	}

	public void setJointRegisSaleConveyance(String jointRegisSaleConveyance) {
		this.jointRegisSaleConveyance = jointRegisSaleConveyance;
	}

	public String getJointRegisCertifiedCopy() {
		return jointRegisCertifiedCopy;
	}

	public void setJointRegisCertifiedCopy(String jointRegisCertifiedCopy) {
		this.jointRegisCertifiedCopy = jointRegisCertifiedCopy;
	}

	public String getJointRegisCounterpartOrDuplicateOfAnyInstrument() {
		return jointRegisCounterpartOrDuplicateOfAnyInstrument;
	}

	public void setJointRegisCounterpartOrDuplicateOfAnyInstrument(String jointRegisCounterpartOrDuplicateOfAnyInstrument) {
		this.jointRegisCounterpartOrDuplicateOfAnyInstrument = jointRegisCounterpartOrDuplicateOfAnyInstrument;
	}

	public String getJointRegisCustomsBondNotExceed() {
		return jointRegisCustomsBondNotExceed;
	}

	public void setJointRegisCustomsBondNotExceed(String jointRegisCustomsBondNotExceed) {
		this.jointRegisCustomsBondNotExceed = jointRegisCustomsBondNotExceed;
	}

	public String getJointRegisCustomsBondOtCase() {
		return jointRegisCustomsBondOtCase;
	}

	public void setJointRegisCustomsBondOtCase(String jointRegisCustomsBondOtCase) {
		this.jointRegisCustomsBondOtCase = jointRegisCustomsBondOtCase;
	}

	public String getJointRegisDebenture() {
		return jointRegisDebenture;
	}

	public void setJointRegisDebenture(String jointRegisDebenture) {
		this.jointRegisDebenture = jointRegisDebenture;
	}

	public String getJointRegisDebentureEndorsedNotExceed() {
		return jointRegisDebentureEndorsedNotExceed;
	}

	public void setJointRegisDebentureEndorsedNotExceed(String jointRegisDebentureEndorsedNotExceed) {
		this.jointRegisDebentureEndorsedNotExceed = jointRegisDebentureEndorsedNotExceed;
	}

	public String getJointRegisDebentureEndorsedExcess() {
		return jointRegisDebentureEndorsedExcess;
	}

	public void setJointRegisDebentureEndorsedExcess(String jointRegisDebentureEndorsedExcess) {
		this.jointRegisDebentureEndorsedExcess = jointRegisDebentureEndorsedExcess;
	}

	public String getJointRegisDebentureDeliveryNotExceed() {
		return jointRegisDebentureDeliveryNotExceed;
	}

	public void setJointRegisDebentureDeliveryNotExceed(String jointRegisDebentureDeliveryNotExceed) {
		this.jointRegisDebentureDeliveryNotExceed = jointRegisDebentureDeliveryNotExceed;
	}

	public String getJointRegisDebentureDeliveryExcess() {
		return jointRegisDebentureDeliveryExcess;
	}

	public void setJointRegisDebentureDeliveryExcess(String jointRegisDebentureDeliveryExcess) {
		this.jointRegisDebentureDeliveryExcess = jointRegisDebentureDeliveryExcess;
	}

	public String getJointRegisDeliveryOrderInRespectofGoods() {
		return jointRegisDeliveryOrderInRespectofGoods;
	}

	public void setJointRegisDeliveryOrderInRespectofGoods(String jointRegisDeliveryOrderInRespectofGoods) {
		this.jointRegisDeliveryOrderInRespectofGoods = jointRegisDeliveryOrderInRespectofGoods;
	}

	public String getJointRegisDivorceDeed() {
		return jointRegisDivorceDeed;
	}

	public void setJointRegisDivorceDeed(String jointRegisDivorceDeed) {
		this.jointRegisDivorceDeed = jointRegisDivorceDeed;
	}

	public String getJointRegisEntryAsAnAdvocateAdvocate() {
		return jointRegisEntryAsAnAdvocateAdvocate;
	}

	public void setJointRegisEntryAsAnAdvocateAdvocate(String jointRegisEntryAsAnAdvocateAdvocate) {
		this.jointRegisEntryAsAnAdvocateAdvocate = jointRegisEntryAsAnAdvocateAdvocate;
	}

	public String getJointRegisEntryAsAnAdvocateAttorney() {
		return jointRegisEntryAsAnAdvocateAttorney;
	}

	public void setJointRegisEntryAsAnAdvocateAttorney(String jointRegisEntryAsAnAdvocateAttorney) {
		this.jointRegisEntryAsAnAdvocateAttorney = jointRegisEntryAsAnAdvocateAttorney;
	}

	public String getJointRegisExchangeOfProperty() {
		return jointRegisExchangeOfProperty;
	}

	public void setJointRegisExchangeOfProperty(String jointRegisExchangeOfProperty) {
		this.jointRegisExchangeOfProperty = jointRegisExchangeOfProperty;
	}

	public String getJointRegisFutherChargeWithPossession() {
		return jointRegisFutherChargeWithPossession;
	}

	public void setJointRegisFutherChargeWithPossession(String jointRegisFutherChargeWithPossession) {
		this.jointRegisFutherChargeWithPossession = jointRegisFutherChargeWithPossession;
	}

	public String getJointRegisFutherChargeWithoutPossession() {
		return jointRegisFutherChargeWithoutPossession;
	}

	public void setJointRegisFutherChargeWithoutPossession(String jointRegisFutherChargeWithoutPossession) {
		this.jointRegisFutherChargeWithoutPossession = jointRegisFutherChargeWithoutPossession;
	}

	public String getJointRegisFutherChargtPossessionGiven() {
		return jointRegisFutherChargtPossessionGiven;
	}

	public void setJointRegisFutherChargtPossessionGiven(String jointRegisFutherChargtPossessionGiven) {
		this.jointRegisFutherChargtPossessionGiven = jointRegisFutherChargtPossessionGiven;
	}

	public String getJointRegisFutherChargePossessionNotGiven() {
		return jointRegisFutherChargePossessionNotGiven;
	}

	public void setJointRegisFutherChargePossessionNotGiven(String jointRegisFutherChargePossessionNotGiven) {
		this.jointRegisFutherChargePossessionNotGiven = jointRegisFutherChargePossessionNotGiven;
	}

	public String getJointRegisGiftDeed() {
		return jointRegisGiftDeed;
	}

	public void setJointRegisGiftDeed(String jointRegisGiftDeed) {
		this.jointRegisGiftDeed = jointRegisGiftDeed;
	}

	public String getJointRegisIndemnityBond() {
		return jointRegisIndemnityBond;
	}

	public void setJointRegisIndemnityBond(String jointRegisIndemnityBond) {
		this.jointRegisIndemnityBond = jointRegisIndemnityBond;
	}

	public String getJointRegisLeaseRentFixed() {
		return jointRegisLeaseRentFixed;
	}

	public void setJointRegisLeaseRentFixed(String jointRegisLeaseRentFixed) {
		this.jointRegisLeaseRentFixed = jointRegisLeaseRentFixed;
	}

	public String getJointRegisLeaseLessThanOneYear() {
		return jointRegisLeaseLessThanOneYear;
	}

	public void setJointRegisLeaseLessThanOneYear(String jointRegisLeaseLessThanOneYear) {
		this.jointRegisLeaseLessThanOneYear = jointRegisLeaseLessThanOneYear;
	}

	public String getJointRegisLeaseLessThanFiveYear() {
		return jointRegisLeaseLessThanFiveYear;
	}

	public void setJointRegisLeaseLessThanFiveYear(String jointRegisLeaseLessThanFiveYear) {
		this.jointRegisLeaseLessThanFiveYear = jointRegisLeaseLessThanFiveYear;
	}

	public String getJointRegisLeaseLessThanTenYear() {
		return jointRegisLeaseLessThanTenYear;
	}

	public void setJointRegisLeaseLessThanTenYear(String jointRegisLeaseLessThanTenYear) {
		this.jointRegisLeaseLessThanTenYear = jointRegisLeaseLessThanTenYear;
	}

	public String getJointRegisLeaseLessThanTwentyYear() {
		return jointRegisLeaseLessThanTwentyYear;
	}

	public void setJointRegisLeaseLessThanTwentyYear(String jointRegisLeaseLessThanTwentyYear) {
		this.jointRegisLeaseLessThanTwentyYear = jointRegisLeaseLessThanTwentyYear;
	}

	public String getJointRegisLeaseLessThanThirtyYear() {
		return jointRegisLeaseLessThanThirtyYear;
	}

	public void setJointRegisLeaseLessThanThirtyYear(String jointRegisLeaseLessThanThirtyYear) {
		this.jointRegisLeaseLessThanThirtyYear = jointRegisLeaseLessThanThirtyYear;
	}

	public String getJointRegisLeaseLessThanHundredYear() {
		return jointRegisLeaseLessThanHundredYear;
	}

	public void setJointRegisLeaseLessThanHundredYear(String jointRegisLeaseLessThanHundredYear) {
		this.jointRegisLeaseLessThanHundredYear = jointRegisLeaseLessThanHundredYear;
	}

	public String getJointRegisLeaseMoreThanHundredYear() {
		return jointRegisLeaseMoreThanHundredYear;
	}

	public void setJointRegisLeaseMoreThanHundredYear(String jointRegisLeaseMoreThanHundredYear) {
		this.jointRegisLeaseMoreThanHundredYear = jointRegisLeaseMoreThanHundredYear;
	}

	public String getJointRegisLeaseNotDefiniteTerm() {
		return jointRegisLeaseNotDefiniteTerm;
	}

	public void setJointRegisLeaseNotDefiniteTerm(String jointRegisLeaseNotDefiniteTerm) {
		this.jointRegisLeaseNotDefiniteTerm = jointRegisLeaseNotDefiniteTerm;
	}

	public String getJointRegisLeaseNoRentReserved() {
		return jointRegisLeaseNoRentReserved;
	}

	public void setJointRegisLeaseNoRentReserved(String jointRegisLeaseNoRentReserved) {
		this.jointRegisLeaseNoRentReserved = jointRegisLeaseNoRentReserved;
	}

	public String getJointRegisLeaseAdditionOnRentReserved() {
		return jointRegisLeaseAdditionOnRentReserved;
	}

	public void setJointRegisLeaseAdditionOnRentReserved(String jointRegisLeaseAdditionOnRentReserved) {
		this.jointRegisLeaseAdditionOnRentReserved = jointRegisLeaseAdditionOnRentReserved;
	}

	public String getJointRegisLeaseRevisionNotification() {
		return jointRegisLeaseRevisionNotification;
	}

	public void setJointRegisLeaseRevisionNotification(String jointRegisLeaseRevisionNotification) {
		this.jointRegisLeaseRevisionNotification = jointRegisLeaseRevisionNotification;
	}

	public String getJointRegisLetterOfAllotmentOfShares() {
		return jointRegisLetterOfAllotmentOfShares;
	}

	public void setJointRegisLetterOfAllotmentOfShares(String jointRegisLetterOfAllotmentOfShares) {
		this.jointRegisLetterOfAllotmentOfShares = jointRegisLetterOfAllotmentOfShares;
	}

	public String getJointRegisLetterOfCredit() {
		return jointRegisLetterOfCredit;
	}

	public void setJointRegisLetterOfCredit(String jointRegisLetterOfCredit) {
		this.jointRegisLetterOfCredit = jointRegisLetterOfCredit;
	}

	public String getJointRegisLetterOfLicence() {
		return jointRegisLetterOfLicence;
	}

	public void setJointRegisLetterOfLicence(String jointRegisLetterOfLicence) {
		this.jointRegisLetterOfLicence = jointRegisLetterOfLicence;
	}

	public String getJointRegisMemorandumOfAssoOfCompany() {
		return jointRegisMemorandumOfAssoOfCompany;
	}

	public void setJointRegisMemorandumOfAssoOfCompany(String jointRegisMemorandumOfAssoOfCompany) {
		this.jointRegisMemorandumOfAssoOfCompany = jointRegisMemorandumOfAssoOfCompany;
	}

	public String getJointRegisMortgageWithPossession() {
		return jointRegisMortgageWithPossession;
	}

	public void setJointRegisMortgageWithPossession(String jointRegisMortgageWithPossession) {
		this.jointRegisMortgageWithPossession = jointRegisMortgageWithPossession;
	}

	public String getJointRegisMortgageWithoutPossession() {
		return jointRegisMortgageWithoutPossession;
	}

	public void setJointRegisMortgageWithoutPossession(String jointRegisMortgageWithoutPossession) {
		this.jointRegisMortgageWithoutPossession = jointRegisMortgageWithoutPossession;
	}

	public String getJointRegisMortgageOfCropLessThanThree() {
		return jointRegisMortgageOfCropLessThanThree;
	}

	public void setJointRegisMortgageOfCropLessThanThree(String jointRegisMortgageOfCropLessThanThree) {
		this.jointRegisMortgageOfCropLessThanThree = jointRegisMortgageOfCropLessThanThree;
	}

	public String getJointRegisMortgageOfCropMoreThanThree() {
		return jointRegisMortgageOfCropMoreThanThree;
	}

	public void setJointRegisMortgageOfCropMoreThanThree(String jointRegisMortgageOfCropMoreThanThree) {
		this.jointRegisMortgageOfCropMoreThanThree = jointRegisMortgageOfCropMoreThanThree;
	}

	public String getJointRegisNotarialAct() {
		return jointRegisNotarialAct;
	}

	public void setJointRegisNotarialAct(String jointRegisNotarialAct) {
		this.jointRegisNotarialAct = jointRegisNotarialAct;
	}

	public String getJointRegisNoteOrMemorandum() {
		return jointRegisNoteOrMemorandum;
	}

	public void setJointRegisNoteOrMemorandum(String jointRegisNoteOrMemorandum) {
		this.jointRegisNoteOrMemorandum = jointRegisNoteOrMemorandum;
	}

	public String getJointRegisNoteOfProtestByTheMasterOfShip() {
		return jointRegisNoteOfProtestByTheMasterOfShip;
	}

	public void setJointRegisNoteOfProtestByTheMasterOfShip(String jointRegisNoteOfProtestByTheMasterOfShip) {
		this.jointRegisNoteOfProtestByTheMasterOfShip = jointRegisNoteOfProtestByTheMasterOfShip;
	}

	public String getJointRegisPartitionDeed() {
		return jointRegisPartitionDeed;
	}

	public void setJointRegisPartitionDeed(String jointRegisPartitionDeed) {
		this.jointRegisPartitionDeed = jointRegisPartitionDeed;
	}

	public String getJointRegisPartnerShip() {
		return jointRegisPartnerShip;
	}

	public void setJointRegisPartnerShip(String jointRegisPartnerShip) {
		this.jointRegisPartnerShip = jointRegisPartnerShip;
	}

	public String getJointRegisPartnerShipDissolution() {
		return jointRegisPartnerShipDissolution;
	}

	public void setJointRegisPartnerShipDissolution(String jointRegisPartnerShipDissolution) {
		this.jointRegisPartnerShipDissolution = jointRegisPartnerShipDissolution;
	}

	public String getJointRegisPolOfInsLessThanEighteen() {
		return jointRegisPolOfInsLessThanEighteen;
	}

	public void setJointRegisPolOfInsLessThanEighteen(String jointRegisPolOfInsLessThanEighteen) {
		this.jointRegisPolOfInsLessThanEighteen = jointRegisPolOfInsLessThanEighteen;
	}

	public String getJointRegisPolOfInsOneThousandFiveHundred() {
		return jointRegisPolOfInsOneThousandFiveHundred;
	}

	public void setJointRegisPolOfInsOneThousandFiveHundred(String jointRegisPolOfInsOneThousandFiveHundred) {
		this.jointRegisPolOfInsOneThousandFiveHundred = jointRegisPolOfInsOneThousandFiveHundred;
	}

	public String getJointRegisPolOfInsOneThousand() {
		return jointRegisPolOfInsOneThousand;
	}

	public void setJointRegisPolOfInsOneThousand(String jointRegisPolOfInsOneThousand) {
		this.jointRegisPolOfInsOneThousand = jointRegisPolOfInsOneThousand;
	}

	public String getJointRegisPolOfInsFireIns() {
		return jointRegisPolOfInsFireIns;
	}

	public void setJointRegisPolOfInsFireIns(String jointRegisPolOfInsFireIns) {
		this.jointRegisPolOfInsFireIns = jointRegisPolOfInsFireIns;
	}

	public String getJointRegisPolOfInsOts() {
		return jointRegisPolOfInsOts;
	}

	public void setJointRegisPolOfInsOts(String jointRegisPolOfInsOts) {
		this.jointRegisPolOfInsOts = jointRegisPolOfInsOts;
	}

	public String getJointRegisPolOfInsRenewalOriginalPol() {
		return jointRegisPolOfInsRenewalOriginalPol;
	}

	public void setJointRegisPolOfInsRenewalOriginalPol(String jointRegisPolOfInsRenewalOriginalPol) {
		this.jointRegisPolOfInsRenewalOriginalPol = jointRegisPolOfInsRenewalOriginalPol;
	}

	public String getJointRegisPolOfInsAccidental() {
		return jointRegisPolOfInsAccidental;
	}

	public void setJointRegisPolOfInsAccidental(String jointRegisPolOfInsAccidental) {
		this.jointRegisPolOfInsAccidental = jointRegisPolOfInsAccidental;
	}

	public String getJointRegisPolOfInsNotExceedOneThousand() {
		return jointRegisPolOfInsNotExceedOneThousand;
	}

	public void setJointRegisPolOfInsNotExceedOneThousand(String jointRegisPolOfInsNotExceedOneThousand) {
		this.jointRegisPolOfInsNotExceedOneThousand = jointRegisPolOfInsNotExceedOneThousand;
	}

	public String getJointRegisPolOfInsIndemnity() {
		return jointRegisPolOfInsIndemnity;
	}

	public void setJointRegisPolOfInsIndemnity(String jointRegisPolOfInsIndemnity) {
		this.jointRegisPolOfInsIndemnity = jointRegisPolOfInsIndemnity;
	}

	public String getJointRegisPolOfInsLifeIns() {
		return jointRegisPolOfInsLifeIns;
	}

	public void setJointRegisPolOfInsLifeIns(String jointRegisPolOfInsLifeIns) {
		this.jointRegisPolOfInsLifeIns = jointRegisPolOfInsLifeIns;
	}

	public String getJointRegisPolOfInsLessThanFiveHundred() {
		return jointRegisPolOfInsLessThanFiveHundred;
	}

	public void setJointRegisPolOfInsLessThanFiveHundred(String jointRegisPolOfInsLessThanFiveHundred) {
		this.jointRegisPolOfInsLessThanFiveHundred = jointRegisPolOfInsLessThanFiveHundred;
	}

	public String getJointRegisPolOfInsLessThanOneThousand() {
		return jointRegisPolOfInsLessThanOneThousand;
	}

	public void setJointRegisPolOfInsLessThanOneThousand(String jointRegisPolOfInsLessThanOneThousand) {
		this.jointRegisPolOfInsLessThanOneThousand = jointRegisPolOfInsLessThanOneThousand;
	}

	public String getJointRegisPolOfInsReIns() {
		return jointRegisPolOfInsReIns;
	}

	public void setJointRegisPolOfInsReIns(String jointRegisPolOfInsReIns) {
		this.jointRegisPolOfInsReIns = jointRegisPolOfInsReIns;
	}

	public String getJointRegisPwrOfAttorneySpecial() {
		return jointRegisPwrOfAttorneySpecial;
	}

	public void setJointRegisPwrOfAttorneySpecial(String jointRegisPwrOfAttorneySpecial) {
		this.jointRegisPwrOfAttorneySpecial = jointRegisPwrOfAttorneySpecial;
	}

	public String getJointRegisPwrOfAttorneyGeneral() {
		return jointRegisPwrOfAttorneyGeneral;
	}

	public void setJointRegisPwrOfAttorneyGeneral(String jointRegisPwrOfAttorneyGeneral) {
		this.jointRegisPwrOfAttorneyGeneral = jointRegisPwrOfAttorneyGeneral;
	}

	public String getJointRegisPromissoryNoteLessThanOneThousand() {
		return jointRegisPromissoryNoteLessThanOneThousand;
	}

	public void setJointRegisPromissoryNoteLessThanOneThousand(String jointRegisPromissoryNoteLessThanOneThousand) {
		this.jointRegisPromissoryNoteLessThanOneThousand = jointRegisPromissoryNoteLessThanOneThousand;
	}

	public String getJointRegisPromissoryNoteOtCases() {
		return jointRegisPromissoryNoteOtCases;
	}

	public void setJointRegisPromissoryNoteOtCases(String jointRegisPromissoryNoteOtCases) {
		this.jointRegisPromissoryNoteOtCases = jointRegisPromissoryNoteOtCases;
	}

	public String getJointRegisPromissoryNoteDemand() {
		return jointRegisPromissoryNoteDemand;
	}

	public void setJointRegisPromissoryNoteDemand(String jointRegisPromissoryNoteDemand) {
		this.jointRegisPromissoryNoteDemand = jointRegisPromissoryNoteDemand;
	}

	public String getJointRegisProtestOfBillOrNote() {
		return jointRegisProtestOfBillOrNote;
	}

	public void setJointRegisProtestOfBillOrNote(String jointRegisProtestOfBillOrNote) {
		this.jointRegisProtestOfBillOrNote = jointRegisProtestOfBillOrNote;
	}

	public String getJointRegisProtestByTheMasterOfShip() {
		return jointRegisProtestByTheMasterOfShip;
	}

	public void setJointRegisProtestByTheMasterOfShip(String jointRegisProtestByTheMasterOfShip) {
		this.jointRegisProtestByTheMasterOfShip = jointRegisProtestByTheMasterOfShip;
	}

	public String getJointRegisProxy() {
		return jointRegisProxy;
	}

	public void setJointRegisProxy(String jointRegisProxy) {
		this.jointRegisProxy = jointRegisProxy;
	}

	public String getJointRegisReceipt() {
		return jointRegisReceipt;
	}

	public void setJointRegisReceipt(String jointRegisReceipt) {
		this.jointRegisReceipt = jointRegisReceipt;
	}

	public String getJointRegisReconveyanceLessThanOneThousand() {
		return jointRegisReconveyanceLessThanOneThousand;
	}

	public void setJointRegisReconveyanceLessThanOneThousand(String jointRegisReconveyanceLessThanOneThousand) {
		this.jointRegisReconveyanceLessThanOneThousand = jointRegisReconveyanceLessThanOneThousand;
	}

	public String getJointRegisReconveyanceOts() {
		return jointRegisReconveyanceOts;
	}

	public void setJointRegisReconveyanceOts(String jointRegisReconveyanceOts) {
		this.jointRegisReconveyanceOts = jointRegisReconveyanceOts;
	}

	public String getJointRegisReleaseRelinquishmentOfRightLessThanOneThousand() {
		return jointRegisReleaseRelinquishmentOfRightLessThanOneThousand;
	}

	public void setJointRegisReleaseRelinquishmentOfRightLessThanOneThousand(
			String jointRegisReleaseRelinquishmentOfRightLessThanOneThousand) {
		this.jointRegisReleaseRelinquishmentOfRightLessThanOneThousand = jointRegisReleaseRelinquishmentOfRightLessThanOneThousand;
	}

	public String getJointRegisReleaseRelinquishmentOfRightOts() {
		return jointRegisReleaseRelinquishmentOfRightOts;
	}

	public void setJointRegisReleaseRelinquishmentOfRightOts(String jointRegisReleaseRelinquishmentOfRightOts) {
		this.jointRegisReleaseRelinquishmentOfRightOts = jointRegisReleaseRelinquishmentOfRightOts;
	}

	public String getJointRegisRespondentiaBond() {
		return jointRegisRespondentiaBond;
	}

	public void setJointRegisRespondentiaBond(String jointRegisRespondentiaBond) {
		this.jointRegisRespondentiaBond = jointRegisRespondentiaBond;
	}

	public String getJointRegisSecurityBond() {
		return jointRegisSecurityBond;
	}

	public void setJointRegisSecurityBond(String jointRegisSecurityBond) {
		this.jointRegisSecurityBond = jointRegisSecurityBond;
	}

	public String getJointRegisSettlementInstrument() {
		return jointRegisSettlementInstrument;
	}

	public void setJointRegisSettlementInstrument(String jointRegisSettlementInstrument) {
		this.jointRegisSettlementInstrument = jointRegisSettlementInstrument;
	}

	public String getJointRegisShareWarrents() {
		return jointRegisShareWarrents;
	}

	public void setJointRegisShareWarrents(String jointRegisShareWarrents) {
		this.jointRegisShareWarrents = jointRegisShareWarrents;
	}

	public String getJointRegisShippingOrder() {
		return jointRegisShippingOrder;
	}

	public void setJointRegisShippingOrder(String jointRegisShippingOrder) {
		this.jointRegisShippingOrder = jointRegisShippingOrder;
	}

	public String getJointRegisSurrenderOfLeaseNotExceesTen() {
		return jointRegisSurrenderOfLeaseNotExceesTen;
	}

	public void setJointRegisSurrenderOfLeaseNotExceesTen(String jointRegisSurrenderOfLeaseNotExceesTen) {
		this.jointRegisSurrenderOfLeaseNotExceesTen = jointRegisSurrenderOfLeaseNotExceesTen;
	}

	public String getJointRegisSurrenderOfLeaseOts() {
		return jointRegisSurrenderOfLeaseOts;
	}

	public void setJointRegisSurrenderOfLeaseOts(String jointRegisSurrenderOfLeaseOts) {
		this.jointRegisSurrenderOfLeaseOts = jointRegisSurrenderOfLeaseOts;
	}

	public String getJointRegisTransferOfShares() {
		return jointRegisTransferOfShares;
	}

	public void setJointRegisTransferOfShares(String jointRegisTransferOfShares) {
		this.jointRegisTransferOfShares = jointRegisTransferOfShares;
	}

	public String getJointRegisTransferOfDebentures() {
		return jointRegisTransferOfDebentures;
	}

	public void setJointRegisTransferOfDebentures(String jointRegisTransferOfDebentures) {
		this.jointRegisTransferOfDebentures = jointRegisTransferOfDebentures;
	}

	public String getJointRegisTransferSecuredBond() {
		return jointRegisTransferSecuredBond;
	}

	public void setJointRegisTransferSecuredBond(String jointRegisTransferSecuredBond) {
		this.jointRegisTransferSecuredBond = jointRegisTransferSecuredBond;
	}

	public String getJointRegisTransferMorgageDeed() {
		return jointRegisTransferMorgageDeed;
	}

	public void setJointRegisTransferMorgageDeed(String jointRegisTransferMorgageDeed) {
		this.jointRegisTransferMorgageDeed = jointRegisTransferMorgageDeed;
	}

	public String getJointRegisTransferOts() {
		return jointRegisTransferOts;
	}

	public void setJointRegisTransferOts(String jointRegisTransferOts) {
		this.jointRegisTransferOts = jointRegisTransferOts;
	}

	public String getJointRegisTransferAdministratorGeneral() {
		return jointRegisTransferAdministratorGeneral;
	}

	public void setJointRegisTransferAdministratorGeneral(String jointRegisTransferAdministratorGeneral) {
		this.jointRegisTransferAdministratorGeneral = jointRegisTransferAdministratorGeneral;
	}

	public String getJointRegisTransferTrustProperty() {
		return jointRegisTransferTrustProperty;
	}

	public void setJointRegisTransferTrustProperty(String jointRegisTransferTrustProperty) {
		this.jointRegisTransferTrustProperty = jointRegisTransferTrustProperty;
	}

	public String getJointRegisTransferofLease() {
		return jointRegisTransferofLease;
	}

	public void setJointRegisTransferofLease(String jointRegisTransferofLease) {
		this.jointRegisTransferofLease = jointRegisTransferofLease;
	}

	public String getJointRegisTrustBeingWill() {
		return jointRegisTrustBeingWill;
	}

	public void setJointRegisTrustBeingWill(String jointRegisTrustBeingWill) {
		this.jointRegisTrustBeingWill = jointRegisTrustBeingWill;
	}

	public String getJointRegisTrustNotBeingWill() {
		return jointRegisTrustNotBeingWill;
	}

	public void setJointRegisTrustNotBeingWill(String jointRegisTrustNotBeingWill) {
		this.jointRegisTrustNotBeingWill = jointRegisTrustNotBeingWill;
	}

	public String getJointRegisWarrentGoods() {
		return jointRegisWarrentGoods;
	}

	public void setJointRegisWarrentGoods(String jointRegisWarrentGoods) {
		this.jointRegisWarrentGoods = jointRegisWarrentGoods;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}


