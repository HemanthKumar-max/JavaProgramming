import { Component, OnInit } from '@angular/core';
import { UserService, AlertService } from '../_services';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-resetpassword',
  templateUrl: './resetpassword.component.html',
  styleUrls: ['./resetpassword.component.css']
})
export class ResetpasswordComponent implements OnInit {

  ResetPasswordForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;
  error = '';

  userId:number;
  
  


  constructor( private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private alertService: AlertService,
    private userservice: UserService) { }


  ngOnInit() {
    this.ResetPasswordForm = this.formBuilder.group(
      {
        email: ['', [Validators.required]],
        password: ['', [Validators.required, Validators.minLength(8)]],
        //confirmpassword: ['', [Validators.required, Validators.minLength(8)]]
      }
    );
    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }
  
 
  





  

  Validate(passwordFormGroup: FormGroup) {
    const password = passwordFormGroup.controls.password.value;
    const confirmpassword = passwordFormGroup.controls.confirmpassword.value;

    if (confirmpassword.length <= 0) {
      return null;
    }

    if (confirmpassword !== password) {
      return {
        doesNotMatch: true
      };
    }

    return null;
  }















  get f() { return this.ResetPasswordForm.controls; }

  onSubmit() {
      this.submitted = true;

      // stop here if form is invalid
      if (this.ResetPasswordForm.invalid) {
          return;
      }


      this.loading = true;
      this.userservice.resetpassword(this.ResetPasswordForm.value)
      .pipe(first())
      .subscribe(
          data => {
              this.alertService.success('password successfully resetted', true);
              this.router.navigate(['/home']);
          },
          error => {
              this.alertService.error(error);
              this.loading = false;
          });
      }
    }