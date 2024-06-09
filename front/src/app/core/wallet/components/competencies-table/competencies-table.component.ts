import { Component, Input, OnInit } from "@angular/core";
import { CompetencyRowComponent } from "../competency-row/competency-row.component";
import { Wallet } from "../../types/Wallet.interface";
import { UserService } from "../../../../shared/services/user/user.service";
import { Competence } from "../../types/Competence.interface";
import { SubCompetence } from "../../types/SubCompetence.interface";
import { WalletService } from "../../services/wallet/wallet.service";

@Component({
  selector: "app-competencies-table",
  standalone: true,
  imports: [CompetencyRowComponent],
  templateUrl: "./competencies-table.component.html",
  styleUrl: "./competencies-table.component.css",
})
export class CompetenciesTableComponent implements OnInit {
  @Input({ required: true }) wallet!: Wallet;
  public isEditable: boolean = false;

  constructor(
    private userService: UserService,
    private walletService: WalletService,
  ) {}

  ngOnInit(): void {
    this.isEditable = new Set(this.wallet.authorizedEditorsID).has(this.userService.get().id);
    console.log(this.isEditable);
  }

  public updateSubCompetence(competence: Competence, subCompetence: SubCompetence) {
    if (!this.isEditable) return;

    this.walletService.updateSubCompetence(competence, subCompetence);
  }
}
