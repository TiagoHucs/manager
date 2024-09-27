import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { TaskService } from '../../task/task.service';

@Component({
  selector: 'app-card',
  standalone: true,
  imports: [],
  templateUrl: './card.component.html',
  styleUrl: './card.component.css'
})
export class CardComponent {

  //TODO type task
  @Input() task: any; 
  @Output() emmiter = new EventEmitter<any>()

  constructor(
    private taskService: TaskService
  ) { }

  evolue(id: number){
    this.taskService.toEvolve(id).subscribe({
      next: (response: any) => {
        alert('Task evoluida: ' + id);
        this.emmiter.emit(true);
      }
    });
  }

}
