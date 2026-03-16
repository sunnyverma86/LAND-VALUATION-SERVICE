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
	
	
}