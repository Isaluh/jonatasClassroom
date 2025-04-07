import { Component } from '@angular/core';
import { MainComponent } from '../../Components/main/main.component';

@Component({
  selector: 'informacaoView',
  standalone: true,
  imports: [MainComponent],
  templateUrl: './informacao-view.component.html',
  styleUrl: './informacao-view.component.css'
})
export class InformacaoViewComponent {

}
