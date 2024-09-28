import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NotifierService } from '../../../shared/notifier/notifier.service';
import { SecurityService } from '../security.service';

@Component({
  selector: 'app-sign-up',
  standalone: true,
  imports: [ReactiveFormsModule],
  providers: [],
  templateUrl: './sign-up.component.html',
  styleUrl: './sign-up.component.css'
})
export class SignUpComponent {
  registerForm: FormGroup;

  constructor(
    private service: SecurityService,
    private fb: FormBuilder,
    private router: Router,
    private notifier: NotifierService
  ) {
    
    this.registerForm = this.fb.group({
      username: ['tiagohucs', [Validators.required]],
      email: ['tiago@hucs.com', [Validators.required]],
      password: ['123456', [Validators.required]]
    });

  }

  onSubmit() {
    this.service.register(this.registerForm.getRawValue()).subscribe({
      next: (response: any) => {
        if (response.msg) {
          this.notifier.success(response.msg);
          this.router.navigate([`signin`]);
        }
      }
    });
  }

}
