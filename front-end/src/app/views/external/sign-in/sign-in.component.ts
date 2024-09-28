import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SecurityService } from '../security.service';
import { NotifierService } from '../../../shared/notifier/notifier.service';

@Component({
  selector: 'app-sign-in',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './sign-in.component.html',
  styleUrl: './sign-in.component.css'
})
export class SignInComponent {
  loginForm: FormGroup;

  constructor(
    private service: SecurityService,
    private fb: FormBuilder,
    private router: Router,
    private notifier: NotifierService
  ) {
    
    this.loginForm = this.fb.group({
      username: ['tiagohucs', [Validators.required]],
      password: ['123456', [Validators.required]]
    });

  }

  onSubmit() {
    this.service.login(this.loginForm.getRawValue()).subscribe({
      next: (response: any) => {
        if (response.msg) {
          this.notifier.notify('success',response.msg); 
        }
        if (response.token) {
          window.localStorage.setItem('token',response.token);
          this.router.navigate([`app/home`]);
        }
      }
    });
  }

  
}
