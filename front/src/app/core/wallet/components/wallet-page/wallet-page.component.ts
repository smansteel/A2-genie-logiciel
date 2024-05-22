import { Component } from '@angular/core';
import { CompetenciesTableComponent } from '../competencies-table/competencies-table.component';

@Component({
  selector: 'app-wallet-page',
  standalone: true,
  imports: [CompetenciesTableComponent],
  templateUrl: './wallet-page.component.html',
  styleUrl: './wallet-page.component.css'
})
export class WalletPageComponent {

}
