import { Component, OnInit } from '@angular/core';
import { TeamService } from './team.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-team',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './team.component.html',
  styleUrl: './team.component.css'
})
export class TeamComponent implements OnInit {

  resource: any;

  constructor(private service: TeamService) { }

  ngOnInit(): void {
    this.getTeam();
  }

  getTeam() {
    this.service.getTeam().subscribe({
      next: (response: any) => {
        console.log(response);
        this.resource = response;
      }
    });

  }

}
