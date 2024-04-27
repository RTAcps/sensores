import { Component, HostListener, afterNextRender } from '@angular/core';
import { CardSensorComponent } from '../card-sensor/card-sensor.component';
import { UpperCasePipe } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CardSensorComponent, UpperCasePipe],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {
  public title = 'Sensores';
  public isMobileView!: boolean;

  constructor() {
    afterNextRender(() => {
      this.isMobileView = window.innerWidth <= 768;
    });
  }

  @HostListener('window:resize', ['$event'])
  public onResize(_event: any) {
    this.isMobileView = window.innerWidth <= 768;
  }
}
