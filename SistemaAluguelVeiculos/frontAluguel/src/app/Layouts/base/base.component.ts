import { Component } from '@angular/core';
import { IconChangeComponent } from "../../Icons/icon-change/icon-change.component";
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'baseLayout',
  standalone: true,
  imports: [IconChangeComponent, RouterLinkActive, RouterLink],
  templateUrl: './base.component.html',
  styleUrl: './base.component.css'
})
export class BaseComponent {

}
