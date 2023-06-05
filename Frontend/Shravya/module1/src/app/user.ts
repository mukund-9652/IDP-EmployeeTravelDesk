import { grade } from "./grade";

export class user{
    employeeId!: number;
    firstName!:string;
    lastName!:string;
    phoneNumber!:string;
    emailAddress!:string;
    roles!:string;
    currentGradeId!:grade;
    accessGranted!:boolean;
}