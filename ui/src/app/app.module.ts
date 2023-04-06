import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookComponent } from './book/book.component';
import { StudentComponent } from './student/student.component';
import { AuthorComponent } from './author/author.component';
import { PublisherComponent } from './publisher/publisher.component';
import { AdminComponent } from './admin/admin.component';
import { LoanComponent } from './loan/loan.component';
import { SidenavComponent } from './sidenav/sidenav.component';
import { AddBooksComponent } from './add-books/add-books.component';
import { AddAuthorsComponent } from './add-authors/add-authors.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AddAdminComponent } from './add-admin/add-admin.component';
import { AddStudentComponent } from './add-student/add-student.component';
import { AddPublisherComponent } from './add-publisher/add-publisher.component';
import { AddLoanComponent } from './add-loan/add-loan.component';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { UpdateAdminComponent } from './update-admin/update-admin.component';
import { UpdateStudentComponent } from './update-student/update-student.component';
import { UpdateBookComponent } from './update-book/update-book.component';
import { UpdateAuthorComponent } from './update-author/update-author.component';
import { UpdatePublisherComponent } from './update-publisher/update-publisher.component';
import { UpdateLoanComponent } from './update-loan/update-loan.component';


@NgModule({
  declarations: [
    AppComponent,
    BookComponent,
    StudentComponent,
    AuthorComponent,
    PublisherComponent,
    AdminComponent,
    LoanComponent,
    SidenavComponent,
    AddBooksComponent,
    AddAuthorsComponent,
    AddAdminComponent,
    AddStudentComponent,
    AddPublisherComponent,
    AddLoanComponent,
    HomeComponent,
    UpdateAdminComponent,
    UpdateStudentComponent,
    UpdateBookComponent,
    UpdateAuthorComponent,
    UpdatePublisherComponent,
    UpdateLoanComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
