import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { API_URL } from '../../../app.url.dev'

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private httpClient: HttpClient) { }

  toSave(){
    return this.httpClient.get(`${API_URL}task/to-save`);
  }

  save(task: any){
    return this.httpClient.post(`${API_URL}task/save`, task);
  }

  toEvolve(id: number){
    return this.httpClient.get(`${API_URL}task/to-evolve/${id}`);
  }

}
