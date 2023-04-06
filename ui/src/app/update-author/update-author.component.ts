import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms'
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-author',
  templateUrl: './update-author.component.html',
  styleUrls: ['./update-author.component.css']
})
export class UpdateAuthorComponent implements OnInit {

  authorsForm: FormGroup;
  constructor(private formbuilder: FormBuilder, private http: HttpClient, private router: Router) {
    this.authorsForm = this.formbuilder.group({
      id:['',Validators.required],
      name: ['', Validators.required],
      birthDate: ['', Validators.required],
      nationality: ['', Validators.required],
    })
  }

  ngOnInit(): void {
  }

  newAuthor() {
    const authorData = this.authorsForm.value;
    this.http.put('http://localhost:8080/author/updateAuthor', authorData)
      .subscribe(response => {
        console.log('Author saved to DB', response);
        this.router.navigateByUrl('/authors')
      }, error => {
        console.error("Error in author save", error);
      }
      );

  }

}
