import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListagemViewComponent } from './listagem-view.component';

describe('ListagemViewComponent', () => {
  let component: ListagemViewComponent;
  let fixture: ComponentFixture<ListagemViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListagemViewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListagemViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
