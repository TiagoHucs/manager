import { Component } from '@angular/core';
import { SecurityService } from '../security.service';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-up',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './sign-up.component.html',
  styleUrl: './sign-up.component.css'
})
export class SignUpComponent {
  registerForm: FormGroup;

  constructor(
    private service: SecurityService,
    private fb: FormBuilder,
    private router: Router
  ) {
    
    this.registerForm = this.fb.group({
      username: ['tiagohucs', [Validators.required]],
      email: ['tiagohucs@gmail.com', [Validators.required]],
      password: ['123456', [Validators.required]]
    });

  }

  onSubmit() {
    this.service.register(this.registerForm.getRawValue()).subscribe({
      next: (response: any) => {
        if (response.msg) {
          alert(response.msg); 
          this.router.navigate([`signin`]);
        }
      },
      error: (err) => {
        alert(err.error.error); 
      }
    });
  }

}
