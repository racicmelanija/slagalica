import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SlagalicaService {
  private baseUrl: string = 'http://localhost:8080/api/words'

  constructor(private http: HttpClient) { }

  getWords(letters: any): any {
    return this.http.get(this.baseUrl + "?letters=" + letters);
  }
}
