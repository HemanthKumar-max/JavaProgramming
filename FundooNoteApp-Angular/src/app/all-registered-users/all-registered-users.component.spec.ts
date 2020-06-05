import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllRegisteredUsersComponent } from './all-registered-users.component';

describe('AllRegisteredUsersComponent', () => {
  let component: AllRegisteredUsersComponent;
  let fixture: ComponentFixture<AllRegisteredUsersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllRegisteredUsersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllRegisteredUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
