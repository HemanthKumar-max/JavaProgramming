import { Component, OnInit } from '@angular/core';
import { UserService} from '../_services';
import { first } from 'rxjs/operators';
@Component({
  selector: 'app-all-registered-users',
  templateUrl: './all-registered-users.component.html',
  styleUrls: ['./all-registered-users.component.css']
})
export class AllRegisteredUsersComponent implements OnInit {
  users:any;
  id:any;
  
  
  constructor(private userservice:UserService) { }

  ngOnInit() {
    this.loadAllUsers();
  }


private loadAllUsers() {
  this.userservice.getAllRegisters().pipe(first()).subscribe(users => { 
      this.users = users; 
  });
}

findUserById(id: number) {
  this.userservice.getById(this.id).pipe(first()).subscribe(() => { 
      this.loadAllUsers(); 
  });

  
}




deleteUser(id: number) {
  this.userservice.delete(id).pipe(first()).subscribe(() => { 
      this.loadAllUsers();
  });
}


}

