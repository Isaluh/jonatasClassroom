import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InformacaoViewComponent } from './informacao-view.component';

describe('InformacaoViewComponent', () => {
  let component: InformacaoViewComponent;
  let fixture: ComponentFixture<InformacaoViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InformacaoViewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InformacaoViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
