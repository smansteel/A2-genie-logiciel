import { Component, Input, Output } from "@angular/core";
import { SubCompetence } from "../../types/SubCompetence.interface";
import { CompetenceLevelChipComponent } from "../competence-level-chip/competence-level-chip.component";
import { CommonModule } from "@angular/common";
import { FormsModule } from "@angular/forms";
import { WalletService } from "../../services/wallet/wallet.service";
import { EventEmitter } from "@angular/core";

@Component({
  selector: "tr[competency-row]",
  standalone: true,
  imports: [CompetenceLevelChipComponent, CommonModule, FormsModule],
  templateUrl: "./competency-row.component.html",
  styleUrl: "./competency-row.component.css",
})
export class CompetencyRowComponent {
  @Input({ required: true }) subCompetence!: SubCompetence;
  @Input({ required: true }) isEditable!: boolean;
  @Output() updateSubCompetence = new EventEmitter<SubCompetence>();
  
  public isEditEnabled: boolean = false;

  constructor() {}

  toggleEdit() {
    if (!this.isEditable) return;

    if (this.isEditEnabled) {
      this.updateSubCompetence.emit(this.subCompetence);
      this.isEditEnabled = false;
    } else {
      this.isEditEnabled = true;
    }
  }
}
