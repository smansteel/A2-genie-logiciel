import { Component } from '@angular/core';
import { CompetencyRowComponent } from '../competency-row/competency-row.component';

@Component({
  selector: 'app-competencies-table',
  standalone: true,
  imports: [CompetencyRowComponent],
  templateUrl: './competencies-table.component.html',
  styleUrl: './competencies-table.component.css'
})
export class CompetenciesTableComponent {

}
