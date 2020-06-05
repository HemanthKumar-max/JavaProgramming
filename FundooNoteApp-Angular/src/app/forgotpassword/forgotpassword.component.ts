import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AlertService, UserService } from '../_services';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-forgotpassword',
  templateUrl: './forgotpassword.component.html',
  styleUrls: ['./forgotpassword.component.css']
})
export class ForgotpasswordComponent implements OnInit {

  forgotPasswordForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;
  error = '';



  constructor( private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private alertService: AlertService,
    private userService: UserService) { }

    ngOnInit() {
      this.forgotPasswordForm = this.formBuilder.group({
          email: ['', Validators.required],
        });


      // get return url from route parameters or default to '/'
      this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  // convenience getter for easy access to form fields
  get f() { return this.forgotPasswordForm.controls; }

  onSubmit() {
      this.submitted = true;

      // stop here if form is invalid
      if (this.forgotPasswordForm.invalid) {
          return;
      }

      this.loading = true;
      this.userService.forgotpassword(this.forgotPasswordForm.value)
      .pipe(first())
      .subscribe(
          data => {
              this.alertService.success('An email has sent to requested account!', true);
              this.router.navigate(['/home']);
          },
          error => {
              this.alertService.error(error);
              this.loading = false;
          });
      }
    }