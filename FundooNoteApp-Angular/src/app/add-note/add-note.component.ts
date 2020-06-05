import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AlertService, UserService } from '../_services';
import { first } from 'rxjs/operators';
import { User } from '../_models';

@Component({
  selector: 'app-add-note',
  templateUrl: './add-note.component.html',
  styleUrls: ['./add-note.component.css']
})
export class AddNoteComponent implements OnInit {

  id:number
 user:User;
noteForm: FormGroup;
  loading = false;
  submitted = false;


   constructor( private formBuilder: FormBuilder,
     private router: Router,
     private userService: UserService,
         private alertService: AlertService) {
           var user=  JSON.parse(localStorage.getItem('user'));
           this.user=JSON.parse(user);    
           var stringToConvert = this.user.id;
           this.id = Number(stringToConvert);
        
           
           
           

          }

  
        ngOnInit() {
           this.noteForm = this.formBuilder.group({
               title: ['', Validators.required],
               content: ['', Validators.required],
               createdAt: ['',Validators.required],
               updatedAt: ['', [Validators.required]]
          });
      }


       get f() { return this.noteForm.controls; }

       onSubmit() {
          this.submitted = true;
         // stop here if form is invalid
         console.log('Submitting');
         if (!this.noteForm.valid) {
           console.log('Form not valid. Please check that fields are correctly filled in');
           return;
         }
      

         
        this.loading = true;
       
        this.userService.addNote(this.noteForm.value,this.id)
            .pipe(first())
            .subscribe(
                data => {
                    this.alertService.success('note successfully added', true);
                    this.router.navigate(['/home']);
                 },
                  error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
     }
    }