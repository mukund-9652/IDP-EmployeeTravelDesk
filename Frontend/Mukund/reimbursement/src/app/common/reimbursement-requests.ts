import { ReimbursementTypes } from "./reimbursement-types";

export class ReimbursementRequests {
    constructor(
        id: number,
        travelRequestId: number,
        requestRaisedByEmployeeId: number,
        requestDate: Date,
        reimbursementTypeId: ReimbursementTypes,
        invoiceNo: string,
        invoiceDate: Date,
        invoiceAmount: number,
        documentUrl: string,
        requestProcessedOn: Date,
        requestProcessedByEmployeeId: number,
        status: string,
        remarks: string
    ) { }
}