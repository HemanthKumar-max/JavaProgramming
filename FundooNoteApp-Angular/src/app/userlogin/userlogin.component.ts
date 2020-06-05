import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService, AlertService } from '../_services';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-userlogin',
  templateUrl: './userlogin.component.html',
  styleUrls: ['./userlogin.component.css']
})
export class UserloginComponent implements OnInit {

  UserloginForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;
  error = '';


  constructor(
      private formBuilder: FormBuilder,
      private route: ActivatedRoute,
      private router: Router,
      private alertService: AlertService,
      private userService: UserService) {}

  ngOnInit() {
      this.UserloginForm = this.formBuilder.group({
          email: ['', Validators.required],
          password: ['', Validators.required]
      });


      // get return url from route parameters or default to '/'
      this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  // convenience getter for easy access to form fields
  get f() { return this.UserloginForm.controls; }

  onSubmit() {
      this.submitted = true;

      // stop here if form is invalid
      if (this.UserloginForm.invalid) {
          return;
      }

      this.loading = true;
      this.userService.loginUser(this.UserloginForm.value)
      .subscribe(login => {
      console.log(login);
      this.alertService.success('login successful', true);
      this.router.navigate(['/app-all-registered-users']);
        },
              error => {
                  this.error = error;
                  this.loading = false;
              });
          }
      }
  