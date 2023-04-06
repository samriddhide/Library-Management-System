import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  title = "Student Management"
  students: any = []
  //students = [{ "id": 1, "name": "Anushka Gupta", "department": "CSE", "rollnumber": 12, "birthdate": "24-jan-2002", "mobilenumber": "9834672837" }]
  isGreen=true
  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllStudents()
  }

  addStudent() {
    console.log("addstudent button works!")
    this.router.navigateByUrl('/add-student') //takes user to add-student url
  }

  fetchAllStudents() {
    this.http.get("http://localhost:8080/student/getAll")
      .subscribe(resp => {
        this.students = resp;
        console.log('Students retrieved successfully:', this.students)
      }, error => {
        console.error('Error retrieving students:', error);
      });
  }

  deleteStudent(studentId: Number) {

    const url = 'http://localhost:8080/student/delete/' + studentId
    console.log(url)
    this.http.delete(url)
      .subscribe(resp => {
        console.log('Students deleted successfully');
        this.fetchAllStudents()
      }, error => {
        console.error('Error deleting Students:', error);
      });
  }

  updateStudent(id: Number) {
    this.router.navigate(['/update-student', id])
  }

}
