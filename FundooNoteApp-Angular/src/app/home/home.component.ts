import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';


import { AuthenticationService } from '../_services';
import { UserLogin } from '../login/userlogin';

@Component({selector: 'home',
    templateUrl: 'home.component.html'})
export class HomeComponent implements OnInit {
     currentUser: UserLogin;
     users: UserLogin[] = [];
   
     constructor(private authService: AuthenticationService) {
         this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    }

    
    ngOnInit() {
    //     this.loadAllUsers();
     }

    // deleteUser(id: number) {
    //     this.userService.delete(id).pipe(first()).subscribe(() => { 
    //         this.loadAllUsers() 
    //     });
    // }

    // private loadAllUsers() {
    //     this.userService.getAll().pipe(first()).subscribe(users => { 
    //         this.users = users; 
    //     });
    // }
}