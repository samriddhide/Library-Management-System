import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms'
import { Router } from '@angular/router';


@Component({
  selector: 'app-update-admin',
  templateUrl: './update-admin.component.html',
  styleUrls: ['./update-admin.component.css']
})
export class UpdateAdminComponent implements OnInit {

  adminForm: FormGroup;

  constructor(private formbuilder: FormBuilder, private http: HttpClient, private router: Router) {
    this.adminForm = this.formbuilder.group({
      id: ['', Validators.required],
      name: ['', Validators.required],
      username: ['', Validators.required],
      password: ['', Validators.required]
    })
  }

  ngOnInit(): void {
  }


  newAdmin() {
    const adminData = this.adminForm.value;
    this.http.put('http://localhost:8080/admin/updateAdmin', adminData)
      .subscribe(response => {
        console.log('Admin saved to DB', response);
        this.router.navigateByUrl('/admin')
      }, error => {
        console.error("Error in admin save", error);
      }
      );

  }

}
