import {
  Component,
  HostListener,
  OnInit,
  afterNextRender,
} from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import Swal from 'sweetalert2';
import { SensorService } from './../../core/service/sensor.service';

@Component({
  selector: 'app-card-sensor',
  standalone: true,
  imports: [MatCardModule],
  templateUrl: './card-sensor.component.html',
  styleUrl: './card-sensor.component.scss',
})
export class CardSensorComponent implements OnInit {
  public isMobileView!: boolean;
  public errorNumber!: number;

  public machineData: any[] = [];
  public sensorData: any[] = [];
  public leitorData: any[] = [];

  constructor(private sensorService: SensorService) {
    afterNextRender(() => {
      this.isMobileView = window.innerWidth <= 768;
    });
  }

  ngOnInit(): void {
    this.showAllMachines();
    this.showAllSensors();
    this.showAllLeituras();
  }

  public showAllMachines(): void {
    this.sensorService.getMachines().subscribe({
      next: (data: any) => {
        if (data && data.content && Array.isArray(data.content)) {
          this.machineData = data.content;
        } else {
          console.error(
            'Dados retornados não contêm a estrutura esperada:',
            data
          );
        }
      },
      error: (e) => {
        const Toast = Swal.mixin({
          toast: true,
          position: 'bottom',
          showConfirmButton: false,
          timer: 3000,
          timerProgressBar: true,
          didOpen: (toast) => {
            toast.onmouseenter = Swal.stopTimer;
            toast.onmouseleave = Swal.resumeTimer;
          },
        });

        if (e.status === 400) {
          this.errorNumber = e.status;

          Toast.fire({
            icon: 'error',
            title: 'Houve um erro inesperado!',
          });
        } else if (e.status === 401) {
          this.errorNumber = e.status;
          Toast.fire({
            icon: 'error',
            title: 'Você não tem autorização para acessar!',
          });
        } else if (e.status === 404) {
          this.errorNumber = e.status;
          Toast.fire({
            icon: 'error',
            title: 'Não foi possível encontrar o filme!',
          });
        } else if (e.status === 500) {
          this.errorNumber = e.status;
          Toast.fire({
            icon: 'error',
            title: 'O servidor apresentou um problema!',
          });
        }
      },
    });
  }

  public showAllSensors(): void {
    this.sensorService.getSensors().subscribe({
      next: (data: any) => {
        if (data && data.content && Array.isArray(data.content)) {
          this.sensorData = data.content;
        } else {
          console.error(
            'Dados retornados não contêm a estrutura esperada:',
            data
          );
        }
      },
      error: (e) => {
        const Toast = Swal.mixin({
          toast: true,
          position: 'bottom',
          showConfirmButton: false,
          timer: 3000,
          timerProgressBar: true,
          didOpen: (toast) => {
            toast.onmouseenter = Swal.stopTimer;
            toast.onmouseleave = Swal.resumeTimer;
          },
        });

        if (e.status === 400) {
          this.errorNumber = e.status;

          Toast.fire({
            icon: 'error',
            title: 'Houve um erro inesperado!',
          });
        } else if (e.status === 401) {
          this.errorNumber = e.status;
          Toast.fire({
            icon: 'error',
            title: 'Você não tem autorização para acessar!',
          });
        } else if (e.status === 404) {
          this.errorNumber = e.status;
          Toast.fire({
            icon: 'error',
            title: 'Não foi possível encontrar o filme!',
          });
        } else if (e.status === 500) {
          this.errorNumber = e.status;
          Toast.fire({
            icon: 'error',
            title: 'O servidor apresentou um problema!',
          });
        }
      },
    });
  }

  public showAllLeituras(): void {
    this.sensorService.getLeituras().subscribe({
      next: (data: any) => {
        if (data && data.content && Array.isArray(data.content)) {
          this.leitorData = data.content;
          console.log(this.leitorData);
        } else {
          console.error(
            'Dados retornados não contêm a estrutura esperada:',
            data
          );
        }
      },
      error: (e) => {
        const Toast = Swal.mixin({
          toast: true,
          position: 'bottom',
          showConfirmButton: false,
          timer: 3000,
          timerProgressBar: true,
          didOpen: (toast) => {
            toast.onmouseenter = Swal.stopTimer;
            toast.onmouseleave = Swal.resumeTimer;
          },
        });

        if (e.status === 400) {
          this.errorNumber = e.status;

          Toast.fire({
            icon: 'error',
            title: 'Houve um erro inesperado!',
          });
        } else if (e.status === 401) {
          this.errorNumber = e.status;
          Toast.fire({
            icon: 'error',
            title: 'Você não tem autorização para acessar!',
          });
        } else if (e.status === 404) {
          this.errorNumber = e.status;
          Toast.fire({
            icon: 'error',
            title: 'Não foi possível encontrar o filme!',
          });
        } else if (e.status === 500) {
          this.errorNumber = e.status;
          Toast.fire({
            icon: 'error',
            title: 'O servidor apresentou um problema!',
          });
        }
      },
    });
  }

  @HostListener('window:resize', ['$event'])
  public onResize(_event: any) {
    this.isMobileView = window.innerWidth <= 768;
  }

  public dataFormat(timestamp: number): string {
    const date = new Date(timestamp);
    const year = date.getFullYear();
    const month = date.getMonth() + 1;
    const day = date.getDate();
    return `${day}/${month}/${year}`;
  }
}
