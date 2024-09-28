import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { TaskService } from '../../task/task.service';
import { NotifierService } from '../../../../shared/notifier/notifier.service';

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
    private taskService: TaskService,
    private notifier: NotifierService
  ) { }

  evolue(id: number){
    this.taskService.toEvolve(id).subscribe({
      next: (response: any) => {
        this.notifier.notify('success','Task evoluida: ' + id);
        this.emmiter.emit(true);
      }
    });
  }

}
