import { Component, OnInit, Inject } from '@angular/core';
import { UserService } from '../_services';
import { first } from 'rxjs/operators';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-display-note',
  templateUrl: './display-note.component.html',
  styleUrls: ['./display-note.component.css']
})
export class DisplayNoteComponent implements OnInit {
  notes:any;
  cards = [this.notes];
  id:any;
  


  constructor(private userservice:UserService,
    public dialog: MatDialog) { }


  ngOnInit() {
    this.loadAllNotes();
   }

 


  private loadAllNotes(){
      this.userservice.getAllNotes().pipe(first()).subscribe(notes => { 
      this.notes = notes; 
  });
  }

  // openDialog(): void {
  //   const dialogRef = this.dialog.open( DialogOverviewExampleDialogComponent, {
  //     width: '250px',
  //     data: {name: this.name, animal: this.animal}
  //   });

  

  // dialogRef.afterClosed().subscribe(result => {
  //   console.log('The dialog was closed');
  //   this.animal = result;
  // });

  // }


  deleteNote(id: number) {
    this.userservice.deleteNoteById(id).pipe(first()).subscribe(() => { 
        this.loadAllNotes();
    });
   }

}

