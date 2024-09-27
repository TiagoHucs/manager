import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { TaskService } from '../task/task.service';
import { KanbanService } from './kanban.service';

@Component({
  selector: 'app-kanban',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './kanban.component.html',
  styleUrl: './kanban.component.css'
})
export class KanbanComponent implements OnInit {

  resource: any;

  constructor(
    private kanbanService: KanbanService,
    private taskService: TaskService
  ) { }

  ngOnInit(): void {
    this.getResource();
  }

  getResource() {
    this.kanbanService.getKanban().subscribe({
      next: (response: any) => {
        console.log(response);
        this.resource = response;
      }
    });
  }

  evolue(id: number){
    this.taskService.toEvolve(id).subscribe({
      next: (response: any) => {
        alert('Task evoluida: ' + id);
        this.getResource();
      }
    });
  }

}
