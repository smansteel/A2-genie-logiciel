import { Component, Input } from '@angular/core';
import { CompetencyRowComponent } from '../competency-row/competency-row.component';
import { Wallet } from '../../types/Wallet.interface';

@Component({
  selector: "app-competencies-table",
  standalone: true,
  imports: [CompetencyRowComponent],
  templateUrl: "./competencies-table.component.html",
  styleUrl: "./competencies-table.component.css",
})
export class CompetenciesTableComponent {
  @Input({ required: true }) wallet!: Wallet;

  constructor() {}
}
