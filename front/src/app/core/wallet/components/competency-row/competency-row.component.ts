import { Component, Input } from "@angular/core";
import { SubCompetence } from "../../types/SubCompetence.interface";

@Component({
  selector: "tr[competency-row]",
  standalone: true,
  imports: [],
  templateUrl: "./competency-row.component.html",
  styleUrl: "./competency-row.component.css",
})
export class CompetencyRowComponent {
  @Input({ required: true }) subCompetence!: SubCompetence;

  constructor() {}
}
