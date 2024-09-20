import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';

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
    private fb: FormBuilder
  ) {
    
    this.taskForm = this.fb.group({
      taskName: ['Minha atividade', [Validators.required]],
      password: ['123456', [Validators.required]]
    });

  }

  onSubmit(){
    console.log(this.taskForm.getRawValue());
  }


}
