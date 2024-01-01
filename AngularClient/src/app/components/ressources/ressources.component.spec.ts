import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RessourcesComponent } from './ressources.component';

describe('RessourcesComponent', () => {
  let component: RessourcesComponent;
  let fixture: ComponentFixture<RessourcesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RessourcesComponent]
    });
    fixture = TestBed.createComponent(RessourcesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
