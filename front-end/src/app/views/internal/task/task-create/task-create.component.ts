import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { TaskService } from '../task.service';
import { Router } from '@angular/router';
import { NotifierService } from '../../../../shared/notifier/notifier.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-task-create',
  standalone: true,
  imports: [ReactiveFormsModule,CommonModule],
  templateUrl: './task-create.component.html',
  styleUrl: './task-create.component.css'
})
export class TaskCreateComponent {
  taskForm: FormGroup;
  resource: any;

  constructor(
    private fb: FormBuilder,
    private service: TaskService,
    private router: Router,
    private notifier: NotifierService
  ) {

    this.service.toSave().subscribe(res => {
      this.resource = res;
    })

    this.taskForm = this.fb.group({
      name: ['Estudar', [Validators.required]],
      description: ['Saber como rodar batch em uma app spring web', [Validators.required]],
      statusCode: [],
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
