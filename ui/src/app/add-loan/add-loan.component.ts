import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms'
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-loan',
  templateUrl: './add-loan.component.html',
  styleUrls: ['./add-loan.component.css']
})
export class AddLoanComponent implements OnInit {

  loanForm: FormGroup;
  constructor(private formbuilder: FormBuilder, private http: HttpClient, private router: Router) {
    this.loanForm = this.formbuilder.group({
      //loanId: ['', Validators.required],
      bookId: ['', Validators.required],
      studentId: ['', Validators.required],
      checkoutDate: ['', Validators.required],
      returnDate: ['', Validators.required],
      dueDate: ['', Validators.required],
    })
  }


  ngOnInit(): void {
  }

  saveLoan() {
    const loanData = this.loanForm.value;
    this.http.post('http://localhost:8080/loan/saveloan', loanData)
      .subscribe(response => {
        console.log('Loan saved to DB', response)
        this.router.navigateByUrl('/loans')
      }, error => {
        console.error("Error in loan save", error)
      }
      );

  }
}
