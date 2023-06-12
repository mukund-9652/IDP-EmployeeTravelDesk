 export class TravelRequestsDTO{ 
    requestId!: number;
	raisedByEmployeeId!: number;
	toBeApprovedByHRId!: number;
	requestRaisedOn!: Date;
	fromDate!: Date;
	toDate!: Date;
	purposeOfTravel!: string;
	locations!: string;
	requestStatus!: string;
	requestApprovedOn!: Date;
	priority!: string;
 }