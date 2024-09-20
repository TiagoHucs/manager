import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { TaskService } from '../task.service';

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
    private service: TaskService
  ) {
    
    this.taskForm = this.fb.group({
      name: ['Minha atividade', [Validators.required]],
      description: ['123456', [Validators.required]]
    });

  }

  onSubmit(){
    console.log(this.taskForm.getRawValue());
    this.service.save(this.taskForm.getRawValue()).subscribe(res => {
      alert("Task salva com sucesso!");
    })
  }


}
