import { NgIf } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'iconChange',
  standalone: true,
  imports: [NgIf],
  templateUrl: './icon-change.component.html',
  styleUrl: './icon-change.component.css'
})
export class IconChangeComponent {
  @Input() icon = ""
}
