import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import { AlertService, UserService } from '../_services';
import { User } from '../_models';

@Component({templateUrl: 'register.component.html'})
export class RegisterComponent implements OnInit {

  


    registerForm: FormGroup;
    loading = false;
    submitted = false;
    returnUrl: string;




    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private userService: UserService,
        private alertService: AlertService) { }

    ngOnInit() {
        this.registerForm = this.formBuilder.group({
            firstname: ['', Validators.required],
            lastname: ['', Validators.required],
            email: ['', [Validators.required,Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$")]],
            password: ['', [Validators.required, Validators.minLength(6),Validators.maxLength(12)]]
        });


         // get return url from route parameters or default to '/'
         this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }

    // convenience getter for easy access to form fields
    get f() { return this.registerForm.controls; }

    onSubmit() {
        this.submitted = true;
       // stop here if form is invalid
       console.log('Submitting');
       if (!this.registerForm.valid) {
         console.log('Form not valid. Please check that fields are correctly filled in');
         return;
       }
   



        this.loading = true;
        this.userService.register(this.registerForm.value)
        .subscribe(user => {
            console.log(user);
                    localStorage.setItem('user', JSON.stringify(user));
                    this.alertService.success('Registration successful', true);
                    this.router.navigate(['/home']);
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
    }
}
