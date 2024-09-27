import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { API_URL } from '../../../app.url.dev';

@Injectable({
  providedIn: 'root'
})
export class KanbanService {

  constructor(private httpClient: HttpClient) { }

  getKanban(){
    return this.httpClient.get(`${API_URL}kanban`);
  }

}
