import { Component, Input } from '@angular/core';

@Component({
  selector: 'buttonsComponent',
  standalone: true,
  imports: [],
  templateUrl: './buttons.component.html',
  styleUrl: './buttons.component.css'
})
export class ButtonsComponent {
  @Input() tipoButton: string = '';
  @Input() variant: string = '';
  @Input() text: string = '';
}
