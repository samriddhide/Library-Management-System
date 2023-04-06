import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  title = "Admin Management"
  admins: any = []
  //admins = [{ "id": 1, "name": "Samriddhi De", "username": "samriddhide", "password": 'A0803' }]
  isGreen = true
 
  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllAdmins()
  }

  addAdmin() {
    console.log("addAdmin button works!")
    this.router.navigateByUrl('/add-admin') //takes user to add-admin url
  }

  fetchAllAdmins() {
    this.http.get("http://localhost:8080/admin/getAll")
      .subscribe(resp => {
        this.admins = resp;
        console.log('Admins retrieved successfully:', this.admins)
      }, error => {
        console.error('Error retrieving admins:', error);
      });
  }

  deleteAdmin(adminId: Number) {

    const url = 'http://localhost:8080/admin/delete/' + adminId
    console.log(url)
    this.http.delete(url)
      .subscribe(resp => {
        console.log('Admin deleted successfully');
        this.fetchAllAdmins()
      }, error => {
        console.error('Error deleting admin:', error);
      });
  }

  updateAdmin(id: Number){
    this.router.navigate(['/update-admin', id])
  }


}
