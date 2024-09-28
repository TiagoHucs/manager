import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { TaskService } from '../task.service';
import { Router } from '@angular/router';
import { NotifierService } from '../../../../shared/notifier/notifier.service';

@Component({
  selector: 'app-task-create',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './task-create.component.html',
  styleUrl: './task-create.component.css'
})
export class TaskCreateComponent {
  taskForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private service: TaskService,
    private router: Router,
    private notifier: NotifierService
  ) {
    
    this.taskForm = this.fb.group({
      name: ['Estudar', [Validators.required]],
      description: ['Saber como rodar batch em uma app spring web', [Validators.required]],
      targetDate: ['2024-10-10']
    });

  }

  onSubmit(){
    console.log(this.taskForm.getRawValue());
    this.service.save(this.taskForm.getRawValue()).subscribe(res => {
      this.notifier.notify('success','Task salva com sucesso!');
      this.router.navigate(['app/kanban']);
    })
  }


}
