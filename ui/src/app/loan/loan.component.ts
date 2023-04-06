import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';



@Component({
  selector: 'app-loan',
  templateUrl: './loan.component.html',
  styleUrls: ['./loan.component.css']
})
export class LoanComponent implements OnInit {

  title = "Loan Management"
  loans: any = []
  //loans=[{"id":33,"bookid":12,"studentid":1,"checkoutdate":"12-Mar-2023","duedate":"18-Mar-2023","returndate":"16-Mar-2023"}]
  isGreen=true

  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllLoans()
  }

  addLoan() {
    console.log("addLoan button works!")
    this.router.navigateByUrl('/add-loan') //takes user to add-loan url
  }

  fetchAllLoans() {
    this.http.get("http://localhost:8080/loan/getAll")
      .subscribe(resp => {
        this.loans = resp;
        console.log('Loans retrieved successfully:', this.loans)
      }, error => {
        console.error('Error retrieving loans:', error);
      });
  }

  deleteLoan(loanId: Number) {

    const url = 'http://localhost:8080/loan/delete/' + loanId
    console.log(url)
    this.http.delete(url)
      .subscribe(resp => {
        console.log('Loan deleted successfully');
        this.fetchAllLoans()
      }, error => {
        console.error('Error deleting loan:', error);
      });
  }

  updateLoan(id: Number) {
    this.router.navigate(['/update-loan', id])
  }

}
