import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddBooksComponent } from './add-books/add-books.component';
import { AddAuthorsComponent } from './add-authors/add-authors.component';
import { AddAdminComponent } from './add-admin/add-admin.component';
import { AddStudentComponent } from './add-student/add-student.component';
import { AddPublisherComponent } from './add-publisher/add-publisher.component';
import { AddLoanComponent } from './add-loan/add-loan.component';
import { AdminComponent } from './admin/admin.component';
import { AuthorComponent } from './author/author.component';
import { BookComponent } from './book/book.component';
import { LoanComponent } from './loan/loan.component';
import { HomeComponent } from './home/home.component';
import { PublisherComponent } from './publisher/publisher.component';
import { StudentComponent } from './student/student.component';
import { UpdateAdminComponent } from './update-admin/update-admin.component';
import { UpdateAuthorComponent } from './update-author/update-author.component';
import { UpdateBookComponent } from './update-book/update-book.component';
import { UpdateLoanComponent } from './update-loan/update-loan.component';
import { UpdatePublisherComponent } from './update-publisher/update-publisher.component';
import { UpdateStudentComponent } from './update-student/update-student.component';


const routes: Routes = [
  {
    path:"books",
    component:BookComponent,
  },{
    path:"students",
    component:StudentComponent,
  },{
    path:"authors",
    component:AuthorComponent,
  }, {
    path: "publishers",
    component: PublisherComponent,
  }, {
    path: "admin",
    component: AdminComponent,
  },
  {
    path: "loans",
    component: LoanComponent,
  },
  {
    path: "add-Books",
    component: AddBooksComponent,
  }, 
  {
    path: "add-authors",
    component: AddAuthorsComponent,
  },
  {
    path: "add-admin",
    component: AddAdminComponent, 
  },
  {
    path: "add-student", 
    component: AddStudentComponent,
  },
  {
    path: "add-publisher",
    component: AddPublisherComponent, 
  },
  {
    path: "add-loan",
    component: AddLoanComponent,
  },
  {
    path: "",
    component: HomeComponent,
  },
  {
    path: "update-admin/:id",
    component: UpdateAdminComponent,
  },
  {
    path: "update-author/:id",
    component: UpdateAuthorComponent,
  },
  {
    path: "update-book/:id",
    component: UpdateBookComponent,
  },
  {
    path: "update-loan/:id",
    component: UpdateLoanComponent,
  },
  {
    path: "update-publisher/:id",
    component: UpdatePublisherComponent,
  },
  {
    path: "update-student/:id",
    component: UpdateStudentComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
