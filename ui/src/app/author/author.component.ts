import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit {

  title="Authors Management"
  authors: any = []
  //authors = [{ "name": "F.Scott Fitzgerald", "birthDate": "24/09/1896", "nationality": "American" }, { "name": "Harper Lee", "birthDate": "28/04/1926", "nationality": "American" }]
  isGreen=true
  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllAuthors()
  }

  addAuthors() {
    console.log("addAuthors button works!")
    this.router.navigateByUrl('/add-authors') //takes user to add-authors url
  }

  fetchAllAuthors() {
    this.http.get("http://localhost:8080/author/getAll")
      .subscribe(resp => {
        this.authors = resp;
        console.log('Authors retrieved successfully:', this.authors)
      }, error => {
        console.error('Error retrieving authors:', error);
      });
  }

  deleteAuthor(authorId: Number) {

    const url = 'http://localhost:8080/author/delete/' + authorId
    console.log(url)
    this.http.delete(url)
      .subscribe(resp => {
        console.log('Author deleted successfully');
        this.fetchAllAuthors()
      }, error => {
        console.error('Error deleting author:', error);
      });
  }

  updateAuthor(id: Number) {
    this.router.navigate(['/update-author', id])
  }


}
