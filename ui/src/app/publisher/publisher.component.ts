import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-publisher',
  templateUrl: './publisher.component.html',
  styleUrls: ['./publisher.component.css']
})
export class PublisherComponent implements OnInit {

  title = "Publishers Management"
  publishers: any = []
  //publishers=[{"id":1,"name":"Penguin","address":"kolkata","phonenumber":"9876782677","email":"penguin@gmail.com"}]
  isGreen = true

  constructor(private router: Router, private http: HttpClient) { }


  ngOnInit(): void {
    this.fetchAllPublishers()
  }

  addPublisher() {
    console.log("addPublisher button works!")
    this.router.navigateByUrl('/add-publisher') //takes user to add-publisher url
  }

  fetchAllPublishers() {
    this.http.get("http://localhost:8080/publisher/getAll")
      .subscribe(resp => {
        this.publishers = resp;
        console.log('Publishers retrieved successfully:', this.publishers)
      }, error => {
        console.error('Error retrieving publishers:', error);
      });
  }

  deletePublisher(publisherId: Number) {

    const url = 'http://localhost:8080/publisher/delete/' + publisherId
    console.log(url)
    this.http.delete(url)
      .subscribe(resp => {
        console.log('Publisher deleted successfully');
        this.fetchAllPublishers()
      }, error => {
        console.error('Error deleting publisher:', error);
      });
  }

  updatePublisher(id: Number) {
    this.router.navigate(['/update-publisher', id])
  }


}
