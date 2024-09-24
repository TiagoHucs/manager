import { Component, OnInit } from '@angular/core';
import { KanbanService } from './kanban.service';

@Component({
  selector: 'app-kanban',
  standalone: true,
  imports: [],
  templateUrl: './kanban.component.html',
  styleUrl: './kanban.component.css'
})
export class KanbanComponent implements OnInit {

  resource: any;

  constructor(private service: KanbanService) { }

  ngOnInit(): void {
    this.getResource();
  }

  getResource() {
    this.service.getKanban().subscribe({
      next: (response: any) => {
        console.log(response);
        this.resource = response;
      }
    });
  }

}
