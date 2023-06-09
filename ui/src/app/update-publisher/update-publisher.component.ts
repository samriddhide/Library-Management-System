import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms'
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-publisher',
  templateUrl: './update-publisher.component.html',
  styleUrls: ['./update-publisher.component.css']
})
export class UpdatePublisherComponent implements OnInit {

  publisherForm: FormGroup;
  constructor(private formbuilder: FormBuilder, private http: HttpClient, private router: Router) {
    this.publisherForm = this.formbuilder.group({
      id: ['', Validators.required],
      name: ['', Validators.required],
      address: ['', Validators.required],
      phone: ['', Validators.required],
      email: ['', Validators.required],
    })
  }

  ngOnInit(): void {
  }


  newPublisher() {
    const publisherData = this.publisherForm.value;
    this.http.put('http://localhost:8080/publisher/updatePublisher', publisherData)
      .subscribe(response => {
        console.log('Publisher saved to DB', response);
        this.router.navigateByUrl('/publishers')
      }, error => {
        console.error("Error in publisher save", error);
      }
      );

  }
}
