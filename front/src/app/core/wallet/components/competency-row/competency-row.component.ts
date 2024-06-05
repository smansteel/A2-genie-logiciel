import { Component, Input } from "@angular/core";
import { SubCompetence } from "../../types/SubCompetence.interface";
import { CompetenceLevelChipComponent } from "../competence-level-chip/competence-level-chip.component";

@Component({
  selector: "tr[competency-row]",
  standalone: true,
  imports: [CompetenceLevelChipComponent],
  templateUrl: "./competency-row.component.html",
  styleUrl: "./competency-row.component.css",
})
export class CompetencyRowComponent {
  @Input({ required: true }) subCompetence!: SubCompetence;

  constructor() {}
}
