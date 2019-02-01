import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailVehiculeComponent } from './detail-vehicule.component';

describe('DetailVehiculeComponent', () => {
  let component: DetailVehiculeComponent;
  let fixture: ComponentFixture<DetailVehiculeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailVehiculeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailVehiculeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
