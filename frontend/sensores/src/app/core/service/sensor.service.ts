import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SensorService {
  public apiUrl = 'https://sensores-rodrigo-5b224b3a4020.herokuapp.com/api/v1';

  constructor(private http: HttpClient) {}

  public getMachines(): Observable<any> {
    const url = `${this.apiUrl}/machines`;

    return this.http.get(url);
  }

  public getMachineById(id: number): Observable<any> {
    const url = `${this.apiUrl}/machines/${id}`;

    return this.http.get(url);
  }

  public createMachine(data: Object): Observable<any> {
    const url = `${this.apiUrl}/machines`;
    const headers = { 'Content-Type': 'application/json' };

    return this.http.post(url, data, { headers });
  }

  public updateMachine(data: Object): Observable<any> {
    const url = `${this.apiUrl}/machines`;
    const headers = { 'Content-Type': 'application/json' };

    return this.http.put(url, data, { headers });
  }

  public getSensors(): Observable<any> {
    const url = `${this.apiUrl}/sensors`;

    return this.http.get(url);
  }

  public getSensorById(id: number): Observable<any> {
    const url = `${this.apiUrl}/sensors/${id}`;

    return this.http.get(url);
  }

  public createSensor(data: Object): Observable<any> {
    const url = `${this.apiUrl}/sensors`;
    const headers = { 'Content-Type': 'application/json' };

    return this.http.post(url, data, { headers });
  }

  public updateSensor(data: Object): Observable<any> {
    const url = `${this.apiUrl}/sensors`;
    const headers = { 'Content-Type': 'application/json' };

    return this.http.put(url, data, { headers });
  }

  public getLeituras(): Observable<any> {
    const url = `${this.apiUrl}/leitura`;

    return this.http.get(url);
  }

  public getLeituraById(id: number): Observable<any> {
    const url = `${this.apiUrl}/leitura/${id}`;

    return this.http.get(url);
  }

  public createLeitura(data: Object): Observable<any> {
    const url = `${this.apiUrl}/leituras`;
    const headers = { 'Content-Type': 'application/json' };

    return this.http.post(url, data, { headers });
  }

  public updateLeitura(data: Object): Observable<any> {
    const url = `${this.apiUrl}/leitura`;
    const headers = { 'Content-Type': 'application/json' };

    return this.http.put(url, data, { headers });
  }
}
