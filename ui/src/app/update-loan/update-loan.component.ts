import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms'
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-loan',
  templateUrl: './update-loan.component.html',
  styleUrls: ['./update-loan.component.css']
})
export class UpdateLoanComponent implements OnInit {

  loanForm: FormGroup;
  constructor(private formbuilder: FormBuilder, private http: HttpClient, private router: Router) {
    this.loanForm = this.formbuilder.group({
      id: ['', Validators.required],
      bookId: ['', Validators.required],
      studentId: ['', Validators.required],
      checkoutDate: ['', Validators.required],
      returnDate: ['', Validators.required],
      dueDate: ['', Validators.required],
    })
  }


  ngOnInit(): void {
  }


  newLoan() {
    const loanData = this.loanForm.value;
    this.http.put('http://localhost:8080/loan/updateLoan', loanData)
      .subscribe(response => {
        console.log('Loan saved to DB', response);
        this.router.navigateByUrl('/loans')
      }, error => {
        console.error("Error in loan save", error);
      }
      );

  }

}
