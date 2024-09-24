import { Routes } from '@angular/router';
import { SignInComponent } from './external/sign-in/sign-in.component';
import { SignUpComponent } from './external/sign-up/sign-up.component';
import { LayoutComponent } from './internal/layout/layout.component';
import { HomeComponent } from './internal/home/home.component';
import { TaskCreateComponent } from './internal/task/task-create/task-create.component';
import { KanbanComponent } from './internal/kanban/kanban.component';

export const routes: Routes = [
    { path: '', redirectTo: 'signin', pathMatch: 'prefix' },
    { path: 'signin', component: SignInComponent },
    { path: 'signup', component: SignUpComponent },
    {
        path: 'app', component: LayoutComponent,
        children: [
            { path: '', redirectTo: 'home', pathMatch: 'prefix' },
            { path: 'home', component: HomeComponent },
            { path: 'task-create', component: TaskCreateComponent },
            { path: 'kanban', component: KanbanComponent }
        ]
    }];
