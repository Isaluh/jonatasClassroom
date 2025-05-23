import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroViewComponent } from './cadastro-view.component';

describe('CadastroViewComponent', () => {
  let component: CadastroViewComponent;
  let fixture: ComponentFixture<CadastroViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CadastroViewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CadastroViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
